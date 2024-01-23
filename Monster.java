package pokemonBattleSim;
import java.util.*;

public class Monster {
    private String name;
    private Type type;
    private int atk, def, spd, HP;
    private ArrayList<Move> moveset;
    private boolean active, confused, paralyzed, poisoned;
    
    public Monster(String n, Type t, int h, int a, int d, int s) {
        this.name = n;
        this.type = t;
        this.HP = h;
        this.atk = a;
        this.def = d;
        this.spd = s;
        this.moveset = new ArrayList();
        this.active = false;
        this.confused = false;
        this.paralyzed = false;
        this.poisoned = false;
    }
    
    // Getter methods
    public String getName() { return this.name; }
    public Type getType() { return this.type; }
    public int getAtk() { return this.atk; }
    public int getDef() { return this.def; }
    public int getSpd() { return this.spd; }
    public int getHP() { return this.HP; }
    public boolean isActive() { return this.active; }
    public boolean isConfused() { return this.confused; }
    public boolean isParalyzed() { return this.paralyzed; }
    public boolean isPoisoned() { return this.poisoned; }
    
    // Add move to moveset
    public void addMove(Move m) {
        this.moveset.add(m);
    }
    
    // Check HP of both Monsters, to be used after every move
    public void checkHP() {
        if (this.HP <= 0) {
            this.HP = 0;
            System.out.printf("%s fainted!%n", this.name);
        }
    }
    
    public void increaseHP(int h) {
        this.HP += h;
    }
    
    // Monster becomes active upon selection of Trainer
    public void setActive(boolean a) {
        if (a) { this.active = true; }
        if (!a) { this.active = false; }
    }
    
    // Checks if Move is in Monster's moveset and takes appropriate effect
    // If Move is damaging, damage is calculated and dealt on foe
    // If Move is not damaging, healing is done to self
    public void use(Move n, Monster foe) {
        if (this.moveset.contains(n)) {
            System.out.printf("%s used %s!%n", this.name, n.getName());
            
            if (n.isDamaging()) {
                foe.HP -= n.calcMove(n, foe);
                if (foe.HP < n.calcMove(n, foe)) { foe.HP = 0; }
                System.out.printf("(%s dealt %d damage, leaving %s with %d HP.)%n", this.name, n.calcMove(n, foe), foe.name, foe.HP);
            }
            else if (!n.isDamaging()) {
                this.HP += n.calcMove(n, this);
                System.out.printf("(%s healed %d HP, giving it %d HP.)%n", this.name, n.calcMove(n, foe), this.HP);
            }
        }
    }
}