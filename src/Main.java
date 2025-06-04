import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel(5); // usamos la fachada

        while (true) {
            System.out.println("\n1. Ver habitaciones disponibles");
            System.out.println("2. Hacer reserva");
            System.out.println("3. Cambiar fecha de reserva");
            System.out.println("4. Ver reservas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    var disponibles = hotel.mostrarHabitacionesDisponibles();
                    if (disponibles.isEmpty()) {
                        System.out.println("No hay habitaciones disponibles.");
                    } else {
                        disponibles.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();
                    Cliente cliente = new Cliente(nombre);

                    System.out.print("Números de habitación separados por coma (ej: 1,2): ");
                    String[] tokens = sc.nextLine().split(",");
                    List<Integer> numeros = new ArrayList<>();
                    for (String token : tokens) numeros.add(Integer.parseInt(token.trim()));

                    System.out.print("Fecha (AAAA-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(sc.nextLine());

                    Reserva reserva = hotel.hacerReserva(cliente, numeros, fecha);
                    if (reserva != null) {
                        System.out.println("Reserva creada: " + reserva);
                    }
                }
                case 3 -> {
                    System.out.print("ID de reserva: ");
                    String id = sc.nextLine();
                    System.out.print("Nueva fecha (AAAA-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(sc.nextLine());
                    boolean actualizado = hotel.cambiarFechaReserva(id, fecha);
                    System.out.println(actualizado ? "Fecha actualizada." : "Reserva no encontrada.");
                }
                case 4 -> hotel.listarReservas();
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}



