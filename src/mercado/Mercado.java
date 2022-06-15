package mercado;

import java.util.HashMap;

import excepciones.*;
import usuarios.*;
import productos.*;
//import interfaces.*;
//import carrito.*;

public class Mercado {
	// atributos
	
	private HashMap<String, Usuario> listaUsuarios;
	private ListaProducto<Congelado> congelados;
	private ListaProducto<AlimentoCultivado> alimentosCultivados;
	private ListaProducto<Limpieza> limpieza;

	// constructores
	
	public Mercado()
	{
		listaUsuarios = new HashMap<String, Usuario>();
		congelados = new ListaProducto<Congelado>();
		alimentosCultivados = new ListaProducto<AlimentoCultivado>();
		limpieza = new ListaProducto<Limpieza>();
	}
	
	// metodos
	
	public Usuario login(String usuario, String contrase�a) throws UsuarioIncorrectoException, Contrase�aIncorrectaException
	{
		if (!listaUsuarios.containsKey(usuario))
			throw new UsuarioIncorrectoException("El usuario no existe.");
		
		if (!listaUsuarios.get(usuario).getContrase�a().equalsIgnoreCase(contrase�a))
			throw new Contrase�aIncorrectaException("La contrase�a es incorrecta");
		
		return listaUsuarios.get(usuario);
	}
	
	public boolean agregarUsuario(Usuario usuario) throws UsuarioIncorrectoException
	{
		if (listaUsuarios.containsKey(usuario.getNombreDeUsuario()))
			throw new UsuarioIncorrectoException("Usuario ya existente.");
		
		listaUsuarios.put(usuario.getNombreDeUsuario(), usuario);
		return true;
	}
	
	public boolean existeUsuario(String nombreUsuario)
	{
		return listaUsuarios.containsKey(nombreUsuario);
	}

}

