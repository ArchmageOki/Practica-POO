
/**
 * Clase que sirve de base para la logística.
 */
public class Logistica {
    final int tramo;
    final float precioPorKm;
    
    /**
     * Constructor.
     */
    public Logistica(int tramo, float precioPorKm)
    {
        this.tramo = tramo;
        this.precioPorKm = precioPorKm;
    }
}