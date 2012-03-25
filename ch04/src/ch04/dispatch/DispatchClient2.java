package ch04.dispatch;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 26/02/12
 * Time: 01:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class DispatchClient2 {

    public static void main(String[] args) throws Exception {
        String soap_request =
                "<?xml version='1.0' encoding='UTF-8'?> " +
                        "<soap:Envelope " +
                        "soap:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/' " +
                        "xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/' " +
                        "xmlns:soapenc='http://schemas.xmlsoap.org/soap/encoding/' " +
                        "xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' " +
                        "xmlns:tns='http://ts.ch02/' " +
                        "xmlns:xsd='http://www.w3.org/2001/XMLSchema'> " +
                        "<soap:Body>" +
                        "<tns:getTimeAsElapsed xsi:nil='true'/>" +
                        "</soap:Body>" +
                        "</soap:Envelope>";


        //

        Service service = Service.create(new QName("foo", "sadgadsg"));
        QName port = new QName("yoo", "asdfs");
        service.addPort(port, HTTPBinding.HTTP_BINDING, "http://127.0.0.1:9877/ts");

        Dispatch<Source> dispatch = service.createDispatch(port, Source.class, Service.Mode.PAYLOAD);

        Map<String,Object> requestContext = dispatch.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "POST");
        Source invoke = dispatch.invoke(new StreamSource(new ByteArrayInputStream(soap_request.getBytes())));


        DOMResult domResult = new DOMResult();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(invoke, domResult);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        String evaluate = xPath.evaluate("//return", domResult.getNode());
        System.out.println(evaluate);

    }
}
