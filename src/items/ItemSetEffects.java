package items;

import effects.EffectInstance;

import java.util.ArrayList;
import java.util.List;

public class ItemSetEffects {
    private List<List<EffectInstance>> setEffects = new ArrayList<>();

    public List<List<EffectInstance>> getSetEffects() {
        return setEffects;
    }

    public void setSetEffects(List<List<EffectInstance>> setEffects) {
        this.setEffects = setEffects;
    }
}
