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
        Usuario usuario = new Usuario(nombre: 'nombre')
        usuario.save()
        Trabajo trabajo = new Trabajo(nombre: 'prueba', tipo: 'suma', operando1: 1, usuario: usuario)
        trabajo.save()
        // if (trabajo.hasErrors()) -> manera de saber que el save no ha ido bien por errores de validación.
        // Si hacemos trabajo.save(failOnError: true) da una excepción en caso de que no se pueda guardar por errores de validación.

        then:
        Trabajo.count == 1
        // Truco comentado por JMiguel: manera de comprobar que la tabla tiene un registro más, sin tener que guardar cuántos había antes
        // Trabajo.count == old(Trabajo.count) + 1
    }

    def "2. Guardado con build (plugin build-test-data)"() {
        expect:
        Trabajo.count == 0

        when:
        Trabajo.build()

        then:
        Trabajo.count == 1
    }

    def "3. Limitaciones del build"() {
        expect:
        Trabajo.count == 0

        when:
        Usuario usuario = Usuario.build()
        Trabajo.build(usuario: usuario)
        Trabajo.build(usuario: usuario)
        // Otra opción más Groovy:
        /*2.times {
            Trabajo.build(usuario: usuario)
        }*/

        then:
        Trabajo.count == 2
    }

}
