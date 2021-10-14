/**
 *Vinnie Limbrick
 * 0831133
 */
package Gameplay;

import Items.AttackItem;
import Items.HealItem;
import Items.Item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

/**
ConsumebaleItem class allows access by index so random integer can reward player with item
 */
public class ConsumableItems {
        
    List<Item> consItems = new LinkedList<>();
    
    public ConsumableItems()
    {
        ;
    }
    
    //add item to LinkedList
    public void addItem(Item i)
    {
        consItems.add(i);
    }
    
    //returns List size 
    public Integer getListSize()
    {
        return consItems.size();
    }
    //return item by index
    public Item getItem(int i)
    {
        return consItems.get(i);
    }
    
    //returns random item as reward for winning battles
    public Item getRandomItem()
    {
        Random rand = new Random();
        int index = rand.nextInt(this.getListSize());
        return consItems.get(index);
    }
    
    //reads from item text files to fill LinkedList
    public void populateFromText() throws IOException
    {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("heal-items.txt"));
        String str;
        while((str = br.readLine()) != null)
        {
        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens())
        {
        data.add(st.nextToken());
        }
        }
                int i = 0;
                for(i = i; i< data.size(); i ++)
                {
                String name = (String)data.get(i);
                i++;
                int hpRecovery = Integer.valueOf((String) data.get(i));

                consItems.add(new HealItem(name, hpRecovery));
                }
        br.close();
     
        String str2;
        BufferedReader br2 = new BufferedReader(new FileReader("attack-items.txt"));
        
        while((str2 = br2.readLine()) != null)
        {
        StringTokenizer st = new StringTokenizer(str2, ",");
        while (st.hasMoreTokens())
        {
        data.add(st.nextToken());
        }
        }

                for(i= i; i< data.size(); i ++)
                {
                String name = (String)data.get(i);
                i++;
                int attDmg = Integer.valueOf((String) data.get(i));
                consItems.add(new AttackItem(name, attDmg));
                }
        
        br2.close();
//        System.out.println(consItems);//print to check ArrayList correctly fill
        
    }

    
    
}
