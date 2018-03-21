
public class Packet
{
	/*	Valores posibles dentro del array colors:
	 *			Negro 		(1)
	 *			Verde 		(2)
	 *			Amarillo	(3)
	 *			Blanco		(4)
	 *			Indefinido	(0)
	 *	La medida del arreglo dice la cantidad de colores por packete.
	*/
	
	private int[] colors;		//Orden de los colores.
	private Packet next;
	
	public Packet(int[] colors, Packet next)
	{
		this.colors = colors;
		this.next = next;
	}
	
	public int[] getColors()
	{
		return colors;
	}

	public void setColors(int[] colors)
	{
		this.colors = colors;
	}

	public Packet getNext()
	{
		return next;
	}

	public void setNext(Packet next)
	{
		this.next = next;
	}
	
	public String toString()
	{
		String temp="";
		for(int i=0; i<this.colors.length; i++)
		{
			if(i==this.colors.length-1)
			{
				temp=temp + this.colors[i];
			}
			else
			{
				temp=temp + this.colors[i] + ",";
			}
		}
		return temp;
	}
}
