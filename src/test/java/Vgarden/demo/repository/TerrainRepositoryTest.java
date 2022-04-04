package Vgarden.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import Vgarden.demo.model.Terrain;
import Vgarden.demo.model.TypeDeSol;
import Vgarden.demo.respository.TerrainRepository;


@SpringBootTest
class TerrainRepositoryTest {

	@Autowired
	private TerrainRepository terrainRepo;

	@Test
	@Transactional
	@Commit
	void test() {
		Terrain terrain = new Terrain();
		terrain.setSurface(15.0);
		terrain.setDureeExpoSoleil(6.5);
		terrain.setTypeDeSol(TypeDeSol.Argileux);
		System.out.println("--------------------");
		System.out.println(terrain);
		terrainRepo.save(terrain);
		}
}
