package clases;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class Usuario {
	
	private String nombre;
	private String apellido;
	private int edad;
	private String dni;
	private String nombreDeUsuario;
	private String contrase�a;
	private Date fechaDeCreacion;
	
	public Usuario(String nombre, String apellido, int edad, String dni, String nombreDeUsuario, String contrase�a) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrase�a = contrase�a;
		fechaDeCreacion = Calendar.getInstance().getTime();
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni
				+ ", nombreDeUsuario=" + nombreDeUsuario + ", contrase�a=" + contrase�a + ", fechaDeCreacion="
				+ fechaDeCreacion;
	}

	public void CambiarContrase�a(String contrase�a) {
		
		this.contrase�a = contrase�a;
		
	}

	
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombreDeUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		Usuario other = (Usuario) obj;
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (Objects.equals(dni, other.dni) || Objects.equals(nombreDeUsuario, other.nombreDeUsuario))
			return true;
		else
			return false;
		
	}
	
	
	

}
