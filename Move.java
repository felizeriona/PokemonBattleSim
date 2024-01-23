package pokemonBattleSim;

public class Move {
    private String name;
    private Type type;
    private int PP, power;
    private double accuracy;
    private boolean damaging;
    
    public Move(String n, Type t, int pp, int po, double a, boolean d) {
        this.name = n;
        this.type = t;
        this.PP = pp;
        this.power = po;
        this.accuracy = a;
        this.damaging = d;
    }
    
    // Getter methods
    public String getName() { return this.name; }
    public Type getType() { return this.type; }
    public int getPP() { return this.PP; }
    public int getPower() { return this.power; }
    public double getAccuracy() { return this.accuracy; }
    public boolean isDamaging() { return this.damaging; }
    
    // Calculates the change in HP when a move is used and casts as int
    public int calcMove(Move n, Monster m) {
        int change = 0;
        
        if (this.damaging) {
            change = (int) ((m.getAtk()*m.getAtk())/(double)(m.getAtk()+m.getDef()) * Type.getAdvantage(n, m));
            /* Placeholder is from previous exercises,
            final damage formula will be closer to in-game.
            Source: https://bulbapedia.bulbagarden.net/wiki/Damage#Generation_I */
        }
        else if (!this.damaging) {
            change = (int) (m.getHP() * 0.5);
            /* Placeholder, exact value of healing will be different for certain Moves */
        }
        
        PP--;
        return change;
    }
}