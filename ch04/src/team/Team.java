package team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 8/02/12
 * Time: 12:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class Team {

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    private List<Player> players;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public Team() {
    }
}
