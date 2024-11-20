
package heladeria.Productos;

import heladeria.Productos.Producto;
import java.sql.*;


public class Topping extends Producto{
    private String Tipo_topping;

    public Topping(String Tipo_topping, int IDProducto, String Nombre, int Precio, String Tipo) {
        super(IDProducto, Nombre, Precio, Tipo);
        this.Tipo_topping = Tipo_topping;
    }

    public Topping() {
        
    }

    public void VerToppings() {
        String url = "jdbc:mysql://localhost:3306/Heladeria";
       int x=-1;
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select nombre, precio, id from productos where tipo='Topping' ";
            ResultSet resultado = instruccion.executeQuery(sql);
            System.out.println("-------------Topping--------------");
            while(resultado.next()){
                System.out.print("Nombre: " + resultado.getString(1) + "\n");
                System.out.print("Precio: " + resultado.getString(2)+ "\n");
                System.out.print("IDProducto: " + resultado.getString(3)+ "\n");                
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
