package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.asistencia.models.Evento;

public interface EventoService {
    Evento save(Evento evento);

    List<Evento> findAll();

    Map<String, Boolean> delete(Long id);

    Evento getEventoById(Long id);

    Evento update(Evento evento, Long id);
}
