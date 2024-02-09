package pe.isil.integracion_apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.integracion_apps.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
