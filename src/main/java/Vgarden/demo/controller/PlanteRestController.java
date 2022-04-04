package Vgarden.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.PlanteException;
import Vgarden.demo.model.Plante;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.PlanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/plante")
@CrossOrigin(origins = "*")
public class PlanteRestController {

	@Autowired
	private PlanteService planteService;

	/*@GetMapping("/t/{terrain}")
	@JsonView(Views.Common.class)
	public List<Plante> getByTerrain(@PathVariable Terrain terrain) {
		List<Plante> list = planteService.getByTerrain(terrain);
		System.out.println(list);
		return list;
	}*/


	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Plante getById(@PathVariable Long id) {
		return planteService.getById(id);
	}


	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Plante create(@Valid @RequestBody Plante plante, BindingResult br) {
		if (br.hasErrors()) {
			throw new PlanteException("Plante mal créée");
		}
		return planteService.createOrUpdate(plante);
	}
	//{"terrain":{"id":"2"},
	//	"emplacementPlante":
	//	{"positionx":"2",
	//	"positiony":"2"},
	//	"typePlante": "Ail"}


	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Plante update(@PathVariable Long id, @Valid @RequestBody Plante plante, BindingResult br) {
		if (plante.getId() == 0L || id != plante.getId() || br.hasErrors()) {
			throw new PlanteException();
		}
		return planteService.createOrUpdate(plante);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		planteService.deleteById(id);
	}

}
