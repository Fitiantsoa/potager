package Vgarden.demo.model;

public enum TypePlante {

	Ail("Ail"), Aubergine("Aubergine"), Betterave("Betterave"), Carotte("Carotte"), Concombre("Concombre"),
	Céléri("Céléri"), Chou("Chou"), Courge("Courge"), Courgette("Cougette"), Fenouil("Fenouil"), Fraisier("Fraisier"), Haricot("Haricot"), Laitue("Laitue"), Melon("Melon"), Poireau("Poreau"), Pois("Pois"), Poivron("Poivron"), Radis("Radis"), Tomate("Tomate");
	private String nom;
	
	private TypePlante(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	}

