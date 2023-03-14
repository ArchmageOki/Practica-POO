import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hace referencia a cada una de las personas. Éstas pueden poseer hasta 5 productos diferentes
 * y no pueden superar en extensión al limite anual marcado para ser consideradas pequeños
 * productores. Si superan estas cantidades, pasarán a ser consideradas grandes productores.
 */
public class Productor {
    private Persona propietario;  // No se debe modificar nunca una vez que se crea el objeto.
    private ArrayList<Producto> productos;
    private double balance;
    private double extension;
    private boolean esGranProductor;

    /**
     * Constructor de la clase Productor.
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
     * Constructor v2, aquí se crea un cultivo nuevo para añadir al Productor.
     */
    public Productor(String nombreProducto, Persona propietario, double extension, Database database) {
        if(!Database.nombresProductos.contains(nombreProducto)) {
            System.out.println("El producto no existe");
        } else {
            this.propietario = propietario;
            this.balance = 0;
            productos = new ArrayList<>();
            switch(nombreProducto) {
                case "Lechuga":
                    productos.add(new ProdLechuga(propietario, extension, database));
                    break;
                case "Tomate":
                    productos.add(new ProdTomate(propietario, extension, database));
                    break;
                case "Aceituna":
                    productos.add(new ProdAceituna(propietario, extension, database));
                    break;
                case "Fresa":
                    productos.add(new ProdFresa(propietario, extension, database));
                    break;
                case "Naranja":
                    productos.add(new ProdNaranja(propietario, extension, database));
                    break;
                case "Patata":
                    productos.add(new ProdPatata(propietario, extension, database));
                    break;
                case "Pepino":
                    productos.add(new ProdPepino(propietario, extension, database));
                    break;
                case "Aceite":
                    productos.add(new ProdAceite(propietario, extension, database));
                    break;
                case "Trigo":
                    productos.add(new ProdTrigo(propietario, extension, database));
                    break;
                case "Maiz":
                    productos.add(new ProdMaiz(propietario, extension, database));
                    break;
                case "Girasol":
                    productos.add(new ProdGirasol(propietario, extension, database));
                    break;
                case "Avellana":
                    productos.add(new ProdAvellana(propietario, extension, database));
                    break;
                case "Garbanzo":
                    productos.add(new ProdGarbanzo(propietario, extension, database));
                    break;
                case "Avena":
                    productos.add(new ProdAvena(propietario, extension, database));
                    break;
                default:
                    System.out.println("El producto no existe");
            }
            this.extension = extension;
            setTipoProductor();
            database.addProductor(this);
            database.actualizarProductoDisponible();  
        }
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
