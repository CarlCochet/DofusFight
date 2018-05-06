package characters;

import effects.EffectInteger;
import items.MountRecord;

import java.util.ArrayList;
import java.util.List;

public class CharacterMountRecord {

    private List<CharacterMountRecord> characterMount = new ArrayList<>();

    private int id;
    private int characterId;
    private int modelId;
    private List<EffectInteger> effects;
    private MountRecord template;

    public CharacterMountRecord(int id, int characterId, int modelId, List<EffectInteger> effects, MountRecord template){
        this.id = id;
        this.characterId = characterId;
        this.modelId = modelId;
        this.effects = effects;
        this.template = template;
    }

    public List<CharacterMountRecord> getCharacterMount() {
        return characterMount;
    }

    public void setCharacterMount(List<CharacterMountRecord> characterMount) {
        this.characterMount = characterMount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public List<EffectInteger> getEffects() {
        return effects;
    }

    public void setEffects(List<EffectInteger> effects) {
        this.effects = effects;
    }

    public MountRecord getTemplate() {
        return MountRecord.getMount(modelId);
    }

    public void setTemplate(MountRecord template) {
        this.template = template;
    }
}
