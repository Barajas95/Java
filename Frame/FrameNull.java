import javax.swing.JFrame;

public class FrameNull
{
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setTitle("Frame");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		//frame.pack();
		frame.setVisible(true);
	}	
}
