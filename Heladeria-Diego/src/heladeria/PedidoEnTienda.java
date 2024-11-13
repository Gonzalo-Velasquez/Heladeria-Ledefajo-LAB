
package heladeria;

import java.util.*;
import java.sql.*;

public class PedidoEnTienda extends Pedidos{
    private String estado;
    private int numero;
    
    Scanner sc = new Scanner(System.in);

    public PedidoEnTienda(String estado, int numero, String tipo, java.sql.Date fecha, int total) {
        super(tipo, fecha, total);
        this.estado = estado;
        this.numero = numero;
    }

    
}
