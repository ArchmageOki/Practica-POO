import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa cada uno de los transportistas que ofrecen servicios
 * de transporte de los productos.
 */
public class Transportista
{
    private String nombre;
    private List<Logistica> tramos;

    /**
     * Constructor de Transportista.
     */
    public Transportista(String nombre)
    {
        this.nombre = nombre;
        this.tramos = new ArrayList<>();
    }
    
    //public void calcularPrecioTransporte();
}
