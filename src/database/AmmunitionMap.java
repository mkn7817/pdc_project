/**
 *Vinnie Limbrick
 * 0831133
 */
package database;

import Characters.BossList;
import Items.Ammunition;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * HashMap for storing ammunition types based on weapon chosen at start of game
 */
public class AmmunitionMap {
    
    private HashMap<String, Ammunition> ammoMap = new HashMap<>();
    
    public AmmunitionMap()
    {
        ;
    }
    
    //creates HashMap for smg Ammunition objects from text
    public void populateAmmoMapSmg() throws IOException
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("smg-ammo.txt"));
        String str;
        AmmunitionMap m1 = new AmmunitionMap();
        while((str = br.readLine()) != null)
        {
        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens())
        {
        data.add(st.nextToken());
        }
        }
            int i = 0;
            for(i= i; i< data.size(); i ++)
            {
            String ammoType = (String)data.get(i);
            i++;
            String ammoCode = (String)data.get(i);
            i++;
            int ammoDmg = Integer.valueOf((String)data.get(i));
            i++;
            double critical = Double.valueOf((String)data.get(i));
            
            ammoMap.put(ammoCode, new Ammunition(ammoType, ammoCode, ammoDmg, critical));
            }
//            System.out.println(data);
                br.close();
        
    }
    
    //creates HashMap for ar Ammunition objects from text
    public void populateAmmoMapAr() throws IOException
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("ar-ammo.txt"));
        String str;
        AmmunitionMap m1 = new AmmunitionMap();
        while((str = br.readLine()) != null)
        {

        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens())
        {
        data.add(st.nextToken());
        }
        }
            int i = 0;
            for(i= i; i< data.size(); i ++)
            {
            String ammoType = (String)data.get(i);
            i++;
            String ammoCode = (String)data.get(i);
            i++;
            int ammoDmg = Integer.valueOf((String)data.get(i));
            i++;
            double critical = Double.valueOf((String)data.get(i));
            
            ammoMap.put(ammoCode, new Ammunition(ammoType, ammoCode, ammoDmg, critical));
            }
//            System.out.println(data);
            br.close();
        
    }
    
    //creates HashMap for sr Ammunition objects from text    
    public void populateAmmoMapSr() throws IOException
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("sr-ammo.txt"));
        String str;
        AmmunitionMap m1 = new AmmunitionMap();
        while((str = br.readLine()) != null)
        {

        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens())
        {
        data.add(st.nextToken());
        }
        }
            int i = 0;
            for(i= i; i< data.size(); i ++)
            {
            String ammoType = (String)data.get(i);
            i++;
            String ammoCode = (String)data.get(i);
            i++;
            int ammoDmg = Integer.valueOf((String)data.get(i));
            i++;
            double critical = Double.valueOf((String)data.get(i));
            
            ammoMap.put(ammoCode, new Ammunition(ammoType, ammoCode, ammoDmg, critical));
            }
//            System.out.println(data);
            br.close();
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
