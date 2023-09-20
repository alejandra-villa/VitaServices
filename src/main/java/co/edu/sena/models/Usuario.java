package co.edu.sena.models;

public class Usuario {

    private String tipoDocumento;
    private String documento;
    private String contraseña;

    public Usuario() {

        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.contraseña = contraseña;

    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
