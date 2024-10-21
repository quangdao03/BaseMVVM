package com.example.basemvvm.ui.main.viewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.basemvvm.base.BaseViewModel
import com.example.basemvvm.data.retrofit.ApiService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val api: ApiService) : BaseViewModel() {
    val backgroundList = MutableLiveData<List<String>>()

    private val errorHandler = CoroutineExceptionHandler() { _, _ ->}

    fun getBackground() {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            val listBg = api.getBackground()
            val data = listBg.flatMap {
                it.data?.map { item -> item.image ?: "" } ?: listOf()
            }.toMutableList()
            data.removeIf { it.isBlank() }
            backgroundList.postValue(data.toList())
        }
    }
}