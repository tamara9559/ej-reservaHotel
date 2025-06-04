package reservas;

import clientes.Cliente;
import habitaciones.Habitacion;
import java.time.LocalDate;
import java.util.List;

public class ReservaVIP extends Reserva {
    private String beneficio;

    public ReservaVIP(Cliente cliente, List<Habitacion> habitaciones, LocalDate fecha, String beneficio) {
        super(cliente, habitaciones, fecha);
        this.beneficio = beneficio;
    }

    @Override
    public String getTipoReserva() {
        return "VIP";
    }

    @Override
    public String toString() {
        return super.toString() + " (Beneficio: " + beneficio + ")";
    }
}

