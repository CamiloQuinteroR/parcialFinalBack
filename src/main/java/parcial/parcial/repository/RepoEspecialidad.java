package parcial.parcial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import parcial.parcial.model.Especialidad;

@Repository
public interface RepoEspecialidad extends MongoRepository<Especialidad, String> {}
