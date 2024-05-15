package EjemploPolimorfismo;

public class Pet extends Animal{
	protected String ColorPet;
	public float WeinghtPet;
	public float SizePet;
	
	//CONSTRUCTOR DE ME CLASE HIJA "PET"
	public Pet(String nameAnimal, String raceAnimal, int ageAnimal, String ColorPet, float WeinghtPet, float SizePet) {
		super(nameAnimal, raceAnimal, ageAnimal);
		this.ColorPet =  ColorPet;
		this.WeinghtPet =  WeinghtPet;
		this.SizePet =  SizePet;
	}
	public String GetColorPet() {
		return ColorPet;
	}
	
	public float  GetWeinghtPet() {
		return WeinghtPet;
	}
	
	public float GetSizePet() {
		return SizePet;
	}
	@Override//override para indicar que se sobreescribira el metodo de la clase madre
	public String ShowDate() {
		return "Nombre: "+GetNameAnimal()+
				"\nRaza: "+GetRaceAnimal()+
				"\nEdad: "+GetAgeAnimal()+" year"+
				"\nColor: "+GetColorPet()+
				"\nPeso: "+GetWeinghtPet()+ " kilos"+
				"\nTamano: "+GetSizePet()+" cm";
	}
}
