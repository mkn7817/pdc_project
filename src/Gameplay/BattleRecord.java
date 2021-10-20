/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameplay;

import Characters.Player;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
* class add battle statistics for each game into log at completion
* stats can be used to balance game (damage, item performance etc)
*/
public class BattleRecord {
    Battle b;
    Player p;
    
    public BattleRecord(Player p)
    {
        b = new Battle();
        this.p = p;
    }
    
    
    //adds game data to battle-stats file
    public void addToLog() throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(new FileOutputStream("battle-stats.txt", true));
        pw.append("Battles: "+Battle.count+" Damage taken: "+Battle.damageReceived+" Damage given: "+Battle.damageInflicted+" Player misses: "+Battle.playerMisses+" Boss misses: "+Battle.aiMisses+" Weapon of choice: "+p.getWeaponName()+"\n");
        
        pw.close();
    }
    
}
