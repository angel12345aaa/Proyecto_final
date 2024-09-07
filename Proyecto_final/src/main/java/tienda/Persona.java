/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author angel
 */
public class Persona {

    private String nombres_completos;
    private String apellidos_completos;
    private String CUI;
    private String sexo;

    public Persona() {
    }

    public Persona(String nombres_completos, String apellidos_completos, String CUI, String sexo) {
        this.nombres_completos = nombres_completos;
        this.apellidos_completos = apellidos_completos;
        this.CUI = CUI;
        this.sexo = sexo;
    }

    public String getNombres_completos() {
        return nombres_completos;
    }

    public void setNombres_completos(String nombres_completos) {
        this.nombres_completos = nombres_completos;
    }

    public String getApellidos_completos() {
        return apellidos_completos;
    }

    public void setApellidos_completos(String apellidos_completos) {
        this.apellidos_completos = apellidos_completos;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "persona{" + "nombres_completos=" + nombres_completos + ", apellidos_completos=" + apellidos_completos + ", CUI=" + CUI + ", sexo=" + sexo + '}';
    }

    String getNombresCompletos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getApellidosCompletos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
