package Taller5;


public class Principal {
	static PersonaMendoza studens = new EstudiantesMendoza(0f,0f,0f,null,null, null, null, null);
	static PersonaMendoza teacher = new ProfesorMendoza(null,0,0f,0f,null,null, null, null);
	public static void main(String[] args) {
		studens.InsertData();
		teacher.InsertData();
		
	}

}
