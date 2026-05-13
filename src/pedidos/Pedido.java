package pedidos;

import java.util.ArrayList;
import java.util.List;
import productos.Producto;

public class Pedido {
    List<Producto> productos;
    double total;
    int id;

    public Pedido(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
    }

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        this.total += producto.getPrecio();
    }

    public double getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("==============================\n");
        sb.append("PEDIDO Nº: ").append(id).append("\n");
        sb.append("------------------------------\n");

        for (Producto p : productos) {
            sb.append("- ").append(p.getNombre())
                    .append(" ($").append(p.getPrecio()).append(")\n");
        }

        sb.append("------------------------------\n");
        sb.append("TOTAL A PAGAR: $").append(total).append("\n");
        sb.append("==============================");

        return sb.toString();
    }

}
