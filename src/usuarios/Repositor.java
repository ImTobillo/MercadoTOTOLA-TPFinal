package usuarios;

public class Repositor extends Empleado{

	public Repositor(String nombre, String apellido, int edad, String dni, String nombreDeUsuario, String contraseña,
			float sueldo, String horario, int horasTrabajadas, int horasExtras,float pagoPorHoras) {
		
		super(nombre, apellido, edad, dni, nombreDeUsuario, contraseña, sueldo, horario, pagoPorHoras);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

	

}
