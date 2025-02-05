import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
    // Atributos
    private Queue<PCB> colaListos; // Cola de procesos listos
    private Queue<PCB> colaBloqueados; // Cola de procesos bloqueados
    private String algoritmoPlanificacion; // Algoritmo de planificación actual

    // Constructor
    public Scheduler(String algoritmoPlanificacion) {
        this.colaListos = new LinkedList<>();
        this.colaBloqueados = new LinkedList<>();
        this.algoritmoPlanificacion = algoritmoPlanificacion;
    }

    // Métodos

    // Método para agregar un proceso a la cola de listos
    public void agregarProceso(PCB pcb) {
        colaListos.add(pcb);
    }

    // Método para mover un proceso de la cola de listos a la cola de bloqueados
    public void bloquearProceso(PCB pcb) {
        colaListos.remove(pcb);
        colaBloqueados.add(pcb);
        pcb.actualizarEstado("Blocked");
    }

    // Método para desbloquear un proceso y moverlo de la cola de bloqueados a la cola de listos
    public void desbloquearProceso(PCB pcb) {
        colaBloqueados.remove(pcb);
        colaListos.add(pcb);
        pcb.actualizarEstado("Ready");
    }

    // Método para seleccionar el siguiente proceso a ejecutar según el algoritmo de planificación
    public PCB seleccionarProceso() {
        PCB procesoSeleccionado = null;

        switch (algoritmoPlanificacion) {
            case "FCFS": // First-Come, First-Served
                procesoSeleccionado = colaListos.poll();
                break;
            case "SJF": // Shortest Job First
                procesoSeleccionado = seleccionarSJF();
                break;
            case "Round Robin": // Round Robin
                procesoSeleccionado = seleccionarRoundRobin();
                break;
            // Agregar más algoritmos según sea necesario
            default:
                System.out.println("Algoritmo de planificación no reconocido.");
        }

        if (procesoSeleccionado != null) {
            procesoSeleccionado.actualizarEstado("Running");
        }
        return procesoSeleccionado;
    }

    // Método para seleccionar el proceso con el menor tiempo de ejecución (SJF)
    private PCB seleccionarSJF() {
        // Implementar lógica para seleccionar el proceso con menor cantidad de instrucciones
        return colaListos.stream()
                .min((p1, p2) -> Integer.compare(p1.getCantidadInstrucciones(), p2.getCantidadInstrucciones()))
                .orElse(null);
    }

    // Método para seleccionar el siguiente proceso en Round Robin
    private PCB seleccionarRoundRobin() {
        // Implementar lógica para Round Robin (puede requerir un puntero o índice)
        return colaListos.poll(); // Simplemente devuelve el primer proceso por ahora
    }

    // Getters
    public Queue<PCB> getColaListos() {
        return colaListos;
    }

    public Queue<PCB> getColaBloqueados() {
        return colaBloqueados;
    }

    public String getAlgoritmoPlanificacion() {
        return algoritmoPlanificacion;
    }

    // Método para cambiar el algoritmo de planificación
    public void cambiarAlgoritmoPlanificacion(String nuevoAlgoritmo) {
        this.algoritmoPlanificacion = nuevoAlgoritmo;
    }
}
