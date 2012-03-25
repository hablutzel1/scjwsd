package ch03.mctx.client;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 29/01/12
 * Time: 07:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MctxClient {

    public static void main(String[] args) {

        EchoService echoService = new EchoService();
        Echo echoPort = echoService.getEchoPort();

        Map<String,Object> requestContext = ((BindingProvider) echoPort).getRequestContext();

        HashMap<String,List<String>> stringListHashMap = new HashMap<String, List<String>>();

        stringListHashMap.put("Accept-Encoding", Collections.singletonList("gzip"));
        stringListHashMap.put("Greeting", Collections.singletonList("Hallo boy!"));

        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, stringListHashMap);

        dump_map(requestContext, "");

        System.out.println("Request above, response below");

        echoPort.echo("heooooo");
        Map<String, Object> responseContext = ((BindingProvider) echoPort).getResponseContext();
        
        dump_map(responseContext, "");

        System.out.println("Response code: "+ responseContext.get(MessageContext.HTTP_RESPONSE_CODE));


    }

    private static void dump_map(Map map, String indent) {
        Set keys = map.keySet();
        for (Object key : keys) {
            System.out.println(indent + key + " ==> " + map.get(key));
            if (map.get(key) instanceof Map)
                dump_map((Map) map.get(key), indent += "   ");
        }
    }

}
