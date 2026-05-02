package Excepciones;

public class NohayProductoException extends Exception{
    public NohayProductoException(String mensaje) {
        super(mensaje);
    }
}