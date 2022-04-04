package Vgarden.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
public class FichePlanteException extends RuntimeException {
	public FichePlanteException() {

	}

	public FichePlanteException(String message) {
		super(message);
	}

}
