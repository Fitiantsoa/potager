package Vgarden.demo.service;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Vgarden.demo.exceptions.FicheRavageurException;
import Vgarden.demo.model.FicheRavageur;
import Vgarden.demo.respository.FicheRavageurRepository;



@Service
public class FicheRavageurService {
	@Autowired
	private FicheRavageurRepository ravageurRepo;
	@Autowired
	private Validator validator;

	public List<FicheRavageur> getAll() {
		return ravageurRepo.findAll(Sort.by(Sort.Order.asc("id")));
	}

	public FicheRavageur getById(Long id) {
		return ravageurRepo.findById(id).orElseThrow(FicheRavageurException::new);
	}

	public void delete(FicheRavageur ficheRavageur) {
		ravageurRepo.delete(ficheRavageur);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public FicheRavageur save(FicheRavageur ficheRavageur) {
		check(ficheRavageur);
		if (ficheRavageur.getId() == null) {
			return ravageurRepo.save(ficheRavageur);
		} else {
			FicheRavageur ficheRavageurEnBase = getById(ficheRavageur.getId());
			ficheRavageurEnBase.setNom(ficheRavageur.getNom());
			ficheRavageurEnBase.setDescription(ficheRavageur.getDescription());
			ficheRavageurEnBase.setSolution(ficheRavageur.getSolution());
			return ravageurRepo.save(ficheRavageurEnBase);
		}
	}

	private void check(FicheRavageur ficheRavageur) {
		if (!validator.validate(ficheRavageur).isEmpty()) {
			throw new FicheRavageurException();
		}
	}

	public boolean exist(Long id) {
		return ravageurRepo.existsById(id);
	}
}
