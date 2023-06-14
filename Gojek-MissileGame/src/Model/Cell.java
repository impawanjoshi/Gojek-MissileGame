package Model;

public class Cell {
    private int cellNo;
    private BattleshipStatus battleShipStatus;

    public Cell(int cellNo, BattleshipStatus battleShipStatus) {
        this.cellNo = cellNo;
        this.battleShipStatus = battleShipStatus;
    }

    public int getCellNo() {
        return cellNo;
    }

    public void setCellNo(int cellNo) {
        this.cellNo = cellNo;
    }

    public BattleshipStatus getBattleShipStatus() {
        return battleShipStatus;
    }

    public void setBattleShipStatus(BattleshipStatus battleShipStatus) {
        this.battleShipStatus = battleShipStatus;
    }
}
