package excepciones;

public class ContraseñaIncorrectaException extends Exception{  // contraseña incorrecta
	public ContraseñaIncorrectaException(String message)
	{
		super(message);
	}
}
