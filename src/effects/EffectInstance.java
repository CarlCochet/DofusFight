package effects;

import enums.DirectionsEnum;
import enums.EffectsEnum;
import enums.TriggerType;
import items.EffectGenerationProvider;
import maps.shapes.Zone;

import java.util.Random;

public class EffectInstance {

    private char shapeType;
    private byte radius;
    private EffectsEnum effectsEnum;
    private String targetMask;
    private int effectUID;
    private String rawZone;
    private int effectId;
    private int diceMin;
    private int diceMax;
    private int duration;
    private int value;
    private int delay;
    private byte random;
    private String triggers;
    private TriggerType triggerTypes;
    private int effectElement;

    public Zone getZone(DirectionsEnum orientation){
        return new Zone(shapeType, radius, orientation);
    }

    public Zone getZone(){
        return new Zone(shapeType, radius);
    }

    public Effect generateEffect(boolean perfect){
        /*if(EffectGenerationProvider.isHandled(effectId)){
            Effect effect = EffectGenerationProvider.handle(this);
        }*/
        if(diceMin > 0 && diceMax == 0){
            return new EffectInteger(effectId, diceMin);
        }
        if(value > 0){
            new EffectInteger(effectId, value);
        }
        if(diceMin != 0 && diceMin < diceMax){
            if(!perfect) {
                int value = new Random().nextInt(diceMax - diceMin) + diceMin;
                return new EffectInteger(effectId, value);
            } else {
                return new EffectInteger(effectId, diceMax);
            }
        }
        return null;
    }

    public int randomizeMinMax(){
        return (int)(diceMin < diceMax ? new Random().nextInt( diceMax - diceMin + 1) + diceMin : diceMin);
    }

    public ObjectEffect getTemplateObjectEffect(){
        return new ObjectEffectDice(effectId, diceMin, diceMax, value);
    }


    public EffectInstance (EffectsEnum effect, int delay, int min, int max, int value, int duration, String rawZone, String targetMask){
        this.delay = delay;
        this.diceMin = min;
        this.diceMax = max;
        this.value = value;
        this.duration = duration;
        this.effectElement = 0;
        this.effectId = effect.ordinal();
        this.effectUID = 0;
        this.random = 0;
        this.rawZone = rawZone;
        this.targetMask = targetMask;
    }

    private TriggerType parseTriggers(){
        if(triggers == "X") {
            return TriggerType.AFTER_DEATH;
        } else if(triggers == "D"){
            return TriggerType.BEFORE_ATTACKED;
        } else if(triggers == "I"){
            return triggerTypes.ON_CAST;
        } else if(triggers == "TE"){
            return triggerTypes.TURN_END;
        } else if(triggers == "H"){
            return TriggerType.ON_HEAL;
        } else {
            return TriggerType.UNKNOWN;
        }
    }

    public char getShapeType() {
        return shapeType;
    }

    public void setShapeType(char shapeType) {
        this.shapeType = shapeType;
    }

    public byte getRadius() {
        return radius;
    }

    public void setRadius(byte radius) {
        this.radius = radius;
    }

    public EffectsEnum getEffectsEnum() {
        return effectsEnum;
    }

    public void setEffectsEnum(EffectsEnum effectsEnum) {
        this.effectsEnum = effectsEnum;
    }

    public String getTargetMask() {
        return targetMask;
    }

    public void setTargetMask(String targetMask) {
        this.targetMask = targetMask;
    }

    public int getEffectUID() {
        return effectUID;
    }

    public void setEffectUID(int effectUID) {
        this.effectUID = effectUID;
    }

    public String getRawZone() {
        return rawZone;
    }

    public void setRawZone(String rawZone) {
        this.rawZone = rawZone;
    }

    public int getEffectId() {
        return effectId;
    }

    public void setEffectId(int effectId) {
        this.effectId = effectId;
    }

    public int getDiceMin() {
        return diceMin;
    }

    public void setDiceMin(int diceMin) {
        this.diceMin = diceMin;
    }

    public int getDiceMax() {
        return diceMax;
    }

    public void setDiceMax(int diceMax) {
        this.diceMax = diceMax;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public byte getRandom() {
        return random;
    }

    public void setRandom(byte random) {
        this.random = random;
    }

    public String getTriggers() {
        return triggers;
    }

    public void setTriggers(String triggers) {
        this.triggers = triggers;
    }

    public TriggerType getTriggerTypes() {
        return triggerTypes;
    }

    public void setTriggerTypes(TriggerType triggerTypes) {
        this.triggerTypes = triggerTypes;
    }

    public int getEffectElement() {
        return effectElement;
    }

    public void setEffectElement(int effectElement) {
        this.effectElement = effectElement;
    }
}