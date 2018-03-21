package LinkedList;

public interface LinkedList_Interface<E>
{	
	public boolean isEmpty(); 				//Devuelve true si la lista est� vac�a, false de lo contrario.
	public int getSize();					//Devuelve la cantidad de elementos de la lista.
	public boolean contains(E data); 		//Devuelve true si el �tem se encuentra en la lista, falso en caso contrario.
	public E get (int index);				//Devuelve el elemento en la posici�n �ndex de la lista.
	public int indexOf(E item); 			//Devuelve el entero que representa la posici�n de �tem en la lista. Si no existe en la lista devuelve -1.
	public void add(int index, E item); 	//Agrega el �tem a la lista en la posici�n �ndex si �ste es v�lido.
	public E remove(int index); 			//Remueve el elemento que est� en la posici�n �ndex de la lista.
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
