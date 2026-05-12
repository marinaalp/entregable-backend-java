import java.util.Scanner;

import productos.Bebida;
import productos.Comida;
import productos.Producto;
import service.ProductoService;
import util.Validador;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        ProductoService service = new ProductoService();
        System.out.println("Bienvenido al sistema de gestión de productos y pedidos");
        // menu.mostrarMenu();
        int opcion = 0;
        cargarDatosIniciales(service);

        while (opcion != 7) {
            menu.mostrarMenu();
            System.out.println("Seleccione una opción:");
            opcion = Validador.leerEntero(scanner, "Ingrese el número de la opción: ");
            //opcion = scanner.nextInt();
            menu.seleccionarOpcion(opcion);
        }
    }

    private static void cargarDatosIniciales(ProductoService service) {
        service.cargarProducto(new Comida("Hamburguesa", 500.0, 10, "comida", 250.0));
        service.cargarProducto(new Comida("Papas Fritas", 200.0, 20, "comida", 150.0));
        service.cargarProducto(new Bebida("Coca Cola", 150.0, 30, "bebida", 330.0));
        service.cargarProducto(new Bebida("Agua Mineral", 100.0, 40, "bebida", 500.0));
    }
}
