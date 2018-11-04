package modelo;

public class Compra {
	private int id;
	private int cantidadProductos;
	private float valorCompra;
	private String detalleCompra;
	private int usuarioId;
	
	
	public Compra(int id, int cantidadProductos, float valorCompra, String detalleCompra, int usuarioId) {
		super();
		this.id = id;
		this.cantidadProductos = cantidadProductos;
		this.valorCompra = valorCompra;
		this.detalleCompra = detalleCompra;
		this.usuarioId = usuarioId;
	}
	
	
	public Compra() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidadProductos() {
		return cantidadProductos;
	}
	public void setCantidadProductos(int cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}
	public float getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	public String getDetalleCompra() {
		return detalleCompra;
	}
	public void setDetalleCompra(String detalleCompra) {
		this.detalleCompra = detalleCompra;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}


	@Override
	public String toString() {
		return "usuario [id=" + id + ", cantidadProductos=" + cantidadProductos + ", valorCompra=" + valorCompra
				+ ", detalleCompra=" + detalleCompra + ", usuarioId=" + usuarioId + "]";
	}
	
}
