package mensajes

import mensajeria.DatosIncompletosException
import mensajeria.Mensaje
import spock.lang.Specification

/**
 * 5. Excepciones con thrown y notThrown
 */
class Mensajes05Spec extends Specification {

    def "No se puede crear un mensaje sin remitente, destinatario o texto"() {
        when:
        new Mensaje(remitente, destinatario, texto)

        then:
        thrown(DatosIncompletosException) // Comprobamos que ha saltado una excepción del tipo indicado.

        where:
        remitente   | destinatario   | texto
        null        | null           | null
        null        | null           | "texto"
        "remitente" | null           | "texto"
        "remitente" | "destinatario" | null
    }

    def "Si hay al menos remitente, destinatario y texto, el mensaje se crea correctamente"() {
        when:
        new Mensaje("remitente", "destinatario", "texto")

        then:
        notThrown(DatosIncompletosException) // Comprobamos que no ha saltado una excepción del tipo indicado.
    }
}
