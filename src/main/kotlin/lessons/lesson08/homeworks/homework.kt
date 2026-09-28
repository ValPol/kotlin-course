/**
 * 1. Преобразование строк
 * Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
 *
 * Правила проверки и преобразования:
 *
 * Если фраза содержит слово "невозможно":
 * Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
 * Если фраза начинается с "Я не уверен":
 * Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".
 * Если фраза содержит слово "катастрофа":
 * Преобразование: Замените "катастрофа" на "интересное событие".
 * Если фраза заканчивается на "без проблем":
 * Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
 * Если фраза содержит только одно слово:
 * Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".
 * Примеры Тестовых Фраз:
 *
 * "Это невозможно выполнить за один день"
 * "Я не уверен в успехе этого проекта"
 * "Произошла катастрофа на сервере"
 * "Этот код работает без проблем"
 * "Удача"
 */
fun transformPhrase(phrase: String): String {
    // Если только одно слово (после обрезки пробелов)
    val trimmed = phrase.trim()
    if (trimmed.isNotEmpty() && trimmed.split("\\s+".toRegex()).size == 1) {
        return "Иногда, $trimmed, но не всегда"
    }

    // Начинается с "Я не уверен"
    if (trimmed.startsWith("Я не уверен")) {
        return "$trimmed, но моя интуиция говорит об обратном"
    }

    // Содержит "катастрофа"
    if (trimmed.contains("катастрофа")) {
        return trimmed.replace("катастрофа", "интересное событие")
    }

    // Содержит "невозможно"
    if (trimmed.contains("невозможно")) {
        return trimmed.replace("невозможно", "совершенно точно возможно, просто требует времени")
    }

    // Заканчивается на "без проблем"
    if (trimmed.endsWith("без проблем")) {
        // Чтобы не затронуть лишнее, проверяем именно окончание
        return trimmed.dropLast("без проблем".length).trim().let { prefix ->
            if (prefix.isEmpty()) "с парой интересных вызовов на пути"
            else "$prefix с парой интересных вызовов на пути"
        }
    }

    return trimmed
}

/**
fun main() {
    println(transformPhrase("Это невозможно выполнить за один день"))
    println(transformPhrase("Я не уверен в успехе этого проекта"))
    println(transformPhrase("Произошла катастрофа на сервере"))
    println(transformPhrase("Этот код работает без проблем"))
    println(transformPhrase("Удача"))
}
*/

/**2. Извлечение даты из строки лога
У вас есть строка лога, например "Пользователь вошел в систему -> 2021-12-01 09:48:23" (данные могут быть любыми, но формат всегда такой). Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди. Используй indexOf или split для получения правой части сообщения.
 *
 */
fun extractDateTime(log: String) {
    val separator = " -> "
    val idx = log.indexOf(separator)
    if (idx == -1) {
        println("Формат не найден")
        return
    }
    val dateTimePart = log.substring(idx + separator.length).trim()

    val parts = dateTimePart.split(" ")
    if (parts.size >= 2) {
        val date = parts[0]
        val time = parts[1]
        println(date)
        println(time)
    } else {
        println("Не удалось извлечь дату и время")
    }
}
/**
fun main() {
    extractDateTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")
}
        */
/***
 * 3. Маскирование личных данных
 * Дана строка с номером кредитной карты, например "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".
 */

fun maskCardNumber(card: String): String {
    val digitsOnly = card.replace("\\s".toRegex(), "")
    if (digitsOnly.length < 4) return digitsOnly

    val lastFour = digitsOnly.substring(digitsOnly.length - 4)
    val masked = "*".repeat(digitsOnly.length - 4) + lastFour


    return masked.chunked(4).joinToString(" ")
}

/**
fun main() {
    println(maskCardNumber("4539 1488 0343 6467"))
}
*/

/**
 * 4. Форматирование адреса электронной почты.
 * У вас есть электронный адрес, например "username@example.com". Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace()
 */

fun formatEmail(email: String): String {
    return email
        .replace("@", " [at] ")
        .replace(".", " [dot] ")
}

/**
fun main() {
    println(formatEmail("username@example.com"))
}
 */

/**
 * 5. Извлечение имени файла из пути.
 * Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или "D:/good.themes/dracula.theme" (может быть любым). Извлеките название файла с расширением.
 */


fun getFileName(path: String): String {

    val normalized = path.replace("\\", "/")
    val lastSlashIndex = normalized.lastIndexOf('/')
    return if (lastSlashIndex != -1 && lastSlashIndex < normalized.length - 1) {
        normalized.substring(lastSlashIndex + 1)
    } else {
        normalized
    }
}

/**
fun main() {
    println(getFileName("C:/Пользователи/Документы/report.txt"))
    println(getFileName("D:/good.themes/dracula.theme"))
}
        */

/**
 * 6. Создание аббревиатуры из фразы.
 * У вас есть фраза, например "Котлин лучший язык программирования" (может быть любой с разделителями слов - пробел). Создайте аббревиатуру из начальных букв слов (например, "ООП").
 *
 * Используйте split. Используйте for для перебора слов. Используйте var переменную для накопления первых букв.
 */


fun createAcronym(phrase: String): String {
    val words = phrase.split("\\s+".toRegex())
    var acronym = ""
    for (word in words) {
        if (word.isNotEmpty()) {
            acronym += word[0].uppercase()
        }
    }
    return acronym
}

/**
fun main() {
    println(createAcronym("Котлин лучший язык программирования"))
}
        */