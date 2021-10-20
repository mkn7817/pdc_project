/**
 *Vinnie Limbrick
 * 0831133
 */
package Items;

public class Weapon extends Item {
    /*
    smg-3 hits low dmg
    assault 2 hits medium dmg
    sniper 1 hit high dmg
    */
    private String weaponType;//"9x19"(smg), "5.56x45"(assault rifle), "7.62x51"(sniper rifle)
    private String weaponCaliber;
    private int hitsPerTurn;
    private int baseDmg;
    private Ammunition ammo;//ammunition loaded into gun
    
    public Weapon()
    {
        super("Bare hands");
        this.weaponType = "Melee";
        this.baseDmg = 50;
    }
    
    public Weapon(String name, String weaponType, int baseDmg, String weaponCaliber, int hitsPerTurn)
    {
        super(name);
        this.weaponType = weaponType;
        this.baseDmg = baseDmg;
        this.hitsPerTurn = hitsPerTurn;
        this.weaponCaliber = weaponCaliber;
    }
    
    //add ammunition object to weapon
    public void addAmmunition(Ammunition ammo)
    {
        this.setAmmo(ammo);
    }
    
    //returns ammunition object currently held by weapon
    public Ammunition getAmmunition()
    {
        return this.ammo;
    }
    
    //returns type of Ammunition (caliber)
    public String getAmmoType()
    {
        return this.ammo.getAmmoType();
    }
    
    //returns ammo code (HP, FMJ, AP)
    public String getAmmoCode()
    {
        return ammo.getAmmoCode();
    }
    
    //remove ammunition object from weapon
    public void removeAmmo()
    {
        this.ammo = null;
    }
    
    //returns number of hits per turn a weapon makes for battle
    public int getHitsPerTurn()
    {
        return this.hitsPerTurn;
    }
    
    @Override
    public String toString() {
        String str = "Weapon model: " + this.getName() + ", Base damage = " + getBaseDmg();
        if (ammo != null)
        {
            str +=", ammunition type = "+ammo;
        }
        return str;
//        return "Weapon model: " + this.getName() + ", Base damage = " + getBaseDmg() + ", ammunition type = " + ammo;
    }

    //returns damage as combination of weapon and ammunition objects
    public int attackDmg()
    {
        int attackDmg = 0;
        attackDmg = (baseDmg+ammo.getAmmoDmg());
        
        return attackDmg;
    }

    //returns weapon type
    public String getWeaponType() {
        return weaponType;
    }
    
    //returns frag chance of Ammunition object
    public double getCriticalAmmo()
    {
        return ammo.getCritical();
    }

    /**
     * @param weaponType the weaponType to set
     */
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
    
    //returns the dmg multiplier from ammo
    public int getAmmoDmg()
    {
        return ammo.getAmmoDmg();
    }
    
    /**
     * @return the baseDmg
     */
    public int getBaseDmg() {
        return baseDmg;
    }

    /**
     * @param baseDmg the baseDmg to set
     */
    public void setBaseDmg(int baseDmg) {
        this.baseDmg = baseDmg;
    }

    /**
     * @return the ammo
     */
    
    /**
     * @param ammo the ammo to set
     */
    public void setAmmo(Ammunition ammo) {
        this.ammo = ammo;
    }
    
    

    
}
