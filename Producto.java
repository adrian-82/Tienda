
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

    /**
     * Constructor for objects of class Producto
     */
    public Producto()
    {
        // initialise instance variables
        nombre="";
        precio=0;
    }

     /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void insertaValores(String nombre, int precio)
    {
    
        this.nombre=nombre;
        
        this.precio=precio;
        
    }
    
       /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getnombre()
    {
        // put your code here
        return nombre;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getPrecio()
    {
        // put your code here
        return precio;
    }
}
