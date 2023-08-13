package co.edu.sena.models.entity;





import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "tipo_doc") 
	private String tipoDocumento;
	
	@Column(name = "documento")
	private int documento;
	
	@Column(name = "contraseña")
	private String contraseña;
	
	@OneToOne
	@JoinColumn(name = "id_afiliado")
	@JsonBackReference
	private Afiliado idAfiliado;
	
	public Usuario() {

	}

	public Usuario(int id, String tipoDocumento, int documento, String contraseña, Afiliado idAfiliado) {

		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.contraseña = contraseña; 
		this.idAfiliado = idAfiliado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Afiliado getIdAfiliado() {
		return idAfiliado;
	}

	public void setAfiliado(Afiliado idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	
}
