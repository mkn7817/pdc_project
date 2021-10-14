/**
 *Vinnie Limbrick
 * 0831133
 */
package Items;

//attack item class
public class AttackItem extends Item {
    
    private int attDmg;
    
    public AttackItem(String name, int attDmg)
    {
        super(name);
        this.attDmg = attDmg;
    }
    
    public int getAttDmg()
    {
        return this.attDmg;
    }
    
    @Override
    public String toString()
    {
        return this.getName()+" (deals "+this.getAttDmg()+" dmg to the enemy)";
    }
    
}
