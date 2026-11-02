open class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        // Жёлтый текст на чёрном фоне
        println("\u001B[33;40mBark\u001B[0m")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        // Зелёный текст на чёрном фоне
        println("\u001B[32;40mMeow\u001B[0m")
    }
}

class Bird : Animal() {
    override fun makeSound() {
        // Голубой текст на чёрном фоне
        println("\u001B[36;40mTweet\u001B[0m")
    }
}

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird())
    animals.forEach { it.makeSound() }
}