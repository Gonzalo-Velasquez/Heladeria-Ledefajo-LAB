package heladeria;

public class Inventario{
    private int id;
    private int cantidad;
    
    public Inventario(int id, int cantidad){
        this.id=id;
        this.cantidad=cantidad;
    }
    
    public int getid(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int cantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    
    public void mostrarInformacion(){
        System.out.println("ID: " + id + ", Cantidad: " + cantidad);
    }
}
