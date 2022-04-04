package Vgarden.demo.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 50, allocationSize = 1)
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "commande_id")
	@JsonView(Views.Common.class)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "commande_utilisateur_id", foreignKey = @ForeignKey(name = "commande_utilisateur_id_fk"))
	@JsonView(Views.CommandeWithUtilisateur.class)
	private Utilisateur utilisateur;

	@Column(name = "commande_date_creation", nullable = false)
	@JsonView(Views.Common.class)
	private LocalDateTime dateCreation;

	@Enumerated(EnumType.STRING)
	@Column(name = "commande_statut", length = 10)
	@JsonView(Views.Common.class)
	private CommandeStatut statut;

	@OneToMany(mappedBy = "id.commande", cascade = CascadeType.REMOVE)
	@JsonView(Views.CommandeWithCommandeProduits.class)
	private List<CommandeProduit> commandeProduits = new ArrayList<>();

	@Version
	private int version;

	/**
	 * Constructeur vide par défaut.
	 */
	public Commande() {
		this.dateCreation = LocalDateTime.now();
		this.statut = CommandeStatut.EN_ATTENTE;
	}

	/**
	 * Constructeur de la commande.
	 * @param utilisateur - L'utilisateur qui a passé la commande.
	 */
	public Commande(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
		this.dateCreation = LocalDateTime.now();
		this.statut = CommandeStatut.EN_ATTENTE;
	}

	public Commande(Utilisateur utilisateur, List<CommandeProduit> commandeProduits) {
		this.utilisateur = utilisateur;
		this.commandeProduits = commandeProduits;
		this.dateCreation = LocalDateTime.now();
		this.statut = CommandeStatut.EN_ATTENTE;
	}

	/**
	 * L'Id de la commande.
	 * @return Id de la commande.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Recupère l'utilisateur qui a passé la commande.
	 * @return - l'utilisateur qui a passé la commande.
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * La date de la création de la commande.
	 * @return - Date de création de la commande
	 */
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public CommandeStatut getStatut() {
		return statut;
	}

	public void setStatut(CommandeStatut statut) {
		this.statut = statut;
	}

	/**
	 * Récupère les produits associés à la commande.
	 * @return Produits associés à la commande.
	 */
	public List<CommandeProduit> getCommandeProduits() {
		return commandeProduits;
	}

	public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
		this.commandeProduits = commandeProduits;
	}

	/**
	 * Recupère le prix total de la commande
	 * par rapport au prix et à la quantité de chaque produit
	 * associé à la commande.
	 * @return Le prix total de la commande.
	 */
	@JsonView(Views.Common.class)
	public double prixTotal() {
		return commandeProduits
				.stream()
				.mapToDouble(commandeProduit -> commandeProduit.getId().getProduit().getPrix() * commandeProduit.getQuantite())
				.sum();
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Commande commande = (Commande) o;
		return id.equals(commande.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

