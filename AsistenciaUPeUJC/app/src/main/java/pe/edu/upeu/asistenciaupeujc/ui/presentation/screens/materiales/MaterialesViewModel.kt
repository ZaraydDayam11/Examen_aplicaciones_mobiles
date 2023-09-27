package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.materiales

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materiales

import pe.edu.upeu.asistenciaupeujc.repository.ActividadRepository
import pe.edu.upeu.asistenciaupeujc.repository.MaterialesRepository
import javax.inject.Inject

@HiltViewModel
class MaterialesViewModel @Inject constructor(
    private val matexRepo: MaterialesRepository,
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val activ: LiveData<List<Materiales>> by lazy {
        matexRepo.reportarMaterialeses()
    }
    val isLoading: LiveData<Boolean> get() = _isLoading
    fun addMateriales() {
        if (_isLoading.value == false)
            viewModelScope.launch (Dispatchers.IO) {
                _isLoading.postValue(true)
            }
    }

    fun deleteMateriales(toDelete: Materiales) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("ELIMAR", toDelete.toString())
            matexRepo.deleteMateriales(toDelete);
        }
    }

}