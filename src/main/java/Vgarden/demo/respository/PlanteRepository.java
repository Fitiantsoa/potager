package Vgarden.demo.respository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import Vgarden.demo.model.Plante;
import Vgarden.demo.model.Terrain;

public interface PlanteRepository extends JpaRepository<Plante, Long> {

	List<Plante> findByTerrain(@Param("terrain") Terrain terrain);

	}
