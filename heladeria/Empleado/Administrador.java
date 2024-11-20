
package heladeria.Administrador;

import java.util.*;
import java.sql.*;

public class Administrador extends Empleado{
    

    public Administrador(String nombre, String rol) {
        super(nombre, rol);
    }
    

    
    public Administrador(){
    
    }
    
    Scanner sc=new Scanner(System.in);
    
    @Override
    public void MostrarDatos() {
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select id, nombre, rol from empleados";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()) {
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
    
    public void AñadirEmpleado() {
        Connection conexion = heladeria.ConexionDB.conectar();

        try {
            System.out.print("Ingrese el nombre del empleado: ");
            nombre = sc.next();
            System.out.println("Ingrese el rol del empleado: ");
            rol = sc.next();


            String sql = "INSERT INTO empleados (nombre, rol) VALUES (?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, rol);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Empleado añadido exitosamente.");
                } else {
                    System.out.println("No se pudo añadir el empleado.");
                }
                preparedStatement.close();
            }

            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    
    }

}
