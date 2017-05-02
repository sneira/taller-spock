package trabajos

class Usuario {

    String nombre

    static constraints = {
        nombre unique: true
    }

}
