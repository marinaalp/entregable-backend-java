import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // 1) Agregar producto
        // 2) Listar productos
        // 3) Buscar/Actualizar producto
        // 4) Eliminar producto
        // 5) Crear un pedido
        // 6) Listar pedidos
        // 7) Salir

        // Elija una opción:

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de gestión de productos y pedidos");
        System.out.println("Menú de opciones:");
        Menu menu = new Menu();
        menu.mostrarMenu();

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            menu.seleccionarOpcion(opcion);
        }
    }
}
