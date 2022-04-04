package Vgarden.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import Vgarden.demo.model.Produit;
import Vgarden.demo.model.Utilisateur;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long>  {
	List<Produit> findByUtilisateur(Utilisateur utilisateur);
}
