
package heladeria;

public class Pedido {
    private String fecha;
    private String tipo;


    public Pedido(String fecha, String tipo) {
        this.fecha = fecha;
        this.tipo = tipo;

    }
    
    public Pedido(){
        
    }
    
    public void calcularTotal(int precio, int cantidad){

    }
    
    
    public String getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }



    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  
    
}
