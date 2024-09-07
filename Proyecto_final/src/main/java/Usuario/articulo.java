package Usuario;

/**
 * @author angel
 */
public class Articulo {//declaracion de variables 

    private String nombre;       //variable del nombre del articulo 

    private int cantidad;        //cantidad de unidades del articulo 

    private double precioUnidad; //precio de cada unidad 

    public Articulo(String nombre, int cantidad, double precioUnidad) { //constructor der la clase articulo 

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public boolean vendido(int numero) {//metodo para pedir al usuario que introduzca un numero 
        if (numero <= cantidad) {
            numero -= cantidad;
        } else {
            System.out.println("no hay suficientes unidades ");

            return false;
        }
        return true;
    }

    @Override//depuracion 
    public String toString() {
        return "NOMBRE =" + nombre + ", CANTIDAD =" + cantidad + ", PRECIO POR UNIDAD =" + precioUnidad + 'Q';
    }

}
