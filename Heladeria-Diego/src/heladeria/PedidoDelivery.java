
package heladeria;

import java.util.*;
import java.sql.*;

public class PedidoDelivery extends Pedidos{
    private String dirrecion;
    private String nombre;
    
    Scanner sc = new Scanner(System.in);

    public PedidoDelivery(String dirrecion, String nombre, String estado, String tipo, java.sql.Date fecha, int total) {
        super(tipo, fecha, total);
        this.dirrecion = dirrecion;
        this.nombre = nombre;
    }
    
    public void PedirDatos(){
        System.out.println("Ingrese los datos del Pedido: ");
        System.out.println("Tipo: ");
        setTipo(sc.nextLine());
        System.out.println("Total: ");
        setTotal(sc.nextInt());
        System.out.println("Dirrecion: ");
        dirrecion = sc.nextLine();
        System.out.println("Nombre: ");
        nombre = sc.nextLine();
    }
    
    public void VerProductos(){
    
    }
    
    
}
