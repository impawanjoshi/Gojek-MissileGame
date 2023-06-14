package Repo;

import Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRepo {
    private Map<Integer, Player> players;

    public PlayerRepo() {
        this.players = new HashMap<>();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players.values());
    }

    public void setPlayers(Map<Integer, Player> players) {
        this.players = players;
    }

    public Player getPlayerByID(Integer PlayerID) {
        return players.getOrDefault(PlayerID, null);
    }

    public void addPlayer(Integer playerId, Player player) {
        this.players.put(playerId, player);
    }


}
