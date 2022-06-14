package usuarios;

public class Cajero extends Empleado{

	int cajaAAtender;

	public Cajero(String nombre, String apellido, int edad, String dni, String nombreDeUsuario, String contraseña,
			float sueldo, String horario, int cajaAAtender,float pagoPorHoras) {
		
		super(nombre, apellido, edad, dni, nombreDeUsuario, contraseña, sueldo, horario,pagoPorHoras);
		
		this.cajaAAtender = cajaAAtender;
	}

	public void AsignarCaja(int caja)
	{
		cajaAAtender=caja;
	}
	
	

	

}
