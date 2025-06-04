package reservas;

import clientes.Cliente;
import habitaciones.Habitacion;
import pagos.Pago;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Reserva {
    protected String id;
    protected Cliente cliente;
    protected List<Habitacion> habitaciones;
    protected LocalDate fecha;
    protected Pago pago;


    public Reserva(Cliente cliente, List<Habitacion> habitaciones, LocalDate fecha, Pago pago) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.habitaciones = habitaciones;
        this.fecha = fecha;
        this.pago = pago;
    }

    public String getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public boolean procesarPago(double monto) {
        if (pago != null) {
            return pago.procesarPago(monto);
        }
        System.out.println("No se ha indicado método de pago.");
        return false;
    }

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

    public String getTipoReserva() {
        return "Estándar";
    }


}

