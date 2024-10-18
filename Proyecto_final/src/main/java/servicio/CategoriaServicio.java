/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Categoria;
import repositorio.CategoriaRepositorio;

/**
 *
 * @author angel
 */
public class CategoriaServicio {
     private final CategoriaRepositorio repo = new CategoriaRepositorio();
    private final Scanner scanner = new Scanner(System.in);

    public void guardarCategoria() {
        try {
            Categoria categoria = new Categoria();
            System.out.println("INGRESA UN CODIGO PARA LA CATEGORIA");
            final int codigo = scanner.nextInt();
            categoria.setCodigo(codigo);
            System.out.println("INGRESE LA DESCRIPCION DE LA CATEGORIA");
            final String descripcion = scanner.next();
            categoria.setDescripcion(descripcion);

            int resultado = repo.guardarLinea(categoria.toString());
            if (resultado > 0) {
                System.out.println("CATEGORIA GUARDADA CORRECTAMENTE");
            } else {
                System.out.println("ERROR AL GUARDAR LA CATEGORIA");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error ingrese un dato adecuado");
        }

    }

    public void imprimirCategorias() {
        repo.obtenerTodos().forEach(linea -> System.out.println(linea));
    }

}
