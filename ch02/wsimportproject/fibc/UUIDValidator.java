package fibc;

import javax.xml.namespace.*;
import javax.xml.soap.*;
import javax.xml.ws.handler.*;
import javax.xml.ws.handler.soap.*;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.IOException;
import java.util.*;

import static javax.xml.ws.handler.MessageContext.MESSAGE_OUTBOUND_PROPERTY;

/**
 * Creado por: jaime
 * 25/01/12
 */
public class UUIDValidator implements SOAPHandler<SOAPMessageContext> {

    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext context) {

        if (!((Boolean) context.get(MESSAGE_OUTBOUND_PROPERTY))) {

            System.out.println("validating incoming UUID");

            try {
                SOAPMessage message = context.getMessage();
                SOAPHeader header = message.getSOAPPart().getEnvelope().getHeader();
                if (header == null) {
                    generateSOAPFault(message, "no header");
                }

                Iterator iterator = header.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                if (iterator == null || !iterator.hasNext()) {
                    generateSOAPFault(message, "no header SOAPConstants.URI_SOAP_ACTOR_NEXT");
                }
                Node next = (Node) iterator.next();

                String value = next == null ? null : next.getValue();

                // assuming value should be the uuid value
                if (value == null) {
                    generateSOAPFault(message, "no uuid valuein header block");
                }


                UUID uuid = UUID.fromString(value);


                if (uuid.variant() != UUIDvariant || uuid.version() != UUIDversion) {
                    generateSOAPFault(message, "invalid uuid value");
                }


                message.writeTo(System.out);
            } catch (SOAPException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


            return true;
        }

        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private static final int UUIDvariant = 2; // layout
    private static final int UUIDversion = 4; // version 


    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    public void close(MessageContext context) {
    }

    private void generateSOAPFault(SOAPMessage msg, String reason) {
        try {
            SOAPBody body = msg.getSOAPPart().getEnvelope().getBody();
            SOAPFault fault = body.addFault();
            fault.setFaultString(reason);
            // wrapper for a SOAP 1.1 or SOAP 1.2 fault
            throw new SOAPFaultException(fault);
        } catch (SOAPException e) {
            int yoo =3;
        }
    }

}
