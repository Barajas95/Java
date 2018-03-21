import java.util.Iterator;

public class DoubleLinkedList<E> implements DoubleLinkedList_Interface<E>,Iterable<E>
{
	private Node<E> firstNode;
	private int size;
	
	public DoubleLinkedList()
	{
		this.firstNode=null;
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
	
	public void add(int index, E data)
	{
		if(index<0 || index>this.size)
		{
			throw new IndexOutOfBoundsException("Indice fuera del Rango");
		}
		else if(this.isEmpty())
		{
			this.addFirst(data);
		}
		else if(index==this.size)
		{
			this.addLast(data);
		}
		else
		{
			Node<E> newNode, temp;
			temp=this.firstNode;
			for(int i=0; i<index-1; i++)
			{
				temp=temp.getNext();
	
			}
			newNode=new Node<E>(data, temp, temp.getNext());
			temp.setNext(newNode);
			temp.getNext().setPrevious(newNode);
			this.size++;
		}
	}
	
	public void addFirst(E data)
	{
		Node<E> newNode=new Node<E>(data, null, this.firstNode);
		this.firstNode=newNode;
		this.size++;
	}
	
	public void addLast(E data)
	{
		Node<E> newNode, temp;
		temp=this.firstNode;
		for(int i=0; i<this.size-1; i++)
		{
			temp=temp.getNext();
		}
		newNode=new Node<E>(data, temp, null);
		temp.setNext(newNode);
		this.size++;
	}
	
	public String toString()
	{
		if(this.isEmpty())
		{
			throw new IndexOutOfBoundsException("Lista vacia");
		}
		
		String output="{";
		Node<E> temp=this.firstNode;
		for(int i=0; i<this.size; i++)
		{
			if(i==this.size-1)
			{
				output=output + (String)"[" + temp.getData() + "]";
			}
			else
			{
				output=output + (String)"[" + temp.getData() + "],";
			}
			
			temp=temp.getNext();
		}
		output=output + "}";
		return output;
	}

	/*
	************************
	************************
	************************
	*/
	
	
	public boolean contains(E data)
	{
		if(this.isEmpty())
		{
			throw new IndexOutOfBoundsException("No hay elementos en la lista");
		}
		else
		{
			boolean found=false;
			int index=0;
			Node<E> testNode=this.firstNode;
			do
			{
				if(data.equals(testNode.getData()))
				{
					found=true;
				}
				else
				{
					testNode=testNode.getNext();
					index++;
				}
			}
			while(index<this.size && found==false);
			return found;
		}
	}
	
	public E get(int index)
	{
		if(index<0 || index>=this.size)
		{
			throw new IndexOutOfBoundsException("Indice fuera del Rango");
		}
		Node<E> temp=this.firstNode;
		for(int i=0; i<index; i++)
		{
			temp=temp.getNext();
		}
		return temp.getData();
	}
	
	public int indexOf(E data)
	{
		if(this.isEmpty())
		{
			throw new IndexOutOfBoundsException("No hay elementos en la lista");
		}
		else
		{
			boolean found=false;
			int index=0;
			Node<E> testNode=this.firstNode;
			do
			{
				if(data.equals(testNode.getData()))
				{
					found=true;
				}
				else
				{
					testNode=testNode.getNext();
					index++;
				}
			}
			while(index<this.size && found==false);
			if(found)
			{
				return index;
			}
			else
			{
				return -1;
			}	
		}
	}

	public E remove(int index)
	{
		E value;
		if(index<0 || index>this.size)
		{
			throw new IndexOutOfBoundsException("Indice fuera del Rango");
		}
		else if(this.isEmpty())
		{
			throw new IndexOutOfBoundsException("Lista vacia");
		}
		else if(index==0)
		{
			value=this.removeFirst();
		}
		else if(index==this.size-1)
		{
			value=this.removeLast();
		}
		else
		{
			Node<E> temp=this.firstNode;
			for(int i=0; i<index-1; i++)
			{
				temp=temp.getNext();
			}
			value=temp.getData();
			temp.setNext(temp.getNext().getNext());
			this.size--;
		}
		return value;
	}
	
	public E removeFirst()
	{
		E value=this.firstNode.getData();
		this.firstNode=this.firstNode.getNext();
		this.size--;
		return value;
	}
	
	public E removeLast()
	{
		Node<E> temp=this.firstNode;
		for(int i=0; i<this.size-1; i++)
		{
			temp=temp.getNext();
		}
		E value=temp.getData();
		temp.setNext(null);
		this.size--;
		return value;	
	}
	
	public E getFirst()
	{
		return this.firstNode.getData();
	}
	
	public E getLast()
	{
		Node<E> temp=this.firstNode;
		for(int i=0; i<this.size-1; i++)
		{
			temp=temp.getNext();
		}
		E value=temp.getData();
		return value;
	}

	public void clear()
	{
		int var=this.size;
		for(int i=0; i<var;i++)
		{
			this.removeFirst();
		}
	}

	public void replace(int index)
	{
		
	}

	@Override
	public DoubleLinkedList_Iterator iterator()
	{
		return new DoubleLinkedList_Iterator<>(this.firstNode);
	}
}