package team;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 19/02/12
 * Time: 04:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamsClient {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        HttpURLConnection urlConnection = (HttpURLConnection) new URL("http://localhost:8888/teams").openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        //System.out.println("Is URLConnection open? " +
        //;);
        String xml = "";
               String next = null;
        while ((next = bufferedReader.readLine()) != null ) {
            xml += next;
        }

        System.out.println("XML: " + xml);

        System.out.println("Sax parsed XML");

        // TODO use a XML Parser
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(new ByteArrayInputStream(xml.getBytes()),new SaxParserHandler());



    }



}

 class SaxParserHandler extends DefaultHandler {
//    char[ ] buffer = new char[1024];
//    int n = 0;
//
//    public void startElement(String uri, String lname,
//                             String qname, Attributes attributes) {
//        clear_buffer();
//    }

//    public void characters(char[ ] data, int start, int length) {
//        System.out.println(".");
//        for (int i = start; i < start + length; i++) {
//            System.out.print(data[i]);
//
//        }
//        System.out.println(".");
//
//
////        System.arraycopy(data, start, buffer, 0, length);
////        n += length;
//    }

     @Override
     public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         System.out.println(qName);
     }

     //    public void endElement(String uri, String lname, String qname) {
//        if (Character.isUpperCase(buffer[0]))
//            System.out.println(new String(buffer));
//        clear_buffer();
//    }

    private void clear_buffer() {
//        Arrays.fill(buffer, '\0');
//        n = 0;
    }
}
