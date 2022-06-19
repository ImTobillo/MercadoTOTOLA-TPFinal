package productos;

import java.util.ArrayList;

public class ListaProducto<E extends Producto> {

	protected ArrayList<E> listaProductos;

	public ListaProducto() {
		listaProductos = new ArrayList<E>();
	}

	public void agregarProducto(E prod) {
		listaProductos.add(prod);
	}

	public void sacarProducto(E prod) {
		listaProductos.remove(prod);
	}

	public String mostrar() {
		return listaProductos.toString();
	}

	public boolean buscar(String nombre) {

		boolean flag = false;
		int i = 0;

		while (i < listaProductos.size() && flag == false) {

			if (listaProductos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				flag = true;
			}
			i++;
		}
		return flag;
	}

	public Producto retornarProducto(String nombre)
	{
		for (E e : listaProductos) {
			if (e.getNombre().equalsIgnoreCase(nombre))
				return e;
		}
		
		return null;		
	}
	
	public void buscarRepone(String nombre, int cantidad) {

		boolean flag = false;
		int i = 0;

		while (i < listaProductos.size() && flag == false) {

			if (listaProductos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				flag = true;
				listaProductos.get(i).agregarStock(cantidad);
			}
			i++;
		}

	}

}
