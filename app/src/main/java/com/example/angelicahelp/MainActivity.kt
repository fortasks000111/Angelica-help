package com.example.angelicahelp  // объявление пакета кода, в котором хранится ui-тест

import androidx.appcompat.app.AppCompatActivity  // импрот класса AppCompatActivity
import android.os.Bundle  // импорт класса Bundle
import com.example.angelicahelp.ui.mainscreen.MainScreen  // импорт класса MainScreen из пакета ui.mainscreen

// объявление класса MainActivity, который наследует AppCompatActivity
class MainActivity : AppCompatActivity() {
    // переопределяем функцию onCreate, который принимает параметр savedInstanceState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // вызываем метод onCreate из родительского класса и передаем ему параметр savedInstanceState
        setContentView(R.layout.activity_main_screen)  // указываем основной макет активного экрана
        // проверяем: был ли savedInstanceState передан при создании активности
        if (savedInstanceState == null) {
            // заменяем R.id.container на MainScreen
            supportFragmentManager.beginTransaction().replace(R.id.container, MainScreen()).commitNow()
        }
    }
}
