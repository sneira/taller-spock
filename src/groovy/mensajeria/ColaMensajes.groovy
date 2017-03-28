package mensajeria

class ColaMensajes {

    private ArrayList<Mensaje> cola

    ColaMensajes() {
        cola = new ArrayList<Mensaje>()
    }

    def addMensaje(Mensaje mensaje) {
        if (mensaje) {
            cola.add(mensaje)
            cola.sort()
        }
    }

    def totalMensajes() {
        cola.size()
    }

    def getMensajeEnPosicion(int i) {
        cola.get(i)
    }

    def vaciar() {
        cola.clear()
    }

    @Override
    String toString() {
        String cadena = "*** Cola con ${totalMensajes()} mensajes ***"
        for (Mensaje mens : cola) {
            cadena += "\n - ${mens}"
        }
        cadena
    }

}
