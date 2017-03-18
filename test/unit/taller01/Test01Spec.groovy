package taller01

import spock.lang.Specification

/**
 * Created by sofia on 11/03/17
 */
class Test01Spec extends Specification { // todo: numerar tests

    def "Test mínimo: bloque expect"() {
        // Un bloque expect sólo admite condiciones y definiciones de variables. Es a la vez estímulo y respuesta.
        expect:
        def a = 2
        def b = 3
        def c = a + b
        c == 5
    }

    def "Setup explícito (también vale given)"() { // todo: Ventajas y desventajas de separar el setup
        setup:
        def a = 2
        def b = 3
        def c = b - a

        expect:
        c == 1
    }

    def "Bloque when/then"() {
        // As a guideline, use when-then to describe methods with side effects, and expect to describe purely functional methods.
        // Ejemplo de la documentación: Math.max(a, b). Es más natural hacerlo del tirón que asignar su valor a una variable.
        when: // Estímulo
        def a = 4
        def b = 3
        def c = a * b

        then:
        c == 12
    }

    def "Bloque when/then con setup explícito"() {
        setup: // Respuesta
        def a = 10
        def b = 2
        def c

        when:
        c = a - b

        then:
        c == 8
    }
}
