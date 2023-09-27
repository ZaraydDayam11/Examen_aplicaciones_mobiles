package pe.edu.upeu.asistencia.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.asistencia.models.Materiales;

@Repository
public interface MaterialesRepository extends JpaRepository<Materiales, Long> {

}