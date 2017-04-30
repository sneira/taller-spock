package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import spock.lang.Specification

/**
 * 1. Estructura de un test en Spock
 * Tipos de bloques:
 *  - setup/given:
 *      - No puede estar precedido por otros bloques.
 *      - No se puede repetir.
 *  - expect:
 *      - Sólo puede contener condiciones y definiciones de variables.
 *      - Útil cuando es más natural describir el estímulo y la respuesta en una sola expresión: Math.max(1, 2) == 2
 *  - when + then:
 *      - Siempre van juntos (estímulo -> respuesta)
 *      - Un método puede contener varias parejas de when + then.
 *      - Los bloques when pueden contener cualquier tipo de código.
 *      - Los bloques then sólo pueden contener condiciones, condiciones de excepción, interacciones y definiciones de variables.
 */
class Mensajes01Spec extends Specification {

    // Bloque mínimo: expect
    def "1. Prioridad por defecto (forma 1)"() {
        expect:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Lo mismo, pero con un setup explícito
    def "2. Prioridad por defecto (forma 2)"() {
        setup:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        expect:
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Comprobar que given es equivalente a setup
    def "3. Prioridad por defecto (forma 3)"() {
        given:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        expect:
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Lo mismo, con when + then
    def "4. Prioridad por defecto (forma 4)"() {
        when:
        Mensaje mensaje = new Mensaje("remitente", "destinatario", "texto")

        then:
        mensaje.prioridad == Mensaje.PRIORIDAD_NORMAL
    }

    // Repetir bloques when + then
    def "5. Los mensajes se ordenan a medida que se añaden"() {
        setup:
        ColaMensajes colaMensajes = new ColaMensajes()

        expect:
        colaMensajes.totalMensajes() == 0

        // Añado un mensaje de prioridad baja.
        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "No hay prisa", Mensaje.PRIORIDAD_BAJA))

        // La cola tiene un mensaje.
        then:
        colaMensajes.totalMensajes() == 1

        // Añado un mensaje de prioridad normal.
        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "Mensaje", Mensaje.PRIORIDAD_NORMAL))

        // La cola tiene dos mensajes. El primero tiene prioridad normal, y el segundo, prioridad baja.
        then:
        colaMensajes.totalMensajes() == 2
        colaMensajes.getMensajeEnPosicion(0).prioridad == Mensaje.PRIORIDAD_NORMAL
        colaMensajes.getMensajeEnPosicion(1).prioridad == Mensaje.PRIORIDAD_BAJA

        // Añado un mensaje de prioridad alta.
        when:
        colaMensajes.addMensaje(new Mensaje("rem", "dest", "Urgente!", Mensaje.PRIORIDAD_ALTA))

        // La cola tiene tres mensajes: el primero con prioridad alta, el segundo con prioridad normal y el tercero con prioridad baja.
        then:
        colaMensajes.totalMensajes() == 3
        colaMensajes.getMensajeEnPosicion(0).prioridad == Mensaje.PRIORIDAD_ALTA
        colaMensajes.getMensajeEnPosicion(1).prioridad == Mensaje.PRIORIDAD_NORMAL
        colaMensajes.getMensajeEnPosicion(2).prioridad == Mensaje.PRIORIDAD_BAJA
    }

}
