
/**
 * Hace referencia a cada una de las personas físicas que están dadas de alta
 * en la base de datos.
 * 
 * @author Juan Manuel Garrido
 */
public class Persona {
    private final String id;
    private static int count = 0;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private int edad;
    private String sexo;
    private boolean activo;

    /**
     * Constructor de la clase
     */
    public Persona(String nombre, String apellido1, String apellido2, String dni, int edad, String sexo, Database database) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        setDNI(dni);
        setEdad(edad);
        setSexo(sexo);
        this.id = String.format("%05d", count++);
        this.activo = true;
        database.addPersona(this);
    }
    
    /**
     * Reemplaza el nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Reemplaza el primer apellido de la persona.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    /**
     * Reemplaza el segundo apellido de la persona.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    /**
     * Reemplaza la edad de la persona. Si la edad introducida es menor que 18,
     * la edad de la persona será 0. Lo mismo sucede si la edad introducida es
     * mayor que 99.
     */
    public void setEdad(int edad) {
        if(edad < 18 || edad > 99) {
            this.edad = 0;
        } else {
            this.edad = edad;
        }
    }
    
    /**
     * Cambia el DNI por el argumento que se pasa. Si no es correcto, el DNI
     * pasa a ser "DNI INCORRECTO"
     */
    public void setDNI(String dni) {
        if (esDNICorrecto(dni)) {
            this.dni = dni;
        } else {
            this.dni = "DNI INCORRECTO";
        }
    }
    
    /**
     * Hace que el sexo sea "Mujer" si se pasa como parámetro. Sino el sexo
     * es "Hombre" por defecto.
     */
    public void setSexo(String sexo)
    {
        if ("Mujer".equals(sexo)) {
            this.sexo = "Mujer";
        } else {
            this.sexo = "Hombre";
        }
    }
    
    /**
     * Devuelve el id.
     */
    public String getId() {
        return this.id;
    }
    
    /**
     * Devuelve el nombre
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Devuelve el primer apellido
     */
    public String getApellido1() {
        return this.apellido1;
    }

    /**
     * Devuelve el segundo apellido
     */
    public String getApellido2() {
        return this.apellido2;
    }
    
    /**
     * Devuelve el DNI
     */
    public String getDNI() {
        return this.dni;
    }
    
    /**
     * Devuelve la edad
     */
    public int getEdad() {
        return this.edad;
    }
    
    /**
     * Devuelve el sexo
     */
    public String getSexo() {
        return this.sexo;
    }
    
    /**
     * Comprueba con un boolean que el formato introducido
     * en la String DNI es válido. Considera válido el DNI si tiene 8 dígitos
     * y una letra final, sea mayúscula o minúscula.
     */
    public static boolean esFormatoValido(String dni) {
        return dni.matches("\\d{8}[a-zA-Z]");
    }
    
    /**
     * Calcula la letra del DNI, creando un int con los 8
     * primeros dígitos de la String del DNI y obteniendo su módulo 23. El
     * resultado de esta operación va a ser igual a la letra del DNI. La letra
     * del DNI se corresponde con la posición en la String letras.
     */
    public static char calcularLetraDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";              // Es el orden de las letras del DNI, desde el 0 hasta el 23.
        
        int numero = Integer.parseInt(dni.substring(0,8));      // Se declara una variable "int numero". De la String dni se
                                                                // hace una substring que incluye los 8 primeros caracteres
                                                                // del dni y mediante el parseInt se transforman en un int.
        
        int indice = numero % 23;                               // Se calcula el módulo 23 de los dígitos del dni para saber
                                                                // qué letra corresponde a ese dni.
        
        return letras.charAt(indice);                           // Se devuelve la letra correspondiente mediante el charAt.
    }
    
    /**
     * Comprueba en primer lugar que el formato del DNI dado
     * es válido. Después calcula la letra que le corresponde a ese DNI y la
     * compara con la letra que se ha pasado como argumento.
     */
    public static boolean esDNICorrecto(String dni) {
        if (!esFormatoValido(dni)) {                            // Si el formato introducido no es correcto, directamente
            return false;                                       // devuelve un false.
        }
        
        char letraCalculada = calcularLetraDNI(dni);            // Calcula la letra del DNI que le corresponde al argumento.
        
        char letraDNI = dni.charAt(8);                          // Extrae la letra del DNI del argumento.
        
        return letraCalculada == letraDNI;                      // Compara la letra calculada y la que le corresponde al DNI.
    }
    
    /**
     * Da de baja a una persona. En otras palabras: lo borra de la base de datos.
     */
    public void darDeBaja(Database database) {
        this.activo = false;
        database.removePersona(this);
    }
    
    /**
     * Sustituye el toString por algo más legible
     */
    @Override
    public String toString() {
    return "Nombre: " + nombre + "\n" +
           "Apellido 1: " + apellido1 + "\n" +
           "Apellido 2: " + apellido2 + "\n" +
           "DNI: " + dni + "\n" +
           "Edad: " + edad + "\n" +
           "Sexo: " + sexo;
    }
}
