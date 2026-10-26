package lessons.lesson15.homeworks

class Cabinet(
    model: String,
    weightKg: Double,
    isFoldable: Boolean,
    val shelvesCount: Int,
    val hasDoors: Boolean
) : Furniture(model, weightKg, isFoldable) {

    override fun usageDescription() =
        "Шкаф: $shelvesCount полок, дверцы: $hasDoors"
}
