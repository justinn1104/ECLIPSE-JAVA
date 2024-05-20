package CajeroAutomatico;
import java.util.Scanner;
public class User extends Sistema{
	Scanner cin = new Scanner(System.in);
	protected String name1, name2, lastName1, lastName2, password, numeroAccount, cedula; 
	public User(String namesUser, String pswUser, String id_CardUser, float balanceUser, String name1, String name2, String lastName1, String lastName2, String password, String numeroAccount, String cedula) {
		super(namesUser, pswUser, id_CardUser, balanceUser);
		this.name1 = name1;
		this.name2 = name2;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.password = password;
		this.numeroAccount = numeroAccount;
		this.cedula = cedula;
	}
	public String GetName1() {
		return name1;
	}
	public void SetName1(String name1) {
		name1 = cin.nextLine();
	}
	public String GetName2() {
		return name2;
	}
	public void SetName2(String name2) {
		name2 = cin.nextLine();
	}
	public String GetLastName1() {
		return lastName1;
	}
	public void SetLastName1(String lastName1) {
		lastName1 = cin.nextLine();
	}
	public String GetLastName2() {
		return lastName2;
	} 
	public void SetLastName2(String lastName2) {
		lastName2 = cin.nextLine();
	}
	public String GetPassword() {
		return  password;
	}
	public void SetPassword(String password) {
		password = cin.nextLine();
	}
	public String GetNumeroAccount() {
		return numeroAccount;
	}
	public void SetNumeroAccount(String numeroAccount) {
		numeroAccount = cin.nextLine();
	}
	public String GetCedula() {
		return cedula;
	}
	public void SetCedula(String cedula) {
		cedula = cin.nextLine();
	}
	
}
