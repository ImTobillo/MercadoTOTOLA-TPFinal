package clases;

public class ItemPedido {
	// atributos
	
	private String nombre;
	private float precioUnitario;
	private int cantidad;
	
	// constructores
	
	public ItemPedido()
	{
		nombre = "";
		precioUnitario = 0;
		cantidad = 0;
	}
	
	public ItemPedido(String nombre, float precioUnitario, int cantidad)
	{
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
	}
	
	// gets & sets
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	
	@Override
	public String toString() {
		return nombre+"\t$"+precioUnitario+"\t"+cantidad;
	}
	
	// metodos
	
	public float precioTotal()
	{
		return precioUnitario * cantidad;
	}

}
