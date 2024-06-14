package SistemaParquin;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MotoGrupoF extends ParqueaderoGrupoF {
    static ArrayList<String> datosMoto = new ArrayList<>();
    private double precio;
    private static final Scanner cin = new Scanner(System.in);

    public MotoGrupoF(String tipoVeiculo, String fechaHora, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion, String tipo) {
        super(tipoVeiculo, fechaHora, espacioSelecc, numPlaca, nombreUser, telefono, direccion, tipo);
    }

    @Override
    public void GenerarTiket() {
        setTipo("moto");
        System.out.print("INGRESA EL NOMBRE DEL USUARIO: ");
        nombreUser = cin.nextLine();
        System.out.print("INGRESA EL MODELO DE LA MOTO: ");
        modelo = cin.nextLine();
        setModelo(modelo);
        System.out.print("INGRESA EL NUMERO DE LA PLACA DE LA MOTO [CARACTER. 6]: ");
        numPlaca = cin.nextLine();
        while (numPlaca.length() != 6) {
            System.out.print("VUELVA A INGRESAR EL NUMERO DE LA PLACA DE LA MOTO [CARACTER. 6]: ");
            numPlaca = cin.nextLine();
        }
        System.out.print("INGRESA EL NUMERO DE TELEFONO DEL USUARIO [CARACTER. 10]: ");
        telefono = cin.nextLine();
        while (telefono.length() != 10) {
            System.out.print("VUELVA A INGRESAR EL NUMERO DE TELEFONO DEL USUARIO [CARACTER. 10]: ");
            telefono = cin.nextLine();
        }
        System.out.print("INGRESA LA DIRECCION DEL USUARIO [MAX. CARACTER. 10]: ");
        direccion = cin.nextLine();
        while (direccion.length() > 10) {
            System.out.print("VUELVA A INGRESAR LA DIRECCION DEL USUARIO [MAX. CARACTER. 10]: ");
            direccion = cin.nextLine();
        }
        System.out.print("INGRESA EL PRECIO: ");
        precio = cin.nextDouble();
        cin.nextLine(); // Consume newline left-over
        fechaHora = generarIngreso(dd, mm, yy, horas, minutos);
        espacioSelecc = generarEspacio();
        String datos = nombreUser + "," + tipo + "," + modelo + "," + numPlaca + "," + telefono + "," + direccion + "," + fechaHora + "," + espacioSelecc + "," + precio;
        datosMoto.add(datos);
        System.out.println("\nCREACION DEL ARCHIVO .CSV\n");
        try (FileWriter fileCsv = new FileWriter(numPlaca + ".csv", true)) {
            for (String data : datosMoto) {
                fileCsv.write(data + "\n");
            }
            System.out.println("\n*DATOS DE LA MOTO GUARDADOS CON EXITO EN EL ARCHIVO 'TiketMoto.csv'*\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nLECTURA DEL ARCHIVO .CSV\n");
        try (BufferedReader leerCsv = new BufferedReader(new FileReader(numPlaca + ".csv"))) {
            String line;
            while ((line = leerCsv.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nCREACION DEL ARCHIVO .JSON\n");
        for (String data : datosMoto) {
            String[] parts = data.split(",");
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("Vehiculo", parts[1]);
            jsonobject.put("Nombre de usuario", parts[0]);
            jsonobject.put("Modelo", parts[2]);
            jsonobject.put("Numero de placa", parts[3]);
            jsonobject.put("Telefono", parts[4]);
            jsonobject.put("Direccion", parts[5]);
            jsonobject.put("Fecha y hora", parts[6]);
            jsonobject.put("Espacio seleccionado", parts[7]);
            jsonobject.put("Precio", parts[8]);

            try (FileWriter filejson = new FileWriter(numPlaca + ".json", true)) {
                filejson.write(jsonobject.toString() + "\n");
                System.out.println("\n*DATOS DE LA MOTO GUARDADOS CON EXITO EN EL ARCHIVO 'TiketMoto.json'*\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nLECTURA DEL ARCHIVO .JSON\n");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(numPlaca + ".json"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                JSONObject jsonReader = new JSONObject(new JSONTokener(line));
                System.out.println("Vehiculo: " + jsonReader.getString("Vehiculo"));
                System.out.println("Nombre de usuario: " + jsonReader.getString("Nombre de usuario"));
                System.out.println("Modelo: " + jsonReader.getString("Modelo"));
                System.out.println("Numero de placa: " + jsonReader.getString("Numero de placa"));
                System.out.println("Telefono: " + jsonReader.getString("Telefono"));
                System.out.println("Direccion: " + jsonReader.getString("Direccion"));
                System.out.println("Fecha y hora: " + jsonReader.getString("Fecha y hora"));
                System.out.println("Espacio seleccionado: " + jsonReader.getString("Espacio seleccionado"));
                System.out.println("Precio: " + jsonReader.getDouble("Precio"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
