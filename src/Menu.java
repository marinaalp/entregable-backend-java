import java.util.List;
import java.util.Scanner;

import excepciones.ProductoNoEncontradoException;
import productos.Comida;
import productos.Producto;
import productos.Bebida;
import service.ProductoService;
import util.Validador;

public class Menu {
    private final Scanner sc;
    private final ProductoService service;

    Menu(Scanner scanner, ProductoService service) {
        this.sc = scanner;
        this.service = service;
    }

    public void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar/Actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Crear un pedido");
        System.out.println("6) Listar pedidos");
        System.out.println("7) Salir");
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
                    System.out.println("Actualizar producto");
                    break;
                case 4:
                    System.out.println("Eliminar producto");
                    break;
                case 5:
                    System.out.println("Crear un pedido");
                    break;
                case 6:
                    System.out.println("Listar pedidos");
                    break;
                case 7:
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
                Producto guardado = service.cargarProducto(comida); // Se guarda como Producto
                System.out.println("Comida " + guardado.getId() + " agregada con éxito.");

            } else if (categoria.equalsIgnoreCase("bebida")) {
                double ml = Validador.leerDouble(sc, "Ingrese los ml: ");
                Bebida bebida = new Bebida(nombre, precio, stock, categoria, ml);
                Producto guardado = service.cargarProducto(bebida); // Se guarda como Producto
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
        List<Producto> lista = service.listarTodos();
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
        Producto producto = service.obtenerPorId(id);
        System.out.println("Producto encontrado: " + producto);

    }
}
