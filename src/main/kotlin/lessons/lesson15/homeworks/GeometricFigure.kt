package lessons.lesson15.homeworks

abstract class GeometricFigure(
    val name: String,
    val color: String
) {
    abstract fun area(): Double
    abstract fun perimeter(): Double

    fun describe() = "Фигура: $name, цвет: $color"
}
