/**
 * 7. Все слова с большой буквы
 * Напишите метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с заглавной буквы а все остальные - строчные. Используй перебор, анализ символов и замену букв на заглавную с помощью метода uppercase() для конкретной буквы.
 */

fun capitalizeWords(text: String): String {
    val words = text.split("\\s+".toRegex())
    val result = mutableListOf<String>()
    for (word in words) {
        if (word.isEmpty()) continue
        val capitalized = word[0].uppercaseChar() + word.substring(1).lowercase()
        result.add(capitalized)
    }
    return result.joinToString(" ")
}

/**
fun main() {
    println(capitalizeWords("привет мир, это пример"))
}
        */
/**8. Игра в разведчика
Напишите шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой: Kotlin шифруется в oKltni. Дешифровка выполняется аналогично.

Если длина строки - нечётная, в конец добавляется символ пробела до начала шифрования. Таким образом все шифрованные сообщения будут с чётной длинной. Должно получиться два публичных метода: encrypt() и decrypt() которые принимают строку и печатают результат в консоль.
        */
fun encrypt(input: String) {
    var text = input
    if (text.length % 2 != 0) {
        text += " "
    }
    val result = StringBuilder()
    for (i in 0 until text.length step 2) {
        result.append(text[i + 1])
        result.append(text[i])
    }
    println(result.toString())
}

fun decrypt(input: String) {
    val text = input
    val result = StringBuilder()
    for (i in 0 until text.length step 2) {
        result.append(text[i + 1])
        result.append(text[i])
    }
    var final = result.toString()
    if (final.endsWith(" ")) {
        final = final.dropLast(1)
    }
    println(final)
}

/**
fun main() {
    encrypt("Kotlin")
    decrypt("oKltni")
}
        */

/**
 * 9. Таблица умножения
 * Напишите функцию, которая принимает два числа и выводит таблицу умножения, у которой в заголовках столбцов и строк находятся перемножаемые числа, а в перекрестии заголовка и столбца - результат перемножения. Важно: каждый столбец должен быть выровнен по правому краю с помощью шаблона с форматированием строк. Размер форматирования каждой строки нужно вычислять динамически для каждого столбца. Результат должен быть похож на этот пример:
 */

fun printMultiplicationTable(a: Int, b: Int) {

    val rows = a
    val cols = b


    val colWidths = IntArray(cols) { col ->
        val colIndex = col + 1
        var maxWidth = 0
        for (rowIndex in 1..rows) {
            val value = rowIndex * colIndex
            maxWidth = maxOf(maxWidth, value.toString().length)
        }
        maxWidth
    }


    print(" ".repeat(maxOf(0, rows.toString().length)))
    for (col in 0 until cols) {
        val value = col + 1
        print("%${colWidths[col]}d".format(value))
        print(" ")
    }
    println()


    for (row in 1..rows) {
        print("%${rows.toString().length}d".format(row))
        for (col in 0 until cols) {
            val value = row * (col + 1)
            print(" %${colWidths[col]}d".format(value))
        }
        println()
    }
}

fun main() {
    printMultiplicationTable(15, 6)
}