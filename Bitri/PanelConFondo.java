import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelConFondo extends JPanel
{
	private Image imagen;
	private Color color;
	
	public PanelConFondo(Image imagen)
	{
		this.imagen=imagen;
		this.repaint();
	}
	
	public PanelConFondo(Color color)
	{
		this.color=color;
		this.setBackground(this.color);
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
