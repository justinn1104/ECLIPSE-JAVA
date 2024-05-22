package CajeroAutomatico;
import java.util.Scanner;
public class Principal {
	static Scanner cin = new Scanner(System.in);
	static Usuario myUser = new Usuario();
	static Cajero systemCajero = new Cajero(); 
	private static  int optionsMenu;
	public static void main(String[] args) {
		MenuPrincipal();
	}
	public static void MenuPrincipal() {
		systemCajero.SetSaldo(500);
		System.out.println("\t[1] Generar Usuario");
		System.out.println("\t[2] Cajero automatico");
		System.out.println("\t[3] Salir");
		System.out.print("\n\nSelecciona una opcion [1 - 3]: ");
		optionsMenu = cin.nextInt();
		switch(optionsMenu) {
			case 1:
				//generar un nuevo usuario
				myUser.GenerarUsuario();
				MenuPrincipal();
				break;
			case 2:
				//sistema de transacciones en un cajero automatico
				systemCajero.CredentialSystem();
				MenuPrincipal();
				break;
			case 3:
				//cerrar el sistema
				System.out.println("\nSISTEMA CERRADO CON EXITO..\n");
				break;
			default:
				System.out.println("\nOPCION INVALIDA..VUELVE A SELECCIONAR..\n");
				MenuPrincipal();
		}
	}
}
