/**
 * Clase que representa una línea.
 * Almacena el producto y la cantidad de veces que se ha comprado.
 * @author Pablo Rubio
 * @version 1
 * @see Producto
 */
public class Linea {
    
    private Producto producto;
    private int cantidad;
    private long id;
    
    /**
     * Constructor de la calse Linea.
     * @param producto Producto de la linea.
     * @param cantidad Cantidad de Veces que se ha añadido al pedido.
     */
    public Linea(Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
        this.id = producto.getCodigo_de_barras();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Obten el id de la linea que coincide con el codigo de barras del producto.
     * @return id de la linea, identica al código de barras del producto.
     */
    protected long getId()
    {
        return this.id;
    }
    
    /**
     *  Obtienes el precio total de la linea.
     * @return precio del producto * cantidad.
     */
    
    public float getPrecioLinea()
    {
        float toReturn =  this.producto.getPrecio()*this.cantidad;
        return toReturn;
    }
    
    /**
     * Método toString reducido.
     * @return devuelve el nombre del producto, precio, veces comprado y precio completo de la linea.
     */
    @Override
    public String toString()
    {
        return "Producto: " + this.producto.getNombre() + "     " + this.cantidad + "X" + this.producto.getPrecio()+ "=" + this.getPrecioLinea();
    }
    
    /**
     * Método toString completo.
     * @return devuelve el método toString de Producto, veces comprado y precio completo de la linea.
     * 
     * @see Producto
     */
    public String toStringComplete()
    {
        return this.producto.toString() + " cantidad: " + this.cantidad + " total: " + this.getPrecioLinea();
    }
    
    
}
