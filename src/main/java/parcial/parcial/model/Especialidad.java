package parcial.parcial.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Especialidad")
public class Especialidad {
    @Id
    private String idEspecialidad;
    private String descripcion;


    public Especialidad(String idEspecialidad, String descripcion) {
        this.idEspecialidad = idEspecialidad;
        this.descripcion = descripcion;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }
}
