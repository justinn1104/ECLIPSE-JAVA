package Taller5;

import java.io.FileWriter;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.Scanner;

public class ProfesorMendoza extends PersonaMendoza {
	static Scanner cin = new Scanner(System.in);
	public String especialidad;
	public int horasTrabajadas;
	public float precioHora, sueldo;
	public ProfesorMendoza(String especialidad, int horasTrabajadas, float precioHora , float sueldo,String name, String lastName, String dni, String date) {
		super(name, lastName, dni, date);
		this.especialidad =especialidad;
		this.horasTrabajadas = horasTrabajadas;
		this.precioHora = precioHora;
		this.sueldo = sueldo;
	}
	@Override
	public void InsertData() {
		System.out.print("\n\t**INGRESAR DATOS DEL MAESTRO**\n");
		System.out.print("\nIngresa el nombre:");
		name = cin.nextLine();
		setName(name);
		System.out.print("\nIngresa el apellido:");
		lastName = cin.nextLine();
		setLastName(lastName);
		System.out.print("\nIngresa el dni:");
		dni = cin.nextLine();
		setDni(dni);
		System.out.print("\nIngresa el date:");
		date = cin.nextLine();
		setDate(date);
		System.out.print("\nIngresa la Profecion:");
		especialidad = cin.nextLine();
		setEspecialidad(especialidad);
		setDate(date);
		System.out.print("\nIngresa las horas trabajdas al dia 1 [1 - 24] :");
		horasTrabajadas = cin.nextInt();
		while(horasTrabajadas<1||horasTrabajadas>10) {
			System.out.print("\nVuelve a ingresar las horas trabajdas al dia 1 [1 - 24] :");
			horasTrabajadas = cin.nextInt();
		}
		System.out.print("\nIngresa el costo por hora [$1.00 - $100.00] :");
		precioHora = cin.nextFloat();
		while(precioHora<1||precioHora>100) {
			System.out.print("\nVuelve a ingresar el costo por hora [$1.00 - $100.00] :");
			precioHora = cin.nextFloat();
		}
		sueldo = SueldoProfesor(horasTrabajadas, precioHora);
		setSueldo(sueldo);
		ReturnData(name, lastName, dni, date);
	}
	@Override
	public void ReturnData(String name, String lastName, String dni, String date) {
		System.out.print("\n\t**DATOS DEL MAESTRO**\n");
		System.out.print("\nNombre:"+name);
		System.out.print("\nApellido:"+ lastName);
		System.out.print("\nDni:"+ dni);
		System.out.print("\nFecha:"+ date);
		System.out.print("\nProfecion:"+ getEspecialidad());
		System.out.print("\nSueldo Mensual:"+ getSueldo());
		
		JSONObject jsonObject = new JSONObject();
	    jsonObject.put("nombre", name);
	    jsonObject.put("apellido", lastName);
	    jsonObject.put("dni", dni);
	    jsonObject.put("fecha", date);
	    jsonObject.put("especialidad", especialidad);
	    jsonObject.put("horasTrabajadas", horasTrabajadas);
	    jsonObject.put("precioHora", precioHora);
	    jsonObject.put("sueldo", sueldo);
	    System.out.print("\n\t**CREACION DEL ARCHIVO JSON**\n");
	    try (FileWriter archivo = new FileWriter("datos_profesor.json")) {
	        archivo.write(jsonObject.toString());
	        System.out.println("\nDatos del profesor guardados en JSON correctamente.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.print("\n\t**LECCTURA DEL ARCHIVO JSON**\n");
        try (FileReader reader = new FileReader("datos_profesor.json")) {
            JSONObject jsonLectura = new JSONObject(new JSONTokener(reader));
            System.out.println("Nombre: " + jsonLectura.getString("nombre"));
            System.out.println("Apellido: " + jsonLectura.getString("apellido"));
            System.out.println("DNI: " + jsonLectura.getString("dni"));
            System.out.println("Fecha: " + jsonLectura.getString("fecha"));
            System.out.println("Especialidad: " + jsonLectura.getString("especialidad"));
            System.out.println("Horas Trabajadas: " + jsonLectura.getInt("horasTrabajadas"));
            System.out.println("Precio por Hora: " + jsonLectura.getDouble("precioHora"));
            System.out.println("Sueldo: " + jsonLectura.getDouble("sueldo")+"\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public float SueldoProfesor(int horasTrabajadas, float precioHora) {
		float salario;
		salario = ((horasTrabajadas*precioHora)*7)*4;
		return salario;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}
