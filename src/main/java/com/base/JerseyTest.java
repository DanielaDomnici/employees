package com.base;

import com.sun.jersey.spi.service.ServiceFinder;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.WebAppDescriptor.Builder;
import com.sun.jersey.test.framework.spi.client.ClientFactory;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;
import org.junit.After;
import org.junit.Before;

/**
 * Created by daniela.domnici on 09/11/15.
 * Get the JerseyTest class and customize it.
 * This class is a base class used for the tests that runs on the grizzly server. (The tests will inherit this class.)
 */

public abstract class JerseyTest {
    private static Class<? extends TestContainerFactory> defaultTestContainerFactoryClass;
    private TestContainerFactory testContainerFactory;
    private ClientFactory clientFactory;
    private final TestContainer tc;
    private final Client client;
    private static final String DEFAULT_TEST_CONTAINER_FACTORY_CLASS_NAME = "com.sun.jersey.test.framework.spi.container.grizzly2.web.GrizzlyWebTestContainerFactory";

    public JerseyTest() throws TestContainerException {
        AppDescriptor ad = this.configure();
        this.tc = this.getContainer(ad, this.getTestContainerFactory());
        this.client = this.getClient(this.tc, ad);
    }

    public JerseyTest(TestContainerFactory testContainerFactory) {
        this.setTestContainerFactory(testContainerFactory);
        AppDescriptor ad = this.configure();
        this.tc = this.getContainer(ad, this.getTestContainerFactory());
        this.client = this.getClient(this.tc, ad);
    }

    protected AppDescriptor configure() {
        throw new UnsupportedOperationException("The configure method must be implemented by the extending class");
    }

    public JerseyTest(AppDescriptor ad) throws TestContainerException {
        this.tc = this.getContainer(ad, this.getTestContainerFactory());
        this.client = this.getClient(this.tc, ad);
    }

    public JerseyTest(String... packages) throws TestContainerException {
        this((AppDescriptor)(new Builder(packages)).build());
    }

    protected void setTestContainerFactory(TestContainerFactory testContainerFactory) {
        this.testContainerFactory = testContainerFactory;
    }

    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        if(this.testContainerFactory == null) {
            this.testContainerFactory = getDefaultTestContainerFactory();
        }

        return this.testContainerFactory;
    }

    public WebResource resource() {
        return this.client.resource(this.tc.getBaseUri());
    }

    public Client client() {
        return this.client;
    }

    @Before
    public void setUp() throws Exception {
        this.tc.start();
    }

    @After
    public void tearDown() throws Exception {
        this.tc.stop();
    }

    private TestContainer getContainer(AppDescriptor ad, TestContainerFactory tcf) {
        if(ad == null) {
            throw new IllegalArgumentException("The application descriptor cannot be null");
        } else {
            Class adType = tcf.supports();
            if(adType == LowLevelAppDescriptor.class && ad.getClass() == WebAppDescriptor.class) {
                ad = LowLevelAppDescriptor.transform((WebAppDescriptor)ad);
            } else if(adType != ad.getClass()) {
                throw new TestContainerException("The application descriptor type, " + ad.getClass() + ", is not supported by the test container factory, " + tcf);
            }

            return tcf.create(this.getBaseURI(), (AppDescriptor)ad);
        }
    }

    private static TestContainerFactory getDefaultTestContainerFactory() {
        if(defaultTestContainerFactoryClass == null) {
            if(System.getProperty("jersey.test.containerFactory") == null && System.getProperty("test.containerFactory") == null) {
                TestContainerFactory[] var3 = (TestContainerFactory[]) ServiceFinder.find(TestContainerFactory.class).toArray();
                if(var3.length >= 1) {
                    for(int var4 = 0; var4 < var3.length; ++var4) {
                        if(var3[var4].getClass().getName().equals("com.sun.jersey.test.framework.spi.container.grizzly2.web.GrizzlyWebTestContainerFactory")) {
                            Logger.getLogger(TestContainerFactory.class.getName()).config("Found multiple TestContainerFactory implementations, using default " + var3[var4].getClass().getName());
                            defaultTestContainerFactoryClass = var3[var4].getClass();
                            return var3[var4];
                        }
                    }

                    if(var3.length != 1) {
                        Logger.getLogger(TestContainerFactory.class.getName()).warning("Found multiple TestContainerFactory implementations, using " + var3[0].getClass().getName());
                    }

                    defaultTestContainerFactoryClass = var3[0].getClass();
                    return var3[0];
                }
            } else {
                String ex = System.getProperty("jersey.test.containerFactory");
                final String tcfName = ex != null?ex:System.getProperty("test.containerFactory", "com.sun.jersey.test.framework.spi.container.grizzly2.web.GrizzlyWebTestContainerFactory");
                defaultTestContainerFactoryClass = (Class) AccessController.doPrivileged(new PrivilegedAction() {
                    public Class<? extends TestContainerFactory> run() {
                        try {
                            return Class.forName(tcfName).asSubclass(TestContainerFactory.class);
                        } catch (ClassNotFoundException var2) {
                            throw new TestContainerException("The default test container factory class name, " + tcfName + ", cannot be loaded", var2);
                        } catch (ClassCastException var3) {
                            throw new TestContainerException("The default test container factory class, " + tcfName + ", is not an instance of TestContainerFactory", var3);
                        }
                    }
                });
            }
        }

        try {
            return (TestContainerFactory)defaultTestContainerFactoryClass.newInstance();
        } catch (Exception var2) {
            throw new TestContainerException("The default test container factory, " + defaultTestContainerFactoryClass + ", could not be instantiated", var2);
        }
    }

    protected Client getClient(TestContainer tc, AppDescriptor ad) {
        Client c = tc.getClient();
        if(c != null) {
            return c;
        } else {
            c = this.getClientFactory().create(ad.getClientConfig());
            boolean enableLogging = System.getProperty("enableLogging") != null;
            if(enableLogging) {
                c.addFilter(new LoggingFilter());
            }

            return c;
        }
    }

    protected ClientFactory getClientFactory() {
        if(this.clientFactory == null) {
            this.clientFactory = getDefaultClientFactory();
        }

        return this.clientFactory;
    }

    private static ClientFactory getDefaultClientFactory() {
        return new ClientFactory() {
            public Client create(ClientConfig cc) {
                return Client.create(cc);
            }
        };
    }

    protected void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    protected URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(this.getPort(8080)).build(new Object[0]);
    }

    protected int getPort(int defaultPort) {
        String port = System.getProperty("jersey.test.port");
        if(null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException var4) {
                throw new TestContainerException("jersey.test.port with a value of \"" + port + "\" is not a valid integer.", var4);
            }
        } else {
            port = System.getProperty("JERSEY_HTTP_PORT");
            if(null != port) {
                try {
                    return Integer.parseInt(port);
                } catch (NumberFormatException var5) {
                    throw new TestContainerException("JERSEY_HTTP_PORT with a value of \"" + port + "\" is not a valid integer.", var5);
                }
            } else {
                return defaultPort;
            }
        }
    }
}
