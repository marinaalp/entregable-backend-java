import java.util.Scanner;

import productos.Bebida;
import productos.Comida;
import service.ProductoService;
import util.Validador;
import service.PedidoService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ProductoService service = new ProductoService();
        PedidoService pedidoService = new PedidoService();
        Menu menu = new Menu(scanner, service, pedidoService);

        System.out.println("Bienvenido al sistema de gestión de productos y pedidos");
        int opcion = 0;
        cargarDatosIniciales(service);
        boolean mostrarMenu = true;
        
        while (opcion != 8) {
            if (mostrarMenu) {
                menu.mostrarMenu();
            }

            System.out.println("Seleccione una opción:");
            opcion = Validador.leerEntero(scanner, "Ingrese el número de la opción: ");
            menu.seleccionarOpcion(opcion);
            if (opcion != 8) {
            String respuesta = Validador.leerTexto(scanner, "¿Desea volver a ver el menú de opciones? (s/n): ");
            
            // Si responde 's', mostrarMenu será true; de lo contrario, false
            mostrarMenu = respuesta.equalsIgnoreCase("s");
        }
        }
    }

    private static void cargarDatosIniciales(ProductoService service) {
        service.cargarProducto(new Comida("Hamburguesa", 500.0, 10, "comida", 250.0));
        service.cargarProducto(new Comida("Papas Fritas", 200.0, 20, "comida", 150.0));
        service.cargarProducto(new Bebida("Coca Cola", 150.0, 30, "bebida", 330.0));
        service.cargarProducto(new Bebida("Agua Mineral", 100.0, 40, "bebida", 500.0));
    }
}
