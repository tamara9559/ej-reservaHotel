package habitaciones;

public class SuiteHabitacion extends Habitacion implements Minibar, Jacuzzi {
    private boolean minibarRep = true;
    private boolean jacuzziLimpio = true;

    public SuiteHabitacion(int numero) {
        super(numero);
    }

    @Override
    public void reponerMinibar() {
        minibarRep = true;
        System.out.println("Minibar repuesto en la suite " + getNumero());
    }

    @Override
    public boolean tieneMinibar() {
        return true;
    }

    @Override
    public void limpiarJacuzzi() {
        jacuzziLimpio = true;
        System.out.println("Jacuzzi limpio en la suite " + getNumero());
    }

    @Override
    public boolean tieneJacuzzi() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " (Suite con minibar y jacuzzi)";
    }
}
