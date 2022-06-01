package Modelo;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Medicos {
    private int id_medico;
    private String nombre_medico;
    private String cmp;
    private String correo_medico;
    private String telefono_medico;
    private int id_especialidad;
    private String estado_medico;
    private String nombre_especialidad;

    public Medicos() {
    }

    public Medicos(int id_medico, String nombre_medico, String cmp, String correo_medico, String telefono_medico, int id_especialidad, String estado_medico, String nombre_especialidad) {
        this.id_medico = id_medico;
        this.nombre_medico = nombre_medico;
        this.cmp = cmp;
        this.correo_medico = correo_medico;
        this.telefono_medico = telefono_medico;
        this.id_especialidad = id_especialidad;
        this.estado_medico = estado_medico;
        this.nombre_especialidad = nombre_especialidad;
    }

  

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getCorreo_medico() {
        return correo_medico;
    }

    public void setCorreo_medico(String correo_medico) {
        this.correo_medico = correo_medico;
    }

    public String getTelefono_medico() {
        return telefono_medico;
    }

    public void setTelefono_medico(String telefono_medico) {
        this.telefono_medico = telefono_medico;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getEstado_medico() {
        return estado_medico;
    }

    public void setEstado_medico(String estado_medico) {
        this.estado_medico = estado_medico;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

}
