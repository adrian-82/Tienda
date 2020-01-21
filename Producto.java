
/**
 * Write a description of class Producto here.
 *
 * @author Adrián Laya García.
 * @version 1.0
 */
public class Producto
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int precio;
    private int cantidad;
    /**
     * Constructor for objects of class Producto
     */
    public Producto()
    {
        // initialise instance variables
        nombre="";
        precio=0;
        cantidad=0;
    }

     /**
     * Metemos por parámetro las caracteristicas del producto.
     *
     * @param  Un nombre(String), un precio(int) y una cantidad(int)
     * 
     */
    public void insertaValores(String nombre, int precio, int cantidad)
    {
    
        this.nombre=nombre;
        
        this.precio=precio;
        
        this.cantidad=cantidad;
    }
    
       /**
  
     * @param  (String)
     * @return   Devuelve el nombre del producto
     */
    public String getnombre()
    {
        // put your code here
        return nombre;
    }
    
    /**
     * 
     * @param  (int)
     * @return    Devuelve el precio del producto
     */
    public int getPrecio()
    {
        // put your code here
        return precio;
    }

}
