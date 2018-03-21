
public class Customer
{
	private String name;
	private LinkedList linkedList;
	
	public Customer(String name)
	{
		this.name=name;
		this.linkedList=new LinkedList();
	}
	
	public void addPedido(int[] colors)
	{
		this.linkedList.addFirst(colors);
		System.out.println("Paquete agregado con exito");
	}
	
	public void imprimirCantidadPedidos()
	{
		System.out.println(this.linkedList.getSize());
	}
	
	public void paqueteExistente(int [] colors)
	{
		System.out.println(this.linkedList.contains(colors));
	}
	
	public void imprimirHistorial()
	{
		System.out.println(this.linkedList.toString());
	}
	
}
