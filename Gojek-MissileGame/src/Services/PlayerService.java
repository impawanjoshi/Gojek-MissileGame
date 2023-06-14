package Services;

import Model.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> createPlayers(int totalPlayers, int gridSize);

    public void assignShipPositions(Player player, String points);
//    public void play();

}
