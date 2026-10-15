
package com.ejemplo.crudestudiantes.servicio;

import com.ejemplo.crudestudiantes.modelo.Estudiante;
import com.ejemplo.crudestudiantes.repositorio.EstudianteRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    // Obtener todos los estudiantes
    public List<Estudiante> listar() {
        return repository.findAll();
    }

    // Buscar estudiante por ID
    public Estudiante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Estudiante no encontrado"));
    }

    // Crear estudiante
    public Estudiante guardar(Estudiante estudiante) {
        estudiante.setId(null);
        return repository.save(estudiante);
    }

    // Actualizar estudiante
    public Estudiante actualizar(Long id, Estudiante datos) {

        Estudiante estudiante = buscarPorId(id);

        estudiante.setNombre(datos.getNombre());
        estudiante.setCorreo(datos.getCorreo());
        estudiante.setEdad(datos.getEdad());

        return repository.save(estudiante);
    }

    // Eliminar estudiante
    public void eliminar(Long id) {
        Estudiante estudiante = buscarPorId(id);
        repository.delete(estudiante);
    }
}
