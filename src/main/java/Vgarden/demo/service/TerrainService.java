package Vgarden.demo.service;

import java.util.List;

import javax.validation.Validator;

import org.springframework.stereotype.Service;

import Vgarden.demo.exceptions.TerrainException;
import Vgarden.demo.model.Terrain;
import Vgarden.demo.model.Utilisateur;
import Vgarden.demo.respository.TerrainRepository;



@Service
public class TerrainService {

	private final Validator validator;
	private TerrainRepository terrainRepository;


	public TerrainService(TerrainRepository terrainRepository, Validator validator) {

		this.validator = validator;
		this.terrainRepository = terrainRepository;
	}

	public List<Terrain> getByUtilisateur(Utilisateur utilisateur){
		return terrainRepository.findByUtilisateur(utilisateur);
	}

	public Terrain getById(Long id) {
    	return terrainRepository.findById(id).orElseThrow(() -> {
            throw new TerrainException("Terrain non trouvé");
        });
    }
	
	public Terrain getByIdWithPlantes(Long id) {
		return terrainRepository.findByIdWithPlantes(id).orElseThrow(() -> {
		throw new TerrainException("Compte inexistant par find by login");
	});}


	public void delete(Terrain terrain) {
		terrainRepository.delete(terrain);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

	public Terrain createOrUpdate(Terrain terrain) {
		check(terrain);
		if (terrain.getId()== null) {
			return terrainRepository.save(terrain);
		} else {
			Terrain terrainEnBase = getById(terrain.getId());
			terrainEnBase.setSurface(terrain.getSurface());
			terrainEnBase.setPlantes(terrain.getPlantes());
			return terrainRepository.save(terrainEnBase);
		}
	}

	private void check(Terrain terrain) {
		if (!validator.validate(terrain).isEmpty()) {
			throw new TerrainException();
		}
	}

	public boolean exist(Long id) {
		return terrainRepository.existsById(id);
	}
}
