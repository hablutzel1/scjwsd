
package ch02.tc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Service", targetNamespace = "http://tempConvertURI.org/", wsdlLocation = "file:/D:/Users/jhe/Desktop/SCDJWS/ch02/wsimportproject/out/foo.wsdl")
public class Service
    extends javax.xml.ws.Service
{

    private final static URL SERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ch02.tc.Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ch02.tc.Service.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/Users/jhe/Desktop/SCDJWS/ch02/wsimportproject/out/foo.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/Users/jhe/Desktop/SCDJWS/ch02/wsimportproject/out/foo.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SERVICE_WSDL_LOCATION = url;
    }

    public Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service() {
        super(SERVICE_WSDL_LOCATION, new QName("http://tempConvertURI.org/", "Service"));
    }

    /**
     * 
     * @return
     *     returns TempService
     */
    @WebEndpoint(name = "TempService")
    public TempService getServiceSoap() {
        return super.getPort(new QName("http://tempConvertURI.org/", "TempService"), TempService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TempService
     */
    @WebEndpoint(name = "TempService")
    public TempService getServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempConvertURI.org/", "TempService"), TempService.class, features);
    }

}