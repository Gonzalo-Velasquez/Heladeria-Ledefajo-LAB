package heladeria.Empleado;

import heladeria.Pedido.*;
import java.util.*;
import java.sql.*;

public class Repartidor extends Empleado{
    private String vehiculo;

    public Repartidor(String nombre, String rol ) {
        super(nombre, rol);
        this.vehiculo = vehiculo;
        
    }
    
    public Repartidor(){
    
    }
    
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void MostrarDatos(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select r.id, e.nombre from empleados e inner join Repartidores r on r.id_empleado=e.id where e.rol = 'Repartidor'";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id Repartidor:" + resultado.getInt(1)+ "\n");
                System.out.print("Nombre:" + resultado.getString(2)+ "\n");
                System.out.println("--------------------------");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
               
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    

    public void AsignarPedidoARepartidor(int idpedido) {
        Connection conexion = heladeria.ConexionDB.conectar();

        try {
            System.out.print("Ingrese el ID del repartidor: ");
            int idRepartidor = sc.nextInt();


            String sql = "INSERT INTO delivery (id_pedido, id_repartidor, fecha_asignacion) VALUES (?,?,curdate())";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idpedido);
                preparedStatement.setInt(2, idRepartidor);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Pedido asignado exitosamente al repartidor.");
                } else {
                    System.out.println("No se pudo asignar el cliente.");
                }
                preparedStatement.close();
            }

            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    
    }
    
public void PedidosRepartidor(int idRepartidor) {
    Connection conexion = heladeria.ConexionDB.conectar();

    try {
       
        String sql = "SELECT p.direccion, c.nombre_cliente, p.total " +
                     "FROM delivery d " +
                     "INNER JOIN pedidos p ON p.id = d.id_pedido " +
                     "INNER JOIN clientes c ON p.id_cliente = c.id_cliente " +
                     "WHERE d.id_repartidor = ?;";
                     
        PreparedStatement instruccion = conexion.prepareStatement(sql);
        instruccion.setInt(1, idRepartidor);

        ResultSet resultado = instruccion.executeQuery();

        System.out.println("-------------PEDIDOS--------------");
        while (resultado.next()) {
            System.out.print("Direccion: " + resultado.getString(1) + "\n");
            System.out.print("Cliente: " + resultado.getString(2) + "\n");
            System.out.print("Total: " + resultado.getString(3) + "\n");
            System.out.println("----------------------------------");
        }

        resultado.close();
        instruccion.close();
        conexion.close();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }
}

}