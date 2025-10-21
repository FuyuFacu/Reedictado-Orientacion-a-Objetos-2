package ar.info.juego.Encriptador;

public class FeistelCipherAdapter implements TipoCifrado {
    private FeistelCipher raiz;

    public FeistelCipherAdapter(FeistelCipher raiz) {
        this.raiz = raiz;
    }

    public String encriptar(String mensaje, String key) {
        return this.raiz.encode(mensaje); // La duda que tengo es si de esta manera es correcta o deberia instanciar un nuevo objeto de FeistelCipher y ahi poner la clave, en tiempo de ejecucion
    }

    public String desencriptar(String mensaje, String key) {
        return this.raiz.encode(mensaje);
    }

}
