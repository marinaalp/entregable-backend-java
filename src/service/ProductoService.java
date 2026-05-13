package service;

import java.util.ArrayList;
import java.util.List;

import excepciones.ProductoNoEncontradoException;
import excepciones.StockInsuficienteException;
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

    public List<Producto> listarTodos() {
        return productos;
    }

    public Producto obtenerPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No se encontró un producto con id " + id);
    }

    public Producto actualizarProducto(int id, Producto nuevoProducto) {
        Producto productoExistente = obtenerPorId(id);

        Validador.validarNombre(nuevoProducto.getNombre());
        Validador.validarPrecio(nuevoProducto.getPrecio());
        Validador.validarStock(nuevoProducto.getStock());

        productoExistente.setNombre(nuevoProducto.getNombre());
        productoExistente.setPrecio(nuevoProducto.getPrecio());
        productoExistente.setStock(nuevoProducto.getStock());

        // Actualización de campos específicos
        if (productoExistente instanceof Bebida && nuevoProducto instanceof Bebida) {
            ((Bebida) productoExistente).setMl(((Bebida) nuevoProducto).getMl());
        } else if (productoExistente instanceof Comida && nuevoProducto instanceof Comida) {
            ((Comida) productoExistente).setGramos(((Comida) nuevoProducto).getGramos());
        }

        return productoExistente;
    }

    public void eliminarProducto(int id) {
        Producto productoExistente = obtenerPorId(id);
        productos.remove(productoExistente);
    }

    public void descontarStock(int id, int cantidad) {
        Producto p = obtenerPorId(id); // Reutilizamos el buscador que ya lanza ProductoNoEncontradoException

        if (p.getStock() < cantidad) {
            throw new StockInsuficienteException("No hay stock suficiente de: " + p.getNombre() +
                    " (Disponible: " + p.getStock() + ")");
        }

        p.setStock(p.getStock() - cantidad);
    }

}
