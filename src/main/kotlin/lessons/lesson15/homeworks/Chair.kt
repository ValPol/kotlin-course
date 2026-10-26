
package lessons.lesson15.homeworks

class Chair(
    model: String,
    weightKg: Double,
    isFoldable: Boolean,
    val hasBackrest: Boolean,
    val seatHeightCm: Double
) : Furniture(model, weightKg, isFoldable) {

    override fun usageDescription() =
        "Стул: ${if (hasBackrest) "со спинкой" else "без спинки"}, высота сиденья $seatHeightCm см"
}
