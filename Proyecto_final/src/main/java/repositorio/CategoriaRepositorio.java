package repositorio;

/**
 *
 * @author angel
 */
public class CategoriaRepositorio extends SuperRepositorio {

    private static final String ARCHIVO_NOMBRE = "categorias";
    
    //metodo constructor
    public CategoriaRepositorio() {
        super(ARCHIVO_NOMBRE);
    }
}
