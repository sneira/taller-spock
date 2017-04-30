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
        /*setup:
        ...

        expect:
        ...
        */
    }

    // Comprobar que given es equivalente a setup
    def "3. Prioridad por defecto (forma 3)"() {
        /*
        ...
         */
    }

    // Lo mismo, con when + then
    def "4. Prioridad por defecto (forma 4)"() {
        /*
        ...
         */
    }

    // Repetir bloques when + then
    def "5. Los mensajes se ordenan a medida que se añaden"() {
        setup:
        ColaMensajes colaMensajes = new ColaMensajes()

        expect:
        colaMensajes.totalMensajes() == 0

        // Añado un mensaje de prioridad baja.
        // La cola tiene un mensaje.
        // Añado un mensaje de prioridad normal.
        // La cola tiene dos mensajes. El primero tiene prioridad normal, y el segundo, prioridad baja.
        // Añado un mensaje de prioridad alta.
        // La cola tiene tres mensajes: el primero con prioridad alta, el segundo con prioridad normal y el tercero con prioridad baja.
    }

}
