package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import org.apache.commons.lang.RandomStringUtils
import spock.lang.Shared
import spock.lang.Specification

/**
 * 4. Bloques setup, cleanup, setupSpec, cleanupSpec; variables compartidas
 */
class Mensajes04Spec extends Specification {

    @Shared ColaMensajes colaMensajes
    // @Shared String cuerpoMensaje
    static String cuerpoMensaje

    def setupSpec() {
        println "Inicializando cola de mensajes..."
        colaMensajes = new ColaMensajes()
        assert colaMensajes.totalMensajes() == 0
    }

    def cleanupSpec() {
        println "Borrando cola ${colaMensajes}"
        assert colaMensajes.totalMensajes() > 0
        colaMensajes.vaciar()
        assert colaMensajes.totalMensajes() == 0
    }

    def setup() {
        cuerpoMensaje = RandomStringUtils.randomAscii(10)
    }

    def cleanup() {
    }

    def "Añadir mensajes a una cola"() {
        when:
        colaMensajes.addMensaje(new Mensaje(remitente, destinatario, cuerpoMensaje))

        then:
        colaMensajes.totalMensajes() == numeroMensajes

        where:
        remitente | destinatario | numeroMensajes
        "usu1"    | "usu2"       | 1
        "admin"   | "rrhh"       | 2
        "admin"   | "empresa"    | 3
    }

}
