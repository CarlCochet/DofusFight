package spells;

import enums.SpellCategoryEnum;

import java.util.ArrayList;
import java.util.List;

public class SpellRecord {

    private static List<SpellRecord> spells = new ArrayList<SpellRecord>();
    private int id;
    private String name;
    private List<Integer> spellsLevels;
    private List<SpellLevelRecord> levels;
    private byte category;

    private SpellCategoryEnum categoryEnum;

    public SpellRecord(int id, String name, List<Integer> spellsLevels, byte category) {
        this.id = id;
        this.name = name;
        this.spellsLevels = spellsLevels;
        this.category = category;
    }

    public SpellLevelRecord getLevel(byte grade){
        return levels.get(levels.size() - 1);
    }

}
