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
        /*when:
        colaMensajes.addMensaje(new Mensaje(remitente, destinatario, texto))

        then:
        colaMensajes.totalMensajes() == totalMensajes

        where:
        remitente | destinatario | texto                       | totalMensajes
        "usu1"    | "usu2"       | "Prueba"                    | ...
        "admin"   | "rrhh"       | "Alta de usuario"           | ...
        "admin"   | "empresa"    | "Incidencia en el servicio" | ...
        */
    }

    def "Añadir un mensaje más"() {
        /*expect:
        colaMensajes.totalMensajes() == ...

        when:
        colaMensajes.vaciar()

        then:
        colaMensajes.totalMensajes() == ...
        */
    }

}
