import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Reserva> reservas = new ArrayList<>();
    private InventarioHabitaciones inventario;

    public GestorReservas(InventarioHabitaciones inventario) {
        this.inventario = inventario;
    }

    public Reserva hacerReserva(Cliente cliente, List<Integer> numeros, LocalDate fecha) {
        List<Habitacion> seleccionadas = new ArrayList<>();

        for (int num : numeros) {
            if (num < 1 || num > inventario.totalHabitaciones()) {
                System.out.println("La habitación " + num + " no existe.");
                return null;
            }

            if (!inventario.estaDisponible(num)) {
                System.out.println("La habitación " + num + " ya está reservada.");
                return null;
            }

            seleccionadas.add(inventario.getPorNumero(num));
        }

        inventario.ocuparHabitaciones(seleccionadas);
        Reserva reserva = new Reserva(cliente, seleccionadas, fecha);
        reservas.add(reserva);
        return reserva;
    }

    public boolean cambiarFecha(String id, LocalDate nuevaFecha) {
        for (Reserva r : reservas) {
            if (r.getId().equals(id)) {
                r.setFecha(nuevaFecha);
                return true;
            }
        }
        return false;
    }

    public void listarReservas() {
        reservas.forEach(System.out::println);
    }
}

