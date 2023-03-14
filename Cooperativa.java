import java.util.Scanner;

/**
 * Se refiere a la cooperativa. Es la clase principal.
 */
public final class Cooperativa
{
    public static float limiteExtension = 5.0f;

    /**
     * Constructor for objects of class Cooperativa
     */
    public Cooperativa()
    {
        
    }
    
    public static void main(String[] args) {
        Database database = new Database(2020);
        Persona juanma = new Persona("Juanma", "Garrido", "Aguilera", "73433769J", 27, "Hombre", database);
        Persona lidia = new Persona("Lidia", "Pedrosa", "Fernandez", "73138004M", 28, "Mujer", database);
    }
}
