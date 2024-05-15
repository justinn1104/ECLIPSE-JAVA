package EjemploHerencia;

public abstract class Animal {
	protected String nameAnimal;
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
