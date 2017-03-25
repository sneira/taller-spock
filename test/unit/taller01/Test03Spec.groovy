package taller01

import spock.lang.Ignore
import spock.lang.Specification

/**
 * 3. Funcionamiento del where
 */

@Ignore
class Test03Spec extends Specification {

    def "Detalles sobre el funcionamiento del where"() {
        setup:
        String extension = ".pdf"

        expect:
        nombre + ext == nombreEsperado

        where:
        nombre | ext | nombreEsperado
        "prueba" | ".png" | "prueba.png"
        "prueba" | ".gif" | "prueba.gif"
        "prueba" | extension | "prueba.pdf"
    }

}
