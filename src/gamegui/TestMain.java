/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

import Characters.Boss;
import Characters.Player;
import Gameplay.Battle;
import static Gameplay.GameSequence.bossNumber;
import Items.AmmoDBManager;
import Items.AmmoDBOperations;
import Items.Ammunition;
import Items.AmmunitionDBMap;
import Items.AmmunitionMap;
import Items.AttackItem;
import Items.HealItem;
import Items.Item;
import Items.Weapon;
import java.io.IOException;

/**
 *
 * @author User
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
//        Player p = new Player("V", 1000, 10, 10, 10);
//        Item gren = new AttackItem("gren", 100);
//        p.addItemObject(gren);
//        p.addItemObject(gren);
//        Weapon w = new Weapon("weapon", "type", 1, "cal", 1);
////        Ammunition am = new Ammunition("type", "code", 50, 0.5);
////        w.addAmmunition(am);
//        p.setWeapon(w);
//        
//        AmmunitionMap am = new AmmunitionMap();
//        Ammunition ammo;
//        am.populateAmmoMapAr();
//        
//        ammo = am.getAmmo("AP");
//        
//        
//        System.out.println(ammo.getAmmoCode());
        
        
        
        AmmoDBManager adbm = new AmmoDBManager();
        AmmoDBOperations adbo = new AmmoDBOperations();
        
        adbo.createTableSmg();
        
        AmmunitionDBMap ammap = new AmmunitionDBMap();
        ammap.getSmgAmmo();
        
/*
        ChoiceListener cl = new ChoiceListener();//listener class for UI interactions
        GUI ui = new GUI(cl);//GUI class takes in listener class
        cl.getUI(ui);
        GUIManager gm = new GUIManager(ui);//Manager takes GUI object
        
        
        gm.displayBattleCommands();
        gm.toggleBattleScreen();
        gm.toggleMultiChoice();
        
//        String str = "";
//        if(str.isEmpty())
//            System.out.println("empty");
//        
//        ui.setMultiChoiceString(null);
//        if(ui.getMultiChoiceString().isEmpty())
//            System.out.println("3");
//        ui.setMultiChoiceString("STRING!1");
//        ui.getMultiChoiceString();
//        if(ui.getMultiChoiceString().equalsIgnoreCase("STRING!1"))
//            System.out.println("1");
//        if(ui.getMultiChoiceString().equals("STRING!1"))
//            System.out.println("2");
        
        AttackItem ai = new AttackItem("grenade", 100);
        HealItem hi = new HealItem("first aid", 100);

        
//        if(ai instanceof AttackItem)
//        {
//            System.out.println("attack item");
//        }
//        System.out.println(ai.getClass());
        
        
        Player p = new Player("V", 1000, 10, 10, 10);
        Item gren = new AttackItem("gren", 100);
        p.addItemObject(gren);
        p.addItemObject(gren);
        Weapon w = new Weapon("weapon", "type", 1, "cal", 1);
        Ammunition am = new Ammunition("type", "code", 50, 0.5);
        w.addAmmunition(am);
        p.setWeapon(w);
        Boss b = new Boss("B", 1100, 30, 10, 10);
        Battle ba1 = new Battle(p, b, ui, gm);
        ba1.runBattle2();
//        while(true)
//            System.out.println(ui.getMultiChoiceString());
//        gm.displayBattleCommands();
//        ui.button1.setText("TEXT");
//        gm.toggleTextField();
//        
//        gm.displayBackpackPanel();
    */    
    }
    
}
