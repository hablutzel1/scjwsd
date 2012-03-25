package ch04.team;

import javax.xml.ws.Endpoint;

class TeamsPublisher {
    public static void main(String[ ] args) {
        int port = 8888;
        String url = "http://localhost:" + port + "/teams";
        System.out.println("Publishing Teams restfully on port " + port);
        Endpoint.publish(url, new RestfulTeams());
    }
}     