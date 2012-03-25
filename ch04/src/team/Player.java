package team;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 19/02/12
 * Time: 09:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {

    public Player() {
    }

    private String name;

    public Player(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String nickname;
}
