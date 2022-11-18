package com.example.usecasebysharedpref.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usecasebysharedpref.data.repository.UserRepositoryImpl
import com.example.usecasebysharedpref.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasebysharedpref.domain.model.NameParam
import com.example.usecasebysharedpref.domain.model.UserName
import com.example.usecasebysharedpref.domain.usecase.GetDataUserUseCase
import com.example.usecasebysharedpref.domain.usecase.SaveDataUserUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainViewModel(private val getDataUserUseCase: GetDataUserUseCase, private val saveDataUserUseCase: SaveDataUserUseCase): ViewModel() {
    var resultLeve = MutableLiveData<String>()//переменная которая хранит последние результаты

    init{
        Log.e("VM","VM creayed")
    }

    override fun onCleared() {
        Log.e("VM","VM cleared")
        super.onCleared()//этот метод вызывается, когда связанная с ней активити уничтожается
    }

    fun save(text: String){
        val params = NameParam(text)
        val resultData: Boolean = saveDataUserUseCase.execute(params)
        resultLeve.value = "Save Data = $resultData"
    }

    fun load(){
        var userName: UserName = getDataUserUseCase.execute()
        resultLeve.value = "${userName.firstName}, ${userName.lastName}"
    }








}