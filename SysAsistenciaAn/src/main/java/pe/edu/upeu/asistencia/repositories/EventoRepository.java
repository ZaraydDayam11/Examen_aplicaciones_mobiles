package pe.edu.upeu.asistencia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.asistencia.models.Actividad;
import pe.edu.upeu.asistencia.models.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<Evento> findByNombreEvento(String nombreEvento);
}
