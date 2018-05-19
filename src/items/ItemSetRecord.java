package items;

import effects.Effect;

import java.util.ArrayList;
import java.util.List;

public class ItemSetRecord {

    private static List<ItemSetRecord> itemSets = new ArrayList<>();

    private int id;
    private String name;
    private List<Integer> items;
    private ItemSetEffects effects;

    public ItemSetRecord(int id, String name, List<Integer> items, ItemSetEffects effects){
        this.id = id;
        this.name = name;
        this.items = items;
        this.effects = effects;
    }

    public static List<ItemSetRecord> getItemSets() {
        return itemSets;
    }

    public static void setItemSets(List<ItemSetRecord> itemSets) {
        ItemSetRecord.itemSets = itemSets;
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

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public ItemSetEffects getEffects() {
        return effects;
    }

    public void setEffects(ItemSetEffects effects) {
        this.effects = effects;
    }

    /*public List<Effect> getSetsEffects(int itemCount){
        if(effects.getSetEffects().size() >= itemCount){
            return (Effect)(effects.getSetEffects().get(itemCount - 1));
        }
    }*/

    public static ItemSetRecord getItemSet(int itemGID){
        boolean check = true;
        int compteur = 0;
        while(check && compteur < itemSets.size()){
            if(itemSets.get(compteur).getItems().contains(itemGID)){
                check = false;
            }
            compteur++;
        }
        return itemSets.get(compteur);
    }
}

