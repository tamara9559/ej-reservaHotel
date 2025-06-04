import clientes.Cliente;
import pagos.Pago;
import pagos.PagoCriptomoneda;
import pagos.PagoEfectivo;
import pagos.PagoTarjetaCredito;
import reservas.Reserva;
import habitaciones.Minibar;
import habitaciones.Jacuzzi;

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
                        for (var habitacion : disponibles) {
                            System.out.println(habitacion);
                            // Si la habitación tiene minibar
                            if (habitacion instanceof Minibar) {
                                System.out.println("  - Esta habitación incluye minibar.");
                            }
                            // Si la habitación tiene jacuzzi
                            if (habitacion instanceof Jacuzzi) {
                                System.out.println("  - Esta habitación incluye jacuzzi.");
                            }
                        }
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

                    // Selección de método de pago
                    System.out.println("Método de pago:");
                    System.out.println("1. Tarjeta de crédito");
                    System.out.println("2. Efectivo");
                    System.out.println("3. Criptomoneda");
                    System.out.print("Seleccione opción: ");
                    int pagoOpcion = sc.nextInt();
                    sc.nextLine();

                    Pago pago = null;
                    switch (pagoOpcion) {
                        case 1 -> {
                            System.out.print("Número de tarjeta: ");
                            String tarjeta = sc.nextLine();
                            pago = new PagoTarjetaCredito(tarjeta);
                        }
                        case 2 -> pago = new PagoEfectivo();
                        case 3 -> {
                            System.out.print("Dirección billetera: ");
                            String billetera = sc.nextLine();
                            pago = new PagoCriptomoneda(billetera);
                        }
                        default -> System.out.println("Opción de pago no válida.");
                    }

                    Reserva reserva = null;
                    if (pago != null) {
                        reserva = hotel.hacerReserva(cliente, numeros, fecha, pago);
                        if (reserva != null) {
                            double monto = 100.0; // Puedes calcular monto real si lo deseas
                            boolean pagado = reserva.procesarPago(monto);
                            if (pagado) {
                                System.out.println("Reserva creada y pagada: " + reserva);
                                // Acciones especiales para habitaciones reservadas
                                for (var hab : reserva.getHabitaciones()) {
                                    if (hab instanceof Minibar minibar) {
                                        minibar.reponerMinibar();
                                    }
                                    if (hab instanceof Jacuzzi jacuzzi) {
                                        jacuzzi.limpiarJacuzzi();
                                    }
                                }
                            } else {
                                System.out.println("Error en el pago. Reserva no completada.");
                            }
                        }
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



