
package heladeria;

import java.sql.*;
    

public class PedidoEnTienda extends Pedido{
    private int total;
    private int IDPedidos;
    public PedidoEnTienda( String fecha, String tipo) {
        super( fecha, tipo);
    }
    
    public PedidoEnTienda(){
    }
    
    

    public void iniciarPedido(){
        Connection conexion = ConexionDB.conectar(); 
            try {
                String insertQuery = "INSERT INTO pedidos (fecha_pedido, tipo_pedido,total) VALUES (?, ?, ?)";

                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1, getFecha());
                preparedStatement.setString(2, getTipo());
                preparedStatement.setInt(3, total);
                

                int Pedido = preparedStatement.executeUpdate();  

                if (Pedido > 0) {
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        IDPedidos=generatedKeys.getInt(1); 
                        System.out.println("Pedido insertado correctamente. ID del pedido: " + IDPedidos);
                    }
                } else {
                    System.out.println("No se pudieron insertar los datos.");
                }

                preparedStatement.close();
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la base de datos: " + e.getMessage());
            }
   
    }
  
    
    
    public void PedidoProducto(int IDProducto, int cantidad){
        Connection conexion = ConexionDB.conectar(); 
        try {
                String insertQuery = "INSERT INTO pedido_producto (id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
                preparedStatement.setInt(1, IDPedidos);
                preparedStatement.setInt(2, IDProducto);
                preparedStatement.setInt(3, cantidad);

                int datosPedido = preparedStatement.executeUpdate();
                if (datosPedido > 0) {
                    System.out.println("Datos insertados correctamente en la base de datos.\n");
                } else {
                    System.out.println("No se pudieron insertar los datos.");
                }

                preparedStatement.close();
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la base de datos: " + e.getMessage());
            }        
    }
    
    @Override
    public void calcularTotal(int precio, int cantidad) {
        total = precio * cantidad;
        System.out.println("Total: "+total);
    }
    
    public void FinPedido(){
        Connection conexion = ConexionDB.conectar(); 
            try {
                String insertQuery = "UPDATE pedidos SET total = ? where id=?";

                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setFloat(1, total);
                preparedStatement.setFloat(2, IDPedidos);
                
                
                int finPedido = preparedStatement.executeUpdate();  

                if (finPedido > 0) {
                } else {
                    System.out.println("No se pudieron insertar los datos.");
                }

                preparedStatement.close();
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la base de datos: " + e.getMessage());
            }    

    }
}
