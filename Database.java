import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Clase que almacena los productos existentes en un ArrayList.
 */
public class Database {
    public static int anno;
    private List<Persona> personas;
    private List<Productor> productores;
    private List<ProductorFederado> productoresFederados;
    
    private Map<String, Double> productoDisponible;

    /**
     * Constructor de la Database.
     */
    public Database(int anno) {
        if(anno < 2020) {
            System.out.println("El año no puede ser inferior a 2020. Se establecerá el año en 2020.");
            this.anno = 2020;
        } else if(anno > 2100) {
            System.out.println("El año no puede ser superior a 2100. Se establecerá el año en 2020.");
            this.anno = 2020;
        } else {
            this.anno = anno;
        }
        this.personas = new ArrayList<>();
        this.productores = new ArrayList<>();
        this.productoresFederados = new ArrayList<>();
        
        this.productoDisponible = new HashMap<>();
    }
    
    /**
     * Imprimir en pantalla los productos disponibles almacenados en el HashMap.
     */
    public void imprimirProductosDisponibles() {
        System.out.println("PRODUCTOS DISPONIBLES");
        System.out.println("---------------------");
        System.out.printf("%-15s %10s\n", "PRODUCTO", "TONELADAS");
        System.out.println("---------------------");
        for(Map.Entry<String, Double> entry : productoDisponible.entrySet()) {
            System.out.printf("%-15s %,10.2f\n", entry.getKey(), entry.getValue());
        }
        System.out.println("---------------------");
    }
    
    /**
     * Actualiza las cantidades de producto disponibles, limpiando siempre al principio el
     * map y después iterando sobre todos los productores y productores federados para
     * añadir la cantidad disponible.
     */
    public void actualizarProductoDisponible() {
        initProductoDisponible();
        for(Productor productor : productores) {
            for(Producto producto : productor.getProductos()) {
                String nombreProducto = producto.getNombreProducto();
                double cantidadDisponible = producto.getCantidadDisponible();
                if(productoDisponible.containsKey(nombreProducto)) {
                    productoDisponible.put(nombreProducto, productoDisponible.get(nombreProducto) + cantidadDisponible);
                } else {
                    productoDisponible.put(nombreProducto, cantidadDisponible);
                }
            }
        }
        for(ProductorFederado productorFederado : productoresFederados) {
            for(Producto producto : productorFederado.getProductos()) {
                String nombreProducto = producto.getNombreProducto();
                double cantidadDisponible = producto.getCantidadDisponible();
                if(productoDisponible.containsKey(nombreProducto)) {
                    productoDisponible.put(nombreProducto, productoDisponible.get(nombreProducto) + cantidadDisponible);
                } else {
                    productoDisponible.put(nombreProducto, cantidadDisponible);
                }
            }
        }
    }
    
    /**
     * Hace una lista completa con los productos a 0 para usar en la función
     * actualizarProductoDisponible(); y por eso es private.
     */
    private void initProductoDisponible() {
        productoDisponible.clear();
        List<String> nombresProductos = Arrays.asList("Lechuga", "Tomate", "Aceituna", "Fresa",
                                        "Naranja", "Patata", "Pepino", "Aceite", "Trigo", "Maiz",
                                        "Girasol", "Avellana", "Garbanzo", "Avena");
        for(String nombre : nombresProductos) {
            productoDisponible.put(nombre, 0.0);
        }
    }
    
    /**
     * Añade la persona a la base de datos.
     */
    public void addPersona(Persona persona) {
        this.personas.add(persona);
    }
    
    /**
     * Elimina la persona de la base de datos.
     */
    public void removePersona(Persona persona) {
        personas.remove(persona);
    }
    
    /**
     * Añade el productor a la base de datos.
     */
    public void addProductor(Productor productor) {
        productores.add(productor);
    }
    
    /**
     * Elimina el productor de la base de datos.
     */
    public void removeProductor(Productor productor) {
        productores.remove(productor);
    }
    
    /**
     * Añade el productor federado a la base de datos.
     */
    public void addProductorFederado(ProductorFederado productorFederado) {
        productoresFederados.add(productorFederado);
    }
    
    /**
     * Elimina el productor federado de la base de datos.
     */
    public void removeProductorFederado(ProductorFederado productorFederado) {
        productoresFederados.remove(productorFederado);
    }
    
    /**
     * Devuelve el productor si existe en el ArrayList.
     */
    public Productor getProductor(Productor productor) {
        if(productores.contains(productor)) {
            return productor;
        }
        return null;
    }
    
    /**
     * Devuelve la persona a partir de su id si existe en el ArrayList.
     */
    public Persona getPersona(String id) {
        for(Persona persona : this.personas) {
            if(persona.getId().equals(id)) {
                return persona;
            }
        }
        return null;
    }
    
    /**
     * Devuelve el año.
     */
    public int getAnno() {
        return this.anno;
    }
}

