package mercado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import excepciones.*;
import usuarios.*;
import productos.*;
//import interfaces.*;
//import carrito.*;

public class Mercado {
	// atributos

	private String nombre;
	private HashMap<String, Usuario> listaUsuarios;
	private ListaProducto<Congelado> congelados;
	private ListaProducto<AlimentoCultivado> alimentosCultivados;
	private ListaProducto<Limpieza> limpieza;

	// constructores

	public Mercado(String nombre) {
		this.nombre = nombre;
		listaUsuarios = new HashMap<String, Usuario>();
		congelados = new ListaProducto<Congelado>();
		alimentosCultivados = new ListaProducto<AlimentoCultivado>();
		limpieza = new ListaProducto<Limpieza>();
	}

	// metodos

	public Usuario login(String usuario, String contraseña)
			throws UsuarioIncorrectoException, ContraseñaIncorrectaException {
		if (!listaUsuarios.containsKey(usuario))
			throw new UsuarioIncorrectoException("El usuario no existe.");

		if (!listaUsuarios.get(usuario).getContraseña().equalsIgnoreCase(contraseña))
			throw new ContraseñaIncorrectaException("La contraseña es incorrecta");

		return listaUsuarios.get(usuario);
	}

	public boolean agregarUsuario(Usuario usuario) throws UsuarioIncorrectoException {
		if (listaUsuarios.containsKey(usuario.getNombreDeUsuario()))
			throw new UsuarioIncorrectoException("Usuario ya existente.");

		listaUsuarios.put(usuario.getNombreDeUsuario(), usuario);
		return true;
	}

	public boolean existeUsuario(String nombreUsuario) {
		return listaUsuarios.containsKey(nombreUsuario);
	}

	public String mostrarTodosLosProductos() {
		StringBuilder lista = new StringBuilder();

		lista.append(congelados.mostrar()+"\n");
		lista.append(alimentosCultivados.mostrar()+"\n");
		lista.append(limpieza.mostrar()+"\n");

		return lista.toString();
	}

	public boolean existeOno(String nombre) {

		boolean flag = congelados.buscar(nombre);

		if (flag == false) {
			flag = alimentosCultivados.buscar(nombre);
		}

		if (flag == false) {
			flag = limpieza.buscar(nombre);
		}

		return flag;
	}

	public Producto retornarProducto(String nombre)
	{
		Producto prod = congelados.retornarProducto(nombre);
		
		if (prod == null)
			prod = alimentosCultivados.retornarProducto(nombre);
		
		if (prod == null)
			prod = limpieza.retornarProducto(nombre);
		
		return prod;
	}
	
	public void reponer(String nombre, int cantidad) {

		congelados.buscarRepone(nombre, cantidad);
		alimentosCultivados.buscarRepone(nombre, cantidad);
		limpieza.buscarRepone(nombre, cantidad);
		
	}

	public void agregarProd(Producto prod, int tipo) {
		
		if(tipo == 1) {
			congelados.agregarProducto((Congelado)prod);
		}
		else if(tipo == 2) {
			alimentosCultivados.agregarProducto((AlimentoCultivado)prod);
		}
		else {
			limpieza.agregarProducto((Limpieza)prod);
		}
	}
	
	public String mostrarEmpleados()
	{
		StringBuilder listaEmp = new StringBuilder();
		Iterator<Entry<String, Usuario>> it = listaUsuarios.entrySet().iterator();
		
		while (it.hasNext())
		{
			Entry<String, Usuario> fila = it.next();
			listaEmp.append(fila.toString()); // corroborar
		}
		
		return listaEmp.toString();
	}
	
	public Empleado buscarEmpleado(String nombreUsuario)
	{
		return (Empleado)listaUsuarios.get(nombreUsuario);
	}
	
	public boolean eliminarEmpleado(String nombreUsuario)
	{
		if (listaUsuarios.remove(nombreUsuario) == null)
			return false;
		else
			return true;
	}
	
	/// gets
	
	public String getNombre() {
		return nombre;
	}
}
