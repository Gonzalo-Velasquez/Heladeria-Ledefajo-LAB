
package heladeria.Pedido;

public class Pedido {
    protected double total;
    private int IDPedido;
    protected int cantidad;

    public Pedido(int total, int IDPedido, int cantidad) {
        this.total = total;
        this.IDPedido = IDPedido;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    public Pedido(){

    }
    
    public void calcularTotal(double precio, int cantidad){
     total = precio * cantidad;
        System.out.println("--- Total: "+total+" --- \n");
    }



    public double getTotal() {
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
