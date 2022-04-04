package Vgarden.demo.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", initialValue = 50, allocationSize = 1)
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	@Column(name = "produit_id")
	@JsonView(Views.Common.class)	
	private Long id;

	@Column(name = "produit_nom", length = 50, nullable = false)
	@JsonView(Views.Common.class)
	private String nom;

	@Column(name = "produit_stock", nullable = false)
	@JsonView(Views.Common.class)
	@NonNull
	@Min(value = 0)
	private double stock;

	@Column(name = "produit_prix", nullable = false)
	@JsonView(Views.Common.class)
	@NonNull
	@Min(value = 0)
	private double prix;
	@JsonView(Views.Common.class)
	@ManyToOne
	@JoinColumn(name = "produit_plante", foreignKey = @ForeignKey(name = "produit_plante_fk"))
	private Plante plante;
	
	@ManyToOne
	@JoinColumn(name = "produit_utilisateur_id", foreignKey = @ForeignKey(name = "produit_utilisateur_fk"))
	@JsonView(Views.Common.class)
	private Utilisateur utilisateur;

	public Produit() {

	}

	public Produit(String nom, double stock, double prix, Plante plante, Utilisateur utilisateur) {
		super();
		this.nom = nom;
		this.stock = stock;
		this.prix = prix;
		this.plante = plante;
		this.utilisateur = utilisateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}
	
	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", stock=" + stock + ", prix=" + prix + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}
}
