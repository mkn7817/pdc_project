/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChoiceListener implements ActionListener {
    
    GUI ui;
    
    public void getUI(GUI ui)
    {
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        
        switch(choice)
        {
            case "choice1": ui.setMultiChoiceString("choice1"); System.out.println("choice1");
                break;
            case "choice2": ui.setMultiChoiceString("choice2"); System.out.println("choice2");
                break;
            case "choice3": ui.setMultiChoiceString("choice3"); System.out.println("choice3");
                break;
            case "confirm": ui.setTextFieldString(ui.textField.getText()); System.out.println(ui.getTextFieldString()+"confirm button worked");
                break;
            case "item1": ui.setMultiChoiceString("item1");
                break;
            case "item2": ui.setMultiChoiceString("item2");
                break;
            case "item3": ui.setMultiChoiceString("item3");
                break;
            case "item4": ui.setMultiChoiceString("item4");
                break;
            case "item5": ui.setMultiChoiceString("item5");
                break;
            case "item6": ui.setMultiChoiceString("item6");
                break;
            case "closebag": ui.setMultiChoiceString("closebag");
                break;
        }
    }
    
}
