package Vgarden.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import Vgarden.demo.respository.CommandeProduitRepository;
import Vgarden.demo.respository.CommandeRepository;
import Vgarden.demo.respository.CompteRepository;
import Vgarden.demo.respository.PlanteRepository;
import Vgarden.demo.respository.ProduitRepository;
import Vgarden.demo.respository.TerrainRepository;



import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommandeRepositoryTest {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeProduitRepository commandeProduitRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private PlanteRepository planteRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TerrainRepository terrainRepository;

    @Test
    @Transactional
    void findByIdAndFetchCommandeProduits() {
//        Utilisateur particulier = new Utilisateur();
//        particulier.setLogin("test1");
//        particulier.setPassword("test1");
//        particulier.setTypeCompte(TypeCompte.Particulier);
//
//        Utilisateur pro = new Utilisateur();
//        pro.setLogin("pro");
//        pro.setPassword("pro");
//        pro.setTypeCompte(TypeCompte.Pro);
//
//        compteRepository.save(particulier);
//        compteRepository.save(pro);
//
//        Terrain terrain = new Terrain();
//        terrain.setUtilisateur(pro);
//
//        terrainRepository.save(terrain);
//
//        Plante plante = new Plante();
//        plante.setTypePlante(TypePlante.Ail);
//        plante.setDatePlantation(LocalDate.now());
//        plante.setEmplacementPlante(new Emplacement(1, 2));
//        plante.setTerrain(terrain);
//
//        planteRepository.save(plante);
//
//        Produit produit = new Produit("test", 14, 12.50, plante);
//
//        produitRepository.save(produit);
//
//        Commande commande = new Commande(particulier);
//
//        List<CommandeProduit> commandeProduits = new ArrayList<>();
//        commandeProduits.add(new CommandeProduit(commande, produit, 1));
//
//        commande.setCommandeProduits(commandeProduits);
//
//        Commande savedCommande = commandeRepository.save(commande);
//
//        Commande fetchedCommande = commandeRepository.findByIdWithCommandeProduits(savedCommande.getId()).orElse(null);
//
//        assertNotNull(fetchedCommande);
//        assertNotNull(fetchedCommande.getCommandeProduits());
    }
}