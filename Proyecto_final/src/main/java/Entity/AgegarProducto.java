package Entity;

/**
 *
 * @author angel
 */
public class AgegarProducto {
private String codigo;
private float precio;
private String nombre;
private String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    

    @Override
    public String toString() {
        return "codigo=" + codigo + " |nombre= " + nombre + " |descripcion= " + descripcion + " |precio Q= " + precio;
    }

  


}
