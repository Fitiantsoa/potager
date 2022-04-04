package Vgarden.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import Vgarden.demo.model.Emplacement;
import Vgarden.demo.model.Plante;
import Vgarden.demo.model.Terrain;
import Vgarden.demo.model.TypeCompte;
import Vgarden.demo.model.TypeDeSol;
import Vgarden.demo.model.Utilisateur;
import Vgarden.demo.respository.CompteRepository;
import Vgarden.demo.respository.PlanteRepository;
import Vgarden.demo.respository.TerrainRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PlanteRepositoryTest {

	@Autowired
    private PlanteRepository planteRepo;
	@Autowired
    private TerrainRepository terrainRepo;
	@Autowired
    private CompteRepository compteRepo;
	@Test
	@Transactional
	@Commit

	void test() {

		Plante plante = new Plante();
		plante.setTypePlante("Ail");
		plante.setDatePlantation(LocalDate.now());
		plante.setArrosageOk(true);
		Emplacement emplacement = new Emplacement(2,2);
		plante.setEmplacementPlante(emplacement);

		Terrain terrain = new Terrain();
		terrain.setSurface(15.0);
		terrain.setDureeExpoSoleil(6.5);
		terrain.setTypeDeSol(TypeDeSol.Argileux);
		System.out.println("--------------------");
		System.out.println(terrain);


		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setTypeCompte(TypeCompte.Pro);
		List<Terrain> terrains = new ArrayList<Terrain>();
		utilisateur.setTerrains(terrains);

		plante.setTerrain(terrain);
		//List <Terrain> terrains = new ArrayList<Terrain>();
		//terrains.add(terrain);

		utilisateur.getTerrains().add(terrain);

		System.out.println("--------------------");
		System.out.println(plante);
		System.out.println("--------------------");
//		System.out.println(utilisateur);
//		compteRepo.save(utilisateur);
//
//		planteRepo.save(plante);
//		terrainRepo.save(terrain);

	}

}
