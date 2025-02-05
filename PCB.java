public class PCB {
    // Atributos
    private int id; // ID del proceso
    private String estado; // Estado del proceso (Running, Blocked, Ready)
    private int programCounter; // Valor del Program Counter (PC)
    private int memoryAddressRegister; // Estado del Memory Address Register (MAR)

    // Constructor
    public PCB(int id, String estado, int programCounter, int memoryAddressRegister) {
        this.id = id;
        this.estado = estado;
        this.programCounter = programCounter;
        this.memoryAddressRegister = memoryAddressRegister;
    }

    // Métodos

    // Método para actualizar el estado del PCB
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Método para actualizar el Program Counter
    public void actualizarProgramCounter(int nuevoValor) {
        this.programCounter = nuevoValor;
    }

    // Método para actualizar el Memory Address Register
    public void actualizarMemoryAddressRegister(int nuevoValor) {
        this.memoryAddressRegister = nuevoValor;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public int getMemoryAddressRegister() {
        return memoryAddressRegister;
    }

    // Método para obtener información del PCB en formato String
    @Override
    public String toString() {
        return "PCB{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", programCounter=" + programCounter +
                ", memoryAddressRegister=" + memoryAddressRegister +
                '}';
    }
}
