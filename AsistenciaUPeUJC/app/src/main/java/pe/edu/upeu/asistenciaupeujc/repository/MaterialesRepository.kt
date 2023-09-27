package pe.edu.upeu.asistenciaupeujc.repository

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.data.local.dao.ActividadDao
import pe.edu.upeu.asistenciaupeujc.data.local.dao.MaterialesDao
import pe.edu.upeu.asistenciaupeujc.data.remote.RestActividad
import pe.edu.upeu.asistenciaupeujc.data.remote.RestMateriales
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materiales
import pe.edu.upeu.asistenciaupeujc.modelo.MaterialesReport
import pe.edu.upeu.asistenciaupeujc.utils.TokenUtils
import javax.inject.Inject

interface MaterialesRepository {

    suspend fun deleteMateriales(materiales: Materiales)
    fun reportarMaterialeses(): LiveData<List<Materiales>>

    fun buscarMaterialesId(id:Long): LiveData<Materiales>

    suspend fun insertarMateriales(materiales: Materiales):Boolean

    suspend fun modificarRemoteMateriales(materiales: Materiales):Boolean
}

class MaterialesRepositoryImp @Inject constructor(
    private val restMateriales: RestMateriales,
    private val materialesDao: MaterialesDao
): MaterialesRepository{
    override suspend fun deleteMateriales(materiales: Materiales){
        CoroutineScope(Dispatchers.IO).launch {
            restMateriales.deleteMateriales(TokenUtils.TOKEN_CONTENT,materiales.id)
        }
        materialesDao.eliminarMateriales(materiales)
    }


    override fun reportarMaterialeses(): LiveData<List<Materiales>> {
        try {
            CoroutineScope(Dispatchers.IO).launch{
                delay(3000)
                val data=restMateriales.reportarMateriales(TokenUtils.TOKEN_CONTENT).body()!!
                materialesDao.insertarMaterialeses(data)
            }

        }catch (e:Exception){
            Log.i("ERROR", "Error: ${e.message}")
        }
        return materialesDao.reportatMateriales()
    }

    override fun buscarMaterialesId(id:Long): LiveData<Materiales> {
        return  materialesDao.buscarMateriales(id)
    }


    override suspend fun insertarMateriales(materiales: Materiales):Boolean{
        //Log.i("DATAXXX", "${materiales.actividadId}")
        return restMateriales.insertarMateriales(TokenUtils.TOKEN_CONTENT, materiales).body()!=null
    }

    override suspend fun modificarRemoteMateriales(materiales: Materiales):Boolean{

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("VER", TokenUtils.TOKEN_CONTENT)
        }
        return restMateriales.actualizarMateriales(TokenUtils.TOKEN_CONTENT, materiales.id, materiales).body()!=null
    }
}