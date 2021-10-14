/**
 *Vinnie Limbrick
 * 0831133
 */
package Items;


public abstract class Item {
	
	private String name;
	
	public Item()
	{
            this.name = "unknown";
	}
	
	public Item(String name)
	{
            this.name = name;
	}
	
	public String getName()
	{
            return this.name;
	}
	
	public void setName(String name)
	{
            this.name = name;
	}
        
        @Override
        public String toString()
        {
            return this.name;
        }
	
	
}