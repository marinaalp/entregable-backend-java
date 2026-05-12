package productos;

public class Bebida extends Producto {
    private double ml; // "refresco", "jugo", "agua", etc.

    public Bebida(String nombre, double precio, int stock, String categoria, double ml) {
        super(nombre, precio, stock, categoria);
        this.ml = ml;
    }

    public Bebida() {
        // constructor vacío
    }

    public double getMl() {
        return ml;
    }

    public void setMl(double ml) {
        this.ml = ml;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", stock=" + getStock() +
                ", categoria='" + getCategoria() + '\'' +
                ", ml='" + ml + '\'' +
                '}';
    }
    
}
