package lessons.lesson15.homeworks

class School(
    name: String,
    city: String,
    studentCount: Int,
    val gradesRange: IntRange // например, 1..11
) : EducationalInstitution(name, city, studentCount) {

    override fun getTypeDescription() = "Школа"

    fun getGradesInfo() = "Классы: ${gradesRange.first}–${gradesRange.last}"
}
