package LinkedList;

public interface LinkedList_Interface<E>
{	
	public boolean isEmpty(); 				//Devuelve true si la lista está vacía, false de lo contrario.
	public int getSize();					//Devuelve la cantidad de elementos de la lista.
	public boolean contains(E data); 		//Devuelve true si el ítem se encuentra en la lista, falso en caso contrario.
	public E get (int index);				//Devuelve el elemento en la posición índex de la lista.
	public int indexOf(E item); 			//Devuelve el entero que representa la posición de ítem en la lista. Si no existe en la lista devuelve -1.
	public void add(int index, E item); 	//Agrega el ítem a la lista en la posición índex si éste es válido.
	public E remove(int index); 			//Remueve el elemento que está en la posición índex de la lista.
	public String toString(); 				//Devuelve el contenido de la lista en un String.
	public void addFirst(E item);			//Agrega un elemento al principio de la lista.
	public void addLast(E item);			//Agrega un elemento al final de la lista
	public E removeFirst();					//Devuelve el primer elemento de la lista y lo elimina.
	public E removeLast();					//Devuelve el ultimo elemento de la lista y lo elimina.
	public E getFirst();					//Devuelve el primer elemento de la lista.
	public E getLast();						//Devuelve el ultimo elemento de la lista.
	public void clear();					//Elimina todos los elementos de la lista.
	public void replace(int index);			//Reemplaza el contenido de un elemento de la lista por otro.	
}
