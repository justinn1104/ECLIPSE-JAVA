package Laboratorio2;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class SistemaBibliotecaMendoza extends BibliotecaMendoza {
	static BibliotecaMendoza mysText[] = new SistemaBibliotecaMendoza[10];//polimosfismo
	static Scanner cin = new Scanner(System.in);
	public int amountAsk, amountReturn;
	public String nameAsk, nameReturn, nameConsultation;
	private String id;
	public SistemaBibliotecaMendoza(String nameText, String idText, String typeText, String autorText, int amountText, int anioText) {
		super(nameText, idText, typeText, autorText, amountText, anioText);
	}
	//encapsuladores e metodas de (getter y setter)
	public int GetAmountAsk () {
		return amountAsk;
	}
	public void SetAmountAsk (int amountAsk) {
		this.amountAsk = amountAsk;
	}
	public int GetAmountReturn () {
		return amountReturn;
	}
	public void SetAmountReturn (int amountReturn) {
		this.amountReturn = amountReturn;
	}
	public String GetNameAsk () {
		return nameAsk;
	}
	public void SetNameAsk (String nameAsk) {
		this.nameAsk = nameAsk;
	}
	public String GetNameReturn () {
		return nameReturn;
	}
	public void SetNameReturn (String nameReturn) {
		this.nameReturn = nameReturn;
	}
	public String GetNameConsultation () {
		return nameConsultation;
	}
	public void SetNameConsultation (String nameConsultation) {
		this.nameConsultation = nameConsultation;
	}
	public String GetId () {
		return id;
	}
	public void SetId (String id) {
		this.id = id;
	}
	//metodo para generar nuevos textos
	@Override
	public void GenerateText() {
		String name, type, autor;
		int amount, anio, newTex;
		System.out.print("\nINSERTA LA CANTIDAD DE TEXTOS QUE DESEA GENERAR [1 - 5]: ");
		newTex = cin.nextInt();
		while(newTex<1||newTex>5) {
			System.out.print("\n**VUELVA A INSERTAR LA CANTIDAD DE TEXTOS QUE DESEA GENERAR [1 - 5]**: ");
			newTex = cin.nextInt();
		}
		
		for(int i=5; i<5+newTex ; i++) {
			System.out.print("\nINSERTAR EL NOMBRE DEL TEXTO [10 caracteres < Long > 4 caracteres]: ");
			name = cin.next();
			while(name.length()<4||name.length()>10) {
				System.out.print("\n**VUELVA A INSERTAR EL NOMBRE DEL TEXTO [10 caracteres < Long > 4 caracteres]**: ");
				name = cin.next();
			}
			System.out.print("\nINSERTAR EL TIPO DE TEXTO [10 caracteres < Long > 4 caracteres]: ");
			type = cin.next();
			while(type.length()<4||type.length()>10) {
				System.out.print("\n**VUELVA A INSERTAR EL TIPO DE TEXTO [10 caracteres < Long > 4 caracteres]**: ");
				type = cin.next();
			}
			System.out.print("\nINSERTAR EL NOMBRE DEL AUTOR DEL TEXTO [10 caracteres < Long > 4 caracteres]: ");
			autor = cin.next();
			while(autor.length()<4||autor.length()>10) {
				System.out.print("\n**VUELVE A INSERTAR EL NOMBRE DEL AUTOR DEL TEXTO [10 caracteres < Long > 4 caracteres]**: ");
				autor = cin.next();
			}
			System.out.print("\nINSERTAR CUANTOS TEXTOS SE INGRESARAN [1 - 5]: ");
			amount = cin.nextInt();
			while(amount<1||amount>5) {
				System.out.print("\n**VUELVA A INSERTAR CUANTOS TEXTOS SE INGRESARAN [1 - 5]**: ");
				amount = cin.nextInt();
			}
			System.out.print("\nINSERTAR EL AÑO DEL TEXTO [1985 - 2024]: ");
			anio = cin.nextInt();
			while(anio<1985||anio>2024) {
				System.out.print("\n**VUELVA A INSERTAR EL AÑO DEL TEXTO [1985 - 2024]**: ");
				anio = cin.nextInt();
			}
			id = GenerateId(type, anio);
			SetId(id);
			// Initialize the object before setting properties
            mysText[i] = new SistemaBibliotecaMendoza(name, id, type, autor, amount, anio);
		}
	}
	//metodo para generar nuevos textos
	public String GenerateId(String type, int anio) {
		String id="", anioString, iS,indiceType;
		int i=0;
		indiceType = type.substring(0,3);
		anioString = anio + ""; 
		iS = i +"";
		indiceType.toLowerCase();
		id = indiceType.concat(anioString.concat(iS));
		i++;
		return id.toLowerCase();
	}
	public void MenuMendoza() {
		int opMenu;
		mysText[0] = new SistemaBibliotecaMendoza("Nacho","cue20180","Cuento","Justin Medoza",2,2018);
		mysText[1] = new SistemaBibliotecaMendoza("Paton","cue20151","Cuento","Justin Medoza",3,2015);
		mysText[2] = new SistemaBibliotecaMendoza("Ducke","cue20202","Cuento","Justin Medoza",4,2020);
		mysText[3] = new SistemaBibliotecaMendoza("Lancha","cue20223","Cuento","Justin Medoza",1,2022);
		mysText[4] = new SistemaBibliotecaMendoza("Carlin","cue20234","Cuento","Justin Medoza",5,2023);
		System.out.println("\n\n\t    **BIBLIOTECA ESPE**");
		System.out.println("\n\t[1] Agregar nuevos textos");
		System.out.println("\t[2] Pedir textos -> Genera .txt");
		System.out.println("\t[3] Devolver textos -> Genera .csv");
		System.out.println("\t[4] Consultar textos -> Genera .json");
		System.out.println("\t[5] Leer archivo TXT de textos pedidos");
		System.out.println("\t[6] Leer archivo CSV de textos Devueltos");
		System.out.println("\t[7] Leer archivo JSON de textos disponibles");
		System.out.println("\t[8] Salir\n");
		System.out.print("\nSELECCIONA UNA OPION [1 - 5]: ");
		opMenu = cin.nextInt();
		switch(opMenu) {
		case 1:
			GenerateText();
			MenuMendoza();
			break;
		case 2:
			AskText ();
			MenuMendoza();
			break;
		case 3:
			ReurnText ();
			MenuMendoza();
			break;
		case 4:
			ConsultationText ();
			MenuMendoza();
			break;
		case 5:
			readFileTxt();
			MenuMendoza();
			break;
		case 6:
			readFileCsv();
			MenuMendoza();
			break;
		case 7:
			readFileJson();
			MenuMendoza();
			break;
		case 8:
			System.out.print("\n**SALSITE CON EXITO..**: ");
			break;
		default:
			System.out.print("\n**VUELVA A SELECCIONAR UNA OPION** ");
			MenuMendoza();
		}
		
	}
	public void AskText () {
		int pos[]= new int[5];
		String nombreCliente;
		System.out.print("\nINGRESA EL NOMBRE DEL CLIENTE: ");
		nombreCliente = cin.next();
		System.out.print("\nINGRESA LA CANTIDAD TEXTOS QUE NECESITAS [1 - 5]: ");
		amountAsk = cin.nextInt();
		while(amountAsk<1||amountAsk>5) {
			System.out.print("\n**VUELVE A INGRESAR LA CANTIDAD TEXTOS QUE NECESITAS [1 - 5]**: ");
			amountAsk = cin.nextInt();
		}
		SetAmountAsk(amountAsk);
		for(int i=0; i<GetAmountAsk();i++) {
			System.out.print("\nINGRESA EL NOMBRE DEL TEXTO QUE DESEAS: ");
			nameAsk = cin.next();
			pos[i] = BusquedaSecuencial(nameAsk, mysText);
			while(pos[i]==-1) {
				System.out.print("\nVUELVE A INGRESAR EL NOMBRE DEL TEXTO QUE DESEAS: ");
				nameAsk = cin.next();
				pos[i] = BusquedaSecuencial(nameAsk, mysText);
			}
			mysText[pos[i]].SetAmountText(GetAmountText()-1);
		}
		//crea el archivo
		try {
	        FileWriter Archivo_Mendoza = new FileWriter("Pedidos.txt");
	        Archivo_Mendoza.write("\nNombre: "+nombreCliente);
	        for(int i=0; i<GetAmountAsk(); i++) {
	        	Archivo_Mendoza.write("\n\t**Tiket pedido**");
	        	Archivo_Mendoza.write("\nArticulo: "+nameAsk);
		        Archivo_Mendoza.write("\nTipo: "+mysText[pos[i]].GetTypeText());
		        Archivo_Mendoza.write("\nCodigo: "+mysText[pos[i]].GetIdText());
		        Archivo_Mendoza.write("\nCantidad: "+1);
		        Archivo_Mendoza.write("\nAño: "+mysText[pos[i]].GetAnioText());
	        }
	        Archivo_Mendoza.close(); // Cierra el archivo FileWriter
	        System.out.println("\nLOS DATOS SE HAN GUARDADO EN EL ARCHIVO 'Pedidos.txt' correctamente.\n");
	    } catch (IOException e) { // Captura una posible excepción de entrada/salida
	        System.err.println("\nERROR AL ABRIR EL ARCHIVO\n");
	        e.printStackTrace(); // Imprime la traza de la excepción
	    }
	}
	public void readFileTxt() {
		//lee el archivo
		try {
		    BufferedReader Archivo_Mendoza = new BufferedReader(new FileReader("Pedidos.txt")); // Abre el archivo en modo de lectura usando BufferedReader		  
		    System.out.println("\nARCHIVO ABIERTO EN EL MODO LECTURA..\n");		    
		    String linea;	
		    System.out.println("\n\tCOMPROBANTE\n");
		    while ((linea = Archivo_Mendoza.readLine()) != null) {// Lee cada línea del archivo hasta que llega al final
		        System.out.println(linea);
		    }		    
		    Archivo_Mendoza.close(); // Cierra el archivo después de leer todas las líneas
		} catch (IOException e) { // En caso de que ocurra una excepción al abrir o leer el archivo		   
		    System.out.println("\nERROR, NO SE PUEDE ABRIR EL ARCHIVO SOLO LECTURA..\n");		    
		    e.printStackTrace(); // Imprime la traza de la excepción en la consola
		}
	}
	public void ReurnText () {
		int pos[]= new int[5];
		String nombreCliente;
		System.out.print("\nINGRESA EL NOMBRE DEL CLIENTE: ");
		nombreCliente = cin.next();
		System.out.print("\nINGRESA LA CANTIDAD TEXTOS QUE VAS A DEVOLVER [1 - 5]: ");
		amountReturn = cin.nextInt();
		while(amountReturn<1||amountReturn>5) {
			System.out.print("\n**VUELVE A INGRESAR LA CANTIDAD TEXTOS QUE VAS A DEVOLVER [1 - 5]**: ");
			amountReturn = cin.nextInt();
		}
		SetAmountReturn(amountReturn);
		for(int i=0; i<GetAmountReturn();i++) {
			System.out.print("\nINGRESA EL NOMBRE DEL TEXTO: ");
			nameReturn = cin.next();
			pos[i] = BusquedaSecuencial(nameReturn, mysText);
			while(pos[i]==-1) {
				System.out.print("\nVUELVE A INGRESAR EL NOMBRE DEL TEXTO: ");
				nameReturn = cin.next();
				pos[i] = BusquedaSecuencial(nameReturn, mysText);
			}
			mysText[pos[i]].SetAmountText(GetAmountText()+1);
		}
		//crea el archivo
		try {
		    FileWriter archivoCsv = new FileWriter("Devoluciones.csv");
		    
		    // Escribir la cabecera del archivo CSV
		    archivoCsv.write("NombreCliente,NombreTexto,Tipo,Codigo,Cantidad,Anio\n");
		    
		    // Escribir los datos de devolución
		    for (int i = 0; i < GetAmountReturn(); i++) {
		        archivoCsv.write(String.format("%s,%s,%s,%s,%d,%d\n",
		                nombreCliente,
		                nameReturn,
		                mysText[pos[i]].GetTypeText(),
		                mysText[pos[i]].GetIdText(),
		                1,
		                mysText[pos[i]].GetAnioText()));
		    }
		    
		    archivoCsv.close(); // Cierra el archivo FileWriter
		    System.out.println("\nLOS DATOS SE HAN GUARDADO EN EL ARCHIVO 'Devoluciones.csv' correctamente.\n");
		} catch (IOException e) { // Captura una posible excepción de entrada/salida
		    System.err.println("\nERROR AL ABRIR EL ARCHIVO\n");
		    e.printStackTrace(); // Imprime la traza de la excepción
		}
	}
	public void readFileCsv() {
		//lee el archivo
		try  {
			BufferedReader Archivo_Mendoza = new BufferedReader(new FileReader("Devoluciones.csv"));
	        System.out.println("\nARCHIVO CSV ABIERTO EN MODO LECTURA..\n");
	        
	        String linea;
	        // Leer y mostrar la cabecera del CSV
	        if ((linea = Archivo_Mendoza.readLine()) != null) {
	            System.out.println(linea);
	        }
	        // Leer y mostrar las líneas del archivo CSV
	        while ((linea = Archivo_Mendoza.readLine()) != null) {
	            String[] datos = linea.split(",");
	            System.out.printf("Nombre del Cliente: %s, Nombre del Texto: %s, Tipo: %s, Código: %s, Cantidad: %s, Año: %s%n",
	                    datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
	        }
	        Archivo_Mendoza.close();
	    } catch (IOException e) {
	        System.out.println("\nERROR, NO SE PUEDE ABRIR EL ARCHIVO CSV EN MODO LECTURA..\n");
	        e.printStackTrace();
	    }
	}
	public void ConsultationText () {
		System.out.println("\nLIBROS DISPONIBLES\n");		
		for(int i=0; i<mysText.length; i++) {
			if (mysText[i] != null) {
                System.out.printf("[%d] %s %s %s %s %d %d%n",
                        (i + 1),
                        mysText[i].GetNameText(),
                        mysText[i].GetIdText(),
                        mysText[i].GetTypeText(),
                        mysText[i].GetAutorText(),
                        mysText[i].GetAmountText(),
                        mysText[i].GetAnioText());
            }
		}
		//generar formato json
		try {
	        JSONArray jsonArray = new JSONArray();

	        // Agregar datos al JSONArray
	        for (int i = 0; i < mysText.length; i++) {
	            if (mysText[i] != null) {
	                JSONObject jsonObject = new JSONObject();
	                jsonObject.put("Nombre", mysText[i].GetNameText());
	                jsonObject.put("ID", mysText[i].GetIdText());
	                jsonObject.put("Tipo", mysText[i].GetTypeText());
	                jsonObject.put("Autor", mysText[i].GetAutorText());
	                jsonObject.put("Cantidad", mysText[i].GetAmountText());
	                jsonObject.put("Año", mysText[i].GetAnioText());
	                jsonArray.put(jsonObject);
	            }
	        }

	        // Escribir el JSONArray en un archivo
	        FileWriter archivoJson = new FileWriter("textos_disponibles.json");
	        archivoJson.write(jsonArray.toString(4)); // Formateado con indentación de 4 espacios
	        archivoJson.close();

	        System.out.println("Archivo JSON generado exitosamente: textos_disponibles.json");
	    } catch (IOException e) {
	        System.err.println("Error al generar el archivo JSON.");
	        e.printStackTrace();
	    }
	}
	public void readFileJson() {
		//lectura formato json
		try (BufferedReader reader = new BufferedReader(new FileReader("textos_disponibles.json"))) {
	        StringBuilder jsonBuilder = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            jsonBuilder.append(line);
	        }
	        // Parse the JSON content
	        JSONArray jsonArray = new JSONArray(jsonBuilder.toString());

	        // Iterate through the JSONArray and print the contents
	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            System.out.printf("Nombre: %s, ID: %s, Tipo: %s, Autor: %s, Cantidad: %d, Año: %d%n",
	                    jsonObject.getString("Nombre"),
	                    jsonObject.getString("ID"),
	                    jsonObject.getString("Tipo"),
	                    jsonObject.getString("Autor"),
	                    jsonObject.getInt("Cantidad"),
	                    jsonObject.getInt("Año"));
	        }
	    } catch (IOException e) {
	        System.err.println("Error al leer el archivo JSON.");
	        e.printStackTrace();
	    }
	}
	public int BusquedaSecuencial(String nameAsk, BibliotecaMendoza[] mysText2) {
		int pos=-1;
		for(int i=0; i< mysText.length; i++) {
			if(mysText[i] != null && nameAsk.equals(mysText[i].GetNameText())) {
				pos = i;
				break;
			}
		}
		return pos;
	}
}
