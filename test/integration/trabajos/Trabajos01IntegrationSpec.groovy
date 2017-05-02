package trabajos

import grails.test.spock.IntegrationSpec

/**
 * 1. Creación de datos para tests
 * Este test es para demostrar las posibilidades que tenemos de crear datos para un test. En una aplicación normal,
 * no tendría sentido hacer un test para comprobar que los datos se guardan.
 * Opciones:
 *  - Método save() de las clases de dominio
 *  - Método build del plugin build-test-data (https://grails.org/plugin/build-test-data?skipRedirect=true)
 * La idea es completar los tests utilizando la menor cantidad posible de parámetros en los constructores.
 */

// Creación del test: podemos hacerlo con Idea o utilizando el comando create-integration-test <nombre>. En este caso,
// por defecto se añade IntegrationSpec al nombre indicado. Si no se especifica un paquete, se usa el nombre de la aplicación
// como nombre de paquete por defecto.
// La clase tiene que heredar de IntegrationSpec.
class Trabajos01IntegrationSpec extends IntegrationSpec {

    def "1. Guardado con save"() {
        expect:
        Trabajo.count == 0

        when:

        then:
        Trabajo.count == 1
    }

    def "2. Guardado con build (plugin build-test-data)"() {
        expect:
        Trabajo.count == 0

        when:

        then:
        Trabajo.count == 1
    }

    def "3. Limitaciones del build"() {
        expect:
        Trabajo.count == 0

        when:

        then:
        Trabajo.count == 2
    }

}
