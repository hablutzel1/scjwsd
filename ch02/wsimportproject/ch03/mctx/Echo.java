package ch03.mctx;

import com.sun.net.httpserver.HttpContext;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 27/01/12
 * Time: 12:10 AM
 * To change this template use File | Settings | File Templates.
 */
@WebService
@HandlerChain(file = "ch03/mctx/handler-chain.xml")
public class Echo {

    @Resource
    WebServiceContext webServiceContext;

    @WebMethod
    public String echo(String from_client) {

        MessageContext messageContext = webServiceContext.getMessageContext();
        Object o = messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        MapDump.dump_map((Map) o, "");


        return "echo: " + from_client;
    }

}
