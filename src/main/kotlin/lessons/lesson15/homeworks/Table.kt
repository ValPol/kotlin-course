package lessons.lesson15.homeworks

class Table(
    model: String,
    weightKg: Double,
    isFoldable: Boolean,
    val lengthCm: Double,
    val widthCm: Double
) : Furniture(model, weightKg, isFoldable) {

    override fun usageDescription() =
        "Стол: ${lengthCm}×${widthCm} см"
}
