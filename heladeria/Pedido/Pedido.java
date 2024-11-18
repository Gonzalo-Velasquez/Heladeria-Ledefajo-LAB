
package heladeria.Pedido;

public class Pedido {
    private int total;
    private int IDPedido;

    public Pedido(int total, int IDPedido) {
        this.total = total;
        this.IDPedido = IDPedido;
    }
    
    public Pedido(){

    }
    
    public void calcularTotal(int precio, int cantidad){
     total = precio * cantidad;
        System.out.println("--- Total: "+total+" --- \n");
    }

    public int getTotal() {
        return total;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }
    
    
    

  
    
}
