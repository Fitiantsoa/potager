package Vgarden.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.CommandeException;
import Vgarden.demo.model.Commande;
import Vgarden.demo.model.Compte;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.CommandeService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeRestController {

    private final CommandeService commandeService;

    public CommandeRestController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/achat")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public List<Commande> getAllAchat(@AuthenticationPrincipal Compte c) {
        if(c.getUtilisateur() == null) {
            throw new CommandeException();
        }

        return commandeService.getByUtilisateurAchatWithCommandeProduits(c.getUtilisateur());
    }

    @GetMapping("/vente")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public List<Commande> getAllVente(@AuthenticationPrincipal Compte c) {
        if(c.getUtilisateur() == null) {
            throw new CommandeException();
        }

        return commandeService.getByUtilisateurVenteWithCommandeProduits(c.getUtilisateur());
    }

    @GetMapping("/id/{commandeId}")
    @JsonView(Views.CommandeWithCommandeProduits.class)
    public Commande getById(@PathVariable Long commandeId) {
        return commandeService.getByIdWithCommandeProduits(commandeId);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Commande create(@AuthenticationPrincipal Compte c, @Valid @RequestBody Commande commande, BindingResult result) {
        if(result.hasErrors() || c.getUtilisateur() == null) {
            throw new CommandeException();
        }

        commande.setUtilisateur(c.getUtilisateur());

        return commandeService.createOrUpdate(commande);
    }

    @PutMapping("/{id}")
    @JsonView(Views.Common.class)
    public Commande update(@Valid @RequestBody Commande commande, BindingResult br, @PathVariable Long id) {
        if (br.hasErrors()) {
            throw new CommandeException();
        }
        if (!commandeService.exist(id)) {
            throw new CommandeException();
        }
        return commandeService.createOrUpdate(commande);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        commandeService.deleteById(id);
    }
}
