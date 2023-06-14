package utils;

public class GetPositionFromCoordinates {
    public int getCellPosition(int x, int y) {
        int pos = 0;

        if (x > 0)
            pos += (x - 1) * 10;

        if (y > 0)
            pos += y;

        return pos;
    }

//    2,3 ->
//    0,0 -> 0
//    0,1-> 1
}
