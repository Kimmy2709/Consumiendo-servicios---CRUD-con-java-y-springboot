package pe.isil.integracion_apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.integracion_apps.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    public Carrera getByCodigo(String codigo);
}
