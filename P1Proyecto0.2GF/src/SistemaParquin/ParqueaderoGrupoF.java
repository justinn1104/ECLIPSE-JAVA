package SistemaParquin;
import java.util.Scanner;
public abstract class ParqueaderoGrupoF {
	static Scanner cin = new Scanner(System.in); 
	private int cantidadPisos=2, cantidadBloques=15;
	protected int dd, mm, yy, horas, minutos;
	protected String tipoVeiculo, fechaHora, espacioSelecc, numPlaca, nombreUser,telefono, direccion;//atributos comunes
	protected String modelo, line,piso, bloque;
	protected int pisoSeleccion, bloqueSeleccion;
	public ParqueaderoGrupoF(String tipoVeiculo, String fechaHora, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion) {
		this.tipoVeiculo = tipoVeiculo;
		this.fechaHora = fechaHora;
		this.espacioSelecc =  espacioSelecc;
		this.numPlaca = numPlaca;
		this.nombreUser = nombreUser;
		this.telefono = telefono;
		this.direccion = direccion;

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
	
}
