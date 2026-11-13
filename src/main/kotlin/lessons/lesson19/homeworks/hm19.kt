package lessons.lesson19.homeworks

// 1. Функция возвращает средний элемент только если длина списка нечётная
fun <T> getMiddleElement(list: List<T>): T? =
    if (list.size % 2 == 1) list[list.size / 2] else null

// 2. Класс-контейнер списка
class ListHolder<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> = items.toList() // копия — снаружи изменить нельзя
}

// 3. Интерфейс преобразователя
interface Mapper<T, R> {
    fun map(item: T): R
    fun mapList(items: List<T>): List<R>
}

// 4. Разбивает строку по пробелам; для списков — каждую строку отдельно
class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun map(item: String): List<String> =
        item.split(" ")

    override fun mapList(items: List<String>): List<List<String>> =
        items.map { it.split(" ") }
}

// 5. Меняет местами ключи и значения
fun <K, V> transposition(map: Map<K, V>): Map<V, K> =
    map.entries.associate { (key, value) -> value to key }

// 6. Интерфейс валидатора
interface Validator<T> {
    fun validate(item: T): Boolean
}

// 7. Строка не null, не пустая и не из одних пробелов
class StringValidator : Validator<String?> {
    override fun validate(item: String?): Boolean =
        !item.isNullOrBlank()
}

// 8. Число чётное
class OddValidator : Validator<Int> {
    override fun validate(item: Int): Boolean =
        item % 2 == 0
}

// 9. Все элементы не null и не равны 0.0 после приведения к Double
class ListValidator<T : Number> : Validator<List<T>?> {
    override fun validate(item: List<T>?): Boolean =
        item != null && item.all { it != null && it.toDouble() != 0.0 }
}

fun main() {
    println(getMiddleElement(listOf(1, 2, 3)))        // 2
    println(getMiddleElement(listOf("a", "b", "c", "d")) )    // null

    println(StringValidator().validate("  "))         // false
    println(OddValidator().validate(4))               // true

    val holder = ListHolder<String>()
    holder.add("a")
    holder.add("b")
    println(holder.getAll())                          // [a, b]

    println(transposition(mapOf("one" to 1)))         // {1=one}
}
