/**
 * Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
 */
class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Вечеринка проходит в: $location. Количество гостей: $attendees")
    }
}

/**
 * Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String) и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.
 */

class Emotion(val type: String, val intensity: Int) {
    fun express() {
        val intensityText = when {
            intensity <= 0 -> "отсутствует"
            intensity in 1..3 -> "слабая"
            intensity in 4..7 -> "средняя"
            else -> "сильная"
        }
        println("Эмоция: $type ($intensityText)")
    }
}

/**
 * Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
 */
object Moon {
    var isVisible: Boolean = false
    var phase: String = "New Moon"

    fun showPhase() {
        if (isVisible) {
            println("Луна видна. Текущая фаза: $phase")
        } else {
            println("Луна не видна. Текущая фаза: $phase")
        }
    }
}

/**
 * Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть свойства “название”, “цена”, “количество”.
 *
 */
data class Product(val name: String, val price: Double, val quantity: Int)

/**
 * Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
 *
 */
class Concert(
    val band: String,
    val venue: String,
    val ticketPrice: Double,
    val capacity: Int
) {
    private var soldTickets: Int = 0

    fun printInfo() {
        println(
            "Концерт: $band\n" +
                    "Место: $venue\n" +
                    "Стоимость билета: $ticketPrice\n" +
                    "Вместимость зала: $capacity\n" +
                    "Продано билетов: $soldTickets"
        )
    }

    fun buyTicket(): Boolean {
        if (soldTickets < capacity) {
            soldTickets++
            return true
        }
        return false
    }
}