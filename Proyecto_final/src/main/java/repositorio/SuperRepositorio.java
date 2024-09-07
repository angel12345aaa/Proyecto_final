/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class SuperRepositorio implements ISuperRepositorio {

    // El nombre del archivo que se va a cargar
    private final File directorio_maestro;

    // Metodo constructor de clase
    @SuppressWarnings("empty-statement")
    public SuperRepositorio(String nombre_archivo_maestro) {;
        this.directorio_maestro = new File(System.getProperty("user.dir") + "\\repo\\" + nombre_archivo_maestro + ".dbf");
    }

    @Override
    public int guardarLineas(List<String> listaLineas) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(directorio_maestro.getAbsolutePath()))) {
            for (String linea : listaLineas) {
                buffer.write(linea);
                buffer.newLine();
            }
            return listaLineas.size();
        } catch (IOException ex) {
            Logger.getLogger(SuperRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int guardarLinea(String linea) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(directorio_maestro.getAbsolutePath()))) {
            buffer.write(linea);
            buffer.newLine();
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(SuperRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int actualizarLinea(String key, String value) {

        String[] propiedades = value.split(",");

        String valor_buscar = null;

        for (String propiedad : propiedades) {
            String[] valor_propiedad = propiedad.split("=");
            if (key.equals(valor_propiedad[0])) {
                valor_buscar = valor_propiedad[1];
            }
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(directorio_maestro.getAbsoluteFile()));
            List<String> listaArchivo = new ArrayList<>();

            String linea_buffer = reader.readLine();
            while (linea_buffer != null) {
                String[] linea_buffer_propiedades = linea_buffer.split(",");

                for (String linea_buffer_propiedad : linea_buffer_propiedades) {
                    String[] linea_buffer_valores = linea_buffer_propiedad.split("=");
                    if (key.equals(linea_buffer_valores[0]) && valor_buscar.equals(linea_buffer_valores[1])) {
                        listaArchivo.add(value);
                    } else {
                        listaArchivo.add(linea_buffer);
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(directorio_maestro));
                for (String linea : listaArchivo) {
                    writer.write(linea);
                }
                writer.close();
            }
            return 1;
        } catch (IOException ex) {
            Logger.getLogger(SuperRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }finally{
            if (reader != null) {
                try {    
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(SuperRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

    @Override
    public int eliminarLinea(String linea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obtenerLinea(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
