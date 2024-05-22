package CajeroAutomatico;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Sistema {
	static Scanner cin = new Scanner(System.in);
	protected String names, lastNames, numCard, codigoCvv, type_Card, pwsCard;
	protected boolean stateCard = false;
	public Sistema(String names, String lastNames, String numCard, String codigoCvv, String type_Card, String pwsCard, boolean stateCard) {
		this.names = names;
		this.lastNames = lastNames;
		this.numCard = numCard;
		this.codigoCvv = codigoCvv;
		this.type_Card = type_Card;
		this.pwsCard = pwsCard;
		this.stateCard = stateCard;
	}
	public String GetName() {
		return names;
	}
	public void SetName(String names) {
		this.names = names;
	}
	public String GetLastName() {
		return lastNames;
	}
	public void SetLastName(String lastNames) {
		this.lastNames = lastNames;
	}
	public String GetNumCard() {
		return numCard;
	}
	public void SetNumCard(String numCard) {
		this.numCard = numCard;
	}
	public String GetCodigoCvv() {
		return codigoCvv;
	}
	public void SetCodigoCvv(String codigoCvv) {
		this.codigoCvv = codigoCvv;
	}
	public String GetType_Card() {
		return type_Card;
	}
	public void SetType_Card(String type_Card) {
		this.type_Card = type_Card;
	}
	public String GetPwsCard() {
		return pwsCard;
	}
	public void SetPwsCard(String pwsCard) {
		this.pwsCard = pwsCard;
	}
	public boolean GetStateCard() {
		return stateCard;
	}
	public void SetStateCard(boolean stateCard) {
		this.stateCard = stateCard;
	}
	public void  UserGenerate() {
		String state; 
		if(GetStateCard()==false) {
			state="Activa";
		}else {
			state="Bloqueada";
		}
		//crea el archivo
		try {
			System.out.println("\n\tUSUARIO GENERADO CON EXITO\n");
	        FileWriter Archivo_Mendoza = new FileWriter("UsuarioGenerado.txt"); // Crea un objeto FileWriter para escribir en el archivo "UsuarioGenerado.txt"           
	        Archivo_Mendoza.write("\n\tUSUARIO\n");
	        Archivo_Mendoza.write("\nNombres: "+GetName()+" "+GetLastName());
	        Archivo_Mendoza.write("\n\tTarjeta '"+GetType_Card()+"'\n");
	        Archivo_Mendoza.write("Numero: "+GetNumCard()+"   CVV: "+GetCodigoCvv()+"\n");
	        Archivo_Mendoza.write("Clave: "+GetPwsCard()+"   Estado: "+state);
	        Archivo_Mendoza.close(); // Cierra el archivo FileWriter
	        System.out.println("\nLOS DATOS SE HAN GUARDADO EN EL ARCHIVO 'Registro.txt' correctamente.\n");
	    } catch (IOException e) { // Captura una posible excepción de entrada/salida
	        System.err.println("\nERROR AL ABRIR EL ARCHIVO\n");
	        e.printStackTrace(); // Imprime la traza de la excepción
	    }
		//lee el archivo
		try {
		    BufferedReader Archivo_Mendoza = new BufferedReader(new FileReader("UsuarioGenerado.txt")); // Abre el archivo en modo de lectura usando BufferedReader		  
		    System.out.println("\nARCHIVO ABIERTO EN EL MODO LECTURA..\n");		    
		    String linea;		    
		    while ((linea = Archivo_Mendoza.readLine()) != null) {// Lee cada línea del archivo hasta que llega al final
		        System.out.println(linea);
		    }		    
		    Archivo_Mendoza.close(); // Cierra el archivo después de leer todas las líneas
		} catch (IOException e) { // En caso de que ocurra una excepción al abrir o leer el archivo		   
		    System.out.println("\nERROR, NO SE PUEDE ABRIR EL ARCHIVO SOLO LECTURA..\n");		    
		    e.printStackTrace(); // Imprime la traza de la excepción en la consola
		}
	}
}
