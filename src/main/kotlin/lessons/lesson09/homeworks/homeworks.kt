
    /**
     * Работа с массивами Array
     * Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
     * Создайте пустой массив строк размером 10 элементов.
     * Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
     * Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
     * Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
     * Создайте массив целых чисел и скопируйте его в новый массив в цикле.
     * Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
     * Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
     * Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
     * Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
     */
   /** fun main() {
        // 1. Массив из 5 целых чисел: [1, 2, 3, 4, 5]
        val arr1 = IntArray(5)
        for (i in 0 until arr1.size) {
            arr1[i] = i + 1
        }
        print("Задача 1: ")
        for (i in 0 until arr1.size) {
            print(arr1[i])
            if (i < arr1.size - 1) {
                print(", ")
            }
        }
        println()

        // 2. Пустой массив строк размером 10 элементов (все null)
        val arr2 = arrayOfNulls<String>(10)
        println("Задача 2: размер = ${arr2.size}")
        var allNull = true
        for (i in 0 until arr2.size) {
            if (arr2[i] != null) {
                allNull = false
            }
        }
        println("Все элементы null: $allNull")

        // 3. Массив Double: удвоенный индекс элемента (0→0.0, 1→2.0, ..., 4→8.0)
        val arr3 = DoubleArray(5)
        for (i in 0 until arr3.size) {
            arr3[i] = i * 2.0
        }
        print("Задача 3: ")
        for (i in 0 until arr3.size) {
            print(arr3[i])
            if (i < arr3.size - 1) {
                print(", ")
            }
        }
        println()

        // 4. Массив Int: значение = индекс * 3
        val arr4 = IntArray(5)
        for (i in 0 until arr4.size) {
            arr4[i] = i * 3
        }
        print("Задача 4: ")
        for (i in 0 until arr4.size) {
            print(arr4[i])
            if (i < arr4.size - 1) {
                print(", ")
            }
        }
        println()

        // 5. Массив из 3 nullable строк: один null, две строки
        val arr5 = arrayOfNulls<String>(3)
        arr5[0] = null
        arr5[1] = "hello"
        arr5[2] = "world"
        print("Задача 5: ")
        for (i in 0 until arr5.size) {
            if (arr5[i] == null) {
                print("null")
            } else {
                print(arr5[i])
            }
            if (i < arr5.size - 1) {
                print(", ")
            }
        }
        println()

        // 6. Копирование массива в новый массив в цикле
        val sourceArr = IntArray(5)
        sourceArr[0] = 10
        sourceArr[1] = 20
        sourceArr[2] = 30
        sourceArr[3] = 40
        sourceArr[4] = 50

        val targetArr = IntArray(sourceArr.size)
        for (i in 0 until sourceArr.size) {
            targetArr[i] = sourceArr[i]
        }
        print("Задача 6: исходный = ")
        for (i in 0 until sourceArr.size) {
            print(sourceArr[i])
            if (i < sourceArr.size - 1) print(", ")
        }
        print("; копия = ")
        for (i in 0 until targetArr.size) {
            print(targetArr[i])
            if (i < targetArr.size - 1) print(", ")
        }
        println()

        // 7. Два массива одинаковой длины, третий — разность элементов
        val a = IntArray(4)
        a[0] = 10; a[1] = 20; a[2] = 30; a[3] = 40

        val b = IntArray(4)
        b[0] = 3; b[1] = 7; b[2] = 15; b[3] = 25

        val diff = IntArray(a.size)
        for (i in 0 until a.size) {
            diff[i] = a[i] - b[i]
        }
        print("Задача 7: разность = ")
        for (i in 0 until diff.size) {
            print(diff[i])
            if (i < diff.size - 1) print(", ")
        }
        println()

        // 8. Поиск индекса элемента со значением 5 через while (если нет — -1)
        val searchArr = IntArray(5)
        searchArr[0] = 2; searchArr[1] = 4; searchArr[2] = 6; searchArr[3] = 5; searchArr[4] = 8

        var index = 0
        var resultIndex = -1
        while (index < searchArr.size) {
            if (searchArr[index] == 5) {
                resultIndex = index
                break
            }
            index++
        }
        println("Задача 8: индекс элемента 5 = $resultIndex")

        // 9. Перебор массива и вывод «чётное»/«нечётное»
        val parityArr = IntArray(6)
        parityArr[0] = 1; parityArr[1] = 2; parityArr[2] = 3
        parityArr[3] = 4; parityArr[4] = 5; parityArr[5] = 6

        println("Задача 9:")
        var i = 0
        while (i < parityArr.size) {
            val value = parityArr[i]
            val type = if (value % 2 == 0) "чётное" else "нечётное"
            println("$value — $type")
            i++
        }

        // 10. Функция поиска подстроки в массиве строк
        val words = arrayOf("apple", "banana", "cherry", "pineapple")
        findSubstringInArray(words, "apple")
    }

    fun findSubstringInArray(strings: Array<String>, substring: String) {
        for (str in strings) {
            if (str.contains(substring)) {
                println("Задача 10: найден элемент: $str")
                return
            }
        }
        println("Задача 10: элемент с подстрокой '$substring' не найден")
    }

*/


    /**
     * Работа со списками List
     * Создайте пустой неизменяемый список целых чисел.
     * Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
     * Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
     * Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
     * Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
     * Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
     * Создайте список строк и получите из него второй элемент, используя его индекс.
     * Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
     * Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
     * Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
     * Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
     */
  /**  fun main() {
        task1_emptyImmutableList()
        task2_immutableStringList()
        task3_mutableIntListInit()
        task4_addElementsToMutableList()
        task5_removeElementFromMutableList()
        task6_printListWithLoop()
        task7_getSecondElementByIndex()
        task8_updateElementByIndex()
        task9_mergeTwoListsWithLoops()
        task10_findMinMaxWithLoop()
        task11_extractEvenNumbersWithLoop()
    }

    // Задача 1: пустой неизменяемый список целых чисел
    fun task1_emptyImmutableList() {
        val emptyList = listOf<Int>()
        println("Задача 1: пустой неизменяемый список, размер = ${emptyList.size}")
    }

    // Задача 2: неизменяемый список строк из 3 элементов
    fun task2_immutableStringList() {
        val immutableList = listOf("Hello", "World", "Kotlin")
        print("Задача 2: ")
        var i = 0
        while (i < immutableList.size) {
            print(immutableList[i])
            if (i < immutableList.size - 1) {
                print(", ")
            }
            i++
        }
        println()
    }

    // Задача 3: изменяемый список целых чисел: [1, 2, 3, 4, 5]
    fun task3_mutableIntListInit() {
        val mutableList = mutableListOf<Int>()
        for (i in 1..5) {
            mutableList.add(i)
        }

        print("Задача 3: ")
        for (idx in 0 until mutableList.size) {
            print(mutableList[idx])
            if (idx < mutableList.size - 1) {
                print(", ")
            }
        }
        println()
    }

    // Задача 4: добавить в изменяемый список новые элементы (6, 7, 8)
    fun task4_addElementsToMutableList() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        list.add(6)
        list.add(7)
        list.add(8)

        print("Задача 4: после добавления 6,7,8 = ")
        var i = 0
        while (i < list.size) {
            print(list[i])
            if (i < list.size - 1) {
                print(", ")
            }
            i++
        }
        println()
    }

    // Задача 5: удалить из изменяемого списка строк определённый элемент ("World")
    fun task5_removeElementFromMutableList() {
        val list = mutableListOf("Hello", "World", "Kotlin")
        val toRemove = "World"
        var removed = false
        var i = 0

        // Удаляем первый найденный элемент
        while (i < list.size) {
            if (list[i] == toRemove) {
                list.removeAt(i)
                removed = true
                break
            }
            i++
        }

        print("Задача 5: после удаления \"$toRemove\" = ")
        var j = 0
        while (j < list.size) {
            print(list[j])
            if (j < list.size - 1) {
                print(", ")
            }
            j++
        }
        println()
    }

    // Задача 6: вывести каждый элемент списка целых чисел через цикл
    fun task6_printListWithLoop() {
        val list = listOf(10, 20, 30, 40, 50)
        println("Задача 6:")
        var i = 0
        while (i < list.size) {
            println(list[i])
            i++
        }
    }

    // Задача 7: получить второй элемент списка строк по индексу
    fun task7_getSecondElementByIndex() {
        val list = listOf("First", "Second", "Third")
        // Второй элемент — индекс 1
        val secondElement = list[1]
        println("Задача 7: второй элемент = $secondElement")
    }

    // Задача 8: изменить значение элемента на определённой позиции (индекс 2)
    fun task8_updateElementByIndex() {
        val list = mutableListOf(5, 10, 15, 20, 25)
        val newVal = 99
        val index = 2

        if (index >= 0 && index < list.size) {
            list[index] = newVal
        }

        print("Задача 8: после замены элемента с индексом $index на $newVal = ")
        var i = 0
        while (i < list.size) {
            print(list[i])
            if (i < list.size - 1) {
                print(", ")
            }
            i++
        }
        println()
    }

    // Задача 9: объединить два списка строк в один новый список с помощью циклов
    fun task9_mergeTwoListsWithLoops() {
        val list1 = listOf("A", "B", "C")
        val list2 = listOf("X", "Y", "Z")
        val merged = mutableListOf<String>()

        var i = 0
        while (i < list1.size) {
            merged.add(list1[i])
            i++
        }

        i = 0
        while (i < list2.size) {
            merged.add(list2[i])
            i++
        }

        print("Задача 9: объединённый список = ")
        var j = 0
        while (j < merged.size) {
            print(merged[j])
            if (j < merged.size - 1) {
                print(", ")
            }
            j++
        }
        println()
    }

    // Задача 10: найти минимальный и максимальный элементы в списке через цикл
    fun task10_findMinMaxWithLoop() {
        val list = listOf(7, 3, 9, 1, 5, 8)

        if (list.isEmpty()) {
            println("Задача 10: список пуст")
            return
        }

        var min = list[0]
        var max = list[0]

        var i = 1
        while (i < list.size) {
            val value = list[i]
            if (value < min) {
                min = value
            }
            if (value > max) {
                max = value
            }
            i++
        }

        println("Задача 10: min = $min, max = $max")
    }

    // Задача 11: создать новый список только с чётными числами из исходного (через цикл)
    fun task11_extractEvenNumbersWithLoop() {
        val source = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val evenList = mutableListOf<Int>()

        var i = 0
        while (i < source.size) {
            val value = source[i]
            if (value % 2 == 0) {
                evenList.add(value)
            }
            i++
        }

        print("Задача 11: чётные числа = ")
        var j = 0
        while (j < evenList.size) {
            print(evenList[j])
            if (j < evenList.size - 1) {
                print(", ")
            }
            j++
        }
        println()
    }*/

    //*
    // Работа с Множествами Set
    //Создайте пустое неизменяемое множество целых чисел.
    //Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    //Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    //Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    //Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    //Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    //Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно распечатать булево значение true если строка есть. Реши задачу через цикл.
    //Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.*/

  fun main() {
      task1_emptyImmutableSet()
      task2_immutableIntSet()
      task3_mutableStringSetInit()
      task4_addElementsToMutableSet()
      task5_removeElementFromMutableSet()
      task6_printSetWithLoop()
      task7_checkStringInSetWithLoop()
      task8_convertSetToListWithLoop()
  }

    // Задача 1: пустое неизменяемое множество целых чисел
    fun task1_emptyImmutableSet() {
        val emptySet = setOf<Int>()
        println("Задача 1: пустой неизменяемый Set, размер = ${emptySet.size}")
    }

    // Задача 2: неизменяемое множество целых чисел с 3 элементами
    fun task2_immutableIntSet() {
        val immutableSet = setOf(1, 2, 3)
        print("Задача 2: ")
        var i = 0
        // Set не поддерживает индексацию, поэтому перебираем через итератор
        val iterator = immutableSet.iterator()
        while (iterator.hasNext()) {
            val value = iterator.next()
            print(value)
            if (i < immutableSet.size - 1) {
                print(", ")
            }
            i++
        }
        println()
    }

    // Задача 3: изменяемое множество строк с инициализацией
    fun task3_mutableStringSetInit() {
        val mutableSet = mutableSetOf<String>()
        mutableSet.add("Kotlin")
        mutableSet.add("Java")
        mutableSet.add("Scala")

        print("Задача 3: ")
        val iterator = mutableSet.iterator()
        var first = true
        while (iterator.hasNext()) {
            val value = iterator.next()
            if (!first) {
                print(", ")
            }
            print(value)
            first = false
        }
        println()
    }

    // Задача 4: добавить новые элементы в изменяемое множество строк
    fun task4_addElementsToMutableSet() {
        val set = mutableSetOf("Kotlin", "Java", "Scala")
        set.add("Swift")
        set.add("Go")

        print("Задача 4: после добавления Swift, Go = ")
        val iterator = set.iterator()
        var first = true
        while (iterator.hasNext()) {
            val value = iterator.next()
            if (!first) {
                print(", ")
            }
            print(value)
            first = false
        }
        println()
    }

    // Задача 5: удалить элемент из изменяемого множества целых чисел
    fun task5_removeElementFromMutableSet() {
        val set = mutableSetOf(1, 2, 3, 4, 5)
        val toRemove = 2

        var removed = false
        val iterator = set.iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == toRemove) {
                iterator.remove()
                removed = true
                break
            }
        }

        print("Задача 5: после удаления $toRemove = ")
        val it = set.iterator()
        var first = true
        while (it.hasNext()) {
            val value = it.next()
            if (!first) {
                print(", ")
            }
            print(value)
            first = false
        }
        println()
    }

    // Задача 6: вывести каждый элемент множества целых чисел через цикл
    fun task6_printSetWithLoop() {
        val set = setOf(10, 20, 30, 40, 50)
        println("Задача 6:")
        val iterator = set.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

    // Задача 7: функция проверки наличия строки в множестве через цикл (без contains)
    fun task7_checkStringInSetWithLoop() {
        val set = setOf("Kotlin", "Java", "Scala", "Go", "Swift")
        checkStringInSet(set, "Java")
        checkStringInSet(set, "Python")
    }

    fun checkStringInSet(stringSet: Set<String>, target: String) {
        var found = false
        val iterator = stringSet.iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == target) {
                found = true
                break
            }
        }
        println("Задача 7: строка \"$target\" присутствует в Set = $found")
    }

    // Задача 8: конвертировать неизменяемое множество строк в изменяемый список через цикл
    fun task8_convertSetToListWithLoop() {
        val immutableSet = setOf("Alpha", "Beta", "Gamma")
        val mutableList = mutableListOf<String>()

        val iterator = immutableSet.iterator()
        while (iterator.hasNext()) {
            mutableList.add(iterator.next())
        }

        print("Задача 8: список из Set = ")
        var first = true
        for (i in 0 until mutableList.size) {
            if (!first) {
                print(", ")
            }
            print(mutableList[i])
            first = false
        }
        println()
    }
