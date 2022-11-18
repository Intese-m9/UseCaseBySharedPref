package com.example.usecasebysharedpref.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.usecasebysharedpref.R
import com.example.usecasebysharedpref.data.repository.UserRepositoryImpl
import com.example.usecasebysharedpref.data.storage.UserStorage
import com.example.usecasebysharedpref.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.usecasebysharedpref.domain.model.NameParam
import com.example.usecasebysharedpref.domain.model.UserName
import com.example.usecasebysharedpref.domain.usecase.GetDataUserUseCase
import com.example.usecasebysharedpref.domain.usecase.SaveDataUserUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var vm: MainViewModel//инициализация ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("VM","Activity crated")
        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)//создание Вью Модели + добавление фабрики MainViewModelFactory
        setContentView(R.layout.activity_main)

        vm.resultLeve.observe(this) {
            showSaveData.text = it // подписка на изменение данных. Если параметры переменной поменяются вызывается данный кусок кода
        }

        saveButton.setOnClickListener {
            var text = editWriteText.text.toString()
             vm.save(text)
        }
        getButton.setOnClickListener {
             vm.load()
        }
    }
}