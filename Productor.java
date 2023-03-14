import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hace referencia a cada una de las personas. Éstas pueden poseer hasta 5 productos diferentes
 * y no pueden superar en extensión al limite anual marcado para ser consideradas pequeños
 * productores. Si superan estas cantidades, pasarán a ser consideradas grandes productores.
 */
public class Productor {
    private Persona propietario;
    private ArrayList<Producto> productos;
    private double balance;
    private double extension;
    private boolean esGranProductor;

    /**
     * Constructor de la clase Productor
     */
    public Productor(Producto producto, Database database) {
        this.propietario = producto.getPropietario();
        this.balance = 0;
        productos = new ArrayList<>();
        productos.add(producto);
        this.extension = producto.getExtension();
        setTipoProductor();
        database.addProductor(this);
        database.actualizarProductoDisponible();
    }

    /**
     * Añade un producto y suma su extensión con el valor anterior. Después
     * comprueba si ha cambiado el tipo de productor.
     */
    public void addCultivo(Producto producto, Database database) {
        if(this.propietario == producto.getPropietario()) {
            if(!productos.contains(producto)) {
                productos.add(producto);
                setExtension(getExtension() + producto.getExtension());
                setTipoProductor();
                database.actualizarProductoDisponible();
            } else {
                System.out.println("El cultivo introducido ya está en la lista de cultivos.");
            }
        } else {
            System.out.println("El cultivo pertenece a otra persona.");
        }
    }
    
    /**
     * Devuelve la extension.
     */
    public double getExtension() {
        return this.extension;
    }
    
    /**
     * Establece la extension
     */
    private void setExtension(double extension) {
        this.extension = extension;
    }
    
    /**
     * Devuelve el ArrayList de productos.
     */
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
    
    /**
     * Elimina un producto y resta su extensión a la total. Después comprueba
     * si ha cambiado el tipo de productor. Si el producto introducido no está
     * dentro de la lista, se imprime un mensaje de error.
     */
    public void removeCultivo(Producto producto, Database database) {
        if (this.productos.contains(producto)) {
            this.productos.remove(producto);
            this.extension -= producto.getExtension();
            setTipoProductor();
            database.actualizarProductoDisponible();
        } else {
            System.out.println("El cultivo introducido no es válido.");
        }
    }
    
    /**
     * Determina si el productor es pequeño o es un gran
     * productor. Es private porque se le llama desde otras
     * funciones únicamente.
     */
    private void setTipoProductor () {
        if (this.extension >= Cooperativa.limiteExtension || this.productos.size() >= 6) {
            this.esGranProductor = true;
        } else {
            this.esGranProductor = false;
        }
    }
}
