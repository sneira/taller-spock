package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import spock.lang.Specification

class Mensajes01Spec extends Specification {

    def "Puedo añadir mensajes"() {
        setup:
        ColaMensajes colaMensajes = new ColaMensajes()
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        expect:
        colaMensajes.totalMensajes() == 0

        when:
        colaMensajes.addMensaje(mensaje)

        then:
        colaMensajes.totalMensajes() == 1
    }

    def "Orden correcto"() {
        setup:
        ColaMensajes colaMensajes = new ColaMensajes()

        expect:
        colaMensajes.totalMensajes() == 0

        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "No hay prisa", Mensaje.PRIORIDAD_BAJA))
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "Mensaje", Mensaje.PRIORIDAD_NORMAL))
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "Urgente!", Mensaje.PRIORIDAD_ALTA))

        then:
        colaMensajes.totalMensajes() == 3
        colaMensajes.getMensajeEnPosicion(0).prioridad == Mensaje.PRIORIDAD_ALTA
        colaMensajes.getMensajeEnPosicion(1).prioridad == Mensaje.PRIORIDAD_NORMAL
        colaMensajes.getMensajeEnPosicion(2).prioridad == Mensaje.PRIORIDAD_BAJA
    }
}
