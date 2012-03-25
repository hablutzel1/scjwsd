
package awsClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "AWSECommerceService", targetNamespace = "http://webservices.amazon.com/AWSECommerceService/2011-08-01", wsdlLocation = "http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl")
public class AWSECommerceService
    extends Service
{

    private final static URL AWSECOMMERCESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(awsClient.AWSECommerceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = awsClient.AWSECommerceService.class.getResource(".");
            url = new URL(baseUrl, "http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://ecs.amazonaws.com/AWSECommerceService/AWSECommerceService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        AWSECOMMERCESERVICE_WSDL_LOCATION = url;
    }

    public AWSECommerceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AWSECommerceService() {
        super(AWSECOMMERCESERVICE_WSDL_LOCATION, new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceService"));
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePort")
    public AWSECommerceServicePortType getAWSECommerceServicePort() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePort"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePort")
    public AWSECommerceServicePortType getAWSECommerceServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePort"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortCA")
    public AWSECommerceServicePortType getAWSECommerceServicePortCA() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortCA"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortCA")
    public AWSECommerceServicePortType getAWSECommerceServicePortCA(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortCA"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortCN")
    public AWSECommerceServicePortType getAWSECommerceServicePortCN() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortCN"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortCN")
    public AWSECommerceServicePortType getAWSECommerceServicePortCN(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortCN"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortDE")
    public AWSECommerceServicePortType getAWSECommerceServicePortDE() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortDE"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortDE")
    public AWSECommerceServicePortType getAWSECommerceServicePortDE(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortDE"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortFR")
    public AWSECommerceServicePortType getAWSECommerceServicePortFR() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortFR"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortFR")
    public AWSECommerceServicePortType getAWSECommerceServicePortFR(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortFR"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortIT")
    public AWSECommerceServicePortType getAWSECommerceServicePortIT() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortIT"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortIT")
    public AWSECommerceServicePortType getAWSECommerceServicePortIT(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortIT"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortJP")
    public AWSECommerceServicePortType getAWSECommerceServicePortJP() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortJP"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortJP")
    public AWSECommerceServicePortType getAWSECommerceServicePortJP(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortJP"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortUK")
    public AWSECommerceServicePortType getAWSECommerceServicePortUK() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortUK"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortUK")
    public AWSECommerceServicePortType getAWSECommerceServicePortUK(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortUK"), AWSECommerceServicePortType.class, features);
    }

    /**
     * 
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortUS")
    public AWSECommerceServicePortType getAWSECommerceServicePortUS() {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortUS"), AWSECommerceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AWSECommerceServicePortType
     */
    @WebEndpoint(name = "AWSECommerceServicePortUS")
    public AWSECommerceServicePortType getAWSECommerceServicePortUS(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.amazon.com/AWSECommerceService/2011-08-01", "AWSECommerceServicePortUS"), AWSECommerceServicePortType.class, features);
    }

}
