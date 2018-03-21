package Stack;

public interface Stack_Interface<E>
{	
	public int getSize();			//Devuelve la cantidad de elementos del stack.
	public void push(E data);		//Inserta un elemento en el stack.
	public E pop();					//Saca y devuelve el elemento de la cima.
	public E top();					//Devuelve el elemento de la cima.
	public boolean isEmpty();		//Devuelve true si el stack está vacio, de lo contrario devuelve false.
	public void clear();			//Vacia el stack.
	public String toString();		//Muestra el contenido de todo el stack.
	public boolean contain();
}
