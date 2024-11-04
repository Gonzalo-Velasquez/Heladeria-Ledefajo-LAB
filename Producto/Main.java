package heladeria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int op;
        
        System.out.println("Bienvenido al Sistema LEDEFAJO" + "\n");
        do {
            System.out.println("Menu (Elegir un numero): \n"
                    + "1. Inventario \n"
                    + "2. Productos \n"
                    + "3. Ventas \n"
                    + "4. Salir \n");
            op = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            
            switch (op) {
                case 1:
                    System.out.println("----------------------------------");                        
                    System.out.println("Este es el inventario");
                    System.out.println("---------------------------------- \n");
                    
                    break;
                case 2:
                    System.out.println("----------------------------------");                        
                    System.out.println("Este es el Producto");
                    System.out.println("---------------------------------- \n");                        
                    break;
                case 3:
                    System.out.println("----------------------------------");                        
                    System.out.println("Este es el Ventas");
                    System.out.println("---------------------------------- \n");                        
                    break;
                case 4:
                    System.out.println("---------------------------------- ");                        
                    System.out.println("Se salió del Sistema");
                    System.out.println("---------------------------------- \n");                        
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
                }
        } while (op != 4);
        
        sc.close(); // Cerrar el scanner
    }
}
