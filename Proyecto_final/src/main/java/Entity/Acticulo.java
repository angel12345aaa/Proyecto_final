package Entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Acticulo implements Serializable{
    
    int id;
    String nombre;
    String descripcion;
    int precio;
    int existencia;
    Date fechaAdicion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public Acticulo(int id, String nombre, String descripcion, int precio, int existencia, Date fechaAdicion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.fechaAdicion = fechaAdicion;
    }
    
    
    
    
}
