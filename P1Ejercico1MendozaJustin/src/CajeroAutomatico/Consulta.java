package CajeroAutomatico;
//clase Hija consulta
public class Consulta extends Cajero{
	

	public Consulta(String namesUser, String pswUser, String id_CardUser, float balanceUser, int retiro, int retiroSinCard, int deposito, float transaccion) {
		super(namesUser, pswUser, id_CardUser, balanceUser, retiro, retiroSinCard, deposito, transaccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void CheckBalance(){
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°"+
							"\nTU SALDO DISPONIBLE ES DE: $"+GetBalanceUser()+
							"\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	}
}
