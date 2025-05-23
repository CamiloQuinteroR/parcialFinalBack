package parcial.parcial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import parcial.parcial.model.Cita;
import parcial.parcial.service.ServiceCita;

/**
 * Controlador REST para la gestión de Citas.
 */
@RestController
@RequestMapping("/Cita")
public class CitaController {

    @Autowired
    private ServiceCita serviceCita;

    /**
     * Endpoint para crear un nuevo Cita.
     * @param Cita Objeto Cita recibido en el cuerpo de la solicitud.
     * @return ResponseEntity con la Cita creada y el estado HTTP 201 (CREATED).
     */
    @PostMapping("/create")
    public ResponseEntity<Cita> createCita(@RequestBody Cita Cita) {
        return new ResponseEntity<>(serviceCita.createCita(Cita), HttpStatus.CREATED);
    }

    /**
     * Endpoint para obtener todos las Citas registradas.
     * @return ResponseEntity con la lista de Citas y el estado HTTP 200 (OK).
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Cita>> getAllCitas() {
        return new ResponseEntity<>(serviceCita.getAllCita(), HttpStatus.OK);
    }

    /**
     * Endpoint para obtener una Cita específica mediante su ID.
     * @param id Identificador único de la Cita.
     * @return ResponseEntity con la Cita encontrada y el estado HTTP 202 (ACCEPTED),
     *         o estado HTTP 404 (NOT FOUND) si no se encuentra.
     */
    @GetMapping("/getCita/{id}")
    public ResponseEntity<Cita> getCita(@PathVariable String id) {
        Optional<Cita> Cita = serviceCita.getCitaById(id);
        if (Cita.isPresent()) {
            return new ResponseEntity<>(Cita.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint para eliminar una Cita específica mediante su ID.
     * @param id Identificador único de la Cita a eliminar.
     * @return ResponseEntity con estado HTTP 204 (NO CONTENT) si la eliminación es exitosa,
     *         o estado HTTP 404 (NOT FOUND) en caso de error.
     */
    @DeleteMapping("/deleteCita/{id}")
    public ResponseEntity<?> deleteCitaById(@PathVariable String id) {
        try {
            serviceCita.deleteCitaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint para eliminar todos las Citas registradas.
     * @return ResponseEntity con estado HTTP 204 (NO CONTENT) después de eliminar todos las Citas.
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllCitas() {
        serviceCita.deleteCitas();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
