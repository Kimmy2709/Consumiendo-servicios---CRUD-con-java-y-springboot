package pe.isil.integracion_apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.isil.integracion_apps.model.Estudiante;
import pe.isil.integracion_apps.repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteRestController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/getAll")
    public List<Estudiante> getAll(){
        return estudianteRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Estudiante> getById(@PathVariable("id") Integer id){
        return estudianteRepository.findById(id);
    }

    @GetMapping("/getByDni/{dni}")
    public Optional<Estudiante> findByDni(@PathVariable("dni") String dni){
        return estudianteRepository.findByDni(dni);
    }

    @PostMapping("/insert")
    public Estudiante insert(@RequestBody Estudiante estudiante){
        estudiante.setId(0);
        return estudianteRepository.save(estudiante);
    }
    @PutMapping("/update/{Id}")
    public Estudiante  update(@PathVariable("Id") Integer Id, @RequestBody Estudiante estudiante){
        Estudiante nuevoEstudiante = estudianteRepository.getById(Id);
        nuevoEstudiante.setApellidos(estudiante.getApellidos());
        nuevoEstudiante.setNombres(estudiante.getNombres());
        nuevoEstudiante.setCarrera(estudiante.getCarrera());
        nuevoEstudiante.setDni(estudiante.getDni());
        return estudianteRepository.save(nuevoEstudiante);
    }

    @DeleteMapping("/delete/{Id}")
    private void delete(@PathVariable("Id") Integer Id){
        estudianteRepository.deleteById(Id);
    }
}
