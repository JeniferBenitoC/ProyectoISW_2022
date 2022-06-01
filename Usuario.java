package Modelo;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Usuario {
    
    private int id_usuario;
    private String nombre;
    private String username;
    private String contraseña;
    private String perfil;
    private String correo_electronico;
    private String telefono;
    private String estado;

    public Usuario(int id_usuario, String nombre, String username, String contraseña, String perfil, String correo_electronico, String telefono, String estado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.username = username;
        this.contraseña = contraseña;
        this.perfil = perfil;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.estado = estado;
    }

        public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
