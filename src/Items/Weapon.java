/**
 *Vinnie Limbrick
 * 0831133
 */
package Items;

public class Weapon extends Item {
    /*
    melee-one hit negates armour
    smg-3 hits, low pen low dmg
    assault 2 hits medium pen
    sniper 1 hit hit pen high dmg
    */
    private String weaponType;//"melee"(melee), "9x19"(smg), "5.56x45"(assault rifle), "7.62x51"(sniper rifle)
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
    }
    
    public void addAmmunition(Ammunition ammo)
    {
        this.setAmmo(ammo);
    }
    
    public Ammunition getAmmunition()
    {
        return this.ammo;
    }
    
    public String getAmmoType()
    {
        return this.ammo.getAmmoType();
    }
    
    public String getAmmoCode()
    {
        return ammo.getAmmoCode();
    }
    
    public void removeAmmo()
    {
        this.ammo = null;
    }
    
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

    public int attackDmg()
    {
        int attackDmg = 0;
        attackDmg = (baseDmg+ammo.getAmmoDmg());
        
        return attackDmg;
    }

    
    /**
     * @return the weaponType
     */
    public String getWeaponType() {
        return weaponType;
    }
    
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
