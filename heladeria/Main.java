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
        Vendedor v = new Vendedor();
        Repartidor r = new Repartidor();
        PedidoEnTienda tienda = new PedidoEnTienda();
        PedidoDelivery delivery = new PedidoDelivery();
        Scanner sc = new Scanner(System.in);
        int rol, op, op1,op2;
        
        do {
            System.out.println("----------------------------------");
            System.out.println("Selecciona tu Rol (Elegir Num):");
            System.out.println("1. Vendedor");
            System.out.println("2. Repartidor");
            System.out.println("3. Salir");
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
                                int precio, cantidad, IDProducto,tipo;
                                do {
                                    System.out.println("--Productos:");
                                    System.out.println("1. Helado");
                                    System.out.println("2. Toppings");
                                    System.out.println("3. Combo");
                                    System.out.println("4. Atras");
                                    
                                    op1 = sc.nextInt();
                                 
                                    sc.nextLine();
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
                                        precio = sc.nextInt();

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
                                        precio = sc.nextInt();

                                        tienda.PedidoProducto(IDProducto, cantidad);
                                        tienda.calcularTotal(precio, cantidad);
                                        tienda.FinPedido();
                                        System.out.println("----------------------------------\n");  
                                    }
        
                                } while(op1 != 4);
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
                    System.out.println("----------------------------------");
                    System.out.println("Se salio del Sistema.");
                    System.out.println("----------------------------------");
                    break;
                    
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }
        } while(rol != 3);
        
        sc.close();
    }
}
