import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList_Iterator<E> implements Iterator<E>
{
	private Node<E> current;
	private Node<E> lastReturned;

	public DoubleLinkedList_Iterator(Node<E> inicio)
	{
		this.current=inicio;
		this.lastReturned=null;
	}
	
	public boolean hasNext()
	{
		return this.current!=null;
	}

	public E next()
	{
		if(!this.hasNext())
		{
			throw new NoSuchElementException("No hay elementos");
		}
		this.current=this.current.getNext();
		return lastReturned.getData();
	}
}
