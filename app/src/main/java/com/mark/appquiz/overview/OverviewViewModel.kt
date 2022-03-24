package com.mark.appquiz.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.appquiz.data.OverviewData
import com.mark.appquiz.network.Api
import com.mark.appquiz.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.ArrayList

class OverviewViewModel: ViewModel() {
    private val _overviewData = MutableLiveData<List<OverviewData>>()

    val overviewData: LiveData<List<OverviewData>>
        get() = _overviewData

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        Log.d("OverviewViewModel", "init")
        getOverviewData()
    }

    private fun getOverviewData() {
        coroutineScope.launch {
            try {
                _overviewData.value = Api.retrofitService.getOverviewData()
            } catch (e: Exception) {
                _overviewData.value = ArrayList()
                Log.e("OverviewViewModel", "$e")
            }
        }
    }


}