/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
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
    
    public List<Ammunition> getSmgAmmo() 
    {
        adbo.createTableSmg();
        
        List<Ammunition> ammoList = new ArrayList<>();
        ResultSet rs = adbm.myQuery("select * from SMGAMMO");
 
        System.out.println(rs);
//        try {
//            while (rs.next()) {
//                int id = rs.getInt("AMMOID");
//                String type = rs.getString("amcaliber");
//                String code = rs.getString("amclass");
//                int damage = rs.getInt("amdamage");
//                double fragchance = rs.getDouble("fragchance");
//
//                Ammunition ammo = new Ammunition(type, code, damage, fragchance);
//                ammoList.add(ammo);
//                ammoMap.put(code, ammo);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return ammoList;
        
    }
    
    public List<Ammunition> getArAmmo() 
    {
        List<Ammunition> ammoList = new ArrayList<>();
        ResultSet rs = adbm.myQuery("select * from ARAMMO");
        try {
            while (rs.next()) {
                int id = rs.getInt("ammoid");
                String type = rs.getString("amcaliber");
                String code = rs.getString("amclass");
                int damage = rs.getInt("amdamage");
                double fragchance = rs.getDouble("fragchance");

                Ammunition ammo = new Ammunition(type, code, damage, fragchance);
                ammoList.add(ammo);
                ammoMap.put(code, ammo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ammoList;
    }
    
    public List<Ammunition> getSrAmmo() 
    {
        List<Ammunition> ammoList = new ArrayList<>();
        ResultSet rs = adbm.myQuery("select * from SRAMMO");
        try {
            while (rs.next()) {
                int id = rs.getInt("ammoid");
                String type = rs.getString("amcaliber");
                String code = rs.getString("amclass");
                int damage = rs.getInt("amdamage");
                double fragchance = rs.getDouble("fragchance");

                Ammunition ammo = new Ammunition(type, code, damage, fragchance);
                ammoList.add(ammo);
                ammoMap.put(code, ammo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AmmunitionDBMap.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ammoList;
    }
}
