package Vgarden.demo.controller;


import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.CompteException;
import Vgarden.demo.model.Compte;
import Vgarden.demo.model.Role;
import Vgarden.demo.model.Views;
import Vgarden.demo.respository.CompteRepository;
import Vgarden.demo.service.CompteServices;
import Vgarden.demo.service.UtilisateurServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class CompteRestController {

	private final CompteServices compteServices;
	private final CompteRepository compteRepo;
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurServices utilisateurServices;

	public CompteRestController(CompteServices compteServices, CompteRepository compteRepo, PasswordEncoder passwordEncoder) {
		this.compteServices = compteServices;
		this.compteRepo = compteRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@JsonView(Views.Common.class)
	@GetMapping("")
	public Compte auth(@AuthenticationPrincipal Compte c ) {
		return c;
	}

	/* REST EXEMPLE POUR CREATION COMPTE AVEC UTILISATEUR
	{
    	"login": "test3",
    	"password": "test3",
    	"utilisateur": {
        	"typeCompte": "Particulier"
        	// le reste des attributs nécessaires
    	}
	}
	 */

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Compte inscription(@RequestBody Compte c, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException("Données incorrectes");
		}
		if (compteRepo.findBylogin(c.getLogin()).isPresent()) {
			throw new CompteException("Utilisateur existant");
		}
		c.setRole(Role.ROLE_USER);
		Compte compte = compteServices.save(c);
		utilisateurServices.getByCompte(compte);
		return compte;
	}


//	@PutMapping("/modifier/{username}")
//	@JsonView(Views.Common.class)
//	public Compte modifierPassword(@AuthenticationPrincipal Compte c, @RequestParam String username) {
//		return compteServices.updatePassword(c, username);
//	}

	// Test
	@PutMapping("")
    @JsonView(Views.Common.class)
    public Compte update(@AuthenticationPrincipal Compte c) {
		return compteServices.save(c);
	}

}
