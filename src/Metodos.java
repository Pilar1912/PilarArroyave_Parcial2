
import java.util.Scanner;
import java.util.Queue;

public class Metodos {

    public Queue<ObjSuper> IngresarClientes(Queue<ObjSuper> cola, Scanner sc, Metodos m){
        Boolean continuar = true;

        while(continuar){
            ObjSuper o = new ObjSuper();
            o.setTurno(m.ValidarTurno(cola));

            System.out.println("Ingrese el nombre del cliente:");
            o.setNombre(sc.next());
            
            System.out.println("Seleccione cual servicio va a realizar :");
            o.setServicio(m.Servicios2(sc));

            System.out.println("Ingrese el valor del servicio a realizar: ");
            o.setPrecio(m.ValidarDecimal(sc));

            System.out.println("Ingrese el número de caja en la que está haciendo fila, en la caja 1 o en la 2: ");
            o.setCaja(m.ValidarEntero(sc));

            o.setEstado(1); //ESTADO PENDIENTE
            System.out.println("Desea agregar mas clientes 1. SI \n 2. NO");
            int opt = m.ValidarEntero(sc);
            if (opt == 2) {
                System.out.println("Vuelve pronto");
                continuar = false;
            }
            cola.offer(o);
        }

        return cola;
    }

    public String MostrarClientesCadaCaja(Queue<ObjSuper> cola, int opt){
        switch (opt) {
            case 1:
            for (ObjSuper o : cola) {
                if(o.getCaja() == 1){
                    System.out.println("-----DATOS DE LOS CLIENTES DE LA CAJA 1-----");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Servicio: " + o.getServicio());
                    if(o.getEstado() == 1){
                        System.out.println("Estado: Pendiente.");
                    }else{
                        System.out.println("Estado: Atendido.");
                    }
                        System.out.println("Valor a pagar: " + o.getPrecio());
                    }
                }
                
                break;
                case 2:

                for (ObjSuper o : cola) {
                if(o.getCaja() == 2){
                    System.out.println("-----DATOS DE LOS CLIENTES DE LA CAJA 2-----");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Servicio: " + o.getServicio());
                    if(o.getEstado() == 1){
                        System.out.println("Estado: Pendiente.");
                    }else{
                        System.out.println("Estado: Atendido.");
                    }
                        System.out.println("Valor a pagar: " + o.getPrecio());
                    }
                }
                    break;
        
            default:
                System.out.println("Esa caja no existe, solo hay dos.");
                break;
        }


        return "DATOS MOSTRADOS CORRECTAMENTE";
    }

    public Queue<ObjSuper> AbandonarFila(Queue<ObjSuper> cola, Scanner sc, Metodos m){
        System.out.println("Ingrese el número de turno que abandonara la fila:");
        int buscado = m.ValidarEntero(sc);
        boolean encontrado = false;

        for (ObjSuper o : cola) {
                if(o.getEstado() == 1 && o.getTurno() == buscado){
                    encontrado = true;
                    System.out.println("-----DATOS DEL CLIENTE ABANDONADOR-----");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Servicio: " + o.getServicio());
                    System.out.println("Valor a pagar: " + o.getPrecio());
                    System.out.println("------------------------------------");
                    }else{
                        System.out.println("El turno ya abandonó la fila.");
                    }
                }
                cola.remove();
                

        if (!encontrado) {
            System.out.println("El cliente con identificación " + buscado + " no se encuentra registrado aún.\n");
        }
        
        return cola;
    }

    public String Atender(Queue<ObjSuper> cola, int opt){
        switch (opt) {
            case 1:
            for (ObjSuper o : cola) {
                if(o.getEstado() == 1 && o.getCaja() ==1){
                    System.out.println("-----DATOS DE LOS CLIENTES DE LA CAJA 1-----");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Servicio: " + o.getServicio());
                    o.setEstado(2);
                        System.out.println("Valor a pagar: " + o.getPrecio());
                    }
                }
                
                break;
                case 2:

                for (ObjSuper o : cola) {
                if(o.getEstado() == 1 && o.getCaja() == 2){
                    System.out.println("-----DATOS DE LOS CLIENTES DE LA CAJA 2-----");
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println("Nombre: " + o.getNombre());
                    System.out.println("Servicio: " + o.getServicio());
                    o.setEstado(2);
                        System.out.println("Valor a pagar: " + o.getPrecio());
                    }
                }
                    break;
        
            default:
                System.out.println("Esa caja no existe, solo hay dos.");
                break;
        }


        return "DATOS MOSTRADOS CORRECTAMENTE";
    }


    public Queue<ObjSuper> CambiarCaja(Queue<ObjSuper> cola, Scanner sc, Metodos m){
        System.out.println("Ingrese el número de turno que cambiará de caja:");
        int buscado = m.ValidarEntero(sc);
        boolean encontrado = false;

        for (ObjSuper o : cola) {
            if (o.getTurno() == buscado && o.getCaja() == 1) {
                encontrado = true;
                o.setCaja(2);
            }else if(o.getTurno() == buscado && o.getCaja() == 2){
                encontrado = true;
                o.setCaja(1);

            }
            System.out.println("Cliente cambio exitosamente.");
            
        }

        if (!encontrado) {
            System.out.println("El cliente con identificación " + buscado + " no se encuentra registrado aún.\n");
        }

        return cola;
    }



    public int ValidarEntero(Scanner sc){
        while(!sc.hasNextInt()){
            System.out.println("Ingrese un número entero válido, ojala de 1 a 5: ");
            sc.next();
        }
        return sc.nextInt();
    }

    public Double ValidarDecimal(Scanner sc){
        while(!sc.hasNextDouble()){
            System.out.println("Ingrese un número entero válido, que sea decimal");
            sc.next();
        }
        return sc.nextDouble();
    }

     private static String Servicio(int opt) {
        String mensaje = "";
        switch (opt) {
            case 1:
                mensaje = "pagar compra";
                break;
            case 2:
                mensaje = "consignar";
                break;
            case 3:
                mensaje = "pagar servicios";
                break;

            default:
                mensaje = "Ninguna.";
                break;
        }
        return mensaje;
    }

    private int Servicios2(Scanner sc){
        System.out.println("1. pagar compra");
        System.out.println("2. consignar");
        System.out.println("3. pagar servicios");
        System.out.println("4. Ninguna");
        return sc.nextInt();
    }

    public int ValidarTurno(Queue<ObjSuper> cola) {
        int turno = 0;
        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }

    
    
}
