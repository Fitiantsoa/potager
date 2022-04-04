package Vgarden.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.FichePlanteException;
import Vgarden.demo.exceptions.FicheRavageurException;
import Vgarden.demo.model.FichePlante;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.FichePlanteService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiches_plante")
@CrossOrigin(origins = "*")
public class FichePlanteRestController {

    private final FichePlanteService fichePlanteService;

    public FichePlanteRestController(FichePlanteService fichePlanteService) {
        this.fichePlanteService = fichePlanteService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<FichePlante> getAll() {
        return fichePlanteService.getAll();
    }

    @GetMapping("/{fichePlanteId}")
    @JsonView(Views.Common.class)
    public FichePlante getById(@PathVariable Long fichePlanteId) {
        return fichePlanteService.getById(fichePlanteId);
    }
    
    @GetMapping("/nom/{typePlante}")
    @JsonView(Views.Common.class)
    public FichePlante getByNom(@PathVariable String typePlante) {
    	return fichePlanteService.getByNom(typePlante);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public FichePlante create(@Valid @RequestBody FichePlante fichePlante, BindingResult result) {
        if(result.hasErrors()) {
            throw new FichePlanteException();
        }

        return fichePlanteService.save(fichePlante);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	fichePlanteService.delete(id);
    }
    
    @PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public FichePlante update(@Valid @RequestBody FichePlante fichePlante, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new FichePlanteException();
		}
		if (!fichePlanteService.exist(id)) {
			throw new FicheRavageurException();
		}
		return fichePlanteService.save(fichePlante);
	}
}
