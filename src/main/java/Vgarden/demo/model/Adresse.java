package Vgarden.demo.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Objects;

@Embeddable
public class Adresse {
	@JsonView(Views.Common.class)
	private String numero;
	@JsonView(Views.Common.class)
	private String voie;
	@JsonView(Views.Common.class)
	private String ville;
	@JsonView(Views.Common.class)
	private String cp;

	public Adresse() {

	}

	public Adresse(String numero, String voie, String ville, String cp) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cp, numero, ville, voie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(cp, other.cp) && Objects.equals(numero, other.numero)
				&& Objects.equals(ville, other.ville) && Objects.equals(voie, other.voie);
	}



}
