package tienda;

import Usuario.Articulo;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal para gestionar la tienda.
 */
public class Tienda {

    private String nombreTienda;
    private static final Hashtable<String, Articulo> lista = new Hashtable<>();

    public Tienda(String nombre) {
        this.nombreTienda = nombre;
    }

    /**
     * Método para añadir artículos al sistema.
     */
    public void insertar(Articulo a) {
        String clave = a.getNombre();
        if (!lista.containsKey(clave)) {
            lista.put(clave, a);
            System.out.println("Se ha añadido el artículo al sistema.");
        } else {
            System.out.println("Error: el artículo ya fue ingresado antes.");
        }
    }

    /**
     * Busca un artículo en la lista de artículos.
     */
    public Articulo busca(String nombre) {
        if (lista.containsKey(nombre)) {
            Articulo a = lista.get(nombre);
            System.out.println("Artículo encontrado.");
            return a;
        } else {
            System.out.println("Artículo no encontrado.");
            return null;
        }
    }

    /**
     * Vende un artículo.
     */
    public double vende(String nombre, int numero) {
        Articulo a = busca(nombre);
        if (a == null) {
            return -1; // Error: artículo no encontrado
        }
        if (a.vendido(numero)) {
            double vendido = numero * a.getPrecioUnidad();
            if (a.getCantidad() == 0) {
                lista.remove(nombre);
            }
            return vendido;
        } else {
            return -1; // Error: no hay suficiente stock
        }
    }

    /**
     * Muestra el menú principal.
     */
    public static void menu() {
        System.out.println("1. Añadir un artículo");
        System.out.println("2. Mostrar todos los artículos");
        System.out.println("3. Buscar un artículo");
        System.out.println("4. Ventas");
        System.out.println("5. Salir del programa");
        System.out.println("Seleccione una opción");
    }

    /**
     * Mensaje de salida del programa.
     */
    public static void salir() {
        System.out.println("Saliendo del programa...");
    }

    public  void main(String[] args) {
        System.out.println("****Sistema de gestión de tienda*****");
        System.out.println("************************************");
        Scanner sc = new Scanner(System.in);
        Tienda mi_tienda = new Tienda("Tienda Angel");
        int opcion = 0;

        do {
            try {
                menu();
                opcion = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1: {
                        System.out.println("Nombre del artículo: ");
                        String nombre = sc.nextLine();

                        System.out.println("Introduzca la cantidad: ");
                        int cantidad = sc.nextInt();

                        System.out.println("Precio por unidad: ");
                        double precioUnidad = sc.nextDouble();
                        sc.nextLine(); // Consumir el salto de línea

                        Articulo aux = new Articulo(nombre, cantidad, precioUnidad);
                        mi_tienda.insertar(aux);
                        break;
                    }
                    case 2:
                        Enumeration<String> e = lista.keys();
                        System.out.println("Número de artículos:");
                        while (e.hasMoreElements()) {
                            String clave = e.nextElement();
                            Articulo Articulo = lista.get(clave);
                            System.out.println(Articulo);
                        }
                        break;
                    case 3: {
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        Articulo producto = mi_tienda.busca(nombre);
                        if (producto != null) {
                            System.out.println("Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad() + ", Precio unidad: " + producto.getPrecioUnidad() + " Q.");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.println("Cantidad: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine(); // Consumir el salto de línea

                        double venta = mi_tienda.vende(nombre, cantidad);
                        if (venta >= 0) {
                            System.out.println("Total de la venta: " + venta + " Q.");
                        } else {
                            System.out.println("Error en la venta.");
                        }
                        break;
                    }
                    case 5:
                        salir();
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                sc.nextLine(); // Consumir el salto de línea
                System.err.println("Error de entrada de datos. Teclee una opción válida.");
            }
        } while (opcion != 5);
    }
}