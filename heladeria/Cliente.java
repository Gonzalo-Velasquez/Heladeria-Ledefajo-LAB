
package heladeria;

import java.util.*;
import java.sql.*;

public class Cliente {
    private String nombre;
    private String dirrecion;
    private int  IDCliente;


    
    Scanner sc = new Scanner(System.in);
    
    public void IngresarDatos(){
        String url = "jdbc:mysql://localhost:3306/Heladeria";
        
        System.out.print("Ingrese el nombre del cliente: ");
        nombre = sc.nextLine();
        
        System.out.print("Ingrese la direccion del cliente: ");
        dirrecion = sc.nextLine();
        
        Connection conexion = ConexionDB.conectar();

        try {

            String sql = "INSERT INTO clientes (nombre_cliente, direccion_cliente) VALUES (?,?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, dirrecion);
                
                int filasAfectadas = preparedStatement.executeUpdate();
                
                if (filasAfectadas > 0) {
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    System.out.println("Cliente anadido exitosamente.");
                    
                    if (generatedKeys.next()) {
                        IDCliente = generatedKeys.getInt(1); 
                        System.out.println("ID del cliente: " + IDCliente);
                } else {
                    System.out.println("No se pudo añadir el cliente.");
                }
            }
            conexion.close();
        }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }
}