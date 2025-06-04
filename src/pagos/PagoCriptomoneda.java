package pagos;

public class PagoCriptomoneda implements Pago {
    private String billetera;

    public PagoCriptomoneda(String billetera) {
        this.billetera = billetera;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Procesando pago en criptomoneda: " + monto + "€ a la billetera " + billetera);
        return true;
    }

    @Override
    public String getDescripcion() {
        return "Pago con criptomoneda";
    }
}
