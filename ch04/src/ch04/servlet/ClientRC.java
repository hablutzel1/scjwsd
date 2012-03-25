package ch04.servlet;

import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ClientRC {
    private static final String url = "http://localhost:8080/serv";

    public static void main(String[] args) {
        new ClientRC().send_requests();
    }

    private void send_requests() {
        try {
            HttpURLConnection conn = null;

            // POST request to create some Fibonacci numbers.
            List<Integer> nums = new ArrayList<Integer>();
            for (int i = 1; i < 15; i++) nums.add(i);
            String payload = URLEncoder.encode("nums", "UTF-8") + "=" +
                    URLEncoder.encode(nums.toString(), "UTF-8");

            // Send the request
            conn = get_connection(url, "POST");
            conn.setRequestProperty("accept", "text/xml");
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(payload);
            out.flush();
            get_response(conn);

            // GET to test whether POST worked
            conn = get_connection(url, "GET");
            conn.addRequestProperty("accept", "text/xml");
            conn.connect();
            get_response(conn);

            conn = get_connection(url + "?num=12", "GET");
            conn.addRequestProperty("accept", "text/plain");
            conn.connect();
            get_response(conn);

            // DELETE request
            conn = get_connection(url + "?num=12", "DELETE");
            conn.addRequestProperty("accept", "text/xml");
            conn.connect();
            get_response(conn);

            // GET request to test whether DELETE worked
            conn = get_connection(url + "?num=12", "GET");
            conn.addRequestProperty("accept", "text/html");
            conn.connect();
            get_response(conn);


            conn = get_connection(url + "?num=12", "OPTIONS");
            conn.connect();
            get_response(conn);

            conn = get_connection(url + "?num=12", "HEAD");
            conn.connect();
            get_response(conn);

        } catch (IOException e) {
            System.err.println(e);
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }

    private HttpURLConnection get_connection(String url_string, String verb) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(verb);
            conn.setDoInput(true);
            conn.setDoOutput(true);
        } catch (MalformedURLException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return conn;
    }

    private void get_response(HttpURLConnection conn) {
        try {
            String xml = "";
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String next = null;
            while ((next = reader.readLine()) != null)
                xml += next;
            System.out.println("The response:\n" + xml);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}     
