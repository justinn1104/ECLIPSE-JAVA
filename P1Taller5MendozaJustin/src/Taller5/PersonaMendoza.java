package Taller5;

import java.util.Scanner;

public class PersonaMendoza {
	static Scanner cin = new Scanner(System.in);
	protected String name, lastName, dni, date;
	public PersonaMendoza(String name, String lastName, String dni, String date) {
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.date = date;
	} 
	//setter y getter
		public String getName() {
			return name;
		}
		public String getLastName() {
			return name;
		}
		public String getDni() {
			return name;
		}
		public String getDate() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public void setDate(String date) {
			this.date = date;
		}
	public void InsertData() {
		System.out.print("\nIngresa el nombre:");
		name = cin.nextLine();
		System.out.print("\nIngresa el apellido:");
		lastName = cin.nextLine();
		System.out.print("\nIngresa el dni:");
		dni = cin.nextLine();
		System.out.print("\nIngresa el date:");
		date = cin.nextLine();
		ReturnData(name, lastName, dni, date);
		/*setName(name);
		setLastName(lastName);
		setDni(dni);
		setDate(date);*/
	}
	public void ReturnData(String name, String lastName, String dni, String date) {	}
}
