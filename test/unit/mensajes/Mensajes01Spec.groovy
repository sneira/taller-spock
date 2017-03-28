package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import spock.lang.Specification

/**
 * 1. Estructura de un test en Spock
 * Tipos de bloques:
 *  - setup/given
 *  - expect
 *  - when + then (se pueden repetir)
 */
class Mensajes01Spec extends Specification {

    // Bloque mínimo: expect
    def "Prioridad por defecto (forma 1)"() {
        expect:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Lo mismo, pero con un setup explícito
    def "Prioridad por defecto (forma 2)"() {
        setup:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        expect:
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Comprobar que given es equivalente a setup
    def "Prioridad por defecto (forma 3)"() {
        given:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        expect:
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Lo mismo, con when + then
    def "Prioridad por defecto (forma 4)"() {
        when:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        then:
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Repetir bloques when + then
    def "Los mensajes se ordenan a medida que se añaden"() {
        setup:
        ColaMensajes colaMensajes = new ColaMensajes()

        expect:
        colaMensajes.totalMensajes() == 0

        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "No hay prisa", Mensaje.PRIORIDAD_BAJA))

        then:
        colaMensajes.totalMensajes() == 1

        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "Mensaje", Mensaje.PRIORIDAD_NORMAL))

        then:
        colaMensajes.totalMensajes() == 2
        colaMensajes.getMensajeEnPosicion(0).prioridad == Mensaje.PRIORIDAD_NORMAL
        colaMensajes.getMensajeEnPosicion(1).prioridad == Mensaje.PRIORIDAD_BAJA

        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "Urgente!", Mensaje.PRIORIDAD_ALTA))

        then:
        colaMensajes.totalMensajes() == 3
        colaMensajes.getMensajeEnPosicion(0).prioridad == Mensaje.PRIORIDAD_ALTA
        colaMensajes.getMensajeEnPosicion(1).prioridad == Mensaje.PRIORIDAD_NORMAL
        colaMensajes.getMensajeEnPosicion(2).prioridad == Mensaje.PRIORIDAD_BAJA
    }

}
