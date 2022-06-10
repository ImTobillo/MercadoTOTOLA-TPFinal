package clases;

public class Empleado extends Usuario implements I_calcularMonto{

    private float sueldo;
    private String horario;
    private float pagoPorHoras;
	private int horasTrabajadas;
    private int horasExtras;
    
	public Empleado(String nombre, String apellido, int edad, String dni, String nombreDeUsuario, String contraseña,float sueldo, String horario,float pagoPorHoras) {
		super(nombre, apellido, edad, dni, nombreDeUsuario, contraseña);
		this.sueldo = sueldo;
		this.horario = horario;
		this.pagoPorHoras = pagoPorHoras;
		this.horasTrabajadas = 0;
		this.horasExtras = 0;
	}

	@Override
	public String toString() {
		return super.toString()+"sueldo=" + sueldo + ", horario=" + horario + ", horasTrabajadas=" + horasTrabajadas
				+ ", horasExtras=" + horasExtras;
	}

	public void ModificarSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public float getSueldo() {

		return sueldo;
	}
	
	public float aCobrar()
    {
        sueldo += ((horasTrabajadas*pagoPorHoras)+(horasExtras*pagoPorHoras*2));
    	
    	return sueldo;
    }
}
