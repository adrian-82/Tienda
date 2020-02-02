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
    private String nombre;
    Producto producto;
    Pedido pedido;
    HashMap<String, Long> nombreProductoCodigoBarras;
    ArrayList<String>colProducts;
    private int opcion;
    public  void interactuar()
    {
        do{
            Scanner teclado=new Scanner(System.in);
            System.out.println("1-...Añadir Productos.");                          /*añadir un pedido, con un codigo de barras(HashMap)*/
            System.out.println("2-...Ver todos los Productos.");                        
            System.out.println("3-...Ver Producto/Pedido específico.");                  /*Listar pedidos y  localizar pedido por la clave*/

                                                                                    /*listar todos los productos*/   /*id aleatorio*/
            System.out.println("99   -...Salir.");

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
                pedidoCodigoBarras();
                
               /* listarPedidos();*/

                break;
            }
            
        }while(opcion!=99);

    }

    public void anadirProductoPedido()
    {
        Scanner sc=new Scanner(System.in);
        HashMap<String, Long> nombreProductoCodigoBarras=new  HashMap<>();
        colProducts=new ArrayList();
        
        
        String nombre="";
        float precio=0;
        long codigo_de_barras=0;
        String fabricante="";

        String cliente="";
        long id=0;
        String direccion="";

        System.out.println("Ingrese el nombre del producto, por favor");

        

       nombre = sc.nextLine();
       producto.setNombre(nombre);
        
        nombre=producto.getNombre();

        System.out.println("Ingrese el precio del producto, por favor");
        producto.setPrecio(sc.nextFloat());
        precio=producto.getPrecio();

        System.out.println("Ingrese el fabricante del producto, por favor");
        producto.setFabricante(sc.nextLine());
        fabricante=producto.getFabricante();      

        System.out.println("Ingrese el código de barras del producto, por favor");
        producto.setCodigo_de_barras(sc.nextLong());
        codigo_de_barras=producto.getCodigo_de_barras();

        Producto producto= new Producto(nombre, precio, codigo_de_barras, fabricante);

        nombreProductoCodigoBarras.put(nombre,producto.getCodigo_de_barras());                                                           /* nombre y codigo barras*/
        colProducts.add(nombre);
    }
    public void verProductos()
    {

        System.out.println();
        System.out.println("La lista de productos y codigo de barras es:");

        Iterator it = colProducts.iterator();
        while (it.hasNext()) 
        {
            
    
            
            System.out.println(colProducts + ", Value = " + nombreProductoCodigoBarras.get(it));
        }

    }

    /*añadir un pedido, con un codigo de barras(HashMap)*/
    public void pedidoCodigoBarras()
    {
        Scanner sc=new Scanner(System.in);

        HashMap<String, Long> pedidoCodigoBarras=new HashMap<>();

        String cliente="";
        long id=0;

        System.out.println("Ingrese el nombre del cliente del pedido, por favor");
        pedido.setCliente(sc.nextLine());
        cliente=pedido.getCliente();

        System.out.println("Ingreso de codigo de barras aleatorio.");
        /*hago en la otra clase un método solo para extraer un id*/

        Pedido pedido=new Pedido(cliente, id);

        pedidoCodigoBarras.put(cliente, pedido.getId());

    }
    
}