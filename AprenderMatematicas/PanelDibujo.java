import java.awt.AWTException;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelDibujo extends JPanel implements ActionListener, KeyListener
{
	private PanelControles pc;
	private JButton boton;
	private JTextField texto;
	private Matematicas[] arreglo;
	private Image fondo;
	private GregorianCalendar calendario;
	private Font 	font1,
					font2,
					font3,
					font4;
	private JPanel panel;
	private JLabel 	label1,
					label2,
					label3,
					label4,
					label5,
					label6,
					label7,
					label8;
	
	private int contador,
				correcto,
				contadorOperaciones,
				x;
	private boolean creado;
	private String operacionGeneral;
	
	public PanelDibujo(PanelControles pc)
	{
		super();																		//Configurar panel
		this.setPreferredSize(new Dimension(700, 500));
		this.setLayout(null);
		
		this.fondo=new ImageIcon("1.jpg").getImage();									//Configurar atributos
		this.calendario=new GregorianCalendar();
		this.pc=new PanelControles();
		this.pc=pc;
		this.font1=new Font("TimesNewRoman", Font.PLAIN, 70);
		this.font2=new Font("TimesNewRoman", Font.PLAIN, 20);
		this.font3=new Font("TimesNewRoman", Font.PLAIN, 100);
		this.font4=new Font("TimesNewRoman", Font.PLAIN, 50);
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.label1=new JLabel("");
		this.label2=new JLabel("");
		this.label3=new JLabel("");
		this.label4=new JLabel("");
		this.label5=new JLabel("");
		this.label6=new JLabel("");
		this.label7=new JLabel("");
		this.label8=new JLabel("");
		this.operacionGeneral="";
		
		this.boton=new JButton("Verificar");											//Botones
		this.add(this.boton);
		this.boton.setBounds(380, 310, 100, 50);
		this.boton.addActionListener(this);
		this.boton.setVisible(false);
		
		this.texto=new JTextField();													//Cuadro de texto
		this.texto.setFont(this.font1);
		this.add(this.texto);
		this.texto.setBounds(250, 310, 100, 70);
		this.texto.setBackground(new Color(78, 130, 82));
		this.texto.setForeground(Color.WHITE);
		this.texto.setCursor(getCursor());
		this.texto.setHorizontalAlignment(JTextField.RIGHT);
		this.texto.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.texto.addKeyListener(this);
		this.texto.setVisible(false);
		
		this.panel.setBounds(220, 180, 360, 200);										//Minipanel
		this.panel.setBackground(Color.GREEN);
		this.panel.setVisible(false);
		this.add(this.panel);
		this.panel.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				PanelDibujo.this.add(PanelDibujo.this.boton);
				PanelDibujo.this.add(PanelDibujo.this.texto);
				PanelDibujo.this.panel.setVisible(false);
			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				
			}
		});
	}
	
	public void setArreglo()															//Recibe el arreglo, pues ya se selecciono alguna opcion dese el panel de control, ya se selecciono una opcion
	{
		this.arreglo=this.pc.getArreglo();
		this.creado=true;
		this.repaint();
	}
	
	public void paintComponent(Graphics g)												//Pintar
	{
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(), this.getHeight(), null);
		g.setFont(this.font1);
		if(!this.pc.getOpcionSeleccionada())
		{
			g.setColor(Color.BLACK);
			g.setFont(this.font1);
			g.drawString("Sumas y Restas", 170, 80);
			g.setFont(this.font3);
			g.setColor(Color.WHITE);
			g.drawString("Selecciona", 75, 280);
 			g.drawString("un nivel", 155, 400);
 			this.boton.setVisible(false);
			this.texto.setVisible(false);
		}
		
		if(this.creado)
		{	
			this.texto.setSize(this.talla(), 70);
			this.boton.setLocation(280 + this.talla(), 310);
			
			g.setColor(new Color(0, 162, 232));
			g.setFont(this.font2);
			g.drawString(this.contador + "/" + this.arreglo.length + " Operaciones", 50, 200);
			g.setColor(new Color(237, 28, 36));
			g.setFont(this.font2);
			g.drawString(this.correcto + "/" + this.contador + " Correctas", 50, 230);
			
			g.setFont(this.font1);
			g.setColor(new Color(255, 255, 255));
			g.drawString(String.valueOf(this.arreglo[this.contador].getNumero1()) + this.arreglo[this.contador].getSigno(), this.x + 260, 230);
			g.drawString(String.valueOf(this.arreglo[this.contador].getNumero2()), this.x + 260, 300);
			
			this.boton.setVisible(true);
			this.texto.setVisible(true);
		}
	}
	
	public int talla()
	{	
		if(this.arreglo[this.contador].getModo()==1)
		{
			this.x=0;
			return 50;
		}
		else if(this.arreglo[this.contador].getModo()==2)
		{
			this.x=10;
			return 100;
		}
		else if(this.arreglo[this.contador].getModo()==3)
		{
			this.x=60;
			return 150;
		}
		else
		{
			this.x=70;
			return 200;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(this.arreglo[this.contador].getNumero3()==Integer.parseInt(this.texto.getText()))					//Si el resultado es correto
			{
				this.panel.setVisible(false);
				this.arreglo[this.contador].setResultado(true);
				this.correcto++;
				this.playAudio(1);
			}
			else																									//Si el resultado es incorrecto
			{	
				this.arreglo[this.contador].setResultado(false);
				this.playAudio(2);
				this.panel.setVisible(true);
				this.asignarValoresPanel();
				this.remove(this.boton);
				this.remove(this.texto);
			}
			this.operacionGeneral+="OPERACION: " + this.arreglo[this.contador].toString() + " .RESULTADO INTRODUCIDO: "+ this.texto.getText() + ". " + this.arreglo[this.contador].getResultado() + ",";
			this.contador++;
			this.contadorOperaciones++;
			this.texto.setText("");
			this.restartArreglo();
			this.repaint();
		}
			
		catch (NumberFormatException f)
		{
			JOptionPane.showMessageDialog(this, "INGRESA UN NUMERO");
			this.texto.setText("");
		}
	}
	
	private void asignarValoresPanel()
	{
		this.label1.setFont(this.font4);
		this.label2.setFont(this.font4);
		this.label3.setFont(this.font4);
		this.label4.setFont(this.font4);
		this.label5.setFont(this.font4);
		this.label6.setFont(this.font4);
		this.label7.setFont(this.font2);
		this.label8.setFont(this.font2);
		
		this.label1.setText(this.arreglo[this.contador].getNumero1() + " " + this.arreglo[this.contador].getSigno());
		this.label2.setText(this.arreglo[this.contador].getNumero2() + "");
		this.label3.setForeground(Color.RED);
		this.label3.setText(this.texto.getText());
		this.label4.setText(this.arreglo[this.contador].getNumero1() + " " + this.arreglo[this.contador].getSigno());
		this.label5.setText(this.arreglo[this.contador].getNumero2() + "");
		this.label6.setForeground(Color.BLUE);
		this.label6.setText(this.arreglo[this.contador].getNumero3() + "");
		this.label7.setText("TU RESPUESTA");
		this.label8.setText("LA CORRECTA");
		
		this.label7.setBounds(0, 0, 150, 20);
		this.label1.setBounds(10, 50, 200, 50);
		this.label2.setBounds(10, 100, 200, 50);
		this.label3.setBounds(10, 150, 200, 50);
		this.label8.setBounds(190, 0, 150, 20);
		this.label4.setBounds(190, 50, 200, 50);
		this.label5.setBounds(190, 100, 200, 50);
		this.label6.setBounds(190, 150, 200, 50);
		
		this.panel.add(this.label1);
		this.panel.add(this.label2);
		this.panel.add(this.label3);
		this.panel.add(this.label4);
		this.panel.add(this.label5);
		this.panel.add(this.label6);
		this.panel.add(this.label7);
		this.panel.add(this.label8);
	}

	public void restartArreglo()
	{
		if(this.contador>(this.arreglo.length-1))
		{
			this.contador=0;
			this.creado=false;
			this.pc.setOpcionSeleccionada(false);
			this.repaint();
			this.playAudio(3);
			JOptionPane.showMessageDialog(this, "PARTIDA TERMINADA. Aciertos correctos: " + this.correcto);
		}
	}
	
	@SuppressWarnings("deprecation")
	public void hacerReporte()
	{
		try
		{
			StringTokenizer st=new StringTokenizer(operacionGeneral, ",");
			PrintWriter pw=new PrintWriter(new FileWriter("reporte.txt",true));
			pw.println("REPORTE GENERADO DEL JUEGO EN " + this.calendario.getTime().toLocaleString());
			for(int i=0; i<this.contadorOperaciones; i++)
			{
				pw.println(st.nextToken());
			}
			pw.println();
			this.operacionGeneral="";
			this.contadorOperaciones=0;
			pw.close();
		}
		
		catch(IOException e)
		{
			System.out.println("Error de IO " + e);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			this.boton.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{	
		 try 
		 {
			 Robot robot = new Robot();
			 if(e.getKeyCode()==8)
			 {
				 this.texto.setText("");
			 }
			 else
			 {
				 robot.keyPress(KeyEvent.VK_LEFT);
			 }
		 }
		 
		 catch (AWTException f)
		 {
			 f.printStackTrace();
		 }
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	public void playAudio(int status)
	{
		String soundName;
		if(status==1)
		{
			soundName="correcto.wav";
		}
		else if(status==2)
		{
			soundName="incorrecto.wav";
		}
		else
		{
			soundName="terminado.wav";
		}
		AudioInputStream audioInputStream;
		try
		{
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}

		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{ 		
			e.printStackTrace();
		}
	}
}