public class ObjSuper{

    private int Turno;
    private String Nombre;
    private int Servicio;
    private int Estado;
    private Double Precio;
    private int Caja;

    public ObjSuper(){

    }


    public ObjSuper(int turno, String nombre, int servicio, int estado, Double precio, int caja) {
        Turno = turno;
        Nombre = nombre;
        Servicio = servicio;
        Estado = estado;
        Precio = precio;
        Caja = caja;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getServicio() {
        return Servicio;
    }

    public void setServicio(int servicio) {
        Servicio = servicio;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public int getCaja() {
        return Caja;
    }

    public void setCaja(int caja) {
        Caja = caja;
    }


    public int getTurno() {
        return Turno;
    }


    public void setTurno(int turno) {
        Turno = turno;
    }
    
    

}