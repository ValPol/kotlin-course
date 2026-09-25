package lessons.lesson07.homeworks/*Задания для цикла for
Прямой диапазон
 */
fun t1() {
// Выводит числа от 1 до 5
    for (i in 1..5) {
        println(i)
    }

// Выводит чётные числа от 1 до 10
    for (i in 2..10 step 2) {
        println(i)
    }
}
//Обратный диапазон
fun t2() {
    // От 5 до 1
    for (i in 5 downTo 1) {
        println(i)
    }

// От 10 до 1, уменьшая на 2
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

}

    //С шагом (step)
fun t3(){

// Шаг 2: числа от 1 до 9
        for (i in 1..9 step 2) {
            println(i)
        }

// Каждое третье число в диапазоне от 1 до 20
        for (i in 1..20 step 3) {
            println(i)
        }
}

//Использование до (until)
fun t4(){
    val size = 15
// От 3 до size, не включая size, шаг 2
    for (i in 3 until size step 2) {
        println(i)
    }
}

/**Задания для цикла while
 *
 */
//Цикл while

fun t5(){
    // Квадраты чисел от 1 до 5
    var i = 1
    while (i <= 5) {
        println(i * i)
        i++
    }

// Уменьшаем число от 10 до 5, потом выводим результат
    var n = 10
    while (n > 5) {
        n--
    }
    println(n)  // будет 5
}

//Цикл do while
fun  t6(){

// Вывод чисел от 5 до 1
    var x = 5
    do {
        println(x)
        x--
    } while (x >= 1)


// do-while, который повторяется, пока счётчик меньше 10, начиная с 5
    var counter = 5
    do {
        println(counter)
        counter++
    } while(counter<=10)
}

/*
Задания для прерывания и пропуска итерации
 */
// Использование break
fun t7(){
    // for от 1 до 10, выход при достижении 6
    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }

// while, бесконечно выводит числа с 1, прерывается при достижении 10
    var j = 1
    while (true) {
        if (j == 10) break
        println(j)
        j++
    }
}
//Использование continue
fun t8(){
    // В for от 1 до 10 пропустить чётные числа
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

// while от 1 до 10, пропускает числа, кратные 3
    var k = 1
    while (k <= 10) {
        if (k % 3 == 0) {
            k++
            continue
        }
        println(k)
        k++
    }
}
/**Таблица умножения (вложенные циклы)
**/
fun t9(){
    for (i in 1..10) {
        for (j in 1..10) {
            print("${i * j}\t")
        }
        println()
    }
}
/**Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции.**/
fun t10(arg: Int) {
    var sum = 0
    for (i in 1..arg) {
        sum += i
    }
    println (sum)
}
/**Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
**/
fun t11(arg: Int){
    var result: Long = 1
    var n = arg
    while (n > 1) {
        result *= n
        n--
    }
    println(result)
}

/**Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
**/
fun t12(arg: Int){
    var sum = 0
    var n = 2
    while (n <= arg) {
        sum += n
        n += 2
    }
    print (sum)
}

/**
 * Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3 из символов *.
 *
 */

fun t13(){
    var row = 0
    while (row < 3) {
        var col = 0
        while (col < 5) {
            print("*")
            col++
        }
        println()
        row++
    }
}

/**Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
 *
 */
fun t14(arg: Int){
    var evenSum = 0
    var oddSum = 0
    for (i in 1..arg) {
        if (i % 2 == 0) {
            evenSum += i
        } else {
            oddSum += i
        }
    }
    println(evenSum)
    print(oddSum)
}
fun main(){
   t14(6)
}