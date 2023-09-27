package pe.edu.upeu.asistenciaupeujc.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matricula")

data class Matricula(

    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var estado: String,
    var eventoId: String,
    var periodoId: String,
    var personaId: String,
    var materialeses: String,

)