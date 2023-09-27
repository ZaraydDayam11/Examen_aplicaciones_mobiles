package pe.edu.upeu.asistencia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pe.edu.upeu.asistencia.exceptions.AppException;
import pe.edu.upeu.asistencia.exceptions.ResourceNotFoundException;
import pe.edu.upeu.asistencia.models.Matricula;
import pe.edu.upeu.asistencia.repositories.MatriculaRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class MatriculaServiceImp implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepo;

    @Override
    public Matricula save(Matricula matricula) {

        try {
            return matriculaRepo.save(matricula);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Matricula> findAll() {
        try {
            return matriculaRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Matricula matriculax = matriculaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula not exist with id :" + id));

        matriculaRepo.delete(matriculax);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Matricula getMatriculaById(Long id) {
        Matricula findMatricula = matriculaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula not exist with id :" + id));
        return findMatricula;
    }

    @Override
    public Matricula update(Matricula matricula, Long id) {
        Matricula matriculax = matriculaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));

        matriculax.setEstado(matricula.getEstado());
        return matriculaRepo.save(matriculax);
    }
}
