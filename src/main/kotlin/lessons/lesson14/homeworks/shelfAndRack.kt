/**
 * Задание 6. Стеллаж и полки.
 *
 * Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
 *
 * Класс Shelf (Полка Стеллажа)
 *
 * Характеристики:
 *
 * Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
 * Список предметов (items): хранит названия предметов на полке.
 * Методы:
 *
 * Добавление Предмета (addItem):
 * Принимает название предмета.
 * Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
 * Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
 * Удаление Предмета (removeItem):
 * Принимает название предмета.
 * Удаляет предмет, если он найден на полке.
 * Возвращает true, если предмет был удален, и false, если такой предмет не найден.
 * Проверка Вместимости (canAccommodate):
 * Принимает название предмета.
 * Определяет, вместится ли предмет на полку.
 * Возвращает true, если предмет вместится, и false, если места недостаточно.
 * Проверка наличия предмета (containsItem):
 * Принимает название предмета
 * Возвращает true если такой предмет есть
 * Получение списка предметов (getItems):
 * Возвращает неизменяемый список предметов
 * Класс Rack (Стеллаж)
 *
 * Характеристики:
 *
 * Список полок (shelves): хранит полки стеллажа.
 * Максимальное количество полок.
 * Методы:
 *
 * Добавление Полки (addShelf):
 * Добавляет новую полку в стеллаж.
 * Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
 * Удаление Полки (removeShelf):
 * Принимает индекс полки для удаления.
 * Удаляет полку по указанному индексу.
 * Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
 * Добавление Предмета (addItem):
 * Добавляет предмет на первую свободную полку.
 * Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
 * Удаление Предмета (removeItem):
 * Находит и удаляет только один предмет с любой полки.
 * Возвращает true, если предмет был удален, и false, если такой предмет не найден.
 * Проверка наличия предмета на стеллаже (containsItem):
 * Возвращает true если предмет есть на одной из полок
 * Получение списка полок (getShelves):
 * Возвращает неизменяемый список полок
 * Печать Содержимого (printContents):
 * Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
 * Сложное удаление полки (advancedRemoveShelf):
 * Принимает индекс полки для удаления
 * Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
 * Удаляет полку с оставшимися предметами
 * Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
 *
 */
class Shelf(val capacity: Int) {
    private val items = mutableListOf<String>()
    private var usedCapacity = 0 // сумма длин названий предметов

    fun addItem(itemName: String): Boolean {
        val itemLength = itemName.length
        if (!canAccommodate(itemName)) return false

        items.add(itemName)
        usedCapacity += itemLength
        return true
    }

    fun removeItem(itemName: String): Boolean {
        val removed = items.remove(itemName)
        if (removed) {
            usedCapacity -= itemName.length
        }
        return removed
    }

    fun canAccommodate(itemName: String): Boolean {
        return usedCapacity + itemName.length <= capacity
    }

    fun containsItem(itemName: String): Boolean = items.contains(itemName)

    fun getItems(): List<String> = items.toList()

    // вспомогательные для логики стеллажа
    internal fun currentUsed(): Int = usedCapacity
    internal fun remainingCapacity(): Int = capacity - usedCapacity
}


class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    fun addShelf(shelf: Shelf): Boolean {
        // если стеллаж уже заполнен — нельзя добавить
        if (shelves.size >= maxShelves) return false
        // если такая полка уже есть (по ссылке) — тоже не добавляем
        if (shelves.contains(shelf)) return false

        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index < 0 || index >= shelves.size) return emptyList()
        val shelf = shelves.removeAt(index)
        return shelf.getItems()
    }

    fun addItem(itemName: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(itemName)) {
                return true
            }
        }
        return false
    }

    fun removeItem(itemName: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(itemName)) {
                return true
            }
        }
        return false
    }

    fun containsItem(itemName: String): Boolean {
        return shelves.any { it.containsItem(itemName) }
    }

    fun getShelves(): List<Shelf> = shelves.toList()

    fun printContents() {
        shelves.forEachIndexed { idx, shelf ->
            val items = shelf.getItems()
            println(
                "Полка #$idx | Вместимость: ${shelf::class.simpleName} (макс. букв: ${shelf.capacity}) | " +
                        "Занято: ${shelf.currentUsed()} | Осталось: ${shelf.remainingCapacity()} | " +
                        "Предметы: $items"
            )
        }
        if (shelves.isEmpty()) {
            println("Стеллаж пуст: полки отсутствуют.")
        }
    }

    /**
     * Сложное удаление полки: перераспределяем предметы по другим полкам.
     * Предметы пытаемся разместить начиная с самых длинных.
     */
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index < 0 || index >= shelves.size) return emptyList()

        val targetShelf = shelves[index]
        val itemsToMove = targetShelf.getItems().sortedByDescending { it.length }
        val failedItems = mutableListOf<String>()

        // сначала удаляем полку из списка, чтобы не пытаться класть на неё
        shelves.removeAt(index)

        for (item in itemsToMove) {
            var placed = false
            for (shelf in shelves) {
                if (shelf.addItem(item)) {
                    placed = true
                    break
                }
            }
            if (!placed) {
                failedItems.add(item)
            }
        }

        return failedItems.toList()
    }
}