/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;


import java.util.Scanner;
import modelo.Producto;
import repositorio.ProductoRepositorio;

/**
 *
 * @author angel
 */
public class ProductoServicio {
     private final ProductoRepositorio repo = new ProductoRepositorio();

    private final Scanner scanner;

    public ProductoServicio() {
        this.scanner = new Scanner(System.in);
    }

    public void guardarProducto() {

        Producto producto = new Producto();

        System.out.println("[ENTRADA] INGRESE CODIGO DE PRODUCTO");
        String codigo = scanner.nextLine().toUpperCase().trim();

        if (codigo.isEmpty()) {
            System.out.println("[ALERTA] EL CODIGO DE PRODUCTO NO PUEDE ESTAR VACIO");
            return;
        }
        
        String linea = repo.obtenerLinea("codigo", codigo);
        
        if (linea == null) {
            producto.setCodigo(codigo);

            System.out.println("[ENTRADA] INGRESE UNA DESCRIPCIÓN DEL PRODUCTO:");
            producto.setDescripcion(scanner.nextLine().toUpperCase().trim());

            System.out.println("[ENTRADA] INGRESE PRECIO DE PRODUCTO:");
            producto.setPrecio(scanner.nextFloat());

            // Guardar información en el repositorio
            int resultado = repo.guardarLinea(producto.toString());

            if (resultado == 1) {
                System.out.println("[INFO] PRODUCTO GUARDADO CORRECTAMENTE");
            } else {
                System.out.println("[ERROR] NO SE PUDO GUARDAR EL PRODUCTO");
            }
        }else{
            System.out.println("[ALERTA] EL CODIGO INGRESADO YA PERTENECE AL PRODUCTO [" + linea + "]");
        }

    }

    public void buscarProductoPorCodigo() {
        System.out.println("[ENTRADA] INGRESE EL CÓDIGO DE PRODUCTO A BUSCAR");
        String codigo = scanner.nextLine().toUpperCase().trim();

        String linea = repo.obtenerLinea("codigo", codigo);
        if (linea == null) {
            System.out.println("[ALERTA] NINGUN PRODUCTO PERTENECE AL CODIGO " + codigo.toUpperCase());
        }
        System.out.println("PRODUCTO: [" + linea + "]");
    }

    public void actualizarProductoPorCodigo() {
        System.out.println("[ENTRADA] INGRESE CODIGO DE PRODUCTO A ACTUALIZAR");
        String codigo = scanner.nextLine().toUpperCase().trim();
        String linea = repo.obtenerLinea("codigo", codigo);
        if (linea == null) {
            System.out.println("[ALERTA] NINGUN PRODUCTO PERTENECE AL CODIGO" + codigo);
        } else {
            System.out.println("[INFO] PRODUCTO A ACTUALIZAR: [" + linea + "]");
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            System.out.println("[ENTRADA] INGRESE UNA NUEVA DESCRIPCION");
            String descripcion = scanner.nextLine().toUpperCase().trim();
            producto.setDescripcion(descripcion);
            System.out.println("[ENTRADA] INGRESE UN NUEVO PRECIO");
            float precio = scanner.nextFloat();
            producto.setPrecio(precio);
            int registros = repo.actualizarLinea("codigo", codigo, producto.toString());
            if (registros > 0) {
                System.out.println("[INFO] PRODUCTO ACTUALIZADO");

            } else {
                System.out.println("[ERROR] NO SE PUDO ACTUALIZAR EL PRODUCTO");
            }
        }

    }

    public void impresionProductos() {
        repo.obtenerTodos().forEach(producto -> System.out.println(producto));
    }
    
    public void eliminarProducto(){
        System.out.println("[ENTRADA] INGRESE EL CODIGO DE PRODUCTO A ELIMINAR");
        String codigo = scanner.next();
        String linea = repo.obtenerLinea("codigo", codigo);
        System.out.println("PRODUCTO A ELIMINAR [" + linea + "]");
        System.out.println("[PREGUNTA] ¿ESTAS SEGURO DE ELIMINAR EL PRODUCTO? S/N");
        String respuesta = scanner.next().trim();
        if ("S".equalsIgnoreCase(respuesta)) {
            repo.eliminarLinea("codigo", codigo);
        }else{
            System.out.println("[INFO] PROCESO DE ELIMINACION CANCELADO");
        }
    }

}
