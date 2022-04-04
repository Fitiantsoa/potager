package Vgarden.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.TerrainException;
import Vgarden.demo.model.Compte;
import Vgarden.demo.model.Plante;
import Vgarden.demo.model.Terrain;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.PlanteService;
import Vgarden.demo.service.TerrainService;


	@RestController
	@RequestMapping("/terrain")
	@CrossOrigin(origins = "*")
	public class TerrainRestController {

		@Autowired
		private TerrainService terrainService;
		@Autowired
		private PlanteService planteService;

		@GetMapping("")
		@JsonView(Views.Common.class)
		public List<Terrain> getByUtilisateur(@AuthenticationPrincipal Compte compte) {
			List<Terrain> list = terrainService.getByUtilisateur(compte.getUtilisateur());
			System.out.println(list);
			System.out.println("laaaa");
			return list;
		}
		
		@GetMapping("/{terrain}/plantes")
		@JsonView(Views.TerrainWithPlantes.class)
		public List<Plante> getByTerrain(@PathVariable Terrain terrain) {
			List<Plante> list = planteService.getByTerrain(terrain);
			return list;
		}

//		@GetMapping("/get")
//		@JsonView(Views.Common.class)
//		public Terrain getById(@RequestParam Long id) {
//			return terrainService.getById(id);
//		}

		@GetMapping("/{id}")
		@JsonView(Views.Common.class)
		public Terrain getById(@PathVariable Long id) {
			return terrainService.getById(id);
		}

		

		@PostMapping("")
		@JsonView(Views.Common.class)
		@ResponseStatus(code = HttpStatus.CREATED)
		public Terrain create(@AuthenticationPrincipal Compte compte, @Valid @RequestBody Terrain terrain, BindingResult br) {
			if (br.hasErrors()) {
				throw new TerrainException();
			}
			terrain.setUtilisateur(compte.getUtilisateur());
			return terrainService.createOrUpdate(terrain);
		}
		
		// {
		//	"surface":"20",
		//	"localisation":"Montluçon",
		//	"utilisateur": {"id":"100"}
		//	}

//		@GetMapping("/{id}/plante")
//		@JsonView(Views.TerrainWithPlantes.class)
//		public Terrain getByIdWithPlante(@PathVariable Long id) {
//			return terrainService.getByIdWithPlantes(id);
//		}
		
		@PutMapping("/{id}")
		@JsonView(Views.Common.class)
		public Terrain update(@PathVariable Long id, @Valid @RequestBody Terrain terrain, BindingResult br) {
			if (terrain.getId() == null|| id != terrain.getId() || br.hasErrors()) {
				throw new TerrainException();
			}
			return terrainService.createOrUpdate(terrain);
		}

		@DeleteMapping("/{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			terrainService.deleteById(id);
		}

}
