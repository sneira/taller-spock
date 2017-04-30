package mensajes

import mensajeria.ColaMensajes
import mensajeria.Mensaje
import spock.lang.Ignore
import spock.lang.Specification

/**
 * 3. Funcionamiento del where
 */
class Mensajes03Spec extends Specification {

    def "Añadir mensajes a una cola"() {
        setup:
        ColaMensajes cola = new ColaMensajes()

        when:
        cola.addMensaje(new Mensaje(remitente, destinatario, texto))

        then:
        cola.totalMensajes() == totalMensajes

        where:
        remitente | destinatario | texto                       | totalMensajes
        "usu1"    | "usu2"       | "Prueba"                    | 1
        "admin"   | "rrhh"       | "Alta de usuario"           | 1
        "admin"   | "empresa"    | "Incidencia en el servicio" | 1
    }
    // El valor de las variables no se guarda de una fila del where (iteración) a la siguiente. De hecho, cada línea
    // del where es una llamada al método con las variables definidas en la cabecera de la tabla como parámetros.

    def "Los mensajes nulos no se añaden"() {
        /*setup:
        ColaMensajes cola = new ColaMensajes()
        Mensaje mens = new Mensaje("remitente", "destinatario", "texto")

        when:
        cola.addMensaje(mensaje)

        then:
        cola.totalMensajes() == total

        where:
        mensaje | total
        null    | 0
        mens    | 1*/
    }
    /*
    Si descomentamos y ejecutamos este test, da el siguiente error: "No such property: mens for class: mensajes.Mensajes03Spec".
    Esto se debe a que Spock transforma los tests con where en lo siguiente:
        def "Los mensajes nulos no se añaden"(mensaje, total) {
            setup:
            ColaMensajes cola = new ColaMensajes()
            Mensaje mens = new Mensaje("remitente", "destinatario", "texto")

            when:
            cola.addMensaje(mensaje)

            then:
            cola.totalMensajes() == total
        }
     Luego llama a este método con cada fila de datos indicada en el where:
        "Los mensajes nulos no se añaden"(null, 0)
        "Los mensajes nulos no se añaden"(mens, 1) -> aquí está el problema: no hemos definido mens previamente
     */

}
