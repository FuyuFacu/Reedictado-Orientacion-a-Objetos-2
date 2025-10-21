package ar.info.juego.Encriptador;

public class Mensajero {
    private TipoCifrado tipoCifrado;

    public void enviar(String mensaje) {
        String mensajeCifrado = tipoCifrado.encriptar(mensaje, "123");
        System.out.println("enviando " + mensajeCifrado);
    }

    public void recibir(String mensaje) {
        String mensajeDesencriptado = tipoCifrado.desencriptar(mensaje, "123");
        System.out.println("Sistema desencriptado: " + mensajeDesencriptado);
    }
}
