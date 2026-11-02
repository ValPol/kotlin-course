import kotlin.math.PI
import kotlin.math.sin

abstract class Shape {
    abstract fun area(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double = PI * radius * radius
}

class Square(private val side: Double) : Shape() {
    override fun area(): Double = side * side
}

class Triangle(
    private val a: Double,
    private val b: Double,
    private val angleDegrees: Double // угол между сторонами a и b в градусах
) : Shape() {
    override fun area(): Double {
        val angleRadians = angleDegrees * (PI / 180.0)
        return 0.5 * a * b * sin(angleRadians)
    }
}

fun main() {
    val shapes: List<Shape> = listOf(
        Circle(5.0),
        Square(4.0),
        Triangle(3.0, 4.0, 90.0) // прямоугольный треугольник
    )

    shapes.forEachIndexed { index, shape ->
        println("Фигура $index: площадь = ${shape.area()}")
    }
}