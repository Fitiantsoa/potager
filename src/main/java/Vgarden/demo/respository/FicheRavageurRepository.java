package Vgarden.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Vgarden.demo.model.FicheRavageur;


public interface FicheRavageurRepository extends JpaRepository<FicheRavageur, Long> {
	
	Optional<FicheRavageur> findByNom(String nom);
}
