package heladeria;

public class ProductosComprados extends Inventario{
    private int compraid;
    
    public ProductosComprados(int id, int cantidad, int compraid){
        super(id, cantidad);
        this.compraid=compraid;
    }
    
    public int getcompraid(){
        return compraid;
    }
    
    public void setcompraid(int compraid){
        this.compraid=compraid;
    }
    
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Compra ID: " + compraid);
    }
    
}
