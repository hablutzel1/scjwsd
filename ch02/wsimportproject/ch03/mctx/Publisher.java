package ch03.mctx;

import fibc.RabbitCounter;

import javax.xml.ws.Endpoint;

/**
 * Creado por: jaime
 * 9/01/12
 */
public class Publisher {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9876/echo", new Echo());
    }
}
