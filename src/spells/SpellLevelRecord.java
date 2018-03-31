package spells;

import effects.EffectInstance;

import java.util.ArrayList;
import java.util.List;

public class SpellLevelRecord {

    private int id;
    private int spellId;
    private byte grade;
    private int apCost;
    private int minRange;
    private int maxRange;
    private boolean castInLine;
    private boolean castInDiagonal;
    private boolean castTestLos;
    private int criticalHitProbability;
    private boolean needFreeCell;
    private boolean needTakenCell;
    private boolean needFreeTrapCell;
    private boolean rangeCanBeBoosted;
    private int maxStacks;
    private int maxCastPerTurn;
    private int maxCastPerTarget;
    private int minCastInterval;
    private int initialCooldown;
    private int globalCooldown;
    private List<Integer> statesRequired = new ArrayList<Integer>();
    private List<Integer> statesForbidden = new ArrayList<Integer>();
    private List<EffectInstance> effects;
    private List<EffectInstance> criticalEffects;



    public SpellLevelRecord(){

    }


}
