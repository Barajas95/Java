
public interface DoubleLinkedList_Interface<E> 
{	
	public boolean isEmpty();
	public int getSize();
	public boolean contains(E data);
	public E get (int index);
	public int indexOf(E item);
	public void add(int index, E item);
	public E remove(int index);
	public String toString();
	public void addFirst(E item);
	public void addLast(E item);
	public E removeFirst();
	public E removeLast();
	public E getFirst();
	public E getLast();
	public void clear();
	public void replace(int index);	
}
