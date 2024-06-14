package SistemaParquin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONTokener;
public abstract class ParqueaderoGrupoF {
    static Scanner cin = new Scanner(System.in); 
    static ParqueaderoGrupoF moto = new MotoGrupoF("","","","","","","","","");
    static ParqueaderoGrupoF auto = new AutoGrupoF("","","","","","","","","");
    static ArrayList<ParqueaderoGrupoF> datosVehiculos = new ArrayList<>();
    private int cantidadPisos = 2, cantidadBloques = 15;
    protected int dd, mm, yy, horas, minutos;
    
    protected String tipoVeiculo, espacioSelecc, numPlaca, nombreUser, telefono, direccion, fechaIngreso, fechaSalida; // atributos comunes
    protected String modelo, line, piso, bloque, tipo;
    protected int pisoSeleccion, bloqueSeleccion;
    private String[][] espacios = new String[2][15];
    
    public ParqueaderoGrupoF(String tipoVeiculo, String espacioSelecc, String numPlaca, String nombreUser, String telefono, String direccion, String tipo, String fechaIngreso, String fechaSalida) {
        this.tipoVeiculo = tipoVeiculo;
        this.espacioSelecc =  espacioSelecc;
        this.numPlaca = numPlaca;
        this.nombreUser = nombreUser;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
    public abstract void GenerarTiket();
    public void MenuSystemParquin() {
        int opMenuGf;
        while (true) {
            System.out.println("\t**SISTEMA DE PARQUEDERO M&M 24H**");
            System.out.println("\n\t[1] INGRESO VEHICULO - CREA&LEE - CSV&JSON");
            System.out.println("\t[2] SALIDA VEHICULO - CREA&LEE - CSV&JSON");
            System.out.println("\t[3] CONSULTAR VEHICULO - LEE - CSV&JSON ");
            System.out.println("\t[4] INPRIMIR TODOS LOS INGRESOS ACTIVOS");
            System.out.println("\t[5] SALIR");
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
                	imprimirDatosVehiculos();
                    break;          
                case 5:
                    System.out.println("**SISTEMA CERRADO**");
                    return;  // Exit the loop and terminate the program
                default:
                    System.out.println("**VUELVA A SELECCIONAR UNA OPCION**");
            }
        }
    }
    public void IngresoVeiculos() {
        int opMenuGf;
        do {
            System.out.println("\n\t**INGRESO DE VEHICULOS**");
            System.out.println("\t[1] MOTO");
            System.out.println("\t[2] AUTO");
            System.out.println("\t[3] REGRESAR");
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
        String dd2, mm2, yy2, hora3, minutos2, form;
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
        if(dd<10) {
        	dd2="0".concat(dd2);
        }
        if(mm<10) {
        	mm2="0".concat(mm2);
        }
        if(hora<10) {
        	hora3="0".concat(hora3);
        }
        if(minutos<10) {
        	minutos2="0".concat(minutos2);
        }
        form = dd2.concat("/").concat(mm2).concat("/").concat(yy2).concat(" - ").concat(hora3).concat(":").concat(minutos2);
        return form;
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
    public void RealizarSalida() {
        String placa, fechaIngreso = null;
        if (datosVehiculos.isEmpty()) {
            System.out.println("El listado de vehículos está vacío.");
        }
        System.out.print("INGRESA EL NUMERO DE LA PLACA VEHICULAR [6 A 7 DIGITOS]: ");
        placa = cin.nextLine();
        while(placa.length() < 6 || placa.length() > 7) {
            System.out.print("VUELVA A INGRESAR EL NUMERO DE LA PLACA VEHICULAR [6 A 7 DIGITOS]: ");
            placa = cin.nextLine();
        }
        placa = placa.toLowerCase();
        for (int i = 0; i < datosVehiculos.size(); i++) {
            ParqueaderoGrupoF vehiculo = datosVehiculos.get(i);
            if (vehiculo.getNumPlaca().equals(placa)) {
                fechaIngreso = vehiculo.getFechaIngreso();
                //datosVehiculos.remove(i);
                break;
            }
        }
        if (fechaIngreso == null) {
            System.out.println("Vehículo con placa " + placa + " no encontrado.");
        }
        System.out.println("INGRESA LA FECHA DE SALIDA: ");
        fechaSalida = generarIngreso(dd, mm, yy, horas, minutos);
    }
    public int descomponerFecha(String fecha, int indexIni, int indexFin) {
        try {
            String formCadena = fecha.substring(indexIni, indexFin);
            int formInteger = Integer.parseInt(formCadena);
            System.out.println(formInteger); // Output = 25
            return formInteger;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    // Método para imprimir todos los elementos del ArrayList
    public void imprimirDatosVehiculos() {
    	if (datosVehiculos.isEmpty()) {
            System.out.println("El listado de vehículos está vacío.");
            return;
        }

        System.out.println("Listado de vehículos:");
        for (ParqueaderoGrupoF vehiculo : datosVehiculos) {
            System.out.println("PLACA: "+vehiculo.getNumPlaca());
            System.out.println("NOMBRE: "+vehiculo.getNombreUser());
            System.out.println("INGRESO: "+vehiculo.getFechaIngreso());
            System.out.println("SALIDA: "+vehiculo.getFechaSalida()+"\n\n");
        }
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
    public String getEspacioSelecc() {
		return espacioSelecc;
	}
	public void setEspacioSelecc(String espacioSelecc) {
		this.espacioSelecc = espacioSelecc;
	}
	public String getNumPlaca() {
		return numPlaca;
	}
	public void setNumPlaca(String numPlaca) {
		this.numPlaca = numPlaca;
	}
	public String getNombreUser() {
		return nombreUser;
	}
	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getPisoSeleccion() {
		return pisoSeleccion;
	}
	public void setPisoSeleccion(int pisoSeleccion) {
		this.pisoSeleccion = pisoSeleccion;
	}
	public String getTipo() {
		return tipo;
	}
	public int getCantidadPisos() {
        return cantidadPisos;
    }
    public int getCantidadBloques() {
        return cantidadBloques;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
