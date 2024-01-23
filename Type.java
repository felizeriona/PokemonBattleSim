package pokemonBattleSim;
import java.util.*;

public class Type {
    private String name;
    private ArrayList<Type> superEffective;
    private ArrayList<Type> notEffective;
    private ArrayList<Type> noEffect;
    
    public Type(String n) {
        name = n;
        superEffective = new ArrayList();
        notEffective = new ArrayList();
        noEffect = new ArrayList();
    }
    
    // Getter method
    public String getName() { return name; }
    
    // Adds Type to ArrayList for Move effectiveness
    public void addType(int e, Type t) {
        // 2: Super effective
        // 1: Not very effective
        // 0: No effect/Immune
        switch(e) {
            case 2:
                superEffective.add(t);
                break;
            case 1:
                notEffective.add(t);
                break;
            case 0:
                noEffect.add(t);
                break;
        }
    }
    
    // Checks type advantage between attacking Move and Monster on defense
    public static double getAdvantage(Move n, Monster m) {
        Type atk = n.getType();
        Type def = m.getType();
        
        // If attack is super/not effective to, or has no effect on defense
        if (atk.superEffective.contains(def)) {
            return 2;
        }
        else if (atk.notEffective.contains(def)) {
            return 0.5;
        }
        else if (atk.noEffect.contains(def)) {
            return 0;
        }
        else {
            return 1;
        }
    }
}