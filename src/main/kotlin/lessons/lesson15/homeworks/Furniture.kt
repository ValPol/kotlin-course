package lessons.lesson15.homeworks

abstract class Furniture(
    val model: String,
    val weightKg: Double,
    val isFoldable: Boolean
) {
    abstract fun usageDescription(): String

    fun basicInfo() = "$model, вес: ${weightKg} кг, складная: $isFoldable"
}
