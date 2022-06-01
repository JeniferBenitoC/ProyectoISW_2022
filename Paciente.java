package Modelo;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Paciente {
    
    private int id_paciente;
    private String nombre_paciente;
    private String dni;
    private String telefono_paciente;
     private String direccion_paciente;
    private String distrito_paciente; 
    private String estado_paciente;
    private int id_historiaclinica;

     public Paciente() {
    }

    public Paciente(int id_paciente, String nombre_paciente, String dni, String telefono_paciente, String direccion_paciente, String distrito, String estado, int id_historiaclinica) {
        this.id_paciente = id_paciente;
        this.nombre_paciente = nombre_paciente;
        this.dni = dni;
        this.telefono_paciente = telefono_paciente;
        this.direccion_paciente = direccion_paciente;
        this.distrito_paciente = distrito;
        this.estado_paciente = estado;
        this.id_historiaclinica = id_historiaclinica;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getDistrito_paciente() {
        return distrito_paciente;
    }

    public void setDistrito_paciente(String distrito_paciente) {
        this.distrito_paciente = distrito_paciente;
    }

    public String getEstado_paciente() {
        return estado_paciente;
    }

    public void setEstado_paciente(String estado_paciente) {
        this.estado_paciente = estado_paciente;
    }
    
    public int getId_historiaclinica() {
        return id_historiaclinica;
    }

    public void setId_historiaclinica(int id_historiaclinica) {
        this.id_historiaclinica = id_historiaclinica;
    }

}
