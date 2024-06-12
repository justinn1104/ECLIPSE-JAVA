package SistemaDistribuidora;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

//Clase Hija2: ProductoElectronico
public class ProductoElectronicoMendoza extends ProductoMendoza {
	// Atributos propios
    private String modelo;

    // Constructor
    public ProductoElectronicoMendoza(String nombre, String codigo, String fechaCreacion, double precio, String modelo) {
        super(nombre, codigo, fechaCreacion, precio);
        this.modelo = modelo;
    }
    @Override
    public  void IngresarProducto() {
   	 
    }
    @Override
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
    // Método propio
    public void RegistrarGarantia() {
        // Método para registrar la garantía del producto electrónico
    }
}

