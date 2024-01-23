package pokemonBattleSim;
import java.util.*;

public class Trainer {
    private String name;
    private ArrayList<Monster> team;
    private ArrayList<Item> bag;
    
    public Trainer(String n) {
        this.name = n;        
        this.team = new ArrayList();
        this.bag = new ArrayList();
    }
    
    // Getter method
    public String getName() { return this.name; }
    
    // Adds Monster to team
    public void addMonster(Monster m) {
        this.team.add(m);
    }
    
    // Adds Item to bag
    public void addItem(Item i) {
        this.bag.add(i);
    }
    
    // Uses up Item from bag and removes it
    public void useItem(Item i, Monster m) {
        if(this.bag.contains(i)) {
            i.use(m);
            this.bag.remove(i); 
        }
    }
}