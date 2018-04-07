package effects;

import enums.EffectsEnum;

public abstract class Effect {

    private EffectsEnum effectsEnum;
    private int effectId;

    public Effect(){

    }

    public Effect(int effectId){
        this.effectId = effectId;
    }

    public abstract ObjectEffect getObjectEffect();

    public EffectsEnum getEffectsEnum() {
        return effectsEnum;
    }

    public void setEffectsEnum(EffectsEnum effectsEnum) {
        this.effectsEnum = effectsEnum;
    }

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }
}
