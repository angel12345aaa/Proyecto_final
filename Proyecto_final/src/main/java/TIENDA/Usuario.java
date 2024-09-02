/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TIENDA;

/**
 *
 * @author angel
 */
public class Usuario extends persona {
    
    private String correo;
    private String contrasenia;
    private String status;
    private String rol;
    
    
    public Usuario() {
        
    }
  

    public Usuario(String correo, String contrasena, String estatus, String rol) {
        this.correo = correo;
        this.contrasenia = contrasena;
        this.status = estatus;
        this.rol = rol;
    }
    
    

    public Usuario(String nombres_completos, String apellidos_completos) {
        super(nombres_completos, apellidos_completos);
    }

    
    //Maira,Ibañes,mar@persona.com,1234556,Registrador de votante,activo
     public Usuario(String nombres_completos, String apellidos_completos,String correo, String contrasenia, String rol, String status) {
        super(nombres_completos, apellidos_completos);
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.status = status;
        this.rol = rol;
        
    }
     
      public Usuario(String nombres_completos, String apellidos_completos, String contrasenia, String rol, String status) {
        super(nombres_completos, apellidos_completos);
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.status = status;
        this.rol = rol;
        
    }

    public Usuario(String correo, String contrasena, String estatus, String rol, String nombres_completos, String apellidos_completos, String CUI, String sexo) {
        super(nombres_completos, apellidos_completos, CUI, sexo);
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.status = estatus;
        this.rol = rol;
    }

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
    
    
    
}
