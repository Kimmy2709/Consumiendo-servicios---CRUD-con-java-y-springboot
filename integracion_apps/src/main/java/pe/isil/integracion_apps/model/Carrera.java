package pe.isil.integracion_apps.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.text.TabableView;

@Data
@Table( name = "carrera")
@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Integer id;
    public  String nombre;
    public String codigo;

}
