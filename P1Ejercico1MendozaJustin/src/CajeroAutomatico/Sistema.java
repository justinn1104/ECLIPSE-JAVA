package CajeroAutomatico;
import java.util.Scanner;
//clase madre abstracta  sistema
public abstract class Sistema {
	Scanner cin = new Scanner(System.in);
	protected String namesUser, pswUser, id_CardUser;
	protected float balanceUser;
	public Sistema(String namesUser, String pswUser, String id_CardUser, float balanceUser) {
		this.namesUser = namesUser;
		this.pswUser = pswUser;
		this.id_CardUser = id_CardUser;
		this.balanceUser = balanceUser;
	}
	//encapsulamiento de metotodos getter y setter
	public String GetNamesUser() {
		return namesUser;
	}
	public void SetNamesUser(String namesUser) {
		namesUser = cin.nextLine();
	}
	public String GetPswUser() {
		return pswUser;
	}
	public void SetPswUser(String pswUser) {
		pswUser = cin.nextLine();
	}
	public String GetId_CardUser() {
		return id_CardUser;
	}
	public void SetId_CardUser(String id_CardUser) {
		id_CardUser = cin.nextLine();
	}
	public float GetBalanceUser() {
		return balanceUser;
	}
	public void SetBalanceUser(float balanceUser) {
		this.balanceUser = balanceUser;
	}
	public abstract void SistemaCajero();
}
