/**
 *Vinnie Limbrick
 * 0831133
 */
package Characters;

import Items.Item;
import Items.Weapon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



public abstract class Character {
    
//    private ArrayList<Item> equipment = new ArrayList<>(6);//backpack array items
    
    private String name;
    private int maxHP;//maximum hit points
    private int currentHP;//current hit ponts
    private int lvl;

    public Character() 
    {
        this.name = "unknown";
        this.maxHP = 100;
        this.currentHP = this.maxHP;
        this.lvl = 0;
    }
    
    public Character(String name, int maxHP, int lvl) 
    {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.lvl = lvl;
    }   
  

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the maxHP
     */
    public int getMaxHP() {
        return maxHP;
    }
    
     public int getCurrentHP() {
        return currentHP;
    }

    /**
     * @param maxHP the maxHP to set
     */
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.currentHP = hp;
    }

     /**
     * @return the lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * @param lvl the lvl to set
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    

    

    
}
