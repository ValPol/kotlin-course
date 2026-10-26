package lessons.lesson15.homeworks

abstract class Materials {
    protected val materials = mutableListOf<String>()

    open fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}
class BottomInsertMaterials : Materials() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }
}
class InterleavedInsertMaterials : Materials() {

    fun addMaterialsInterleaved(newMaterials: List<String>) {
        var newIndex = 0
        var currentIndex = 0

        while (newIndex < newMaterials.size) {
            materials.add(currentIndex, newMaterials[newIndex])
            newIndex++
            currentIndex += 2
        }
    }
}
class SortedMaterials : Materials() {
    override fun addMaterial(material: String) {
        materials.add(material)
        materials.sort()
    }
}

class KeyValueMaterials : Materials() {

    fun addFromMap(map: Map<String, String>) {
        // Ключи в начало в обратном порядке
        val keysReversed = map.keys.toList().reversed()
        // Значения в конец
        val values = map.values.toList()

        // Сначала вставляем ключи в начало
        keysReversed.forEach { key ->
            materials.add(0, key)
        }

        // Потом добавляем значения в конец
        materials.addAll(values)
    }
}