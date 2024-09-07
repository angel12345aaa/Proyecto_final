package tienda;

/**
 * Clase que representa a un usuario en el sistema. Extiende de la clase Persona.
 */
public class Usuario {  // Asegúrate de que el nombre de la clase base sea Persona (con P mayúscula)
    
    private String correo;
    private String contrasenia;
    private String status;
    private String rol;
    
    // Constructor por defecto
    public Usuario() {
        super();  // Llama al constructor de la clase base
    }
  
    // Constructor con parámetros específicos (para la creación básica de usuario)
    public Usuario(String correo, String contrasenia, String status, String rol) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.status = status;
        this.rol = rol;
    }
    
    // Constructor con nombre completo y apellidos
    public Usuario(String nombresCompletos, String apellidosCompletos) {
        //super(nombresCompletos, apellidosCompletos);
    }
    
    // Constructor completo con todos los parámetros
    public Usuario(String nombresCompletos, String apellidosCompletos, String correo, String contrasenia, String rol, String status) {
       // super(nombresCompletos, apellidosCompletos);
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.status = status;
        this.rol = rol;
    }
     
    // Constructor con todos los parámetros, incluyendo CUI y sexo
    public Usuario(String correo, String contrasenia, String status, String rol, String nombresCompletos, String apellidosCompletos, String CUI, String sexo) {
        //super(nombresCompletos, apellidosCompletos, CUI, sexo);
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.status = status;
        this.rol = rol;
    }

    // Métodos getter y setter
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Métodos para obtener nombre completo y apellidos (debe estar implementado en la clase base Persona)
//    @Override
//    public String getNombresCompletos() {
//        return super.getNombresCompletos();  // Suponiendo que la clase base Persona tiene el método getNombresCompletos()
//    }
//
//    @Override
//    public String getApellidosCompletos() {
//        return super.getApellidosCompletos();  // Suponiendo que la clase base Persona tiene el método getApellidosCompletos()
//    }
}
