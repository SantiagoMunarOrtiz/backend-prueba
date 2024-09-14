package prueba.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.demo.model.Cliente; 

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping("/{tipo}/{numero}")
    public ResponseEntity<?> getCliente(
        @PathVariable String tipo,
        @PathVariable String numero
    ) {
        try {
          
            if (!tipo.equalsIgnoreCase("C") && !tipo.equalsIgnoreCase("P")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Tipo de documento no válido. Solo se permite 'C' o 'P'.");
            }

           
            if (numero == null || numero.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Número de documento es obligatorio.");
            }

            
            if (tipo.equalsIgnoreCase("C") && numero.equals("23445322")) {
                Cliente cliente = new Cliente();
                cliente.setPrimerNombre("Juan");
                cliente.setSegundoNombre("Carlos");
                cliente.setPrimerApellido("Perez");
                cliente.setSegundoApellido("Garcia");
                cliente.setTelefono("123456789");
                cliente.setDireccion("Calle Falsa 123");
                cliente.setCiudadResidencia("Bogotá");

                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente no encontrado.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno en el servidor.");
        }
    }
}
