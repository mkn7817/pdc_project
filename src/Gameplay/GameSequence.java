/**
 *Vinnie Limbrick
 * 0831133
 */
package Gameplay;

import Characters.BossList;
import Characters.CreateCharacter;
import Characters.Player;
import static Gameplay.RunGame.clearConsole;
import static Gameplay.RunGame.initialItems;
import static Gameplay.RunGame.pressContinue;
//import database.AmmunitionMap;
import Items.HealItem;
import database.AmmoDBManager;
import database.AmmoDBOperations;
import database.AmmunitionDBMap;
import gamegui.ChoiceListener;
import gamegui.GUI;
import gamegui.GUIManager;
//import Items.Item;
import java.io.IOException;
import java.util.InputMismatchException;
//import java.util.Random;
import java.util.Scanner;


public class GameSequence {
    
    public static int bossNumber = 0;
    
    public static void woodsFirstPhase(Player p, GUI ui, GUIManager gm)
    {
//        Thread thread = new Thread();
        Scanner scan = new Scanner(System.in);
        int numberGuess;
        int numberGuessGui = 0;
//        int numberGuessGui2 = numberGuessGui;
        boolean guessFlag = true;
        int guesses = 0;
        boolean cont1 = false;
        
        
        gm.displayWoods();
        gm.toggleMultiChoice();
        gm.toggleTextField();
        ui.setTextFieldString("0");

        
//        System.out.println("Walking into the woods you come across a strange figure.");
//        System.out.println("He asks: 'What number comes next in the following sequence? 1, 2, 3, 5, 8, 13.'");
        
        ui.textBox.setText("Walking into the woods you come across a strange figure.\nHe asks: 'What number comes next in the following sequence? 1, 2, 3, 5, 8, 13.'\nEnter your guess into the text box and press confirm");
        
        do{
        
        while(guessFlag == true && guesses < 3)
            try{
                
        numberGuessGui = Integer.parseInt(ui.getTextFieldString());
        gm.getInputConfirm();
        guesses++;
        try{
        numberGuessGui = Integer.parseInt(ui.getTextFieldString());
        } catch (NumberFormatException e)
        {
            ui.addToText("Please enter a valid number");
        }

        numberGuess = numberGuessGui;
        if(numberGuess == 21)
        {
            HealItem fa = new HealItem("First Aid Kit", 30);
            ui.addToText("Yes, you are correct. Here, take an extra First Aid Kit.");
            p.addItemObject(fa);
            guessFlag = false;
            cont1 = true;
            break;
        }
        else if(numberGuess != 21)
        {
            System.out.println("Sorry, your answer is incorrect1");
            cont1 = true;
        }
        }catch(InputMismatchException e)
        {
            System.out.println("Sorry, your answer is incorrect2");
            guesses++;
        }
        
        if(guesses > 3)
        {
            System.out.println("You have failed my test.");
            ui.addToText("You have failed the test");
            guessFlag = false;
            cont1 = false;
            break;
        }
        
        }while(!cont1);
        //continue prompt
        ui.addToText("Enter any text and click confirm to continue");
        boolean flag = true;
        while(flag)
        {
            gm.getInputConfirm();
            if(!ui.getTextFieldString().equals("")){
                
                flag = false;
                System.out.println(flag+"flag");
                ui.setTextFieldString("");
            }
        }
    }
    
