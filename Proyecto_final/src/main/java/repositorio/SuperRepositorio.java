
package repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class SuperRepositorio implements ISuperRepositorio {//metodos a implementar en isuper

       // El nombre del archivo que se va a guardar 
    private final File directorio_maestro;

    // Metodo constructor de clase
    @SuppressWarnings("empty-statement")

    public SuperRepositorio(String nombre_archivo_maestro) {;
        // ruta del archivp actual creandolo en repo
        this.directorio_maestro = new File(System.getProperty("user.dir") + "/repo/" + nombre_archivo_maestro + ".dbf");
    }

    @Override
    public int guardarLineas(List<String> listaLineas) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(directorio_maestro.getAbsolutePath(), true))) {
            for (String linea : listaLineas) {//recorre linea por linea 
                buffer.write(linea);
                buffer.newLine();
            }
            return listaLineas.size();
        } catch (IOException ex) {//depuracion de errores
            Logger.getLogger(SuperRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int guardarLinea(String linea) {//guardar una linea en el archivo
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(directorio_maestro.getAbsolutePath(), true))) {
            buffer.write(linea);
            buffer.newLine();
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public int actualizarLinea(String key, String value, String nuevaLinea) {//reemplazamientos
        List<String> lineas = obtenerTodos();
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(directorio_maestro.getAbsolutePath(), false))) {
            
            
            for (String linea : lineas) {
                String[] columnas = linea.split("\\|");
                boolean busqueda = false;
                for (String columnaRegistro : columnas) {
                    
                    String[] valores = columnaRegistro.split("=");
                    if (key.equalsIgnoreCase(valores[0]) && value.equalsIgnoreCase(valores[1])) {
                        busqueda = true;
                    }
                }
                if (busqueda) {
                    buffer.write(nuevaLinea);
                }
                else{
                    buffer.write(linea);
                }
                buffer.newLine();
            }
            return 1;
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return 0;
    }

    @Override
    public int eliminarLinea(String key, String value) {
        List<String> lineas = obtenerTodos();
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(directorio_maestro.getAbsolutePath(), false))) {
            
            
            for (String linea : lineas) {
                String[] columnas = linea.split("\\|");
                boolean busqueda = false;
                for (String columnaRegistro : columnas) {
                    
                    String[] valores = columnaRegistro.split("=");
                    if (key.equalsIgnoreCase(valores[0]) && value.equalsIgnoreCase(valores[1])) {
                        busqueda = true;
                    }
                }
                if (!busqueda) {//coincidencias escribe la linea 
                    buffer.write(linea);
                }
                buffer.newLine();
            }
            return 1;
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return 0;
    }

    @Override
    public String obtenerLinea(String key, String value) {
        try (BufferedReader br = new BufferedReader(new FileReader(directorio_maestro))) {//abre el archivo en moto lectura
            String linea = null; //almacena las lineas leidas
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\\|");
                for (String columnaRegistro : columnas) {
                    String[] valores = columnaRegistro.split("=");
                    if (key.equalsIgnoreCase(valores[0]) && value.equalsIgnoreCase(valores[1])) {
                        return linea;//linea completa ci cponcide
                    }
                }
            }
            return null;
        } catch (IOException ex) {
            Logger.getLogger(SuperRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public List<String> obtenerTodos() {
        List<String> lineasLista = new ArrayList<>();//lista vacia donde iran todas las lineas 
        try (BufferedReader br = new BufferedReader(new FileReader(directorio_maestro))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLista.add(linea);//linea leida al archivo
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineasLista;
    }
}
