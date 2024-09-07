package tienda;// declaracion del paquete , declara que esta clase pertenece a Tienda 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;//importaciones de entrada y salida 

/**
 * Clase para manejar el sistema de login. Incluye métodos para verificar y
 * crear un usuario administrador.
 */
public class LoginSystem {
//rutas de archivo en donde se guardaran los datos
    private static final String ARCHIVO_USUARIOS = "C:/Tienda/usuariosTienda.txt";
    private static final String ARCHIVO_PRODUCTOS = "C:/Tienda/productosTienda.txt";

    public static Date date = new Date();//almacenamiento de fecha y hora actual

    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String CARACTERES = "#$%&:;.*";

    /**
     * Verifica si existe un administrador en el archivo de usuarios.
     *
     * @return true si existe un administrador, false en caso contrario.
     */
    public static boolean adminExists() {
        try (FileReader fileReader = new FileReader(ARCHIVO_USUARIOS); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linea;//lee el archivo linea por linea 
            while ((linea = bufferedReader.readLine()) != null) {
                if (linea.contains("Administrador")) {
                    return true;
                }
            }
        } catch (IOException ex) {//variable para mostrar un mensaje de error 
            System.err.println("Error al leer el archivo de usuarios: " + ex.getMessage());
        }
        return false;
    }

    /**
     * Crea un usuario administrador y lo guarda en el archivo de usuarios.
     */
    public static void crearAdmin() {
        String contrasenia = JOptionPane.showInputDialog(null,
                "Sistema de gestion de inventariods\n\nIngrese una contraseña para el usuario Admin:");
        if (contrasenia == null || contrasenia.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.");
            return;
        }

        String nombresCompletos = JOptionPane.showInputDialog(null, "Ingrese nombre de admin:");
        if (nombresCompletos == null || nombresCompletos.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            return;
        }

        String apellidosCompletos = JOptionPane.showInputDialog(null, "Ingrese apellido de admin:");
        if (apellidosCompletos == null || apellidosCompletos.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío.");
            return;
        }

        String correo = JOptionPane.showInputDialog(null, "Ingrese correo de admin:");
        if (correo == null || correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.");
            return;
        }

        Usuario usuario = new Usuario(nombresCompletos, apellidosCompletos, correo, contrasenia,
                "Administrador - agrrgar articulos  - eliminar articulos  - ventas ",
                "Activo");

//        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ARCHIVO_USUARIOS, true)))) {
//            writer.write(usuario.getNombresCompletos() + ","
//                    + usuario.getApellidosCompletos() + ","
//                    + usuario.getCorreo() + ","
//                    + usuario.getContrasenia() + ","
//                    + usuario.getRol() + ","
//                    + usuario.getStatus() + "\n");
//            System.out.println("El usuario administrador ha sido creado");
//        } catch (IOException ex) {
//            System.err.println("Error al escribir en el archivo de usuarios: " + ex.getMessage());
//        }
    }
}
