package usuarios;

public class Seguridad extends Empleado{

	private String zonaAvigilar;

	public Seguridad(String nombre, String apellido, int edad, String dni, String nombreDeUsuario, String contrase�a, String horario, String zonaAvigilar,float pagoPorHoras) {
		
		super(nombre, apellido, edad, dni, nombreDeUsuario, contrase�a, horario,pagoPorHoras);
		
		this.zonaAvigilar = zonaAvigilar;
	}

	@Override
	public String toString() {
		return super.toString() + " zonaAvigilar=" + zonaAvigilar;
	}
	
	public void asignarZona(String zonaAVigilar) {
		
		this.zonaAvigilar = zonaAVigilar;
		
	}

	
	
}
