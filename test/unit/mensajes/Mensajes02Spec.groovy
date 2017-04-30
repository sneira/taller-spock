package mensajes

import mensajeria.GeneradorNombres
import spock.lang.Specification

/**
 * 2. Tests orientados a datos
 * Bloque where con datos para iterar.
 * Maneras de crear conjuntos de datos:
 * - Tuberías: variable << [valor1, valor2, ..., valorN]
 * - Tablas (la opción Reformat code las formatea automáticamente):
 *      variable1 | variable2
 *      valor1    | valorX
 *      valor2    | valorY
 *      ...       | ...
 *      valorN    | valorZ
 */
class Mensajes02Spec extends Specification {

    def "1. Normalizado de nombres (forma 1: tuberías)"() {
        expect:
        GeneradorNombres.normalizarNombre(nombreOriginal) == nombreNormalizado

        where:
        nombreOriginal << ["prueba", "fichero.pdf", "Nombre con espacios.doc", "¡Reunión urgente mañana!.txt"]
        nombreNormalizado << ["prueba", "fichero.pdf", "Nombre con espacios.doc", "Reunion urgente manana.txt"]
    }

    def "2. Normalizado de nombres (forma 2: tablas)"() {
        expect:
        GeneradorNombres.normalizarNombre(nombreOriginal) == nombreNormalizado

        where:
        nombreOriginal                 | nombreNormalizado
        "prueba"                       | "prueba"
        "fichero.pdf"                  | "fichero.pdf"
        "Nombre con espacios.doc"      | "Nombre con espacios.doc"
        "¡Reunión urgente mañana!.txt" | "Reunion urgente manana.txt"
    }

}
