package trabajos

import grails.test.spock.IntegrationSpec

/**
 * 2. Prueba del ExecutorService
 */
class Trabajos02IntegrationSpec extends IntegrationSpec {

    def executorService

    def "1. Los trabajos correctamente configurados se marcan como procesados sin errores"() {
        setup:
        Trabajo trabajo = Trabajo.build(tipo: tipo, operando1: operando1, operando2: operando2)

        when:
        executorService.procesarTrabajo(trabajo)

        then:
        trabajo.procesado
        !trabajo.error

        where:
        tipo       | operando1 | operando2
        "suma"     | 1         | 1
        "cuadrado" | 2         | null
    }

    def "2. Los trabajos incorrectamente configurados se marcan como procesados con errores"() {
        setup:
        Trabajo trabajo = Trabajo.build(tipo: tipo, operando1: operando1, operando2: operando2)

        when:
        executorService.procesarTrabajo(trabajo)

        then:
        trabajo.procesado
        trabajo.error

        where:
        tipo       | operando1 | operando2
        "suma"     | 1         | null
        "cuadrado" | 1         | 2
        "asdfs"    | 2         | 4
    }

}
