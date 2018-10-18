import java.awt.Graphics;
import javax.swing.JFrame;

public class Multilineas2 extends Multilineas
{
	public Multilineas2()
	{
		super();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		this.x=600;																	//Izquierda arriba
		this.y=0;
		for (int i=0; i<16; i++)
		{
			g.drawLine(0, 0, x, y);
			this.x-=40;
			this.y+=40;
		}

		this.x=0;																	//Derecha abajo
		this.y=600;
		for (int i=0; i<15; i++)
		{
			g.drawLine(600, 600, x, y);
			this.x+=40;
			this.y-=40;
		}
		
		this.x=600;																	//Izquierda abajo
		this.y=600;
		for (int i=0; i<15; i++)
		{
			g.drawLine(0, 600, x, y);
			this.x-=40;
			this.y-=40;
		}
		
		this.x=0;																	//Derecha arriba
		this.y=0;
		for (int i=0; i<15; i++)
		{
			g.drawLine(600, 0, x, y);
			this.x+=40;
			this.y+=40;
		}
	}
	
	public static void main(String[] args)
	{
		JFrame window2=new JFrame("Multilineas 2");
		pn = new Multilineas2();
		
		window2.setDefaultCloseOperation(window2.EXIT_ON_CLOSE);
		window2.add(pn);
		window2.pack();
		window2.setVisible(true);
	}
}