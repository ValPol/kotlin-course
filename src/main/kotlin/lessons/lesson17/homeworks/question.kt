/**abstract class BaseClass(
    /* 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass.
       ОТВЕТ 1: само private-поле BaseClass из main() недоступно. В main() читается
       другое свойство — public val privateVal, объявленное в конструкторе ChildrenClass.
       Оно «затеняет» (shadowing) родительское: в наследнике любое обращение к privateVal
       идёт к своему свойству, а в BaseClass внутри getAll() — к приватному родительскому. */
    private val privateVal: String,

    /* 2. объясни, почему это поле недоступно в main().
       ОТВЕТ 2: protected-поля видны только внутри класса и его наследников.
       В ChildrenClass protectedVal объявлен без val/var — это просто параметр конструктора,
       который передаётся в super. Своего свойства у наследника нет, а родительское
       protected-поле из main() не видно. */
    protected val protectedVal: String,

    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"

    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    /* ОТВЕТ 6: сделать это нельзя. private-члены не наследуются и не видны даже наследнику,
       поэтому ChildrenClass физически не может обращаться к privateField. Единственный способ —
       добавить public-сеттер в BaseClass, но он доработке не подлежит. Поле изменится только
       изнутри самого BaseClass (как это делает getAll(), который его читает). */

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    /* 7. объясни, почему эта функция не может быть публичной.
       ОТВЕТ 7: она возвращает ProtectedClass — вложенный protected-класс. В Kotlin видимость
       возвращаемого типа не может быть «уже», чем видимость самой функции: public-функция,
       открывающая protected-тип, не скомпилируется («public function exposes its protected
       return type»). Снаружи нельзя было бы даже описать результат. */
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    /* 8. распечатай getAll() и объясни, почему в поле "generate" другой текст.
       ОТВЕТ 8: внутри getAll() вызов generate() — виртуальный (динамическая диспетчеризация).
       Kotlin смотрит на фактический тип объекта (ChildrenClass) и берёт override-версию,
       поэтому в мапе окажется «Это генерация из дочернего класса», а не родительский текст. */
    open fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    /* 9. объясни, почему эта функция не может быть публичной или protected.
       ОТВЕТ 9: аналогично пункту 7, но ещё жёстче — она возвращает PrivateClass, который
       виден только внутри BaseClass. Ни public, ни protected функция не может наружу
       выставлять private-тип: вызывать её (или использовать результат) вне BaseClass
       всё равно было бы нельзя, компилятор это запрещает. */
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}


class ChildrenClass(
    /* ответ 10: сам publicVal здесь — не поле, а просто параметр конструктора (нет val/var).
       Но он передаётся в конструктор BaseClass, где объявлен как public val publicVal.
       В main() доступен именно этот унаследованный public-свойство базового класса:
       instance.publicVal — это свойство BaseClass, а не параметр наследника. */
    val privateVal: String,
    protectedVal: String,
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    /* ответ 4: доработка, ради которой пункт 3 заработает. Родительский сеттер publicField
       проверяет значение через verifyPublicField() и отбрасывает всё длиннее 3 символов —
       «Антонио Бандерас» туда не пролезал бы. Функция open, поэтому переопределяем её здесь. */
    override fun verifyPublicField(value: String): Boolean = true

    /* ответ 5: публичная обёртка. protected-поле невидимо из main(), но доступно наследнику,
       поэтому меняем его через публичный метод класса-наследника.
       Имя changeProtectedField, а не setProtectedField: для protectedField родитель
       уже сгенерировал JVM-сеттер с таким именем, и одноимённая функция вызвала бы
       ошибку Accidental override. */
    fun changeProtectedField(value: String) {
        protectedField = value
    }

    /* ответ 11: функция getAll() объявлена в BaseClass как public, а public-члены
       наследуются. Вызов child.getAll() из main() — это унаследованный метод, его
       не нужно переопределять или объявлять в ChildrenClass. */

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    /* ответ 12: при вызове child.printText() напечатается «Печать из класса BaseClass».
       Переопределения не происходит, потому что private-методы не виртуальные:
       вызов privatePrint() внутри BaseClass разрешается статически на этапе компиляции.
       privatePrint() в ChildrenClass — независимый новый метод, никак не связанный
       с родительским. */

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}

    /* ОТВЕТ 4: доработка, ради которой пункт 3 заработает. Родительский сеттер publicField
       проверяет значение через verifyPublicField() и отбрасывает всё длиннее 3 символов —
       «Антонио Бандерас» туда не пролезал бы. Функция open, поэтому переопределяем её здесь. */
    override fun verifyPublicField(value: String): Boolean = true

    /* ОТВЕТ 5: публичный сеттер-обёртка. protected-поле невидимо из main(), но виден
       наследнику, поэтому меняем его через публичный метод класса-наследника. */
    fun setProtectedField(value: String) {
        protectedField = value
    }

    /* ОТВЕТ 11: функция getAll() объявлена в BaseClass как public, а public-члены
       наследуются. Вызов child.getAll() из main() — это унаследованный метод, его
       не нужно переопределять или объявлять в ChildrenClass. */

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    /* ОТВЕТ 12: при вызове child.printText() напечатается «Печать из класса BaseClass».
       Переопределения не происходит, потому что private-методы не виртуальные:
       вызов privatePrint() внутри BaseClass разрешается статически на этапе компиляции.
       privatePrint() в ChildrenClass — это независимый новый метод, никак не связанный
       с родительским; он даже не помечен override (и не может быть им). */

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}

/*fun main() {
    val child = ChildrenClass(
        privateVal = "значение от main",
        protectedVal = "protected",
        publicVal = "public"
    )

    // 3+4: теперь присваивание проходит — переопределённый verifyPublicField пропускает значение
    child.publicField = "Антонио Бандерас"

    // 5: меняем protected-поле через сеттер наследника
    child.setProtectedField("Защищённое поле изменено из main()")

    println(child.getAll())
    child.printText()

    // Проверка пунктов 1 и 10
    println("privateVal (свойство наследника): ${child.privateVal}")
    println("publicVal (унаследованное свойство): ${child.publicVal}")
}
*/