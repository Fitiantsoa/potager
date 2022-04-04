package Vgarden.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Vgarden.demo.exceptions.UtilisateurException;
import Vgarden.demo.model.Compte;
import Vgarden.demo.model.TypeCompte;
import Vgarden.demo.model.Utilisateur;
import Vgarden.demo.respository.UtilisateurRepository;


@Service
public class UtilisateurServices {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private CompteServices compteServices;

	public Utilisateur getByCompte(Compte c) {
		try {
			return utilisateurRepository.findByCompte(c).orElseThrow(() ->
			new UtilisateurException("Aucun utilisateur associé"));
		}
		catch(UtilisateurException e) {
			Utilisateur newUser = new Utilisateur();
			newUser.setCompte(c);
			newUser.setPseudo(c.getLogin());
			return create(newUser);
		}

	}
	public Utilisateur getByIdWithTerrains(Long id) {
		return utilisateurRepository.findByIdWithTerrains(id).orElseThrow(() -> {
		throw new UtilisateurException("Compte inexistant par find by ID");
	});}
	

	public Utilisateur create(Utilisateur u) {
		u.setTypeCompte(TypeCompte.Particulier);
		return utilisateurRepository.save(u);
	}

	public Utilisateur update(Compte c, Utilisateur u) {
		Utilisateur utilisateurBase = utilisateurRepository.findByCompte(c).orElseThrow(() ->
				new UtilisateurException("Erreur compte"));
		utilisateurBase.setAdresse(u.getAdresse());
		utilisateurBase.setCivilite(u.getCivilite());
		return utilisateurRepository.save(utilisateurBase);
	}

	public Utilisateur upgrade(Compte c) {
		Utilisateur utilisateurBase = utilisateurRepository.findByCompte(c).orElseThrow(() ->
				new UtilisateurException("Erreur compte"));
		utilisateurBase.setTaxe(5);
		utilisateurBase.setTypeCompte(TypeCompte.Pro);
		return utilisateurRepository.save(utilisateurBase);
	}


	public void delete(Utilisateur u) {
		Long id = u.getCompte().getId();
		Compte compteEnBase = compteServices.getById(id);
		compteEnBase.setUtilisateur(null);
		compteServices.save(compteEnBase);
		utilisateurRepository.delete(u);
	}

	public void deleteAfterCompte(Utilisateur u) {
		utilisateurRepository.delete(u);
	}

}
