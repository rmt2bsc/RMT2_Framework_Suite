//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 08:13:01 PM CDT 
//


package org.rmt2.jaxb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.RMT2Base;


/**
 * <p>Java class for gl_detail_group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gl_detail_group">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account_types" type="{}gl_accounttype_type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="account_categories" type="{}gl_accountcatg_type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accounts" type="{}gl_account_type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gl_detail_group", propOrder = {
    "accountTypes",
    "accountCategories",
    "accounts"
})
public class GlDetailGroup
    extends RMT2Base
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "account_types", nillable = true)
    protected List<GlAccounttypeType> accountTypes;
    @XmlElement(name = "account_categories", nillable = true)
    protected List<GlAccountcatgType> accountCategories;
    @XmlElement(nillable = true)
    protected List<GlAccountType> accounts;

    /**
     * Gets the value of the accountTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlAccounttypeType }
     * 
     * 
     */
    public List<GlAccounttypeType> getAccountTypes() {
        if (accountTypes == null) {
            accountTypes = new ArrayList<GlAccounttypeType>();
        }
        return this.accountTypes;
    }

    /**
     * Gets the value of the accountCategories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountCategories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlAccountcatgType }
     * 
     * 
     */
    public List<GlAccountcatgType> getAccountCategories() {
        if (accountCategories == null) {
            accountCategories = new ArrayList<GlAccountcatgType>();
        }
        return this.accountCategories;
    }

    /**
     * Gets the value of the accounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlAccountType }
     * 
     * 
     */
    public List<GlAccountType> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<GlAccountType>();
        }
        return this.accounts;
    }

}