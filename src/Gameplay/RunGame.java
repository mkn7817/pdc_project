/**
 *Vinnie Limbrick
 * 0831133
 */
package Gameplay;

import Characters.Boss;
import Characters.BossList;
import Characters.CreateCharacter;
import Characters.Player;
import Items.AttackItem;
import Items.HealItem;
import gamegui.GUI;
import gamegui.GameGUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * this class provides game logic to perform tasks
 */
public class RunGame {
    
    static Scanner scan = new Scanner(System.in);
    
    //returns int value for multi-choice options in game
    public static int readInput(String prompt, int userChoices)// throws InputMismatchException
    {
        int input;
        do{
        System.out.println(prompt);
        try{
        input = scan.nextInt();
        }catch(InputMismatchException e){
            input = -1;
            System.out.println("Please enter a valid integer");
            scan.next();
        }
        }while(input < 1 || input > userChoices);
        return input;
    }
    
    public static void printTitle(String title)
    {
        for(int i = 0; i < 20; i++)
            System.out.print("-");
        System.out.println();
        System.out.println(title);
    }
    
    //prints number of lines to clear clutter from java console
    public static void clearConsole()
    {
        for(int i = 0; i < 30; i++)
        {
            System.out.println();
        }
    }
    
    public static void pressContinue()
    {
        System.out.println("Enter anything to continue");
        scan.nextLine();
    }
    
    public static void initialItems(Player p)
    {
        int pChoice1;
        int pChoice2 = 0;
        
        String choice1 = "First Aid Kit";
        String choice2 = "F1 Grenade";
        
        
        HealItem fKit = new HealItem(choice1, 30);
        AttackItem f1Grenade = new AttackItem(choice2, 60);
        
        

            System.out.println("Welcome, "+p.getName()+". Please select two items you wish to take with you. Enter the respective number and hit enter.");
            System.out.print("1. First Aid Kit\n2. F1 Grenade\n");
            try{
            pChoice1 = scan.nextInt();
            }catch(InputMismatchException e)
            {
                pChoice1 = 0;
                System.out.println("Please enter a valid integer");
                scan.next();
            }
            if(pChoice1 ==1)
            {
                p.addItemObject(fKit);
                System.out.println("Please choose another item to put into your backpack");
                System.out.print("1. "+choice1+"\n2. "+choice2+"\n");
                pChoice2 = scan.nextInt();
                if(pChoice2 == 1)
                {
                    p.addItemObject(fKit);
//                    System.out.println("Grenade added to your backpack");
                }
                else if(pChoice2 == 2)
                {
                    p.addItemObject(f1Grenade);
//                    System.out.println("Bunker Key added to your backpack");
                }
            }
            else if (pChoice1 == 2)
            {
                p.addItemObject(f1Grenade);
                System.out.println("Please choose another item to put into your backpack");
                System.out.print("1. "+choice1+"\n2. "+choice2+"\n");
                pChoice2 = scan.nextInt();
                if(pChoice2 == 1)
                {
                    p.addItemObject(fKit);
//                    System.out.println("First Aid Kit added to your backpack");
                }
                else if(pChoice2 == 2)
                {
                    p.addItemObject(f1Grenade);
//                    System.out.println("Bunker Key added to your backpack");
                }
            }
            
    }
    
        
    public static void bossArray()
    {
      ArrayList bossList = new ArrayList();
      Boss boss1 = new Boss("Nurmass", 99, 10, 12, 0.7);
      Boss boss2 = new Boss("Opatchki", 120, 10, 42, 0.33);
      Boss boss3 = new Boss("CyBly", 150, 10, 28, 0.6);
      bossList.add(boss1);
      bossList.add(boss2);
      bossList.add(boss3);
      
      Iterator<Boss> it = bossList.iterator();
      while(it.hasNext())
      {
          System.out.println(it.next());
      }
      
      PriorityQueue bossQueue = new PriorityQueue<Boss>();
      bossQueue.add(boss1);
      
    }

    
}
