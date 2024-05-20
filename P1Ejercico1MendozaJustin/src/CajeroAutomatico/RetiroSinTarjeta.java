package CajeroAutomatico;

public class RetiroSinTarjeta extends Cajero{
	public RetiroSinTarjeta(String namesUser, String pswUser, String id_CardUser, float balanceUser, int retiro, int retiroSinCard, int deposito, float transaccion) {
		super(namesUser, pswUser, id_CardUser, balanceUser, retiro, retiroSinCard, deposito, transaccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void CheckBalance(){
		System.out.print("\nCUANTO DESEAS RETIRAR: [10 A 350; *10]");
		RetiroSinCard();
		while(retiroSinCard<10 || retiroSinCard>350 || retiroSinCard % 10 !=0) {
			System.out.print("\nVUELVE A INGRESAR UN VALOR VALIDO "+
								"\nCUANTO DESEAS RETIRAR: [10 A 350; *10]");
			RetiroSinCard();
		}
		if(retiroSinCard<=GetBalanceUser()) {
			transaccion = GetBalanceUser();
			SetBalanceUser(transaccion-retiroSinCard);
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nRetiraste: $"+retiroSinCard+
								"\nTu saldo disponible es: $"+GetBalanceUser()+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}else {
			System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
								"\nSALDO INSUFICINTE......"+
								"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		}
	}
}
