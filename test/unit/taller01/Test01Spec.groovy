package taller01

import spock.lang.Specification

/**
 * 1. Estructura de un test en Spock
 */
class Test01Spec extends Specification {

    def "Test mínimo: bloque expect"() {
        // Un bloque expect sólo admite condiciones y definiciones de variables. Es a la vez estímulo y respuesta.
        expect:
        def a = 2
        def b = 3
        def c = a + b
        c == 5
    }

    def "Setup explícito (también vale given)"() {
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

        then: // Respuesta
        c == 12
    }

    def "Bloque when/then con setup explícito"() {
        setup:
        def a = 10
        def b = 2
        def c

        when:
        c = a - b

        then:
        c == 8
    }

    def "Varios when/then"() {
        setup:
        def a = 2

        when:
        a *= 2

        then:
        a == 4

        when:
        a *= 2

        then:
        a == 8

        when:
        a *= 2

        then:
        a == 16
    }
}
