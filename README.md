Вашему вниманию представлена реализация проекта по домашней работе №1. Разработано Android приложение, которое генерирует случайное число, подчиняющееся логнормальному закону распределения.

Описание разработанного решения.
На главном и единственном экране размещено поле прокрутки и два поля (EditText) для ввода значений μ и σ². При нажатии на кнопку с @id/get_random_num в текстовом поле (TextView) с @id/random_number_result выводится строчное значение числа, которое было рассчитано по закону логнормального распределения для введенных μ и σ². При чем, когда строчки ввода пустые в них можно увидеть символы математического ожидания и дисперсии. Это необходимо для того, чтобы пользователь мог определить какие значение в какую строчку нужно вводить. Кроме того, согласно техническому заданию, реализовано сохранение данных при повороте экрана. Этого удалось достичь благодаря View моделям: при повороте экрана хотя и пересоздаются вью (сами экраны), но сами данные в View сохраняются, это можно пронаблюдать в MainScreen.kt. На самом экране используются TextWatcher-ы чтобы пред записанные данные при повороте экрана не стирались.

Тесты.
Прикреплен класс с двумя unit-тестами. Первый проверяет корректность работы формулы. Поскольку для самой программы и для теста при генерации числа из нормального распределения генерируются совершенно случайные числа, в тесте предусмотрена вероятность расхождения двух конечных чисел. Именно из-за этой проблемы иногда тест не проходит, однако эту проблему можно устранить, увеличив дельту эксцессов. Во всяком случае, прикреплен скрин, который доказывает, что тест проходит корректно. Второй тест предназначен для проверки непустоты поля (TextView), в которое выводится конечное число.

Ветки и автосборка.
Согласно техническому заданию, был использован detect с кастомной конфигурацией. Помимо этого, создан репозиторий "Angelica-help". Как и указано, разработка велась в ветке develop после чего, она была совмещена с master веткой. Для автоматической сборки и тестирования кода был написан файл main.yml. Был создан README.md файл с кратким описанием проекта и скринами работы приложения. А также был создан релиз с apk и App Bundle файлом.

![Screenshot_1](https://github.com/fortasks000111/Angelica-help/assets/167869575/71509ef2-1f16-4ab5-9a2f-4206304c1869)


![Screenshot_2](https://github.com/fortasks000111/Angelica-help/assets/167869575/4e11f3b0-bb4d-48d2-940c-286813647e93)

![Screenshot_3](https://github.com/fortasks000111/Angelica-help/assets/167869575/b99d626e-2aa6-44f2-8665-eb055da36603)

![Screenshot_4](https://github.com/fortasks000111/Angelica-help/assets/167869575/3ae37303-8da3-48c5-b793-47c660d88eeb)
