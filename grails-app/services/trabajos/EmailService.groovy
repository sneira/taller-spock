package trabajos

class EmailService {

    static transactional = false

    def mailService

    def notificarFinBatch(Integer numTrabajos) {
        enviarMail(getEmailAdmin(), textoFinBatch(numTrabajos))
    }

    def notificarErrorTrabajo(Trabajo trabajo) {
        enviarMail(getEmailAdmin(), textoFallo(trabajo))
    }

    String getEmailAdmin() {
        Configuracion configuracion = Configuracion.first()
        if (configuracion?.emailAdmin) {
            return configuracion.emailAdmin
        } else {
            println "No hay email de administrador configurado"
            return null
        }
    }

    def enviarMail(String direccionDestino, String texto) {
        if (direccionDestino) {
            println "Enviando notificación a ${direccionDestino}"
            mailService.sendMail {
                from "taller-spock@virtualsw.com"
                to direccionDestino
                subject "Notificación"
                body texto
            }
        } else {
            println "La dirección de email no es válida"
        }
    }

    private static String textoFallo(Trabajo trabajo) {
        "El trabajo ${trabajo.nombre} del usuario ${trabajo.usuario.nombre} ha dado error."
    }

    private static String textoFinBatch(Integer trabajosProcesados) {
        "Se ha procesado un lote de ${trabajosProcesados} trabajo(s)."
    }

}
