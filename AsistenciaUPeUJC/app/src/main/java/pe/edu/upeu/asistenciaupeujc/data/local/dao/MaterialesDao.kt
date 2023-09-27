package pe.edu.upeu.asistenciaupeujc.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import androidx.room.Update
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materiales

@Dao
interface MaterialesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMateriales(materiales: Materiales)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMaterialeses(materiales: List<Materiales>)

    @Update
    suspend fun modificarMateriales(materiales: Materiales)

   /* @Query("delete  from materiales where id=:materiales")
    suspend fun eliminarMateriales(materiales: Long)*/
    @Delete
    suspend fun eliminarMateriales(materiales: Materiales)
    @Query("select * from materiales")
    fun reportatActividad():LiveData<List<Materiales>>

    @Query("select * from materiales")
    fun reportatMateriales():LiveData<List<Materiales>>

    @Query("select * from materiales where id=:idx")
    fun buscarMateriales(idx: Long): LiveData<Materiales>
}