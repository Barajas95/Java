import java.util.Random;

public class Matematicas
{ 
	private Random aleatorio;												//Atributos
	private int numero1,
				numero2,
				numero3,
				modo;	
	private String signo;
	private String resultado;
	
	public Matematicas()													//Constructor
	{
		this.aleatorio=new Random();
		this.signo="";
	}

	public void setSigno(String signo)										//Setters
	{
		this.signo=signo;
	}
	
	public void setModo(int modo)
	{
		this.modo=modo;
	}
	
	public void setResultado(boolean a)
	{
		this.resultado=(a)?"Correcto":"Incorrecto";
	}
	
	public int getNumero1()													//Getters
	{
		return this.numero1;
	}
	
	public int getNumero2()
	{
		return this.numero2;
	}
	
	public int getNumero3()
	{
		return this.numero3;
	}
	
	public String getResultado()
	{
		return this.resultado;
	}
	
	public int getModo()
	{
		return this.modo;
	}
	
	public String getSigno()
	{
		return this.signo;
	}
	
	public String toString()
	{
		return (this.numero1 + " " + this.getSigno() + " " + this.numero2 + " = " + this.numero3);
	}
		
	public void obtenerAleatorio()											//Obtener los numeros aleatoriamente
	{
		if(this.signo=="+")
		{
			switch(this.modo)
			{
				case 1:
						//Suma de un solo digito sin acarreo
						do
						{
							this.numero1=this.aleatorio.nextInt(9);
							this.numero2=this.aleatorio.nextInt(9);
						} while (this.numero1+this.numero2>9 || this.numero1==0 || this.numero2==0);
						break;
				case 2:
						//Suma de dos digitos sin acarreo
						do
						{
							this.numero1=this.aleatorio.nextInt(99);
							this.numero2=this.aleatorio.nextInt(99);
						} while(this.numero1%10+this.numero2%10>9 || this.numero1%100/10+this.numero2%100/10>9 || this.numero1<10 || this.numero2<10);
						break;
				case 3:
						//Suma de dos digitos con acarreo
						do
						{
							this.numero1=this.aleatorio.nextInt(99);
							this.numero2=this.aleatorio.nextInt(99);
						} while(this.numero1%10+this.numero2%10<10 || this.numero1%100/10+this.numero2%100/10<10 || this.numero1<10 || this.numero2<10);
						break;
				case 4:
						//Suma
						do
						{
							this.numero1=this.aleatorio.nextInt(999);
							this.numero2=this.aleatorio.nextInt(999);
						} while(this.numero1<100 || this.numero2<100);
						break;
				default:
						System.out.println("No corresponde a ningun caso");
						break;
			}
			this.numero3=this.numero1+this.numero2;
		}
		else
		{
			switch(this.modo)
			{
			case 1:
					//Resta de un solo digito sin negativos
					do
					{
						this.numero1=this.aleatorio.nextInt(9);
						this.numero2=this.aleatorio.nextInt(9);
					} while (this.numero1-this.numero2<0 || this.numero1==0 || this.numero2==0);
					break;
			case 2:
					//Resta de dos digitos sin prestamo ni negativos
					do
					{
						this.numero1=this.aleatorio.nextInt(99);
						this.numero2=this.aleatorio.nextInt(99);
					} while(this.numero1%10-this.numero2%10<0 || this.numero1%100/10-this.numero2%100/10<0 || this.numero1<10 || this.numero2<10);
					break;
			case 3:
					//Resta de dos digitos con prestamo pero sin negativos
					do
					{
						this.numero1=this.aleatorio.nextInt(99);
						this.numero2=this.aleatorio.nextInt(99);
					} while(this.numero1%10-this.numero2%10>-1 || ((this.numero1%100/10)-1)-this.numero2%100/10<0 || this.numero1<10 || this.numero2<10);
					break;
			case 4:
					//Resta sin negativos
				do
				{
					this.numero1=this.aleatorio.nextInt(999);
					this.numero2=this.aleatorio.nextInt(999);
				} while(this.numero1<100 || this.numero2<100 || this.numero1-this.numero2<0);
				break;
			default:
				System.out.println("No corresponde a ningun caso");
				break;
			}
			this.numero3=this.numero1-this.numero2;
		}
	}
}