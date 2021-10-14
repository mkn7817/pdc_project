/**
 *Vinnie Limbrick
 * 0831133
 */

package Characters;

import Items.Item;
import java.util.HashSet;
import java.util.Random;

public class Boss extends Character {
    
    private int baseDmg;
    private double accuracy;
    HashSet<Item> items = new HashSet<>(3);
    
    
    public Boss()
    {
        super("unknown", 100, 10);
        this.baseDmg = 10;
        this.accuracy = 0.5;
        
//        items.add(e);
        
    }
    
    public Boss(String name, int maxHP, int lvl, int baseDmg, double accuracy)
    {
        super(name, maxHP, lvl);
        this.baseDmg = baseDmg;
        this.accuracy = accuracy;
        
    }


//    public int attack() {
//        Random rand = new Random();
//        
//        if (rand.nextDouble() > this.getAccuracy())
//        {
//            System.out.println(this.getName()+" missed their shot!");
//            return 0;
//        }
//        else return this.baseDmg;       
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
    public String printStats()
    {
        String str = "";
        str += "Name: "+this.getName()+"\n";
        str += "HP: "+this.getCurrentHP()+"/"+this.getMaxHP()+"\n";
        return str;
    }
    
    public double getAccuracy()
    {
        return this.accuracy;
    }
    
    public int getBaseDmg()
    {
        return this.baseDmg;
    }
    
    public String toString()
    {
        String str = super.getName();
        return str;
    }
    
}
