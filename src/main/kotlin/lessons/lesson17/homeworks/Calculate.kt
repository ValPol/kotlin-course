
/* Абстрактный класс операции.
   База реализует проверку применимости и разбор выражения,
   наследники описывают только саму математику в apply(). */
abstract class Operation {

    /* Символ оператора, по которому операция узнаётся в выражении. */
    abstract val symbol: String

    /* Проверка применимости: выражение подходит, если удалось
       разобрать его на числовые операнды. */
    open fun matches(expression: String): Boolean {
        return parseOperands(expression) != null
    }

    /* Разбиение выражения на операнды.
       Возвращает список чисел или null, если разобрать не удалось.
       Список (а не пара с null внутри) — чтобы поддерживать
       и унарные операции вроде sqrt. */
    open fun parseOperands(expression: String): List<Double>? {
        val index = expression.indexOf(symbol)
        if (index == -1) return null

        val left = expression.substring(0, index).trim().toDoubleOrNull() ?: return null
        val right = expression.substring(index + symbol.length).trim().toDoubleOrNull() ?: return null

        return listOf(left, right)
    }

    /* Дополнительная проверка операндов: текст ошибки или null, если всё в порядке.
       Так каждая операция сама отвечает за свои ограничения. */
    open fun validate(operands: List<Double>): String? = null

    /* Выполнение операции — переопределяется в наследниках. */
    abstract fun apply(operands: List<Double>): Double
}

class Calculator private constructor(
    operations: List<Operation>
) {
    /* Список операций приватный: снаружи не виден и не меняется напрямую. */
    private val operations = operations.toMutableList()

    /* Регистрация пользовательской операции.
       Символ не может повторяться — вторая регистрация отклоняется. */
    fun register(operation: Operation): Boolean {
        if (operations.any { it.symbol == operation.symbol }) return false
        operations.add(operation)
        return true
    }

    /* Главный метод: принимает строку, возвращает строку. */
    fun evaluate(expression: String): String {
        val expr = expression.trim()

        /* Выбор операции: первая, чьи matches() и parseOperands() согласны. */
        val operation = operations.firstOrNull { it.matches(expr) }
            ?: return "Ошибка: неподдерживаемая операция или некорректное выражение"

        val operands = operation.parseOperands(expr)
            ?: return "Ошибка: неподдерживаемая операция или некорректное выражение"

        /* Операция сама сообщает о недопустимых операндах (например, деление на ноль). */
        operation.validate(operands)?.let { return it }

        /* Собственно вычисление — операция реально выполняется. */
        return formatResult(operation.apply(operands))
    }

    /* Приватный служебный метод: убирает ".0" у целых результатов. */
    private fun formatResult(value: Double): String {
        return if (value % 1.0 == 0.0) value.toLong().toString() else value.toString()
    }

    companion object {
        /* Фабрика со стандартным набором операций. */
        fun createDefault(): Calculator = Calculator(
            listOf(
                AddOperation(),
                SubtractOperation(),
                MultiplyOperation(),
                DivideOperation(),
                ModuloOperation()
            )
        )
    }
}

/* Стандартные операции: снаружи калькулятора недоступны
   (internal = видны только внутри нашего модуля). */

internal class AddOperation : Operation() {
    override val symbol = "+"
    override fun apply(operands: List<Double>) = operands[0] + operands[1]
}

internal class SubtractOperation : Operation() {
    override val symbol = "-"
    override fun apply(operands: List<Double>) = operands[0] - operands[1]
}

internal class MultiplyOperation : Operation() {
    override val symbol = "*"
    override fun apply(operands: List<Double>) = operands[0] * operands[1]
}

internal class DivideOperation : Operation() {
    override val symbol = "/"
    override fun apply(operands: List<Double>) = operands[0] / operands[1]
    override fun validate(operands: List<Double>) =
        if (operands[1] == 0.0) "Ошибка: деление на ноль" else null
}

internal class ModuloOperation : Operation() {
    override val symbol = "%"
    override fun apply(operands: List<Double>) = operands[0] % operands[1]
    override fun validate(operands: List<Double>) =
        if (operands[1] == 0.0) "Ошибка: деление на ноль" else null
}

/* Пользовательская бинарная операция — код калькулятора не менялся. */
class PowerOperation : Operation() {
    override val symbol = "^"
    override fun apply(operands: List<Double>) = Math.pow(operands[0], operands[1])
}

/* Пользовательская унарная операция: у неё один операнд,
   поэтому переопределены matches() и parseOperands(). */
class SquareRootOperation : Operation() {
    override val symbol = "sqrt"

    override fun matches(expression: String): Boolean {
        return expression.startsWith("$symbol ")
    }

    override fun parseOperands(expression: String): List<Double>? {
        val operand = expression.removePrefix(symbol).trim().toDoubleOrNull() ?: return null
        return listOf(operand)
    }

    override fun apply(operands: List<Double>) = kotlin.math.sqrt(operands[0])
}

fun main() {
    val calculator = Calculator.createDefault()

    /* Пользовательские операции добавляются без изменения кода калькулятора. */
    calculator.register(PowerOperation())
    calculator.register(SquareRootOperation())

    val tests = listOf(
        "3 + 4" to "7",
        "10 - 2.5" to "7.5",
        "6 * 7" to "42",
        "20 / 4" to "5",
        "10 % 3" to "1",
        "2 ^ 10" to "1024",
        "sqrt 25" to "5",
        "3 ** 4" to "Ошибка: неподдерживаемая операция или некорректное выражение",
        "abc + def" to "Ошибка: неподдерживаемая операция или некорректное выражение",
        "5 + abc" to "Ошибка: неподдерживаемая операция или некорректное выражение",
        "10 / 0" to "Ошибка: деление на ноль",
        "10 % 0" to "Ошибка: деление на ноль"
    )

    var passed = 0
    var failed = 0

    for ((expression, expected) in tests) {
        val actual = calculator.evaluate(expression)
        if (actual == expected) {
            println("OK   \"$expression\" -> $actual")
            passed++
        } else {
            println("FAIL \"$expression\" -> $actual (ожидалось: $expected)")
            failed++
        }
    }

    val duplicate = calculator.register(PowerOperation())
    if (!duplicate) {
        println("OK   повторная регистрация \"^\" отклонена")
        passed++
    } else {
        println("FAIL повторная регистрация прошла")
        failed++
    }

    println()
    println("Итог: $passed пройдено, $failed провалено")
}