package taller01

import spock.lang.Specification
import spock.lang.Unroll

/**
 * 4. Bloques setup, cleanup, setupSpec, cleanupSpec
 */

@Unroll
class Test04Spec extends Specification {

    def setupSpec() {
        println "*** Iniciando test..."
    }

    def cleanupSpec() {
        println "*** Finalizando test..."
    }

    def setup() {
        println "****** Iniciando método..."
    }

    def cleanup() {
        println "****** Terminando método..."
    }

    def "Test sencillo"() {
        expect:
        Math.max(1, 2) == 2
    }

    def "Test con where: el mínimo de #op1 y #op2 es #resultado"() {
        expect:
        Math.min(op1, op2) == resultado

        where:
        op1 | op2 | resultado
        1   | 2   | 1
        3   | 4   | 3
        8   | 2   | 2
        9   | 0   | 0
    }
}
