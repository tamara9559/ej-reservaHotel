package pagos;

public class PagoTarjetaCredito implements Pago {
    private String numeroTarjeta;

    public PagoTarjetaCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean procesarPago(double monto) {
        // Simulación de procesamiento
        System.out.println("Procesando pago por tarjeta: " + monto + "€");
        return true;
    }

   }