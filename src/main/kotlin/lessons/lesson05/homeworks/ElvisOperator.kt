package lessons.lesson05.homeworks

/**
 * Задача 1
 *
 * Контекст: Вы изучаете физическое явление затухания звука в помещении. У вас есть измеренное значение начальной интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
 * Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания пропорциональна начальной интенсивности, умноженной на коэффициент затухания. Если коэффициент затухания неизвестен, использовать стандартное значение 0.5.
 *
 * Задача 2
 *
 * Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5% от его стоимости. В случае, если стоимость не указана, то берётся стандартная стоимость в $50
 * Задача: Рассчитать полную стоимость доставки.
 *
 * Задача 3
 *
 * Контекст: Вы проводите метеорологические измерения. Одним из важных показателей является атмосферное давление, которое должно быть зафиксировано. Лаборант приносит вам набор показателей, но по пути может что-нибудь потерять. Задача - сообщить об ошибке в случае отсутствия показаний атмосферного давления.
 */
fun main() {
    // ========== Задача 1: Затухание звука ==========
    println("--- Задача 1: Затухание звука ---")

    // Тест 1: коэффициент затухания известен
    val initialIntensity1: Double = 100.0
    val attenuationCoefficient1: Double? = 0.3
    val effectiveCoefficient1 = attenuationCoefficient1 ?: 0.5
    val resultingIntensity1 = initialIntensity1 * effectiveCoefficient1
    println("initialIntensity1 = $initialIntensity1, " +
            "k = $attenuationCoefficient1")
    println("effectiveCoefficient1: $effectiveCoefficient1")
    println("resultingIntensity1: $resultingIntensity1")

    // Тест 2: коэффициент затухания неизвестен (null)
    val initialIntensity2: Double = 100.0
    val attenuationCoefficient2: Double? = null
    val effectiveCoefficient2 = attenuationCoefficient2 ?: 0.5
    val resultingIntensity2 = initialIntensity2 * effectiveCoefficient2
    println("initialIntensity2 = $initialIntensity2, " +
            "k = $attenuationCoefficient2")
    println("effectiveCoefficient2: $effectiveCoefficient2")
    println("resultingIntensity2: $resultingIntensity2")

    // ========== Задача 2: Стоимость доставки ==========
    println("\n--- Задача 2: Стоимость доставки ---")

    // Тест 1: стоимость груза указана
    val deliveryCost1: Double = 200.0
    val cargoValue1: Double? = 1000.0
    val effectiveCargoValue1 = cargoValue1 ?: 50.0
    val insurance1 = effectiveCargoValue1 * 0.005
    val totalCost1 = deliveryCost1 + insurance1
    println("deliveryCost1 = $deliveryCost1, cargoValue1 = $cargoValue1")
    println("effectiveCargoValue1: $effectiveCargoValue1")
    println("insurance1: $insurance1")
    println("totalCost1: $totalCost1")

    // Тест 2: стоимость груза не указана (null)
    val deliveryCost2: Double = 200.0
    val cargoValue2: Double? = null
    val effectiveCargoValue2 = cargoValue2 ?: 50.0
    val insurance2 = effectiveCargoValue2 * 0.005
    val totalCost2 = deliveryCost2 + insurance2
    println("deliveryCost2 = $deliveryCost2, cargoValue2 = $cargoValue2")
    println("effectiveCargoValue2: $effectiveCargoValue2")
    println("insurance2: $insurance2")
    println("totalCost2: $totalCost2")

    // ========== Задача 3: Атмосферное давление ==========
    println("\n--- Задача 3: Атмосферное давление ---")

    // Тест 1: показания есть
    val pressure1: Double? = 1013.25
    val pressureReport1 = pressure1 ?: error("No pressure1 ")
    println("pressureReport1: $pressureReport1 ")

    // Тест 2: показания потеряны (null)
    val pressure2: Double? = null
    val pressureReport2 = pressure2 ?: error("No pressure2")
    println("pressureReport2: $pressureReport2 ")
}
