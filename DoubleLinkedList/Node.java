
public class Node<E>
{
	private E data;
	private Node<E> previous, next;
	
	public Node()
	{
		this(null,null,null);
	}
	
	public Node (E data, Node <E> previous, Node<E> next)
	{
		this.data=data;
		this.previous=previous;
		this.next=next;
	}
	
	public E getData()
	{
		return this.data;
	}
	
	public void setData(E data)
	{
		this.data=data;
	}
	
	public Node<E> getPrevious()
	{
		return this.previous;
	}
	
	public void setPrevious(Node<E> previous)
	{
		this.previous=previous;
	}	
	
	public Node<E> getNext()
	{
		return this.next;
	}
	
	public void setNext(Node<E> next)
	{
		this.next=next;
	}	
}
