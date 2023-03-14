import java.util.Map;
import java.util.HashMap;

/**
 * Hace referencia a cada uno de los cultivos.
 */
public class ProdTomate extends Producto {
    private static Map<Integer, Double> valorPorKgHistorico = new HashMap<>();
    private static double rendimiento;
    private static double valorPorKg;
    
    /**
     * Constructor de la clase ProdTomate.
     */
    public ProdTomate(Persona persona, double extension, Database database) {
        super("Tomate", persona, true, extension);
        ProdTomate.rendimiento = 80;
        ProdTomate.valorPorKg = 0.33;
        valorPorKgHistorico = new HashMap<>();
    }
    
    /**
     * Actualiza el valor por kg del producto.
     */
    public static void actualizarValores(double nuevoValorPorKg, Database database) {           // Habrá que meterlo en una funcion de database!!!!!
        valorPorKgHistorico.put(database.getAnno(), ProdTomate.getValorPorKg());                  // Ojo al getAnno, tiene que ser el año correcto!!!!!
        ProdTomate.setValorPorKg(nuevoValorPorKg);
    }
    
    /**
     * Devuelve el rendimiento en toneladas por hectárea.
     */
    public static double getRendimiento() {
        return ProdTomate.rendimiento;
    }
    
    /**
     * Devuelve el valor por kg de producto.
     */
    public static double getValorPorKg() {
        return ProdTomate.valorPorKg;
    }
    
    /**
     * Modifica el rendimiento del producto. Si el valor introducido
     * es menor o igual a 0, su rendimiento se establece en 0.
     */
    public static void setRendimiento(double rendimiento) {
        if(rendimiento <= 0) {
            ProdTomate.rendimiento = 0;
        } else {
            ProdTomate.rendimiento = rendimiento;
        }
    }
    
    /**
     * Modifica el valor por kg del producto. Si el valor introducido
     * es menor o igual a 0, se establece en 0.
     */
    public static void setValorPorKg(double valorPorKg) {
        if(valorPorKg <= 0) {
            ProdTomate.valorPorKg = 0;
        } else {
            ProdTomate.valorPorKg = valorPorKg;
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