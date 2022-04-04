package Vgarden.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Vgarden.demo.model.FicheMaladie;

public interface FicheMaladieRepository extends JpaRepository<FicheMaladie, Long> {
	
	Optional<FicheMaladie> findByNom(String nom);
}

