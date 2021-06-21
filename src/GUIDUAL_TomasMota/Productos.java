package GUIDUAL_TomasMota;

public class Productos {
	private String Codigo;
	private String Nombre;
	private String Precio;
	private String Descripcion;

	// Contructor vacio
	public Productos() {
		super();
	}

	// Constructor
	public Productos(String codigo, String nombre, String precio, String descripcion) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Precio = precio;
		Descripcion = descripcion;
	}

	// GETTERS AND SETTERS
	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

}
