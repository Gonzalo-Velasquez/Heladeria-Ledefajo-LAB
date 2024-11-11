
package heladeria;

import java.sql.*;

public class Productos {
    private String Nombre;
    private int Precio;

    public Productos(String Nombre, int Precio) {
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    
    
}
