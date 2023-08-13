package co.edu.sena.models.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "afiliado")
public class Afiliado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "documento")
	private int documento;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "beneficiarios")
	private int beneficiarios;
	
	@OneToOne(mappedBy = "idAfiliado", cascade = CascadeType.ALL)
	private Usuario usuario;
		
	public Afiliado() {

	}

	public Afiliado(int id, String nombres, int documento, String apellidos, int edad, String telefono, String correo,
			String direccion, int beneficiarios, Usuario usuario) {
		this.id = id;
		this.nombres = nombres;
		this.documento = documento;
		this.apellidos = apellidos;
		this.edad = edad;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.beneficiarios = beneficiarios;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(int beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
