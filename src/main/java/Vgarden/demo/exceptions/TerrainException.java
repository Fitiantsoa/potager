package Vgarden.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST)
public class TerrainException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TerrainException() {

	}

	public TerrainException(String message) {
		super(message);
	}

}
