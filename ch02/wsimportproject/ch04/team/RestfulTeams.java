package ch04.team;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
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
        else throw new HTTPException(405);

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
        return "C:\\Users\\jaime\\Desktop\\SCDJWS\\ch02\\wsimportproject\\ch04\\team\\teams.xml";
    }


    private void read_teams_from_file() {
        try {
            String cwd = System.getProperty("user.dir");
            String sep = System.getProperty("file.separator");
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


}
