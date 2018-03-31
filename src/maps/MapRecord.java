package maps;

import java.util.ArrayList;
import java.util.List;

public class MapRecord {

    private static List<MapRecord> maps = new ArrayList<MapRecord>();

    private int id;
    private AbstractMapInstance instance;
    private List<Integer> blueCells;
    private List<Integer> redCells;


}
