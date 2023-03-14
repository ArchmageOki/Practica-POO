import java.util.Map;

/**
 * Hace referencia a cada producto que se puede plantar.
 */
public abstract class Producto {
    private final String nombreProducto;
    private final Persona propietario;
    private final boolean perecedero;
    private final double extension;
    
    /**
     * Constructor.
     */
    public Producto(String nombreProducto, Persona persona, boolean perecedero, double extension) {
        this.nombreProducto = nombreProducto;       // Final
        this.propietario = persona;                 // Final
        this.perecedero = perecedero;               // Final
        this.extension = extension;                 // Final
    }

    /**
     * Devuelve el nombre.
     */
    public String getNombreProducto() {
        return this.nombreProducto;
    }
    
    /**
     * Devuelve el propietario (objeto).
     */
    public Persona getPropietario() {
        return this.propietario;
    }
    
    /**
     * Devuelve si es perecedero o no.
     */
    public boolean getPerecedero() {
        return this.perecedero;
    }
    
    /**
     * Devuelve la extensión del cultivo en ha.
     */
    public double getExtension() {
        return this.extension;
    }
    
    /**
     * Método base para obtener la cantidad disponible
     * de producto en cada subclase.
     */
    public abstract double getCantidadDisponible();
}
