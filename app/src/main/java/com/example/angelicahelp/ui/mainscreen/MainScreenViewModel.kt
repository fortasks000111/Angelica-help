package com.example.angelicahelp.ui.mainscreen  // объявление пакета, в котором находится класс MainScreen

import androidx.lifecycle.ViewModel  // импорт класса ViewModel из библиотеки androidx.lifecycle
import java.lang.Math.PI  // импорт числа пи
import java.util.Random  // импорт библиотеки рандом
import kotlin.math.ln  // импорт натурального логарифма

// инициализация подкласса для класса ViewModel
class MainScreenViewModel : ViewModel() {
    var mean: Double? = null  // переменная для метаматического ожидания
    var variance: Double? = null  // переменная для дисперсии
    var randomNumber: Double? = null  // переменная для случайного значения

    private val random = Random()  // приватная переменная для генерации случайного числа

    // инициализация функции для получения числа из логнормального распредеделия
    fun getResult(): Double? {
        // если хоть одна из двух переменных не поменяла свое значение
        if (mean == null || variance == null)
            randomNumber = null  // оставляем число из логнормального распределения
        else if (mean!! > 0 && variance!! >= 0)  // в противном случае (когда обе переменные переопределены)
            // пользуемся формулой для нахождения значения нашего итогового числа
            randomNumber = generateLogNormal(mean!!, variance!!, 1.0)
        return randomNumber  // возвращаем число
    }

    // приватная функция для нахождения логнормального распределения
    private fun generateLogNormal(mu: Double, sigmaSquared: Double, multiplier: Double): Double {
        val modifiedSigmaSquared = sigmaSquared * multiplier  // переделываем структуру числа сигма
        val u1 = random.nextDouble()  // генерация случайных чисел из нормального распределения
        val u2 = random.nextDouble()
        val z = kotlin.math.sqrt(-2.0 * ln(u1)) * kotlin.math.cos(2.0 * PI * u2)  // на основе формулы определяем специальное число z
        return kotlin.math.exp(mu + kotlin.math.sqrt(modifiedSigmaSquared) * z)  // вычисляем экспоненту числа из нормального распределения при помощи формулы
    }

}
