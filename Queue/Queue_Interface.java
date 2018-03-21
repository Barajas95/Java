package Queue;

public interface Queue_Interface<E>
{	
	public boolean isEmpty();
	public int getSize();
	public boolean contain();
	public void clear();
	public void enQueue(E data);
	public E deQueue();
	public E getFirst();
	
}
