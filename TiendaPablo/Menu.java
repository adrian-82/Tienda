package TiendaPablo;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class Menú here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    private String cliente;
    private long id;
    private String nombre;
    private long codBarras;
    Producto producto;
    Pedido pedido;
    HashMap<String, Long> nombreProductoCodigoBarras;
    HashMap< Long, String> pedidoCodigoBarras;
    ArrayList<String>colProducts;
    ArrayList<String>clientes;
    private int opcion;

    
    /**
     * Menú para interactuar con el usuario.
     * Introducción de una opción
     */
    public  void interactuar()
    {

        do{
            Scanner teclado=new Scanner(System.in);
            System.out.println();  
            System.out.println("1-...Añadir Productos.");                     /*añadir un pedido, con un codigo de barras(HashMap)*/
            System.out.println("2-...Ver todos los Productos.");              /*listar todos los productos*/
            System.out.println("3-...AsignarPedido/CodigoBarras.");             /*id aleatorio*/
            System.out.println("4-...Buscar un pedido(por codigo de barras)");
            System.out.println("5-...Ver todos los Pedidos/CodigoBarras.");      /*Listar pedidos y  localizar pedido por la clave*/
                                                                          
            System.out.println("numero negativo   -...Salir.");
            System.out.println(); 
            System.out.println("Introduzca una opción, por favor!");
            /*añadir productos hasta que la persona quiera(-1)*/
            int opcion=teclado.nextInt();

            /*ver los productos/pedidos*/

            switch(opcion)
            {
                case 1:               

                anadirProductoPedido();

                break;
                
                case 2:   

                verProductos();                                                                 /*ver productos con su cod de barras*/

                break;
                
                case 3:

                asignarPedidoCodigoBarras();

                 break;
                 
                case 4:   

                buscar1PedidoCodigoBarras();                                                       /*ver productos con su cod de barras*/

                break;

                case 5: 
                
                mostrarPedidoCodigoBarras();
                                                               
                break;
                
                default:
             
            }

        }while(opcion<0); // Salir con un numero negativo 

    }

    /**
     * Añade un producto con sus caracteristicas.
     *
     */
    public void anadirProductoPedido()
    {

        Scanner sc=new Scanner(System.in);
        HashMap<String, Long> nombreProductoCodigoBarras=new  HashMap<>();
        colProducts=new ArrayList();

        /* String nombre="";*/
        float precio=0;
        long codigo_de_barras=0;
        String fabricante="";

        String cliente="";
        long id=0;
        String direccion="";
        Producto producto= new Producto(nombre, precio, codigo_de_barras, fabricante);
        System.out.println("Ingrese el nombre del producto, por favor");

        nombre = sc.nextLine();
        producto.setNombre(nombre);
        nombre=producto.getNombre();

        System.out.println("Ingrese el precio del producto, por favor");

        precio = sc.nextFloat();
        producto.setPrecio(precio);
        precio=producto.getPrecio();

        System.out.println("Ingrese el fabricante del producto, por favor");

        sc.nextLine();
        fabricante =sc.nextLine();
        producto.setFabricante(fabricante);
        fabricante=producto.getFabricante();      

        System.out.println("Ingrese el código de barras del producto, por favor");

        codigo_de_barras =sc.nextLong();
        producto.setCodigo_de_barras(codigo_de_barras);

        nombreProductoCodigoBarras.put(nombre,producto.getCodigo_de_barras());

        colProducts.add(nombre);
    }

    /**
     * Muestra los productos y sus precios.
     *
     */
    public void verProductos()
    {

        System.out.println();
        System.out.println("La lista de productos y codigo de barras es:");

        Iterator it = nombreProductoCodigoBarras.entrySet().iterator();

        while (it.hasNext()) 
        {

            System.out.println(it.next() + ", Value = " + nombreProductoCodigoBarras.get(it.next()));

        }

    }

    /*añadir un pedido, con un codigo de barras(HashMap)*/

    /**
     * Asigna a un pedido un código de barras aleatório
     *
     */
    public void asignarPedidoCodigoBarras()
    {
        
        clientes= new ArrayList();
        Pedido pedido=new Pedido(cliente, id);
        Scanner sc=new Scanner(System.in);
        HashMap<Long, String> pedidoCodigoBarras=new HashMap<>();

        System.out.println("Ingrese el nombre del cliente del pedido, por favor");
        pedido.setCliente(sc.nextLine());
        cliente=pedido.getCliente();

        
        System.out.println("Ingreso de codigo de barras aleatorio.");
        pedidoCodigoBarras.put(pedido.getId(), cliente);        
        clientes.add(cliente);
     
    }

    public void buscar1PedidoCodigoBarras()
    {
        
       Scanner sc=new Scanner(System.in);
       System.out.println("Ingrese el codigo de barras del pedido.");
       
       
        
       codBarras=sc.nextLong();
       System.out.println(codBarras + "....." +   pedidoCodigoBarras.get(id));//Pienso que deberiamos llamar al metodo 
       
    
    
    }
    
    
    /**
     * Muestra cada pedido el código de barras asignado previamente.
     *
     */
    public void mostrarPedidoCodigoBarras()
    {
 
        Iterator it1= clientes.iterator();

        while(it1.hasNext())
        {

            System.out.println(it1.next() + "...." +  pedidoCodigoBarras.get(it1));

        }
    }  
}