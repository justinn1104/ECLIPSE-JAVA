package CajeroAutomatico;

public class Deposito extends Cajero{
	public Deposito(String namesUser, String pswUser, String id_CardUser, float balanceUser, int retiro, int retiroSinCard, int deposito, int transaccion) {
		super(namesUser, pswUser, id_CardUser, balanceUser, retiro, retiroSinCard, deposito, transaccion);
	}

	@Override
	public void CheckBalance() {
		System.out.print("\nCUANTO DESEAS DEPOSITAR: [5 A 2500]");
		Deposito();
		while(deposito<5||deposito>2500) {
			System.out.print("\nVUELVE A INGRESAR UNA CANTIDAD CORRECTA.."+
								"\nCUANTO DESEAS DEPOSITAR: [5 A 2500]");
			Deposito();
		}
		
		transaccion = (float) GetBalanceUser();
		SetBalanceUser(transaccion + deposito);
		System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
							"\nDepositaste: $"+deposito+
							"\nTu saldo disponible es: $"+GetBalanceUser()+
							"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		
	}
}
