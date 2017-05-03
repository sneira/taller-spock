package trabajos

import grails.test.spock.IntegrationSpec

/**
 * 3. Otra manera de probar el ExecutorService
 */
class Trabajos03IntegrationSpec extends IntegrationSpec {

    def executorService

    def setupSpec() {
        Usuario usuario = Usuario.build()

        // Trabajos válidos
        Trabajo.build(nombre: "ok", tipo: "suma", operando1: 3, operando2: 2, usuario: usuario)
        Trabajo.build(nombre: "ok", tipo: "cuadrado", operando1: 2, usuario: usuario)

        // Trabajos no válidos
        Trabajo.build(nombre: "error", usuario: usuario)
        Trabajo.build(nombre: "error", tipo: "suma", operando1: 3, usuario: usuario)
        Trabajo.build(nombre: "error", tipo: "cuadrado", operando1: 2, operando2: 5, usuario: usuario)

        // Nos aseguramos de que los datos se han guardado bien
        assert Trabajo.count == 5
    }

    def "1. Los trabajos correctamente configurados se marcan como procesados sin errores"() {
        when:
        executorService.procesarTrabajo(trabajo)

        then:
        trabajo.procesado
        !trabajo.error

        where:
        trabajo << Trabajo.findAllByNombre("ok")
    }

    def "2. Los trabajos incorrectamente configurados se marcan como procesados con errores"() {
        when:
        executorService.procesarTrabajo(trabajo)

        then:
        trabajo.procesado
        trabajo.error

        where:
        trabajo << Trabajo.findAllByNombre("error")
    }

    // Cuidado: si no pongo esto, los datos que he creado en el cleanupSpec se mantienen para el resto de tests, y pueden causar fallos.
    def cleanupSpec() {
        Trabajo.findAll().each { it.delete() } // No, no hay un deleteAll...
        Usuario.findAll().each { it.delete() }
    }

}
