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
        setup:
        ColaMensajes cola = new ColaMensajes()

        when:
        cola.addMensaje(new Mensaje(remitente, destinatario, texto, prioridad))

        then:
        cola.totalMensajes() == 1

        where:
        remitente | destinatario | texto                       | prioridad
        "usu1"    | "usu2"       | "Prueba"                    | Mensaje.PRIORIDAD_NORMAL
        "admin"   | "rrhh"       | "Alta de usuario"           | Mensaje.PRIORIDAD_BAJA
        "admin"   | "empresa"    | "Incidencia en el servicio" | Mensaje.PRIORIDAD_ALTA
    }

    @Ignore
    def "Los mensajes nulos no se añaden"() {
        setup:
        ColaMensajes cola = new ColaMensajes()
        Mensaje mens = new Mensaje("remitente", "destinatario", "texto")

        when:
        cola.addMensaje(mensaje)

        then:
        cola.totalMensajes() == total

        where:
        mensaje | total
        null    | 0
        mens    | 1
    }

}
