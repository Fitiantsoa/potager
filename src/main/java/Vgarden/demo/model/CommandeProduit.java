package Vgarden.demo.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "commande_produit")
public class CommandeProduit {

	@EmbeddedId
	@JsonView(Views.Common.class)
	private CommandeProduitKey id;

	@Min(1)
	@Column(name = "commande_produit_quantite", nullable = false)
	@JsonView(Views.Common.class)
	private Integer quantite;

	public CommandeProduit() {

	}

	/**
	 * Constructeur de Commande Produit
	 * @param commande - La commande associée au produit
	 * @param produit - Le produit associé à la commande
	 * @param quantite - La quantité du produit
	 */
	public CommandeProduit(Commande commande, Produit produit, Integer quantite) {
		this.id = new CommandeProduitKey(commande, produit);
		this.quantite = quantite;
	}

	public CommandeProduitKey getId() {
		return id;
	}

	public void setId(CommandeProduitKey id) {
		this.id = id;
	}

	/**
	 * La quantité du produit
	 * @return - Quantité du produit
	 */
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	/**
	 * Recupère le prix total du produit
	 * par rapport au prix et à la quantité du produit
	 * associé à la commande.
	 * @return Le prix total du produit.
	 */
	@JsonView(Views.Common.class)
	public double prixTotal() {
		return this.id.getProduit().getPrix() * this.quantite;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommandeProduit that = (CommandeProduit) o;
		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
