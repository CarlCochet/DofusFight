package maps;

public class Cell {

    private int cellId;
    private int x;
    private int y;
    private int celltype;
    private boolean targeted;
    private boolean possibleMove;

    public Cell(int x, int y, int celltype, int cellId){
        this.cellId = cellId;
        this.x = x;
        this.y = y;
        this.celltype = celltype;
        this.targeted = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCelltype() {
        return celltype;
    }

    public void setCelltype(int celltype) {
        this.celltype = celltype;
    }

    public boolean getTargeted() {
        return targeted;
    }

    public void setTargeted(boolean targeted) {
        this.targeted = targeted;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public boolean isTargeted() {
        return targeted;
    }

    public boolean getPossibleMove() {
        return possibleMove;
    }

    public void setPossibleMove(boolean possibleMove) {
        this.possibleMove = possibleMove;
    }
}
