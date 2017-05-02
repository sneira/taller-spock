package trabajos

class Configuracion {

    String emailAdmin

    static constraints = {
        emailAdmin email: true
    }
}
