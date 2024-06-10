package SistemaParquin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONTokener;
public abstract class ParqueaderoGrupoF {
    static Scanner cin = new Scanner(System.in); 
    static ParqueaderoGrupoF moto = new MotoGrupoF("","","","","","","","");
    static ParqueaderoGrupoF auto = new AutoGrupoF("","","","","","","","");
    private int cantidadPisos = 2, cantidadBloques = 15;
    protected int dd, mm, yy, horas, minutos;
    
    protected String tipoVeiculo, fechaHora, espacioSelecc, numPlaca, nombreUser, telefono, direccion; // atributos comunes
    protected String modelo, line, piso, bloque, tipo;
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
        /*for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 15; j++) {
                espacios[i][j] = "libre";
            }
        }*/
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
        while (pisoSeleccion < 1 || pisoSeleccion > 2) {
            System.out.print("**VUELVA A SELECCIONAR UN PISO [1 AL 2]**: ");
            pisoSeleccion = cin.nextInt();
        }
        System.out.print("SELECCIONA UN BLOQUE [1 AL 15]: ");
        bloqueSeleccion = cin.nextInt();
        while (bloqueSeleccion < 1 || bloqueSeleccion > 15) {
            System.out.print("**VUELVA A SELECCIONAR UN BLOQUE [1 AL 15]**: ");
            bloqueSeleccion = cin.nextInt();
        }
        if (pisoSeleccion == 1) {
            piso = "A";
        } else {
            piso = "B";
        }
        espacios[pisoSeleccion - 1][bloqueSeleccion - 1] = "ocupado";
        bloque = Integer.toString(bloqueSeleccion);
        return piso + bloque;
    }
    public String generarIngreso(int dd, int mm, int yy, int hora, int minutos) {
        String dd2, mm2, yy2, hora3, minutos2;
        System.out.print("INGRESA EL AÑO [2024]: ");
        yy = cin.nextInt();
        while (yy != 2024) {
            System.out.print("**VUELVA A INGRESAR EL AÑO [2024]**: ");
            yy = cin.nextInt();
        }
        System.out.print("INGRESA EL MES [1 AL 12]: ");
        mm = cin.nextInt();
        while (mm < 1 || mm > 12) {
            System.out.print("**VUELVA A INGRESAR EL MES [1 AL 12]**: ");
            mm = cin.nextInt();
        }
        switch (mm) {
            case 1, 3, 5, 7, 8, 10, 12: // 31
                System.out.print("INGRESA EL DIA [1 AL 31]: ");
                dd = cin.nextInt();
                while (dd < 1 || dd > 31) {
                    System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 31]**: ");
                    dd = cin.nextInt();
                }
                break;
            case 4, 6, 9, 11: // 30
                System.out.print("INGRESA EL DIA [1 AL 30]: ");
                dd = cin.nextInt();
                while (dd < 1 || dd > 30) {
                    System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 30]**: ");
                    dd = cin.nextInt();
                }
                break;
            case 2: // 28
                System.out.print("INGRESA EL DIA [1 AL 28]: ");
                dd = cin.nextInt();
                while (dd < 1 || dd > 28) {
                    System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 28]**: ");
                    dd = cin.nextInt();
                }
                break;
        }
        System.out.print("INGRESA LA HORA [1 AL 24]: ");
        hora = cin.nextInt();
        while (hora < 1 || hora > 24) {
            System.out.print("**VUELVA A INGRESAR LA HORA [1 AL 24]**: ");
            hora = cin.nextInt();
        }
        System.out.print("INGRESA LOS MINUTOS [1 AL 60]: ");
        minutos = cin.nextInt();
        while (minutos < 1 || minutos > 60) {
            System.out.print("**VUELVA A INGRESAR LOS MINUTOS [1 AL 60]**: ");
            minutos = cin.nextInt();
        }
        dd2 = Integer.toString(dd);
        mm2 = Integer.toString(mm);
        yy2 = Integer.toString(yy);
        hora3 = Integer.toString(hora);
        minutos2 = Integer.toString(minutos);
        return dd2 + "/" + mm2 + "/" + yy2 + " -  " + hora3 + ":" + minutos2;
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
        return bloque;
    }
    public void setEspacio(String espacio, int a, int b) {
        this.espacios[a][b] = espacio;
    }
    public void MenuSystemParquin() {
        int opMenuGf;
        while (true) {
            System.out.println("\t**SISTEMA DE PARQUEDERO M&M 24H**");
            System.out.println("\n\t[1] INGRESO VEHICULO - CREA&LEE - CSV&JSON");
            System.out.println("\t[2] SALIDA VEHICULO - CREA&LEE - CSV&JSON");
            System.out.println("\t[3] CONSULTAR VEHICULO - LEE - CSV&JSON ");
            System.out.println("\t[4] SALIR");
            System.out.print("\nSELECCIONA UNA OPCION [1 AL 4]: ");
            opMenuGf = cin.nextInt();
            cin.nextLine();  // consume newline

            switch (opMenuGf) {
                case 1:
                    IngresoVeiculos();
                    break;
                case 2:
                	RealizarSalida();
                    // Implementar la función de salida de vehículos si es necesario
                    break;
                case 3:
                    consultarVehiculo();
                    break;
                case 4:
                    System.out.println("**SISTEMA CERRADO**");
                    return;  // Exit the loop and terminate the program
                default:
                    System.out.println("**VUELVA A SELECCIONAR UNA OPCION**");
            }
        }
    }
    public void consultarVehiculo() {
        String placa;
        System.out.print("INGRESA EL NUMERO DE LA PLACA VEICULAR [6 A 7 DIGITOS]: ");
        placa = cin.nextLine();
        while (placa.length() < 6 || placa.length() > 7) {
            System.out.print("**VUELVA A INGRESAR EL NUMERO DE LA PLACA VEICULAR [6 A 7 DIGITOS]**:");
            placa = cin.nextLine();
        }

        System.out.println("\nLECTURA DEL ARCHIVO .CSV\n");
        try (BufferedReader leerCsv = new BufferedReader(new FileReader(placa + ".csv"))) {
            String line;
            while ((line = leerCsv.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
        	System.out.println("El archivo CSV no existe.");
            System.out.print("¿Desea volver a intentar la lectura? (si/no): ");
            String respuesta = cin.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
            	consultarVehiculo();
            } else {
                return; // Sale del método si el usuario no desea volver a intentarlo
            }
        }
        System.out.println("\nLECTURA DEL ARCHIVO .JSON\n");
        try (FileReader fileReader = new FileReader(placa + ".json")) {
            JSONObject jsonReader = new JSONObject(new JSONTokener(fileReader));
            System.out.println("Vehiculo: " + jsonReader.getString("Vehiculo"));
            System.out.println("Nombre de usuario: " + jsonReader.getString("Nombre de usuario"));
            System.out.println("Modelo: " + jsonReader.getString("Modelo"));
            System.out.println("Numero de placa: " + jsonReader.getString("Numero de placa"));
            System.out.println("Telefono: " + jsonReader.getString("Telefono"));
            System.out.println("Direccion: " + jsonReader.getString("Direccion"));
            System.out.println("Fecha y hora: " + jsonReader.getString("Fecha y hora"));
            System.out.println("Espacio seleccionado: " + jsonReader.getString("Espacio seleccionado"));
        } catch (IOException e) {
        	System.out.println("El archivo JSON no existe.");
            System.out.print("¿Desea volver a intentar la lectura? (si/no): ");
            String respuesta = cin.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
            	consultarVehiculo();
            } else {
                return; // Sale del método si el usuario no desea volver a intentarlo
            }
        }
    }
    public void IngresoVeiculos() {
        int opMenuGf;
        do {
            System.out.println("\n\t**INGRESO DE VEHICULOS**");
            System.out.println("\n\t[1] MOTO");
            System.out.println("\n\t[2] AUTO");
            System.out.println("\n\t[3] REGRESAR");
            System.out.print("\n\nSELECCIONA EL TIPO DEL VEHICULO: ");
            opMenuGf = cin.nextInt();
            cin.nextLine();  // consume newline
            switch (opMenuGf) {
                case 1:
                    moto.GenerarTiket();
                    break;
                case 2:
                    auto.GenerarTiket();
                    break;
                case 3:
                    System.out.println("**REGRESASTE AL MENU PRINCIPAL**");
                    break;
                default:
                    System.out.println("**OPCION INCORRECTA**");
            }
        } while (opMenuGf != 3);
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void RealizarSalida() {
        String placa;
        System.out.print("INGRESA EL NUMERO DE LA PLACA VEHICULAR [6 A 7 DIGITOS]: ");
        placa = cin.nextLine();
        while(placa.length() < 6 || placa.length() > 7) {
            System.out.print("VUELVA A INGRESAR EL NUMERO DE LA PLACA VEHICULAR [6 A 7 DIGITOS]: ");
            placa = cin.nextLine();
        }
        placa = placa.toLowerCase();
        
        // Realizar salida en CSV
        try (BufferedReader leerCsv = new BufferedReader(new FileReader(placa + ".csv"))) {
            String line;
            while ((line = leerCsv.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
        	System.out.println("El archivo CSV no existe.");
            System.out.print("¿Desea volver a intentar la lectura? (si/no): ");
            String respuesta = cin.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
                RealizarSalida(); // Llama recursivamente al método si el usuario desea volver a intentarlo
            } else {
                return; // Sale del método si el usuario no desea volver a intentarlo
            }
        }

        // Realizar salida en JSON
        try (BufferedReader fileReader = new BufferedReader(new FileReader(placa + ".json"))) {
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
            }
        } catch (IOException e) {
        	System.out.println("El archivo JSON no existe.");
            System.out.print("¿Desea volver a intentar la lectura? (si/no): ");
            String respuesta = cin.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
                RealizarSalida(); // Llama recursivamente al método si el usuario desea volver a intentarlo
            } else {
                return; // Sale del método si el usuario no desea volver a intentarlo
            }
        }

        // Eliminar archivos CSV y JSON
        try {
            FileWriter fileCsv = new FileWriter(placa + ".csv");
            fileCsv.close();
            System.out.println("ARCHIVO '" + placa + ".csv' ELIMINADO EXITOSAMENTE");

            FileWriter fileJson = new FileWriter(placa + ".json");
            fileJson.close();
            System.out.println("ARCHIVO '" + placa + ".json' ELIMINADO EXITOSAMENTE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
