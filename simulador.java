import java.util.Scanner;

public class Simulador {
    // Atributos
    private Scheduler scheduler; // Planificador de procesos
    private int duracionCiclo; // Duración de un ciclo de ejecución (en ms)
    private int numeroProcesadores; // Número de procesadores activos
    private boolean enEjecucion; // Estado de la simulación

    // Constructor
    public Simulador(String algoritmoPlanificacion, int duracionCiclo, int numeroProcesadores) {
        this.scheduler = new Scheduler(algoritmoPlanificacion);
        this.duracionCiclo = duracionCiclo;
        this.numeroProcesadores = numeroProcesadores;
        this.enEjecucion = false;
    }

    // Método para iniciar la simulación
    public void iniciarSimulacion() {
        enEjecucion = true;
        System.out.println("Simulación iniciada con el algoritmo de planificación: " + scheduler.getAlgoritmoPlanificacion());

        while (enEjecucion) {
            ejecutarCiclo();
            pausarCiclo();
        }
    }

    // Método para ejecutar un ciclo de la simulación
    private void ejecutarCiclo() {
        for (int i = 0; i < numeroProcesadores; i++) {
            PCB proceso = scheduler.seleccionarProceso();
            if (proceso != null) {
                // Simular la ejecución del proceso
                System.out.println("Ejecutando proceso: " + proceso.getNombre());
                // Aquí se puede agregar lógica para simular el tiempo de ejecución
                try {
                    Thread.sleep(duracionCiclo); // Simula la duración del ciclo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Actualizar el estado del proceso después de la ejecución
                proceso.actualizarProgramCounter(proceso.getProgramCounter() + 1); // Incrementar el PC
                // Lógica para manejar el final del proceso o excepciones
                if (proceso.getCantidadInstrucciones() <= 0) {
                    proceso.finalizar(); // Finalizar el proceso si no hay más instrucciones
                    System.out.println("Proceso finalizado: " + proceso.getNombre());
                } else {
                    // Si el proceso necesita ser bloqueado, se puede llamar a bloquearProceso
                    // scheduler.bloquearProceso(proceso);
                }
            }
        }
    }

    // Método para pausar el ciclo (opcional, para permitir interacción del usuario)
    private void pausarCiclo() {
        // Aquí se puede implementar lógica para pausar la simulación o recibir comandos del usuario
        // Por ejemplo, permitir al usuario cambiar el algoritmo de planificación
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presione 'q' para salir o 'c' para continuar...");
        String input = scanner.nextLine();
        if (input.equals("q")) {
            enEjecucion = false; // Terminar la simulación
        }
    }

    // Método para cambiar el algoritmo de planificación
    public void cambiarAlgoritmoPlanificacion(String nuevoAlgoritmo) {
        scheduler.cambiarAlgoritmoPlanificacion(nuevoAlgoritmo);
        System.out.println("Algoritmo de planificación cambiado a: " + nuevoAlgoritmo);
    }

    // Getters y Setters
    public int getDuracionCiclo() {
        return duracionCiclo;
    }

    public void setDuracionCiclo(int duracionCiclo) {
        this.duracionCiclo = duracionCiclo;
    }

    public int getNumeroProcesadores() {
        return numeroProcesadores;
    }

    public void setNumeroProcesadores(int numeroProcesadores) {
        this.numeroProcesadores = numeroProcesadores;
    }
}
