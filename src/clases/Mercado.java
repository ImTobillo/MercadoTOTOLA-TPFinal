package clases;

import java.util.HashMap;

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
	
	public boolean login(String usuario, String contraseña)
	{
		try {
			if (!listaUsuarios.containsKey(usuario))
				throw new UsuarioIncorrectoException("El usuario no existe.");
			if (!listaUsuarios.get(usuario).getContraseña().equalsIgnoreCase(contraseña))
				throw new ContraseñaIncorrectaException("La contraseña es incorrecta");
			
			return true;
		}
		catch (UsuarioIncorrectoException e) {
			return false; 							/// ?? preguntar
		}
		catch (ContraseñaIncorrectaException e) {
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean agregarUsuario(Usuario usuario)
	{
		try {
			if (listaUsuarios.containsKey(usuario.getNombreDeUsuario()))
				throw new UsuarioIncorrectoException("Usuario ya existente.");
			else // ??
			{
				listaUsuarios.put(usuario.getNombreDeUsuario(), usuario);
				return true;
			}
		} 
		catch (UsuarioIncorrectoException e) {
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}

}

