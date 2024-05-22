package CajeroAutomatico;
import java.util.Scanner;
public class Usuario {
	static Scanner cin = new Scanner(System.in);
	public String nameUser, lastNameUser, numberCard, cvvCard, typeCard, pwsUser;
	public boolean bloqued=false;
	public void GenerarUsuario() {
		Sistema system = new Sistema(nameUser, lastNameUser, numberCard, cvvCard, typeCard, pwsUser,bloqued);
		System.out.println("\n\n\tCREAR UN NUEVO USUARIO\n\n");
		System.out.println("INGRESA EL NOMBRE DEL USUARIO: ");
		nameUser = cin.nextLine();
		system.SetName(nameUser);
		System.out.println("INGRESA EL APELLIDO DEL USUARIO: ");
		lastNameUser = cin.nextLine();
		system.SetLastName(lastNameUser);
		System.out.println("INGRESA EL BANCO DE LA TARJETA DEL USUARIO: ");
		typeCard = cin.nextLine();
		system.SetType_Card(typeCard);
		System.out.print("INGRESA EL NUMERO DE LA TARJETA DEL USUARIO [10 DIGITOS]: ");
		numberCard = cin.nextLine();
		while(numberCard.length()!=10) {
			System.out.print("\nVUELVA A INGRESAR EL NUMERO DE LA TARJETA DEL USUARIO [10 DIGITOS]: ");
			numberCard = cin.nextLine();
		}
		system.SetNumCard(numberCard);
		System.out.print("\nINGRESA EL CODIGO DE SEGURIDAD DE LA TARJETA DEL USUARIO [3 DIGITOS]: ");
		cvvCard = cin.nextLine();
		while(cvvCard.length()!=3) {
			System.out.print("\nVUELVA A INGRESAR EL CODIGO DE SEGURIDAD DE LA TARJETA DEL USUARIO [3 DIGITOS]: ");
			cvvCard = cin.nextLine();
		}
		system.SetCodigoCvv(cvvCard);
		pwsUser = ValidaClave();
		system.SetPwsCard(pwsUser);
		system.UserGenerate();
		
	}
	public String  ValidaClave() {
		String clave;
		System.out.print("\nIngresa una clave [4 digitos]: ");
		clave = cin.next();
		while(clave.length()!=4) {
			System.out.print("\nVuelve a ingresar una clave [4 digitos]: ");
			clave = cin.next();
		}
		return clave;
	}
}
