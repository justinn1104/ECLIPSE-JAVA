package SistemaParquin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONTokener;
public abstract class ParqueaderoGrupoF {
	static Scanner cin = new Scanner(System.in); 
	static ParqueaderoGrupoF moto = new MotoGrupoF("","","","","","","","");
	static ParqueaderoGrupoF auto = new AutoGrupoF("","","","","","","","");
	private int cantidadPisos=2, cantidadBloques=15;
	protected int dd, mm, yy, horas, minutos;
	
	protected String tipoVeiculo, fechaHora, espacioSelecc, numPlaca, nombreUser,telefono, direccion;//atributos comunes
	protected String modelo, line,piso, bloque, tipo;
	protected int pisoSeleccion, bloqueSeleccion;
	private String[][] espacios = new String[2][15];
	public ParqueaderoGrupoF(String tipoVeiculo, String fechaHora, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion, String tipo) {
		this.tipoVeiculo = tipoVeiculo;
		this.fechaHora = fechaHora;
		this.espacioSelecc =  espacioSelecc;
		this.numPlaca = numPlaca;
		this.nombreUser = nombreUser;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipo = tipo;
	}
	public int getCantidadPisos() {
		return cantidadPisos;
	}
	public int getCantidadBloques() {
		return cantidadBloques;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public abstract void GenerarTiket();
	public String generarEspacio() {
		System.out.print("SELECCIONA UN PISO [1 AL 2]: ");
		pisoSeleccion = cin.nextInt();
		while(pisoSeleccion<1||pisoSeleccion>2) {
			System.out.print("**VUELVA A SELECCIONAR UN PISO [1 AL 2]**: ");
			pisoSeleccion = cin.nextInt();
		}
		System.out.print("SELECCIONA UN BLOQUE [1 AL 15]: ");
		bloqueSeleccion = cin.nextInt();
		while(bloqueSeleccion<1||bloqueSeleccion>15) {
			System.out.print("**VUELVA A SELECCIONAR UN BLOQUE [1 AL 15]**: ");
			bloqueSeleccion = cin.nextInt();
		}
		if(pisoSeleccion==1) {
			piso = "A";
		}else {
			piso = "B";
		}
		espacios[pisoSeleccion-1][bloqueSeleccion-1]="ocupado";
		bloque=Integer.toString(bloqueSeleccion);
		return piso+bloque;
	}
	
	public String generarIngreso( int dd, int mm, int yy,int hora, int minutos) {
		String dd2, mm2, yy2, hora3, minutos2;
		System.out.print("INGRESA EL AÑO [2024]: ");
		yy = cin.nextInt();
		while(yy!=2024) {
			System.out.print("**VUELVA A INGRESAR EL AÑO [2024]**: ");
			yy = cin.nextInt();
		}
		System.out.print("INGRESA EL MES [1 AL 12]: ");
		mm = cin.nextInt();
		while(mm<1||mm>12) {
			System.out.print("**VUELVA A INGRESAR EL MES [1 AL 12]**: ");
			mm = cin.nextInt();
		}
		switch(mm) {
		case 1 , 3, 5, 7, 8, 10, 12://31
			System.out.print("INGRESA EL DIA [1 AL 31]: ");
			dd = cin.nextInt();
			while(dd<1||dd>31) {
				System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 31]**: ");
				dd = cin.nextInt();
			}
			break;
		case 4, 6, 9, 11://30
			System.out.print("INGRESA EL DIA [1 AL 30]: ");
			dd = cin.nextInt();
			while(dd<1||dd>30) {
				System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 30]**: ");
				dd = cin.nextInt();
			}
			break;
		case 2://28
			System.out.print("INGRESA EL DIA [1 AL 28]: ");
			dd = cin.nextInt();
			while(dd<1||dd>28) {
				System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 28]**: ");
				dd = cin.nextInt();
			}
			break;
		}
		System.out.print("INGRESA LA HORA [1 AL 24]: ");
		hora = cin.nextInt();
		while(hora<1||hora>24) {
			System.out.print("**VUELVA A INGRESAR LA HORA [1 AL 24]**: ");
			hora = cin.nextInt();
		}
		System.out.print("INGRESA LOS MINUTOS [1 AL 60]: ");
		minutos = cin.nextInt();
		while(minutos<1||minutos>60) {
			System.out.print("**VUELVA A INGRESAR LOS MINUTOS [1 AL 60]**: ");
			minutos = cin.nextInt();
		}
		dd2=Integer.toString(dd);
		mm2=Integer.toString(mm);
		yy2=Integer.toString(yy);
		hora3=Integer.toString(hora);
		minutos2=Integer.toString(minutos);
		return dd2+"/"+mm2+"/"+yy2+" -  "+hora3+":"+minutos2;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setPiso(String line) {
		this.line = line;
	}
	public void setBloque(String bloque) {
		this.modelo = bloque;
	}
	public String getModelo() {
		return modelo;
	}
	public String getPiso() {
		return line;
	}
	public String getBloque() {
		return  bloque;
	}
	public void setEspacio(String espacio, int a, int b) {
		this.espacios[a][b] = espacio;
	}
	public void MenuSystemParquin() {
		int opMenuGf;
		System.out.println("\t**SISTEMA DE PARQUEDERO M&M 24H**");
		System.out.println("\n\t[1] INGRESO VEHICULO - CREA&LEE -  CSVV&JSON");
		System.out.println("\t[2] SALIDA VEHICULO - CREA&LEE -  CSVV&JSON");
		System.out.println("\t[3] CONSULTAR VEHICULO - LEE - CSV&JSON ");
		System.out.println("\t[4] SALIR");
		System.out.print("\nSELECCIONA UNA OPCION [1 AL 4] :");
		opMenuGf = cin.nextInt();
		switch(opMenuGf) {
		case 1:
			IngresoVeiculos();
			MenuSystemParquin();
			break;
		case 2:
			MenuSystemParquin();
			break;
		case 3:
			consultarVehiculo();
			MenuSystemParquin();
			break;
		case 4:
			System.out.println("**SISTEMA CERRADO**");
			break;
		default:
			System.out.println("**VUELVA A SELECCIONAR UNA OPCION**");
			MenuSystemParquin();
		}
	}
	public void consultarVehiculo() {
		String placa;
		System.out.print("INGRESA EL NUMERO DE LA PLACA VEICULAR [6 A 7]DIGITOS: ");
		placa = cin.next();
		while(placa.length()<6||placa.length()>7) {
			System.out.print("**VUELVA A INGRESAR EL NUMERO DE LA PLACA VEICULAR [6 A 7]DIGITOS**:");
			placa = cin.next();
		}
		placa.toLowerCase();
		System.out.println("\nLECTURA DEL ARCHIVO .CSV\n");
		try (BufferedReader leerCsv = new BufferedReader(new FileReader(placa+".csv"))){
			while((line = leerCsv.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nLECTURA DEL ARCHIVO .JSON\n");	
		try(FileReader fileReader = new FileReader (placa+".json")){
			JSONObject jsonReader = new JSONObject (new JSONTokener(fileReader));
			System.out.println("Vehiculo: " +jsonReader.getString("Vehiculo: "));
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
	
	public void IngresoVeiculos() {
		int opMenuGf;
		do {
			System.out.println("\n\t**INGRESO DE VEHIVULOS**\n"
					+ "\n\t[1] MOTO"
					+ "\n\t[2] AUTO"
					+ "\n\t[3] REGRESAR"
					+ "\n\nSELECCIONA EL TIPO DEL VEHICULO:");
			opMenuGf = cin.nextInt();
			switch(opMenuGf) {
			case 1:
				moto.GenerarTiket();
				break;
			case 2:
				auto.GenerarTiket();
				break;
			case 3:
				System.out.println("**REGRASTE AL MENU PRINCIPAL**");
				break;
			default:
				System.out.println("**OPCION INCORRECTA**");
			}
		}while(opMenuGf !=3);
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
