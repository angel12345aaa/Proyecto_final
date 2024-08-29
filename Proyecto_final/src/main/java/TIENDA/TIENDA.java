package TIENDA;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class TIENDA {

    String nombreTienda;

    static Hashtable<String, articulo> lista = new Hashtable<>();

    public TIENDA(String nombre) {

        this.nombreTienda = nombre;
    }

    /*
    metodo para añadir articulos al sistema 
     */
    public void insertar(articulo a) {

        String clave = a.getNombre();

        if (!lista.containsKey(clave)) {//si contiene la clave 
            lista.put(clave, a);
            System.out.println(" Se ha añadido el articulo al sistema ");
        } else {
            System.out.println(" error , el articulo ya fue ingresado antes ");
        }

    }

    public articulo busca(String nombre) {//buscar un articulo en la lista de articulos agregados 

        articulo a;

        if (lista.containsKey(nombre)) {
            a = (articulo) lista.get(nombre);

            System.out.println("Articulo encontado ");

            return a;

        } else {
            System.out.println("Articulo no encontrado ");
        }
        return null;
    }

    public double vende(String nombre, int numero) {

        articulo a = busca(nombre);
        double vendido = 0;

        if (a == null) {
            vendido = -1;
        } else if (a.vendido(numero)) {
            vendido = numero * a.getprecioUnidad();//precio del articulo

            if (a.getCantidad() == 0) {
                lista.remove(nombre);
            }
        }
        return vendido;
    }

    public static void menu() {//
        System.out.println("1. Añadir un articulo ");
        System.out.println("2. mostrar todos los articulos ");
        System.out.println("3. buscar un articulo  ");
        System.out.println("4. ventas  ");
        System.out.println("5. salir del programa ");
        System.out.println("Seleccione una opcion  ");
    }

    public static void salir() {
        System.out.println("saliendo del programa..... ");
    }

    public static void main(String[] args) {
        System.out.println("****Sitema de gestion de tienda*****");
        System.out.println("************************************");
        Scanner sc = new Scanner(System.in);
        TIENDA mi_tienda = new TIENDA("tienda angel ");
        int opcion = 0;

        do {
            try {
                menu();//try en caso de que se ingresen puntos comas etc 
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1: {
                        String cad;
                        sc.nextLine();
                        System.out.println("Nombre del articulo: ");
                        String nombre = sc.nextLine();

                        System.out.println("intruduzca la cantidad ");
                        cad = sc.nextLine();
                        int cantidad = Integer.parseInt(cad);

                        System.out.println("precio por unidad");
                        cad = sc.nextLine();
                        double precioUnidad = Double.parseDouble(cad);

                        articulo aux = new articulo(nombre, cantidad, precioUnidad);
                        mi_tienda.insertar(aux);

                        break;
                    }
                    case 2:
                        Object clave;
                        articulo Articulo;
                        Enumeration e = lista.keys();

                        System.out.println("numero de articulos ");

                        while (e.hasMoreElements()) {
                            clave = e.nextElement();
                            Articulo = (articulo) lista.get(clave);
                            System.out.println(Articulo.getArticulo());
                        }
                        break;

                    case 3: //mostrar un articulo 
                    {
                        String cad;
                        sc.nextLine();
                        System.out.println(" nombre: ");
                        cad = sc.nextLine();

                        articulo producto = mi_tienda.busca(cad);
                        if (producto != null) {
                            System.out.println("Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad() + ", Precio unidad: " + producto.getPrecioUnidad() + " Q.");
                            System.out.println("");
                        }
                        break;
                    }
                    case 4: {
                        String cad;
                        sc.nextLine();
                        System.out.println("nombre: ");
                        cad = sc.nextLine();

                        System.out.println("cantidad: ");
                        int cantidad = sc.nextInt();

                        double venta = mi_tienda.vende(cad, cantidad);

                        if (venta != 0 && venta != 1) {
                            System.out.println("total de la venta:  " + venta + "Q");
                        }
                        
                        break;
                    }
                }
                } catch (InputMismatchException e) {//error de entrada 
                    sc.nextLine();
                    System.err.println("error de entrada de datos, teclee una opcion valida.");
                }
                                                       
        } while(opcion != 5);
        
        
    salir();
    
    }
}
