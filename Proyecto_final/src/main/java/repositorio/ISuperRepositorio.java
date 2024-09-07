package repositorio;

import java.util.List;

/**
 *
 * @author angel
 */
public interface ISuperRepositorio {
    
    int guardarLineas(List<String> listaLineas);
    
    int guardarLinea(String linea);
    
    int actualizarLinea(String key, String value);
    
    int eliminarLinea(String linea);
    
    String obtenerLinea(String key, String value);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
