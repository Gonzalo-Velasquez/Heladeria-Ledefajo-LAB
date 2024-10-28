package heladeria;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConexionDB.conectar();

        if (connection != null) {
            try {
                // Prepara la consulta SQL para insertar los datos
                String insertQuery = "INSERT INTO batido (Sabor_Batido, Tamanio_batido, Nombre_Batido) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, "limon");
                preparedStatement.setString(2, "Pequeño");
                preparedStatement.setString(3, "Limonaso");

                // Ejecuta la consulta
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Datos insertados correctamente en la base de datos.");
                } else {
                    System.out.println("No se pudieron insertar los datos.");
                }

                // Cierra la conexión
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al insertar datos en la base de datos: " + e.getMessage());
            }
        } else {
            System.err.println("No se pudo establecer la conexión a la base de datos.");
        }
        
        ver ver =new ver();
        
        ver.batidos();
        
    }

}
