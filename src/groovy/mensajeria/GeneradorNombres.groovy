package mensajeria

import java.text.Normalizer

class GeneradorNombres {

    static String normalizarNombre(String nombreOriginal) {
        if (nombreOriginal) {
            // Con el normalize sustituimos los caracteres con tilde por sus equivalentes sin ella (por ejemplo, ó por o).
            // Con el replaceAll quitamos todos los caracteres que no sean letras, números, puntos, guiones o espacios.
            return Normalizer.normalize(nombreOriginal, Normalizer.Form.NFD).replaceAll("[^a-zA-Z0-9\\.\\- ]+","");
        }
        return nombreOriginal
    }
}
