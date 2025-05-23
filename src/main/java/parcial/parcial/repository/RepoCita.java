package parcial.parcial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import parcial.parcial.model.Cita;

@Repository
public interface  RepoCita extends MongoRepository<Cita, String>{}




