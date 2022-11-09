package com.example.usecasebysharedpref.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usecasebysharedpref.R
import com.example.usecasebysharedpref.data.repository.UserRepositoryImpl
import com.example.usecasebysharedpref.domain.model.NameParam
import com.example.usecasebysharedpref.domain.model.UserName
import com.example.usecasebysharedpref.domain.usecase.GetDataUserUseCase
import com.example.usecasebysharedpref.domain.usecase.SaveDataUserUseCase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//создаем все зависимости
//имплементируем метод из data для связи с Domain
val userRepository by lazy { UserRepositoryImpl(context = applicationContext) }
//подключаем два UseCase к данной Main_Activity
 val getDataUserUseCase by lazy { GetDataUserUseCase(userRepository) }
 val saveDataUserUseCase by lazy { SaveDataUserUseCase(userRepository) }
//В будущем можно изменить и не писать это с бибилотеками Hilt, Dagger, Koin



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveButton.setOnClickListener {
            var text = editWriteText.text.toString()
            val params = NameParam(text)
            val result: Boolean = saveDataUserUseCase.execute(params)
            showSaveData.text = "Save Data = $result"
        }
        getButton.setOnClickListener {
            var userName: UserName = getDataUserUseCase.execute()
            showSaveData.text = "${userName.firstName}, ${userName.lastName}"
        }




    }
}