import java.util.Random;
import java.util.Scanner;
/**
 * Objeto que representa un producto.
 * 
 * <p>
 * 
 * Este objeto almacena y gestiona, el nombre del producto, codigo de barras, precio y Fabricante.
 * 
 * @version 1
 * @author Pablo Rubio
 */
public class Producto {

    private String nombre;
    private String fabricante;
    private float precio;
    private long codigo_de_barras;

    /**
     * Constructor de Producto.
     * 
     * <p>
     * 
     * Con código de barras aleatorio y sin fabricante.
     * 
     * @param nombre nombre del producto.
     * @param precio precio del producto.
     * @param random Objeto random que genera un código de barras aleatorio.
     */

    public Producto(String nombre, float precio, Random random)
    {        
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_de_barras = random.nextLong();
        this.fabricante = "";

    }

    /**
     * Constructor de Producto.
     * 
     * <p>
     * 
     * Con código de barras pasado por parametro y sin fabricante.
     * 
     * @param nombre nombre del producto.
     * @param precio precio del producto.
     * @param codigo_de_barras código de barras del producto..
     */

    public Producto(String nombre, float precio, long codigo_de_barras)
    {        
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_de_barras = codigo_de_barras;
        this.fabricante = "";

    }

    /**
     * Constructor de Producto.
     * 
     * <p>
     * 
     * Con código de barras aleatorio y con fabricante.
     * 
     * @param nombre nombre del producto.
     * @param precio precio del producto.
     * @param random Objeto random que genera un código de barras aleatorio.
     * @param fabricante Fabricante del producto.
     */

    public Producto(String nombre, float precio, Random random, String fabricante)
    {        
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_de_barras = random.nextLong();
        this.fabricante = fabricante;

    }

    /**
     * Constructor de Producto.
     * 
     * <p>
     * 
     * Con código de barras pasado por parametro y con fabricante.
     * 
     * @param nombre nombre del producto.
     * @param precio precio del producto.
     * @param codigo_de_barras código de barras del producto..
     * @param fabricante Fabricante del producto.
     */

    public Producto(String nombre, float precio, long codigo_de_barras, String fabricante)
    {        
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_de_barras = codigo_de_barras;
        this.fabricante = fabricante;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public long getCodigo_de_barras() {
        return codigo_de_barras;
    }

    public void setCodigo_de_barras(long codigo_de_barras) {
        this.codigo_de_barras = codigo_de_barras;
    }

    /**
     * Método toString completo.
     * @return una cadena que contiente el código de barras, nombre, precio y si tiene fabricante, tambien lo incluye en formato variable: valor.
     */
    @Override
    public String toString()
    {
        if("".equals(fabricante))
        {
            return "Código de barras: " + this.codigo_de_barras + " nombre: " + this.nombre + " precio: " + this.precio;
        }
        else
        {
            return "Código de barras: " + this.codigo_de_barras + " nombre: " + this.nombre + " fabricante: " + this.fabricante + " precio: " + this.precio;
        }

    }

    /**
     * Método toString sin código de barras.
     * @return una cadena que contiente el  nombre, precio y si tiene fabricante, tambien lo incluye en formato variable: valor.
     */

    public String toStringWithoutCode()
    {
        if("".equals(fabricante))
        {
            return "Nombre: " + this.nombre + " precio: " + this.precio;
        }
        else
        {
            return "Nombre: " + this.nombre + " fabricante: " + this.fabricante + " precio: " + this.precio;
        }
    }

}
