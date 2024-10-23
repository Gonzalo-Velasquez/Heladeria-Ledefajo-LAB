package javaapplication1;

import javaapplication1.ConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConexionDB.conectar();

        if (connection != null) {
            try {
                // Prepara la consulta SQL para insertar los datos
                String insertQuery = "INSERT INTO Heladeria (nombre, apellido, cargo, horas_trabajadas, valor_hora, sueldo) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, 'nombre');
                preparedStatement.setString(2, 'apellido');
                preparedStatement.setString(3, 'cargo');
                preparedStatement.setInt(4, 'horas_trabajadas');
                preparedStatement.setInt(5, 'valor_hora');
                preparedStatement.setInt(6, 'sueldo');

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
    }

}
