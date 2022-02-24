package com.kalamou.jcdecauxtest.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalamou.jcdecauxtest.api.JCDecauxApi
import com.kalamou.jcdecauxtest.model.StationsItem
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {


    private val _stations = MutableLiveData<List<StationsItem>>()
    val stations: LiveData<List<StationsItem>> = _stations

    fun getStations(lat: Double, lng: Double): LiveData<List<StationsItem>> {
        viewModelScope.launch {
            try {
                val response = JCDecauxApi.retrofitService.getStations(lat, lng)
                _stations.value = response.body()
            } catch (e: Exception) {
                Log.d("OverviewViewModel", "getStations: $e")
            }
        }
        return stations
    }
}