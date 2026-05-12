package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    public static void validarNombre(String nombre) throws IllegalArgumentException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public static void validarPrecio(double precio) throws IllegalArgumentException {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public static void validarStock(int stock) throws IllegalArgumentException {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    public static void validarCategoria(String categoria) throws IllegalArgumentException {
        if (!categoria.equalsIgnoreCase("comida") && !categoria.equalsIgnoreCase("bebida")) {
            throw new IllegalArgumentException("La categoría debe ser 'comida' o 'bebida'");
        }
    }

    // lectura de datos de consola, si el usuario ingresa un valor distinto a un
    // numero, vuelve en bucle a pedir que se ingrese el dato
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpia el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println(" Debe ingresar un número entero. Intente nuevamente.");
                sc.nextLine(); // descarta lo que el usuario escribió mal
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine(); // limpia el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println(" Debe ingresar un número decimal. Intente nuevamente.");
                sc.nextLine(); // descarta lo que el usuario escribió mal
            }
        }
    }

    public static void validarMl(double ml) throws IllegalArgumentException {
        if (ml <= 0) {
            throw new IllegalArgumentException("El contenido en ml debe ser mayor a cero");
        }
    }

    public static void validarGramos(double gramos) throws IllegalArgumentException {
        if (gramos <= 0) {
            throw new IllegalArgumentException("El peso en gramos debe ser mayor a cero");
        }
    }
}
