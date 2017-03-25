package taller01

import spock.lang.Shared
import spock.lang.Specification

/**
 * 6. Variables compartidas
 */
class Test06Spec extends Specification {

    @Shared BigDecimal numero = new BigDecimal(0)

    def "Test 1"() {
        expect:
        numero.longValue() == 0

        when:
        numero = numero.add(new BigDecimal(5))

        then:
        numero.longValue() == 5
    }

    def "Test 2"() {
        expect:
        numero.longValue() == 5

        when:
        numero = numero.add(new BigDecimal(5))

        then:
        numero.longValue() == 10
    }


}
