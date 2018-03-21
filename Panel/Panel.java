import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Panel extends JFrame
{
	public Panel()
	{
		
	}
	
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setTitle("Frame");
		
		//Layout
		frame.setLayout(null);
		frame.setLayout(new FlowLayout());
		frame.setLayout(new GridLayout());
		
		
		frame.setBackground(new Color(200, 200, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		//frame.pack();
		frame.setVisible(true);
	}
	
	
}
