
package heladeria.Pedido;

import heladeria.*;
import java.sql.*;

public class PedidoDelivery extends Pedido implements Descuento{

    public PedidoDelivery(int total, int IDPedido, int cantidad) {
        super(total, IDPedido, cantidad);
    }

    public PedidoDelivery() {
    }



    public void iniciarPedido(int IDCliente, String direccion){
        Connection conexion = ConexionDB.conectar(); 
            try {
                String insertQuery = "INSERT INTO pedidos (fecha_pedido, estado, id_cliente, direccion, tipo_pedido, total) VALUES (curdate(), ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,"Listo");
                preparedStatement.setInt(2,IDCliente);
                preparedStatement.setString(3,direccion);                
                preparedStatement.setString(4,"Delivery");
                preparedStatement.setDouble(5, getTotal());
                

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
    public void calcularTotal(double precio, int cantidad) {
        this.cantidad = cantidad; 
        super.calcularTotal(precio, cantidad); 
        this.total = aplicarDescuento(this.total); 
    }

    @Override
    public double aplicarDescuento(double precioOriginal) {
        if (cantidad > 3) {
            System.out.println("Descuento del 10%. Compra desde 4 helados.");
            precioOriginal=precioOriginal * 0.9;
            System.out.println("---Total con descuento: "+ precioOriginal);
            return precioOriginal;
        }
        return precioOriginal; 
    }


    
    public void FinPedido(){
        Connection conexion = ConexionDB.conectar(); 
            try {
                String insertQuery = "UPDATE pedidos SET total = ? where id=?";

                PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);

                preparedStatement.setDouble(1, total);
                preparedStatement.setInt(2, getIDPedido());
                
                
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