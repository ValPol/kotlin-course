/**
Задачи на приведение коллекции к значению
Проверить, что размер коллекции больше 5 элементов.
Проверить, что коллекция пустая
Проверить, что коллекция не пустая
Взять элемент по индексу или создать значение если индекса не существует
Собрать коллекцию в строку
Посчитать сумму всех значений
Посчитать среднее
Взять максимальное число
Взять минимальное число
Взять первое число или null
Проверить что коллекция содержит элемент
 */
fun checkSizeGreaterThanFive(collection: Collection<Int>): Boolean = collection.size > 5

fun checkEmpty(collection: Collection<*>): Boolean = collection.isEmpty()

fun checkNotEmpty(collection: Collection<*>): Boolean = collection.isNotEmpty()

// Взять элемент по индексу или создать значение, если индекса не существует
fun getOrElseExample(list: List<Int>, index: Int, defaultValue: Int): Int = list.getOrElse(index) { defaultValue }

// Собрать коллекцию в строку
fun joinToStringExample(collection: Collection<String>): String = collection.joinToString(separator = ", ")

// Посчитать сумму всех значений
fun sumExample(collection: Collection<Int>): Int = collection.sum()

// Посчитать среднее
fun averageExample(collection: Collection<Int>): Double = collection.average()

// Взять максимальное число
fun maxExample(collection: Collection<Int>): Int? = collection.maxOrNull()

// Взять минимальное число
fun minExample(collection: Collection<Int>): Int? = collection.minOrNull()

// Взять первое число или null
fun firstOrNullExample(collection: Collection<Int>): Int? = collection.firstOrNull()

// Проверить, что коллекция содержит элемент
fun containsExample(collection: Collection<Int>, element: Int): Boolean = collection.contains(element)
/**
 * Задачи на обработку коллекций
 * Отфильтровать коллекцию по диапазону 18-30
 * Выбрать числа, которые не делятся на 2 и 3 одновременно
 * Очистить текстовую коллекцию от null элементов
 * Преобразовать текстовую коллекцию в коллекцию длин слов
 * Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
 * Отсортировать список в алфавитном порядке
 * Взять первые 3 элемента списка
 * Распечатать квадраты элементов списка
 * Группировать список по первой букве слов
 * Очистить список от дублей
 * Отсортировать список по убыванию
 * Взять последние 3 элемента списка
 */
// Отфильтровать коллекцию по диапазону 18–30
fun filterRange18To30(numbers: Collection<Int>) = numbers.filter { it in 18..30 }

// Выбрать числа, которые не делятся на 2 и 3 одновременно
fun notDivisibleBy2And3(numbers: Collection<Int>) =
    numbers.filter { !(it % 2 == 0 && it % 3 == 0) }

// Очистить текстовую коллекцию от null элементов
fun filterNotNullStrings(list: List<String?>): List<String> = list.filterNotNull()

// Преобразовать текстовую коллекцию в коллекцию длин слов
fun mapToLengths(words: Collection<String>) = words.map { it.length }

// Преобразовать текстовую коллекцию в мапу: ключи — перевёрнутые слова, значения — длина слов
fun associateReversedWithLength(words: Collection<String>) =
    words.associate { word -> word.reversed() to word.length }

// Отсортировать список в алфавитном порядке
fun sortAlphabetically(words: List<String>) = words.sorted()

// Взять первые 3 элемента списка
fun takeFirstThree(list: List<Any>) = list.take(3)

// Распечатать квадраты элементов списка (через forEach)
fun printSquares(numbers: List<Int>) {
    numbers.forEach { println(it * it) }
}

// Группировать список по первой букве слов
fun groupByFirstLetter(words: List<String>) =
    words.groupBy { it.first().lowercase() }

// Очистить список от дублей
fun distinctList(list: List<Any>) = list.distinct()

// Отсортировать список по убыванию
fun sortDescending(numbers: List<Int>) = numbers.sortedDescending()

// Взять последние 3 элемента списка
fun takeLastThree(list: List<Any>) = list.takeLast(3)

/**
 * Задача 24. Характеристика числовой коллекции
 * Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции используя конструкцию when
 *
 * Если коллекция пустая - “Пусто”
 * Если количество элементов меньше пяти - “Короткая”
 * Если коллекция начинается с 0 - “Стартовая”
 * Если сумма всех чисел больше 10000 - “Массивная”
 * Если среднее значение равно 10 - “Сбалансированная”
 * Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
 * Если максимальное число меньше -10 - “Отрицательная”
 * Если минимальное число больше 1000 - “Положительная”
 * Если содержит одновременно числа 3 и 14 - “Пи***тая”
 * Иначе - “Уникальная”
 * Вызвать метод с данными, подходящими под каждую из веток
 */
