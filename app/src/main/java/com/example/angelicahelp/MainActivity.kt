package com.example.angelicahelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.angelicahelp.ui.mainscreen.MainScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainScreen())
                .commitNow()
        }
    }
}