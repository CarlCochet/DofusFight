package characters;

import java.util.ArrayList;
import java.util.List;

public class CharacterRecord {

    private static List<CharacterRecord> characters = new ArrayList<>();

    private int id;
    private byte breedId;
    private int mapId;
    private int cellId;
    private byte direction;
    private long exp;
    private int spawnPointMapId;
    private Stats stats;
    private int spellPoints;
    private int statsPoints;
    private List<CharacterSpell> spells;

    public CharacterRecord(int id, byte breedId, int mapId, int cellId, byte directionn,
                           long exp, int spawnPointMapId, Stats stats, int spellPoints,
                           int statsPoints ,List<CharacterSpell> spells){
        this.id = id;
        this.breedId = breedId;
        this.mapId = mapId;
        this.cellId = cellId;
        this.direction = directionn;
        this.exp = exp;
        this.spawnPointMapId = spawnPointMapId;
        this.stats = stats;
        this.spellPoints = spellPoints;
        this.statsPoints = statsPoints;
        this.spells = spells;
    }

    public static CharacterRecord getRecord(int id){

        for(int i = 0 ; i < characters.size() ; i++){
            if(characters.get(i).getId() == id){
                return characters.get(i);
            }
        }

        return null;
    }

    public static List<CharacterRecord> getCharacters() {
        return characters;
    }

    public static void setCharacters(List<CharacterRecord> characters) {
        CharacterRecord.characters = characters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getBreedId() {
        return breedId;
    }

    public void setBreedId(byte breedId) {
        this.breedId = breedId;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public byte getDirection() {
        return direction;
    }

    public void setDirection(byte direction) {
        this.direction = direction;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getSpawnPointMapId() {
        return spawnPointMapId;
    }

    public void setSpawnPointMapId(int spawnPointMapId) {
        this.spawnPointMapId = spawnPointMapId;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int getSpellPoints() {
        return spellPoints;
    }

    public void setSpellPoints(int spellPoints) {
        this.spellPoints = spellPoints;
    }

    public int getStatsPoints() {
        return statsPoints;
    }

    public void setStatsPoints(int statsPoints) {
        this.statsPoints = statsPoints;
    }

    public List<CharacterSpell> getSpells() {
        return spells;
    }

    public void setSpells(List<CharacterSpell> spells) {
        this.spells = spells;
    }
}
