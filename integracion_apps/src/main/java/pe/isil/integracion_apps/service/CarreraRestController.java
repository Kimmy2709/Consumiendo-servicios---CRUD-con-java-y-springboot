package pe.isil.integracion_apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.isil.integracion_apps.model.Carrera;
import pe.isil.integracion_apps.repository.CarreraRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraRestController {

    @Autowired
    public CarreraRepository carreraRepository;

    @GetMapping("/getAll")
    public List<Carrera> getAll() {
        return carreraRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Carrera>  getById(@PathVariable("id") Integer id){
        return carreraRepository.findById(id);
    }

    @GetMapping("/getByCodigo/{codigo}")
    public Carrera getByCodigo(@PathVariable("codigo") String codigo){
        return carreraRepository.getByCodigo(codigo);
    }

    @PostMapping("/store")
    public Carrera store(@RequestBody Carrera carrera){
        carrera.setId(0);
        return carreraRepository.save(carrera);
    }

    @PutMapping("/update/{id}")
    public Carrera update(@PathVariable("id") Integer id, @RequestBody Carrera carrera ){
        Carrera updateCarrera = carreraRepository.getById(id);
        updateCarrera.setNombre(carrera.getNombre());
        updateCarrera.setCodigo(carrera.getCodigo());
        return carreraRepository.save(updateCarrera);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
         carreraRepository.deleteById(id);
    }
}
