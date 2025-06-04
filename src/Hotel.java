import java.time.LocalDate;
import java.util.List;

public class Hotel {
    private final InventarioHabitaciones inventario;
    private final GestorReservas gestor;

    public Hotel(int cantidadHabitaciones) {
        this.inventario = new InventarioHabitaciones(cantidadHabitaciones);
        this.gestor = new GestorReservas(inventario);
    }

    public List<Habitacion> mostrarHabitacionesDisponibles() {
        return inventario.disponibles();
    }

    public Reserva hacerReserva(Cliente cliente, List<Integer> numerosHabitaciones, LocalDate fecha) {
        return gestor.hacerReserva(cliente, numerosHabitaciones, fecha);
    }

    public boolean cambiarFechaReserva(String id, LocalDate nuevaFecha) {
        return gestor.cambiarFecha(id, nuevaFecha);
    }

    public void listarReservas() {
        gestor.listarReservas();
    }

    public int getTotalHabitaciones() {
        return inventario.totalHabitaciones();
    }
}