fun describeCollection(numbers: Collection<Int>): String {
    val size = numbers.size
    val sum = numbers.sum()
    val avg = if (numbers.isNotEmpty()) numbers.average() else 0.0
    val max = numbers.maxOrNull() ?: Int.MIN_VALUE
    val min = numbers.minOrNull() ?: Int.MAX_VALUE
    val joined = numbers.joinToString("")

    return when {
        numbers.isEmpty() -> "Пусто"
        size < 5 -> "Короткая"
        numbers.firstOrNull() == 0 -> "Стартовая"
        sum > 10000 -> "Массивная"
        avg == 10.0 -> "Сбалансированная"
        joined.length == 20 -> "Клейкая"
        max < -10 -> "Отрицательная"
        min > 1000 -> "Положительная"
        numbers.contains(3) && numbers.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}


fun testDescribeCollection() {
    println(describeCollection(emptyList()))                          // Пусто
    println(describeCollection(listOf(1, 2, 3)))                      // Короткая
    println(describeCollection(listOf(0, 1, 2, 3, 4)))                 // Стартовая
    println(describeCollection(List(2000) { 6 }))                    // Массивная (сумма > 10000)
    println(describeCollection(listOf(10, 10, 10)))                   // Сбалансированная (среднее = 10)
    println(describeCollection(listOf(34553453, 535345, 54334534, 876543210)))      // Клейкая (длина строки = 20)
    println(describeCollection(listOf(-20, -15, -12)))                // Отрицательная (макс < -10)
    println(describeCollection(listOf(1001, 1002, 1003)))             // Положительная (мин > 1000)
    println(describeCollection(listOf(3, 5, 14, 7)))                   // Пи***тая (есть 3 и 14)
    println(describeCollection(listOf(11, 22, 33, 44, 55)))            // Уникальная (ничего не подошло)
}
/**
 * Задача 25. Анализ учебных оценок
 * Напиши функцию, которая принимает список чисел и возвращает список чисел.
 *
 * Пример данных: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
 *
 * Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию и взять первые 3. Вызывай методы обработки и фильтрации последовательно один из другого, чтобы результат предыдущего метода являлся основой для следующего.
 *
 */
fun getTopThreePassingGrades(grades: List<Int>): List<Int> =
    grades
        .filter { it >= 60 }           // отфильтровать удовлетворительные
        .sorted()                      // отсортировать по возрастанию
        .take(3)                       // взять первые 3

fun testGrades() {
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println(getTopThreePassingGrades(grades))  // [67, 74, 85]
}

/**
 * Задача 26. Создание каталога по первой букве
 * Напиши функцию, которая принимает список строк и возвращает словарь с ключом - буквой и значением - списком строк.
 *
 * Начальные значения: val list = listOf(
 * "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
 * )
 *
 * Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве используя метод groupBy
 */
fun createCatalogByFirstLetter(items: List<String>): Map<Char, List<String>> =
    items
        .map { it.lowercase() }        // привести к нижнему регистру
        .groupBy { it.first() }         // сгруппировать по первой букве

fun testCatalog() {
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы",
        "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга",
        "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор",
        "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница",
        "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба",
        "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир",
        "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    val catalog = createCatalogByFirstLetter(list)
}

/**
 * Задание 27. Подсчёт средней длины слов в списке
 * Напиши функцию, которая принимает список строк и возвращает строку.
 *
 * Начальные значения взять из предыдущей задачи.
 *
 * Цель: Перевести все слова в количество букв, подсчитать среднее значение. Вернуть форматированный текст с двумя знаками после запятой, используя функцию format и подходящий шаблон.
 */
fun averageWordLengthFormatted(items: List<String>): String {
    if (items.isEmpty()) return "0.00"

    val lengths = items.map { it.length }
    val average = lengths.average()
    return String.format("%.2f", average)
}

fun testAverageLength() {
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы",
        "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга",
        "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор",
        "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница",
        "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба",
        "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир",
        "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    println(averageWordLengthFormatted(list))
}
/**Задание 28: Категоризация чисел
Напиши функцию, которая принимает список чисел и возвращает словарь с ключами - строками и значениями - список чисел.

Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)

Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).*/
fun categorizeByParity(numbers: List<Int>): Map<String, List<Int>> {
    return numbers
        .distinct()                 // уникальные числа
        .sortedDescending()         // отсортировать по убыванию
        .groupBy { if (it % 2 == 0) "четные" else "нечетные" }
}

fun testCategorize() {
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println(categorizeByParity(numbers))
}

/**Задание 29: Поиск первого подходящего элемента
Напиши функцию, которая принимает список чисел и число и возвращает nullable число.

Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60) и число для проверки возраста, например 18.

Цель: Найти первый возраст в списке, который соответствует условию (больше второго аргумента) и вернуть его, либо null если значения не нашлось.*/

fun findFirstAgeGreaterThan(ages: List<Int?>, threshold: Int): Int? {
    return ages.firstOrNull { it != null && it > threshold }
}

fun testFindFirstAge() {
    val ages = listOf<Int?>(22, 18, 30, 45, 17, null, 60)
    println(findFirstAgeGreaterThan(ages, 18))  // 22
    println(findFirstAgeGreaterThan(ages, 40))  // 45
    println(findFirstAgeGreaterThan(ages, 60))  // null
}

