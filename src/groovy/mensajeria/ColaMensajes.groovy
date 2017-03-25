package mensajeria

class ColaMensajes {

    private ArrayList<Mensaje> cola

    ColaMensajes() {
        cola = new ArrayList<Mensaje>()
    }

    def addMensaje(Mensaje mensaje) {
        cola.add(mensaje)
        cola.sort()
    }

    def totalMensajes() {
        cola.size()
    }

    def getMensajeEnPosicion(int i) {
        cola.get(i)
    }

}
