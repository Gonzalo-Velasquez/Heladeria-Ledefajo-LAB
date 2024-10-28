package heladeria;

import java.sql.*;

public class ver {
    public void batidos() {
       
        //Paso 1. Creamos nuestra cadena de conexion a mysql
        String url = "jdbc:mysql://localhost:3306/Heladeria";
       
        try {
            //Paso 2. Creamos el objeto de conexion a la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "");
            //Paso 3. Creamos un objeto Statement
            Statement instruccion = conexion.createStatement();
            //Paso 4. Creamos el query
            String sql = "select Sabor_Batido, Tamanio_batido, Nombre_Batido from batido";
            //Paso 5. Ejecucion del query
            ResultSet resultado = instruccion.executeQuery(sql);
            //Paso 6. Procesamos el resultado
            while(resultado.next()){
                System.out.print("Sabor Batido:" + resultado.getInt(1));
                System.out.print(" Tamanio batido:" + resultado.getString(2));
                System.out.print(" Nombre Batido:" + resultado.getString(3));
            }
            //Cerramos cada objeto que hemos utilizado
            resultado.close();
            instruccion.close();
            conexion.close();
               
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

