package lessons.lesson15.homeworks

abstract class Polygon(
    name: String,
    color: String,
    private val sidesCount: Int,
    private val sideLengths: List<Double>
) : GeometricFigure(name, color) {

    override fun perimeter(): Double = sideLengths.sum()

    override fun area(): Double {
        throw UnsupportedOperationException("Площадь общего многоугольника не определена без углов")
    }
}
