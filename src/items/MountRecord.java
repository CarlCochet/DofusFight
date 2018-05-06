package items;

import effects.EffectInstance;

import java.util.ArrayList;
import java.util.List;

public class MountRecord {

    private static List<MountRecord> mounts = new ArrayList<>();

    private int id;
    private short itemGId;
    private List<EffectInstance> effects;

    public MountRecord(int id, short itemGId, List<EffectInstance> effects){
        this.id = id;
        this.itemGId = itemGId;
        this.effects = effects;
    }

    public static MountRecord getMount(short itemGId){

        for(int i = 0 ; i < mounts.size() ; i++){
            if(mounts.get(i).getItemGId() == itemGId){
                return mounts.get(i);
            }
        }

        return null;
    }

    public static MountRecord getMount(int modelId){

        for(int i = 0 ; i < mounts.size() ; i++){
            if(mounts.get(i).getId() == modelId){
                return mounts.get(i);
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getItemGId() {
        return itemGId;
    }

    public void setItemGId(short itemGId) {
        this.itemGId = itemGId;
    }

    public List<EffectInstance> getEffects() {
        return effects;
    }

    public void setEffects(List<EffectInstance> effects) {
        this.effects = effects;
    }
}
