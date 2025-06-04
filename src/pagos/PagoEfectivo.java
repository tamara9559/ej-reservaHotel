package pagos;

public class PagoEfectivo implements Pago {

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago en efectivo recibido: " + monto + "€");
        return true;
    }

    @Override
    public String getDescripcion() {
        return "Pago en efectivo";
    }
}