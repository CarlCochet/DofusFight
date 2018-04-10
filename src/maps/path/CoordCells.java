package maps.path;

import fr.klemek.betterlists.BetterArrayList;
import maps.Cell;

import java.util.ArrayList;
import java.util.List;

public class CoordCells {
    public static BetterArrayList<CellData> cells = new BetterArrayList<>();

    public static CellData getCell(int id){
        return cells.firstOrDefault(cell -> cell.getId() == id, null);
    }

    public static CellData getCell(int x, int y){
        return cells.firstOrDefault(cell -> cell.getX() == x && cell.getY() == y, null);
    }

    private static byte x = 0;
    private static byte y = 0;
    private static int id = 0;

    public CoordCells(){
        List<CellData> cells = new ArrayList<>();
        for(int i = 0 ; i < 14 ; i++){
            byte[] data = new byte[]{x, y};
            id = i;
            for(int j = i ; j <= 560 - (28 - i) ; j += 28){
                cells.add(new CellData(id, (byte) data[0], (byte) data[0]));
                data[0]++;
                data[1]++;
            }
        }
    }

    private static void SearNeighbors(){
        for (CellData cell : cells) {
            BetterArrayList<CellData> auxCells = new BetterArrayList<>();
            List<CellData> cells2 = cells.where(x -> (x.x == cell.x - 1 && x.y == cell.y) || (x.x == cell.x + 1 && x.y == cell.y) || (x.x == cell.x - 1 && x.y == cell.y) || (x.x == cell.x + 1 && x.y == cell.y));
            cell.line = cells2;
            cells2 = cells.where(x -> (x.x == cell.x - 1 && x.y == cell.y - 1) || (x.x == cell.x - 1 && x.y == cell.y + 1) || (x.x == cell.x + 1 && x.y == cell.y - 1) || (x.x == cell.x + 1 && x.y == cell.y + 1));
            cell.diagonal = cells2;
        }
    }

    public class CellData {
        public int id;
        public byte x;
        public byte y;

        public List<CellData> line;
        public List<CellData> diagonal;

        public CellData(int id, byte x, byte y){
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public byte getX() {
            return x;
        }

        public void setX(byte x) {
            this.x = x;
        }

        public byte getY() {
            return y;
        }

        public void setY(byte y) {
            this.y = y;
        }

        public List<CellData> getLine() {
            return line;
        }

        public void setLine(List<CellData> line) {
            this.line = line;
        }

        public List<CellData> getDiagonal() {
            return diagonal;
        }

        public void setDiagonal(List<CellData> diagonal) {
            this.diagonal = diagonal;
        }
    }
}


