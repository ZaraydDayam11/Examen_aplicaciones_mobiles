package pe.edu.upeu.asistencia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.asistencia.models.Evento;
import pe.edu.upeu.asistencia.models.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    Optional<Matricula> findByEstado(String estado);
}
