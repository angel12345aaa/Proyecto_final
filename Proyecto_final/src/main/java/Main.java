
import java.util.InputMismatchException;
import java.util.Scanner;
import servicio.CategoriaServicio;
import servicio.ProductoServicio;



public class Main {

    /**
     * Escaner para ingreso de datos
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Informaciön basica para login
     */
    private static final String ROL_ADMIN = "admin";
    private static final String ROL_CAJERO = "cajero";
    private static boolean esAdmin = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (login()) {
            menuPrincipal();
        }
    }

    public static boolean login() {

        System.out.print("INGRESE SU CARNET PARA ACCEDER AL SISTEMA: ");
        String carnet = scanner.nextLine().trim();

        if (ROL_ADMIN.equalsIgnoreCase(carnet)) {
            System.out.println("Bienvenido al sistema, usted accedio como administrador. \n");
            esAdmin = true;
            return true;  // El login es exitoso
        } else if (ROL_CAJERO.equalsIgnoreCase(carnet)) {
            System.out.println("Bienvenido al sistema, usted accedio como cajero.\n");
            esAdmin = false;
            return true;  // El login es exitoso
        } else {
            System.out.println("Clave incorrecta. Intentelo de nuevo. \n");
            return false; // El login falló
        }
    }

    public static void menuPrincipal() {

        //this.articulosvc.crearArticulo();
        if (esAdmin) {
            mostrarMenuAdmin();
        } else {
            mostrarMenuCajero ();
        }
    }

   public static void mostrarMenuCajero(){
       CategoriaServicio categoriaServicio =new CategoriaServicio();
       ProductoServicio produtoServicio = new ProductoServicio();
       
       int opcion =0;
        do {
            System.out.println("[1] Categorias Existentes ");
            System.out.println("[2] Productos Existentes ");
            System.out.println("[3] POS");
            System.out.println("[4] Salir del Sistema");
            try {opcion = scanner.nextInt();
            scanner.nextLine(); 
            
           switch (opcion){
               case 1:
                   categoriaServicio.imprimirCategorias();
               case 2:
                   produtoServicio.impresionProductos();
                   default:
                    System.out.println("Opcion no válida.");
            }
            }catch(InputMismatchException ex){
                System.out.println("Opcion ivalida solo acepta digitos");
            }
           
            
        
   }while(opcion != 0);
     }
    
    
    
    
    
    public static void mostrarMenuAdmin() {
        int opcion =0;
        do {
            System.out.println("[1] Gestion de Categorias");
            System.out.println("[2] Gestion de Producto");
            System.out.println("[4] Gestion de Ventas");
            System.out.println("[0] Salir");
            System.out.print("Seleccione una opcion: ");
            try {opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    gestionDeCategorias();
                    break;
                case 2:
                    gestionDeProductos();
                    break;
                case 3:
                    // mostrarProductos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
            }catch(InputMismatchException ex){
                System.out.println("Opcion ivalida solo acepta digitos");
            }
            
            
            
        } while (opcion != 0);
    }

    public static void gestionDeCategorias() {
        CategoriaServicio servicio = new CategoriaServicio();
        System.out.println("[1] Añadir Categorias ");
        System.out.println("[2] Ver Categorias Existentes ");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                servicio.guardarCategoria();
                break;
            case 2:
                servicio.imprimirCategorias();
                break;
            default:
                System.out.println("LA OPCION NO EXISTE");
        }
    }

    public static void gestionDeProductos() {
        // Servicio para productos
        ProductoServicio servicio = new ProductoServicio();
        System.out.println("[1] Anadir productos ");
        System.out.println("[2] Buscar producto por codigo");
        System.out.println("[3] Actualizar producto");
        System.out.println("[4] Eliminar producto");
        System.out.println("[5] Ver lista de producto");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                servicio.guardarProducto();
                break;
            case 2:
                servicio.buscarProductoPorCodigo();
                break;
            case 3:
                servicio.actualizarProductoPorCodigo();
                break;
            case 4:
                servicio.eliminarProducto();
                break;
            case 5 :
                servicio.impresionProductos();
            default:
                System.out.println("LA OPCIÓN NO EXISTE");
        }
    }
}



