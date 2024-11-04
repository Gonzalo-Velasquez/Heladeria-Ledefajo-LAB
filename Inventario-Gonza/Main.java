
package heladeria;

public class Main{
    public static void main(String[] args){
        ProductosVendidos venta = new
ProductosVendidos(1, 20, 101, 201);
        ProductosComprados compra = new
ProductosComprados(1, 20, 301);
        
        venta.mostrarInformacion();
        compra.mostrarInformacion();
        
    }
}