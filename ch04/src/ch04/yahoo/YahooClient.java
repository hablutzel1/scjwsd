package ch04.yahoo;

import java.net.URI;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.Dispatch;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMResult;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.ws.handler.MessageContext;

import ch04.dispatch.NSResolver;
import org.w3c.dom.NodeList;



// A client against the Yahoo! RESTful news summary service.
class YahooClient {
    public static void main(String[ ] args) throws Exception {
//        if (args.length < 1) {
//            System.err.println("YahooClient <your AppID>");
//            return;
//        }
//        String app_id = "appid=zlyD1lvV34Ghx24OY6vpUOSOUczD2woxvT3PU8vLmO3F7VM75yPY0laQ1Wz6koq1bw" ;
        
        // Create a name for a service port.
//        URI ns_URI = new URI("urn:yahoo:yn");
        QName serviceName = new QName("yahoo");
        QName portName = new QName("yahoo_port");

        // Now create a service proxy
        Service s = Service.create(serviceName);

//        String qs = app_id + "&type=all&results=10&" +
//                    "sort=date&language=en&query=quantum mechanics";

        //http://www.thomas-bayer.com/sqlrest/CUSTOMER/18/

        // Endpoint address
        URI address = new URI("http",                  // HTTP scheme
                              null,                    // user info
                              "www.thomas-bayer.com",  // host
                              80,                      // port
                              "/sqlrest/CUSTOMER/18/", // path
                              null,                      // query string
                              null);                   // fragment

        // Add the appropriate port
        s.addPort(portName, HTTPBinding.HTTP_BINDING, address.toString());

        // From the service, generate a Dispatcher
        Dispatch<Source> d =
            s.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);
        Map<String, Object> request_context = d.getRequestContext();
        request_context.put(MessageContext.HTTP_REQUEST_METHOD, "GET");
//        Source result = d.invoke(null);
        // Invoke


        Service yahooService = Service.create(new QName("yahooService"));
        QName yahooPort = new QName("YahooPort");
        yahooService.addPort(yahooPort, HTTPBinding.HTTP_BINDING, address.toString());
        Dispatch<Source> dispatch = yahooService.createDispatch(yahooPort, Source.class, Service.Mode.PAYLOAD);
        Map<String, Object> requestContext = dispatch.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "GET");
        Source invoke = dispatch.invoke(null);


        DOMResult dom_result = new DOMResult();
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.transform(invoke, dom_result);

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();

        System.out.println("Full response: " + xp.evaluate("//*", dom_result.getNode(), XPathConstants.STRING));
//        xp.setNamespaceContext(new NSResolver("yn", ns_URI.toString()));
        String resultList = (String)
            xp.evaluate("/CUSTOMER/FIRSTNAME",
                        dom_result.getNode(),
                        XPathConstants.STRING);

        System.out.println(resultList);
//        int len = resultList.getLength();
//        for (int i = 1; i <= len; i++) {
//            String title =
//                xp.evaluate("/yn:ResultSet/yn:Result(" + i + ")/yn:Title",
//                            dom_result.getNode());
//            String click =
//                xp.evaluate("/yn:ResultSet/yn:Result(" + i + ")/yn:ClickUrl",
//                            dom_result.getNode());
//            System.out.printf("(%d) %s (%s)\n", i, title, click);
//        }
    }
}   

			