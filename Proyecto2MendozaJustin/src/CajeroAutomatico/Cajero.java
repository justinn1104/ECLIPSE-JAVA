package CajeroAutomatico;
import java.util.Scanner;
public class Cajero {
	static Scanner cin = new Scanner(System.in);
	protected int retiro, retiroSinCard, deposito, transaccion, saldo;
	protected String pswSystem;
	protected boolean stateSystemCard;
	public void CredentialSystem() {
		
		SistemaCajero();
	}
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
				//Creamos las instan
				ConsultarSaldo();
				SistemaCajero();
				break;
			case 2:
				//Creamos 
				RetirarDinero();
				SistemaCajero();
				break;
			case 3:
				//Creamos las instancias para los objetos usando el metodo CheckBalance() que es el polimosfismo
				RetirarDineroSinTarjeta();
				SistemaCajero();
				break;
			case 4:
				//Creamos las
				DepositarDinero();
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
	//public void CheckBalance();
	
	
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
	public int GetSaldo() {
		return saldo;
	}
	public void SetSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	//
	public void ConsultarSaldo(){
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
							"\nTU SALDO DISPONIBLE ES DE: $"+GetSaldo()+
							"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	}
	public void DepositarDinero() {
		System.out.print("\nCUANTO DESEAS DEPOSITAR [5 A 2500]: ");
		Deposito();
		while(deposito<5||deposito>2500) {
			System.out.print("\nVUELVE A INGRESAR UNA CANTIDAD CORRECTA.."+
								"\nCUANTO DESEAS DEPOSITAR [5 A 2500]: ");
			Deposito();
		}
		transaccion = GetSaldo();
		SetSaldo(transaccion + deposito);
		System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
							"\nDepositaste: $"+deposito+
							"\nTu saldo disponible es: $"+GetSaldo()+
							"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		
	}
	public void RetirarDinero() {
		System.out.print("\nCUANTO DESEAS RETIRAR: [5 A 500; *5]");
		Retiro();
		while(retiro<5 || retiro>500 || retiro % 5 !=0) {
			System.out.print("\nVUELVE A INGRESAR UN VALOR VALIDO "+
								"\nCUANTO DESEAS RETIRAR: [5 A 500; *5]");
			Retiro();
		}
		if(retiro<=GetSaldo()) {
			transaccion = GetSaldo();
			SetSaldo(transaccion-retiro);
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nRetiraste: $"+retiro+
								"\nTu saldo disponible es: $"+GetSaldo()+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}else {
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nSALDO INSUFICINTE......"+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}
		
		
	}
	
	public void RetirarDineroSinTarjeta(){
		System.out.print("\nCUANTO DESEAS RETIRAR: [10 A 350; *10]");
		RetiroSinCard();
		while(retiroSinCard<10 || retiroSinCard>350 || retiroSinCard % 10 !=0) {
			System.out.print("\nVUELVE A INGRESAR UN VALOR VALIDO "+
								"\nCUANTO DESEAS RETIRAR: [10 A 350; *10]");
			RetiroSinCard();
		}
		if(retiroSinCard<=GetSaldo()) {
			transaccion = GetSaldo();
			SetSaldo(transaccion-retiroSinCard);
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nRetiraste: $"+retiroSinCard+
								"\nTu saldo disponible es: $"+GetSaldo()+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}else {
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nSALDO INSUFICINTE......"+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}
	}
	
}
