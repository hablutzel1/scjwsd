package ch04.dispatch;

import team.RestfulTeams;

import javax.xml.ws.Endpoint;

class Publisher {
    public static void main(String[ ] args) {
        int port = 8888;
        String url = "http://localhost:" + port + "/rp";
        Endpoint.publish(url, new RabbitCounterProvider());
    }
}     