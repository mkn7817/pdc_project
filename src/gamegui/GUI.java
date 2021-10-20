/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class GUI {
    
    public JFrame frame;
    JPanel titlePanel;
    JPanel imagePanel;
    
    public JButton confirmButton;
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton resetButton;
    public JPanel buttonPanel;
    
    public JTextArea textBox;//game text
    public JTextField textField;//player text to enter
    
    public JPanel startPanel;
    public JLabel startLabel;
    public JPanel woodsPanel;
    public JLabel woodsLabel;
    public JPanel customsPanel;
    public JLabel customsLabel;
    public JPanel reservePanel;
    public JLabel reserveLabel;
    public JPanel labPanel;
    public JLabel labLabel;
    
    public JPanel battlePlayer;
    public JPanel battleBoss;
    public JLabel playerHP, playerName, playerWeapon, playerAmmo;
    public JLabel bossHP, bossName;
    
    public JPanel itemPanel;
    public JButton item1, item2, item3, item4, item5, item6, closeBag;
    public ArrayList<JButton> itemButtonList;
    
    public boolean reset = false;
    
    private String textFieldString;
    private String multiChoiceString;
    ChoiceListener cl;
        
    public GUI(ChoiceListener cl)
    {
        //JFrame 
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocation(100, 100);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //title
        titlePanel = new JPanel();
        
        //text box
        textBox = new JTextArea();
        textBox.setBounds(40, 350, 700, 150);//x, y, width, height
        textBox.setBackground(Color.black);
        textBox.setForeground(Color.white);
        textBox.setEditable(true);
        textBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textBox.setLineWrap(true);
        textBox.setWrapStyleWord(true);
//        textBox.setLineWrap(true);
//        textBox.setWrapStyleWord(true);
        
        //reset button
//        resetButton = new JButton();
//        resetButton.setBounds(640, 460, 100, 40);
//        resetButton.setBackground(Color.black);
//        resetButton.setForeground(Color.white);
//        resetButton.setText("RESET");
//        resetButton.addActionListener(cl);
//        resetButton.setActionCommand("reset");
//        resetButton.setVisible(true);
        
        //confirm button
        confirmButton = new JButton();
        confirmButton.setBounds(640, 500, 100, 40);
        confirmButton.setBackground(Color.black);
        confirmButton.setForeground(Color.white);
        confirmButton.setText("CONFIRM");
        confirmButton.addActionListener(cl);
        confirmButton.setActionCommand("confirm");
        
        //multi-choice buttons and panel
        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 150, 200, 180);
        buttonPanel.setBackground(Color.red);
        buttonPanel.setLayout(new GridLayout(3, 1));
        frame.add(buttonPanel);
        
        button1 = new JButton();
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button1.addActionListener(cl);
        button1.setActionCommand("choice1");
        
        button2 = new JButton();
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.addActionListener(cl);
        button2.setActionCommand("choice2");
        
        button3 = new JButton();
        button3.setBackground(Color.black);
        button3.setForeground(Color.white);
        button3.addActionListener(cl);
        button3.setActionCommand("choice3");
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.setVisible(false);
        
        //battle panels and labels
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.white, 1);//border for jlabels
        
        battlePlayer = new JPanel();
        battlePlayer.setBounds(10, 20, 100, 240);
        battlePlayer.setLayout(new GridLayout(4, 1));
        battlePlayer.setBackground(Color.black);
        battlePlayer.setForeground(Color.white);
        playerHP = new JLabel("player hp");
        playerHP.setBorder(border);
        playerHP.setBackground(Color.black);
        playerHP.setForeground(Color.white);
        playerName = new JLabel("player name");
        playerName.setBorder(border);
        playerName.setBackground(Color.black);
        playerName.setForeground(Color.white);
        playerWeapon = new JLabel("weapon");
        playerWeapon.setBorder(border);
        playerWeapon.setBackground(Color.black);
        playerWeapon.setForeground(Color.white);
        playerAmmo = new JLabel("ammo");
        playerAmmo.setBorder(border);
        playerAmmo.setBackground(Color.black);
        playerAmmo.setForeground(Color.white);
        battlePlayer.add(playerName);
        battlePlayer.add(playerHP);
        battlePlayer.add(playerWeapon);
        battlePlayer.add(playerAmmo);
        frame.add(battlePlayer);
        battlePlayer.setVisible(true);
        
        battleBoss = new JPanel();
        battleBoss.setBounds(660, 20, 100, 120);
        battleBoss.setLayout(new GridLayout(2, 1));
        battleBoss.setBackground(Color.black);
        battleBoss.setForeground(Color.white);
        bossHP = new JLabel("boss hp");
        bossHP.setBorder(border);
        bossHP.setBackground(Color.black);
        bossHP.setForeground(Color.white);
        bossName = new JLabel("boss name");
        bossName.setBorder(border);
        bossName.setBackground(Color.black);
        bossName.setForeground(Color.white);
        battleBoss.add(bossName);
        battleBoss.add(bossHP);
        frame.add(battleBoss);  
        battleBoss.setVisible(false);
        
        //item list in battle
        itemPanel = new JPanel();
        itemPanel.setBounds(70, 450, 640, 60);
        itemPanel.setLayout(new GridLayout(1, 7));
        itemPanel.setBackground(Color.black);
        itemPanel.setForeground(Color.white);
        
        item1 = new JButton();
        item1.setBackground(Color.black);
        item1.setForeground(Color.white);
        item1.addActionListener(cl);
        item1.setActionCommand("item1");
        item2 = new JButton();
        item2.setBackground(Color.black);
        item2.setForeground(Color.white);
        item2.addActionListener(cl);
        item2.setActionCommand("item2");
        item3 = new JButton();
        item3.setBackground(Color.black);
        item3.setForeground(Color.white);
        item3.addActionListener(cl);
        item3.setActionCommand("item3");
        item4 = new JButton();
        item4.setBackground(Color.black);
        item4.setForeground(Color.white);
        item4.addActionListener(cl);
        item4.setActionCommand("item4");
        item5 = new JButton();
        item5.setBackground(Color.black);
        item5.setForeground(Color.white);
        item5.addActionListener(cl);
        item5.setActionCommand("item5");
        item6 = new JButton();
        item6.setBackground(Color.black);
        item6.setForeground(Color.white);
        item6.addActionListener(cl);
        item6.setActionCommand("item6");
        closeBag = new JButton();
        closeBag.setBackground(Color.black);
        closeBag.setForeground(Color.white);
        closeBag.addActionListener(cl);
        closeBag.setActionCommand("closebag");
        itemPanel.add(item1);
        itemPanel.add(item2);
        itemPanel.add(item3);
        itemPanel.add(item4);
        itemPanel.add(item5);
        itemPanel.add(item6);
        
        itemButtonList = new ArrayList<>(6);
        itemButtonList.add(item1);
        itemButtonList.add(item2);
        itemButtonList.add(item3);
        itemButtonList.add(item4);
        itemButtonList.add(item5);
        itemButtonList.add(item6);
        itemPanel.setVisible(false);
        
        
        textField = new JTextField();
        textField.setBounds(40, 500, 600, 40);
        textField.setBackground(Color.white);
        
