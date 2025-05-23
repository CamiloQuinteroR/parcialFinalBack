package parcial.parcial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parcial.parcial.model.Especialidad;
import parcial.parcial.service.ServiceEspecialidad;

@RestController
@RequestMapping("/Especialidad")
public class EspecialidadController {

    @Autowired
    private ServiceEspecialidad serviceEspecialidad;

    /**
     * Crea una nueva Especialidadad en la base de datos.
     * @param Especialidad Objeto de tipo Especialidad que se debe almacenar.
     * @return ResponseEntity con la Especialidad creada y el código de estado HTTP 201 (CREATED).
     */
    @PutMapping("/create")
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad Especialidad) {
        return new ResponseEntity<>(serviceEspecialidad.createEspecialidad(Especialidad), HttpStatus.CREATED);
    }

    /**
     * Obtiene la lista de todas los Especialidades almacenadas.
     * @return ResponseEntity con la lista de Especialidades y el código de estado HTTP 202 (ACCEPTED).
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Especialidad>> getAllEspecialidad() {
        return new ResponseEntity<>(serviceEspecialidad.getAllEspecialidad(), HttpStatus.ACCEPTED);
    }

    /**
     * Obtiene un Especialidadad específica según su identificador.
     * @param id Identificador del Especialidadad a buscar.
     * @return ResponseEntity con el Especialidadad si se encuentra, o código de estado HTTP 404 (NOT_FOUND) si no existe.
     */
    @GetMapping("/getEspecialidad/{id}")
    public ResponseEntity<Especialidad> getEspecialidad(@PathVariable String id) {
        Optional<Especialidad> Especialidad = serviceEspecialidad.getEspecialidadById(id);
        if (Especialidad.isPresent()) {
            return new ResponseEntity<>(Especialidad.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Elimina todos las Especialidades almacenadas en la base de datos.
     * @return ResponseEntity con el código de estado HTTP 202 (ACCEPTED).
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteEspecialidad() {
        serviceEspecialidad.deleteEspecialidads();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * Elimina una Especialidadad específica según su identificador.
     * @param id Identificador de la Especialidadad a eliminar.
     * @return ResponseEntity con el código de estado HTTP 202 (ACCEPTED) si la eliminación es exitosa,
     * o HTTP 404 (NOT_FOUND) si la Especialidadad no existe.
     */
    @DeleteMapping("/deleteEspecialidad/{id}")
    public ResponseEntity<?> deleteEspecialidadById(@PathVariable String id) {
        try {
            serviceEspecialidad.deleteEspecialidadById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
