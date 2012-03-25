package ch03.mctx;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 29/01/12
 * Time: 07:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class EchoHandler implements SOAPHandler<SOAPMessageContext> {

    public Set<QName> getHeaders() {

        return null;
    }

    public boolean handleMessage(SOAPMessageContext context) {

        Boolean o = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        
        if (o) {
            System.out.println("printing response to client from EchoHandler");
            
            MapDump.dump_map(context, "");
            
        }

        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    public void close(MessageContext context) {

    }
}
