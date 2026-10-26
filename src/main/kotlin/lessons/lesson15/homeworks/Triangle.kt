package lessons.lesson15.homeworks

class Triangle(
    color: String = "синий",
    val a: Double,
    val b: Double,
    val c: Double
) : Polygon("Треугольник", color, 3, listOf(a, b, c)) {

    init {
        require(a + b > c && a + c > b && b + c > a) { "Неверный треугольник" }
    }

    // Формула Герона
    override fun area(): Double {
        val p = perimeter() / 2.0
        return kotlin.math.sqrt(p * (p - a) * (p - b) * (p - c))
    }
}
