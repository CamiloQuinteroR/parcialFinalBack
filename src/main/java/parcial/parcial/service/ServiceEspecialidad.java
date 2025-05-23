package parcial.parcial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parcial.parcial.model.Especialidad;
import parcial.parcial.repository.RepoEspecialidad;


@Service
public class ServiceEspecialidad {

    @Autowired
    private RepoEspecialidad repoEspecialidad;

    /**
     * Crea una nueva especialidd y la almacena en la base de datos.
     * @param Especialidad Objeto Especialidad
     * @return La Especalidad creada.
     */
    public Especialidad createEspecialidad(Especialidad Especialidad) {
        repoEspecialidad.save(Especialidad);
        return Especialidad;
    }

    /**
     * Obtiene la lista de todos las especalidades almacenadas en la base de datos.
     * @return Lista de especialidad.
     */
    public List<Especialidad> getAllEspecialidad() {
        return repoEspecialidad.findAll();
    }

    /**
     * Busca una especialidad por su identificador.
     * @param id Identificador unico de especialidad.
     * @return Un Optional que contiene la especialidad si se encuentra, o vacío si no existe.
     */
    public Optional<Especialidad> getEspecialidadById(String id) {
        return repoEspecialidad.findById(id);
    }

    /**
     * Elimina una especialidad de la base de datos según su identificador.
     * @param id Identificador único de especialidad a eliminar.
     * @throws RuntimeException si la especailidad no se encuentra.
     */
    public void deleteEspecialidadById(String id) {
        Optional<Especialidad> EspecialidadOptional = getEspecialidadById(id);
        if (EspecialidadOptional.isPresent()) {
            repoEspecialidad.delete(EspecialidadOptional.get());
        } else {
            throw new RuntimeException("Especialidad no encontrado con ID: " + id);
        }
    }

    /**
     * Elimina todos las espaecialidad almacenadas en la base de datos.
     */
    public void deleteEspecialidads() {
        repoEspecialidad.deleteAll();
    }
}
