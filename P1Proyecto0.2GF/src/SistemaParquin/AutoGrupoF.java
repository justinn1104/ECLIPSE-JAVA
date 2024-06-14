package SistemaParquin;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
public class AutoGrupoF extends ParqueaderoGrupoF {
    static Scanner cin = new Scanner(System.in);
    private double precio;
    public AutoGrupoF(String tipoVeiculo, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion, String tipo, String fechaIngreso, String fechaSalida) {
        super(tipoVeiculo, espacioSelecc, numPlaca, nombreUser, telefono, direccion, tipo, fechaIngreso, fechaSalida);
    }
    @Override
    public void GenerarTiket() {
        setTipo("auto");
        System.out.print("INGRESA EL NOMBRE DEL USUARIO: ");
        nombreUser = cin.nextLine();
        System.out.print("INGRESA EL MODELO DEL AUTO: ");
        modelo = cin.nextLine();
        setModelo(modelo);
        System.out.print("INGRESA EL NUMERO DE LA PLACA DEL AUTO [CARACTER. 7]: ");
        numPlaca = cin.nextLine();
        while (numPlaca.length() != 7) {
            System.out.print("VUELVA A INGRESAR EL NUMERO DE LA PLACA DEL AUTO [CARACTER. 7]: ");
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
        
        fechaIngreso = generarIngreso(dd, mm, yy, horas, minutos);
        System.out.println("longitud: "+fechaIngreso.length());	
        espacioSelecc = generarEspacio();
        datosVehiculos.add(new AutoGrupoF(tipoVeiculo, espacioSelecc, numPlaca, nombreUser, telefono, direccion, tipo, fechaIngreso, fechaSalida));
        System.out.println("\nCREACION DEL ARCHIVO .CSV\n");
        try (FileWriter fileCsv = new FileWriter(numPlaca + ".csv", true)) {
        	String datos = nombreUser + "," + tipo + "," + modelo + "," + numPlaca + "," + telefono + "," + direccion + "," + espacioSelecc + "," + precio;
        	fileCsv.write(datos);
        	fileCsv.close();
            System.out.println("\n*DATOS DEL AUTO GUARDADOS CON EXITO EN EL ARCHIVO 'TiketAuto.csv'*\n");
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
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("Vehiculo", tipo);
        jsonobject.put("Nombre de usuario", nombreUser);
        jsonobject.put("Modelo", modelo);
        jsonobject.put("Numero de placa", numPlaca);
        jsonobject.put("Telefono", telefono);
        jsonobject.put("Direccion", direccion);
        jsonobject.put("Fecha y hora ingreso", fechaIngreso);
        jsonobject.put("Espacio seleccionado", espacioSelecc);
        try (FileWriter filejson = new FileWriter(numPlaca + ".json", true)) {
            filejson.write(jsonobject.toString() + "\n");
            System.out.println("\n*DATOS DEL AUTO GUARDADOS CON EXITO EN EL ARCHIVO 'TiketAuto.json'*\n");
        } catch (IOException e) {
            e.printStackTrace();
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
                System.out.println("Fecha y hora ingreso: " + jsonReader.getString("Fecha y hora ingreso"));
                System.out.println("Espacio seleccionado: " + jsonReader.getString("Espacio seleccionado"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
