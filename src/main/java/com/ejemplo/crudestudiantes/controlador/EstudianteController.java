
package com.ejemplo.crudestudiantes.controlador;

import com.ejemplo.crudestudiantes.modelo.Estudiante;
import com.ejemplo.crudestudiantes.servicio.EstudianteService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    // Listar estudiantes
    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    // Buscar estudiante por ID
    @GetMapping("/{id}")
    public Estudiante buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Crear estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crear(
            @RequestBody Estudiante estudiante) {
        Estudiante nuevo = service.guardar(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // Actualizar estudiante
    @PutMapping("/{id}")
    public Estudiante actualizar(
            @PathVariable Long id,
            @RequestBody Estudiante estudiante) {
        return service.actualizar(id, estudiante);
    }

    // Eliminar estudiante
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
