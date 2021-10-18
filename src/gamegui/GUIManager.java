/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

import Characters.Player;
import Items.Ammunition;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class GUIManager {
    
    GUI ui;
    
    
    public GUIManager(GUI ui)
    {
        this.ui = ui;
    }
    
    public void displayTitle()
    {
        ui.titlePanel.setVisible(true);
    }
    
    //display woods background
    public void displayWoods()
    {
        ui.frame.remove(ui.startPanel);
        
        //JPanel for background image
        ui.woodsPanel = new JPanel();
        ui.woodsPanel.setBounds(40, 10, 700, 380);
        ui.woodsPanel.setBackground(Color.red);
        ui.woodsPanel.setLayout(null);
        

        //JLabel to place image upon
        ImageIcon woodsImage = new ImageIcon("woods.png");
        ui.woodsLabel = new JLabel();
        ui.woodsLabel.setBounds(0, 0, 700, 380);
        ui.woodsLabel.setIcon(woodsImage);
        ui.woodsPanel.add(ui.woodsLabel);
        
        //add panel to frame as final step
        ui.frame.add(ui.woodsPanel);
        ui.frame.repaint();
    }
    
    public void removeWoodsDisplay()
    {
        ui.frame.remove(ui.woodsPanel);
    }
    
    //display customs bacground
    public void displayCustoms()
    {

        //JPanel for background image
        ui.customsPanel = new JPanel();
        ui.customsPanel.setBounds(40, 10, 700, 380);
        ui.customsPanel.setBackground(Color.red);
        ui.customsPanel.setLayout(null);
        

        //JLabel to place image upon
        ImageIcon woodsImage = new ImageIcon("customs.png");
        ui.customsLabel = new JLabel();
        ui.customsLabel.setBounds(0, 0, 700, 380);
        ui.customsLabel.setIcon(woodsImage);
        ui.customsPanel.add(ui.customsLabel);
        
        //add panel to frame as final step
        ui.frame.add(ui.customsPanel);
    }
    
    //display reserve background
    public void displayReserve()
    {
        //remove old panel
        ui.frame.remove(ui.woodsPanel);
        
        //JPanel for background image
        ui.reservePanel = new JPanel();
        ui.reservePanel.setBounds(40, 10, 700, 380);
        ui.reservePanel.setBackground(Color.red);
        ui.reservePanel.setLayout(null);
        

        //JLabel to place image upon
        ImageIcon woodsImage = new ImageIcon("reserve.png");
        ui.reserveLabel = new JLabel();
        ui.reserveLabel.setBounds(0, 0, 700, 380);
        ui.reserveLabel.setIcon(woodsImage);
        ui.reservePanel.add(ui.reserveLabel);
        
        //add panel to frame as final step
        ui.frame.add(ui.reservePanel);
        ui.frame.repaint();
    }
    
        public void backgroundLab()
    {
        //remove old panel
        ui.frame.remove(ui.reservePanel);
        
//        frame.remove(reservePanel);
        
        //JPanel for background image
        ui.labPanel = new JPanel();
        ui.labPanel.setBounds(40, 10, 700, 380);
        ui.labPanel.setBackground(Color.red);
        ui.labPanel.setLayout(null);
        

        //JLabel to place image upon
        ImageIcon woodsImage = new ImageIcon("lab.png");
        ui.labLabel = new JLabel();
        ui.labLabel.setBounds(0, 0, 700, 380);
        ui.labLabel.setIcon(woodsImage);
        ui.labPanel.add(ui.labLabel);
        
        //add panel to frame as final step
        ui.frame.add(ui.labPanel);
    }
    
    //display lab background
    public void displayLab()
    {
        ;
    }
    
    //displays relevant panels to battle screen
    public void toggleBattleScreen()
    {
        if(!ui.battleBoss.isVisible())
        {
            ui.battlePlayer.setVisible(true);
            ui.battleBoss.setVisible(true);
            ui.bossName.repaint();
            ui.bossHP.repaint();
        }
        else if(ui.battleBoss.isVisible())
        {
            ui.battlePlayer.setVisible(false);
            ui.battleBoss.setVisible(false);
        }
    }
    
    public void updateBossGUI(String name, int hp)
    {
        String hpS = hp+"";//convert hp to string first
        ui.bossHP.setText(hpS);
        ui.bossName.setText(name);
    }
    
    public void updatePlayerGUI(Player p)
    {
        ui.playerName.setText(p.getName());
        ui.playerHP.setText(p.getCurrentHP()+"/"+p.getMaxHP()+" Hit Points");
        ui.playerWeapon.setText(p.getWeaponName());
        ui.playerAmmo.setText(p.getAmmoCode());
        
    }
    
    //toggles the text field display and confirm button
    public void toggleTextField()
    {
        if(ui.textField.isVisible())
        {
            ui.textField.setVisible(false);
            ui.confirmButton.setVisible(false);
        }
        else if(!ui.textField.isVisible())
        {
            ui.textField.setVisible(true);
            ui.confirmButton.setVisible(true);
        }
    }
    
    //toggles multi choice button panel visibility
    public void toggleMultiChoice()
    {
        if(ui.buttonPanel.isVisible())
        {
            ui.buttonPanel.setVisible(false);
        }
        else if(!ui.buttonPanel.isVisible())
        {
            ui.buttonPanel.setVisible(true);
        }
    }
    
    //set button text for multi-choice buttons
    public void setMultiChoiceText(String s1, String s2, String s3)
    {
        ui.button1.setText(s1);
        ui.button2.setText(s2);
        ui.button3.setText(s3);
    }
    
    //updates player display details
    public void updatePlayerDetails(Player p)
    {
        ui.playerHP.setText(p.getCurrentHP()+"/"+p.getMaxHP());
        ui.playerAmmo.setText(p.getAmmoCode());
    }
    
    public void displayBackpackPanel()
    {
        ui.itemPanel.setVisible(true);
    }
    
    //runs loop until there is player input
    public void getInput()
    {
     ui.setMultiChoiceString("");
        while(ui.getMultiChoiceString().isEmpty())
        {
            ui.getMultiChoiceString();
            ui.getMultiChoiceString();
            System.out.print("");
        }
        
    }
    
    //runs loop until there is player input via confirm button
    public void getInputConfirm()
    {
//     ui.setMultiChoiceString("");
     ui.setTextFieldString("");
        while(ui.getTextFieldString().isEmpty())
        {
            ui.getTextFieldString();
            ui.getTextFieldString();
            System.out.print("");
        }
        
    }
    
    public void refreshFrame()
    {
//        ui.battleBoss.repaint();
        ui.bossHP.repaint();
    }
    
    
    //displays battle commands
    public void displayBattleCommands()
    {
//        toggleMultiChoice();
        setMultiChoiceText("Attack", "Use Item", "Defend");
        System.out.println("TEST displayCommands()");
    }
    
   
    
}
