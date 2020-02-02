package TiendaPablo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Clase que representa la factura de un pedido junto con su Cliente y dirección si va a ser enviado el pedido.
 * @author Pablo Rubio
 * @version 1
 * @see Producto Linea
 */
public class Pedido {

    private HashMap<Long, Linea> factura;
    private String cliente;
    private String direccion;
    private long id;

    /**
     * Pedido sin dirección y con id pasada como parametro.
     * @param cliente Cliente del pedido;
     * @param id id del pedido.
     */
    public Pedido(String cliente, long id)
    {
        this.cliente = cliente;
        this.id = id;
        factura = new HashMap<Long,Linea>();
        direccion = "";
    }

    /**
     *  Pedido con id pasada como parametro
     * @param cliente Cliente del pedido;
     * @param id id del pedido.
     * @param direccion dirección del cliente
     */
    public Pedido(String cliente, long id, String direccion) 
    {

        this.cliente = cliente;
        this.id = id;
        factura = new HashMap<Long,Linea>();
        this.direccion=direccion;
    }

    /**
     * Pedido sin dirección y con id aleatoria.
     * @param cliente Cliente del pedido;
     * @param random Objeto random para generar una id aleatoria para el pedido.
     */
    public Pedido(String cliente, Random random)
    {
        this.cliente = cliente;
        this.id = random.nextLong();
        factura = new HashMap<Long,Linea>();
        direccion = "";
    }

        /**
     * Pedido sin dirección y con id aleatoria.
     * @param cliente Cliente del pedido;
     * @param random Objeto random para generar una id aleatoria para el pedido.
     */
   
        public void  Pedido(Random random)
    {

        this.id = random.nextLong();

    }
    
    
    
    
    
    
    
    /**
     *  Pedido con id aleatoria.
     * 
     * @param cliente Cliente del pedido;
     * @param random Objeto random para generar una id aleatoria para el pedido.
     * @param direccion dirección del cliente
     */
    public Pedido(String cliente, Random random, String direccion) 
    {

        this.cliente = cliente;
        this.id = random.nextLong();;
        factura = new HashMap<Long,Linea>();
        this.direccion=direccion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }
    /*la id se mete en el constructor*/

    /**
     * Devuelve un array con todas las lineas de la factura.
     * @return array que contiene todas las lineas de la factura.
     * 
     * @see Linea
     */
    public ArrayList<Linea>  getFacturaArray() {

        ArrayList<Linea> toReturn = new ArrayList<Linea>();

        Set<Long> claves;
        claves = this.factura.keySet();
        for(Long l : claves)
        {
            toReturn.add(this.factura.get(l));
        }

        return toReturn;
    }

    
    /**
     * Elimina una linea de la factura. Si el producto no existe no raliza ninguna acción.
     * @param codigo_de_barras código de barras del producto a eliminar.
     */
    public void eliminarProducto(long codigo_de_barras)
    {        
        if(factura.containsKey(codigo_de_barras))
        {
            factura.remove(codigo_de_barras);
        }
    }

    /**
     * Añade un producto a la factura y su cantidad, si el producto, ya está, se añade su cantidad a la ya existente.
     * @param producto Producto a añadir a la factura.
     * @param cantidad cantidad de veces que hay que añadir el producto.
     */
    public void añadirProducto(Producto producto, int cantidad)
    {
        if(factura.containsKey(producto.getCodigo_de_barras()))
        {
            Linea lineaExistente = factura.get(producto.getCodigo_de_barras());
            lineaExistente.setCantidad(lineaExistente.getCantidad() + cantidad);
        }
        else
        {
            Linea linea = new Linea(producto, cantidad);
            factura.put(producto.getCodigo_de_barras(), linea);
        }
    }

    /**
     * Devuelve el ingreso generado por este pedido.
     * @return la suma de los precios de todos los productos en la factura.
     */
    public float getImporteTotal()
    {
        float total = 0;

        Set<Long> claves;
        claves = this.factura.keySet();
        for(Long l : claves)
        {
            total += factura.get(l).getPrecioLinea();
        }

        return total;
    }

    /**
     * Método toString de la factura.
     * @return Id del pedido, nombre del cliente, dirección si la tiene, y todos los productos de la factura en formato std.
     */
    @Override
    public String toString()
    {
        String toReturn ="Id del pedido: " + this.id + "\nNombre del cliente: " + this.cliente;

        if(!"".equals(this.direccion))
        {
            toReturn += "\n"+ "Dirección: " + this.direccion;
        }

        toReturn += "\nFactura: ";

        Set<Long> claves;
        claves = this.factura.keySet();
        for(Long l : claves)
        {
            toReturn += "\n" + this.factura.get(l).toString();
        }

        toReturn += "\nTOTAL: " + this.getImporteTotal();

        return toReturn;
    }

    /**
     * Devuelve la información de un pedido de manera simple: id, nombre del cliente, dirección, si la hay e importe total.
     * @return Un string con la información de: id, nombre del cliente, dirección, si la hay e importe total en una sola linea.
     */
    public String toStringSimpleInformation()
    {
        String toReturn ="Id: " + this.id;
        toReturn += " Cliente: " +this.cliente;

        if(!"".equals(this.direccion))
        {
            toReturn += " Dirección: " +this.direccion;
        }

        toReturn += " TOTAL: " + this.getImporteTotal();

        return toReturn;
    }

}
