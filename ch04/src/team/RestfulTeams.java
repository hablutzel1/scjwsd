package team;

import com.sun.deploy.net.HttpResponse;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.net.URI;
import java.util.*;


/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 8/02/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServiceProvider
@ServiceMode(value = Service.Mode.MESSAGE)
@BindingType(value = HTTPBinding.HTTP_BINDING)
public class RestfulTeams implements Provider<Source> {

    @Resource
    protected WebServiceContext webServiceContext;

    public RestfulTeams() {

        read_teams_from_file();
        deserialize();

    }

    public Source invoke(Source request) {

        MessageContext messageContext = webServiceContext.getMessageContext();
        String requestVerb = (String) messageContext.get(MessageContext.HTTP_REQUEST_METHOD);

        requestVerb = requestVerb.toUpperCase();

        if (requestVerb.equals("GET")) return do_get(messageContext);
        if (requestVerb.equals("POST")) return do_post(messageContext);
        else throw new HTTPException(405);


    }

    private Source do_post(MessageContext messageContext) {

        java.util.Map<java.lang.String, java.util.List<java.lang.String>> o
                = (Map<String, List<String>>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<String> cargo = o.get("Cargo");
        if (cargo == null) throw new HTTPException(400); // bad request

        String cargoXml = cargo.get(0);


        Transformer transformer;

        try {
            transformer = TransformerFactory.newInstance().newTransformer();

            DOMResult domResult = new DOMResult();
            transformer.transform(new StreamSource(new ByteArrayInputStream(cargoXml.getBytes())), domResult);

            URI create_team = new URI("create_team");

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            String name = xPath.evaluate("/create_team/name", domResult.getNode());

//            xPath.setNamespaceContext(new );
            NodeList player = (NodeList) xPath.evaluate("//player", domResult.getNode(), XPathConstants.NODESET);

            List<Player> players = new ArrayList<Player>();
            for (int i = 0; i < player.getLength(); i++) {
                Node item = player.item(i);
                String playerName = xPath.evaluate("name", item);
                String nickName = xPath.evaluate("nickname", item);
                players.add(new Player(playerName, nickName));
            }

            Team team = new Team(name, players);

            teams.add(team);
            serialize();

            return response_to_client("TOdo bien");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void serialize() throws FileNotFoundException {
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(get_file_path())));
        xmlEncoder.writeObject(teams);
        xmlEncoder.close();
    }

    private Source do_get(MessageContext messageContext) {
        String query = (String) messageContext.get(MessageContext.QUERY_STRING);
        if (query == null) {
            return new StreamSource(new ByteArrayInputStream(team_bytes));
        } else {

            String name = get_value_from_qs("name", query);
            Team team = team_map.get(name);
            if (team == null) {
                throw new HTTPException(404);

            }
            return new StreamSource(encode_to_stream(team));
        }

    }

    private ByteArrayInputStream encode_to_stream(Object obj) {
        // Serialize object to XML and return
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        XMLEncoder enc = new XMLEncoder(stream);
        enc.writeObject(obj);
        enc.close();
        return new ByteArrayInputStream(stream.toByteArray());
    }


    private String get_value_from_qs(String key, String qs) {
        String[] parts = qs.split("=");
        // Check if query string has form: name=<team name>
        if (!parts[0].equalsIgnoreCase(key))
            throw new HTTPException(400); // bad request
        return parts[1].trim();
    }


    private String get_file_path() {
        return "C:\\Users\\jaime\\Desktop\\SCDJWS\\ch04\\src\\team\\teams.xml";
    }


    private void read_teams_from_file() {
        try {

            String path = get_file_path();
            int len = (int) new File(path).length();
            team_bytes = new byte[len];
            new FileInputStream(path).read(team_bytes);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void deserialize() {
        // Deserialize the bytes into a list of teams
        XMLDecoder dec = new XMLDecoder(new ByteArrayInputStream(team_bytes));
        teams = (List<Team>) dec.readObject();

        // Create a map for quick lookups of teams.
        team_map = Collections.synchronizedMap(new HashMap<String, Team>());
        for (Team team : teams) team_map.put(team.getName(), team);
    }

    private Map<String, Team> team_map; // for easy lookups
    private List<Team> teams;           // serialized/deserialized
    private byte[] team_bytes;         // from the persistence file

    private static final String file_name = "teams.ser";

    private StreamSource response_to_client(String msg) {

        ByteArrayInputStream stream = encode_to_stream(msg);
        return new StreamSource(stream);
    }




}
