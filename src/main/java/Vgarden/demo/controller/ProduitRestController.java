package Vgarden.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.ProduitException;
import Vgarden.demo.model.Compte;
import Vgarden.demo.model.Produit;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.ProduitService;


@RestController
@RequestMapping("/produit")
@CrossOrigin(origins = "*")
public class ProduitRestController {
	@Autowired
	private ProduitService produitService;
	
	@GetMapping("/user")
	@JsonView(Views.Common.class)
	public List<Produit> getByUtilisateur(@AuthenticationPrincipal Compte c) {
		return produitService.getByUtilisateur(c);
	}
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Produit> getAll(@AuthenticationPrincipal Compte c){
		List<Produit> produits = produitService.getAll();
		List<Produit> produitUtilisateur = produitService.getByUtilisateur(c);
		for (Produit p : produitUtilisateur) {
			produits.remove(p);
		}		
		System.out.println(produits);
		return produits;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Produit getById(@PathVariable Long id){
		return produitService.getById(id);
	}
	
	
	
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Produit create(@AuthenticationPrincipal Compte c,@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitException("Données incorrectes");
		}
		return produitService.save(c, produit);
	}
	
	@PutMapping("")
	@CrossOrigin
	@JsonView(Views.Common.class)
	public Produit update(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitException("Données incorrectes");
		}
		return produitService.update(produit);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produitService.delete(id);
	}
}
