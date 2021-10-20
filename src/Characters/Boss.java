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
    
    public String printStats()
    {
        String str = "";
        str += "Name: "+this.getName()+"\n";
        str += "HP: "+this.getCurrentHP()+"/"+this.getMaxHP()+"\n";
        return str;
    }
    
    //returns boss accuracy for hit or miss in battle
    public double getAccuracy()
    {
        return this.accuracy;
    }
    
    //returns damage amount boss does in battle
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
