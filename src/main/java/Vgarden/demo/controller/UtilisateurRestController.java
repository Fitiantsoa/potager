package Vgarden.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.UtilisateurException;
import Vgarden.demo.model.Compte;
import Vgarden.demo.model.Utilisateur;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.CompteServices;
import Vgarden.demo.service.UtilisateurServices;



@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "*")
public class UtilisateurRestController {
	@Autowired
	private UtilisateurServices utilisateurServices;
	@Autowired
	private CompteServices compteServices;

	@GetMapping("/info")
	@JsonView(Views.Common.class)
	public Utilisateur getUtilisateur(@AuthenticationPrincipal Compte c) {		
		return utilisateurServices.getByCompte(c);
	}
	
	
//	@GetMapping("/{id}/terrain")
//	@JsonView(Views.UtilisateurWithTerrains.class)
//	public Utilisateur getByIdWithTerrain(@PathVariable Long id) {
//		return utilisateurServices.getByIdWithTerrains(id);
//	}
	
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Utilisateur create(@AuthenticationPrincipal Compte c,@Valid @RequestBody Utilisateur u, BindingResult br) {
		if (br.hasErrors()) {
			throw new UtilisateurException("Données incorrectes");
		}
		u.setCompte(c);
		u.setPseudo(c.getLogin());
		return utilisateurServices.create(u);
	}
	

	@PutMapping("")
	@CrossOrigin
	@JsonView(Views.Common.class)
	public Utilisateur modifier(@AuthenticationPrincipal Compte c,@Valid @RequestBody Utilisateur u, BindingResult br) {
		if (br.hasErrors()) {
			throw new UtilisateurException("Données incorrectes");
		}
		u.setPseudo(c.getLogin());
		return utilisateurServices.update(c, u);
	}

	@PutMapping("/upgrade")
	public Utilisateur upgrade(@AuthenticationPrincipal Compte c) {
//		if (br.hasErrors()) {
//			throw new UtilisateurException("Données incorrectes");
//		}
		return utilisateurServices.upgrade(c);
	}
}
