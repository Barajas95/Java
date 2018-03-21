import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

@SuppressWarnings("serial")
public class Bitri
{
	private static PanamaHitek_Arduino ino=new PanamaHitek_Arduino();
	private static final SerialPortEventListener listener=new SerialPortEventListener()
    {
        public void serialEvent(SerialPortEvent e)
        {
            try
            {
                if (ino.isMessageAvailable())
                {
                    System.out.println(ino.printMessage());
                }
            }
            catch (SerialPortException | ArduinoException f)
            {
                Logger.getLogger(Bitri.class.getName()).log(Level.SEVERE, null, f);
            }
        }
    };
    
    public Bitri()
    {
        try
        {
            ino.arduinoRXTX("COM4", 9600, listener);
        }
        catch (ArduinoException e)
        {
            Logger.getLogger(Bitri.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
	public static void main(String[] args)
	{
		new Bitri();
		Customer cliente1=null;
		Queue queue=new Queue();
		Scanner scanner = new Scanner(System.in);
		
		boolean salir1=false;
		boolean salir2=false;
		boolean salir3=false;
		boolean salir4=false;
		
		int opcion1,
			opcion2,
			opcion3;
		
		do
		{
			System.out.println("INGRESAR JEFE 		(1) ");
			System.out.println("INGRESAR CLIENTE	(2) ");
			System.out.println("SALIR				(3) ");
			System.out.println("PRUEBA ON			(7) ");
			System.out.println("PRUEBA OFF			(8) ");
			System.out.print("Selecciona una opcion: ");
			opcion1=scanner.nextInt();
			switch(opcion1)
			{
				case 1:	
							do
							{
								System.out.println("CREAR CLIENTE	(1) ");
								System.out.println("VER CLIENTES 	(2) ");
								System.out.println("SALIR		 	(3) ");
								System.out.print("Selecciona una opcion: ");
								opcion2=scanner.nextInt();
								switch(opcion2)
								{
									case 1:
												System.out.print("INGRESA EL NOMBRE DEL CLIENTE: ");
												String nombre=scanner.next();
												cliente1=new Customer(nombre);
												break;
									case 2:
												break;
									case 3:
												salir2=true;
												break;
								}
								
							}while(salir2==false);
							salir2=false;
							break;
				case 2:
							do
							{
								System.out.println("CREAR PEDIDO 					(1) ");
								System.out.println("CANTIDAD DE PEDIDOS TOTALES 	(2) ");
								System.out.println("BUSCAR PEDIDO 					(3) ");
								System.out.println("VER PEDIDOS 					(4) ");
								System.out.println("SALIR		 					(5) ");
								System.out.print("Selecciona una opcion: ");
								opcion3=scanner.nextInt();
								switch(opcion3)
								{
									case 1:
												int dato;
												int[] datos1=new int[10];		//Maxima cantidad de colores que puede tener un paquete
												int[] datos2;
												int contador=0;
												System.out.println("PARA SALIR PRESIONA 9");
												do
												{
													System.out.print("INGRESA NUMERO DEL COLOR: ");
													dato=scanner.nextInt();
													if(dato==9)
													{
														salir4=true;
													}
													else
													{
														datos1[contador]=dato;
														contador++;
													}
													
													if(contador>9)
													{
														salir4=true;
													}
												}while(salir4==false);
												datos2=new int[contador];
												for(int i=0; i<contador; i++)
												{
													datos2[i]=datos1[i];
												}
												contador=0;
												salir4=false;
												cliente1.addPedido(datos2);
												queue.enQueue(datos2);
												break;
									case 2:
												cliente1.imprimirCantidadPedidos();
												break;
									case 3:
												String busqueda="";
												System.out.print("INGRESA LOS COLORES QUE DESEAS BUSCAR separados por coma: ");
												busqueda=scanner.next();
												/*char[] colores1=busqueda.toCharArray();
												int[] colores2=null;
												for(int i=0; i<colores1.length; i++)
												{
													colores2[i]=(int) colores1[i];
												}
												cliente1.paqueteExistente(colores2);
												*/
												break;
									case 4:
												cliente1.imprimirHistorial();
												break;
									case 5:
												salir3=true;;
												break;
									default:
												break;
								}
								
							}while(salir3==false);
							salir3=false;
							break;
				case 3:
							salir1=true;
							break;
				case 7:
							try
							{
									ino.sendByte(3);
									ino.sendByte(1);
									ino.sendByte(3);
									ino.sendByte(1);
									
									ino.sendByte(1);
									ino.sendByte(1);
									ino.sendByte(1);
									ino.sendByte(1);
							}
							catch (ArduinoException | SerialPortException ex)
							{
								Logger.getLogger(Bitri.class.getName()).log(Level.SEVERE, null, ex);
							}
							break;
				case 8:
							try
							{
								ino.sendData("2");
							}
							catch (ArduinoException | SerialPortException ex)
							{
								Logger.getLogger(Bitri.class.getName()).log(Level.SEVERE, null, ex);
							}
							break;
				default:
							break;
			}
		}while(salir1==false);
	}
}