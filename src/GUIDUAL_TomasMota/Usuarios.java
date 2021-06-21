package GUIDUAL_TomasMota;

public class Usuarios {
	private String username;
	private String password;
	private String nombre;
	private String email;
	private String edad;

	// CONSTRUCTORES
	public Usuarios(String username, String password, String nombre, String email, String edad) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}

	public Usuarios() {
		super();
	}

	// GETTER AND SETTERS
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
