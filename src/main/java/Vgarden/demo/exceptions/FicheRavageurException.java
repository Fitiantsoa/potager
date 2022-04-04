package Vgarden.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
public class FicheRavageurException extends RuntimeException {
	public FicheRavageurException() {

	}

	public FicheRavageurException(String message) {
		super(message);
	}

}
