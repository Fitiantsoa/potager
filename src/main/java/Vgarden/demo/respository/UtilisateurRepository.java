package Vgarden.demo.respository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Vgarden.demo.model.Compte;
import Vgarden.demo.model.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByCompte(Compte c);
	
	@Query("SELECT c from Utilisateur c left join fetch c.terrains where c.id=:id")
	Optional<Utilisateur> findByIdWithTerrains(@Param("id") Long id);
}
