package prueba.demo.service;

import prueba.demo.dto.ClienteResponseDto;
import prueba.demo.exception.ClientNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest 
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService; 

    @Test
    void shouldReturnClientWhenDataIsCorrect() {
        ClienteResponseDto cliente = clienteService.consultarCliente("C", "23445322");
        assertEquals("Juan", cliente.getPrimerNombre());
        assertEquals("Pérez", cliente.getPrimerApellido());
        assertEquals("555-1234", cliente.getTelefono());
        assertEquals("Bogotá", cliente.getCiudad());
    }

    @Test
    void shouldThrowExceptionWhenClientNotFound() {
        assertThrows(ClientNotFoundException.class, () -> {
            clienteService.consultarCliente("C", "12345678");
        });
    }

    @Test
    void shouldThrowExceptionForInvalidDocumentType() {
        assertThrows(IllegalArgumentException.class, () -> {
            clienteService.consultarCliente("X", "23445322");
        });
    }
}
