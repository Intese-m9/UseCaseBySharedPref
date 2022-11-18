package com.example.usecasebysharedpref.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usecasebysharedpref.data.repository.UserRepositoryImpl
import com.example.usecasebysharedpref.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasebysharedpref.domain.usecase.GetDataUserUseCase
import com.example.usecasebysharedpref.domain.usecase.SaveDataUserUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {
//создаем use case
    //создаем все зависимости
//имплементируем метод из data для связи с Domain
//В будущем можно изменить и не писать это с бибилотеками Hilt, Dagger, Koin
       private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
//подключаем два UseCase к данной Main_Activity
       private val getDataUserUseCase by lazy { GetDataUserUseCase(userRepository) }
       private val saveDataUserUseCase by lazy { SaveDataUserUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //создаем нашу ViewModel
        return MainViewModel(
            getDataUserUseCase=getDataUserUseCase,
            saveDataUserUseCase=saveDataUserUseCase) as T//передаем UseCase

    }
}