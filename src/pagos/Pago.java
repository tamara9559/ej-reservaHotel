package pagos;

public interface Pago {
    boolean procesarPago(double monto);
    String getDescripcion();
}