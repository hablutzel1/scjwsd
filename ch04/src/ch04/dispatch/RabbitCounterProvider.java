package ch04.dispatch;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 21/02/12
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServiceProvider
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class RabbitCounterProvider implements Provider<Source>{

    @Resource
    WebServiceContext webServiceContext;


    private Map<Integer, Integer> cache =
            Collections.synchronizedMap(new HashMap<Integer, Integer>());

    private final String xml_start = "<fib:response xmlns:fib = 'urn:fib'>";
    private final String xml_stop = "</fib:response>";
    private final String uri = "urn:fib";


    @Override
    public Source invoke(Source request) {

        MessageContext messageContext = webServiceContext.getMessageContext();
        String o = (String) messageContext.get(MessageContext.HTTP_REQUEST_METHOD);

        o = o.toUpperCase();

        if (o.equals("GET"))return doGet();
        if (o.equals("POST"))return doPost(request);

        throw new HTTPException(405); // unallowed method
    }


    private Source doPost(Source request) {

        DOMResult domResult = new DOMResult();
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(request, domResult );

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            xPath.setNamespaceContext(new NSResolver("fib", "urn:fib"));
            String evaluate = xPath.evaluate("/fib:request", domResult.getNode());

            // TODO persist it to our cache
            System.out.println("Persisting to our cache:"+ evaluate);

            return  new StreamSource(new ByteArrayInputStream((xml_start +"POST: xxx " +  xml_stop).getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Source doGet() {
        String retorno = xml_start +"GET: " +cache.values() +  xml_stop;
        return new StreamSource(new ByteArrayInputStream(retorno.getBytes()));  //To change body of created methods use File | Settings | File Templates.
    }
}