//        frame.add(resetButton);
        frame.add(itemPanel);
        frame.add(confirmButton);
        frame.add(textBox);        
        frame.add(textField);
        
        
        
//        backgroundStart();
        frame.setVisible(true);
    }
    
    //sets initial background upon start    
    public void backgroundStart()
    {
        startPanel = new JPanel();
        startPanel.setBounds(40, 10, 700, 380);
        startPanel.setBackground(Color.red);
        startPanel.setLayout(null);
        
        ImageIcon titleImage = new ImageIcon("title.png");
        startLabel = new JLabel();
        startLabel.setBounds(0, 0, 700, 380);
        startLabel.setIcon(titleImage);
        startPanel.add(startLabel);
        
        frame.add(startPanel);
        
    }
    
    
    //getters and setters for attributes related to action listeners
    public void setReset(boolean b)
    {
        this.reset = b;
    }
    
    public boolean getReset()
    {
        return this.reset;
    }
    
    public void setTextArea(String s)
    {
        textBox.setText(s);
    }
    
    public void setTextFieldString(String s)
    {
        this.textFieldString = s;
    }
    
    public void addToText(String s)
    {
        textBox.setText(textBox.getText() + "\n"+s);
    }
    
    public String getTextBox()
    {
        return textBox.getText();
    }
    
    public String getTextFieldString()
    {
        return this.textFieldString;
    }
    
    public void setMultiChoiceString(String s)
    {
        this.multiChoiceString = s;
    }
    
    public String getMultiChoiceString()
    {
        return this.multiChoiceString;
    }
   
   
}

