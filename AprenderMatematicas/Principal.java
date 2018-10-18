import java.awt.BorderLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Principal extends JFrame
{ 
	private PanelControles pc;
	private PanelDibujo pd;
	
	public Principal()
	{ 
		super("Sumas y Restas");
		this.setLocation(50, 50);
		this.setResizable(false);
		
		this.pc=new PanelControles();
		this.pd=new PanelDibujo(this.pc);
		this.pc.setPanelDibujo(this.pd);
		
		this.add(this.pc, BorderLayout.WEST);
		this.add(this.pd);
		
		this.pack();
	}
	
	public static void main(String[] args)
	{
		Principal ventana=new Principal();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}