import grails.util.Environment

class BootStrap {

    def loadInitialDataService

    // Lo que pongamos aquí nos valdrá para los tests de integración o para los funcionales,
    // pero no para los unitarios, ya que para ejecutarlos no se arranca la aplicación.
    def init = { servletContext ->
        def entorno = Environment.current.name
        def fase = System.properties["grails.test.phase"] // Esto se carga desde el fichero _Events.groovy, en la carpeta scripts
        println "========== Entorno: ${entorno} =========="
        if (fase) {
            println "========== Fase: ${fase} =========="
        }

        if (entorno == "test") {
            loadInitialDataService.loadDataForTest()
        }

        // O podemos llamar al método por reflexión:
        // loadInitialDataService."loadDataFor${entorno.capitalize()}"()
    }

    def destroy = {
    }

}
