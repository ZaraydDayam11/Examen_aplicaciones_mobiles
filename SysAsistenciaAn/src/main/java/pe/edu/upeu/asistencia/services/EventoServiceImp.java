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
import pe.edu.upeu.asistencia.models.Evento;
import pe.edu.upeu.asistencia.repositories.EventoRepository;

@RequiredArgsConstructor
@Service
@Transactional
public class EventoServiceImp implements EventoService {

    @Autowired
    private EventoRepository eventoRepo;

    @Override
    public Evento save(Evento evento) {

        try {
            return eventoRepo.save(evento);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Evento> findAll() {
        try {
            return eventoRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Evento eventox = eventoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento not exist with id :" + id));

        eventoRepo.delete(eventox);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Evento getEventoById(Long id) {
        Evento findEvento = eventoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("evento not exist with id :" + id));
        return findEvento;
    }

    @Override
    public Evento update(Evento evento, Long id) {
        Evento eventox = eventoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        eventox.setFecha(evento.getFecha());
        eventox.setHorai(evento.getHorai());
        eventox.setEstado(evento.getEstado());
        return eventoRepo.save(eventox);
    }
}
