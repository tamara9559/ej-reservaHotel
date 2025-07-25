import clientes.Cliente;
import habitaciones.Habitacion;
import habitaciones.InventarioHabitaciones;
import pagos.Pago;
import reservas.GestorReservas;
import reservas.Reserva;

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

    public Reserva hacerReserva(Cliente cliente, List<Integer> numerosHabitaciones, LocalDate fecha, Pago pago) {
        return gestor.hacerReserva(cliente, numerosHabitaciones, fecha, pago);
    }

    public boolean cambiarFechaReserva(String id, LocalDate nuevaFecha) {
        return gestor.cambiarFecha(id, nuevaFecha);
    }

    public void listarReservas() {
        gestor.listarReservas();
    }

}


