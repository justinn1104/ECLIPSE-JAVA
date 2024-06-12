package SistemaDistribuidora;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

//Clase Hija1: ProductoAlimenticio
class ProductoAlimenticioMendoza extends ProductoMendoza {
 // Atributos propios
 private String fechaExpiracion;
 private int dd, mm, yyyy,dd2, mm2, yyyy2;
 // Constructor
 public ProductoAlimenticioMendoza(String nombre, String codigo, String fechaCreacion, double precio, String fechaExpiracion) {
     super(nombre, codigo, fechaCreacion, precio);
     this.fechaExpiracion = fechaExpiracion;
 }

 @Override
 public  void IngresarProducto() {
	 fechaCreacion = generarFecha();
	 fechaExpiracion = generarFecha();
	 System.out.println("FECHA DE INGRESO: "+fechaCreacion);
	 System.out.println("FECHA DE EXPIRACIÓN:"+fechaExpiracion);
	 System.out.println(fechaCreacion.length() + "   "+ fechaExpiracion.length());
	 dd=descomponerFecha(fechaCreacion, 0, 2);
	 mm=descomponerFecha(fechaCreacion, 3, 5);
	 yyyy=descomponerFecha(fechaCreacion, 6, 10);
	 dd2=descomponerFecha(fechaExpiracion, 0, 2);
	 mm2=descomponerFecha(fechaExpiracion, 3, 5);
	 yyyy2=descomponerFecha(fechaExpiracion, 6, 10);
	 if(yyyy2==yyyy) {
		 if(mm2==dd) {
			 if(dd2<=dd) {
				 System.out.println("EL ESTADO DEL PRODUCTO ES BUENO");
			 }else {
				 System.out.println("EL ESTADO DEL PRODUCTO ES EXPIRADO");
			 }
		 }else {
			 if(mm2>mm) {
				 System.out.println("EL ESTADO DEL PRODUCTO ES EXPIRADO");
			 }
		 }
	 }else{
		 if(yyyy2>yyyy) {
			 System.out.println("EL ESTADO DEL PRODUCTO ES EXPIRADO");
		 }
		 
	 }
	 
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
 public void ValidarVigenciaProducto() {
     // Método para validar la vigencia del producto alimenticio
 }
}