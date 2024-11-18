package heladeria;

import java.util.*;
import java.sql.*;

public class Vendedor extends Empleado{
    private String turno;
    private int salario;

    public Vendedor(String nombre, String rol, String turno, int salario) {
        super(nombre, rol);
        this.turno = turno;
        this.salario = salario;
    }
    
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void MostrarDatos() {
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select id, nombre, rol from empleados where rol = 'Vendedor'";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()) {
                System.out.print("Id Empleado:" + resultado.getInt(1)+ "\n");
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
}
