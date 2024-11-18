
package heladeria.Productos;

import java.sql.*;
import java.util.*;


public class Combo extends Producto{
    private String combo;

    public Combo(String combo, int IDProducto, String Nombre, int Precio, String Tipo) {
        super(IDProducto, Nombre, Precio, Tipo);
        this.combo = combo;
    }

    public Combo() {

    }
    
    
    public void VerCombos() {
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select nombre, precio, id from productos where tipo='Combo' ";
            ResultSet resultado = instruccion.executeQuery(sql);
            System.out.println("--------------COMBO---------------");
            while(resultado.next()){
                System.out.print("Combo: " + resultado.getString(1) + "\n");
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
