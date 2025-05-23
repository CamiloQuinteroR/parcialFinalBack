package parcial.parcial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parcial.parcial.model.Cita;
import parcial.parcial.repository.RepoCita;

@Service
public class ServiceCita {
    @Autowired
    private RepoCita repoCita;

    // Metodo para crear una nueva Cita y guardarla en la base de datos
    public Cita createCita(Cita Cita) {
        repoCita.save(Cita);
        return Cita;
    }   

    // Metodo para obtener la lista de todos las Citas almacenadas en la base de datos
    public List<Cita> getAllCita() {
        return repoCita.findAll();
    }

    // Metodo para obtener un Cita especifica por su ID
    public Optional<Cita> getCitaById(String id) {
        return repoCita.findById(id);
    }

    // Metodo para eliminar una Cita por su ID, verificando primero si existe
    public void deleteCitaById(String id) {
        Optional<Cita> CitaOptional = getCitaById(id);
        if (CitaOptional.isPresent()) {
            repoCita.delete(CitaOptional.get());
        } else {
            throw new RuntimeException("Cita no encontrada con ID: " + id);
        }
    }

    // Metodo para eliminar todos las Citas de la base de datos
    public void deleteCitas() {
        repoCita.deleteAll();
    }
}
