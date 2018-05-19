package items;

import effects.EffectInstance;
import enums.ItemTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class ItemRecord {

    private static List<ItemRecord> items = new ArrayList<>();

    private int id;
    private String name;

    private int typeId;
    private ItemTypeEnum typeEnum;
    private int level;
    private List<EffectInstance> effects;
    private String criteria;
    private boolean hasSet;
    private ItemSetRecord itemSet;
    private boolean weapon;

    public ItemRecord(int id, String name, int level, List<EffectInstance> effects, String criteria){
        this.id = id;
        this.name = name;
        this.level = level;
        this.effects = effects;
        this.criteria = criteria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemTypeEnum getTypeEnum() {
        return ItemTypeEnum.get(typeId);
    }

    public void setTypeEnum(ItemTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<EffectInstance> getEffects() {
        return effects;
    }

    public void setEffects(List<EffectInstance> effects) {
        this.effects = effects;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public boolean isHasSet() {
        return hasSet;
    }

    public void setHasSet(boolean hasSet) {
        this.hasSet = hasSet;
    }

    public ItemSetRecord getItemSet() {
        return itemSet;
    }

    public void setItemSet(ItemSetRecord itemSet) {
        this.itemSet = itemSet;
    }

    public boolean isWeapon() {
        return weapon;
    }

    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }

    public static ItemRecord getItem(int id){
        int compteur = 0;
        boolean check = true;
        while(check && compteur < items.size()){
            if(items.get(compteur).getId() == id){
                check = false;
            }
            compteur++;
        }
        return items.get(compteur);
    }

    public static ItemRecord[] getItems() {
        return items.toArray(new ItemRecord[items.size()]);
    }

    public static void setItems(List<ItemRecord> items) {
        ItemRecord.items = items;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
