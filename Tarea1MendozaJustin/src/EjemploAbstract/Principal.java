package EjemploAbstract;

public class Principal {//clase princial del programa

	public static void main(String[] args) {
		Silver silver = new Silver();
		AnimalCarnivorous animalC = new AnimalCarnivorous();
		AnimalHerbivorous animalH = new AnimalHerbivorous();
		
		
		silver.Feed();
		animalC.Feed();
		animalH.Feed();
	}

}
