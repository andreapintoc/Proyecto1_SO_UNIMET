public class Proceso {
    // Atributos
    private int id; // ID único del proceso
    private String nombre; // Nombre del proceso
    private String estado; // Estado del proceso (Running, Blocked, Ready)
    private int cantidadInstrucciones; // Cantidad de instrucciones del proceso
    private boolean esCpuBound; // Indica si es CPU bound o I/O bound
    private int ciclosParaExcepcion; // Ciclos para generar una excepción
    private int ciclosParaSatisfacerExcepcion; // Ciclos para satisfacer la excepción

    // Constructor
    public Proceso(int id, String nombre, int cantidadInstrucciones, boolean esCpuBound, 
                   int ciclosParaExcepcion, int ciclosParaSatisfacerExcepcion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadInstrucciones = cantidadInstrucciones;
        this.esCpuBound = esCpuBound;
        this.ciclosParaExcepcion = ciclosParaExcepcion;
        this.ciclosParaSatisfacerExcepcion = ciclosParaSatisfacerExcepcion;
        this.estado = "Ready"; // Estado inicial
    }

    // Métodos

    // Método para iniciar el proceso
    public void iniciar() {
        this.estado = "Running";
    }

    // Método para bloquear el proceso
    public void bloquear() {
        this.estado = "Blocked";
    }

    // Método para desbloquear el proceso
    public void desbloquear() {
        this.estado = "Ready";
    }

    // Método para finalizar el proceso
    public void finalizar() {
        this.estado = "Terminated";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getCantidadInstrucciones() {
        return cantidadInstrucciones;
    }

    public boolean isCpuBound() {
        return esCpuBound;
    }

    public int getCiclosParaExcepcion() {
        return ciclosParaExcepcion;
    }

    public int getCiclosParaSatisfacerExcepcion() {
        return ciclosParaSatisfacerExcepcion;
    }

    // Método para obtener información del proceso en formato String
    @Override
    public String toString() {
        return "Proceso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", cantidadInstrucciones=" + cantidadInstrucciones +
                ", esCpuBound=" + esCpuBound +
                ", ciclosParaExcepcion=" + ciclosParaExcepcion +
                ", ciclosParaSatisfacerExcepcion=" + ciclosParaSatisfacerExcepcion +
                '}';
    }
}
