package Services.impl;

import Model.BattleshipStatus;
import Model.Cell;
import Model.Player;
import Repo.PlayerRepo;
import Services.PlayerService;
import utils.GetPositionFromCoordinates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerServiceImpl implements PlayerService {

    private GetPositionFromCoordinates getPositionFromCoordinates;
    private PlayerRepo playerRepo;

    public PlayerServiceImpl(GetPositionFromCoordinates obj, PlayerRepo playerRepo) {
        getPositionFromCoordinates = obj;
        this.playerRepo = playerRepo;
    }

    @Override
    public List<Player> createPlayers(int totalPlayers, int gridSize) {


        for (int i = 1; i <= totalPlayers; i++) {
            Player newPlayer = new Player(i);

            Map<Integer, Cell> cells = new HashMap<>();
            for (int m = 0; m < gridSize * gridSize; m++) {
                Cell cell = new Cell(m, BattleshipStatus.O);
                cells.put(m, cell);
            }
            newPlayer.setCells(cells);

            playerRepo.addPlayer(i, newPlayer);
            System.out.println("Player " + i + " added ");
        }
        return playerRepo.getPlayers();
    }

    @Override
    public void assignShipPositions(Player player, String points) {

        List<String> pts = List.of(points.split(":"));
        Map<Integer, Cell> cells = player.getCells();
        System.out.println(cells.size());
        for (int i = 0; i < pts.size(); i++) {
            String[] cds = pts.get(i).split(",");
            int x = Integer.parseInt(cds[0]);
            int y = Integer.parseInt(cds[1]);
            System.out.println(x + " " + y + " " + getPositionFromCoordinates.getCellPosition(x, y));
            Cell cell = cells.get(getPositionFromCoordinates.getCellPosition(x, y));
            cell.setBattleShipStatus(BattleshipStatus.B);
        }
    }
}
