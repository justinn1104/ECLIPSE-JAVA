package SistemaParquin;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

public class MotoGrupoF extends ParqueaderoGrupoF {
	static Scanner cin = new Scanner(System.in);
	protected String numPlaca, modelo, nombreUser, telefono, direccion, espacioSelecc, line;
	protected int dd, mm, yy, horas, minutos;
	public MotoGrupoF(String tipoVeiculo, String fechaHora, int pisoSeleccion, int bloqueSeleccion, String numPlaca, String modelo, String nombreUser, String telefono, String direccion, String espacioSelecc) {
		super(tipoVeiculo, fechaHora, pisoSeleccion, bloqueSeleccion);
		this.numPlaca = numPlaca;
		this.modelo = modelo;
		this.nombreUser = nombreUser;
		this.telefono = telefono;
		this.direccion = direccion;
		this.espacioSelecc =  espacioSelecc;
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
		System.out.print("Exito: ");
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
	
}
