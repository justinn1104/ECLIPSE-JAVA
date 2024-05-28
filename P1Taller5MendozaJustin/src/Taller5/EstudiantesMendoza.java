package Taller5;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EstudiantesMendoza extends PersonaMendoza {
    static Scanner cin = new Scanner(System.in);
    public String career;
    public float note1, note2, promedio;

    public EstudiantesMendoza(float promedio, float note1, float note2, String career, String name, String lastName, String dni, String date) {
        super(name, lastName, dni, date);
        this.promedio = promedio;
        this.note1 = note1;
        this.note2 = note2;
        this.career = career;
    }

    @Override
    public void InsertData() {
        System.out.print("\n\t**INGRESAR DATOS DEL ESTUDIANTE**\n");
        System.out.print("\nIngresa el nombre:");
        name = cin.nextLine();
        setName(name);
        System.out.print("\nIngresa el apellido:");
        lastName = cin.nextLine();
        setLastName(lastName);
        System.out.print("\nIngresa el dni:");
        dni = cin.nextLine();
        setDni(dni);
        System.out.print("\nIngresa la fecha de nacimiento:");
        date = cin.nextLine();
        setDate(date);
        System.out.print("\nIngresa la carrera:");
        career = cin.nextLine();
        setCarrera(career);
        System.out.print("\nIngresa la nota 1 [1 - 10]:");
        note1 = cin.nextFloat();
        while (note1 < 1 || note1 > 10) {
            System.out.print("\nVuelve a ingresar la nota 1 [1 - 10]:");
            note1 = cin.nextFloat();
        }
        System.out.print("\nIngresa la nota 2 [1 - 10]:");
        note2 = cin.nextFloat();
        while (note2 < 1 || note2 > 10) {
            System.out.print("\nVuelve a ingresar la nota 2 [1 - 10]:");
            note2 = cin.nextFloat();
        }
        promedio = PromedioStudens(note1, note2);
        setPromedio(promedio);
        ReturnData(name, lastName, dni, date);
    }
    @Override
    public void ReturnData(String name, String lastName, String dni, String date) {
    	String line = "";
        System.out.print("\n\t**DATOS DEL ESTUDIANTE**\n");
        System.out.print("\nNombre:" + name);
        System.out.print("\nApellido:" + lastName);
        System.out.print("\nDni:" + dni);
        System.out.print("\nFecha:" + date);
        System.out.print("\nCarrera:" + getCarrera());
        System.out.print("\nPromedio:" + getPromedio());
        System.out.print("\n\nt**CREACION DEL ARCHIVO CSV**\n");
        try {
            FileWriter writer = new FileWriter("datos_Sestudiantes.csv", true); // El parámetro true indica que se agregará al final del archivo
            String data = name + "," + lastName + "," + dni + "," + date + "," + career + "," + note1 + "," + note2 + "," + promedio + "\n";
            writer.write(data);
            writer.close();
            System.out.println("\nDatos del estudiante guardados en CSV correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.print("\n\t**LECCTURA DEL ARCHIVO CSV**\n");
        try (BufferedReader br = new BufferedReader(new FileReader("datos_estudiantes.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Nombre: " + data[0] + ", Apellido: " + data[1] + ", DNI: " + data[2] + ", Fecha: " + data[3] + ", Carrera: " + data[4] + ", Nota1: " + data[5] + ", Nota2: " + data[6] + ", Promedio: " + data[7]+"\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public float PromedioStudens(float note1, float note2) {
        return (note1 + note2) / 2;
    }
    public float getPromedio() {
        return promedio;
    }
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    public String getCarrera() {
        return career;
    }

    public void setCarrera(String career) {
        this.career = career;
    }
}
