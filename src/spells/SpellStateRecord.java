package spells;

import java.util.ArrayList;
import java.util.List;

public class SpellStateRecord {

    private static List<SpellStateRecord> spellsStates = new ArrayList<SpellStateRecord>();

    private int id;

    private String name;

    private boolean preventsSpellCast;

    private boolean preventsFight;

    private boolean isSilent;

    private boolean cantBeMoved;

    private boolean cantBePushed;

    private boolean cantDealDamage;

    private boolean invulnerable;

    private boolean cantSwitchPosition;

    private boolean incurable;

    private boolean invulnerableMelee;

    private boolean invulnerableRange;

    public SpellStateRecord(int id, String name, boolean preventspellCast, boolean preventFight, boolean isSilent, boolean cantBeMoved, boolean cantBePushed, boolean cantDeadDamage,
                            boolean invulnerable, boolean cantSwitchPosition, boolean incurable, boolean invulnerableMelee, boolean invulnerableRange){
        this.id = id;
        this.name = name;
        this.preventsSpellCast = preventspellCast;
        this.preventsFight = preventFight;
        this.isSilent = isSilent;
        this.cantBeMoved = cantBeMoved;
        this.cantBePushed = cantBePushed;
        this.cantDealDamage = cantDeadDamage;
        this.invulnerable = invulnerable;
        this.cantSwitchPosition = cantSwitchPosition;
        this.incurable = incurable;
        this.invulnerableMelee = invulnerableMelee;
        this.invulnerableRange = invulnerableRange;
    }

    public static SpellStateRecord getState(int id){
        for(int i = 0 ; i < spellsStates.size() ; i++){
            if(spellsStates.get(i).getId() == id){
                return spellsStates.get(i);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPreventsSpellCast() {
        return preventsSpellCast;
    }

    public void setPreventsSpellCast(boolean preventsSpellCast) {
        this.preventsSpellCast = preventsSpellCast;
    }

    public boolean isPreventsFight() {
        return preventsFight;
    }

    public void setPreventsFight(boolean preventsFight) {
        this.preventsFight = preventsFight;
    }

    public boolean isSilent() {
        return isSilent;
    }

    public void setSilent(boolean silent) {
        isSilent = silent;
    }

    public boolean isCantBeMoved() {
        return cantBeMoved;
    }

    public void setCantBeMoved(boolean cantBeMoved) {
        this.cantBeMoved = cantBeMoved;
    }

    public boolean isCantBePushed() {
        return cantBePushed;
    }

    public void setCantBePushed(boolean cantBePushed) {
        this.cantBePushed = cantBePushed;
    }

    public boolean isCantDealDamage() {
        return cantDealDamage;
    }

    public void setCantDealDamage(boolean cantDealDamage) {
        this.cantDealDamage = cantDealDamage;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }

    public void setInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
    }

    public boolean isCantSwitchPosition() {
        return cantSwitchPosition;
    }

    public void setCantSwitchPosition(boolean cantSwitchPosition) {
        this.cantSwitchPosition = cantSwitchPosition;
    }

    public boolean isIncurable() {
        return incurable;
    }

    public void setIncurable(boolean incurable) {
        this.incurable = incurable;
    }

    public boolean isInvulnerableMelee() {
        return invulnerableMelee;
    }

    public void setInvulnerableMelee(boolean invulnerableMelee) {
        this.invulnerableMelee = invulnerableMelee;
    }

    public boolean isInvulnerableRange() {
        return invulnerableRange;
    }

    public void setInvulnerableRange(boolean invulnerableRange) {
        this.invulnerableRange = invulnerableRange;
    }
}
