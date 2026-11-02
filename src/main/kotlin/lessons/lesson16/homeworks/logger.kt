package lessons.lesson16.homeworks

import ShoppingCart


enum class LogLevel { INFO, WARNING, ERROR, DEBUG }

class Logger {
    fun log(message: String) {
        log(LogLevel.INFO, message)
    }

    fun log(level: LogLevel, message: String) {
        when (level) {
            LogLevel.WARNING -> println("\u001B[33m[WARNING] $message\u001B[0m")      // жёлтый
            LogLevel.ERROR   -> println("\u001B[37;41m[ERROR] $message\u001B[0m")     // белый на красном
            else             -> println("[${level.name}] $message")
        }
    }

    fun log(messages: List<String>) {
        messages.forEach { log(it) }
    }

    fun log(ex: Exception) {
        log(LogLevel.ERROR, ex.message ?: "Неизвестная ошибка")
    }
}

fun main() {
    println("=== Тестирование корзины ===")
    val cart = ShoppingCart()
    cart.addToCart("A001")                 // +1
    cart.addToCart("A002", 3)              // +3
    cart.addToCart(mapOf("A001" to 2, "A003" to 5)) // A001 +2, A003 +5
    cart.addToCart(listOf("A004", "A004")) // +1, +1

    println(cart)

    println("\n=== Тестирование логгера ===")
    val logger = Logger()
    logger.log("Простое сообщение (INFO по умолчанию)")
    logger.log(LogLevel.WARNING, "Предупреждение о низком запасе")
    logger.log(LogLevel.ERROR, "Критическая ошибка соединения")
    logger.log(listOf("Сообщение 1", "Сообщение 2", "Сообщение 3"))

    try {
        throw Exception("Ошибка валидации данных")
    } catch (e: Exception) {
        logger.log(e)
    }
}