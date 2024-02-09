package pe.isil.integracion_apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.isil.integracion_apps.model.Curso;
import pe.isil.integracion_apps.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/intapps/cursos")
public class CursoRestController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/getAll")
    public List<Curso> getAll(){
        return cursoRepository.findAll();
    }
    @GetMapping("/getById/{Id}")
    public Optional<Curso> getById(@PathVariable ("Id") Integer Id){
        return cursoRepository.findById(Id);
    }
    @PostMapping("/agregar")
    public Curso insert(@RequestBody Curso curso){
        curso.setId(0);
        return cursoRepository.save(curso);
    }
    @PutMapping("/actualizar/{Id}")
    public  Curso update(@PathVariable ("Id") Integer Id,@RequestBody Curso curso){
        Curso cursoFromDB = cursoRepository.getById(Id);
        cursoFromDB.setNrc(curso.getNrc());
        cursoFromDB.setNombre(curso.getNombre());
        return cursoRepository.save(cursoFromDB);
    }

    @DeleteMapping("delete/{Id}")
    public void delete(@PathVariable("Id") Integer Id){
        cursoRepository.deleteById(Id);
    }
}
