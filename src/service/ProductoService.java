package service;

import java.util.ArrayList;
import java.util.List;

import productos.Producto;
import util.Validador;

public class ProductoService {
    private List<Producto> productos;
    private static int contadorID = 1;

    //constructor que inicializa la lista de productos
    public ProductoService() {
        this.productos = new ArrayList<>();
    }
    public Producto cargarProducto(Producto p) {
        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());
        p.setId(contadorID);
        contadorID++;
        productos.add(p);
        return p;     
    }


    
    
}
