package prueba.demo.service;

import org.springframework.stereotype.Service;
import prueba.demo.dto.ClienteResponseDto;
import prueba.demo.exception.ClientNotFoundException;

@Service 
public class ClienteService {

    public ClienteResponseDto consultarCliente(String tipoDocumento, String numeroDocumento) {
        if (!"C".equals(tipoDocumento) && !"P".equals(tipoDocumento)) {
            throw new IllegalArgumentException("Tipo de documento inválido");
        }

        if ("C".equals(tipoDocumento) && "23445322".equals(numeroDocumento)) {
            return new ClienteResponseDto("Juan", "Pérez", "555-1234", "Bogotá");
        } else {
            throw new ClientNotFoundException("Cliente no encontrado");
        }
    }
}
