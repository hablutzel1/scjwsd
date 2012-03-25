
package ch03.mctx.client;

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
@WebServiceClient(name = "EchoService", targetNamespace = "http://mctx.ch03/", wsdlLocation = "http://localhost:9876/echo?wsdl")
public class EchoService
    extends Service
{

    private final static URL ECHOSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ch03.mctx.client.EchoService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ch03.mctx.client.EchoService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:9876/echo?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9876/echo?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        ECHOSERVICE_WSDL_LOCATION = url;
    }

    public EchoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EchoService() {
        super(ECHOSERVICE_WSDL_LOCATION, new QName("http://mctx.ch03/", "EchoService"));
    }

    /**
     * 
     * @return
     *     returns Echo
     */
    @WebEndpoint(name = "EchoPort")
    public Echo getEchoPort() {
        return super.getPort(new QName("http://mctx.ch03/", "EchoPort"), Echo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Echo
     */
    @WebEndpoint(name = "EchoPort")
    public Echo getEchoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://mctx.ch03/", "EchoPort"), Echo.class, features);
    }

}