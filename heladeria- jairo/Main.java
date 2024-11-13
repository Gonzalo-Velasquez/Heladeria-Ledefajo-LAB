package heladeria;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Helado he = new Helado();
        Topping to = new Topping();
        Combo co = new Combo();
        Scanner sc = new Scanner(System.in);
        int rol, op, op1;
        
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
                        System.out.println("3. Cerrar Sesión");
                        System.out.println("----------------------------------");
                        op = sc.nextInt();
                        
                        switch(op) {
                            case 1:
                                do {
                                    System.out.println("--Ver Productos");
                                    System.out.println("1. Helados");
                                    System.out.println("2. Topping");
                                    System.out.println("3. Combos");
                                    System.out.println("4. Atrás");
                                    
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
                                            System.out.println("<---- Atrás");
                                            break;
                                        default:
                                            System.out.println("Opción Inválida. Intente nuevamente.");
                                            break;
                                    }
                                } while(op1 != 4);
                                break;

                            case 2:
                                do {
                                    System.out.println("--Productos:");
                                    System.out.println("1. Helado");
                                    System.out.println("2. Toppings");
                                    System.out.println("3. Combo");
                                    System.out.println("4. Atrás");
                                    
                                    op1 = sc.nextInt();
                                    switch(op1) {
                                        case 1:
                                            int precio, cantidad, IDProducto;
                                            String fecha, tipo;
                                            
                                            sc.nextLine(); 
                                            System.out.println("Ingrese la fecha del pedido:");
                                            fecha = sc.nextLine();
                                            
                                            System.out.println("Ingrese el Tipo de Entrega: (En tienda o delivery): ");
                                            tipo = sc.nextLine();
                                            
                                            he.VerHelados();
                                            
                                            PedidoEnTienda tienda = new PedidoEnTienda(fecha, tipo);
                                            tienda.iniciarPedido();
                                            
                                            System.out.println("Ingresar el ID del Producto: ");
                                            IDProducto = sc.nextInt();
                                            
                                            System.out.println("Ingresar la cantidad del Producto: ");
                                            cantidad = sc.nextInt();
                                            
                                            System.out.println("Ingresar el precio del producto: ");
                                            precio = sc.nextInt();
                                            
                                            tienda.PedidoProducto(IDProducto, cantidad);
                                            tienda.calcularTotal(precio, cantidad);
                                            tienda.FinPedido();
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                            break;
                                    }
                                } while(op1 != 4);
                                break;
                            
                            case 3:
                                System.out.println("Cerrando sesión...");
                                break;
                            
                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                                break;
                        }
                    } while(op != 3);
                    break;
                    
                case 2:
                    System.out.println("----------------------------------");
                    System.out.println("Menu REPARTIDOR (Elegir Num):");
                    System.out.println("----------------------------------");
                    break;
                    
                case 3:
                    System.out.println("----------------------------------");
                    System.out.println("Se salió del Sistema.");
                    System.out.println("----------------------------------");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while(rol != 3);
        
        sc.close();
    }
}
