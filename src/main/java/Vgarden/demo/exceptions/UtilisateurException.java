package Vgarden.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
public class UtilisateurException extends RuntimeException{
	public UtilisateurException() {
	}

	public UtilisateurException(String message) {
		super(message);
	}

}
