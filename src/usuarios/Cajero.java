package usuarios;

public class Cajero extends Empleado{

	int cajaAAtender;

	public Cajero(String nombre, String apellido, int edad, String dni, String nombreDeUsuario, String contrase�a,
			float sueldo, String horario, int cajaAAtender,float pagoPorHoras) {
		
		super(nombre, apellido, edad, dni, nombreDeUsuario, contrase�a, sueldo, horario,pagoPorHoras);
		
		this.cajaAAtender = cajaAAtender;
	}

	public void AsignarCaja(int caja)
	{
		cajaAAtender=caja;
	}
	
	

	

}
