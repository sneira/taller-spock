package trabajos

import grails.test.spock.IntegrationSpec

/**
 * 4. Prueba del BatchService
 */
class Trabajos04IntegrationSpec extends IntegrationSpec {

    def batchService

    def "1. El servicio procesa todos los trabajos de la tabla"() {
        expect:
        Trabajo.count == 0

        when:

        then:
        Trabajo.count == 2
        Trabajo.countByProcesado(true) == 0

        when:
        batchService.procesoBatch()

        then:
        Trabajo.countByProcesado(false) == 0
        Trabajo.countByError(true) == Trabajo.countByNombre("error")
        Trabajo.countByError(false) == Trabajo.countByNombre("ok")
    }

}
