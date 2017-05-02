package trabajos

import grails.transaction.Transactional

@Transactional
class ExecutorService {

    def emailService

    def procesarTrabajo(Trabajo trabajo) {
        if (trabajo.tipo.equalsIgnoreCase("suma")) {
            if (trabajo.operando1 && trabajo.operando2) {
                trabajo.resultado = sumar(trabajo.operando1, trabajo.operando2)
            } else {
                trabajo.error = true
            }
        } else if (trabajo.tipo.equalsIgnoreCase("cuadrado")) {
            if (trabajo.operando2) {
                trabajo.error = true
            } else {
                trabajo.resultado = cuadrado(trabajo.operando1)
            }
        } else {
            trabajo.error = true
        }
        trabajo.procesado = true
        trabajo.save()

        if (trabajo.error) {
            emailService.notificarErrorTrabajo(trabajo)
        }
    }

    private Integer sumar(Integer operando1, Integer operando2) {
        println "Sumando ${operando1} + ${operando2}..."
        operando1 + operando2
    }

    private Integer cuadrado(Integer operando) {
        println "Elevando ${operando} al cuadrado..."
        operando ^ 2
    }

}
