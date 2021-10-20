/**
 *Vinnie Limbrick
 * 0831133
 */
package Gameplay;

import Characters.Boss;
import Characters.Player;
import Characters.PlayerBattle;
import Items.AttackItem;
import Items.HealItem;
import Items.Item;
import gamegui.GUI;
import gamegui.GUIManager;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;

//Battle class to handle turn based combat
public class Battle {
    
    Player p;
    Boss b;
    GUI ui;
    GUIManager gm;
    //counters for stat tracking and balance adjustment on analytics
    public static int count;//counter for number of battles in game
    public static int damageReceived;//keeps track of damage received sum
    public static int damageInflicted;//sum of damage dealt by player
    public static int playerMisses;//sum of player attacks that miss
    public static int aiMisses;//boss attacks that miss
    
    
    public Battle()
    {
        ;
    }
    
    public Battle(Player p, Boss b, GUI ui, GUIManager gm)//, 
    {
        this.p = p;
        this.b = b;
        this.ui = ui;
        this.gm = gm;
     
    }
    
    public void runBattle2()
    {
        count++;
        
        gm.displayBattleCommands();
        gm.toggleBattleScreen();
        PlayerBattle ba = new PlayerBattle(p, ui, gm);
        Random rand = new Random();
        boolean bIsAlive = true;
        boolean pIsAlive = true;
        gm.updateBossGUI(b.getName(), b.getCurrentHP());

        do{
            boolean requestStop = false;

        while(!requestStop)
        {
            ui.addToText("Select your action");
            if(pIsAlive == true){
            gm.getInput();
            
            if(ui.getMultiChoiceString().equals("choice1"))
            {
                int i = ba.attack();
                ui.addToText("You dealt "+i+" damage in "+p.weaponHitsPerTurn()+" hits");
                damageInflicted+=i;
                b.setHp(b.getCurrentHP() - i);
                if(b.getCurrentHP() < 0)
                    b.setHp(0);
                gm.updateBossGUI(b.getName(), b.getCurrentHP());
                ui.setMultiChoiceString("");
                if(i == 0)
                    playerMisses++;
                requestStop = true;
            }
            else if(ui.getMultiChoiceString().equals("choice2") && p.getNumItems() != 0)
            {
                ArrayList<Item> bp = p.getBackpack();
                Item i;
//                int itemIdex;
                ui.setMultiChoiceString("");
                ba.openBackpack();
                gm.toggleMultiChoice();
                gm.getInput();
                ba.clearButtonList();

                i = p.getItem(ui.itemButtonList.indexOf(ui.getMultiChoiceString())+1);

                p.consumeItem(ui.itemButtonList.indexOf(ui.getMultiChoiceString())+1);
                if(i instanceof HealItem)
                {
                    p.setHp(p.getCurrentHP()+((HealItem) i).getHpRecovery());
                    if(p.getCurrentHP() > p.getMaxHP())
                        p.setHp(p.getMaxHP());
                }
                if(i instanceof AttackItem)
                {
                    b.setHp(b.getCurrentHP() - ((AttackItem) i).getAttDmg());
                }
                
                gm.toggleMultiChoice();
                ui.itemPanel.setVisible(false);
                
                
                
                ui.setMultiChoiceString("");
                requestStop = true;
                gm.updatePlayerDetails(p);
                gm.updateBossGUI(b.getName(), b.getCurrentHP());
            }
            else if(ui.getMultiChoiceString().equals("choice3"))
            {
                ui.addToText("You defended");
                ui.setMultiChoiceString("");
                p.setDefense(true);
                requestStop = true;
            }
            else requestStop = true;
        }
        }

        if(b.getCurrentHP() <= 0)
        {
            bIsAlive = false;
        }
        
        //boss turn
        if(bIsAlive)
        {
            double accCheck = rand.nextDouble();//accuracy random for miss or hit
            double grenadeThrow = rand.nextDouble();//chance for boss to use special attack
            ui.addToText("The boss attacks");
        
        if(b.getCurrentHP() < 0.2*b.getMaxHP())
        {
            ui.addToText("They healed");
            b.setHp(b.getCurrentHP() + 30);
            gm.updateBossGUI(b.getName(), b.getCurrentHP());
        }
        else if(grenadeThrow < 0.1)
        {

            if(p.getDefense() == true)
            {
                p.setHp(p.getCurrentHP() - 30);
                if(p.getCurrentHP()< 0)
                    p.setHp(0);
                gm.updatePlayerDetails(p);
                damageReceived += 30;
            ui.addToText("They throw a grenade dealing 30 damage");
            }
            else
            {
                p.setHp(p.getCurrentHP() - 60);
                if(p.getCurrentHP()< 0)
                    p.setHp(0);
                gm.updatePlayerDetails(p);
                ui.addToText("They throw a grenade dealing 60 damage");
                damageReceived += 60;
            }
        }
        else
        {
            ui.setTextArea("They fire a shot");
            if(b.getAccuracy() > accCheck)
            {
                if(p.getDefense() == true){
                ui.addToText("The shot hits you dealing "+(b.getBaseDmg()/2)+" damage");
                p.setHp(p.getCurrentHP() - (b.getBaseDmg()/2));
                if(p.getCurrentHP()< 0)
                    p.setHp(0);
                gm.updatePlayerDetails(p);
                damageReceived += b.getBaseDmg();
                }
                else {
                ui.addToText("The shot hits you dealing "+(b.getBaseDmg())+" damage");
                p.setHp(p.getCurrentHP() - (b.getBaseDmg()));
                if(p.getCurrentHP()< 0)
                    p.setHp(0);
                gm.updatePlayerDetails(p);
                damageReceived += b.getBaseDmg();
                }
            }
            else ui.addToText("The shot misses"); aiMisses++;
        }
        if(p.getCurrentHP() <= 0)
        {
            pIsAlive = false;
            p.setIsAlive();
            requestStop = true;
        }
        }

        

        
       }while(bIsAlive && pIsAlive);
        if(!bIsAlive)
        {
            ui.setTextArea(b.getName()+" has been defeated!");
        }
        if(!p.isAlive())
        {
            ui.setTextArea("You lost the battle");
        }
        gm.toggleMultiChoice();
        ui.addToText("Enter any text and click confirm to continue");
        boolean flag = true;
        ui.setTextFieldString("");
        while(flag)
        {
            gm.getInputConfirm();
            if(!ui.getTextFieldString().equals(""))
            {
               flag = false;
            }
        }
        gm.toggleBattleScreen();

    }

}
