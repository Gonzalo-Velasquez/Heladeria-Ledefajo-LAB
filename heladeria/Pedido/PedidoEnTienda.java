
package heladeria.Pedido;

import heladeria.ConexionDB;
import java.sql.*;
    

public class PedidoEnTienda extends Pedido{

    public PedidoEnTienda(int total, int IDPedido) {
        super(total, IDPedido);
    }

    public PedidoEnTienda() {
    }


    

    public void iniciarPedido(){
        Connection conexion = ConexionDB.conectar(); 
            try {
                String insertQuery = "INSERT INTO pedidos (fecha_pedido, estado, tipo_pedido,total) VALUES (curdate(), ?, ?, ?)";

                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,"Entregado");
                preparedStatement.setString(2,"En Tienda");
                preparedStatement.setInt(3, getTotal());
                

                int Pedido = preparedStatement.executeUpdate();  

                if (Pedido > 0) {
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        setIDPedido(generatedKeys.getInt(1)); 
                        System.out.println("Pedido insertado correctamente. ID del pedido: " + getIDPedido());
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
                preparedStatement.setInt(1, getIDPedido());
                preparedStatement.setInt(2, IDProducto);
                preparedStatement.setInt(3, cantidad);

                int datosPedido = preparedStatement.executeUpdate();
                if (datosPedido > 0) {
                    System.out.println("Pedido registrado correctamente en la base de datos.\n");
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
        super.calcularTotal(precio, cantidad); 
    }
    

    
    public void FinPedido(){
        Connection conexion = ConexionDB.conectar(); 
            try {
                String insertQuery = "UPDATE pedidos SET total = ? where id=?";

                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setFloat(1, getTotal());
                preparedStatement.setFloat(2, getIDPedido());
                
                
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
