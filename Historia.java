package Modelo;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class Historia {
    
    private int id_historiaclinica;
    private String antec_familiares;
    private String antec_personales;
    private String estado_historia;

    public Historia() {
    }

    public Historia(int id_historiaclinica, String antec_familiares, String antec_personales, String estado_historia) {
        this.id_historiaclinica = id_historiaclinica;
        this.antec_familiares = antec_familiares;
        this.antec_personales = antec_personales;
        this.estado_historia = estado_historia;
    }

    public int getId_historiaclinica() {
        return id_historiaclinica;
    }

    public void setId_historiaclinica(int id_historiaclinica) {
        this.id_historiaclinica = id_historiaclinica;
    }

    public String getAntec_familiares() {
        return antec_familiares;
    }

    public void setAntec_familiares(String antec_familiares) {
        this.antec_familiares = antec_familiares;
    }

    public String getAntec_personales() {
        return antec_personales;
    }

    public void setAntec_personales(String antec_personales) {
        this.antec_personales = antec_personales;
    }

    public String getEstado_historia() {
        return estado_historia;
    }

    public void setEstado_historia(String estado_historia) {
        this.estado_historia = estado_historia;
    }
}
