import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Reserva {
    private String id;
    private Cliente cliente;
    private List<Habitacion> habitaciones;
    private LocalDate fecha;

    public Reserva(Cliente cliente, List<Habitacion> habitaciones, LocalDate fecha) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.habitaciones = habitaciones;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Reserva ID: " + id + ", Cliente: " + cliente.getNombre() + ", Fecha: " + fecha;
    }
}

