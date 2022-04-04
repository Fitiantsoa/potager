package Vgarden.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "fiches_plante")
@SequenceGenerator(name = "seqFichePlante", sequenceName = "seq_fiche_plante", initialValue = 100, allocationSize = 1)
public class FichePlante {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFichePlante")
	@JsonView(Views.Common.class)
	@Column(name = "id")
	private Long id;

	@JsonView(Views.Common.class)
	@Column(name = "nom", length = 50, nullable = true)
	private String nom;

	@JsonView(Views.Common.class)
	@Column(name = "eau", nullable = true)
	private String eau;

	@JsonView(Views.Common.class)
	@Column(name = "soleil", nullable = true)
	private String exposition;

	@JsonView(Views.Common.class)
	@Column(name = "espacement", nullable = true)
	private String espacement;
	
	@JsonView(Views.Common.class)
	@Column(name = "graine", nullable = true)
	private String dureeConservationGraine;

	@JsonView(Views.Common.class)
	@Column(name = "calendrier_semer", nullable = true)
	private String calendrierSemer;
	
	@JsonView(Views.Common.class)
	@Column(name = "calendrier_planter", nullable = true)
	private String calendrierPlanter;
	
	@JsonView(Views.Common.class)
	@Column(name = "calendrier_recolter", nullable = true)
	private String calendrierRecolter;
	
	@JsonView(Views.Common.class)
	@Column(name = "bons_copains", nullable = true)
	private String bonsCopains;
	
	@JsonView(Views.Common.class)
	@Column(name = "mauvais_copains", nullable = true)
	private String mauvaisCopains;
	
	@JsonView(Views.Common.class)
	@Column(name = "maladies", nullable = true)
	private String maladies;
	
	@JsonView(Views.Common.class)
	@Column(name = "ravageurs", nullable = true)
	private String ravageurs;
	
//	@Enumerated(EnumType.STRING)
//	@ElementCollection(targetClass = Month.class, fetch = FetchType.EAGER)
//	@CollectionTable(name = "calendrier_semer")
//	private Set<Month> calendrierSemer;
//
//	@Enumerated(EnumType.STRING)
//	@ElementCollection(targetClass = Month.class, fetch = FetchType.EAGER)
//	@CollectionTable(name = "calendrier_planter")
//	private Set<Month> calendrierPlanter;
//
//	@Enumerated(EnumType.STRING)
//	@ElementCollection(targetClass = Month.class, fetch = FetchType.EAGER)
//	@CollectionTable(name = "calendrier_recolter")
//	private Set<Month> calendrierRecolter;
//
//	@OneToMany(mappedBy = "bonsCopains")
//	private List<FichePlante> bonsCopains;
//
//	@OneToMany(mappedBy = "mauvaisCopains")
//	private List<FichePlante> mauvaisCopains;
//
//	@ManyToMany(mappedBy = "plantes")
//	private List<FicheMaladie> maladiesPlante;
//
//	@ManyToMany(mappedBy = "plantes")
//	private List<FicheRavageur> ravageursPlante;
	
	@JsonView(Views.Common.class)
	@Column(name = "methode_semer", nullable = true)
	private String methodeSemer;

	@JsonView(Views.Common.class)
	@Column(name = "methode_planter", nullable = true)
	private String methodePlanter;

	@JsonView(Views.Common.class)
	@Column(name = "methode_entretien", nullable = true)
	private String methodeEntretien;

	@JsonView(Views.Common.class)
	@Column(name = "methode_recolte", nullable = true)
	private String methodeRecolte;

	public FichePlante() {

	}

	
	public FichePlante(String nom, String eau, String exposition, String espacement, String dureeConservationGraine,
			String calendrierSemer, String calendrierPlanter, String calendrierRecolter, String bonsCopains,
			String mauvaisCopains, String maladies, String ravageurs, String methodeSemer, String methodePlanter,
			String methodeEntretien, String methodeRecolte) {
		super();
		this.nom = nom;
		this.eau = eau;
		this.exposition = exposition;
		this.espacement = espacement;
		this.dureeConservationGraine = dureeConservationGraine;
		this.calendrierSemer = calendrierSemer;
		this.calendrierPlanter = calendrierPlanter;
		this.calendrierRecolter = calendrierRecolter;
		this.bonsCopains = bonsCopains;
		this.mauvaisCopains = mauvaisCopains;
		this.maladies = maladies;
		this.ravageurs = ravageurs;
		this.methodeSemer = methodeSemer;
		this.methodePlanter = methodePlanter;
		this.methodeEntretien = methodeEntretien;
		this.methodeRecolte = methodeRecolte;
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


	public String getEau() {
		return eau;
	}


	public void setEau(String eau) {
		this.eau = eau;
	}


	public String getExposition() {
		return exposition;
	}


	public void setExposition(String exposition) {
		this.exposition = exposition;
	}


	public String getEspacement() {
		return espacement;
	}


	public void setEspacement(String espacement) {
		this.espacement = espacement;
	}


	public String getDureeConservationGraine() {
		return dureeConservationGraine;
	}


	public void setDureeConservationGraine(String dureeConservationGraine) {
		this.dureeConservationGraine = dureeConservationGraine;
	}


	public String getCalendrierSemer() {
		return calendrierSemer;
	}


	public void setCalendrierSemer(String calendrierSemer) {
		this.calendrierSemer = calendrierSemer;
	}


	public String getCalendrierPlanter() {
		return calendrierPlanter;
	}


	public void setCalendrierPlanter(String calendrierPlanter) {
		this.calendrierPlanter = calendrierPlanter;
	}


	public String getCalendrierRecolter() {
		return calendrierRecolter;
	}


	public void setCalendrierRecolter(String calendrierRecolter) {
		this.calendrierRecolter = calendrierRecolter;
	}


	public String getBonsCopains() {
		return bonsCopains;
	}


	public void setBonsCopains(String bonsCopains) {
		this.bonsCopains = bonsCopains;
	}


	public String getMauvaisCopains() {
		return mauvaisCopains;
	}


	public void setMauvaisCopains(String mauvaisCopains) {
		this.mauvaisCopains = mauvaisCopains;
	}


	public String getMaladies() {
		return maladies;
	}


	public void setMaladies(String maladies) {
		this.maladies = maladies;
	}


	public String getRavageurs() {
		return ravageurs;
	}


	public void setRavageurs(String ravageurs) {
		this.ravageurs = ravageurs;
	}


	public String getMethodeSemer() {
		return methodeSemer;
	}


	public void setMethodeSemer(String methodeSemer) {
		this.methodeSemer = methodeSemer;
	}


	public String getMethodePlanter() {
		return methodePlanter;
	}


	public void setMethodePlanter(String methodePlanter) {
		this.methodePlanter = methodePlanter;
	}


	public String getMethodeEntretien() {
		return methodeEntretien;
	}


	public void setMethodeEntretien(String methodeEntretien) {
		this.methodeEntretien = methodeEntretien;
	}


	public String getMethodeRecolte() {
		return methodeRecolte;
	}


	public void setMethodeRecolte(String methodeRecolte) {
		this.methodeRecolte = methodeRecolte;
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
		FichePlante other = (FichePlante) obj;
		return Objects.equals(id, other.id);
	}


}
