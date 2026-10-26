package lessons.lesson15.homeworks

class Circle(
    name: String = "Круг",
    color: String = "белый",
    val radius: Double
) : GeometricFigure(name, color) {

    override fun area() = Math.PI * radius * radius
    override fun perimeter() = 2 * Math.PI * radius
}
