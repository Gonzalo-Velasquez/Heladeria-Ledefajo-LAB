
package heladeria;

import java.util.*;
import java.sql.*;

public class Cliente {
    private String nombre;
    private String dirrecion;
    
    Scanner sc = new Scanner(System.in);
    
    public void IngresarDatos(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        
        System.out.print("Ingrese la dirección del cliente: ");
        String direccionCliente = sc.nextLine();

        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "INSERT INTO clientes (nombre_cliente, direccion_cliente) VALUES ('" + nombreCliente + "', '" + direccionCliente + "')";
            int filasInsertadas = instruccion.executeUpdate(sql);
            if (filasInsertadas > 0) {
                System.out.println("Cliente añadido exitosamente.");
            } else {
                System.out.println("No se pudo añadir el cliente.");
            }

            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void InsertarPedido(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        System.out.print("Ingrese la fecha del pedido (YYYY-MM-DD): ");
        String fechaPedido = sc.nextLine();
        
        System.out.print("Ingrese el total del pedido: ");
        double totalPedido = sc.nextDouble();
        
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "INSERT INTO pedidos (fecha_pedido, estado_pedido) VALUES('" + fechaPedido + "', '" + estadoPedido + "')";
        }
        
    }
    
    public void AsignarCliente() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        System.out.print("Ingrese la id del repartidor: ");
        int idRepartidor = sc.nextInt();
        System.out.print("Ingrese el ID del pedido: ");
        int idPedido = sc.nextInt();
        
        String insertQuery = "INSERT INTO delivery (id_pedido, id_repartidor, fecha_asignacion, estado_entrega) VALUES (?, ?, ?, 'Pendiente')";

        try (Connection conexion = DriverManager.getConnection(url, "root", "");
             PreparedStatement pstmt = conexion.prepareStatement(insertQuery)) {
            
            pstmt.setInt(1, idPedido);
            pstmt.setInt(2, idRepartidor);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pedido asignado exitosamente al repartidor.");
            } else {
                System.out.println("No se pudo asignar el pedido.");
            }
        }
    }
}