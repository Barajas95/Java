import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Bitri extends JPanel
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
                Logger.getLogger(JavaRX.class.getName()).log(Level.SEVERE, null, f);
            }
        }
    };
    
    public Bitri()
    {
        try
        {
            ino.arduinoRXTX("COM3", 9600, listener);
        }
        catch (ArduinoException e)
        {
            Logger.getLogger(Bitri.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void main(String[] args)
    {
    	new Bitri();
	}
}
