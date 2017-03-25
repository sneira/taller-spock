package taller01

import spock.lang.Specification

/**
 * 5. Excepciones
 */
class Test05Spec extends Specification {

    def "Comprobar que se lanza una excepción"() {
        when:
        def cadena
        cadena.length() > 0

        then:
        thrown(NullPointerException)
    }

    def "Comprobar que no se lanza una excepción"() {
        when:
        def cadena = "hola"
        cadena.length() > 0

        then:
        notThrown(NullPointerException)
    }
}
