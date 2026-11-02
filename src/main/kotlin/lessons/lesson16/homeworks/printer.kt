abstract class Printer {
    abstract fun print(text: String)
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        val words = text.split(" ")
        words.forEach { word ->
            // Чёрный текст на белом фоне
            println("\u001B[30;47m$word\u001B[0m")
        }
    }
}

class InkjetPrinter : Printer() {
    // Пары: (цвет текста, цвет фона)
    private val colorPairs = listOf(
        "\u001B[31;44m", // красный текст, синий фон
        "\u001B[32;45m", // зелёный текст, фиолетовый фон
        "\u001B[33;46m", // жёлтый текст, бирюзовый фон
        "\u001B[34;42m", // синий текст, зелёный фон
        "\u001B[35;43m"  // фиолетовый текст, жёлтый фон
    )

    override fun print(text: String) {
        val words = text.split(" ").filter { it.isNotEmpty() }
        words.forEachIndexed { index, word ->
            val pair = colorPairs[index % colorPairs.size]
            println("$pair$word\u001B[0m") // сброс стиля
        }
    }
}

fun main() {
    val laser = LaserPrinter()
    val inkjet = InkjetPrinter()

    val longText = "Это длинный текст для проверки работы струйного и лазерного принтера в разных режимах печати."

    println("--- Лазерный принтер ---")
    laser.print(longText)

    println("\n--- Струйный принтер ---")
    inkjet.print(longText)
}
