/**
 *Vinnie Limbrick
 * 0831133
 */
package Characters;

import Gameplay.RunGame;
import Items.Ammunition;
import Items.Weapon;
import gamegui.ChoiceListener;
import gamegui.GUI;
import gamegui.GUIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;

/**
 * CreateCharacter object to prompt user input in selecting weapon for beginning of game
 */
public class CreateCharacter {
    
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    String nameInput;
    
    int process = 0;

    
    //create character object from player object
    public CreateCharacter(Player p, GUI ui, GUIManager gm)
    {

    String weapChoice = null;
    boolean cont1 = false;
    boolean cont2 = false;
    do{
    nameInput = ui.getTextFieldString();
    ui.textBox.setText("Please enter your name and click confirm");
    if(nameInput != null)
        cont1 = true;
    } while(!cont1);
    
    ui.textField.setText("0");
    ui.setTextFieldString(null);
//    ui.playerName.setText(nameInput);
//    ui.playerHP.setText(p.getCurrentHP()+"/"+p.getMaxHP()+" Hit Points");


    System.out.println(nameInput);

    p.setStr(rand.nextInt(9)+1);
    p.setDex(rand.nextInt(9)+1);
    p.setName(nameInput);


//    ui.textBox.setText("Enter which weapon you would like to use. Enter number and click confirm\n");
    ui.textBox.setText("Click which weapon you would like to use.\nMP5 submachine gun (shoots 3 bullets per turn)\nAK-74M Assault Rifle (Shoots 2 bullets per turn)\n700 Remington Sniper Rifle(shoots 1 bullet per turn)\n");
    
//    System.out.println("Enter which weapon you would like to use");
//    System.out.print("1. MP5 submachine gun (shoots 3 bullets per turn)\n2. AK-74M Assault Rifle (Shoots 2 bullets per turn)\n3. 700 Remington Sniper Rifle(shoots 1 bullet per turn)\n");
    

    gm.toggleTextField();
    gm.toggleMultiChoice();
    gm.setMultiChoiceText("MP5 (smg)", "AK-74 (assault rifle)", "M700 Rem. (sniper)");
    
    do{
        System.out.println(ui.getMultiChoiceString());
        weapChoice = ui.getMultiChoiceString();
        if(weapChoice != null)
        {
            cont2 = true;
            System.out.println("loop accessed");
        }
    }while(!cont2);
    System.out.println("finished loop");
    switch(weapChoice)
    {
        case "choice1":
            Weapon smg = new Weapon("mp5", "smg", 6, "9x19", 3);
            System.out.println(smg);
            p.setWeapon(smg);
            Ammunition ammosmg = new Ammunition("9x19","HP", 9, 0.30);
            smg.addAmmunition(ammosmg);
            break;
        case "choice2":
            Weapon ar = new Weapon("AK-74M", "assault rifle", 12, "5.45x39", 2);
            System.out.println(ar);
            p.setWeapon(ar);
            Ammunition ammoar = new Ammunition("5.45x39","HP", 15, 0.20);
            ar.addAmmunition(ammoar);
            break;
        case "choice3":
            Weapon sr = new Weapon("700 Remington", "sniper rifle", 26, "7.62x51", 1);
            System.out.println(sr);
            p.setWeapon(sr);
            Ammunition ammosr = new Ammunition("7.62x51","HP", 30, 0.10);
            sr.addAmmunition(ammosr);
            break;
    
    }
    
    ui.playerWeapon.setText(p.getWeaponName());//
    ui.playerAmmo.setText(p.getAmmoCode());
    gm.updatePlayerGUI(p);

        }
    
}
    

    

