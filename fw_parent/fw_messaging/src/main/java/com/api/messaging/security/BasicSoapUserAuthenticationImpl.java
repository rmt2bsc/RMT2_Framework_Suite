package com.api.messaging.security;

import java.io.InputStream;
import java.util.Date;

import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;

import com.SystemException;
import com.api.config.old.ProviderConfig;
import com.api.messaging.MessageException;
import com.api.messaging.webservice.soap.client.SoapClientWrapper;
import com.api.security.authentication.web.AuthenticationException;
import com.api.security.authentication.web.AuthorizationException;
import com.api.security.authentication.web.LogoutException;
import com.api.util.RMT2Date;
import com.api.util.RMT2File;
import com.api.util.RMT2String;
import com.api.web.security.AbstractUserAuthenticationTemplateImpl;
import com.api.web.security.RMT2SecurityToken;
import com.api.web.security.RMT2SessionBean;
import com.api.web.security.SessionBeanManager;
import com.api.web.security.UserAuthenticationFactory;
import com.api.web.security.UserAuthenticator;

/**
 * SOAP implementation of interface,
 * {@link com.api.security.authentication.web.UserAuthenticator
 * UserAuthenticator}
 * <p>
 * 
 * @author rterrell
 * 
 */
public class BasicSoapUserAuthenticationImpl extends
        AbstractUserAuthenticationTemplateImpl implements UserAuthenticator {

    private static Logger logger = Logger.getLogger("CommonSoapImpl");

    private String loginXmlTemplate;

    private SoapClientWrapper client;

    /**
     * 
     */
    public BasicSoapUserAuthenticationImpl() {
        this.client = new SoapClientWrapper();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.api.security.authentication.web.UserAuthenticator#authenticate()
     */
    public RMT2SecurityToken authenticate() throws AuthenticationException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.UserAuthenticator#authenticate(java
     * .lang .String, java.lang.String)
     */
    public RMT2SecurityToken authenticate(String loginId, String password)
            throws AuthenticationException {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.UserAuthenticator#authenticate(java
     * .lang .String, java.lang.String, java.lang.String, java.lang.String)
     */
    public RMT2SecurityToken authenticate(String loginId, String password,
            String appCode, String sessionId) throws AuthenticationException,
            AuthorizationException {
        this.process(loginId, password, appCode, sessionId);
        return (RMT2SecurityToken) this.sessionToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.AbstractUserAuthenticationTemplateImpl
     * #initialize()
     */
    @Override
    protected void initialize() throws AuthenticationException {
        // Get the XML login message here
        this.loginXmlTemplate = this.loadXmlMessage("xml/login.xml");
        return;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.AbstractUserAuthenticationTemplateImpl
     * #verifyUser(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    protected RMT2SecurityToken verifyUser(String loginId, String password,
            String appCode, String sessionId) throws AuthenticationException {
        // Replace XML place holders with input parameters
        String delivDate = RMT2Date.formatDate(new Date(),
                "MM/dd/yyyy hh:mm:ss");
        String xml = this.loginXmlTemplate;
        xml = RMT2String.replace(xml, delivDate, "$delivery_date$");
        xml = RMT2String.replace(xml, loginId, "$user_id$");
        xml = RMT2String.replace(xml, loginId, "$uid$");
        xml = RMT2String.replace(xml, password, "$pw$");
        xml = RMT2String.replace(xml, appCode, "$app_code$");
        xml = RMT2String.replace(xml, sessionId, "$session_id$");

        try {
            SOAPMessage resp = this.client.callSoap(xml);
            if (client.isSoapError(resp)) {
                String errMsg = this.client.getSoapErrorMessage(resp);
                logger.error(errMsg);
                throw new AuthenticationException(errMsg);
            }
            String result = this.client.getSoapResponsePayloadString();
            logger.info(result);

            SessionBeanManager sm = SessionBeanManager
                    .getInstance(this.request);
            RMT2SecurityToken token = new RMT2SecurityToken();
            RMT2SessionBean session = sm.buildSessionBean(result,
                    "//RS_authentication_login/session_token",
                    "//RS_authentication_login/session_token/roles");
            token.setSession(session);
            token.setToken(result);
            return token;
        } catch (MessageException e) {
            this.msg = "Accounting Authentication Error regarding server-side messaging";
            throw new AuthenticationException(this.msg, e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.AbstractUserAuthenticationTemplateImpl
     * #cleanUp()
     */
    @Override
    protected void cleanUp() throws AuthenticationException {
        this.client.close();
        this.client = null;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.UserAuthenticator#logout(java.lang
     * .String , java.lang.String)
     */
    public int logout(String loginId, String sessionId) throws LogoutException {
        // Replace XML place holders with input parameters
        String xml = this.loadXmlMessage("xml/logout.xml");
        String delivDate = RMT2Date.formatDate(new Date(),
                "MM/dd/yyyy hh:mm:ss");
        String deltaXml = RMT2String.replace(xml, delivDate, "$delivery_date$");
        deltaXml = RMT2String.replace(deltaXml, loginId, "$user_id$");
        deltaXml = RMT2String.replace(deltaXml, loginId, "$uid$");
        deltaXml = RMT2String.replace(deltaXml, sessionId, "$session_id$");

        // Invalidate user's session
        this.removeSession();

        // Log User out of the system
        try {
            SOAPMessage resp = this.client.callSoap(deltaXml);
            if (client.isSoapError(resp)) {
                String errMsg = this.client.getSoapErrorMessage(resp);
                logger.error(errMsg);
                throw new LogoutException(errMsg);
            }
            String result = this.client.getSoapResponsePayloadString();
            logger.info(result);
            RMT2SecurityToken token = new RMT2SecurityToken();
            token.setToken(result);
            return 1;
        } catch (MessageException e) {
            this.msg = "Accounting Authentication Error regarding server-side messaging";
            logger.error(this.msg);
            throw new LogoutException(this.msg, e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.api.security.authentication.web.UserAuthenticator#
     * checkAuthenticationStatus (java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public RMT2SecurityToken checkAuthenticationStatus(String loginId,
            String appCode, String sessionId) throws AuthenticationException {
        // Replace XML place holders with input parameters
        String xml = this.loadXmlMessage("xml/user_auth_check.xml");
        String delivDate = RMT2Date.formatDate(new Date(),
                "MM/dd/yyyy hh:mm:ss");
        String deltaXml = RMT2String.replace(xml, delivDate, "$delivery_date$");
        deltaXml = RMT2String.replace(deltaXml, loginId, "$user_id$");
        deltaXml = RMT2String.replace(deltaXml, loginId, "$uid$");
        deltaXml = RMT2String.replace(deltaXml, appCode, "$app_code$");
        deltaXml = RMT2String.replace(deltaXml, sessionId, "$session_id$");

        try {
            SOAPMessage resp = this.client.callSoap(deltaXml);
            if (client.isSoapError(resp)) {
                String errMsg = this.client.getSoapErrorMessage(resp);
                logger.error(errMsg);
                return null;
            }
            String result = this.client.getSoapResponsePayloadString();
            logger.info(result);
            RMT2SecurityToken token = new RMT2SecurityToken();
            RMT2SessionBean session;
            try {
                if (this.request != null) {
                    session = UserAuthenticationFactory.getSessionBeanInstance(
                            loginId, appCode, this.request,
                            this.request.getSession(false));
                }
                else {
                    session = UserAuthenticationFactory.getSessionBeanInstance(
                            loginId, appCode);
                    session.setSessionId(sessionId);
                }
                token.setSession(session);
            } catch (AuthenticationException e) {
                this.msg = "Accounting Authentication Error obtaining the RMT2SessionBean instance";
                logger.error(this.msg);
                throw new SystemException(this.msg, e);
            }
            // token.setSession(sessionBean);
            token.setToken(result);
            return token;
        } catch (MessageException e) {
            this.msg = "Accounting Authentication Error regarding server-side messaging";
            logger.error(this.msg);
            throw new AuthenticationException(this.msg, e);
        }
    }

    protected String loadXmlMessage(String file) {
        String data = null;
        InputStream is = RMT2File.getFileInputStream(file);
        if (is != null) {
            data = RMT2File.getStreamStringData(is);
        }
        return data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.api.security.authentication.web.UserAuthenticator#setProvider(com.api
     * .messaging.ProviderConfig)
     */
    public void setProvider(ProviderConfig provider) {
        super.setProvider(provider);
        this.client.setConfig(provider);
        return;
    }

}
