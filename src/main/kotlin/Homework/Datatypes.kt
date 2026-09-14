val v1: Int = 42
val v2: Long = 98765432123456789L
val v3: Float = 23.45f
val v4: Double = 0.123456789
val v5: String = "Kotlin & Java"
// val v6 = FALSE   булевы литералы пишутся в нижнем регистре: true / false
val v6: Boolean = false
val v7: Char = 'c'
val v8: Int = 500
val v9: Long = 4294967296L
val v10: Float = 18.0f
val v11: Double = -0.001
val v12: String = "OpenAI"
val v13: String = "true"
val v14: List<Int> = listOf(3, 14)
val v15: Char = '9'
val v16: Int = 2048
val v17: Long = 10000000000L
val v18: Set<String> = setOf("OpenAI", "Quantum Computing")
val v19: Float = 5.75f
// val v20 = `1.414` число нужно писать без кавычек
val v20: Double = 1.414
val v21: String = "Artificial Intelligence"
// val v22 = arrayOf('x', "A")  массив должен быть однородным по типу; 'x' — Char, "A" — String
val v22: Array<Any> = arrayOf('x', "A")
val v23: String = "Android Studio"
val v24: Char = '@'
val v25: Int = 1024
val v26: Long = 1234567890123L
val v27: Float = 10.01f
val v28: Double = -273.15
val v29: String = "SpaceX"
// val v30 = FALSE  неверный регистр булевого литерала
val v30: Boolean = false
val v31: Double = 0.007
val v32: String = "🤯"
val v33: Map<String, Int> = mapOf("true" to 2, "false" to 34)
// val v34 = ‘65535’ одинарные кавычки для Char, но 65535 — это число
val v34: Char = '\uFFFF'
val v35: Long = 72057594037927935L
val v36: Float = 2.71828f
val v37: Double = 101.0101
val v38: String = "Quantum Computing"
val v39: Map<Int, String> = mapOf(2 to "true", 34 to "false")
val v40: Char = 'x'
val v41: Int = 314
val v42: Long = 123456789123456789L
val v43: Float = 6.626f
// val v44 = TRUE  неверный регистр булевого литерала
val v44: Boolean = true

/**
 * Хранить букву, на которую указывает палец медиума во время спиритического сеанса.
 * Это один символ  Char
 */
val mediumFingerLetter: Char = 'A'

/**
 * Хранить количество ложек сахара, которые я кладу в одну чашку чая.
 * Количество — целое неотрицательное число Int
 */
val sugarSpoonsPerCup: Int = 2

/**
 * Хранить список расходов на доставку еды, чтобы ещё раз убедиться, что готовить было дешевле.
 * Расходы — числа с дробной частью List<Double>
 */
val deliveryExpenses: List<Double> = listOf(199.99, 249.50, 175.0)

/**
 * Хранить длину очереди в столовой до миллиардной доли сантиметра.
 * Высокая точность   Double
 */
val queueLengthInCm: Double = 15.000000001

/**
 * Хранить факт, закрыт ли баг после того, как его просто переименовали в фичу.
 * Факт (да/нет) Boolean
 */
val bugClosedAfterRename: Boolean = true

/**
 * Хранить количество свистков чайника за день.
 * Целое число Int
 */
val kettleWhistlesCount: Int = 3

/**
 * Хранить количество нажатий котом на клавиатуру ноутбука за всё время твоей работы.
 * Может быть большим Long
 */
val catKeyboardPresses: Long = 12345L

/**
 * Хранить количество попыток пересчитать звёзды на небе за всю историю человечества.
 * Очень большое число Long
 */
val starCountingAttempts: Long = 999999999L

/**
 * Хранить массу воздуха в спускающем матрасе после нападения кота в долях грамма.
 * Дробное значение с точностью Double
 */
val airMassInDeflatingMattress: Double = 0.375

/**
 * Хранить словарь «название стартапа и сумму потерь инвесторов».
 * Ключ — строка, значение — число Map<String, Double>
 */
val startupLosses: Map<String, Double> = mapOf(
    "Startup Alpha" to 1500000.0,
    "Startup Beta" to 850000.5
)

/**
 * Хранить строку «починилось само», чтобы закрывать тикеты без лишних слов.
 * Текст String
 */
val ticketCloseReason: String = "починилось само"

/**
 * Хранить список тем для митингов, которые на самом деле никому не нужны.
 * Список строк List<String>
 */
val uselessMeetingTopics: List<String> = listOf(
    "Обсуждение цвета кнопок",
    "Планирование планирования",
    "Итоги итогов"
)