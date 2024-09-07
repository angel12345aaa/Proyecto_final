/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.io.BufferedWriter;
import java.util.List;

/**
 *
 * @author angel
 */
public class ProductoRepositorio extends SuperRepositorio {
    
    private final static String NOMBRE_ARCHIVO_PRODUCTOS = "productos";
    
    public ProductoRepositorio() {
        super(NOMBRE_ARCHIVO_PRODUCTOS);
    }
}
