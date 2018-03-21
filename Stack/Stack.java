package Stack;

import java.util.EmptyStackException;

public class Stack<E> implements Stack_Interface<E>
{
	private Node<E> firstNode;
	private int size;
	
	public Stack()
	{
		this.size=0;
		this.firstNode=null;
	}

	public int getSize()
	{
		return this.size;
	}
	
	public void push(E data)
	{
		Node<E> newNode=new Node<E>(data, this.firstNode);
		this.firstNode=newNode;
		this.size++;
	}

	public E pop()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			E value=this.firstNode.getData();
			this.firstNode=this.firstNode.getNext();
			this.size--;
			return value;
		}
	}

	@Override
	public E top()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return this.firstNode.getData();
		}
		
	}

	public boolean isEmpty()
	{
		return this.size==0;
	}

	public void clear()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			int var=this.size;
			for(int i=0; i<var; i++)
			{
				this.pop();
			}
			
		}
	}
	
	public String toString()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
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
				output=output + (String)"[" + temp.getData() + "].";
			}
			
			temp=temp.getNext();
		}
		output=output + "}";
		return output;
	}	
}
