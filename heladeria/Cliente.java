
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
}