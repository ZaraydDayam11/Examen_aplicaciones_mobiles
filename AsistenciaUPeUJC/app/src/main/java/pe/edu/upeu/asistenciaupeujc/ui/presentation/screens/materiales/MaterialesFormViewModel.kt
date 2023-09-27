package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.materiales

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materiales
import pe.edu.upeu.asistenciaupeujc.modelo.MaterialesReport
import pe.edu.upeu.asistenciaupeujc.repository.ActividadRepository
import pe.edu.upeu.asistenciaupeujc.repository.MaterialesRepository
import javax.inject.Inject

@HiltViewModel
class MaterialesFormViewModel @Inject constructor(
    private val materRepo: MaterialesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    fun getMateriales(idX: Long): LiveData<Materiales> {
        return materRepo.buscarMaterialesId(idX)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading


    fun addMateriales(materiales: Materiales){
        viewModelScope.launch (Dispatchers.IO){
            try {
                materRepo.insertarMateriales(materiales)
            }catch (e:Exception){
                Log.i("ERRRRR", "${e.message}")
            }
        }
    }
    fun editMateriales(materiales: Materiales){
        viewModelScope.launch(Dispatchers.IO){
            try {
                materRepo.modificarRemoteMateriales(materiales)
            }catch (e:Exception){
                Log.i("ERRRRREDI", "${e.message}")
            }
        }
    }
}