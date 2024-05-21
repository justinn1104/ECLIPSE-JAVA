package Cajero;
import java.util.Scanner;
public class Usuario {
	Scanner cin = new Scanner(System.in);
	public String nameUser, lastNameUser, numberCard, cvvCard, typeCard;
	public void GenerarUsuario() {
		System.out.println("\t\tCREA TU USUARIO\n\n");
		System.out.println("INGRESA EL NOMBRE DEL USUARIO: ");
		nameUser = cin.nextLine();
		System.out.println("INGRESA EL APELLIDO DEL USUARIO: ");
		lastNameUser = cin.nextLine();
		System.out.println("INGRESA EL NUMERO DE LA TARJETA DEL USUARIO: [10 DIGITOS]");
		numberCard = cin.nextLine();
		while(numberCard.length()!=10) {
			System.out.println("VUELVA A INGRESAR EL NUMERO DE LA TARJETA DEL USUARIO: [10 DIGITOS]");
			numberCard = cin.nextLine();
		}
		System.out.println("INGRESA EL CODIGO DE SEGURIDAD DE LA TARJETA DEL USUARIO: [3 DIGITOS]");
		cvvCard = cin.nextLine();
		while(cvvCard.length()!=3) {
			System.out.println("VUELVA A INGRESAR EL CODIGO DE SEGURIDAD DE LA TARJETA DEL USUARIO: [3 DIGITOS]");
			cvvCard = cin.nextLine();
		}
	}
	public String GetName() {
		return nameUser;
	}

	public String GetLastName() {
		return lastNameUser;
	}
	public String GetNumCard() {
		return numberCard;
	}
	public String GetCvvCard() {
		return cvvCard;
	}
	public String GetTypeCard() {
		return typeCard;
	}
	public void SetName(String nameUser) {
		this.nameUser = nameUser;
	}
	public void SetLastName(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}
	public void SetNumCard(String numberCard) {
		this.numberCard = numberCard;
	}
	public void SetCvvCard(String cvvCard) {
		this.cvvCard = cvvCard;
	}
	public void SetTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}
}
