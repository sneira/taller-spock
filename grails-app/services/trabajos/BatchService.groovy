package trabajos

import grails.transaction.Transactional

@Transactional
class BatchService {

    def executorService
    def emailService

    def procesoBatch() {
        println ">> Proceso batch: inicio <<"

        List<Trabajo> trabajosPendientes = Trabajo.findAllByProcesado(false)
        int numTrabajosPendientes = trabajosPendientes.size()
        println "Trabajos pendientes: ${numTrabajosPendientes}"
        Trabajo.findAll().each { Trabajo trabajo ->
            println "Procesando trabajo ${trabajo.tipo} (${trabajo.id}) para usuario ${trabajo.usuario.nombre}"
            executorService.procesarTrabajo(trabajo)
        }
        emailService.notificarFinBatch(numTrabajosPendientes)
        println ">> Proceso batch: fin <<"
    }

}
