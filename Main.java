package github;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
class MenuDeOpciones{
    private HashMap<String, Double> productos = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void Menu(){
        int opcion = 1;
        do { 
            System.out.println("================================");
            System.out.println("       MENU DE OPCIONES         ");
            System.out.println("1. Agregar Producto.");
            System.out.println("2. Vender Producto.");
            System.out.println("3. Mostrar productos.");
            System.out.println("4. Salir.");
            System.out.println("================================");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("ERROR.... "+ e.getMessage());
                sc.nextLine();
            }
            if(opcion > 0){
                switch (opcion) {
                    case 1 -> agregarProducto();
                    case 2 -> venderProducto();
                    case 3 -> mostrarProductos();
                    case 4 -> {
                        System.out.println(" saliendo del programa...");
                        break;
                    }
                    default -> System.out.println("opcion invalida. intenta de nuevo");
                }
            }
        } while (true);
    }
}
class Final{
    public void finalizar(){
        System.out.println("===============================");
        System.out.println("GRACIAS POR SU PREFERECIA");
        System.out.println("===============================");
    }
}
class Hora{
    public void imprimirDatos(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter Formatohora = DateTimeFormatter.ofPattern("HH:mm");

        String hora = ahora.format(Formatohora);
        String fecha = ahora.format(formato);

        String[] Cajeros = { "Ricoy", "Ana", "Luis"};
        String cajero = Cajeros[0];

        System.out.println("-------------------------------");
        System.out.println("fecha:  " + fecha + "  Hora: " + hora);
        System.out.println("Cajero: " + cajero);
        System.out.println("-------------------------------");
    }
}
class Imprimir {
    public void imprimirEncabezado(){
        System.out.println("===============================");
        System.out.println("  SUPERMERCADO LA ESQUINA ");
        System.out.println("  RFC: XXX-XXX-XX ");
        System.out.println("-------------------------------");
    }
}
public class Main{
    public static void main(String[] args){
        Imprimir mo = new Imprimir();
        Hora mp = new Hora();
        Final fp = new Final();
        mo.imprimirEncabezado();
        mp.imprimirDatos();
        fp.finalizar();
        
    }
}