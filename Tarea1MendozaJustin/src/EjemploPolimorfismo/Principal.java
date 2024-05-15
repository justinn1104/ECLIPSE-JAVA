package EjemploPolimorfismo;

public class Principal {

	public static void main(String[] args) {
		Animal myAnimals[] = new Animal[2];
		
		myAnimals[0]= new Animal("Tigre","felino",1);
		myAnimals[1]= new Pet("serpiente","reptil",4,"verde",56.3f,15.3f);
		
		for(Animal animals: myAnimals) {
			System.out.println(animals.ShowDate());
			System.out.println(" ");
			
		}
		

	}

}
