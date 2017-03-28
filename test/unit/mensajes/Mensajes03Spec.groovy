package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import spock.lang.Ignore
import spock.lang.Specification

/**
 * 3. Funcionamiento del where
 */
class Mensajes03Spec extends Specification {

    def "Añadir mensajes a una cola"() {
        /*setup:
        ColaMensajes cola = new ColaMensajes()

        when:
        cola.addMensaje(new Mensaje(remitente, destinatario, texto))

        then:
        cola.totalMensajes() == totalMensajes

        where:
        remitente | destinatario | texto                       | totalMensajes
        "usu1"    | "usu2"       | "Prueba"                    | ...
        "admin"   | "rrhh"       | "Alta de usuario"           | ...
        "admin"   | "empresa"    | "Incidencia en el servicio" | ...
        */
    }

    def "Los mensajes nulos no se añaden"() {
        /*setup:
        ColaMensajes cola = new ColaMensajes()
        Mensaje mens = new Mensaje("remitente", "destinatario", "texto")

        when:
        cola.addMensaje(mensaje)

        then:
        cola.totalMensajes() == total

        where:
        mensaje | total
        null    | 0
        mens    | 1*/
    }

}
