/**
 *Vinnie Limbrick
 * 0831133
 */
package Items;

import java.util.Random;

public class Ammunition {

   //ammo must be "none"(melee), "9x19"(smg), "5.56x45"(assault rifle), "7.62x51"(sniper rifle)
    private String ammoType;//ammo caliber
    private String ammoCode;//"HP" hollow point, high base low pen, "FMJ" full metal jacket medium base medium pen, "AP" armour piercing lower dmg higher pen
    private int ammoDmg;//base damage per bullet
    private int penetration;//armour penetration
    private double critical;//fragmentation chance of bullet 
    
        public Ammunition() {
        this.ammoType = "Unknown";
        this.ammoDmg = 1;
        this.critical = 0.0;
        this.ammoCode = "";
        }
        
    
        public Ammunition(String ammoType, String ammoCode, int ammoDmg, double critical){
        this.ammoType = ammoType;
        this.ammoDmg = ammoDmg;
        this.critical = critical;
        this.ammoCode = ammoCode;
        
    }
    
    //determines bullet fragmentation/critical hit
    public boolean fragmentation(double critical)
    {
        Random rand = new Random();
        int fragChance;
        fragChance = rand.nextInt(10)+1;
        if((double)fragChance/10 < critical)
        {
        return true;
        }
        else return false;
    }
        
    public String toString()
    {
        String str = getAmmoType()+" "+getAmmoCode();
        
        return str;
    }
    
     public String getAmmoCode() {
        return ammoCode;
    }
    
    public void setAmmoCode(String ammoCode) {
        this.ammoCode = ammoCode;
    }
     
    /**
     * @return the ammoType
     */
    public String getAmmoType() {
        return ammoType;
    }

    /**
     * @param ammoType the ammoType to set
     */
    public void setAmmoType(String ammoType) {
        this.ammoType = ammoType;
    }

    /**
     * @return the baseDmg
     */
    public int getAmmoDmg() {
        return ammoDmg;
    }

    /**
     * @param baseDmg the baseDmg to set
     */
    public void setAmmoDmg(int ammoDmg) {
        this.ammoDmg = ammoDmg;
    }

    /**
     * @return the penetration
     */
    public int getPenetration() {
        return penetration;
    }

    /**
     * @param penetration the penetration to set
     */
    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    /**
     * @return the critical
     */
    public double getCritical() {
        return critical;
    }

    /**
     * @param critcal the critical to set
     */
    public void setCritcal(double critcal) {
        this.critical = critical;
    }
    
}
