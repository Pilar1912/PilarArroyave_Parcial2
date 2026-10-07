import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Menu {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<ObjSuper> cola = new LinkedList<>();
    Metodos m = new Metodos();
    boolean continuar = true;

    while(continuar){
        System.out.println("¿Que desea realizar");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Mostrar los clientes de la caja 1.");
            System.out.println("3. Mostrar los clientes de la caja 2.");
            System.out.println("4. Abandonar fila.");
            System.out.println("5. Cambiar de fila.");
            System.out.println("6. Atender clientes de la caja 1.");
            System.out.println("7. Atender clientes de la caja 2.");
            System.out.println("8. Salir.");
            int opt = m.ValidarEntero(sc);
            switch (opt) {
                case 1:
                    cola = m.IngresarClientes(cola, sc, m);
                    break;
                case 2:
                    System.out.println("\n Clientes de la caja 1: " +  m.MostrarClientesCadaCaja(cola, 1));
                    break;
                case 3:
                    System.out.println("\n Clientes de la caja 1: " +  m.MostrarClientesCadaCaja(cola, 2));
                    break;
                case 4:
                    m.AbandonarFila(cola, sc, m);
                    break;
                case 5:
                    m.CambiarCaja(cola, sc, m);
                    break;
                case 6:
                    m.Atender(cola, 1);
                    break;
                case 7:
                    m.Atender(cola, 2);
                    break;
                case 8:
                    System.out.println("Hasta luego.");
                    continuar = false;
                    break;
            
                default:
                    System.out.println("Opción inválida. Ingrese un número del 1 al 6.");
                    break;
            }

    }
}
    
}
