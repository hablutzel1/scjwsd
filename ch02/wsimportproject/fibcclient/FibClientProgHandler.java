package fibcclient;

//import fibC.RabbitCounterService;
//import fibC.RabbitCounter;


import fibc.ch03.*;

import javax.xml.ws.handler.*;
import java.util.*;

class FibClientProgHandler {
    public static void main(String[] args) {
        RabbitCounterService service = new RabbitCounterService();
        service.setHandlerResolver(new MyHandlerResolver());
        RabbitCounter port = service.getRabbitCounterPort();
        try {
            int n = 10;
            System.out.println("fib(" + n + ") = " + port.countRabbits(n));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static class MyHandlerResolver implements HandlerResolver {
        public List<Handler> getHandlerChain(PortInfo portInfo) {
            return new ArrayList<Handler>(){
                {
                    add(new ArgHandler());
                    add(new UUIDHandler());
//
                }
            };
        }
    }
}