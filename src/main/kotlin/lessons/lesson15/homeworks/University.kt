package lessons.lesson15.homeworks

class University(
    name: String,
    city: String,
    studentCount: Int,
    val faculties: List<String>
) : EducationalInstitution(name, city, studentCount) {

    override fun getTypeDescription() = "Университет"

    fun listFaculties() = faculties.joinToString(", ")
}
