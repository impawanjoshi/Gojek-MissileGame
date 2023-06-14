import Model.Player;
import Repo.PlayerRepo;
import Services.PlayerService;
import Services.impl.PlayerServiceImpl;
import utils.GetPositionFromCoordinates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Driver {
    int playersCount;
    int gridSize;

    int totalShips;
    String S1, S2;
    String P1, P2;
    private List<String> configs;

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.getConfigFromFile();
        driver.setConfigs();

        GetPositionFromCoordinates getPositionFromCoordinates = new GetPositionFromCoordinates();
        PlayerRepo playerRepo = new PlayerRepo();

        PlayerService playerService = new PlayerServiceImpl(getPositionFromCoordinates, playerRepo);

        List<Player> players = playerService.createPlayers(driver.playersCount, driver.gridSize);
//        Player player = playerRepo.getPlayerByID(1);
//        System.out.println(player.getCells().size());

        playerService.assignShipPositions(playerRepo.getPlayerByID(1), driver.P1);
//        playerService.assignShipPositions(players.get(1), driver.P2);

    }

    public void getConfigFromFile() {
        configs = new ArrayList<>();
        String filePath = "C:\\Users\\joshi\\IdeaProjects\\Gojek-MissileGame\\src\\config.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String newLine;
            while ((newLine = reader.readLine()) != null) {
                configs.add(newLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setConfigs() {
        this.playersCount = Integer.parseInt(configs.get(0));

        this.totalShips = Integer.parseInt(configs.get(1));
        this.gridSize = Integer.parseInt(configs.get(2));

        this.S1 = configs.get(3);
        this.S2 = configs.get(4);

        this.gridSize = Integer.parseInt(configs.get(5));

        this.P1 = configs.get(6);
        this.P2 = configs.get(7);
    }
}