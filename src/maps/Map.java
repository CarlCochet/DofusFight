package maps;

import maps.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    private static int sizeX = 34;
    private static int sizeY = 34;

    private Cell[][] cells;

    private int[][] block;
    private List<int[]> blocks;

    public Map(){
        cells = new Cell[sizeX][sizeY];
        generate();
    }

    public void generate(){
        blocks=new ArrayList<int[]>();
        int randint = 0;
        int count = 0;
        int countId = 0;
        for(int i = 0  ; i < sizeX ; i++){
            for(int k = 0 ; k < sizeY ; k++){
                if( (i + k) < 13 || (i + k) > 53 || (i - k) > 13 || (k - i) > 13){
                    cells[i][k] = new Cell(i, k, 1, -1, false, false);
                    count++;
                    this.blocks.add(new int[]{i, k});
                } else {
                    Random rand = new Random();
                    randint = rand.nextInt(20);
                    cells[i][k] = new Cell(i, k, randint > 1 ? 2 : randint, countId, false, false);
                    if (randint < 2) {
                        count++;
                        this.blocks.add(new int[]{i, k});
                    }
                    countId++;
                }
            }
        }
        generatePlacements();
        block=new int[count][2];
        for(int i=0;i<count;i++){
            block[i]=new int[]{blocks.get(i)[0],blocks.get(i)[1]};
        }
    }

    public boolean visibility(int x0, int y0, int x1, int y1, int range){
        boolean clear = true;
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        if(dx + dy > range){
            return false;
        }
        int x = x0;
        int y = y0;
        int n = -1 + dx + dy;
        int x_inc = (x1 > x0 ? 1 : -1);
        int y_inc = (y1 > y0 ? 1 : -1);
        int error = dx - dy;
        dx *= 2;
        dy *= 2;

        if (error > 0)
        {
            x += x_inc;
            error -= dy;
        } else if (error < 0) {
            y += y_inc;
            error += dx;
        } else {
            x += x_inc;
            error -= dy;
            y += y_inc;
            error += dx;
            n--;
        }

        while (n > 0 && clear){
            if (this.getCells()[x][y].getCelltype() == 0){
                clear = false;
            } else {
                if (error > 0)
                {
                    x += x_inc;
                    error -= dy;
                } else if (error < 0)
                {
                    y += y_inc;
                    error += dx;
                } else {
                    x += x_inc;
                    error -= dy;
                    y += y_inc;
                    error += dx;
                    n--;
                }
                n--;
            }
        }
        return clear;
    }

    public void generatePlacements(){
        int numPlaceCells = (new Random().nextInt(8) + 8) * 2;
        int currentNum = 0;
        while(currentNum < numPlaceCells){
            int x = new Random().nextInt(33);
            int y = new Random().nextInt(33);
            if(cells[x][y].getCelltype() == 2){
                if(currentNum < numPlaceCells/2){
                    cells[x][y].setBlue(true);
                    currentNum++;
                } else {
                    cells[x][y].setRed(true);
                    currentNum++;
                }
            }
        }

    }

    public static int getSizeX() {
        return sizeX;
    }

    public static void setSizeX(int sizeX) {
        Map.sizeX = sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    public static void setSizeY(int sizeY) {
        Map.sizeY = sizeY;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int[][] getBlock() {
        return block;
    }

    public void setBlock(int[][] block) {
        this.block = block;
    }

    public List<int[]> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<int[]> blocks) {
        this.blocks = blocks;
    }

}
