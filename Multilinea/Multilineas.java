import javax.swing.*;
import java.awt.*;

public class Multilineas extends JPanel
{
	protected static Multilineas pn;
	protected int 	x,
					y;
	
	public Multilineas()
	{
		super();
		this.setPreferredSize(new Dimension(600, 600));
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
		/*
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
		*/
	}

	public static void main(String[] args) 
	{
		JFrame window=new JFrame("Multilineas");
		pn = new Multilineas();
		
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.add(pn);
		window.pack();
		window.setVisible(true);
	}
}