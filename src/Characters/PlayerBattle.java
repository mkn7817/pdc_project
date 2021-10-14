/**
 *Vinnie Limbrick
 * 0831133
 */
package Characters;

import Gameplay.RunGame;
import Items.Ammunition;
import Items.HealItem;
import Items.Item;
import Items.Weapon;
import gamegui.GUI;
import gamegui.GUIManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Player object for battle, contains battle specific methods and access to objects for 
 */
public class PlayerBattle {
    
        Player p;
        Ammunition am;
        Weapon w;
        GUI ui;
        GUIManager gm;
        boolean isAlive = true;
        boolean requestStop = false;

        
        public PlayerBattle(Player p, GUI ui, GUIManager gm)//
        {
            this.p = p;
            this.w = p.getWeapon();
            this.am = w.getAmmunition();
            
            this.ui = ui;
            this.gm = gm;
//            this.bp = p.getBackpack();

        
        }
    
        //method determines damage dealth by attack based on weapon and ammunition objects used by player
        public int attack() {
        Random rand = new Random();
        int shots = 0;
        int turnDmg = 0;
        double accuracy = (p.getDex()+10)/20.0;
        System.out.println(w.getHitsPerTurn());
        while(shots < w.getHitsPerTurn())
        {
        double hitChance = rand.nextDouble();
        double critChance = rand.nextDouble();
        int hitDmg = w.attackDmg()+w.getAmmoDmg();
        if(accuracy > hitChance)
        {
            if(w.getCriticalAmmo() > critChance)
            {
                System.out.println("Bullet fragmented dealing "+2*hitDmg+"!");
                turnDmg += 2*hitDmg;
                shots++;
            }
            else
            {
            System.out.println("You hit them for "+hitDmg);
            turnDmg += hitDmg;
            shots++;
            }
        }
        else 
        {
            System.out.println("You missed!");
            shots++;
        }
        
        }
        System.out.println("You dealt a total of "+turnDmg+" damage!");
        return turnDmg;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        //prints each item from backpack name onto JButtons for itemPanel
        public void openBackpack()
        {
            ArrayList<Item> bp = p.getBackpack();
               for(int i = 0; i < p.getNumItems(); i++)
               {
                   for(int j = i; j < p.getNumItems(); j++)
                   {
                       ui.itemButtonList.get(j).setText(""+p.getItem(j));
                       System.out.println(""+p.getItem(j));
                   }

               }
               gm.displayBackpackPanel();
               ui.frame.repaint();
        }
        
        //clears labels for backpack items after use
        public void clearButtonList()
        {

               for(int i = 0; i < p.getNumItems(); i++)
               {
                    ui.itemButtonList.get(i).setText("");
               }
  
        }
    
        //displays battle commands
        public void displayCommands()
        {
            gm.toggleMultiChoice();
            gm.setMultiChoiceText("Attack", "Use Item", "Defend");
            System.out.println("TEST displayCommands()");
        }
        
        public void playerTurn()
        {
            requestStop = false;
        
        while(!requestStop)
        {
//            displayCommands();
            gm.getInput();
            
            if(ui.getMultiChoiceString().equals("choice1"))
            {
                int i = attack();
                System.out.println("attacked");
                ui.setMultiChoiceString("");
                requestStop = true;
            }
            else if(ui.getMultiChoiceString().equals("choice2"))
            {
                ArrayList<Item> bp = p.getBackpack();
                ui.setMultiChoiceString("");
                openBackpack();
                gm.toggleMultiChoice();
                gm.getInput();
                
                p.consumeItem(ui.itemButtonList.indexOf(ui.getMultiChoiceString()));
                requestStop = true;
                
            }
            else if(ui.getMultiChoiceString().equals("choice3"))
            {
                ui.setMultiChoiceString("");
                p.setDefense(true);
                requestStop = true;
            }
            else requestStop = true;
        }
        System.out.println("Player turn ended");
        }
        
}
