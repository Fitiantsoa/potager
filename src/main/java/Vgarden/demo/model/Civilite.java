package Vgarden.demo.model;

public enum Civilite {
	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");

	private String titre;

	private Civilite(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}
}
