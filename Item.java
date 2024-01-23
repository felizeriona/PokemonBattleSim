package pokemonBattleSim;

public class Item {
    private String name;
    private int effect;
    
    public Item(String n, int e) {
        this.name = n;
        this.effect = e;
    }
    
    // Getter method
    public String getName() { return this.name; }
    public double getEffect() { return this.effect; }
    
    // Uses item on non-fainted Monster
    public void use(Monster m) {
        if (m.getHP() > 0) {
            m.increaseHP(this.effect);
            /* Placeholder, exact value of healing will be different for certain Moves */
        }
    }
}