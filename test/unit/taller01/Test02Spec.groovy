package taller01

import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 * 2. Tests orientados a datos
 */

@Unroll
class Test02Spec extends Specification {

    def "Tuberías de datos"() {
        expect:
        Math.max(op1, op2) == resultado

        where:
        op1 << [1, 2, 3, 4]
        op2 << [5, 6, 1, 2]
        resultado << [5, 6, 3, 4]
    }

    def "Tablas de datos"() {
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
