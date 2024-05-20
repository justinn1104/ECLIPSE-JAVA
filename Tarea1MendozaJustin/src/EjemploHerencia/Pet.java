package EjemploHerencia;

public class Pet extends Animal{
	private String ColorPet;//modificador de acceso "private"
	private float WeinghtPet;
	private float SizePet;
	
	//CONSTRUCTOR DE ME CLASE HIJA "PET"
	public Pet(String nameAnimal, String raceAnimal, int ageAnimal, String ColorPet, float WeinghtPet, float SizePet) {
		super(nameAnimal, raceAnimal, ageAnimal);
		this.ColorPet =  ColorPet;
		this.WeinghtPet =  WeinghtPet;
		this.SizePet =  SizePet;
	}
	
	public void ShowDate() {
		System.out.println("Nombre: "+GetNameAnimal()+
				"\nRaza: "+GetRaceAnimal()+
				"\nEdad: "+GetAgeAnimal()+" year"+
				"\nColor: "+ColorPet+
				"\nPeso: "+WeinghtPet+
				"\nTamano: "+SizePet);
	}
}
