package pokemonBattleSim;

// Double slash comments explain code or specific game mechanic
/* Slash asterisk comments note changes in future development */

public class Main {
    public static void main(String[] args) {
        // Adding Type instances
        Type nor = new Type("Normal");      Type fir = new Type("Fire");
        Type wat = new Type("Water");       Type ele = new Type("Electric");
        Type gra = new Type("Grass");       Type ice = new Type("Ice");
        Type fig = new Type("Fighting");    Type poi = new Type("Poison");
        Type gro = new Type("Ground");      Type fly = new Type("Flying");
        Type psy = new Type("Psychic");     Type bug = new Type("Bug");
        Type roc = new Type("Rock");        Type gho = new Type("Ghost");
        Type dra = new Type("Dragon");
        
        // Adding type advantages
        // Normal
            // Not effective to Rock
            // No effect on Ghost
        nor.addType(1, roc);
        nor.addType(0, gho);
        
        // Fire
            // Super effective to Grass, Ice, Bug
            // Not effective to Fire, Water, Rock, Dragon
        fir.addType(2, gra); fir.addType(2, ice); fir.addType(2, bug);
        fir.addType(1, fir); fir.addType(1, wat); fir.addType(1, roc); fir.addType(1, dra);
        
        // Water
            // Super effective to Fire, Ground, Rock
            // Not effective to Water, Grass, Dragon
        wat.addType(2, fir); wat.addType(2, gro); wat.addType(2, roc);
        wat.addType(1, wat); wat.addType(1, gra); wat.addType(1, dra);
        
        // Electric
            // Super effective to Water, Flying
            // Not effective to Electric, Grass, Dragon
            // No effect on Ground
        ele.addType(2, wat); ele.addType(2, fly);
        ele.addType(1, ele); ele.addType(1, gra); ele.addType(1, dra);
        ele.addType(0, gro);
        
        // Grass
            // Super effective to Water, Ground, Rock
            // Not effective to Fire, Grass, Poison, Flying, Bug, Dragon
        gra.addType(2, wat); gra.addType(2, gro); gra.addType(2, roc);
        gra.addType(1, fir); gra.addType(1, gra); gra.addType(1, poi); gra.addType(1, fly); gra.addType(1, bug); gra.addType(1, dra); 
        
        // Ice
            // Super effective to Grass, Ground, Flying, Dragon
            // Not effective to Water, Ice
        ice.addType(2, gra); ice.addType(2, gro); ice.addType(2, fly); ice.addType(2, dra);
        ice.addType(1, wat); ice.addType(1, ice);
        
        // Fighting
            // Super effective to Normal, Ice, Rock
            // Not effective to Poison, Flying, Psychic, Bug
            // No effect on Ghost
        fig.addType(2, nor); fig.addType(2, ice); fig.addType(2, roc);
        fig.addType(1, poi); fig.addType(1, fly); fig.addType(1, psy); fig.addType(1, bug);
        fig.addType(0, gho);
        
        // Poison
            // Super effective to Grass, Bug
            // Not effective to Poison, Ground, Rock, Ghost
        poi.addType(2, gra); poi.addType(2, bug);
        poi.addType(1, poi); poi.addType(1, gro); poi.addType(1, roc); poi.addType(1, gho);
        
        // Ground
            // Super effective to Fire, Electric, Poison, Rock
            // Not effective to Grass, Bug
            // No effect on Flying
        gro.addType(2, fir); gro.addType(2, ele); gro.addType(2, poi); gho.addType(2, roc);
        gro.addType(1, gra); gro.addType(1, bug); 
        gro.addType(0, fly); 
        
        // Flying
            // Super effective to Grass, Fighting, Bug
            // Not effective to Electric, Rock
        fly.addType(2, gra); fly.addType(2, fig); fly.addType(2, bug);
        fly.addType(1, ele); fly.addType(1, roc);
        
        // Psychic
            // Super effective to Fighting, Poison
            // Not effective to Psychic
        psy.addType(2, fig); psy.addType(2, poi);
        psy.addType(1, psy);
        
        // Bug
            // Super effective to Grass, Poison, Psychic
            // Not effective to Fire, Fighting, Flying, Ghost
        bug.addType(2, gra); bug.addType(2, poi); bug.addType(2, psy);
        bug.addType(1, fir); bug.addType(1, fig); bug.addType(1, fly); bug.addType(1, gho);
        
        // Rock
            // Super effective to Fire, Ice, Flying, Bug
            // Not effective to Fighting, Ground
        roc.addType(2, fir); roc.addType(2, ice); roc.addType(2, fly); roc.addType(2, bug);
        roc.addType(1, fig); roc.addType(1, gro); 
        
        // Ghost
            // Super effective to Ghost
            // No effect on Normal, Fighting
        gho.addType(2, gho);
        gho.addType(1, nor); gho.addType(1, fig); 
        
        // Dragon
            // Super effective to Dragon
        dra.addType(2, dra); 
        
        /*
        Note when declaring new Monster instances:
        base atk and def are calculated as
        (in-game physical + in-game special) / 2, rounded up
        
        Source for in-game data: Bulbapedia
        */
        
        // SCENARIO 1
        // Adding Monster instances
        Monster m1 = new Monster("Charmander", fir, 39, 56, 47, 65);
        Monster m2 = new Monster("Squirtle", wat, 44, 49, 65, 43);
        
        // Adding Move instances
        Move scratch = new Move("Scratch", nor, 35, 40, 1.00, true);
        Move waterGun = new Move("Water Gun", wat, 25, 40, 1.00, true);
        
        // Adding Moves to Monster's moveset
        m1.addMove(scratch);
        m2.addMove(waterGun);
        
        // SCENARIO 2
        // Adding Item instance
        Item i1 = new Item("Potion", 10);
        
        // Adding Trainer instances
        Trainer t1 = new Trainer("Felize");
        Trainer t2 = new Trainer("Mica");
        
        // Adding Monsters to Trainer's team
        t1.addMonster(m1);
        t2.addMonster(m2);
        
        System.out.printf("%s is a trainer with the Monster %s.%n", t1.getName(), m1.getName());
        System.out.printf("%s is a trainer with the Monster %s.%n", t2.getName(), m2.getName());
        
        System.out.printf("%s is a %s type Monster with the %s type move %s.%n", m1.getName(), fir.getName(), nor.getName(), scratch.getName());
        System.out.printf("%s is a %s type Monster with the %s type move %s.%n", m1.getName(), wat.getName(), wat.getName(), scratch.getName());
        
        System.out.println("\nA BATTLE STARTS!");
        
        System.out.printf("%s challenges %s to a battle!%n", t1.getName(), t2.getName());
        System.out.printf("%s: %s, I choose you!%n", t1.getName(), m1.getName());
        
        // SCENARIO 3
        /*
        For final project, battles will run on a loop until
        all Monsters in Trainer's team have HP 0.
        
        Moves are hard coded as placeholder instead of taking user input.
        */
        
        m1.use(scratch, m2);
        m2.use(waterGun, m1);
        m1.checkHP();
        m2.checkHP();
    }
}