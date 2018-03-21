import java.util.NoSuchElementException;

public class Queue
{
	private Packet firstPacket;
	private int size;
	
	public Queue()
	{
		this.size=0;
		this.firstPacket=null;
	}

	public boolean isEmpty()
	{
		return this.size==0;
	}

	public int getSize()
	{
		return this.size;
	}

	public void enQueue(int[] colors)
	{
		if(this.isEmpty())
		{
			Packet newPacket=new Packet(colors, this.firstPacket);
			this.firstPacket=newPacket;
		}
		else
		{
			Packet newNode, temp;
			temp=this.firstPacket;
			for(int i=0; i<this.size-1; i++)
			{
				temp=temp.getNext();
			}
			newNode=new Packet(colors, temp.getNext());
			temp.setNext(newNode);
		}
		this.size++;
	}

	public String deQueue()
	{
		String temp="";
		if(this.isEmpty())
		{
			throw new NoSuchElementException("La Queue esta vacia");
		}
		else
		{
			temp=this.firstPacket.toString();
			this.firstPacket=this.firstPacket.getNext();
			this.size--;
		}
		return temp;
	}
	
	public void clear()
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("La Queue esta vacia");
		}
		else
		{
			int var=this.size;
			for(int i=0; i<var; i++)
			{
				this.deQueue();
			}
		}
	}

	public String peek()
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("La Queue esta vacia");
		}
		else
		{
			return this.firstPacket.toString();
		}
	}
	
	public String toString()
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("La Queue esta vacia");
		}
		else
		{
			String output="{";
			Packet temp=this.firstPacket;
			for(int i=0; i<this.size; i++)
			{
				if(i==this.size-1)
				{
					output=output + (String)"[" + temp.toString() + "]";
				}
				else
				{
					output=output + (String)"[" + temp.toString() + "].";
				}
				
				temp=temp.getNext();
			}
			return output + "}";
		}
	}
}
