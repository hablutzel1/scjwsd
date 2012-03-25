package ch03.mctx.client;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 27/01/12
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String[] args) {
        EchoService echoService = new EchoService();
        System.out.println(echoService.getEchoPort().echo("hallo"));
    }
}
