package cz.movapp.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _fromUa = MutableLiveData(true)

    val fromUa: LiveData<Boolean>
        get() = _fromUa

    fun setFromUa(fromUa: Boolean) {
        _fromUa.value = fromUa
    }
}