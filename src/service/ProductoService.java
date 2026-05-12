package service;

import java.util.ArrayList;
import java.util.List;

import productos.Bebida;
import productos.Comida;
import productos.Producto;
import util.Validador;

public class ProductoService {
    private List<Producto> productos;
    private static int contadorID = 1;

    // constructor que inicializa la lista de productos
    public ProductoService() {
        this.productos = new ArrayList<>();
    }

    public Producto cargarProducto(Producto p) {
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());
        if (p instanceof Bebida) {
            // Hacemos un "cast" para poder acceder a los métodos de Bebida
            Bebida b = (Bebida) p;
            Validador.validarMl(b.getMl());
        } else if (p instanceof Comida) {
            Comida c = (Comida) p;
            Validador.validarGramos(c.getGramos());
        }
        p.setId(contadorID);
        contadorID++;
        productos.add(p);
        return p;
    }

}
