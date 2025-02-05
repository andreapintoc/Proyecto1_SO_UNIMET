public class Excepcion {
    // Atributos
    private String tipo; // Tipo de excepción (por ejemplo, "I/O", "Interrupción")
    private Proceso proceso; // Proceso asociado a la excepción
    private int ciclosParaSatisfacer; // Ciclos necesarios para satisfacer la excepción

    // Constructor
    public Excepcion(String tipo, Proceso proceso, int ciclosParaSatisfacer) {
        this.tipo = tipo;
        this.proceso = proceso;
        this.ciclosParaSatisfacer = ciclosParaSatisfacer;
    }

    // Métodos

    // Método para manejar la excepción
    public void manejarExcepcion() {
        System.out.println("Manejando excepción de tipo: " + tipo + " para el proceso: " + proceso.getNombre());
        // Simular el tiempo necesario para satisfacer la excepción
        try {
            Thread.sleep(ciclosParaSatisfacer * 100); // Multiplicamos por 100 para simular el tiempo en ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Después de manejar la excepción, se puede volver a poner el proceso en la cola de listos
        proceso.desbloquear(); // Cambiar el estado del proceso a "Ready"
        System.out.println("Excepción manejada. Proceso " + proceso.getNombre() + " está listo para continuar.");
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public int getCiclosParaSatisfacer() {
        return ciclosParaSatisfacer;
    }

    // Método para obtener información de la excepción en formato String
    @Override
    public String toString() {
        return "Excepcion{" +
                "tipo='" + tipo + '\'' +
                ", proceso=" + proceso.getNombre() +
                ", ciclosParaSatisfacer=" + ciclosParaSatisfacer +
                '}';
    }
}
