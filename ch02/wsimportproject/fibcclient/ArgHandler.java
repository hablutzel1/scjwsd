package fibcclient;

import fibc.ch03.*;

import javax.xml.bind.*;
import javax.xml.ws.*;
import javax.xml.ws.handler.*;
import java.util.logging.*;

/**
 * Creado por: jaime
 * 23/01/12
 */
public class ArgHandler implements LogicalHandler<LogicalMessageContext> {

    Logger logger = Logger.getLogger("ArgHandler");

    public boolean handleMessage(LogicalMessageContext context) {

        logger.info("ArgHandler.handlerMessageasdfasdf");

        if (((Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY))) {

            LogicalMessage message = context.getMessage();

            try {
                JAXBContext a = JAXBContext.newInstance("fibc.ch03");
                Object payload = message.getPayload(a);
                CountRabbits value = (CountRabbits) ((JAXBElement) payload).getValue();
                int arg0 = value.getArg0();
                if (arg0 < 0) {
                    logger.info("value " + arg0 + "converted to positiveasdfa");
                    value.setArg0(Math.abs(arg0));
                }

                ((JAXBElement) payload).setValue(value);
                message.setPayload(payload, a);

            } catch (JAXBException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


        }
        return true;
    }

    public boolean handleFault(LogicalMessageContext context) {
        return true;
    }

    public void close(MessageContext context) {
        logger.info("close arg handlers");
    }
}
