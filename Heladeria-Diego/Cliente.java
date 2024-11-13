
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
        
        Connection conexion = ConexionDB.conectar();

        try {

            String sql = "INSERT INTO clientes (nombre_cliente, direccion_cliente) VALUES (?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, nombreCliente);
                preparedStatement.setString(2, direccionCliente);
                
                int filasAfectadas = preparedStatement.executeUpdate();
                
                if (filasAfectadas > 0) {
                    System.out.println("Cliente añadido exitosamente.");
                } else {
                    System.out.println("No se pudo añadir el cliente.");
                }
            }
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void AsignarCliente(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        System.out.print("Ingrese la id del repartidor: ");
        int idRepartidor = sc.nextInt();
        System.out.print("Ingrese el ID del pedido: ");
        int idPedido = sc.nextInt();
        
        Connection connection = ConexionDB.conectar();

        if (connection != null) {
            try {
                // Prepara la consulta SQL para insertar los datos
                String sql = "INSERT INTO usuarios (id_repartidor, id_pedido) VALUES (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idrepartidor);
                preparedStatement.setInt(2, idpedido);

                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Datos insertados correctamente en la base de datos.");
                } else {
                    System.out.println("No se pudieron insertar los datos.");
                }

                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la base de datos: " + e.getMessage());
            }
        } else {
            System.err.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}