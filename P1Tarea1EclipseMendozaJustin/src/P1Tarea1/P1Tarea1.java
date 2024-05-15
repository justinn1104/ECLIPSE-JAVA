package P1Tarea1;
import java.util.Scanner; // Importa la clase Scanner de la librería java.util lectura de datos
import java.io.FileWriter; // Importa la clase FileWriter para escribir en archivos
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida
import java.io.BufferedReader; //Importa la clase BufferedReader del paquete java.io
import java.io.FileReader; //Importa a clase FileReader del paquete java.io
public class P1Tarea1 {
	static int b=0, itenSelection, numberAmountMendoza, sizeMendoza = 8;
    static double SubTotal, Total, IVA=1.12;
    static String []nameProductMendoza = new String [100];
    static int []amountProductMendoza = new int [100];
    static double []PriceProductMendoza = new double [100];
    static String []nameProductAddMendoza = new String [100];
    static int []amountProductAddMendoza = new int [100];
    static double []priceProductAddMendoza = new double [100];
    static double []subPriceProductMendoza = new double [100];   
    static String []nameProductBoughtMendoza = new String [100];
    static int []amountProductBoughtMendoza = new int [100];
    static double []priceProductBoughtMendoza = new double [100]; 
	static String nameProduct;
	static int amountProduct;
	static double priceProduct, IVA_PRODUCT = 0.15, taxProduct, subTotalProduct, totalProduct;
	static int amountNamesMendoza;
	static String []namesMendoza = new String[10];
	public static void main(String[] args) {
		MenuMendoza();
	}
	public static void MenuMendoza(){
		int opMenuMendoza;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEVALUACION #1 POO\n");
		System.out.println("[1] MINIMARKET JM");
		System.out.println("[2] CALCULAR IMPUESTO");
		System.out.println("[3] ORDENAR ARREGLO");
		System.out.println("[4] CREAR ACHIVO");
		System.out.println("[5] LEER ACHIVO");
		System.out.println("[6] SALIR");
		System.out.print("\nSelecciona una opcion: ");
		opMenuMendoza = scanner.nextInt();
		while(opMenuMendoza<1 || opMenuMendoza>6) {
			System.out.print("\nVuelva a seleccionar una opcion: ");
			opMenuMendoza = scanner.nextInt();
		}
		switch(opMenuMendoza) {
			case 1:
				MenuMarket();
				MenuMendoza();
				break;
			case 2:
				TaxMendoza();
				MenuMendoza();
				break;
			case 3:
				ArrayToBubbleSort();
				MenuMendoza();
				break;
			case 4:
				Create_A_Archive();
				MenuMendoza();
				break;
			case 5:
				Read_A_Archive();
				MenuMendoza();
				break;
			case 6:
				System.out.println("\nSaliste con exito..\n");
				break;
			default:
				System.out.print("\nVuelva a selercionar una opcion...\n");
		}
	}
	public static void TaxMendoza() {
		priceProduct=0;
		taxProduct=0;
		subTotalProduct=0;
		totalProduct=0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nIngresa el nombre del producto que desea: ");
		nameProduct = scanner.nextLine();
		System.out.print("\nIngresa la cantida de " + nameProduct + " que desea [1 uni - 30 uni] : ");
		amountProduct = scanner.nextInt();
		while(amountProduct < 1 || amountProduct > 30 ) {
			System.out.print("\nVuelva a ingresar la cantida de " + nameProduct + " que desea [1 uni - 30 uni] : ");
			amountProduct = scanner.nextInt();
		}
		System.out.print("\nIngresa el Precio del productos " + nameProduct + " [$0.1 - $1] : ");
		priceProduct = scanner.nextFloat();
		while(priceProduct < 0.1 || priceProduct > 1) {
			System.out.print("\nVuelva a ingresar el Precio del productos " + nameProduct + " [$0.1 - $1] : ");
			priceProduct = scanner.nextDouble();
		}
		System.out.println("\n\t\t\t*VENTA*");
		System.out.println("\nCant. \tDescripcion \tC. Uni. \tC. Total");
		System.out.println(amountProduct + " \t" + nameProduct + " \t" + priceProduct + " \t" + amountProduct*priceProduct );
		
		subTotalProduct = amountProduct * priceProduct;
		taxProduct = subTotalProduct * IVA_PRODUCT;
		totalProduct = subTotalProduct + taxProduct;
		System.out.println("\nSUBTOTAL: $"+subTotalProduct);
		System.out.println("IMPUESTO: $"+taxProduct);
		System.out.println("TOTAL: $"+totalProduct);
	}
	public static void ArrayToBubbleSort() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nIngresa la cantidad de nombres que desas: [1 a 10]");
		amountNamesMendoza = scanner.nextInt();
		while(amountNamesMendoza <1 || amountNamesMendoza >10) {
			System.out.print("\nVuelve a ingresar la cantidad de nombres que desas: [1 a 10]");
			amountNamesMendoza = scanner.nextInt();
		}
		for(int i=0; i< amountNamesMendoza ; i++) {
			System.out.print("\nIngresa el nombre #" + (i+1) + " : ");
			namesMendoza[i] = scanner.next();
		}
		for(int i=0 ; i<amountNamesMendoza ; i++) {
			System.out.println(i+1 + "-" + namesMendoza[i]);
		}
		System.out.println("\n\t*NOMBRES ORDENADOS POR EL METODO BURBUJA*\n");
		for(int i=0; i<amountNamesMendoza ; i++) {
			for(int j=0 ; j<amountNamesMendoza-1 ; j++) {
				if(namesMendoza[j].compareTo(namesMendoza[j+1])>0){
					String aux = namesMendoza[j];
					namesMendoza[j]=namesMendoza[j+1];
					namesMendoza[j+1]=aux;
				}
			}
		}
		for(int i=0 ; i<amountNamesMendoza ; i++) {
			System.out.println(i+1 + "-" + namesMendoza[i]);
		}
	}
	public static void Create_A_Archive() {
		try {
            FileWriter Archivo_Mendoza = new FileWriter("Registro.txt"); // Crea un objeto FileWriter para escribir en el archivo "Registro.txt"           
            Archivo_Mendoza.write("\n\t\t\t*VENTA*");
            Archivo_Mendoza.write("\nCant. \tDescripcion \tC. Uni. \tC. Total\n");
            Archivo_Mendoza.write(amountProduct + " \t" + nameProduct + " \t" + priceProduct + " \t" + amountProduct*priceProduct );
    		Archivo_Mendoza.write("\nSUBTOTAL: $"+subTotalProduct);
    		Archivo_Mendoza.write("\nIMPUESTO: $"+taxProduct);
    		Archivo_Mendoza.write("\nTOTAL: $"+totalProduct);
            Archivo_Mendoza.write("\n\n\n\t*NOMBRES ORDENADOS POR EL METODO BURBUJA*\n");
    		for(int i=0 ; i<amountNamesMendoza ; i++) {
    			Archivo_Mendoza.write("\n"+ (i+1) + "-" + namesMendoza[i]);
    		}
            Archivo_Mendoza.close(); // Cierra el archivo FileWriter
            System.out.println("\nLOS DATOS SE HAN GUARDADO EN EL ARCHIVO 'Registro.txt' correctamente.\n");
        } catch (IOException e) { // Captura una posible excepción de entrada/salida
            System.err.println("\nERROR AL ABRIR EL ARCHIVO\n");
            e.printStackTrace(); // Imprime la traza de la excepción
        }
	}
	public static void Read_A_Archive() {
		try {
		    BufferedReader Archivo_Mendoza = new BufferedReader(new FileReader("Registro.txt")); // Abre el archivo en modo de lectura usando BufferedReader		  
		    System.out.println("\nARCHIVO ABIERTO EN EL MODO LECTURA..\n");		    
		    String linea;		    
		    while ((linea = Archivo_Mendoza.readLine()) != null) {// Lee cada línea del archivo hasta que llega al final
		        System.out.println(linea);
		    }		    
		    Archivo_Mendoza.close(); // Cierra el archivo después de leer todas las líneas
		} catch (IOException e) { // En caso de que ocurra una excepción al abrir o leer el archivo		   
		    System.out.println("\nERROR, NO SE PUEDE ABRIR EL ARCHIVO SOLO LECTURA..\n");		    
		    e.printStackTrace(); // Imprime la traza de la excepción en la consola
		}
	}
	
	//minimarket          
    public static void MenuMarket(){
    	nameProductMendoza[0]="Coca Cola";nameProductMendoza[1]="Dorito";nameProductMendoza[2]="Empanada de verde";nameProductMendoza[3]="Cafe lato";
    	nameProductMendoza[4]="Dedito de queso";nameProductMendoza[5]="Yogurt";nameProductMendoza[6]="Galletas";nameProductMendoza[7]="KFC";
        amountProductMendoza[0]=10;amountProductMendoza[1]=10;amountProductMendoza[2]=10;amountProductMendoza[3]=10;amountProductMendoza[4]=10;amountProductMendoza[5]=10;amountProductMendoza[6]=10;amountProductMendoza[7]=10;
        PriceProductMendoza[0]=1.00;PriceProductMendoza[1]=1.00;PriceProductMendoza[2]=0.50;PriceProductMendoza[3]=1.00;PriceProductMendoza[4]=0.50;PriceProductMendoza[5]=0.75;PriceProductMendoza[6]=0.25;PriceProductMendoza[7]=7.50;
        Scanner scanner = new Scanner(System.in);
        int OpcMenu;
        System.out.println("[1] COMPRAR PRODUCTO");
        System.out.println("[2] INGRESAR INVENTARIO");
        System.out.println("[3] IMPRIMIR INVENTARIO");
        System.out.println("[4] SALIR");
        System.out.println("SELECCIONAR UNA OPCION : ");
        OpcMenu = scanner.nextInt();
        switch(OpcMenu){
            case 1:
                System.out.println("\tSelecciona un articulo para vender");
                GenaradoVentas();
                MenuMarket();
                break;
            case 2:
                System.out.println("\tAñade articulos nuevos al inventario");
                AddProductos();
                MenuMarket();
                break;
            case 3:
                System.out.println("\n\tInventario del Minimarket");
                numberAmountMendoza=0;
                Imprimir_Inven(nameProductAddMendoza, amountProductAddMendoza, priceProductAddMendoza, b);
                MenuMarket();
                break;
            case 4:
            	System.out.println("\nSaliste con exito..\n");
                break;
            default:
            	System.out.print("\nVuelva a selercionar una opcion...\n");
                MenuMarket();
        }
    }
    public static void GenaradoVentas(){
        Scanner scanner = new Scanner(System.in);
        String NewCompra, Conver;
        Imprimir_Inven(nameProductMendoza, amountProductMendoza, PriceProductMendoza, b);
        System.out.print("Seleciona un iten: ");
        itenSelection = scanner.nextInt();        
        if(itenSelection>0 && itenSelection<=sizeMendoza+b){
            int aux1 = itenSelection - 1;
            do{
                System.out.print("Seleciona la cantidad del articulo [1 a " + amountProductMendoza[aux1] + "] : ");
                numberAmountMendoza = scanner.nextInt();
                while(numberAmountMendoza<1||numberAmountMendoza>amountProductMendoza[aux1]) {
                	System.out.print("\nVuelva a selecionar la cantidad del articulo [1 a " + amountProductMendoza[aux1] + "] : ");
                    numberAmountMendoza = scanner.nextInt();
                }
                if(numberAmountMendoza<=amountProductMendoza[aux1]){
                    venta(nameProductMendoza, amountProductMendoza, PriceProductMendoza, subPriceProductMendoza, aux1,numberAmountMendoza);
                    amountProductMendoza[aux1] = amountProductMendoza[aux1]- numberAmountMendoza;
                    do{
		                System.out.print("Desea compar otro articulo?...(S/N):" );                
		                NewCompra = scanner.next();
		                Conver = NewCompra.toLowerCase();
		                if(Conver.equals("s")){                        
		                    GenaradoVentas();
		                }else if(Conver.equals("n")){
		                   break;
		               }else{
		                    System.out.println("Opciones no validas... intentalo de nuevo::....");
		               }
		            }while(Conver != "n");                                              
                }else{
                    System.out.println("Ingresa una cantidad que sustente el stok\t");                    
                }
            }while(numberAmountMendoza>amountProductMendoza[aux1]);            
        }else{
            System.out.println("Ingresa un articulo que este en el inventario\t");
            GenaradoVentas();            
        }                             
    }
    
    public static void venta(String []Array1, int []Array2, double []Array3, double []Array4, int e, int c){        
        System.out.println("["+(e+1)+"] \t"+c+"\t "+" $"+Array3[e]+"\t\t"+Array1[e]);
        Array4[e] = c * Array3[e];
        SubTotal += Array4[e];
        Total = SubTotal* IVA;
        System.out.println("\t\t\t Sub Total :  \t "+SubTotal);
        System.out.println("\t\t\t IVA 12% :  \t "+(Total-SubTotal));
        System.out.println("\t\t\t Total :  \t "+Total);
    }
    
    public static int AddProductos(){
        Scanner scanner = new Scanner(System.in);                      
        System.out.print("\nIngresa la cantidad de productos que deseas ingresar [1 a 5] : ");
        b = scanner.nextInt();        
        while(b<1 || b>5) {
        	System.out.print("\nVuelva a ingresar la cantidad de productos que deseas ingresar [1 a 5] : ");
            b = scanner.nextInt();
        }
        for(int i = sizeMendoza ; i <sizeMendoza+b ; i++ ){
            System.out.print("Ingresa el  nombre el producto #"+ (i+1)+" : ");
            nameProductAddMendoza[i] = scanner.next();
            System.out.print("Ingresa la cantidad del producto #"+ (i+1)+" [1 a 10] : ");
            amountProductAddMendoza[i]=scanner.nextInt();
            while(amountProductAddMendoza[i]<1 || amountProductAddMendoza[i]>10) {
            	System.out.print("\nVuelva a ingresar la  cantidad del producto #"+ (i+1)+" [1 a 10] : ");
                amountProductAddMendoza[i]=scanner.nextInt();
            }
            System.out.print("Ingresa el precio del producto #"+ (i+1)+" [$0.1 a $50] : ");
            priceProductAddMendoza[i]=scanner.nextDouble();
            while(priceProductAddMendoza[i]<0.1||priceProductAddMendoza[i]>50) {
            	System.out.print("\nVuelva a ingresar el precio del producto #"+ (i+1)+" [$0.1 a $50] : ");
                priceProductAddMendoza[i]=scanner.nextDouble();
            }
        }
        System.out.println("\n");
        for(int i = sizeMendoza; i<b+sizeMendoza; i++){           
            System.out.println("["+(i+1)+"] \t"+amountProductAddMendoza[i]+"\t "+" $"+priceProductAddMendoza[i]+"\t\t"+nameProductAddMendoza[i]);    
        }
        System.out.println("\n");
        for(int i=0; i<b+sizeMendoza; i++){
        	amountProductMendoza[sizeMendoza+i]= amountProductAddMendoza[i];
            PriceProductMendoza[sizeMendoza+i]= priceProductAddMendoza[i];
            nameProductMendoza[sizeMendoza+i]= nameProductAddMendoza[i];
        }
        return b;
    }

    public static void Imprimir_Inven(String []Array1, int []Array2, double []Array3, int a){    	        
        System.out.println("\n");
        for(int i=sizeMendoza; i<a+sizeMendoza; i++){
        	amountProductMendoza[i]= Array2[i];
            PriceProductMendoza[i]= Array3[i];
            nameProductMendoza[i]= Array1[i];
        }
        for(int i=0;i<sizeMendoza+a;i++){
           System.out.println("["+(i+1)+"] \t"+amountProductMendoza[i]+"\t "+" $"+PriceProductMendoza[i]+"\t\t"+nameProductMendoza[i]);  
        }
        System.out.println("\n");
    }
}
