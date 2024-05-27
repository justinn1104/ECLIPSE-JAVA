package Laboratorio2;

public abstract class BibliotecaMendoza {
	protected String nameText, idText, typeText, autorText;
	protected int amountText, anioText;
	//constructor para la instancia de la biblioteca
	public BibliotecaMendoza(String nameText, String idText, String typeText, String autorText, int amountText, int anioText) {
		this.nameText = nameText;
		this.idText = idText;
		this.typeText = typeText;
		this.autorText = autorText;
		this.amountText = amountText;
		this.anioText = anioText;
	}
	//encapsuladores e metodas de (getter y setter)
	public String GetNameText () {
		return nameText;
	}
	public void SetNameText (String nameText) {
		this.nameText = nameText;
	}
	public String GetIdText () {
		return idText;
	}
	public void SetIdText (String idText) {
		this.idText = idText;
	}
	public String GetTypeText () {
		return typeText;
	}
	public void SetTypeText (String typeText) {
		this.typeText = typeText;
	}
	public String GetAutorText () {
		return autorText;
	}
	public void SetAutorText (String autorText) {
		this.autorText = autorText;
	}
	public int GetAmountText () {
		return amountText;
	}
	public void SetAmountText (int amountText) {
		this.amountText = amountText;
	}
	public int GetAnioText () {
		return anioText;
	}
	public void SetAnioText (int anioText) {
		this.anioText = anioText;
	}
	//metodo para generar nuevos textos
	public abstract void GenerateText();
	//metodo para generar nuevos textos
}
