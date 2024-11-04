package heladeria;

public class ProductosVendidos extends Inventario{
    private int ventaid;
    private int clienteid;

    public ProductosVendidos(int id, int cantidad, int ventaid, int clienteid){
        super(id, cantidad);
        this.ventaid=ventaid;
        this.clienteid=clienteid;
    }
    
    public int getventaid(){
        return ventaid;
    }
    
    public void setventaid(int ventaid){
        this.ventaid=ventaid;
    }
    
    public int getclienteid(){
        return clienteid;
    }
    
    public void setclienteid(int clienteid){
        this.clienteid=clienteid;
    }
    
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Venta ID: " + ventaid + ", Cliente ID: " + clienteid);
        
        
    }
}

