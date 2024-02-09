package pe.isil.integracion_apps.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String carrera;
}
