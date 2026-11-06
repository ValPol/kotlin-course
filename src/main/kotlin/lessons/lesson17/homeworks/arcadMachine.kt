/**
 * Игровой автомат
 * Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)
 *
 * Поля:
 *
 * цвет
 * модель
 * включен
 * ОС загружена
 * список установленных игр
 * наличие джойстика
 * баланс вырученных средств
 * владелец
 * телефон поддержки.
 * игровой сеанс оплачен
 * стоимость одного игрового сеанса
 * пин-код автомата
 * Методы:
 *
 * включить
 * выключить
 * загрузить ОС
 * завершить работу ОС
 * показать список игр
 * включить игру
 * оплатить игровой сеанс
 * забрать наличные с помощью пин-кода
 * открыть сейф и выдать наличные
 */


package lessons.lesson17.homeworks

class ArcadeMachine(
    val model: String,
    var color: String,
    val hasJoystick: Boolean,
    var owner: String,
    val supportPhone: String,
    var sessionCost: Int
) {
    private var isPoweredOn: Boolean = false
    private var osLoaded: Boolean = false
    private var sessionPaid: Boolean = false
    private var revenueBalance: Int = 0
    private val pinCode: String

    private val installedGames: MutableList<String> = mutableListOf()

    init {
        pinCode = generatePin()
    }

    fun turnOn() {
        if (!osLoaded) loadOS()
        isPoweredOn = true
    }

    fun turnOff() {
        isPoweredOn = false
    }

    fun loadOS() {
        osLoaded = true
    }

    fun shutDownOS() {
        osLoaded = false
    }

    fun showInstalledGames(): List<String> {
        return installedGames.toList()
    }

    fun startGame(gameName: String): Boolean {
        if (!isPoweredOn || !sessionPaid) return false
        if (gameName !in installedGames) return false
        sessionPaid = false
        return true
    }

    fun payForSession(amount: Int): Boolean {
        if (amount < sessionCost) return false
        sessionPaid = true
        revenueBalance += amount
        return true
    }

    fun withdrawCash(enteredPin: String): Int {
        if (enteredPin != pinCode) return 0
        return openSafeAndDispenseCash()
    }

    private fun openSafeAndDispenseCash(): Int {
        val dispensed = revenueBalance
        revenueBalance = 0
        return dispensed
    }

    private fun generatePin(): String {
        return (1000..9999).random().toString()
    }
}
