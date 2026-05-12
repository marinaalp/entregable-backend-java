import java.util.Scanner;

public class Menu {
    private final Scanner sc;
    Menu(Scanner scanner) {
        this.sc = scanner;
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
                System.out.println("Agregar producto");
                break;  
            case 2:
                System.out.println("Listar productos");
                break;
            case 3:
                System.out.println("Buscar/Actualizar producto");
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
        } catch (Exception e) {
            // TODO: handle exception
        }
       
    }
    public void imagenSalida(){
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
    }
