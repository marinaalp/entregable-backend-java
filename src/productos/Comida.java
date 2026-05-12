package productos;

public class Comida extends Producto {
    private double gramos; // "hamburguesa", "pizza", "ensalada", etc.

    public Comida(String nombre, double precio, int stock, String categoria, double gramos) {
        super(nombre, precio, stock, categoria);
        this.gramos = gramos;
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", stock=" + getStock() +
                ", categoria='" + getCategoria() + '\'' +
                ", gramos='" + gramos + '\'' +
                '}';
    }
    
}
