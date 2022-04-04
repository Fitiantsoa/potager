package Vgarden.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;

import Vgarden.demo.exceptions.FicheMaladieException;
import Vgarden.demo.exceptions.FicheRavageurException;
import Vgarden.demo.model.FicheMaladie;
import Vgarden.demo.model.Views;
import Vgarden.demo.service.FicheMaladieService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fiches_maladie")
@CrossOrigin(origins = "*")
public class FicheMaladieRestController {

    private final FicheMaladieService ficheMaladieService;

    public FicheMaladieRestController(FicheMaladieService ficheMaladieService) {
        this.ficheMaladieService = ficheMaladieService;
    }

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<FicheMaladie> getAll() {
        return ficheMaladieService.getAll();
    }

    @GetMapping("/{ficheMaladieId}")
    @JsonView(Views.Common.class)
    public FicheMaladie getById(@PathVariable Long ficheMaladieId) {
        return ficheMaladieService.getById(ficheMaladieId);
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    @ResponseStatus(code = HttpStatus.CREATED)
    public FicheMaladie create(@Valid @RequestBody FicheMaladie ficheMaladie, BindingResult result) {
        if(result.hasErrors()) {
            throw new FicheMaladieException();
        }

        return ficheMaladieService.save(ficheMaladie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	ficheMaladieService.delete(id);
    }
    
    @PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public FicheMaladie update(@Valid @RequestBody FicheMaladie ficheMaladie, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new FicheMaladieException();
		}
		if (!ficheMaladieService.exist(id)) {
			throw new FicheRavageurException();
		}
		return ficheMaladieService.save(ficheMaladie);
	}
}
