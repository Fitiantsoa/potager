package Vgarden.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Vgarden.demo.exceptions.FichePlanteException;
import Vgarden.demo.model.FichePlante;
import Vgarden.demo.respository.FichePlanteRepository;

import javax.validation.Validator;
import java.util.List;

@Service
public class FichePlanteService {
	@Autowired
	private FichePlanteRepository fichePlanteRepo;
	@Autowired
	private Validator validator;

	public List<FichePlante> getAll() {
		return fichePlanteRepo.findAll(Sort.by(Sort.Order.asc("id")));
	}

	public FichePlante getById(Long id) {
		return fichePlanteRepo.findById(id).orElseThrow(FichePlanteException::new);
	}
	
	public FichePlante getByNom(String nom) {
		FichePlante fichePlante = fichePlanteRepo.findByNom(nom).orElseThrow(FichePlanteException::new);
		return fichePlante;
	}

	public void delete(FichePlante fichePlante) {
		fichePlanteRepo.delete(fichePlante);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public FichePlante save(FichePlante fichePlante) {
		check(fichePlante);
		if (fichePlante.getId() == null) {
			return fichePlanteRepo.save(fichePlante);
		} else {
			FichePlante fichePlanteEnBase = getById(fichePlante.getId());
			fichePlanteEnBase.setNom(fichePlante.getNom());
			fichePlanteEnBase.setEau(fichePlante.getEau());
			fichePlanteEnBase.setExposition(fichePlante.getExposition());
			fichePlanteEnBase.setEspacement(fichePlante.getEspacement());
			fichePlanteEnBase.setDureeConservationGraine(fichePlante.getDureeConservationGraine());
			fichePlanteEnBase.setCalendrierSemer(fichePlante.getCalendrierSemer());
			fichePlanteEnBase.setCalendrierPlanter(fichePlante.getCalendrierPlanter());
			fichePlanteEnBase.setCalendrierRecolter(fichePlante.getCalendrierRecolter());
			fichePlanteEnBase.setBonsCopains(fichePlante.getBonsCopains());
			fichePlanteEnBase.setMauvaisCopains(fichePlante.getMauvaisCopains());
			fichePlanteEnBase.setMaladies(fichePlante.getMaladies());
			fichePlanteEnBase.setRavageurs(fichePlante.getRavageurs());
			fichePlanteEnBase.setMethodeSemer(fichePlante.getMethodeSemer());
			fichePlanteEnBase.setMethodePlanter(fichePlante.getMethodePlanter());
			fichePlanteEnBase.setMethodeEntretien(fichePlante.getMethodeEntretien());
			fichePlanteEnBase.setMethodeRecolte(fichePlante.getMethodeRecolte());
			return fichePlanteRepo.save(fichePlanteEnBase);
		}
	}

	private void check(FichePlante fichePlante) {
		if (!validator.validate(fichePlante).isEmpty()) {
			throw new FichePlanteException();
		}
	}

	public boolean exist(Long id) {
		return fichePlanteRepo.existsById(id);
	}
}
