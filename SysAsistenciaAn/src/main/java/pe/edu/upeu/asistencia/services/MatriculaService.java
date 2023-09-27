package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.asistencia.models.Matricula;

public interface MatriculaService {
    Matricula save(Matricula matricula);

    List<Matricula> findAll();

    Map<String, Boolean> delete(Long id);

    Matricula getMatriculaById(Long id);

    Matricula update(Matricula matricula, Long id);
}
