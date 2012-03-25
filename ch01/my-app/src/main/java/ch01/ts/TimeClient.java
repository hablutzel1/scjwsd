package ch01.ts;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.*;

class TimeClient {

    static class MyThread implements Runnable {

        int number;

        MyThread(int number) {
            this.number = number;
        }

        public void run() {

            System.out.println("started request: " + number);
            requests++;
            try {
                makeWSRequest();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            responses++;
            System.out.println("finished request: " + number);
            if (responses == 100) {
                synchronized (lock) {


                    lock.notifyAll();

                }
            }
        }
    }

    static volatile int requests = 0;
    static volatile int responses = 0;

    private static Object lock = new Object();

    public static void main(String args[]) throws Exception {

        synchronized (lock) {

            for (int i = 0; i < 100; i++) {
                new Thread(new MyThread(i)).start();

            }
            lock.wait();
        }

        System.out.println("requests: " + requests);
        System.out.println("responses: " + responses);

    }

    private static void makeWSRequest() throws MalformedURLException {
        URL url = new URL("http://localhost:9876/ts?wsdl");
//        URL url = new URL("http://localhost:8888/ts?wsdl");

        // Qualified name of the service:
        //   1st arg is the service URI
        //   2nd is the service name published in the WSDL
        QName qname = new QName("http://ts.ch01/", "TimeServerImplService");

        // Create, in effect, a factory for the service.
        Service service = Service.create(url, qname);

        // Extract the endpoint interface, the service "port".
        TimeServer eif = service.getPort(TimeServer.class);

        System.out.println(eif.getTimeAsString());
//        System.out.println(eif.getTimeAsElapsed());

//        eif.getTimeAsString();
//        eif.getTimeAsElapsed();
    }
}

