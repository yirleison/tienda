package modelo;

public class Producto {
	
	private int id;
	private String nombre;
	private int estado;
	private float valorUnitario;
	private int categoriaId;
	
	
	public Producto(int id, String nombre, int estado, float valorUnitario, int categoriaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.valorUnitario = valorUnitario;
		this.categoriaId = categoriaId;
	}
	
	
	public Producto() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}


	@Override
	public String toString() {
		return "producto [id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", valorUnitario=" + valorUnitario
				+ ", categoriaId=" + categoriaId + "]";
	}
		
}
