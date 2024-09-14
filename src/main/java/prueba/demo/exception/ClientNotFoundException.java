package prueba.demo.exception;

public class ClientNotFoundException extends RuntimeException {

   
    public ClientNotFoundException() {
        super("Cliente no encontrado");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
