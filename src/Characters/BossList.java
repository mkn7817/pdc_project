/**
 *Vinnie Limbrick
 * 0831133
 */
package Characters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


/*
 * keeps a LinkedList of bosses in game to be accessed as story progresses
 */
public class BossList {
    
        private List<Boss> bList = new LinkedList();
        private static int bossNumber = 0;//number to access index for which boss you encounter in specific order

        
        
        public BossList()
        {
            ;
        }
        
        
        public BossList(Boss b1, Boss b2, Boss b3)
        {
            bList.add(b1);
            bList.add(b2);
            bList.add(b3);
        }
        
        //add Boss object to LinkedList
        public void addBoss(Boss b)
        {
            bList.add(b);
        }
        
        //get method to pull boss from LinkedList
        public Boss getNextBoss(int i)
        {
            if(!bList.isEmpty())
            {
            return bList.get(i);
            }
            else return null;
        }
                
        //reads from boss-data.txt to construct bosses, fills bList with bosses 
        public void populateBossList() throws IOException
        {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("boss-data.txt"));
        String str;

        while((str = br.readLine()) != null)
        {
        StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens())
        {
        data.add(st.nextToken());
        }
//            System.out.println(data);
//                reader.close();
        }
        int i = 0;
                for(i= i; i< data.size(); i ++){
                String name = (String)data.get(i);
                i++;
                int maxHP = Integer.valueOf((String) data.get(i));
                i++;
                int lvl = Integer.valueOf((String)data.get(i));
                i++;
                int baseDmg = Integer.valueOf((String)data.get(i));
                i++;
                double accuracy = Double.valueOf((String)data.get(i));
                bList.add(new Boss(name, maxHP, lvl, baseDmg, accuracy));
              
        }
        br.close();

        }
        
        public String toString()
        {
            String str = "";
            
            for(int i = 0; i < bList.size(); i++)
            {
                str += bList.get(i)+"\n";
            }
            return str;
        }
    
}
