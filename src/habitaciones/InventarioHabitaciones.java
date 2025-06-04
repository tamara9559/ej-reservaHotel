package habitaciones;

import java.util.ArrayList;
import java.util.List;

public class InventarioHabitaciones {
    private List<Habitacion> habitaciones;

    public InventarioHabitaciones(int cantidad) {
        habitaciones = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            if (i == cantidad) {
                habitaciones.add(new SuiteHabitacion(i)); // La última es suite
            } else {
                habitaciones.add(new Habitacion(i));
            }
        }
    }

    public List<Habitacion> disponibles() {
        return habitaciones.stream().filter(Habitacion::estaDisponible).toList();
    }

    public Habitacion getPorNumero(int numero) {
        return habitaciones.get(numero - 1);
    }

    public boolean estaDisponible(int numero) {
        return getPorNumero(numero).estaDisponible();
    }

    public void ocuparHabitaciones(List<Habitacion> habs) {
        habs.forEach(h -> h.setDisponible(false));
    }

    public int totalHabitaciones() {
        return habitaciones.size();
    }
}

