import java.util.HashMap;
import java.util.Map;

/**
 * Hace referencia a cada uno de los cultivos.
 */
public class ProdAvena extends Producto {
    private static Map<Integer, Double> valorPorKgHistorico = new HashMap<>();
    private static double rendimiento;
    private static double valorPorKg;
    
    /**
     * Constructor de la clase ProdAvena.
     */
    public ProdAvena(Persona persona, double extension, Database database) {
        super("Avena", persona, false, extension);
        ProdAvena.rendimiento = 3.6;
        ProdAvena.valorPorKg = 0.16;
        valorPorKgHistorico = new HashMap<>();
    }
    
    /**
     * Actualiza el valor por kg del producto.
     */
    public static void actualizarValores(double nuevoValorPorKg, Database database) {           // Habrá que meterlo en una funcion de database!!!!!
        valorPorKgHistorico.put(database.getAnno(), ProdAvena.getValorPorKg());                  // Ojo al getAnno, tiene que ser el año correcto!!!!!
        ProdAvena.setValorPorKg(nuevoValorPorKg);
    }
    
    /**
     * Devuelve el rendimiento en toneladas por hectárea.
     */
    public static double getRendimiento() {
        return ProdAvena.rendimiento;
    }
    
    /**
     * Devuelve el valor por kg de producto.
     */
    public static double getValorPorKg() {
        return ProdAvena.valorPorKg;
    }
    
    /**
     * Modifica el rendimiento del producto. Si el valor introducido
     * es menor o igual a 0, su rendimiento se establece en 0.
     */
    public static void setRendimiento(double rendimiento) {
        if(rendimiento <= 0) {
            ProdAvena.rendimiento = 0;
        } else {
            ProdAvena.rendimiento = rendimiento;
        }
    }
    
    /**
     * Modifica el valor por kg del producto. Si el valor introducido
     * es menor o igual a 0, se establece en 0.
     */
    public static void setValorPorKg(double valorPorKg) {
        if(valorPorKg <= 0) {
            ProdAvena.valorPorKg = 0;
        } else {
            ProdAvena.valorPorKg = valorPorKg;
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
