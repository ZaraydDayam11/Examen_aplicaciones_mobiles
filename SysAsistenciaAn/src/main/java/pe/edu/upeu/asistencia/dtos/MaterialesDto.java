package pe.edu.upeu.asistencia.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.asistencia.models.Actividad;
import pe.edu.upeu.asistencia.models.Evento;
import pe.edu.upeu.asistencia.models.Matricula;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialesDto {
    private Long id;

    private String materEntre;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime horaReg;
    private String latituda;
    private String longituda;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modFh;
    private String offlinex;

    @JsonIgnoreProperties({ "subactasises", "materialeses", "asistencias" })
    private Evento eventoId;

    @JsonIgnoreProperties({ "subactasises", "materialeses", "asistencias" })
    private Matricula matriculaId;

    public record MaterialesCrearDto(Long id, String materEntre, LocalDate fecha,
            LocalTime horaReg, String latituda, String longituda, LocalDate modFh, String offlinex, Long eventoId,
            Long matriculaId) {
    }
}
