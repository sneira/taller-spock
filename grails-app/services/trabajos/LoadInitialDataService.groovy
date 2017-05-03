package trabajos

class LoadInitialDataService {

    static transactional = false

    def loadDataForTest() {
        Configuracion.build(emailAdmin: 'sofia@virtualsw.com')
    }

}
