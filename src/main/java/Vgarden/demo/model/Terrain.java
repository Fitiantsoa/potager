package Vgarden.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "terrain")
@SequenceGenerator(name = "seqTerrain", sequenceName = "seq_terrain", initialValue = 1, allocationSize = 1)
public class Terrain {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTerrain")
	@JsonView(Views.Common.class)
	private Long id;

	@Column(name = "surface")
	@JsonView(Views.Common.class)
	private double surface;

	@Column(name = "localisation", length = 50, nullable = true)
	@JsonView(Views.Common.class)
	private String localisation;

	@Column(name = "dureeExpoSoleil")
	@JsonView(Views.Common.class)
	private double dureeExpoSoleil;

	@Column(name = "decoupageTerrainLongeur")
	@JsonView(Views.Common.class)
	private double decoupageTerrainLongeur;

	@Column(name = "decoupageTerrainLargeur")
	@JsonView(Views.Common.class)
	private double decoupageTerrainLargeur;

	@Enumerated(EnumType.STRING)
	@JsonView(Views.Common.class)
	@Column(name = "typeDeSol", length = 20)
	private TypeDeSol typeDeSol;

	@ManyToOne
	@JoinColumn(name = "proprietaire", foreignKey = @ForeignKey(name = "utilisateur_terrain_fk"))
	@JsonView(Views.TerrainWithUtilisateur.class)
	private Utilisateur utilisateur;

	@JsonView(Views.TerrainWithPlantes.class)
	@OneToMany(mappedBy = "terrain")
	private List<Plante> plantes;


	public Terrain() {

	}

	public Terrain(double surface, String localisation, double dureeExpoSoleil, double decoupageTerrainLongeur,
			double decoupageTerrainLargeur, TypeDeSol typeDeSol, Utilisateur utilisateur, List<Plante> plantes) {
		super();
		this.surface = surface;
		this.localisation = localisation;
		this.dureeExpoSoleil = dureeExpoSoleil;
		this.decoupageTerrainLongeur = decoupageTerrainLongeur;
		this.decoupageTerrainLargeur = decoupageTerrainLargeur;
		this.typeDeSol = typeDeSol;
		this.utilisateur = utilisateur;
		this.plantes = plantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public double getDureeExpoSoleil() {
		return dureeExpoSoleil;
	}

	public void setDureeExpoSoleil(double dureeExpoSoleil) {
		this.dureeExpoSoleil = dureeExpoSoleil;
	}

	public double getDecoupageTerrainLongeur() {
		return decoupageTerrainLongeur;
	}

	public void setDecoupageTerrainLongeur(double decoupageTerrainLongeur) {
		this.decoupageTerrainLongeur = decoupageTerrainLongeur;
	}

	public double getDecoupageTerrainLargeur() {
		return decoupageTerrainLargeur;
	}

	public void setDecoupageTerrainLargeur(double decoupageTerrainLargeur) {
		this.decoupageTerrainLargeur = decoupageTerrainLargeur;
	}

	public TypeDeSol getTypeDeSol() {
		return typeDeSol;
	}

	public void setTypeDeSol(TypeDeSol typeDeSol) {
		this.typeDeSol = typeDeSol;
	}

	public List<Plante> getPlantes() {
		return plantes;
	}

	public void setPlantes(List<Plante> plantes) {
		this.plantes = plantes;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
		Terrain other = (Terrain) obj;
		return Objects.equals(id, other.id);
	}




}
