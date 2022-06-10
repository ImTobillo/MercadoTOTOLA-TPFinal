package clases;

import java.util.HashSet;
import java.util.Iterator;

public class Carrito implements I_calcularMonto{
	// atributos
	
	private HashSet<ItemPedido> listaDePedidos;
	private float precioTotal;

	// constructor
	
	public Carrito() {
		listaDePedidos = new HashSet<>();
		precioTotal = 0;
	}
	
	// gets & sets
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	// metodos
	
	@Override
	public float aCobrar() {
		float montoTotal = 0;
		
		for (ItemPedido itemPedido : listaDePedidos) {
			montoTotal += itemPedido.precioTotal();
		}
		
		return montoTotal;
	}
	
	public boolean agregarACarrito(ItemPedido pedido) {
		return listaDePedidos.add(pedido);
	}
	
	public String mostrarCarrito()
	{
		StringBuilder lista = new StringBuilder();
		
		Iterator<ItemPedido> it = listaDePedidos.iterator();
		
		while(it.hasNext())
			lista.append(it.next().toString()+"\n");
		
		return lista.toString();
	}
}
