package CajeroAutomatico;

public class Retiro extends Cajero{
	public Retiro(String namesUser, String pswUser, String id_CardUser, float balanceUser, int retiro, int retiroSinCard, int deposito, float transaccion) {
		super(namesUser, pswUser, id_CardUser, balanceUser, retiro, retiroSinCard, deposito, transaccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void CheckBalance() {
		System.out.print("\nCUANTO DESEAS RETIRAR: [5 A 500; *5]");
		Retiro();
		while(retiro<5 || retiro>500 || retiro % 5 !=0) {
			System.out.print("\nVUELVE A INGRESAR UN VALOR VALIDO "+
								"\nCUANTO DESEAS RETIRAR: [5 A 500; *5]");
			Retiro();
		}
		if(retiro<=GetBalanceUser()) {
			transaccion = GetBalanceUser();
			SetBalanceUser(transaccion-retiro);
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nRetiraste: $"+retiro+
								"\nTu saldo disponible es: $"+GetBalanceUser()+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}else {
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nSALDO INSUFICINTE......"+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}
		
		
	}
}
