import java.io.InputStream
interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}
// ---------- Задача 1. Абстрактные классы устройств (методы не реализуем) ----------
// Префикс Abstract — чтобы имена не пересекались с конкретными классами из задачи 5

abstract class AbstractFridge : Powerable, Openable, TemperatureRegulatable,
    AutomaticShutdown, LightEmitting

abstract class AbstractWashingMachine : Powerable, Openable, TemperatureRegulatable,
    WaterConnection, Drainable, Timable, Programmable

abstract class AbstractSmartLamp : Powerable, LightEmitting, SoundEmitting, Programmable

abstract class AbstractElectronicClock : Powerable, BatteryOperated, Timable,
    SoundEmitting, Programmable

abstract class AbstractRobotVacuum : Powerable, Movable, Rechargeable,
    BatteryOperated, Programmable, SoundEmitting

abstract class AbstractMechanicalClock : Mechanical, Timable

abstract class AbstractFlashlight : Powerable, BatteryOperated, LightEmitting

abstract class AbstractCoffeeMachine : Powerable, TemperatureRegulatable,
    WaterConnection, Programmable

abstract class AbstractSmartSpeaker : Powerable, SoundEmitting, Programmable, LightEmitting


// ---------- Задача 2. Абстрактный класс включаемого оборудования ----------

abstract class PowerableEquipment : Powerable {
    protected var isPoweredOn = false

    override fun powerOn() {
        isPoweredOn = true
        println("Устройство включено")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Устройство выключено")
    }
}


// ---------- Задача 3. Абстрактный класс программируемого оборудования ----------

abstract class ProgrammableEquipment : PowerableEquipment(), Programmable {
    override fun programAction(action: String) {
        println("Задано действие: $action")
    }

    override fun execute() {
        println("Выполняем запрограммированное действие")
    }
}


// ---------- Задача 4. Класс с температурой и открыванием ----------

abstract class ThermalOpenableEquipment : ProgrammableEquipment(),
    TemperatureRegulatable, Openable {

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("Нельзя установить температуру: устройство выключено")
            return
        }
        println("Установлена температура $temp градусов")
    }

    override fun open() {
        if (!isPoweredOn) {
            println("Нельзя открыть: устройство выключено")
            return
        }
        println("Устройство открыто")
    }

    override fun close() = println("Устройство закрыто")

    // Переопределяем программирование, чтобы режим нельзя было задать при выключенном питании
    override fun programAction(action: String) {
        if (!isPoweredOn) {
            println("Нельзя задать режим: устройство выключено")
            return
        }
        super.programAction(action)
    }
}


// ---------- Задача 5. Конкретные устройства ----------

class Fridge(override val maxTemperature: Int) : ThermalOpenableEquipment(), AutomaticShutdown, LightEmitting {
    override val sensorType = "датчик открытия двери"
    override val maxSensoredValue = 1

    override fun startMonitoring() {
        if (!isPoweredOn) {
            println("Мониторинг невозможен: холодильник выключен")
            return
        }
        println("Следим за датчиком: $sensorType")
    }

    override fun emitLight() {
        if (!isPoweredOn) {
            println("Внутренний свет не работает: холодильник выключен")
            return
        }
        println("Внутри холодильника загорелся свет")
    }

    override fun completeLiteEmission() = println("Внутренний свет погас")
}

class WashingMachine(override val maxTemperature: Int) : ThermalOpenableEquipment(), WaterConnection, Drainable, Timable {
    override fun connectToWaterSupply() {
        if (!isPoweredOn) {
            println("Подключение к воде невозможно: стиральная машина выключена")
            return
        }
        println("Подключены к водопроводу")
    }

    override fun getWater(amount: Int) {
        if (!isPoweredOn) {
            println("Набор воды невозможен: стиральная машина выключена")
            return
        }
        println("Набрали $amount мл воды")
    }

    override fun connectToDrain() {
        if (!isPoweredOn) {
            println("Подключение к сливу невозможно: стиральная машина выключена")
            return
        }
        println("Подключены к сливу")
    }

    override fun drain() {
        if (!isPoweredOn) {
            println("Слив невозможен: стиральная машина выключена")
            return
        }
        println("Сливаем воду")
    }

    override fun setTimer(time: Int) {
        if (!isPoweredOn) {
            println("Нельзя установить таймер: стиральная машина выключена")
            return
        }
        println("Таймер установлен на $time минут")
    }
}

class Kettle(override val maxTemperature: Int) : ThermalOpenableEquipment(), WaterConnection, AutomaticShutdown {
    override val sensorType = "датчик температуры кипения"
    override val maxSensoredValue = 100

    override fun connectToWaterSupply() {
        if (!isPoweredOn) {
            println("Нельзя набрать воду: чайник выключен")
            return
        }
        println("Набрали воду из крана")
    }

    override fun getWater(amount: Int) {
        if (!isPoweredOn) {
            println("Нельзя налить воду: чайник выключен")
            return
        }
        println("Налили $amount мл воды")
    }

    override fun startMonitoring() {
        if (!isPoweredOn) {
            println("Мониторинг невозможен: чайник выключен")
            return
        }
        println("Следим за датчиком: $sensorType (до $maxSensoredValue градусов)")
    }
}

class Oven(override val maxTemperature: Int) : ThermalOpenableEquipment(), Timable, SoundEmitting {
    override fun setTimer(time: Int) {
        if (!isPoweredOn) {
            println("Нельзя установить таймер: духовка выключена")
            return
        }
        println("Таймер установлен на $time минут")
    }

    override fun setVolume(volume: Int) {
        println("Громкость сигнала: $volume")
    }

    override fun mute() = println("Звук выключен")

    override fun playSound(stream: InputStream) = println("Проигрываем сигнал готовности")
}


// ---------- Запуск устройств ----------

fun main() {
    println("--- Холодильник ---")
    val fridge = Fridge(6)
    fridge.setTemperature(4)      // выключен — проверка сработает
    fridge.powerOn()
    fridge.setTemperature(4)
    fridge.open()
    fridge.startMonitoring()
    fridge.emitLight()
    fridge.close()
    fridge.powerOff()

    println("\n--- Стиральная машина ---")
    val washingMachine = WashingMachine(100)
    washingMachine.powerOn()
    washingMachine.open()
    washingMachine.connectToWaterSupply()
    washingMachine.getWater(5000)
    washingMachine.programAction("Стирка хлопок 60 градусов")
    washingMachine.setTimer(90)
    washingMachine.execute()
    washingMachine.drain()
    washingMachine.close()
    washingMachine.powerOff()
    washingMachine.programAction("Отжим") // выключена — проверка сработает

    println("\n--- Чайник ---")
    val kettle = Kettle(100)
    kettle.powerOn()
    kettle.setTemperature(100)
    kettle.connectToWaterSupply()
    kettle.getWater(1500)
    kettle.startMonitoring()
    kettle.powerOff()

    println("\n--- Духовка ---")
    val oven = Oven(300)
    oven.powerOn()
    oven.open()
    oven.setTemperature(220)
    oven.programAction("Режим выпечки")
    oven.setTimer(40)
    oven.execute()
    oven.close()
    oven.powerOff()
}