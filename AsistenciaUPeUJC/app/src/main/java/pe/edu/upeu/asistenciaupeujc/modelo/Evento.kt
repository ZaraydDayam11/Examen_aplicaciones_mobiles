package pe.edu.upeu.asistenciaupeujc.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "evento")
data class Evento(

    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var nombreEvento: String,
    var fecha: String,
    var horai: String,
    var minToler: String,
    var latitud: String,
    var longitud: String,
    var estado: String,
    var evaluar: String,
    var perfilEvento: String,
    var userCreate: String,
    var mater: String,
    var validInsc: String,
    var asisSubact: String,
    var entsal: String,
    var periodoId: String,
    var subactasises: String,
    var materialeses: String,
    var asistencias: String,
    )


