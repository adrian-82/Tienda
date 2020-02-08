package TiendaPablo;
import java.util.Random;
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
    private String nomCliente;
    private long id;
    private String nombreArticulo;
    private String nombreFabricante;
    private float precio; 
    private long  codigo_de_barras;
    Producto producto;

    Pedido pedido;
    HashMap<String, Float> nombreArticuloPrecio;
    HashMap<  String, Long> pedidoCodigoBarras;
    HashMap< Long, String > delReves;
    ArrayList<String>colProducts;
    ArrayList<String>clientes;
    private int opcion;
    private boolean fin;
    /**
     * Menú para interactuar con el usuario.
     * Introducción de una opción
     */
    public  void interactuar()
    {

        pedidoCodigoBarras=new HashMap<>();
        delReves=new HashMap();
        colProducts=new ArrayList();
        nombreArticuloPrecio=new  HashMap<>();
        clientes= new ArrayList();
        fin=false;

        do{
            Scanner teclado=new Scanner(System.in);
            System.out.println();  
            System.out.println("1-...Añadir Productos.");                     /*añadir un pedido, con un codigo de barras(HashMap)*/
            System.out.println("2-...Ver todos los Productos.");              /*listar todos los productos*/
            System.out.println("3-...AsignarPedido/CodigoBarras.");             /*id aleatorio*/
            System.out.println("4-...Buscar un pedido(por codigo de barras)");
            System.out.println("5-...Ver todos los Pedidos/CodigoBarras.");      /*Listar pedidos y  localizar pedido por la clave*/

            System.out.println("99   -...Salir.");
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

                case 99: 

                fin=true;

                break;

                default:

            }

        }while(!fin);

    }

    /**
     * Añade un producto con sus caracteristicas.
     *
     */
    public void anadirProductoPedido()
    {
        Producto producto = new Producto(nombreArticulo, precio, codigo_de_barras, nombreFabricante);
        Scanner sc=new Scanner(System.in);

        String nombreArticulo="";
        float precio=0;
        long codigo_de_barras=0;
        String fabricante="";

        String cliente="";
        long id=0;
        String direccion="";

        System.out.println("Ingrese el nombre del producto, por favor");

        nombreArticulo = sc.nextLine();
        producto.setNombre(nombreArticulo);
        nombreArticulo=producto.getNombre();

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

        nombreArticuloPrecio.put(nombreArticulo,producto.getPrecio());

        colProducts.add(nombreArticulo);

    }

    /**
     * Muestra los productos y sus precios.
     *
     */
    public void verProductos()
    {

        System.out.println();
        System.out.println("La lista de productos y codigo de barras es:");

        for (String productito : colProducts)
        {

            System.out.println(productito + "/t......" + nombreArticuloPrecio.get(productito));

        }

    }

    /*añadir un pedido, con un codigo de barras(HashMap)*/

    /**
     * Asigna a un pedido un código de barras aleatório
     *
     */
    public void asignarPedidoCodigoBarras()
    {

        Pedido pedido=new Pedido(nomCliente, id);
        Scanner sc=new Scanner(System.in);
   

        System.out.println("Ingrese el nombre del cliente del pedido, por favor");
        pedido.setCliente(sc.nextLine());
        nomCliente=pedido.getCliente();

        System.out.println("Ingreso de codigo de barras aleatorio.");
        pedido.generadorId();
        pedidoCodigoBarras.put(nomCliente, pedido.getId());        
        clientes.add(nomCliente);
        System.out.println("El id del cliente es: " + " " + pedido.getId() + "... ya asignado."   );
        
        /*ahora del reves para buscar*/
        delReves.put(pedido.getId(), nomCliente);
        
    }

    public void buscar1PedidoCodigoBarras()
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el codigo de barras del pedido.");                          

        id=sc.nextLong();
        
        
        if(delReves.containsKey(id))
        {
            
        System.out.println( id + "....." +   delReves.get(id));
        
        
        }else
        {
         System.out.println( "El código id no se existe, intentelo de nuevo!");
        }
        
        

    }
    /**
     * Muestra cada pedido el código de barras asignado previamente.
     *
     */
    public void mostrarPedidoCodigoBarras()
    {

        System.out.println();
        System.out.println("La lista de Pedidos y Codigo de barras es:");

        for (String pedidito : clientes)
        {

            System.out.println(pedidito + "/t......" + pedidoCodigoBarras.get(pedidito));

        }

    }  
}