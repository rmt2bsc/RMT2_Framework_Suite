package testcases;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.RMT2Base;
import com.api.config.AppPropertyPool;
import com.api.config.ConfigConstants;
import com.api.config.ConfigException;
import com.api.config.MessagingSysConfigController;
import com.api.config.old.AbstractSystemConfigImpl;
import com.api.config.old.ConfigAttributes;
import com.api.config.old.CoreSysConfigFactory;
import com.api.config.old.ResourceConfigurator;
import com.api.messaging.webservice.ServiceRegistry;
import com.api.messaging.webservice.ServiceRegistryFactory;
import com.util.RMT2BeanUtility;
import com.util.RMT2File;

/**
 * Uses local resource to perform the initialization of the application by
 * loading system environment variables and application properties, establishing
 * the JDBC connection pool, and setting the the application's logger.
 * <p>
 * User-defined JVM and application properties are loaded into memory from local
 * resources.
 * 
 * @author Roy Terrell
 * 
 */
public class StandAloneApiConfigTestDelegate extends RMT2Base {

    private static final String WEB_SERVICE_LOADER_FACTORY_LDAP = "ldap";

    private static Logger logger;

    private String propFile;

    private String appName;

    private String loaderType;

    private String baseDn;

    private String mapperClass;

    /**
     * 
     */
    public StandAloneApiConfigTestDelegate() {
        this.appName = "Unknown Application";
    }

    public StandAloneApiConfigTestDelegate(String configFile) {
        this();
        this.propFile = configFile;
        return;
    }

    public void doConfig() throws ApiTestException {
        // Setup Logging environment
        String logPath = "config.log4j";
        Properties props = RMT2File.loadPropertiesFromClasspath(logPath);
        PropertyConfigurator.configure(props);
        logger = Logger.getLogger(MessagingSysConfigController.class);
        logger.info("\n\nBegin Application Configuration for " + appName
                + "...");

        // Load system and application properties for this web app being
        // initialized.
        logger.info("Loading system/application configuration...");
        try {
            this.setupProperties();
        } catch (ConfigException e) {
            throw new ApiTestException(e);
        }
        // Load web service registry
        logger.info("Loading web service registry for application, " + appName);
        if (loaderType == null) {
            throw new ApiTestException(
                    "Initialization parameter, \"ServiceLoaderFactory\", was not setup for System Configuration Servlet");
        }
        RMT2BeanUtility b = new RMT2BeanUtility();
        ServiceRegistryFactory f = (ServiceRegistryFactory) b.createBean(System
                .getProperty(ConfigConstants.PROPNAME_SERVICE_REGISTRY));
        ServiceRegistry r = null;
        if (loaderType.equalsIgnoreCase(WEB_SERVICE_LOADER_FACTORY_LDAP)) {
            r = f.getLdapServiceRegistryManager(baseDn, mapperClass);
        }
        if (r != null) {
            r.loadServices();
        }

        // Perform custom setup logic at the descendent level
        this.doCustomSetup();

        // Configuration process complete...
        msg = "Initialization of application, "
                + AppPropertyPool
                        .getProperty(ConfigConstants.PROPNAME_APP_NAME)
                + ", in the " + AppPropertyPool.getEnvirionment()
                + " completed.";
        logger.info(msg);
    }

    private void setupProperties() throws ConfigException {
        // TODO: Create a more dynamic call to obtain system configurator. For
        // example, invoke SystemConfiguratorFactory.getSystemConfigurator()
        // which will obtain and instantiate the class specified in the
        // container's web.xml.
        ResourceConfigurator cfg = CoreSysConfigFactory
                .getPropertiesSystemConfigurator(this.propFile);
        ((AbstractSystemConfigImpl) cfg).setAppName(appName);
        if (!AppPropertyPool.isAppConfigured()) {
            cfg.doSetup();
            cfg.doPostSetup(null);
            ConfigAttributes appConfig = (ConfigAttributes) cfg;
            AppPropertyPool pool = AppPropertyPool.getInstance();
            pool.addProperties(appConfig);
        }
        this.appName = System.getProperty("appName");
        this.loaderType = System.getProperty("loaderType");
        this.baseDn = System.getProperty("baseDn");
        this.mapperClass = System.getProperty("mapperClass");
    }

    /**
     * Stub method for creating custom setup procedure.
     */
    protected void doCustomSetup() {
        return;
    }
}
