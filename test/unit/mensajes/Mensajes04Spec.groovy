package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import org.apache.commons.lang.RandomStringUtils
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

/**
 * 4. Bloques setup, cleanup, setupSpec, cleanupSpec; variables compartidas
 */

@Stepwise // Esta anotación hace que el test se ejecute en el orden en el que está.
class Mensajes04Spec extends Specification {

    @Shared ColaMensajes colaMensajes = new ColaMensajes()
    // La anotación @Shared hace que la variable sea compartida. Es decir, mantendrá su estado entre métodos e iteraciones.
    // También se puede usar static, aunque no se recomienda para valores que no sean constantes.

    // Se ejecuta al principio del test.
    def setupSpec() {
        println "Inicializando test..."
    }

    // Se ejecuta al final del test.
    def cleanupSpec() {
        println "Finalizando test..."
    }

    // Se ejecuta antes de cada método o iteración.
    def setup() {
        colaMensajes.addMensaje(new Mensaje("setup", "setup", "Mensaje creado en el setup"))
    }

    // Se ejecuta después de cada método o iteración.
    def cleanup() {
        println "Fin de método/iteración. Cola: ${colaMensajes}"
    }

    def "Añadir mensajes a una cola"() {
        when:
        colaMensajes.addMensaje(new Mensaje(remitente, destinatario, texto))

        then:
        colaMensajes.totalMensajes() == totalMensajes

        where:
        remitente | destinatario | texto                       | totalMensajes
        "usu1"    | "usu2"       | "Prueba"                    | 2 // 1 del setup de la clase + 1 del método.
        "admin"   | "rrhh"       | "Alta de usuario"           | 4 // Los 2 anteriores, 1 del setup de la clase + 1 del método.
        "admin"   | "empresa"    | "Incidencia en el servicio" | 6 // Los 4 anteriores, 1 del setup de la clase + 1 del método.
    }

    def "Añadir un mensaje más"() {
        expect:
        colaMensajes.totalMensajes() == 7 // Los 6 anteriores + 1 del setup de la clase.

        when:
        colaMensajes.vaciar()

        then:
        colaMensajes.totalMensajes() == 0
    }

}
