package ch03.image;

import fibc.RabbitCounter;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Creado por: jaime
 * 9/01/12
 */
public class Publisher {
    private Endpoint endpoint;

    public static void main(String[] args) {
        Publisher me = new Publisher();
        me.create_endpoint();
        me.configure_endpoint();
        me.publish();
    }

    private void create_endpoint() {
        endpoint = Endpoint.create(new SkiImageService());
    }

    private void configure_endpoint() {
        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        binding.setMTOMEnabled(true);
    }

    private void publish() {
        int port = 9999;
        String url = "http://localhost:" + port + "/image";
        endpoint.publish(url);
        System.out.println(url);
    }
}
