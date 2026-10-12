/**Задачи на сигнатуру метода
Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое значение. В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.
// Не принимает аргументов и не возвращает значения
fun doNothing()

// Принимает два целых числа и возвращает их сумму
fun sum(a: Int, b: Int): Int

// Принимает строку и ничего не возвращает
fun processString(text: String)

// Принимает список целых чисел и возвращает среднее значение типа Double
fun average(numbers: List<Int>): Double

// Принимает nullable строку и возвращает её длину в виде nullable целого числа; доступна только в текущем файле
internal fun lengthOrNull(text: String?): Int?

// Не принимает аргументов и возвращает nullable вещественное число
fun getNullableDouble(): Double?

// Принимает nullable список целых чисел, не возвращает значения; доступна только в текущем файле
internal fun processNullableList(numbers: List<Int>?): Unit

// Принимает целое число и возвращает nullable строку
fun intToStringOrNull(value: Int): String?

// Не принимает аргументов и возвращает список nullable строк
fun getNullableStringList(): List<String?>

// Принимает nullable строку и nullable целое число и возвращает nullable булево значение
fun checkCondition(text: String?, number: Int?): Boolean? */


/**

Задачи на написание кода
Напишите валидную сигнатуру метода а так же рабочий код для задач.

Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
*/
// multiplyByTwo: принимает целое число и возвращает его, умноженное на 2
fun multiplyByTwo(value: Int): Int = value * 2

// isEven: true, если число чётное, иначе false
fun isEven(value: Int): Boolean = value % 2 == 0

// printNumbersUntil: выводит числа от 1 до n; если n < 1 — ничего не делает
fun printNumbersUntil(n: Int) {
    if (n < 1) return
    for (i in 1..n) {
        println(i)
    }
}

// findFirstNegative: возвращает первое отрицательное число или null, если нет
fun findFirstNegative(numbers: List<Int>): Int? {
    return numbers.firstOrNull { it < 0 }
}

// processList: выводит каждую строку; при встрече null — прекращает выполнение
fun processList(strings: List<String?>) {
    for (str in strings) {
        if (str == null) return
        println(str)
    }
}
