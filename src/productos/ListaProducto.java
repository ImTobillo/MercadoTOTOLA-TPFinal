package productos;

import java.util.ArrayList;

public class ListaProducto<E extends Producto> {

	protected ArrayList<E> listaProductos;
	
	public ListaProducto(){
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
	
}
