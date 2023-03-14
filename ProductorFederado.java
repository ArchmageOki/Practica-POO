import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Hace referencia a cada una de las agrupaciones de personas que han
 * puesto su terreno en común para ser consideradas productores federados.
 * Solo puede haber un productor federado de cada tipo de producto y la
 * superficie total de éste no puede superar el límite marcado por la
 * cooperativa. Puede estar formado por cualquier número de personas
 * siempre que no se supere este límite.
 */
public final class ProductorFederado {
    private static Map<String, ProductorFederado> productores = new HashMap<>();
    private ArrayList<Persona> propietarios;
    private ArrayList<Producto> productos;
    private String plantacion;
    private double balance;
    private double extension;

    /**
     * Constructor de la clase ProductorFederado.
     */
    public ProductorFederado(Producto producto) {
        if(productores.containsKey(producto.getNombreProducto())) {
            System.out.println("Ya existe un productor federado con este tipo de cultivo.");
        } else {
            this.propietarios = new ArrayList<>(Arrays.asList(producto.getPropietario()));
            this.productos = new ArrayList<>(Arrays.asList(producto));
            this.plantacion = producto.getNombreProducto();
            this.balance = 0;
            this.extension = producto.getExtension();
            
            productores.put(this.plantacion, this);
        }
    }
    
    public void addCultivo(Producto producto) {
        if(producto.getNombreProducto() == plantacion && !productos.contains(producto) && this.extension + producto.getExtension() < Cooperativa.limiteExtension) {
            this.productos.add(producto);
            this.propietarios.add(producto.getPropietario());
            this.extension += producto.getExtension();
        } else {
            System.out.println("El cultivo introducido no es válido");
        }
    }
    
    public void removeCultivo(Producto producto) {
        if(this.productos.contains(producto)) {
            this.productos.remove(producto);
            this.extension -= producto.getExtension();
        } else {
            System.out.println("El cultivo introducido no es válido");
        }
    }
    
    /**
     * Devuelve el ArrayList de productos.
     */
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
}
