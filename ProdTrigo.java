import java.util.HashMap;
import java.util.Map;

/**
 * Hace referencia a cada uno de los cultivos.
 */
public class ProdTrigo extends Producto {
    private static Map<Integer, Double> valorPorKgHistorico = new HashMap<>();
    private static double rendimiento;
    private static double valorPorKg;
    
    /**
     * Constructor de la clase ProdTrigo.
     */
    public ProdTrigo(Persona persona, double extension, Database database) {
        super("Trigo", persona, false, extension);
        ProdTrigo.rendimiento = 5;
        ProdTrigo.valorPorKg = 0.50;
        valorPorKgHistorico = new HashMap<>();
    }
    
    /**
     * Actualiza el valor por kg del producto.
     */
    public static void actualizarValores(double nuevoValorPorKg, Database database) {           // Habrá que meterlo en una funcion de database!!!!!
        valorPorKgHistorico.put(database.getAnno(), ProdTrigo.getValorPorKg());                  // Ojo al getAnno, tiene que ser el año correcto!!!!!
        ProdTrigo.setValorPorKg(nuevoValorPorKg);
    }
    
    /**
     * Devuelve el rendimiento en toneladas por hectárea.
     */
    public static double getRendimiento() {
        return ProdTrigo.rendimiento;
    }
    
    /**
     * Devuelve el valor por kg de producto.
     */
    public static double getValorPorKg() {
        return ProdTrigo.valorPorKg;
    }
    
    /**
     * Modifica el rendimiento del producto. Si el valor introducido
     * es menor o igual a 0, su rendimiento se establece en 0.
     */
    public static void setRendimiento(double rendimiento) {
        if(rendimiento <= 0) {
            ProdTrigo.rendimiento = 0;
        } else {
            ProdTrigo.rendimiento = rendimiento;
        }
    }
    
    /**
     * Modifica el valor por kg del producto. Si el valor introducido
     * es menor o igual a 0, se establece en 0.
     */
    public static void setValorPorKg(double valorPorKg) {
        if(valorPorKg <= 0) {
            ProdTrigo.valorPorKg = 0;
        } else {
            ProdTrigo.valorPorKg = valorPorKg;
        }
    }
    
    /**
     * Devuelve las toneladas disponibles.
     */
    @Override
    public double getCantidadDisponible() {
        return this.rendimiento * getExtension();
    }
}
