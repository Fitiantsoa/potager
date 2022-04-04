package Vgarden.demo.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "plante")
@SequenceGenerator(name = "seqPlantes", sequenceName = "seq_plantes", initialValue = 20, allocationSize = 1)
public class Plante {

	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPlantes")
	@Column(name = "planteId")
	private Long Id;

	@JsonView(Views.PlantesWithTerrain.class)
	@ManyToOne
	@JoinColumn(name = "planteTerrain", foreignKey = @ForeignKey(name = "plante_terrain_fk"))
	private Terrain terrain;

	@Embedded
	@JsonView(Views.Common.class)
	private Emplacement emplacementPlante;

	@Column(name = "planteType")
	@JsonView(Views.Common.class)
	private String typePlante;

	@Column(name = "planteCroissance")
	@JsonView(Views.Common.class)
	private int croissance;


	//Entre 1 et 3 ?  - Determinera l'image de la plante (ou une barre de croissance).
	//@Enumerated(EnumType.STRING)
	//@Column(name = "planteSolFavori")
	//private TypeDeSol solFavori; // A afficher sur la fiche de la plante.
	//@Column(name = "planteBesoinFixation")
	//private boolean besoinFixation; // Plantes montantes (tomates etc.)

	//@Column(name = "planteBesoinSemi")
	//private boolean besoinSemi; //
	//@Column(name = "planteDateRepiquage")
	//private LocalDate dateRepiquage; // Si besoin semi - A afficher sur l'appli � titre informatif dans la fiche de la plante.

	@JsonView(Views.Common.class)
	@Column(name = "planteDatePlantation")
	private LocalDate datePlantation; // A afficher dans la fiche de la plante

	@JsonView(Views.Common.class)
	@Column(name = "planteArrosageOk")
	private boolean arrosageOk; // Pour la notif d'arrosage.

	@JsonView(Views.Common.class)
	@Column(name = "planteDateRecolte")
	private LocalDate dateRecolte; //
	//@Column(name = "plante_DatePlantationOptimale")
	//private LocalDate datePlantationOptimale; // Pour conseiller l'utilisateur sur la date de plantation.
	//@Column(name = "plante_DateSemiOptimale")
	//private LocalDate dateSemiOptimale; // Pour conseiller l'utilisateur sur la date de mise en semi.

	public Plante() {

	}
	
	public Plante(Terrain terrain, Emplacement emplacementPlante, String typePlante, int croissance,
			LocalDate datePlantation, boolean arrosageOk, LocalDate dateRecolte) {
		super();
		this.terrain = terrain;
		this.emplacementPlante = emplacementPlante;
		this.typePlante = typePlante;
		this.croissance = croissance;
		this.datePlantation = datePlantation;
		this.arrosageOk = arrosageOk;
		this.dateRecolte = dateRecolte;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public Emplacement getEmplacementPlante() {
		return emplacementPlante;
	}
	public void setEmplacementPlante(Emplacement emplacementPlante) {
		this.emplacementPlante = emplacementPlante;
	}
	public String getTypePlante() {
		return typePlante;
	}
	public void setTypePlante(String typePlante) {
		this.typePlante = typePlante;
	}
	public int getCroissance() {
		return croissance;
	}
	public void setCroissance(int croissance) {
		this.croissance = croissance;
	}
	public LocalDate getDatePlantation() {
		return datePlantation;
	}
	public void setDatePlantation(LocalDate datePlantation) {
		this.datePlantation = datePlantation;
	}
	public boolean isArrosageOk() {
		return arrosageOk;
	}
	public void setArrosageOk(boolean arrosageOk) {
		this.arrosageOk = arrosageOk;
	}
	public LocalDate getDateRecolte() {
		return dateRecolte;
	}
	public void setDateRecolte(LocalDate dateRecolte) {
		this.dateRecolte = dateRecolte;
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plante other = (Plante) obj;
		return Id == other.Id;
	}




}
