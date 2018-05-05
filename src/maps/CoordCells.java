package maps;

import java.util.ArrayList;
import java.util.List;

public class CoordCells {

    private static List<CellData> cells = new ArrayList<>();

    public static CellData getCell(int id){
        for(int i = 0 ; i < cells.size() ; i++){
            if(cells.get(i).getId() == id){
                return cells.get(i);
            }
        }
        return null;
    }

    public static CellData getCell(int x, int y){
        for(int i = 0 ; i < cells.size() ; i++){
            if(cells.get(i).getX() == x && cells.get(i).getY() == y){
                return cells.get(i);
            }
        }
        return null;
    }

    private static byte x = 0;
    private static byte y = 0;
    private static int id = 0;

    public CoordCells(){

        List<CellData> cells = new ArrayList<>();
        for(int i = 0 ; i < 14 ;  i++){
            byte[] data = new byte[]{x,y};
            id = i;
            for(int j = i ; j <= 560 - (28 - i) ; j += 28){
                cells.add(new CellData(id, x, y));
                data[0]++;
                data[1]--;
                id += 28;
            }
            x++;
            y++;
        }

        x = 1;
        y = 0;
        for(int i = 14 ; i < 28 ;  i++){
            byte[] data = new byte[]{x,y};
            id = i;
            for(int j = i ; j <= 560 - (28 - i) ; j += 28){
                cells.add(new CellData(id, x, y));
                data[0]++;
                data[1]--;
                id += 28;
            }
            x++;
            y++;
        }

        List<CellData> newCells = new ArrayList<>();
        newCells.add(cells.get(0));

        for(int i = 0 ; i < cells.size() ; i++){
            boolean inserted = false;
            int index = 0;
            while(!inserted && index < newCells.size()){
                if(cells.get(i).getId() < newCells.get(index).getId()){
                    newCells.add(index, cells.get(i));
                    inserted = true;
                }
                index++;
            }
        }
        cells = newCells;

        searNeighbors();

    }

    public static void searNeighbors(){
        for (int i = 0 ; i < cells.size() ; i++) {
            List<CellData> line = new ArrayList<>();
            List<CellData> diagonal = new ArrayList<>();
            for(int k = 0 ; k < cells.size() ; k++){
                if((cells.get(i).getX() - 1 == cells.get(k).getX() && cells.get(i).getY() == cells.get(k).getY()) ||
                        (cells.get(i).getX() + 1 == cells.get(k).getX() && cells.get(i).getY() == cells.get(k).getY()) ||
                        (cells.get(i).getX() == cells.get(k).getX() && cells.get(i).getY() - 1 == cells.get(k).getY()) ||
                        (cells.get(i).getX() == cells.get(k).getX() && cells.get(i).getY() + 1 == cells.get(k).getY())){
                    line.add(cells.get(k));
                }
                if((cells.get(i).getX() - 1 == cells.get(k).getX() && cells.get(i).getY() - 1 == cells.get(k).getY()) ||
                        (cells.get(i).getX() + 1 == cells.get(k).getX() && cells.get(i).getY() - 1 == cells.get(k).getY()) ||
                        (cells.get(i).getX() - 1 == cells.get(k).getX() && cells.get(i).getY() + 1 == cells.get(k).getY()) ||
                        (cells.get(i).getX() + 1 == cells.get(k).getX() && cells.get(i).getY() + 1 == cells.get(k).getY())){
                    diagonal.add(cells.get(k));
                }
            }
            cells.get(i).setLine(line);
            cells.get(i).setDiagonal(diagonal);
        }
    }


    public class CellData{
        private int id;
        private byte x;
        private byte y;

        private List<CellData> line = new ArrayList<>();
        private List<CellData> diagonal = new ArrayList<>();

        public CellData(int id, byte x, byte y){
            this.x = x;
            this.y = y;
            this.id = id;
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
