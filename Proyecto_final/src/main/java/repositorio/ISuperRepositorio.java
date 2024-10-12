package repositorio;

import java.util.List;

/**
 *
 * @author angel
 */
public interface ISuperRepositorio {
    
   int guardarLineas(List<String> listaLineas);
    
    int guardarLinea(String linea);
    
    int actualizarLinea(String key, String value, String linea);
    
    int eliminarLinea(String key, String value);
    
    String obtenerLinea(String key, String value);
    
    List<String> obtenerTodos();

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
