import java.util.List;
import java.util.Scanner;
import repositorio.CategoriaRepositorio;
import repositorio.ProductoRepositorio;
import repositorio.modelo.Categoria;
import repositorio.modelo.Producto;

public class Main {
    
    private final Scanner scanner = new Scanner(System.in);
    private boolean esAdmin = false;
//rutas de archivo en donde se guardaran los datos
    private static final String ARCHIVO_categorias = "C:/Tienda/categoriasTienda.txt";
    private static final String ARCHIVO_productos = "C:/Tienda/productosTienda.txt";

    public static void main(String[] args) {
        Main mainApp = new Main();
        if (mainApp.login()) {
            mainApp.menuPrincipal();
        }
    }

    public boolean login() {
        System.out.print("INGRESE SU CARNET PARA ACCEDER AL SISTEMA: ");
        String carnet = scanner.nextLine();
        
        // Claves de acceso predefinidas
        String claveAdmin = "admin"; 
        String claveCajero = "cajero12"; 
        
        if (carnet.equals(claveAdmin)) {
            System.out.println("Bienvenido al sistema, usted accedio como administrador.");
            esAdmin = true;
            return true;  // El login es exitoso
        } else if (carnet.equals(claveCajero)) {
            System.out.println("Bienvenido al sistema, usted accedio como cajero.");
            esAdmin = false;
            return true;  // El login es exitoso
        } else {
            System.out.println("Clave incorrecta. Intentelo de nuevo.");
            return false; // El login falló
        }
    }

    public void menuPrincipal() {
        if (esAdmin) {
            mostrarMenuAdmin();
        } else {
            mostrarMenuCajero();
        }
    }

    public void mostrarMenuAdmin() {
        int opcion;
        do {
            System.out.println("[1] Agregar Categoria");
            System.out.println("[2] Agregar Producto");
            System.out.println("[3] Mostrar Categorias");
            System.out.println("[4] Mostrar Productos");
            System.out.println("[0] Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    agregarCategoria();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    mostrarCategorias();
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        } while (opcion != 0);
    }

    public void mostrarMenuCajero() {
        int opcion;
        do {
            System.out.println("[1] Mostrar Categorias");
            System.out.println("[2] Mostrar Productos");
            System.out.println("[0] Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    mostrarCategorias();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no válida.");
            }
        } while (opcion != 0);
    }

    public void agregarCategoria() {
        System.out.print("Ingrese el nombre de la categoria: ");
        String nombre = scanner.nextLine();

        Categoria categoria = new Categoria(0, nombre); // ID se asigna automáticamente
        CategoriaRepositorio repo = new CategoriaRepositorio();
        int id = repo.guardarCategoria(categoria);

        System.out.println("Categoría guardada con ID: " + id);
    }

    public void agregarProducto() {
        Producto producto = new Producto();
        
        System.out.print("Ingrese el codigo del producto: ");
        producto.setCodigo(scanner.nextInt());
        scanner.nextLine(); // Consumir la nueva línea
        
        System.out.print("Ingrese el color del producto: ");
        producto.setColor(scanner.nextLine());
        
        System.out.print("Ingrese el peso del producto: ");
        producto.setPeso(scanner.nextFloat());
        
        System.out.print("Ingrese el precio del producto: ");
        producto.setPrecio(scanner.nextFloat());
        scanner.nextLine(); // Consumir la nueva línea
        
        ProductoRepositorio repo = new ProductoRepositorio();
        int resultado = repo.guardarLinea(producto.toString());
        System.out.println("REGISTROS GUARDADOS: " + resultado);
    }

    public void mostrarCategorias() {
        CategoriaRepositorio repo = new CategoriaRepositorio();
        List<Categoria> categorias = repo.obtenerCategorias();

        if (categorias.isEmpty()) {
            System.out.println("No hay categorias registradas.");
        } else {
            for (Categoria categoria : categorias) {
                System.out.println(categoria);
            }
        }
    }

    public void mostrarProductos() {
        ProductoRepositorio repo = new ProductoRepositorio();
       
    }
}
