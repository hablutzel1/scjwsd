package fibcclient;

import java.util.UUID;
import java.util.Set;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPConstants;
import java.io.IOException;

public class UUIDHandler implements SOAPHandler<SOAPMessageContext> {
    private static final String LoggerName = "ClientSideLogger";
    private Logger logger;
    private final boolean log_p = true; // set to false to turn off

    public UUIDHandler() {
        logger = Logger.getLogger(LoggerName);
    }

    public boolean handleMessage(SOAPMessageContext ctx) {
        if (log_p) logger.info("handleMessage");

        // Is this an outbound message, i.e., a request?
        Boolean request_p = (Boolean)
                ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        // Manipulate the SOAP only if it's a request
        if (request_p) {
            // Generate a UUID and a timestamp to place in the message header.
            UUID uuid = UUID.randomUUID();

            try {
                SOAPMessage msg = ctx.getMessage();
                SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
                SOAPHeader hdr = env.getHeader();
                // Ensure that the SOAP message has a header.
                if (hdr == null) hdr = env.addHeader();

                QName qname = new QName("http://ch03.fib", "uuid");
                SOAPHeaderElement helem = hdr.addHeaderElement(qname);

                helem.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT); // default
                helem.setMustUnderstand(true);
                helem.addTextNode(uuid.toString());
                msg.saveChanges();

                // For tracking, write to standard output.
                msg.writeTo(System.out);
                System.out.println("\n");
            } catch (SOAPException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return true; // continue down the chain
    }

    public boolean handleFault(SOAPMessageContext ctx) {
        if (log_p) logger.info("handleFault");
        try {
            ctx.getMessage().writeTo(System.out);
        } catch (SOAPException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return true;
    }

    public Set<QName> getHeaders() {
        if (log_p) logger.info("getHeaders");
        return null;
    }

    public void close(MessageContext messageContext) {
        if (log_p) logger.info("close");
    }
}
