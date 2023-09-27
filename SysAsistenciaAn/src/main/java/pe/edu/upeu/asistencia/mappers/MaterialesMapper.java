package pe.edu.upeu.asistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.asistencia.dtos.MaterialesDto;
import pe.edu.upeu.asistencia.models.Materiales;

@Mapper(componentModel = "spring")
public interface MaterialesMapper {

    // Convierte una entidad Materiales a MaterialesDto
    MaterialesDto toMaterialesDto(Materiales entidad);

    // Convierte un DTO de creación de materiales a Materiales
    @Mapping(target = "eventoId", ignore = true)
    @Mapping(target = "matriculaId", ignore = true)
    Materiales materialesCrearDtoToMateriales(MaterialesDto.MaterialesCrearDto entidadCrearDto);
}
