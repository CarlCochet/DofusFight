package maps;

import java.util.ArrayList;
import java.util.List;

public class MapRecord {

    private static List<MapRecord> maps = new ArrayList<MapRecord>();

    private int id;
    private AbstractMapInstance instance;
    private List<Integer> blueCells;
    private List<Integer> redCells;

    public MapRecord(int id, List<Integer> blueCells, List<Integer> redCells){
        this.id = id;
        this.blueCells = blueCells;
        this.redCells = redCells;
    }

    public static List<MapRecord> getMaps() {
        return maps;
    }

    public static void setMaps(List<MapRecord> maps) {
        MapRecord.maps = maps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AbstractMapInstance getInstance() {
        return instance;
    }

    public void setInstance(AbstractMapInstance instance) {
        this.instance = instance;
    }

    public List<Integer> getBlueCells() {
        return blueCells;
    }

    public void setBlueCells(List<Integer> blueCells) {
        this.blueCells = blueCells;
    }

    public List<Integer> getRedCells() {
        return redCells;
    }

    public void setRedCells(List<Integer> redCells) {
        this.redCells = redCells;
    }
}
