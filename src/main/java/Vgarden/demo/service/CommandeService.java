package Vgarden.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import Vgarden.demo.exceptions.CommandeException;
import Vgarden.demo.model.Commande;
import Vgarden.demo.model.Utilisateur;
import Vgarden.demo.respository.CommandeProduitRepository;
import Vgarden.demo.respository.CommandeRepository;

import javax.validation.Validator;
import java.util.List;

@Service
public class CommandeService {

    private static final Logger logger = LoggerFactory.getLogger(CommandeService.class);

    private final Validator validator;
    private final CommandeRepository commandeRepository;
    private final CommandeProduitRepository commandeProduitRepository;

    public CommandeService(Validator validator, CommandeRepository commandeRepository, CommandeProduitRepository commandeProduitRepository) {
        this.validator = validator;
        this.commandeRepository = commandeRepository;
        this.commandeProduitRepository = commandeProduitRepository;
    }

    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    public Commande getById(Long id) {
        return commandeRepository.findById(id).orElseThrow(() -> {
            throw new CommandeException("Commande inexistante");
        });
    }

    public Commande getByIdWithCommandeProduits(Long id) {
        return commandeRepository.findByIdWithCommandeProduits(id).orElseThrow(() -> {
            throw new CommandeException("Commande inexistante");
        });
    }

    public List<Commande> getByUtilisateurAchatWithCommandeProduits(Utilisateur utilisateur) {
        return commandeRepository.findByUtilisateurAchatWithCommandeProduits(utilisateur);
    }

    public List<Commande> getByUtilisateurVenteWithCommandeProduits(Utilisateur utilisateur) {
        return commandeRepository.findByUtilisateurVenteWithCommandeProduits(utilisateur);
    }

    public Commande createOrUpdate(Commande commande) {
        if (commande == null) {
            throw new CommandeException();
        }

        checkData(commande);

        if (commande.getId() == null) {
            Commande newCommande = commandeRepository.save(commande);

            if(!commande.getCommandeProduits().isEmpty()) {
                commande.getCommandeProduits().forEach(commandeProduit -> commandeProduit.getId().setCommande(newCommande));
                commandeProduitRepository.saveAll(commande.getCommandeProduits());
            }

            logger.debug("Created new commande [{}] for user [{}]", newCommande.getId(), newCommande.getUtilisateur().getId());

            return newCommande;
        } else {
            logger.debug("Updated commande {}", commande.getId());

            Commande databaseCommande = getById(commande.getId());
            databaseCommande.setCommandeProduits(commande.getCommandeProduits());
            return commandeRepository.save(databaseCommande);
        }
    }

    private void checkData(Commande commande) {
        if(!validator.validate(commande).isEmpty()) {
            throw new CommandeException();
        }
    }

    public boolean exist(Long id) {
        return commandeRepository.existsById(id);
    }

    public void delete(Commande commande) {
        if (commande == null || commande.getId() == null) {
            throw new CommandeException();
        }

        commandeRepository.delete(commande);
    }

    public void deleteById(Long id) {
        delete(getById(id));
    }
}
