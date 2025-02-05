public class Main {
    public static void main(String[] args) {
        // Configuración inicial del simulador
        String algoritmoPlanificacion = "FCFS"; // Algoritmo de planificación por defecto
        int duracionCiclo = 100; // Duración de un ciclo de ejecución en milisegundos
        int numeroProcesadores = 2; // Número de procesadores activos

        // Crear una instancia del simulador
        Simulador simulador = new Simulador(algoritmoPlanificacion, duracionCiclo, numeroProcesadores);

        // Crear la interfaz gráfica
      //  InterfazGrafica interfazGrafica = new InterfazGrafica(simulador);

        // Crear el gráfico de rendimiento
     //   GraficoRendimiento graficoRendimiento = new GraficoRendimiento();

        // Ejemplo de cómo agregar datos al gráfico (esto se puede hacer en la simulación)
        // graficoRendimiento.agregarDatos(1, 75.0); // Agregar un punto de rendimiento
        // graficoRendimiento.agregarDatos(2, 80.0); // Agregar otro punto de rendimiento

        // Mostrar el gráfico
     //   graficoRendimiento.mostrarGrafico();
    }
}
