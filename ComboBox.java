package Modelo;

/**
 *
 * @author Jenifer M. Benito Cueva
 */
public class ComboBox {
    
    private int id;
    private String nombre;

    public ComboBox(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }



    public int getId() {
        return id;
    }

    public void setId_producto(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString()
    {
        return this.getNombre();
    }    
}
