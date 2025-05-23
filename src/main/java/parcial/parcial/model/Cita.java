package parcial.parcial.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "Cita")
public class Cita {
    @Id
    private String id;
    private String idEspecialidad;
    private String fecha;
    private String ubicacion;
    private String estado;
    private String doctor;


    public Cita(String id, String idEspecialidad, String fecha, String ubicacion,String estado, String doctor) {
        this.id = id;
        this.idEspecialidad= idEspecialidad;
        this.fecha= fecha;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.doctor = doctor;
    }

}
