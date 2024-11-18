package heladeria;

import java.util.*;
import java.sql.*;

public class Empleado {
    private String nombre;
    private String rol;

    public Empleado(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    Scanner sc = new Scanner(System.in);
    
    public void MostrarDatos(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "select id, nombre, rol from empleados";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
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
