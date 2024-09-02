
package TIENDA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class loginSystem {
    private static String ARCHIVO_usuarios = "C:/Tienda/usuariosTienda.txt";// crear archivos para guardar en txt 
    private static String ARCHIVO_productos = "C:/Tienda/productosTienda.txt";
    
    private static BufferedWriter Fescribe;// escribir dentro del archivo
    private static BufferedReader leer;
    private static FileReader Fleer;
    public static Date date = new Date();
    
    //Sets de caracteres disponibles con los que construir contraseñas
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //creacion de contraseña para acceso al sistema
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz"; 
    private static final String NUMEROS = "0123456789";
    private static final String CARACTERES = "#$%&:;.*";
    
    
     public static Boolean AdminExists(){
        
        try
        { 
           Fleer = new FileReader(ARCHIVO_usuarios);
           leer = new BufferedReader(Fleer);
            String linea="";
            while((linea=leer.readLine())!=null)
            {
                if (linea.indexOf("Administrador")!=-1)
                {
                   return true;
                }
            }              
        }
         
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
         return false;
    }
     

    public static  void CrearAdmin(){
         
         Usuario usuario = new Usuario();
         
         usuario.setContrasena(JOptionPane.showInputDialog(null,"Sistema de Votaciones "
                + "                                  \n\n  Ingrese una contraseña para el usuario Admin "));
         
         
         usuario.setNombres_completos(JOptionPane.showInputDialog(null,"Ingrese nombre de admin"));
         usuario.setApellidos_completos(JOptionPane.showInputDialog(null,"Ingrese apellido de admin"));
         usuario.setCorreo(JOptionPane.showInputDialog(null,"Ingrese correo de admin"));
         usuario.setRol("Administrador - Registradores de votantes - Votante - Auditor");
         usuario.setEstatus("Activo");
         
         try{
                Fescribe =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ARCHIVO_Usuarios,true)));
            
                //guarda en la base de datos los archivos 
                Fescribe.write(usuario.getNombres_completos()+","+usuario.getApellidos_completos()+","+
                           usuario.getCorreo()+","+usuario.getContrasena()+","+usuario.getRol()+","+usuario.getEstatus()+"\n");  
            
                   
                System.out.println("El producto ha sido insertado en la base de datos");
                Fescribe.close();//cerrar el fichero y que los datos se queden escritos
                
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }   
    }
     
     
     
     
}
