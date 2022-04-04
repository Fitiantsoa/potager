package Vgarden.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.FicheRavageurException;
import Vgarden.demo.model.FicheRavageur;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.FicheRavageurService;



@RestController
@RequestMapping("/fiches_ravageur")
@CrossOrigin(origins = "*")
public class FicheRavageurRestController {

    private final FicheRavageurService ficheRavageurService;

    public FicheRavageurRestController(FicheRavageurService ficheRavageurService) {
        this.ficheRavageurService = ficheRavageurService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<FicheRavageur> getAll() {
        return ficheRavageurService.getAll();
    }

    @GetMapping("/{ficheRavageurId}")
    @JsonView(Views.Common.class)
    public FicheRavageur getById(@PathVariable Long ficheRavageurId) {
        return ficheRavageurService.getById(ficheRavageurId);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public FicheRavageur create(@Valid @RequestBody FicheRavageur ficheRavageur, BindingResult result) {
        if(result.hasErrors()) {
            throw new FicheRavageurException();
        }

        return ficheRavageurService.save(ficheRavageur);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	ficheRavageurService.delete(id);
    }
    
    @PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public FicheRavageur update(@Valid @RequestBody FicheRavageur ficheRavageur, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new FicheRavageurException();
		}
		if (!ficheRavageurService.exist(id)) {
			throw new FicheRavageurException();
		}
		return ficheRavageurService.save(ficheRavageur);
	}
}
