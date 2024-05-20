package CajeroAutomatico;
import java.util.Scanner;
//clase hija abstracta  cajero
public abstract class Cajero extends Sistema {
	Scanner cin = new Scanner(System.in);
	protected int retiro, retiroSinCard, deposito;
	protected float transaccion;
	public Cajero(String namesUser,String pswUser, String id_CardUser, float balanceUser, int retiro, int retiroSinCard, int deposito, float transaccion) {
		super(namesUser, pswUser, id_CardUser, balanceUser);
		this.retiro = retiro;
		this.retiroSinCard = retiroSinCard;
		this.deposito = deposito;
		this.transaccion = transaccion;
	}
	@Override
	public void SistemaCajero(){
		int menuOptions;
		System.out.println("\n\t\tTRANSACCIONES");
		System.out.println("\t[1] CONSULTA");
		System.out.println("\t[2] RETIRO");
		System.out.println("\t[3] RETIRO SIN TARJETA");
		System.out.println("\t[4] DEPOSITO");
		System.out.println("\t[5] SALIR");
		System.out.print("\nSELECCIONES UNA OPCION CORRECTA:");
		menuOptions = cin.nextInt();
		switch(menuOptions){
			case 1:
				//Creamos las instancias para los objetos usando el metodo CheckBalance() que es el polimosfismo
				Cajero mensaje1 = new Consulta(namesUser, pswUser, id_CardUser, balanceUser);
				mensaje1.CheckBalance();
				SistemaCajero();
				break;
			case 2:
				//Creamos las instancias para los objetos usando el metodo CheckBalance() que es el polimosfismo
				Cajero mensaje2 = new Retiro(id_CardUser, id_CardUser, id_CardUser, transaccion, transaccion);
				mensaje2.CheckBalance();
				SistemaCajero();
				break;
			case 3:
				//Creamos las instancias para los objetos usando el metodo CheckBalance() que es el polimosfismo
				Cajero mensaje3 = new RetiroSinTarjeta(id_CardUser, id_CardUser, id_CardUser, transaccion, transaccion);
				mensaje3.CheckBalance();
				SistemaCajero();
				break;
			case 4:
				//Creamos las instancias para los objetos usando el metodo CheckBalance() que es el polimosfismo
				Cajero mensaje4 = new Deposito(id_CardUser, id_CardUser, id_CardUser, transaccion);
				mensaje4.CheckBalance();
				SistemaCajero();
				break;
			case 5:
				System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
									"\nSALISTE CON EXITO...VUELVA PRONTO.."+
									"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
				break;
			default:
				System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
						"\nSELECCIONES UNA OPCION CORRECTA...VUELVA A INTENTARLO.."+
						"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
				SistemaCajero();
		}
	}
	//Metodo Abstracto consulta de saldo
	public abstract void CheckBalance();
	
	
	//Metodo para solicitar cantidad de retiro
	public void Retiro() {
		retiro = cin.nextInt();
	}
	//Metodo para solicitar cantidad de retiro sin tarjeta
	public void RetiroSinCard() {
		retiroSinCard = cin.nextInt();
	}
	//Metodo para solicitar cantidad de deposito
	public void Deposito() {
		deposito = cin.nextInt();
	}
	//
}
