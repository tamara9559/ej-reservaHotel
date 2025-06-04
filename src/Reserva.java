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
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva ID: ").append(id)
                .append(", Cliente: ").append(cliente.getNombre())
                .append(", Fecha: ").append(fecha)
                .append(", Habitaciones: [");

        for (int i = 0; i < habitaciones.size(); i++) {
            sb.append(habitaciones.get(i).getNumero());
            if (i < habitaciones.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

