package ch04.dispatch;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.Dispatch;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.ws.handler.MessageContext;

import org.w3c.dom.NodeList;
import ch04.dispatch.NSResolver;

class DispatchClient {
    public static void main(String[] args) throws Exception {
        new DispatchClient().setup_and_test();
    }

    private void setup_and_test() {
        // Create identifying names for service and port.
        URI ns_URI = null;
        try {
            ns_URI = new URI("urn:fib");
        } catch (URISyntaxException e) {
            System.err.println(e);
        }

        QName service_name = new QName("rcService", ns_URI.toString());
        QName port = new QName("rcPort", ns_URI.toString());
        String endpoint = "http://localhost:8889/rp";

        // Now create a service proxy or dispatcher.
        Service service = Service.create(service_name);
        service.addPort(port, HTTPBinding.HTTP_BINDING, endpoint);
        Dispatch<Source> dispatch =
                service.createDispatch(port, Source.class, Service.Mode.PAYLOAD);

        // Send some requests.
        String xml_start = "<fib:request xmlns:fib = 'urn:fib'>";
        String xml_end = "</fib:request>";

        // To begin, a POST to create some Fibonacci numbers.
        List<Integer>   nums = new ArrayList<Integer>();
        for (int i = 0; i < 12; i++) nums.add(i + 1);
        String xml = xml_start + nums.toString() + xml_end;
        invoke(dispatch, "POST", ns_URI.toString(), xml);

        // GET request to test whether the POST worked.
        invoke(dispatch, "GET", ns_URI.toString(), null);

        // DELETE request to remove the list
//        invoke(dispatch, "DELETE", ns_URI.toString(), null);

        // GET to test whether the DELETE worked.
//        invoke(dispatch, "GET", ns_URI.toString(), null);

        // POST to repopulate and a final GET to confirm
        nums = new ArrayList<Integer>();
        for (int i = 0; i < 24; i++)
            nums.add(i + 1);

        xml = xml_start + nums.toString() + xml_end;
        invoke(dispatch, "POST", ns_URI.toString(), xml);
        invoke(dispatch, "GET", ns_URI.toString(), null);
    }

    private void invoke(Dispatch<Source> dispatch,
                        String verb,
                        String uri,
                        Object data) {
        Map<String, Object> request_context = dispatch.getRequestContext();
        request_context.put(MessageContext.HTTP_REQUEST_METHOD, verb);

        System.out.println("Request: " + data);

        // Invoke
        StreamSource source = null;
        if (data != null) source = make_stream_source(data.toString());
        Source result = dispatch.invoke(source);
        display_result(result, uri);
    }

    private void display_result(Source result, String uri) {
        DOMResult dom_result = new DOMResult();
        try {
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.transform(result, dom_result);

            XPathFactory xpf = XPathFactory.newInstance();
            XPath xp = xpf.newXPath();
            xp.setNamespaceContext(new NSResolver("fib", uri));
            String result_string =
                    xp.evaluate("/fib:response", dom_result.getNode());
            System.out.println(result_string);
        } catch (TransformerConfigurationException e) {
            System.err.println(e);
        } catch (TransformerException e) {
            System.err.println(e);
        } catch (XPathExpressionException e) {
            System.err.println(e);
        }
    }

    private StreamSource make_stream_source(String msg) {
        ByteArrayInputStream stream = new ByteArrayInputStream(msg.getBytes());
        return new StreamSource(stream);
    }
}

