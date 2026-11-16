package lessons.lesson20.homeworks
import kotlin.math.absoluteValue

fun Array<Int>.firstLast(): Pair<Int?, Int?> =
    if (isEmpty()) null to null else this.first() to this.last()

fun <T : Comparable<T>> MutableList<T>.sortedView(ascending: Boolean): List<T> {
    if (ascending) sort() else sortDescending()
    return this
}
/**
fun <K, V> Map<K, List<V>?>?.remapIndexed(index: Int): Map<String, V?>? =
    this?.associate { (key, list) -> key.toString() to list?.getOrNull(index) }

fun main() {
    val map: Map<String, List<Int>?>? =
        mapOf("one" to listOf(10, 20, 30), "two" to null, "three" to listOf(5))

    println(map.remapIndexed(0))    // {one=10, two=null, three=5}
    println(map.remapIndexed(1))    // {one=20, two=null, three=null} — в "three" нет индекса 1
    println(map.remapIndexed(10))   // {one=null, two=null, three=null}
}
*/

fun Number.within(other: Number, deviation: Number): Boolean =
    (toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()

fun main() {
    println(10.within(12, 3))          // true  (|10 - 12| = 2 ≤ 3)
    println(10.within(15, 3))          // false (5 > 3)
    println(2.5.within(2, 0.5))        // true  (0.5 ≤ 0.5 — граница включена)
    println(1L.within(3L, 1L))         // false
    println((-5).within(-4, 2))        // true  (|−5 − (−4)| = 1 ≤ 2)
}

fun String.encrypt(base: Int): String = String(map { it + base }.toCharArray())

fun String.decrypt(base: Int): String = encrypt(-base)


fun main() {
    val secret = "Kotlin!".encrypt(3)      // "Nrwolq!"
    println(secret)
    println(secret.decrypt(3))             // "Kotlin!" — исходная строка
}

fun String.spellWithUsers(users: List<String>) {
    require(users.isNotEmpty()) { "Нужен хотя бы один ник" }
    uppercase().forEachIndexed { i, letter ->
        println(letter)
        println(users[i % users.size])
    }
}

fun main() {
    "Kotlin".spellWithUsers(
        listOf("@SadNSober_", "@jetBrains", "@kotlinlang", "@korolev", "@jetbrains_kotlin", "@dev_kazan")
    )
}

