
fun main() {
    // Party
    val party = Party("Клуб «Космос»", 42)
    party.details()

    // Emotion
    val joy = Emotion("радость", 8)
    joy.express()

    // Moon
    Moon.isVisible = true
    Moon.phase = "Full Moon"
    Moon.showPhase()

    // Product
    val milk = Product("Молоко", 99.9, 10)
    println(milk)

    // Concert
    val concert = Concert("The Rolling Stones", "Stadium Arena", 5000.0, 1000)
    concert.printInfo()
    println("Билет куплен: ${concert.buyTicket()}")
    concert.printInfo()

    // Rack & Shelf
    val rack = Rack(maxShelves = 3)
    val shelf1 = Shelf(capacity = 10) // макс. сумма букв = 10
    val shelf2 = Shelf(capacity = 15)
    rack.addShelf(shelf1)
    rack.addShelf(shelf2)

    rack.addItem("Чай")       // длина 3
    rack.addItem("Кофе")      // длина 4
    rack.addItem("Шоколад")   // длина 7
    rack.printContents()

    println("Содержит 'Кофе': ${rack.containsItem("Кофе")}")
    rack.removeItem("Кофе")
    println("Содержит 'Кофе' после удаления: ${rack.containsItem("Кофе")}")

    val shelf3 = Shelf(20)
    rack.addShelf(shelf3)

    // advancedRemoveShelf: удаляем первую полку и перераспределяем
    val failed = rack.advancedRemoveShelf(0)
    println("Не удалось разместить предметы: $failed")
    rack.printContents()
}