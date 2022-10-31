package football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers (){
        return Collections.unmodifiableList(players);
    }

    private void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(String playerName){
        boolean isRemoved = players.removeIf(p -> p.getName().equals(playerName));
        if(!isRemoved){
            String errorMessage = String.format("Player %s is not in %s team.", playerName, this.name);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public double getRating(){
        return players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0);
    }
}
