import java.util.List;
import java.util.Scanner;

import excepciones.ProductoNoEncontradoException;
import pedidos.Pedido;
import productos.Comida;
import productos.Producto;
import productos.Bebida;
import service.ProductoService;
import util.Validador;
import service.PedidoService;

public class Menu {
    private final Scanner sc;
    private final ProductoService productoservice;
    private final PedidoService pedidoService;

    Menu(Scanner scanner, ProductoService service, PedidoService pedidoService) {
        this.sc = scanner;
        this.productoservice = service;
        this.pedidoService = pedidoService;
    }

    public void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar por ID");
        System.out.println("4) Actualizar producto");
        System.out.println("5) Eliminar producto");
        System.out.println("6) Crear un pedido");
        System.out.println("7) Listar pedidos");
        System.out.println("8) Salir");
    }

    public void seleccionarOpcion(int opcion) {
        try {
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    crearPedido();
                    break;
                case 7:
                    listarPedidos();
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    System.out.println("Salir");
                    imagenSalida();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }

    }

    public void imagenSalida() {
        // Bolsa de Papas
        System.out.println("      .----------------.      ");
        System.out.println("     /  _  _  _  _  _   \\     ");
        System.out.println("    |  (_)(_)(_)(_)(_)   |    ");
        System.out.println("    |   PAPAS FRITAS     |    ");
        System.out.println("    |    .--------.      |    ");
        System.out.println("    |    |  ####  |      |    ");
        System.out.println("    |    '--------'      |    ");
        System.out.println("    |   .  .  .  .  .    |    ");
        System.out.println("     \\__________________/     ");
        System.out.println("      '----------------'      ");

        System.out.println();

        // Gaseosa
        System.out.println("          ______          ");
        System.out.println("         |  ____|         ");
        System.out.println("         | |              ");
        System.out.println("      ___|_|______        ");
        System.out.println("     |____________|       ");
        System.out.println("     |            |       ");
        System.out.println("     |   *    *   |       ");
        System.out.println("     |      *     |       ");
        System.out.println("     |   *    *   |       ");
        System.out.println("     |            |       ");
        System.out.println("     |____________|       ");
        System.out.println("     (____________)       ");
    }

    public void agregarProducto() {
        System.out.println("--- Datos del nuevo producto ---");
        String nombre = Validador.leerTexto(sc, "Ingrese el nombre: ");
        double precio = Validador.leerDouble(sc, "Ingrese el precio: ");
        int stock = Validador.leerEntero(sc, "Ingrese el stock: ");
        String categoria = Validador.leerTexto(sc, "Ingrese la categoría (comida o bebida): ");

        try {
            if (categoria.equalsIgnoreCase("comida")) {
                double gramos = Validador.leerDouble(sc, "Ingrese los gramos: ");
                Comida comida = new Comida(nombre, precio, stock, categoria, gramos);
                Producto guardado = productoservice.cargarProducto(comida); // Se guarda como Producto
                System.out.println("Comida " + guardado.getId() + " agregada con éxito.");

            } else if (categoria.equalsIgnoreCase("bebida")) {
                double ml = Validador.leerDouble(sc, "Ingrese los ml: ");
                Bebida bebida = new Bebida(nombre, precio, stock, categoria, ml);
                Producto guardado = productoservice.cargarProducto(bebida); // Se guarda como Producto
                System.out.println("Bebida " + guardado.getId() + " agregada con éxito.");

            } else {
                System.out.println("Categoría no válida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void listarProductos() {
        System.out.println("--- Lista de productos ---");
        List<Producto> lista = productoservice.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    public void buscarProducto() {
        System.out.println("--- Buscar producto por ID ---");
        int id = Validador.leerEntero(sc, "Ingrese el ID del producto: ");
        Producto producto = productoservice.obtenerPorId(id);
        System.out.println("Producto encontrado: " + producto);

    }

    // cuando actualiza no cambia la categoria
    public void actualizarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el ID del producto a actualizar: ");
        Producto actual = productoservice.obtenerPorId(id); // Si no existe, lanza excepción y sale al catch del Main

        System.out.println("Datos actuales: " + actual);
        System.out.println("--- Ingrese los nuevos datos ---");

        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");

        Producto datosNuevos;

        // Lógica para mantener el tipo de producto (Herencia)
        if (actual instanceof Comida) {
            double gramos = Validador.leerDouble(sc, "Gramos: ");
            datosNuevos = new Comida(nombre, precio, stock, "comida", gramos);
        } else {
            double ml = Validador.leerDouble(sc, "Mililitros: ");
            datosNuevos = new Bebida(nombre, precio, stock, "bebida", ml);
        }

        Producto actualizado = productoservice.actualizarProducto(id, datosNuevos);
        System.out.println("Producto actualizado con éxito: " + actualizado);
    }

    public void eliminarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el ID del producto a eliminar: ");
        productoservice.eliminarProducto(id);
        System.out.println("Producto eliminado con éxito.");
    }

    public void crearPedido() {
        System.out.println("--- Nuevo Pedido ---");
        Pedido nuevoPedido = new Pedido();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nProductos disponibles:");
            listarProductos(); // Mostramos la lista para que vea los IDs

            int id = Validador.leerEntero(sc, "Ingrese ID del producto (0 para terminar): ");

            if (id == 0) {
                continuar = false;
            } else {
                try {
                    // Buscamos el producto real en el catálogo
                    Producto p = productoservice.obtenerPorId(id);

                    // Antes de agregar al pedido, descontamos el stock (si no hay, lanza excepción)
                    productoservice.descontarStock(id, 1);

                    // Agregamos al pedido el producto encontrado
                    nuevoPedido.agregarProducto(p);
                    System.out.println(p.getNombre() + " agregado al carrito.");

                } catch (ProductoNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (excepciones.StockInsuficienteException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                }
            }
        }

        // Si el pedido no está vacío, lo guardamos en el service de pedidos
        if (!nuevoPedido.getProductos().isEmpty()) {
            Pedido guardado = pedidoService.crearPedido(nuevoPedido);
            System.out.println("\n Pedido #" + guardado.getId() + " finalizado.");
            System.out.println("Total a pagar: $" + guardado.getTotal());
        } else {
            System.out.println("Pedido cancelado (no se agregaron productos).");
        }
    }
    public void listarPedidos() {
        System.out.println("--- Lista de Pedidos ---");
        List<Pedido> pedidos = pedidoService.listarPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos realizados.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }

}
