package trabajos

class Trabajo {

    String nombre
    String tipo
    Boolean procesado = false
    Boolean error = false
    Integer operando1
    Integer operando2
    Integer resultado
    Usuario usuario

    static constraints = {
        operando2 nullable: true
        resultado nullable: true // El resto de propiedades son obligatorias
    }
}
