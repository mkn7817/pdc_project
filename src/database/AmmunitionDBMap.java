/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Items.Ammunition;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * creates HashMap object of Ammunition from created database
 */
public class AmmunitionDBMap {
    
    AmmoDBManager adbm;
    AmmoDBOperations adbo;
    private HashMap<String, Ammunition> ammoMap = new HashMap<>();
    
    public AmmunitionDBMap()
    {
        adbm = new AmmoDBManager();
        adbo = new AmmoDBOperations();
    }
   
    public void getSmgAmmo() 
    {
        
        adbo.createTableSmg();
        List<Ammunition> ammoList = new ArrayList<>();
        ResultSet rs = adbm.myQuery("select * from SMGAMMO");
        
        try {
            while (rs.next()) {
                String type = rs.getString(2);
                String code = rs.getString(3);
                int damage = rs.getInt(4);
                double fragchance = rs.getDouble(5);
                
                //input from database creating Ammunition objects into HashMap
                ammoMap.put(code, new Ammunition(type, code, damage, fragchance));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next())
                System.out.println("has next");
        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    public List<Ammunition> getArAmmo() 
    {
        adbo.createTableAr();
        List<Ammunition> ammoList = new ArrayList<>();
        ResultSet rs = adbm.myQuery("select * from ARAMMO");

        try {
            while (rs.next()) {
                String type = rs.getString(2);
                String code = rs.getString(3);
                int damage = rs.getInt(4);
                double fragchance = rs.getDouble(5);

                //input from database creating Ammunition objects into HashMap
                ammoMap.put(code, new Ammunition(type, code, damage, fragchance));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next())
                System.out.println("has next");
        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ammoList;
    }
    
    public List<Ammunition> getSrAmmo() 
    {

        adbo.createTableSr();
        List<Ammunition> ammoList = new ArrayList<>();
        ResultSet rs = adbm.myQuery("select * from SRAMMO");
        System.out.println(rs);
        
        try {
            while (rs.next()) {
//                int id = rs.getInt(1);
                String type = rs.getString(2);
                String code = rs.getString(3);
                int damage = rs.getInt(4);
                double fragchance = rs.getDouble(5);
                
                ammoMap.put(code, new Ammunition(type, code, damage, fragchance));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next())
                System.out.println("has next");
        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ammoList;
    }
    
    //returns ammo based on type (HP, FMJ, AP)
    public Ammunition getAmmo(String s)
    {
        return ammoMap.get(s);
    }
    
    @Override
    public String toString()
    {
        Iterator it = ammoMap.entrySet().iterator();
        String str = "";
        Map.Entry element = (Map.Entry)it.next();
        
        while(it.hasNext())
        {
            
            str += element.getValue()+" ";
        }
        return str;
    }
}