    public static void woodsSecondPhase(Player p, GUI ui, GUIManager gm, AmmunitionDBMap am) throws IOException
    {

        boolean cont2 = false;//continue condition second loop

        ui.setMultiChoiceString("0");

        ui.textBox.setText("You approach a wooden shack.The Shack appears to be locked with a keypad.\nOn the wall next to the door there is a poster that reads: 16 06 68 XX XX 98\nA note above the keypad says: solve the missing numbers (hint look at numbers upside down) \nand enter the 4 digit code in the keypad to enter\n");
        ui.addToText("Enter numbers into text field and click confirm");
        gm.getInputConfirm();
        
        
        if(ui.getTextFieldString().equalsIgnoreCase("8788"))
        {
            ui.setTextFieldString("0");
            ui.textBox.setText("The door unlocks. Inside you find a pack of FMJ ammunition\nDo you wish to switch to the FMJ ammunition?\n1. Yes\n2. No");
            gm.toggleMultiChoice();
            gm.toggleTextField();
            gm.setMultiChoiceText("Yes", "No", "");
            ui.setMultiChoiceString("");
                
            while(!cont2)
            {

                gm.getInput();
                if(ui.getMultiChoiceString().equals("choice1"))
                {
                    p.setAmmo(am.getAmmo("FMJ"));
                    gm.updatePlayerGUI(p);
                    cont2 = true;
                    break;
                }
                else if(ui.getMultiChoiceString().equals("choice2"))
                {
                    cont2 = true;
                }
                    
            }
            gm.updatePlayerDetails(p);
        }
        else
        {
            gm.toggleMultiChoice();
            gm.toggleTextField();
        }

    }
    
    
    public static void woodsThirdPhase(Player p, BossList b, ConsumableItems c, GUI ui, GUIManager gm)
    {
            ui.setMultiChoiceString("");
            gm.displayBattleCommands();
            gm.toggleTextField();

        ui.setTextArea("You have encountered the Woods boss!");
        Battle ba1 = new Battle(p, b.getNextBoss(bossNumber), ui, gm);
        bossNumber++;
        ba1.runBattle2();
     }
    
    
    public static void reserveFirstPhase(Player p, ConsumableItems ci, GUI ui, GUIManager gm)
    {
        ui.setTextArea("Upon entering the reserve you notice a large barrack building\nLying on the ground you find an item\nEnter any text and click confirm to continue");
        ui.setTextFieldString("");
        
        p.addItemObject(ci.getRandomItem());
        boolean flag = true;
        while(flag)
        {
            gm.getInputConfirm();
            if(!ui.getTextFieldString().equals("")){
                
                flag = false;
            }
        }
        
    }
    
    public static void reserveSecondPhase(Player p, GUI ui, GUIManager gm)
    {
        ui.setTextArea("You get to a large bunker door that has a red and blue wire. You must cut the correct wire to safely unlock the door");
        
        gm.toggleMultiChoice();
        gm.setMultiChoiceText("Cut red", "Cut blue", "");
        ui.setMultiChoiceString("");
        
        gm.getInput();
        

        if(ui.getMultiChoiceString().equals("choice1"))
        {
            ui.addToText("There is a small explosion that deals some damage to you, however the door is now passable");
            p.setHp(p.getCurrentHP() - 50);
            gm.updatePlayerDetails(p);
        }
        else if(ui.getMultiChoiceString().equals("choice2"))
        {
            ui.addToText("The door safely opens and you pass through");
        }

        ui.addToText("Click confrim to continue");
        ui.setTextFieldString("");
        
        gm.getInputConfirm();
                
    }
     
     public static void reserveThirdPhase(Player p, BossList b, ConsumableItems ci, GUI ui, GUIManager gm)
    {
        ui.setTextArea("You encounter the Reserve Boss");
        Battle ba3 = new Battle(p, b.getNextBoss(bossNumber), ui, gm);
        ba3.runBattle2();
        bossNumber++;
    }
     
     public static void runLab(Player p, BossList b, GUI ui, GUIManager gm, AmmunitionDBMap aM)
     {
         gm.backgroundLab();
         
        //set condintions to take input
        ui.setTextArea("You find an ammunition box outside the laboratory\nWould you like to swap to AP ammunition?");
        gm.setMultiChoiceText("Yes", "No", "");
        gm.toggleMultiChoice();
        ui.setMultiChoiceString("");

        gm.getInput();
        if(ui.getMultiChoiceString().equals("choice1"))
        {
            p.setAmmo(aM.getAmmo("AP"));
            ui.addToText("You equipped the AP ammo");
            gm.updatePlayerGUI(p);
        }
        
        //continue prompt
        ui.addToText("Click confrim to continue");
        ui.setTextFieldString("");
        gm.getInputConfirm();

        ui.addToText("Upon reaching the lab you are greated by the lab Boss");
        
        Battle ba4 = new Battle(p, b.getNextBoss(bossNumber), ui, gm);
        bossNumber++;
        ba4.runBattle2();

     }
    
