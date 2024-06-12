package SistemaDistribuidora;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Clase Padre: Producto
public abstract class ProductoMendoza {
	//enstancias
	static Scanner cin = new Scanner(System.in);
	// Atributos
    protected String nombre, codigo, fechaCreacion;
    protected double precio;

    // Constructor
    public ProductoMendoza(String nombre, String codigo, String fechaCreacion, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.precio = precio;
    }

    // Métodos
    public abstract void IngresarProducto();
    
    public void GuardarProductoCSV() {
        // Método para guardar información del producto en un archivo CSV
        try {
            FileWriter csvWriter = new FileWriter("productos.csv", true);
            csvWriter.append(nombre);
            csvWriter.append(",");
            csvWriter.append(codigo);
            csvWriter.append(",");
            csvWriter.append(fechaCreacion.toString());
            csvWriter.append(",");
            csvWriter.append(String.valueOf(precio));
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String generarFecha() {
    	int dd, mm, yy;
        String dd2, mm2, yy2;
        System.out.print("INGRESA EL AÑO [2024 - 2030]: ");
        yy = cin.nextInt();
        while (yy<2024 || yy>2030) {
            System.out.print("**VUELVA A INGRESAR EL AÑO [2024 - 2030]**: ");
            yy = cin.nextInt();
        }
        System.out.print("INGRESA EL MES [1 AL 12]: ");
        mm = cin.nextInt();
        while (mm < 1 || mm > 12) {
            System.out.print("**VUELVA A INGRESAR EL MES [1 AL 12]**: ");
            mm = cin.nextInt();
        }
        if(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12) {
        	System.out.print("INGRESA EL DIA [1 AL 31]: ");//31 dias
            dd = cin.nextInt();
            while (dd < 1 || dd > 31) {
                System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 31]**: ");
                dd = cin.nextInt();
            }
        }else {
        	if(mm==4||mm==6||mm==9||mm==11) {
        		System.out.print("INGRESA EL DIA [1 AL 30]: ");//30 dias
                dd = cin.nextInt();
                while (dd < 1 || dd > 30) {
                    System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 30]**: ");
                    dd = cin.nextInt();
                }
        	}else {
        		System.out.print("INGRESA EL DIA [1 AL 28]: ");//28
                dd = cin.nextInt();
                while (dd < 1 || dd > 28) {
                    System.out.print("**VUELVA A INGRESAR EL DIA [1 AL 28]**: ");
                    dd = cin.nextInt();
                }
        	}
        }
        dd2 = Integer.toString(dd);
        mm2 = Integer.toString(mm);
        yy2 = Integer.toString(yy);
        if(dd<10) {
        	dd2="0".concat(dd2);
        }
        if(mm<10) {
        	mm2="0".concat(mm2);
        }
        String form;
        form = dd2.concat("/").concat(mm2).concat("/").concat(yy2);
        return form;
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

}
