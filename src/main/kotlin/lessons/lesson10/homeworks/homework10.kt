import java.time.LocalDate

fun main() {
    // 1. Пустой неизменяемый словарь, ключи и значения — целые числа
    val emptyImmutableMap: Map<Int, Int> = emptyMap()

    // 2. Словарь с несколькими парами, ключи — Float, значения — Double
    val floatDoubleMap = mapOf(
        1.5f to 1.5,
        2.7f to 3.14,
        3.0f to 9.81
    )

    // 3. Изменяемый словарь: ключи — Int, значения — String
    val mutableIntStringMap = mutableMapOf(
        1 to "один",
        2 to "два"
    )

    // 4. Добавить новые пары в изменяемый словарь
    mutableIntStringMap[3] = "три"
    mutableIntStringMap.put(4, "четыре")
    mutableIntStringMap += mapOf(5 to "пять", 6 to "шесть")

    // 5. Извлечь значение по ключу; попробовать получить значение по несуществующему ключу
    val value = mutableIntStringMap[3]
    val valueOrNull = mutableIntStringMap.get(99)
    val safeValue = mutableIntStringMap.getOrDefault(99, "не найдено")
    val orElse = mutableIntStringMap[99] ?: "не найдено"

    println("value: $value")
    println("valueOrNull: $valueOrNull")
    println("safeValue: $safeValue")
    println("orElse: $orElse")

    // 6. Удалить элемент по ключу
    mutableIntStringMap.remove(3)
    val removed = mutableIntStringMap.remove(4)
    println("removed: $removed")

    // 7. Словарь (ключи Double, значения Int), вывод деления ключа на значение с обработкой деления на 0
    val doubleIntMap = mutableMapOf(
        10.0 to 2,
        7.5 to 0,
        -3.0 to 3
    )

    for ((key, value) in doubleIntMap) {
        val result = if (value == 0) {
            "бесконечность"
        } else {
            key / value
        }
        println("$key / $value = $result")
    }

    // 8. Изменить значение для существующего ключа
    mutableIntStringMap[1] = "один (обновлено)"
    mutableIntStringMap.replace(2, "два (через replace)")

    // 9. Объединить два словаря в третий изменяемый через циклы
    val map1 = mapOf("a" to 1, "b" to 2)
    val map2 = mapOf("b" to 20, "c" to 3)

    val merged = mutableMapOf<String, Int>()
    for ((k, v) in map1) {
        merged[k] = v
    }
    for ((k, v) in map2) {
        merged[k] = v
    }
    println("merged: $merged")

    // 10. Словарь: ключи — String, значения — списки Int; добавить несколько элементов
    val stringListMap = mutableMapOf<String, MutableList<Int>>()
    stringListMap.computeIfAbsent("группа A") { mutableListOf() }.add(10)
    stringListMap.computeIfAbsent("группа A") { mutableListOf() }.addAll(listOf(20, 30))
    stringListMap.computeIfAbsent("группа B") { mutableListOf() }.add(5)
    println("stringListMap: $stringListMap")

    // 11. Словарь: ключи Int, значения — изменяемые множества строк; добавить строку в множество по ключу и распечатать
    val intSetMap = mutableMapOf<Int, MutableSet<String>>()
    intSetMap.computeIfAbsent(1) { mutableSetOf() }.add("яблоко")
    intSetMap.computeIfAbsent(1) { mutableSetOf() }.add("банан")

    val setFor1 = intSetMap[1]
    println("setFor1 before: $setFor1")
    setFor1?.add("вишня")
    println("setFor1 after: $setFor1")

    // 12. Словарь, ключи — пары чисел; найти значение, где пара содержит 5 как первое или второе число
    data class PairInt(val first: Int, val second: Int)

    val pairMap = mapOf(
        PairInt(1, 2) to "A",
        PairInt(5, 7) to "B",
        PairInt(3, 5) to "C",
        PairInt(8, 9) to "D"
    )

    val result = pairMap.entries
        .find { (key, _) -> key.first == 5 || key.second == 5 }
        ?.value
    println("result: $result")

    val allResults = pairMap.entries
        .filter { (key, _) -> key.first == 5 || key.second == 5 }
        .map { it.value }
    println("allResults: $allResults")

    // Словарь библиотека: Ключи - автор книги, значения - список книг
    val library: Map<String, List<String>> = mapOf(
        "Толстой" to listOf("Война и мир", "Анна Каренина"),
        "Достоевский" to listOf("Преступление и наказание")
    )
    println("library: $library")

    //Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plantsGuide: Map<String, List<String>> = mapOf(
        "Цветы" to listOf("роза", "тюльпан"),
        "Деревья" to listOf("дуб", "берёза")
    )
    println("plantsGuide: $plantsGuide")

    //Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val quarterfinals: Map<String, List<String>> = mapOf(
        "Команда А" to listOf("Иванов", "Петров", "Сидоров"),
        "Команда Б" to listOf("Кузнецов", "Смирнов")
    )
    println("quarterfinals: $quarterfinals")

//Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val treatmentCourse: Map<LocalDate, List<String>> = mapOf(
        LocalDate.of(2026, 10, 1) to listOf("Аспирин", "Витамин C"),
        LocalDate.of(2026, 10, 2) to listOf("Парацетамол")
    )
    println("treatmentCourse: $treatmentCourse")

    //Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val travelerDict: Map<String, Map<String, List<String>>> = mapOf(
        "Италия" to mapOf(
            "Рим" to listOf("Колизей", "Пантеон"),
            "Флоренция" to listOf("Галерея Уффици")
        ),
        "Франция" to mapOf(
            "Париж" to listOf("Эйфелева башня", "Лувр")
        )
    )
    println("travelerDict: $travelerDict")
}
