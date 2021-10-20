/**
 *Vinnie Limbrick
 * 0831133
 */
package Items;

//HealItem class for healing objects
public class HealItem extends Item {
    
    private int hpRecovery;
    
    public HealItem(String name, int hpRecovery)
    {
        super(name);
        this.hpRecovery = hpRecovery;
    }
    
    public String toString()
    {
        String str = ""+getName()+" (increase HP by "+getHpRecovery()+")";
        return str;
    }

    //returns amount to recover HP in Battle
    public int getHpRecovery() {
        return hpRecovery;
    }

    //set HP recovery amount
    public void setHpRecovery(int hpRecovery) {
        this.hpRecovery = hpRecovery;
    }
}
