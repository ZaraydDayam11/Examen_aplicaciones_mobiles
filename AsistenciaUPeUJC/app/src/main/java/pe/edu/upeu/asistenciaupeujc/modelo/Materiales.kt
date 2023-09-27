package pe.edu.upeu.asistenciaupeujc.modelo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey

import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "materiales"
   /* ,
    foreignKeys = [
        ForeignKey(
            entity = Evento::class,
            parentColumns = ["id"],
            childColumns = ["eventoId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Matricula::class,
            parentColumns = ["id"],
            childColumns = ["matriculaId"],
            onDelete = ForeignKey.CASCADE
        )
    ]*/
)
data class Materiales(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    var materEntre: String,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var modFh: String,
    var offlinex: String,

)

/*data class MaterialesConEventoyMatricula(
    var id: Long,

    var materEntre: String,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var modFh: String,
    var offlinex: String,
    var eventoId: Long,
    var matriculaId: Long,
    var nombreEvento: String,
    var estado: String
)
*/
data class MaterialesReport(
    var id: Long,
    var materEntre: String,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var modFh: String,
    var offlinex: String,

)
