package mensajeria

class Mensaje implements Comparable<Mensaje> {

    public static final int PRIORIDAD_ALTA = 1
    public static final int PRIORIDAD_NORMAL = 2
    public static final int PRIORIDAD_BAJA = 3

    String remitente
    String destinatario
    Integer prioridad
    String texto
    Long timestamp
    String nombreAdjunto

    public Mensaje(String remitente, String destinatario, String texto) {
        this(remitente, destinatario, texto, PRIORIDAD_NORMAL)
    }

    public Mensaje(String remitente, String destinatario, String texto, Integer prioridad) {
        if (!remitente) {
            throw new DatosIncompletosException("Falta el remitente")
        }

        if (!destinatario) {
            throw new DatosIncompletosException("Falta el destinatario")
        }

        if (!texto) {
            throw new DatosIncompletosException("Falta el texto del mensaje")
        }

        this.timestamp = System.currentTimeMillis()
        this.remitente = remitente
        this.destinatario = destinatario
        this.texto = texto
        this.prioridad = prioridad
    }

    public void adjuntarFichero(String nombreFichero) {
        this.nombreAdjunto = GeneradorNombres.normalizarNombre(nombreFichero)
    }

    @Override
    int compareTo(Mensaje o) {
        int comparacionPrioridades = prioridad.compareTo(o.prioridad)
        return (comparacionPrioridades != 0 ? comparacionPrioridades : timestamp.compareTo(o.timestamp))
    }

    @Override
    String toString() {
        "De ${remitente} a ${destinatario}: '${texto}' (${timestamp})"
    }
}