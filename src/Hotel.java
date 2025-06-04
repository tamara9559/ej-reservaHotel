import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Hotel(int cantidadHabitaciones) {
        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public List<Habitacion> mostrarHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion h : habitaciones) {
            if (h.estaDisponible()) disponibles.add(h);
        }
        return disponibles;
    }

    public Reserva hacerReserva(Cliente cliente, List<Integer> numerosHabitaciones, LocalDate fecha) {
        List<Habitacion> seleccionadas = new ArrayList<>();
        for (int num : numerosHabitaciones) {
            Habitacion hab = habitaciones.get(num - 1);
            if (hab.estaDisponible()) {
                hab.setDisponible(false);
                seleccionadas.add(hab);
            }
        }
        Reserva reserva = new Reserva(cliente, seleccionadas, fecha);
        reservas.add(reserva);
        return reserva;
    }

    public boolean cambiarFechaReserva(String id, LocalDate nuevaFecha) {
        for (Reserva r : reservas) {
            if (r.getId().equals(id)) {
                r.setFecha(nuevaFecha);
                return true;
            }
        }
        return false;
    }

    public void listarReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }
}

