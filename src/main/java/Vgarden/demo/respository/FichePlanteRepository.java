package Vgarden.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Vgarden.demo.model.FichePlante;


public interface FichePlanteRepository extends JpaRepository<FichePlante, Long> {
	
	Optional<FichePlante> findByNom(String nom);
}
