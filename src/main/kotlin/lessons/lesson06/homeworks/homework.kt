package lessons.lesson06.homeworks

fun main() {
    // Задание 1: Определение сезона
    determineSeason(1)
    determineSeason(4)
    determineSeason(7)
    determineSeason(10)
    determineSeason(13)   // невалидный
    determineSeason(0)    // невалидный

    println()

    // Задание 2: Расчёт возраста питомца
    calculateDogAge(0)
    calculateDogAge(1)
    calculateDogAge(2)
    calculateDogAge(5)
    calculateDogAge(-1)   // невалидный

    println()

    // Задание 3: Определение способа перемещения
    determineTransport(0)
    determineTransport(1)
    determineTransport(3)
    determineTransport(5)
    determineTransport(10)
    determineTransport(-1)  // невалидный

    println()

    // Задание 4: Расчёт бонусных баллов
    calculateBonusPoints(500)
    calculateBonusPoints(1000)
    calculateBonusPoints(1500)
    calculateBonusPoints(0)
    calculateBonusPoints(-100)  // невалидный

    println()

    // Задание 5: Определение типа документа
    determineDocumentType("txt")
    determineDocumentType("jpg")
    determineDocumentType("xls")
    determineDocumentType("pdf")
    determineDocumentType("")      // невалидный
    determineDocumentType("   ")   // невалидный

    println()

    // Задание 6: Конвертация температуры
    convertTemperature(25.0, 'C')
    convertTemperature(77.0, 'F')
    convertTemperature(0.0, 'C')
    convertTemperature(32.0, 'F')
    convertTemperature(100.0, 'X')  // невалидный

    println()

    // Задание 7: Подбор одежды по погоде
    recommendClothing(-35)
    recommendClothing(-10)
    recommendClothing(5)
    recommendClothing(15)
    recommendClothing(20)
    recommendClothing(40)

    println()

    // Задание 8: Выбор фильма по возрасту
    selectMovieCategory(5)
    selectMovieCategory(9)
    selectMovieCategory(10)
    selectMovieCategory(18)
    selectMovieCategory(25)
    selectMovieCategory(-3)  // невалидный
}

// ===================== Задание 1 =====================
fun determineSeason(monthNumber: Int) {
    if (monthNumber < 1 || monthNumber > 12) {
        println("Ошибка: номер месяца должен быть от 1 до 12 (получено $monthNumber)")
        return
    }
    val season = when (monthNumber) {
        12, 1, 2 -> "Зима"
        3, 4, 5 -> "Весна"
        6, 7, 8 -> "Лето"
        9, 10, 11 -> "Осень"
        else -> "Неизвестно"
    }
    println("Месяц $monthNumber — $season")
}

// ===================== Задание 2 =====================
fun calculateDogAge(dogAge: Int) {
    if (dogAge < 0) {
        println("Ошибка: возраст не может быть отрицательным (получено $dogAge)")
        return
    }
    val humanAge = if (dogAge <= 2) {
        dogAge * 10.5
    } else {
        2 * 10.5 + (dogAge - 2) * 4
    }
    println("Возраст собаки $dogAge год(а) = ${humanAge} человеческих лет")
}

// ===================== Задание 3 =====================
fun determineTransport(distanceKm: Int) {
    if (distanceKm < 0) {
        println("Ошибка: расстояние не может быть отрицательным (получено $distanceKm)")
        return
    }
    val transport = when {
        distanceKm <= 1 -> "пешком"
        distanceKm <= 5 -> "велосипед"
        else -> "автотранспорт"
    }
    println("Расстояние $distanceKm км — recommended: $transport")
}

// ===================== Задание 4 =====================
fun calculateBonusPoints(purchaseAmount: Int) {
    if (purchaseAmount < 0) {
        println("Ошибка: сумма покупки не может быть отрицательной (получено $purchaseAmount)")
        return
    }
    val bonusPoints = if (purchaseAmount <= 1000) {
        (purchaseAmount / 100) * 2
    } else {
        (purchaseAmount / 100) * 3
    }
    println("Сумма покупки $purchaseAmount руб. — $bonusPoints бонусных баллов")
}

// ===================== Задание 5 =====================
fun determineDocumentType(extension: String) {
    val trimmed = extension.trim()
    if (trimmed.isEmpty()) {
        println("Ошибка: расширение не указано")
        return
    }
    val docType = when (trimmed.lowercase()) {
        "txt", "doc", "docx", "pdf", "rtf" -> "Текстовый документ"
        "jpg", "jpeg", "png", "gif", "bmp" -> "Изображение"
        "xls", "xlsx", "csv", "ods" -> "Таблица"
        else -> "Неизвестный тип"
    }
    println("Расширение .$trimmed — $docType")
}

// ===================== Задание 6 =====================
fun convertTemperature(temp: Double, unit: Char) {
    when (unit.uppercaseChar()) {
        'C' -> {
            val result = temp * 9 / 5 + 32
            print("Конвертация: $temp°C = $result")
            println("F")
        }
        'F' -> {
            val result = (temp - 32) * 5 / 9
            print("Конвертация: $temp°F = $result")
            println("C")
        }
        else -> {
            println("Ошибка: неизвестная единица измерения '$unit'. Используйте 'C' или 'F'.")
        }
    }
}

// ===================== Задание 7 =====================
fun recommendClothing(temperature: Int) {
    if (temperature < -30 || temperature > 35) {
        println("Температура $temperature°C — лучше не выходить из дома")
        return
    }
    val clothing = when {
        temperature < 10 -> "куртка и шапка"
        temperature <= 18 -> "ветровка"
        else -> "футболка и шорты"
    }
    println("Температура $temperature°C — recommended: $clothing")
}

// ===================== Задание 8 =====================
fun selectMovieCategory(age: Int) {
    if (age < 0) {
        println("Ошибка: возраст не может быть отрицательным (получено $age)")
        return
    }
    val category = when (age) {
        in 0..9 -> "детские"
        in 10..18 -> "подростковые"
        else -> "18+"
    }
    println("Возраст $age — доступные категории фильмов: $category")
}