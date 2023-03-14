import java.util.HashMap;
import java.util.Map;

/**
 * Hace referencia a cada uno de los cultivos.
 */
public class ProdFresa extends Producto {
    private static Map<Integer, Double> valorPorKgHistorico = new HashMap<>();
    private static double rendimiento;
    private static double valorPorKg;
    
    /**
     * Constructor de la clase ProdFresa.
     */
    public ProdFresa(Persona persona, double extension, Database database) {
        super("Fresa", persona, true, extension);
        ProdFresa.rendimiento = 54;
        ProdFresa.valorPorKg = 2.45;
        valorPorKgHistorico = new HashMap<>();
    }
    
    /**
     * Actualiza el valor por kg del producto.
     */
    public static void actualizarValores(double nuevoValorPorKg, Database database) {           // Habrá que meterlo en una funcion de database!!!!!
        valorPorKgHistorico.put(database.getAnno(), ProdFresa.getValorPorKg());                  // Ojo al getAnno, tiene que ser el año correcto!!!!!
        ProdFresa.setValorPorKg(nuevoValorPorKg);
    }
    
    /**
     * Devuelve el rendimiento en toneladas por hectárea.
     */
    public static double getRendimiento() {
        return ProdFresa.rendimiento;
    }
    
    /**
     * Devuelve el valor por kg de producto.
     */
    public static double getValorPorKg() {
        return ProdFresa.valorPorKg;
    }
    
    /**
     * Modifica el rendimiento del producto. Si el valor introducido
     * es menor o igual a 0, su rendimiento se establece en 0.
     */
    public static void setRendimiento(double rendimiento) {
        if(rendimiento <= 0) {
            ProdFresa.rendimiento = 0;
        } else {
            ProdFresa.rendimiento = rendimiento;
        }
    }
    
    /**
     * Modifica el valor por kg del producto. Si el valor introducido
     * es menor o igual a 0, se establece en 0.
     */
    public static void setValorPorKg(double valorPorKg) {
        if(valorPorKg <= 0) {
            ProdFresa.valorPorKg = 0;
        } else {
            ProdFresa.valorPorKg = valorPorKg;
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
