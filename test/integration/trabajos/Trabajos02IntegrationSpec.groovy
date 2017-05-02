package trabajos

import grails.test.spock.IntegrationSpec

/**
 * 2. Prueba del ExecutorService
 */
class Trabajos02IntegrationSpec extends IntegrationSpec {

    def executorService

    def "1. Los trabajos correctamente configurados se marcan como procesados sin errores"() {
        /* Rellenar los bloques que faltan */

        when:
        executorService.procesarTrabajo(trabajo)

        then:
        trabajo.procesado
        !trabajo.error
    }

    def "2. Los trabajos incorrectamente configurados se marcan como procesados con errores"() {
        /* Rellenar los bloques que faltan */

        when:
        executorService.procesarTrabajo(trabajo)

        then:
        trabajo.procesado
        trabajo.error
    }

}
