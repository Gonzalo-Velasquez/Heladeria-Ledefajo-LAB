package heladeria;

import heladeria.Productos.*;
import heladeria.Pedido.*;
import heladeria.Empleado.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Helado he = new Helado();
        Topping to = new Topping();
        Combo co = new Combo();
        Cliente c = new Cliente();
        Repartidor r = new Repartidor();
        PedidoEnTienda tienda = new PedidoEnTienda();
        PedidoDelivery delivery = new PedidoDelivery();
        PedidoComboPersonalizado pcp = new PedidoComboPersonalizado();
        Administrador admin = new Administrador();
        Scanner sc = new Scanner(System.in);
        int rol, op, op1;
        
        do {
            System.out.println("----------------------------------");
            System.out.println("Selecciona tu Rol (Elegir Num):");
            System.out.println("1. Vendedor");
            System.out.println("2. Repartidor");
            System.out.println("3. Administrador");
            System.out.println("4. Salir");
            System.out.println("----------------------------------");
            
            rol = sc.nextInt();
            sc.nextLine(); 
            
            switch (rol) {
                case 1:
                    do {
                        System.out.println("----------------------------------");
                        System.out.println("Menu VENDEDOR (Elegir Num):");
                        System.out.println("1. Ver Productos");
                        System.out.println("2. Hacer Venta");
                        System.out.println("3. Cerrar Sesion");
                        System.out.println("----------------------------------");
                        op = sc.nextInt();
                        
                        switch(op) {
                            case 1:
                                do {
                                    System.out.println("--Ver Productos");
                                    System.out.println("1. Helados");
                                    System.out.println("2. Topping");
                                    System.out.println("3. Combos");
                                    System.out.println("4. Atras");
                                    
                                    op1 = sc.nextInt();
                                    switch(op1) {
                                        case 1:
                                            he.VerHelados();
                                            break;
                                        case 2:
                                            to.VerToppings();
                                            break;
                                        case 3:
                                            co.VerCombos();
                                            break;
                                        case 4:
                                            System.out.println("<---- Atras");
                                            break;
                                        default:
                                            System.out.println("Opcion Invalida. Intente nuevamente.");
                                            break;
                                    }
                                } while(op1 != 4);
                                break;

                            case 2:   
                                int cantidad, IDProducto,tipo;
                                double precio;
                                String combinacion;
                                do {
                                    System.out.println("--Productos:");
                                    System.out.println("1. Helado");
                                    System.out.println("2. Toppings");
                                    System.out.println("3. Combo");
                                    System.out.println("4. Personalizado");
                                    System.out.println("5. Atras");
                                    
                                    op1 = sc.nextInt();
                                    sc.nextLine();
                                    if(op1==1 || op1 == 2 || op1==3){
                                        System.out.println("Ingrese el Tipo de Entrega: ");
                                        System.out.println("1. En Tienda");
                                        System.out.println("2. Delivery");
                                        tipo = sc.nextInt();
                                        
                                        if(tipo == 2){
                                        System.out.println("----------------------------------");
                                        System.out.println("--Delivery: ");
                                        c.IngresarDatos();
                                        
                                        delivery.iniciarPedido(c.getIDCliente(),c.getDirrecion());
                                        if(op1==1){
                                            he.VerHelados();
                                        }else if(op1==2){
                                            to.VerToppings();
                                        }else if(op1==3){
                                            co.VerCombos();
                                        }
                                        System.out.println("----------------------------------");
                                        System.out.println("Ingresar el ID del Producto elegido: ");
                                        IDProducto = sc.nextInt();
                                        
                                        System.out.println("Ingresar la cantidad del Producto: ");
                                        cantidad = sc.nextInt();

                                        System.out.println("Ingresar el precio del producto: ");
                                        precio = sc.nextDouble();

                                        delivery.PedidoProducto(IDProducto, cantidad);
                                        delivery.calcularTotal(precio, cantidad);
                                        delivery.FinPedido();
                                        System.out.println("----------------------------------  ");                                          
                                        
                                        System.out.println("ASIGNAR pedido a un Repartidor: ");
                                        r.MostrarDatos();
                                        r.AsignarPedidoARepartidor(delivery.getIDPedido());
                                        
                                        }else if(tipo == 1){
                                            if(op1==1){
                                                he.VerHelados();
                                            }else if(op1==2){
                                                to.VerToppings();
                                            }else if(op1==3){
                                                co.VerCombos();
                                            }
                                            tienda.iniciarPedido();
                                            System.out.println("----------------------------------");
                                            System.out.println("--En Tienda: ");
                                            System.out.println("Ingresar el ID del Producto elegido: ");
                                            IDProducto = sc.nextInt();

                                            System.out.println("Ingresar la cantidad del Producto: ");
                                            cantidad = sc.nextInt();

                                            System.out.println("Ingresar el precio del producto: ");
                                            precio = sc.nextDouble();

                                            tienda.PedidoProducto(IDProducto, cantidad);
                                            tienda.calcularTotal(precio, cantidad);
                                            tienda.FinPedido();
                                            System.out.println("----------------------------------\n");  
                                        }
                                    }else if(op1==4){
                                        pcp.iniciarPedido();
                                        System.out.println("----------------------------------");
                                        System.out.println("--Solo en Tienda: ");
                                        
                                        System.out.println("Ingrese los nombres de los productos a combinar (MAX. 3):");
                                        System.out.println("Precio: 300$");
                                        System.out.println("Ejemplo: Chocolate+Frutilla+Chispas");
                                        combinacion= sc.nextLine();

                                        pcp.pedidoPersonalizado(combinacion);
                                        
                                        System.out.println("Ingresar la cantidad del Producto: ");
                                        cantidad = sc.nextInt();
                                        System.out.println("Ingresar el precio del producto: ");
                                        precio = sc.nextDouble();
                                        
                                        pcp.PedidoProducto(cantidad);
                                        
                                        pcp.calcularTotal(precio, cantidad);
                                        pcp.FinPedido();
                                        System.out.println("----------------------------------\n");  
                                    }
        
                                } while(op1 != 5);
                                break;
                            
                            case 3:
                                System.out.println("Cerrando sesion...");
                                break;
                            
                            default:
                                System.out.println("Opcion no valida. Intente nuevamente.");
                                break;
                        }
                        
                    } while(op != 3);
                    break;
                    
                case 2:
                    
                    r.MostrarDatos();
                    int idr;
                    
                    System.out.println("Ingrese su ID: ");
                    idr = sc.nextInt();
                    System.out.println(idr);
                    do{
                    System.out.println("----------------------------------");
                    System.out.println("menu REPARTIDOR (Elegir num): ");
                    System.out.println("1. Ver Pedidos");
                    System.out.println("2. Cerrar Sesion");
                    System.out.println("----------------------------------\n");
                    op1 = sc.nextInt();
                    
                    switch(op1){
                            case 1:
                                System.out.println(idr);
                                r.PedidosRepartidor(idr);
                            break;
                            case 2:
                                System.out.println("Cerrando sesion...");
                            break;
                        }
                    }while(op1!=2);
                    
                    break;
                    
                case 3:
                    do{
                    System.out.println("----------------------------------");
                    System.out.println("Menu Administrador: ");
                    System.out.println("1. Ver Todos los empleados");
                    System.out.println("2. Añadir empleado");
                    System.out.println("3. Salir");
                    System.out.println("----------------------------------");
                    op= sc.nextInt(); 
                    
                    switch (op){
                        case 1:
                            admin.MostrarDatos();
                            break;
                        case 2:
                            admin.AñadirEmpleado();
                            break;
                    }
                    }while(op!=3);
                    
                    break;
                case 4:
                    System.out.println("----------------------------------");
                    System.out.println("Se salio del Sistema.");
                    System.out.println("----------------------------------");
                    break;
                    
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }
        } while(rol != 4);
        
        sc.close();
    }
}
