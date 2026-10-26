package lessons.lesson15.homeworks

abstract class EducationalInstitution(
    val name: String,
    val city: String,
    val studentCount: Int
) {
    abstract fun getTypeDescription(): String

    fun info() = "${getTypeDescription()} «$name» в $city, студентов: $studentCount"
}
