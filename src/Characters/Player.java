/**
 *Vinnie Limbrick
 * 0831133
 */
package Characters;


import Items.Weapon;
import Items.Ammunition;
import Items.Item;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Player extends Character {


    Random rand = new Random();
    
    private int str;//strength - affects melee damage
    private int dex;//dexterity - affects accuracy and evasion
    private Weapon weapon;
    private ArrayList<Item> backpack = new ArrayList<>(6);//array for storing items size 6
    private boolean defense;
    private boolean isAlive;

    public Player()
    {
        super();
        this.str = 5;
        this.dex = 5;
        this.defense = false;
        this.isAlive = true;
    }
    
    public Player(String name, int maxHP, int lvl, int str, int dex)
    {
        super(name, maxHP, lvl);
        this.str = str;
        this.dex = dex;
        this.defense = false;
        this.isAlive = true;
    }
    
    public ArrayList getBackpack()
    {
        return this.backpack;
    }
    
    public String getAmmoCode()
    {
        return weapon.getAmmoCode();
    }
    
    public String getAmmoType()
    {
        return weapon.getAmmoType();
    }
    
    public void setDefense(boolean b)
    {
        this.defense = b;
    }
    
    public boolean getDefense()
    {
        return this.defense;
    }
    
    //prints all equipment held by player
    public String listEquipment()
    {
        Iterator<Item> it = backpack.iterator();
        int ind = 1;
        String str = "";
        while(it.hasNext())
        {
            str += ind+". "+it.next()+"\n";
            ind++;
        }
        System.out.println(str);
        return str;
    }
    
    //returns number of items in backpack arraylist
    public int getNumItems()
    {
        return backpack.size();
    }
    
    //return item based on index from backpack
    public Item getItem(int i)
    {
        return backpack.get(i);
    }
    

    //remove item from backpack arraylist after use
    public void consumeItem(int index)
    {
        System.out.println("You used "+backpack.get(index));
        backpack.remove(index);
    }
    
    //
    public int getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(int str) {
        this.str = str;
    }

    /**
     * @return the dex
     */
    public int getDex() {
        return dex;
    }

    /**
     * @param dex the dex to set
     */
    public void setDex(int dex) {
        this.dex = dex;
    }
    
    //print player stats to console
    public String printStats()
    {
        String str = "";
        str += "Name: "+this.getName()+"\n";
        str += "HP: "+this.getCurrentHP()+"/"+this.getMaxHP()+"\n";
//        str += "Dexterity: "+this.getDex()+"\n";
//        str += "Strength: "+this.getStr()+"\n";
//        str+= "Weapon: "+this.getWeapon()+"\n";
        return str;
    }
    
    //returns weapon name
    public String getWeaponName()
    {
        return this.weapon.getName();
    }
    
//    returns weapon object equipped by the player
    public Weapon getWeapon()
    {
        return this.weapon;
    }
    
    //set weapon object
    public void setWeapon(Weapon w)
    {
        this.weapon = w;
    }
   
    
    //returns number of shots taken by weapon each attack turn
    public int weaponHitsPerTurn()
    {
        return weapon.getHitsPerTurn();
    }
        
    //set ammo method within Player class to change ammo object within players weapon object
    public void setAmmo(Ammunition a)
    {
        this.weapon.setAmmo(a);
    }
    
    //adds item into backpack equipment array
    public void addItemObject(Item i)
    {
        backpack.add(i);
        System.out.println(i.getName()+" added to your backpack!");
    }
    
    public boolean isAlive()
    {
        return this.isAlive;
    }
    
    //checks player has HP left, sets isAlive to false if not
    public void setIsAlive()
    {
        if(this.getCurrentHP() <= 0)
            this.isAlive = false;
    }
    

    
    @Override
    public String toString() {
        String str1 = "Character name: "+this.getName()+"\n"+this.getCurrentHP()+"/"+this.getMaxHP()+" hit points\n"+"Level "+getLvl()+"\nEquiped: "+this.getWeapon()+" loaded with "+this.getAmmoType();
        
        return str1;
    }
       
}
