/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AmmoDBOperations {
    
    AmmoDBManager adbm;
    
    public AmmoDBOperations()
    {
        adbm = new AmmoDBManager();
    }
    
    //create table with smg ammo
    public void createTableSmg() {
        try {
            
            Statement statement = adbm.getConnection().createStatement();
//            DatabaseMetaData metadata = null;
            DatabaseMetaData metadata = adbm.getConnection().getMetaData();
            String[] name = { "TABLE"};
            ResultSet tableNames = metadata.getTables( null, null, null, name);
            
            String newTableName = "SMGAMMO";
            
            while( tableNames.next())
            {
                String tab = tableNames.getString( "TABLE_NAME");

                if(tab.equalsIgnoreCase(newTableName)) {
                    statement.executeUpdate("drop table "+newTableName);
                    
                }
            }
            
            String sqlCreate = "create table " + newTableName + " (AMID int not null,"
                    + "AMCALIBER varchar(10), AMCLASS varchar(3),"
                    + "AMDAMAGE int,"
                    + "FRAGCHANCE double, PRIMARY KEY (AMID))";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "insert into " + newTableName + " values("
                    + "1, '9x19', 'HP', 9, 0.3),"
                    + "("
                    + "2, '9x19', 'FMJ', 12, 0.3),"
                    + "("
                    + "3, '9x19', 'AP', 14, 0.3)";
         
            statement.executeUpdate(sqlInsert);

        } catch (SQLException ex) {
            Logger.getLogger(AmmoDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //create table with ar ammo
    public void createTableAr() {
        try {
            
            Statement statement = adbm.getConnection().createStatement();
//            DatabaseMetaData metadata = null;
            DatabaseMetaData metadata = adbm.getConnection().getMetaData();
            String[] name = { "TABLE"};
            ResultSet tableNames = metadata.getTables( null, null, null, name);
            String newTableName = "ARAMMO";
            
            //checks if table name already exists, drops table if it does
            while( tableNames.next())
            {
                String tab = tableNames.getString( "TABLE_NAME");
//                System.out.println("TABLE NAMES: "+tab);
                if(tab.equalsIgnoreCase(newTableName)) {
                    statement.executeUpdate("drop table "+newTableName);
                }
            }
            
            //build sql statement to create table
            String sqlCreate = "create table " + newTableName + " (AMID int not null,"
                    + "AMCALIBER varchar(10), AMCLASS varchar(3),"
                    + "AMDAMAGE int,"
                    + "FRAGCHANCE double, PRIMARY KEY (AMID))";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "insert into " + newTableName + " values("
                    + "1, '5.45x39', 'HP', 15, 0.2),"
                    + "("
                    + "2, '5.45x39', 'FMJ', 17, 0.2),"
                    + "("
                    + "3, '5.45x39', 'AP', 21, 0.2)";
            statement.executeUpdate(sqlInsert);

        } catch (SQLException ex) {
            Logger.getLogger(AmmoDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //create table with sr ammo
    public void createTableSr() {
        try {
            
            Statement statement = adbm.getConnection().createStatement();
//            DatabaseMetaData metadata = null;
            DatabaseMetaData metadata = adbm.getConnection().getMetaData();
            String[] name = { "TABLE"};
            ResultSet tableNames = metadata.getTables( null, null, null, name);
                        
            String newTableName = "SRAMMO";
            
            //checks if table name already exists, drops table if it does
            while( tableNames.next())
            {
                String tab = tableNames.getString( "TABLE_NAME");
//                System.out.println("TABLE NAMES: "+tab);
                if(tab.equalsIgnoreCase(newTableName)) {
                    statement.executeUpdate("drop table "+newTableName);
                    
                }
            }
            
            //build string for sql statement to create table
            String sqlCreate = "create table " + newTableName + " (AMID int not null,"
                    + "AMCALIBER varchar(10), AMCLASS varchar(3),"
                    + "AMDAMAGE int,"
                    + "FRAGCHANCE double, PRIMARY KEY (AMID))";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "insert into " + newTableName + " values("
                    + "1, '7.62x51', 'HP', 45, 0.2),"
                    + "("
                    + "2, '7.62x51', 'FMJ', 65, 0.2),"
                    + "("
                    + "3, '7.62x51', 'AP', 80, 0.2)";
            statement.executeUpdate(sqlInsert);

        } catch (SQLException ex) {
            Logger.getLogger(AmmoDBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
