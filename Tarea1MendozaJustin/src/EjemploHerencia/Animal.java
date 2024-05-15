package EjemploHerencia;

public abstract class Animal {
	protected String nameAnimal;//modificador de acceso "protected"
	protected String raceAnimal;
	protected int ageAnimal;
	
	public Animal(String nameAnimal, String raceAnimal, int ageAnimal){
		this.nameAnimal = nameAnimal;
		this.raceAnimal = raceAnimal;
		this.ageAnimal = ageAnimal;
	}
	
	public String GetNameAnimal() {
		return nameAnimal;
	}
	
	public String GetRaceAnimal() {
		return raceAnimal;
	}
	
	public int GetAgeAnimal() {
		return ageAnimal;
	}
}
