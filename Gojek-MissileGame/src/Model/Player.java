package Model;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private int PlayerID;
    private Map<Integer, Cell> cells;
    //    private Map<>
    private int totalShips;

    public Player() {

    }

    public Player(int playerID) {
        PlayerID = playerID;
        this.cells = new HashMap<>();
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public Map<Integer, Cell> getCells() {
        return cells;
    }

    public void setCells(Map<Integer, Cell> cells) {
        this.cells = cells;
    }

    public int getTotalShips() {
        return totalShips;
    }

    public void setTotalShips(int totalShips) {
        this.totalShips = totalShips;
    }
}
