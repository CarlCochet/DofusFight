package items;

import enums.EffectsEnum;

public class ItemEffectAttribute {

    private EffectsEnum effect;

    public ItemEffectAttribute(EffectsEnum effect){
        this.effect = effect;
    }

    public EffectsEnum getEffect() {
        return effect;
    }

    public void setEffect(EffectsEnum effect) {
        this.effect = effect;
    }
}
