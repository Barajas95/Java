import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelControles extends JPanel implements ActionListener
{
	private JLabel 	instruccion1,														//Atributos
					instruccion2;
	private JRadioButton 	suma,
							resta;
	private JButton nivel1,
					nivel2,
					nivel3,
					nivel4,
					reporte;
	private Matematicas matematicas;
	private Matematicas[] arreglo;
	private PanelDibujo pd;
	private Font 	font1,
					font2;
	private Color color;
	
	private boolean opcionSeleccionada;
	
	public PanelControles()
	{
		super();																		//Configuracion del panel
		setLayout(new GridLayout(9, 1));
		this.setBackground(Color.CYAN);
		
		this.matematicas=new Matematicas();												//Inicializar atributos
		//Si se modifica el numero de elementos del arreglo, seran la cantidad de operaciones a realizar por cada seccion
		this.arreglo=new Matematicas[20];
		this.font1=new Font("TimesNewRoman", Font.PLAIN, 20);
		this.font2=new Font("TimesNewRoman", Font.PLAIN, 30);
		
		this.instruccion1=new JLabel("¡TÚ ESCOJES!");									//Instruccion 1
		this.instruccion1.setFont(this.font1);
		this.add(this.instruccion1);
		
		this.suma=new JRadioButton("Suma", true);										//Radio buttons
		this.suma.setFont(this.font2);
		this.resta=new JRadioButton("Resta");
		this.resta.setFont(this.font2);
		ButtonGroup operacion=new ButtonGroup();
		operacion.add(this.suma);
		operacion.add(this.resta);
		this.suma.addActionListener(this);
		this.resta.addActionListener(this);
		this.add(this.suma);
		this.add(this.resta);
		this.suma.setBackground(Color.CYAN);
		this.resta.setBackground(Color.CYAN);
		this.matematicas.setSigno("+");
		
		this.instruccion2=new JLabel("SELECCIONA UN NIVEL");							//Instruccion 2
		this.instruccion2.setFont(this.font1);
		this.add(this.instruccion2);
		
		this.nivel1=new JButton("1 dígito");											//Niveles
		this.nivel1.setFont(this.font1);
		this.nivel1.addActionListener(this);
		this.add(this.nivel1);
		this.color=this.nivel1.getBackground();
		
		this.nivel2=new JButton("2 dígitos sin llevar");
		this.nivel2.setFont(this.font1);
		this.nivel2.addActionListener(this);
		this.add(this.nivel2);
		
		this.nivel3=new JButton("2 dígitos con llevar");
		this.nivel3.setFont(this.font1);
		this.nivel3.addActionListener(this);
		this.add(this.nivel3);
		
		this.nivel4=new JButton("3 dígitos");
		this.nivel4.setFont(this.font1);
		this.nivel4.addActionListener(this);
		this.add(this.nivel4);
		
		this.reporte=new JButton("Reporte");											//Reporte
		this.reporte.setFont(this.font1);
		this.reporte.addActionListener(this);
		this.add(this.reporte);
	}
	
	public void setPanelDibujo(PanelDibujo pd)											//Setter
	{
		this.pd=pd;
	}
	
	public void setOpcionSeleccionada(boolean opcionSeleccionada)
	{
		this.opcionSeleccionada=opcionSeleccionada;
		this.matematicas.setModo(0);
		this.nivel1.setBackground(this.color);
		this.nivel2.setBackground(this.color);
		this.nivel3.setBackground(this.color);
		this.nivel4.setBackground(this.color);
	}
	
	public Matematicas[] getArreglo()													//Getter
	{
		return this.arreglo;
	}
	
	public boolean getOpcionSeleccionada()
	{
		return this.opcionSeleccionada;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)											//Eventos
	{
		if(e.getSource()==this.suma)
		{
			this.matematicas.setSigno("+");
		}
		if(e.getSource()==this.resta)
		{
			this.matematicas.setSigno("-");
		}
		if(e.getSource()==this.nivel1)
		{
			this.nivel1.setBackground(Color.YELLOW);
			this.nivel2.setBackground(this.color);
			this.nivel3.setBackground(this.color);
			this.nivel4.setBackground(this.color);
			this.matematicas.setModo(1);
		}
		if(e.getSource()==this.nivel2)
		{
			this.nivel1.setBackground(this.color);
			this.nivel2.setBackground(Color.YELLOW);
			this.nivel3.setBackground(this.color);
			this.nivel4.setBackground(this.color);
			this.matematicas.setModo(2);
		}
		if(e.getSource()==this.nivel3)
		{
			this.nivel1.setBackground(this.color);
			this.nivel2.setBackground(this.color);
			this.nivel3.setBackground(Color.YELLOW);
			this.nivel4.setBackground(this.color);
			this.matematicas.setModo(3);
		}
		if(e.getSource()==this.nivel4)
		{
			this.nivel1.setBackground(this.color);
			this.nivel2.setBackground(this.color);
			this.nivel3.setBackground(this.color);
			this.nivel4.setBackground(Color.YELLOW);
			this.matematicas.setModo(4);
		}
		
		if(e.getSource()==this.reporte)
		{
			this.reporte.setBackground(Color.ORANGE);
			this.pd.hacerReporte();
			JOptionPane.showMessageDialog(this.pd, "El archivo con el reporte se ha generado.");
			this.reporte.setBackground(this.color);
		}
		
		if(this.matematicas.getSigno()!="" && this.matematicas.getModo()!=0)
		{
			for(int i=0; i<this.arreglo.length; i++)
			{
				this.arreglo[i]=new Matematicas();
				this.arreglo[i].setSigno(this.matematicas.getSigno());
				this.arreglo[i].setModo(this.matematicas.getModo());
				this.arreglo[i].obtenerAleatorio();
			}
			this.opcionSeleccionada=true;
			this.pd.setArreglo();
		}
	}
}