
package heladeria;

import java.util.*;
import java.sql.*;

public class Repartidor extends Empleado{
    private String vehiculo;
    private String zona_entrega;

    public Repartidor(String nombre, String rol, String vehiculo, String zona_entrega ) {
        super(nombre, rol);
        this.vehiculo = vehiculo;
        this.zona_entrega = zona_entrega;
    }
    
    Scanner sc = new Scanner(System.in);
    
    public void MostrarRepartidor(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select id, nombre, rol from empleados where rol = 'Repartidor'";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id Empleados:" + resultado.getInt(1)+ "\n");
                System.out.print(" Nombre:" + resultado.getString(2)+ "\n");
                System.out.print(" Rol:" + resultado.getString(3)+ "\n");
                System.out.println("--------------------------");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
               
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void AsignarPedidoARepartidor() {
    String url = "jdbc:mysql://localhost:3306/Heladeria";
        
    Connection conexion = heladeria.ConexionDB.conectar();

    try {
        System.out.print("Ingrese el ID del repartidor: ");
        int idRepartidor = sc.nextInt();

        System.out.print("Ingrese el ID del pedido: ");
        int idPedido = sc.nextInt();

        String sql = "INSERT INTO delivery (id_pedido, id_repartidor) VALUES (?,?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPedido);
            preparedStatement.setInt(2, idRepartidor);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Pedido asignado exitosamente al repartidor.");
            } else {
                System.out.println("No se pudo asignar el cliente.");
            }
        }

        conexion.close();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }
}
}
