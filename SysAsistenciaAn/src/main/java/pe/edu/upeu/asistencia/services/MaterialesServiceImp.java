package pe.edu.upeu.asistencia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upeu.asistencia.dtos.MaterialesDto;
import pe.edu.upeu.asistencia.exceptions.AppException;

import pe.edu.upeu.asistencia.exceptions.ResourceNotFoundException;
import pe.edu.upeu.asistencia.mappers.MaterialesMapper;
import pe.edu.upeu.asistencia.models.Materiales;
import pe.edu.upeu.asistencia.repositories.MaterialesRepository;

/**
 *
 * @author DELL
 */

@RequiredArgsConstructor
@Service
@Transactional
public class MaterialesServiceImp implements MaterialesService {

    @Autowired
    private MaterialesRepository materialesRepo;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private MatriculaService matriculaService;

    /*
     * @Autowired
     * private ActividadService actividadService;
     */

    private final MaterialesMapper materialesMapper;

    @Override
    public Materiales save(MaterialesDto.MaterialesCrearDto materiales) {

        Materiales matEnt = materialesMapper.materialesCrearDtoToMateriales(materiales);
        /*
         * matEnt.setActividadId(actividadService.getActividadById(materiales.
         * actividadId()));
         */
        matEnt.setEventoId(eventoService.getEventoById(materiales.eventoId()));
        matEnt.setMatriculaId(matriculaService.getMatriculaById(materiales.matriculaId()));

        System.out.println(materiales.fecha());
        System.out.println(materiales.horaReg());
        try {
            return materialesRepo.save(matEnt);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Materiales> findAll() {
        try {
            return materialesRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Materiales materialesx = materialesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materiales not exist with id :" + id));

        materialesRepo.delete(materialesx);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Materiales getMaterialesById(Long id) {
        Materiales findMateriales = materialesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materiales not exist with id :" + id));
        return findMateriales;
    }

    @Override
    public Materiales update(MaterialesDto.MaterialesCrearDto materiales, Long id) {
        Materiales materialesx = materialesRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        System.out.println("IMPRIME:" + materiales.modFh());
        materialesx.setFecha(materiales.fecha());
        materialesx.setHoraReg(materiales.horaReg());
        materialesx.setOfflinex(materiales.offlinex());
        return materialesRepo.save(materialesx);
    }

}
