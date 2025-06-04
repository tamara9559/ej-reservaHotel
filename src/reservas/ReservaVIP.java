package reservas;

import clientes.Cliente;
import habitaciones.Habitacion;
import pagos.Pago;

import java.time.LocalDate;
import java.util.List;

public class ReservaVIP extends Reserva {
    private String beneficio;

    public ReservaVIP(Cliente cliente, List<Habitacion> habitaciones, LocalDate fecha, Pago pago, String beneficio) {
        super(cliente, habitaciones, fecha,pago);
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

