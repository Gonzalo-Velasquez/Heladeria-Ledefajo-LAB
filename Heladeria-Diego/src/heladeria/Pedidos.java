package heladeria;

import java.sql.*;

public class Pedidos {
    private String tipo;
    private Date fecha;
    private int total;

    public Pedidos(String tipo, Date fecha, int total) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getTotal() {
        return total;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}


