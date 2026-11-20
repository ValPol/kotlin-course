/**
 * Задача 1
 *
 * Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
 *
 * Для строки: "Это строка: [значение]".
 * Для любого числа: "Это число: [значение]".
 * Для списка: "Это список, количество элементов: [количество]".
 * Для словаря: "Это словарь, количество пар: [количество]".
 * Для остальных типов: "Неизвестный тип данных".
 * Используйте оператор is для проверки типов.
 *
 * Задача 2
 *
 * Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1. Используйте as? для безопасного приведения типа.
 *
 * Задача 3
 *
 * Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
 *
 * Задача 4
 *
 * Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа. Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.
 *
 * Задача 5
 *
 * Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
 *
 * Задача 6
 *
 * Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>. Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.
 */
fun analyzeDataType(value: Any) {
    when (value) {
        is String -> println("Это строка: $value")
        is Int, is Double, is Float, is Long, is Short, is Byte -> println("Это число: $value")
        is List<*> -> println("Это список, количество элементов: ${value.size}")
        is Map<*, *> -> println("Это словарь, количество пар: ${value.size}")
        else -> println("Неизвестный тип данных")
    }
}

fun safeCastToList(value: Any): Int =
    (value as? List<*>)?.size ?: -1

fun getStringLengthOrZero(value: Any?): Int =
    (value as? String)?.length ?: 0

fun Any.toSquare(): Double {
    val n = (this as? Number)?.toDouble() ?: this.toString().toDouble()
    return n * n
}

fun sumIntOrDoubleValues(items: List<Any>): Double =
    items.sumOf { item ->
        when (item) {
            is Int -> item.toDouble()
            is Double -> item
            else -> 0.0
        }
    }

fun tryCastToListAndPrint(value: Any) {
    val list = value as? List<*>
    if (list == null) {
        println("Ошибка: аргумент не является списком")
        return
    }
    for (item in list) {
        if (item is String) {
            println(item)
        } else {
            val typeName = item?.let { it::class.simpleName } ?: "null"
            println("Предупреждение: элемент '$item' не является строкой ($typeName)")
        }
    }
}

fun main() {
    println("=== Задача 1: analyzeDataType ===")
    analyzeDataType("Привет")                 // Это строка: Привет
    analyzeDataType(42)                       // Это число: 42
    analyzeDataType(3.14)                     // Это число: 3.14
    analyzeDataType(listOf(1, 2, 3))          // Это список, количество элементов: 3
    analyzeDataType(mapOf("a" to 1, "b" to 2))// Это словарь, количество пар: 2
    analyzeDataType(true)                     // Неизвестный тип данных

    println("\n=== Задача 2: safeCastToList ===")
    println(safeCastToList(listOf("a", "b"))) // 2
    println(safeCastToList("не список"))      // -1
    println(safeCastToList(emptyList<Int>())) // 0

    println("\n=== Задача 3: getStringLengthOrZero ===")
    println(getStringLengthOrZero("Кот"))     // 3
    println(getStringLengthOrZero(null))      // 0
    println(getStringLengthOrZero(123))       // 0

    println("\n=== Задача 4: toSquare (функция-расширение) ===")
    println(4.toSquare())                     // 16.0
    println(2.5.toSquare())                   // 6.25
    println("3".toSquare())                   // 9.0
    println("4.2".toSquare())                 // 17.64

    println("\n=== Задача 5: sumIntOrDoubleValues ===")
    val mixedList = listOf<Any>(1, 2.5, "текст", 3,  4.5)
    println(sumIntOrDoubleValues(mixedList))  // 11.0 (1 + 2.5 + 3 + 4.5)

    println("\n=== Задача 6: tryCastToListAndPrint ===")
    tryCastToListAndPrint(listOf("яблоко", 10, "груша", true))
    // яблоко
    // Предупреждение: элемент '10' не является строкой (Integer)
    // груша
    // Предупреждение: элемент 'true' не является строкой (Boolean)

    tryCastToListAndPrint("просто строка")
    // Ошибка: аргумент не является списком
}
