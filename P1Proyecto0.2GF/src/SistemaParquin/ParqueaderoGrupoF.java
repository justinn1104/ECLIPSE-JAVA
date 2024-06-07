package SistemaParquin;
import java.util.Scanner;
public abstract class ParqueaderoGrupoF {
	static Scanner cin = new Scanner(System.in); 
	private int cantidadPisos=2, cantidadBloques=15;
	//protected String espacionDisponible[] = new String[30];
	protected String tipoVeiculo, fechaHora, piso, bloque;
	protected int pisoSeleccion, bloqueSeleccion;
	public ParqueaderoGrupoF(String tipoVeiculo, String fechaHora, int pisoSeleccion, int bloqueSeleccion) {
		this.tipoVeiculo = tipoVeiculo;
		this.pisoSeleccion = pisoSeleccion;
		this.bloqueSeleccion = bloqueSeleccion;
		this.fechaHora = fechaHora;
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
}
