package SistemaParquin;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

public class MotoGrupoF extends ParqueaderoGrupoF {
	static Scanner cin = new Scanner(System.in);
	public MotoGrupoF(String tipoVeiculo, String fechaHora, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion) {
		super(tipoVeiculo, fechaHora, espacioSelecc, numPlaca, nombreUser, telefono, direccion);
	}
	@Override
	public void GenerarTiket() {
		System.out.print("INGRESA EL NOMBRE DEL USUARIO [MAX. CARACTER. 10]: ");
		nombreUser = cin.nextLine();
		while(nombreUser.length()>10) {
			System.out.print("**VUELVA A INGRESAR EL NOMBRE DEL USUARIO [MAX. CARACTER. 10]**: ");
			nombreUser = cin.nextLine();
		}
		System.out.print("INGRESA EL MODELO DE LA MOTO [MAX. CARACTER. 10]: ");
		modelo = cin.nextLine();
		while(modelo.length()>10) {
			System.out.print("**VUELVA A INGRESAR MODELO DE LA MOTO  [MAX. CARACTER. 10]**: ");
			modelo = cin.nextLine();
		}
		setModelo(modelo);
		System.out.print("INGRESA EL NUMERO DE LA PLACA DE LA MOTO [CARACTER. 7]: ");
		numPlaca = cin.nextLine();
		while(numPlaca.length()!=7) {
			System.out.print("**VUELVA A INGRESAR EL NUMERO DE LA PLACA DE LA MOTO [CARACTER. 7]**: ");

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
public class MotoGrupoF extends ParqueaderoGrupoF {
	static Scanner cin = new Scanner(System.in);
	public MotoGrupoF(String tipoVeiculo, String fechaHora, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion) {
		super(tipoVeiculo, fechaHora, espacioSelecc, numPlaca, nombreUser, telefono, direccion);
	}
	@Override
	public void GenerarTiket() {
		System.out.print("INGRESA EL NOMBRE DEL USUARIO [MAX. CARACTER. 10]: ");
		nombreUser = cin.nextLine();
		while(nombreUser.length()>10) {
			System.out.print("**VUELVA A INGRESAR EL NOMBRE DEL USUARIO [MAX. CARACTER. 10]**: ");
			nombreUser = cin.nextLine();
		}
		System.out.print("INGRESA EL MODELO DE LA MOTO [MAX. CARACTER. 10]: ");
		modelo = cin.nextLine();
		while(modelo.length()>10) {
			System.out.print("**VUELVA A INGRESAR MODELO DE LA MOTO  [MAX. CARACTER. 10]**: ");
			modelo = cin.nextLine();
		}
		setModelo(modelo);
		System.out.print("INGRESA EL NUMERO DE LA PLACA DE LA MOTO [CARACTER. 7]: ");
		numPlaca = cin.nextLine();
		while(numPlaca.length()!=7) {
			System.out.print("**VUELVA A INGRESAR EL NUMERO DE LA PLACA DE LA MOTO [CARACTER. 7]**: ");
			numPlaca = cin.nextLine();
		}
		System.out.print("INGRESA EL NUMERO DE TELEFONO DEL USUARIO [CARACTER. 10]: ");
		telefono = cin.nextLine();
		while(telefono.length()!=10) {
			System.out.print("**VUELVA A INGRESAR EL NUMERO DE TELEFONO DEL USUARIO [CARACTER. 10]**: ");
			telefono = cin.nextLine();
		}
		System.out.print("INGRESA LA DIRECCION DEL USUARIO [MAX. CARACTER. 10]: ");
		direccion = cin.nextLine();
		while(direccion.length()>10) {
			System.out.print("**VUELVA A INGRESAR LA DIRECCION DEL USUARIO [MAX. CARACTER. 10]**: ");
			direccion = cin.nextLine();
		}
		fechaHora = generarIngreso(dd, mm, yy, horas, minutos);
		espacioSelecc=generarEspacio();
		System.out.println("\nCREACION DEL ARCHIVO .CSV\n");
		try {
			FileWriter fileCsv = new FileWriter("TiketMoto.csv",true);
			String datos = nombreUser+","+modelo+","+numPlaca+","+telefono+","+direccion+","+fechaHora+","+espacioSelecc;
			fileCsv.write(datos);
			fileCsv.close();
			System.out.println("\n**DATOS DE LA MOTO GURDADOS CON EXITO EN EL ARCHIVO 'TiketMoto.csv'**\n");
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("\nLECTURA DEL ARCHIVO .CSV\n");
		try (BufferedReader leerCsv = new BufferedReader(new FileReader("TiketMoto.csv"))){
			while((line = leerCsv.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nCREACION DEL ARCHIVO .JSON\n");
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("Nombre de usuario: ",nombreUser);
		jsonobject.put("Modelo: ",modelo);
		jsonobject.put("Numero de placa: ",numPlaca);
		jsonobject.put("Telefono: ",telefono);
		jsonobject.put("Direccion: ",direccion);
		jsonobject.put("Fecha y hora : ",fechaHora);
		jsonobject.put("Espacion seleccionado: ",espacioSelecc);
		try (FileWriter filejson = new FileWriter ("TiketMoto.json")){
			filejson.write(jsonobject.toString());
			//filejson.close();
			System.out.println("\n \n**DATOS DE LA MOTO GURDADOS CON EXITO EN EL ARCHIVO 'TiketMoto.json'**\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nLECTURA DEL ARCHIVO .JSON\n");
		try(FileReader fileReader = new FileReader ("TiketMoto.json")){
			JSONObject jsonReader = new JSONObject (new JSONTokener(fileReader));
			System.out.println("Nombre de usuario: " +jsonReader.getString("Nombre de usuario: "));
			System.out.println("Modelo: " +jsonReader.getString("Modelo: "));
			System.out.println("Numero de placa: " +jsonReader.getString("Numero de placa: "));
			System.out.println("Telefono: " +jsonReader.getString("Telefono: "));
			System.out.println("Direccion: " +jsonReader.getString("Direccion: "));
			System.out.println("Fecha y hora : " +jsonReader.getString("Fecha y hora : "));
			System.out.println("Espacion seleccionado: " +jsonReader.getString("Espacion seleccionado: "));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
