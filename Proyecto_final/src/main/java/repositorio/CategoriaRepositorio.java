/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.util.List;
import repositorio.modelo.Categoria;

/**
 *
 * @author angel
 */
public class CategoriaRepositorio extends SuperRepositorio {
    
    private static final String NOMBRE_ARCHIVO_CATEGORIAS = "categorias";
    
    public CategoriaRepositorio() {
        super(NOMBRE_ARCHIVO_CATEGORIAS);
    }

    public int guardarCategoria(Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Categoria> obtenerCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
