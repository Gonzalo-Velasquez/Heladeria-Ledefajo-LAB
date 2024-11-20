
package heladeria.Productos;

import heladeria.Productos.Producto;
import java.sql.*;

public class Helado extends Producto{
    private String Sabor;

    public Helado() {
    }
    public Helado(String Sabor, int IDProducto, String Nombre, int Precio, String Tipo) {
        super(IDProducto, Nombre, Precio, Tipo);
        this.Sabor = Sabor;
    }
    

    
    public void VerHelados() {
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select nombre, precio, id from productos where tipo='helado' ";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            System.out.println("-------------HELADOS--------------");
            while(resultado.next()){
                System.out.print("Sabor: " + resultado.getString(1) + "\n");
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

    public String getSabor() {
        return Sabor;
    }
    

}