    public static void runSequence() throws IOException, InterruptedException
    {
        //game loop condition for game over
        boolean game = true;
       
        //create database objects
        AmmoDBManager adbm = new AmmoDBManager();
        AmmoDBOperations adbo = new AmmoDBOperations();
        
        //create ammunition tables for constructor input
        adbo.createTableSmg();
        adbo.createTableAr();
        adbo.createTableSr();
        
        //
        AmmunitionDBMap amSmg = new AmmunitionDBMap();
        AmmunitionDBMap amAr = new AmmunitionDBMap();
        AmmunitionDBMap amSr = new AmmunitionDBMap();
        
        //add ammo from databass into HashMap
        amSmg.getSmgAmmo();
        amAr.getArAmmo();
        amSr.getSrAmmo();
        
        //instantiate consumable items for input as reward for boss battles
        ConsumableItems ci = new ConsumableItems();
        ci.populateFromText();
        
        //create GUI, Listner and GUI manager objects
        ChoiceListener cl = new ChoiceListener();//listener class for UI interactions
        GUI ui = new GUI(cl);//GUI class takes in listener class
        cl.getUI(ui);
        GUIManager gm = new GUIManager(ui);//Manager takes GUI object
        
        
        
        ui.backgroundStart();
        
        
        Player p = new Player("", 99, 5, 5, 5);//instantiate with default starting stats;
        CreateCharacter c1 = new CreateCharacter(p, ui, gm);//run through character creation method
        
        BossList b = new BossList();
        b.populateBossList();
        
        while(p.isAlive() && game == true){
        ui.setReset(false);
        
        woodsFirstPhase(p, ui, gm);
        
        if(p.getAmmoType().equalsIgnoreCase("9x19"))
        {
            woodsSecondPhase(p, ui, gm, amSmg);
        }
        else if(p.getAmmoType().equalsIgnoreCase("5.45x39"))
        {
           woodsSecondPhase(p, ui, gm, amAr); 
        }
        else if(p.getAmmoType().equalsIgnoreCase("7.62x51"))
        {
            woodsSecondPhase(p, ui, gm, amSr);
        }
        else
        {
            woodsSecondPhase(p, ui, gm, amSmg);
        }
        
        gm.displayBattleCommands();
        woodsThirdPhase(p, b, ci, ui, gm);
        
        //check player is alive to continue loop
        if(!p.isAlive())
            break;
        
        //set reserve background on GUI
        gm.displayReserve();

            reserveFirstPhase(p, ci, ui, gm);
            reserveSecondPhase(p, ui, gm);
            reserveThirdPhase(p, b, ci, ui, gm);
        
        //check player is alive to continue loop
        if(!p.isAlive())
            break;
        
        if(p.getAmmoType().equalsIgnoreCase("9x19"))
        {
        runLab(p, b, ui, gm, amSmg);
        }
        else if(p.getAmmoType().equalsIgnoreCase("5.45x39"))
        {
        runLab(p, b, ui, gm, amAr);  
        }
        else if(p.getAmmoType().equalsIgnoreCase("7.62x51"))
        {
        runLab(p, b, ui, gm, amSr);  
        }
        else runLab(p, b, ui, gm, amSmg);
        
        ui.setTextArea("Congratulations, you have finished my game.");
        game = false;
    }
        if(!p.isAlive())
            ui.setTextArea("Game Over: You died...");
        
        ui.addToText("Click confrim to exit");
        ui.addToText(Battle.count+" battles fought");
        ui.setTextFieldString("");
        
        BattleRecord br = new BattleRecord(p);
        br.addToLog();
        gm.getInputConfirm();
        System.exit(0);
    }
    
    
}
