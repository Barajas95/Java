import java.util.NoSuchElementException;

public class LinkedList
{
	private Packet firstPacket;
	private int size;
	
	public LinkedList()
	{
		this.firstPacket=null;
		this.size=0;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public boolean contains(int[] colors)
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("Aun no hay elementos en la linked list");
		}
		else
		{
			boolean found=false;
			int index=0;
			Packet tempPacket=this.firstPacket;
			do
			{
				if(colors==tempPacket.getColors())
				{
					found=true;
				}
				else
				{
					tempPacket=tempPacket.getNext();
					index++;
				}
			}
			while(index<this.size && found==false);
			return found;
		}	
	}
	
	public String get(int index)
	{
		if(index<0 || index>=this.size)
		{
			throw new IndexOutOfBoundsException("Indice fuera del Rango");
		}
		else if(this.isEmpty())
		{
			throw new NoSuchElementException("Aun no hay elementos en la linked list");
		}
		else if(index==0)
		{
			return this.getFirst();
		}
		else if(index==this.size-1)
		{
			return this.getLast();
		}
		else
		{
			Packet temp=this.firstPacket;
			for(int i=0; i<index; i++)
			{
				temp=temp.getNext();
			}
			return temp.toString();
		}
	}
	
	public String indexOf(int[] colors)
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("Aun no hay elementos en la linked list");
		}
		else
		{
			String index="";
			Packet tempPacket=this.firstPacket;
			for(int i=0; i<this.size; i++)
			{
				if(colors==tempPacket.getColors())
				{
					if(i==this.size-1)
					{
						index=index + i;
					}
					else
					{
						index=index + i + ",";
					}
				}
			tempPacket=tempPacket.getNext();
			}
			return index;
		}
	}

	public void add(int index, int[] colors)
	{
		if(index<0 || index>this.size)
		{
			throw new IndexOutOfBoundsException("Indice fuera del Rango");
		}
		else if(index==0)
		{
			this.addFirst(colors);
		}
		else if(index==this.size-1)
		{
			this.addLast(colors);
		}
		else
		{
			Packet previous=this.firstPacket;
			for(int i=0; i<index-1; i++)
			{
				previous=previous.getNext();
			}
			Packet newPacket = new Packet(colors, previous.getNext());
			previous.setNext(newPacket);
			this.size++;
		}
	}

	public String remove(int index)
	{
		if(index<0 || index>=this.size)
		{
			throw new IndexOutOfBoundsException("Indice fuera del Rango");
		}
		else if(this.isEmpty())
		{
			throw new NoSuchElementException("Aun no hay elementos en la linked list");
		}
		else if(index==0)
		{
			return this.removeFirts();
		}
		else if(index==this.size-1)
		{
			return this.removeLast();
		}
		else
		{
			String value="";
			Packet temp=this.firstPacket;
			for(int i=0; i<index-1; i++)
			{
				temp=temp.getNext();
			}
			value=temp.getNext().toString();
			temp.setNext(temp.getNext().getNext());
			this.size--;
			return value;
		}
	}
	
	public String toString()
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException("Aun no hay elementos en la linked list");
		}
		else
		{
			String output="{";
			Packet temp=this.firstPacket;
			for(int i=0; i<this.size; i++)
			{
				if(i==this.size-1)
				{
					output=output + temp.toString() + "]";
				}
				else
				{
					output=output + temp.toString() + "].";
				}
				
				temp=temp.getNext();
			}
			output=output + "}";
			return output;
		}
	}
	
//**********
//**********
//**********
	
	public void addFirst(int[] colors)
	{
		Packet newPacket=new Packet(colors, this.firstPacket);
		this.firstPacket=newPacket;
		this.size++;
	}

	public void addLast(int[] colors)
	{
		Packet temp=this.firstPacket;
		for(int i=0; i<this.size-1; i++)
		{
			temp=temp.getNext();
		}
		Packet newPacket = new Packet(colors, null);
		temp.setNext(newPacket);
		this.size++;
	}
	
	public String removeFirts()
	{
		Packet temp=this.firstPacket;
		String value=temp.toString();
		this.firstPacket=this.firstPacket.getNext();
		this.size--;
		return value;
	}
	
	public String removeLast()
	{
		String value="";
		Packet temp=this.firstPacket;
		for(int i=0; i<this.size-1; i++)
		{
			temp=temp.getNext();
		}
		value=temp.getNext().toString();
		temp.setNext(null);
		this.size--;
		return value;
	}
	
	public String getFirst()
	{
		Packet temp=this.firstPacket;
		return temp.toString();
	}
	
	public String getLast()
	{
		Packet temp=this.firstPacket;
		for(int i=0; i<this.size; i++)
		{
			temp=temp.getNext();
		}
		return temp.toString();
	}
}
