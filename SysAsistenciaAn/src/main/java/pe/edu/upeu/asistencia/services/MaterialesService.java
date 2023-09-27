package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.asistencia.dtos.MaterialesDto;
import pe.edu.upeu.asistencia.models.Materiales;

/**
 *
 * @author DELL
 */
public interface MaterialesService {
    Materiales save(MaterialesDto.MaterialesCrearDto materiales);

    List<Materiales> findAll();

    Map<String, Boolean> delete(Long id);

    Materiales getMaterialesById(Long id);

    Materiales update(MaterialesDto.MaterialesCrearDto materiales, Long id);
}
