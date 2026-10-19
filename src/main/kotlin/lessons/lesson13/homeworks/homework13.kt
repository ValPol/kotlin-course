fun main() {
    // 1. Среднее время выполнения теста
    val testTimes = mapOf(
        "login" to 3,
        "logout" to 2,
        "createUser" to 5,
        "updateProfile" to 4
    )
    println("1. Среднее время: ${averageTestTime(testTimes)} сек")

    // 2. Список всех тестовых методов
    val metaData = mapOf(
        "testLogin" to "auth, smoke",
        "testLogout" to "auth",
        "testCreateUser" to "regression"
    )
    println("2. Методы: ${testMethodsList(metaData)}")

    // 3. Добавить новый тест и его результат
    val mutableResults = mutableMapOf(
        "testA" to "passed",
        "testB" to "failed"
    )
    addTestWithResult(mutableResults, "testC", "skipped")
    println("3. После добавления: $mutableResults")

    // 4. Количество успешных тестов
    val statusResults = mapOf(
        "t1" to "passed",
        "t2" to "passed",
        "t3" to "failed",
        "t4" to "skipped"
    )
    println("4. Успешных: ${countPassedTests(statusResults)}")

    // 5. Удалить запись о баге
    val bugTracking = mutableMapOf(
        "BUG-101" to "open",
        "BUG-102" to "fixed",
        "BUG-103" to "open"
    )
    removeFixedBug(bugTracking, "BUG-102")
    println("5. После удаления: $bugTracking")

    // 6. Сообщение о странице и статусе
    val pageStatuses = mapOf(
        "https://example.com/home" to "200",
        "https://example.com/login" to "404"
    )
    printPageStatuses(pageStatuses)

    // 7. Сервисы с временем ответа выше порога
    val serviceResponseTimes = mapOf(
        "auth" to 120,
        "payment" to 80,
        "catalog" to 200
    )
    val threshold = 100
    println("7. Медленные сервисы: ${slowServices(serviceResponseTimes, threshold)}")

    // 8. Статус endpoint или "not tested"
    val apiStatuses = mapOf(
        "/users" to "200 OK",
        "/orders" to "500 Error"
    )
    val endpointToCheck = "/products"
    println("8. Статус ${endpointToCheck}: ${getApiStatusOrDefault(apiStatuses, endpointToCheck)}")

    // 9. Получить browserType без null
    val envConfig = mapOf(
        "browserType" to "chrome",
        "env" to "stage"
    )
    println("9. Browser type: ${getBrowserType(envConfig)}")

    // 10. Копия неизменяемого словаря + новая версия
    val versions = mapOf(
        "v1.0" to "released",
        "v1.1" to "beta"
    )
    val updatedVersions = addNewVersion(versions, "v1.2", "alpha")
    println("10. Обновлённые версии: $updatedVersions")

    // 11. Настройки устройства или по умолчанию
    val deviceSettings = mapOf(
        "Pixel 9A" to "high_perf",
        "iPhone 15" to "standard"
    )
    val defaultSetting = "low_perf"
    println("11. Для Galaxy S24: ${getDeviceSettingsOrDefault(deviceSettings, "Galaxy S24", defaultSetting)}")

    // 12. Содержит ли словарь код ошибки
    val errors = mapOf(
        "ERR_001" to "timeout",
        "ERR_002" to "connection_refused"
    )
    val errorCodeToCheck = "ERR_001"
    println("12. Ошибка ${errorCodeToCheck} есть: ${containsErrorCode(errors, errorCodeToCheck)}")

    // 13. Отфильтровать по версии в ключе
    val scenarios = mapOf(
        "TestID_1.0" to "Passed",
        "TestID_1.1" to "Failed",
        "TestID_1.1" to "Skipped", // в map ключ уникален, это просто пример
        "TestID_2.0" to "Passed"
    )
    // В реальности дубли ключей быть не может, поэтому используем разные ключи:
    val scenariosReal = mapOf(
        "Login_1.0" to "Passed",
        "Login_1.1" to "Failed",
        "Logout_1.1" to "Skipped",
        "Dashboard_2.0" to "Passed"
    )
    val targetVersion = "1.1"
    println("13. Сценарии версии ${targetVersion}: ${filterByVersion(scenariosReal, targetVersion)}")

    // 14. Есть ли модули с неудачным тестированием
    val moduleResults = mapOf(
        "Auth" to "passed",
        "Payment" to "failed",
        "Catalog" to "passed"
    )
    println("14. Есть неудачные модули: ${hasFailedModules(moduleResults)}")

    // 15. Добавить настройки из другого словаря
    val baseEnv = mutableMapOf(
        "region" to "eu",
        "timeout" to "30s"
    )
    val extraSettings = mapOf(
        "retries" to "3",
        "parallel" to "true"
    )
    mergeTestSettings(baseEnv, extraSettings)
    println("15. Объединённые настройки: $baseEnv")

    // 16. Объединить два неизменяемых словаря с багами
    val bugsA = mapOf("BUG-201" to "critical", "BUG-202" to "medium")
    val bugsB = mapOf("BUG-203" to "low", "BUG-202" to "high") // дубли ключа — победит второй
    val mergedBugs = mergeBugDictionaries(bugsA, bugsB)
    println("16. Объединённые баги: $mergedBugs")

    // 17. Очистить изменяемый словарь
    val tempRunData = mutableMapOf(
        "lastRun" to "2025-01-01",
        "duration" to "120s"
    )
    clearTempData(tempRunData)
    println("17. После очистки: $tempRunData")

    // 18. Исключить skipped из отчёта
    val reportWithSkipped = mapOf(
        "T1" to "passed",
        "T2" to "skipped",
        "T3" to "failed"
    )
    val filteredReport = removeSkippedTests(reportWithSkipped)
    println("18. Отчёт без skipped: $filteredReport")

    // 19. Копия словаря с удалением нескольких конфигураций
    val configs = mapOf(
        "debug" to "on",
        "logLevel" to "info",
        "retryCount" to "3"
    )
    val keysToRemove = listOf("logLevel", "retryCount")
    val reducedConfigs = copyWithoutKeys(configs, keysToRemove)
    println("19. Конфигурации без ключей: $reducedConfigs")

    // 20. Отчёт в виде списка строк
    val resultsForReport = mapOf(
        "ID-001" to "Passed",
        "ID-002" to "Failed"
    )
    println("20. Отчёт: ${generateReport(resultsForReport)}")

    // 21. Преобразовать mutable в immutable для архивации
    val lastRunResults = mutableMapOf(
        "A" to "passed",
        "B" to "failed"
    )
    val archived = archiveResults(lastRunResults)
    println("21. Архив: $archived (тип: ${archived::class.simpleName})")

    // 22. Заменить числовые ID на строковые
    val intIdResults = mapOf(
        1 to 120L,
        2 to 90L,
        3 to 150L
    )
    val stringIdResults = convertIdsToString(intIdResults)
    println("22. С строковыми ID: $stringIdResults")

    // 23. Увеличить все оценки на 10%
    val perfScores = mapOf(
        "v1.0" to 100.0,
        "v1.1" to 120.0,
        "v2.0" to 95.0
    )
    println("23. Скорректированные оценки: ${increaseByTenPercent(perfScores)}")

    // 24. Проверить, пуст ли словарь с ошибками компиляции
    val compileErrorsEmpty = emptyMap<String, String>()
    println("24. Словарь ошибок пуст: ${isEmptyCompileErrors(compileErrorsEmpty)}")

    // 25. Убедиться, что словарь с результатами нагрузочного тестирования не пуст
    val loadTestResults = mapOf("run-1" to "ok", "run-2" to "degraded")
    println("25. Словарь не пуст: ${isNotEmptyLoadTest(loadTestResults)}")

    // 26. Все ли тесты прошли успешно
    val allPassedMap = mapOf("t1" to "passed", "t2" to "passed")
    println("26. Все тесты успешны: ${allTestsPassed(allPassedMap)}")

    // 27. Содержит ли словарь хотя бы одну ошибку
    val hasErrorMap = mapOf("t1" to "passed", "t2" to "failed")
    println("27. Есть хотя бы одна ошибка: ${anyTestFailed(hasErrorMap)}")

    // 28. Отфильтровать неудачные тесты с "optional" в названии
    val optionalTests = mapOf(
        "optional_auth" to "failed",
        "optional_payment" to "passed",
        "core_login" to "failed",
        "optional_dashboard" to "failed"
    )
    println("28. Неудачные optional-тесты: ${filterOptionalFailed(optionalTests)}")
}

// 1. Среднее время
fun averageTestTime(times: Map<String, Int>): Double {
    if (times.isEmpty()) return 0.0
    return times.values.average()
}

// 2. Список всех методов (keys)
fun testMethodsList(meta: Map<String, String>): List<String> = meta.keys.toList()

// 3. Добавить тест и результат (put)
fun addTestWithResult(results: MutableMap<String, String>, testName: String, status: String) {
    results.put(testName, status)
}

// 4. Количество успешных (filter + count)
fun countPassedTests(results: Map<String, String>): Int =
    results.filter { it.value == "passed" }.count()

// 5. Удалить баг (remove)
fun removeFixedBug(bugs: MutableMap<String, String>, bugId: String) {
    bugs.remove(bugId)
}

// 6. Вывести страницу и статус (forEach)
fun printPageStatuses(pages: Map<String, String>) {
    pages.forEach { (url, status) ->
        println("Страница $url — статус: $status")
    }
}

// 7. Медленные сервисы (filter)
fun slowServices(services: Map<String, Int>, threshold: Int): Map<String, Int> =
    services.filter { it.value > threshold }

// 8. Статус или "not tested" (getOrElse)
fun getApiStatusOrDefault(statuses: Map<String, String>, endpoint: String): String =
    statuses.getOrElse(endpoint) { "not tested" }

// 9. browserType, не может быть null (getValue — выбрасывает, если нет; здесь предполагаем, что ключ есть)
fun getBrowserType(config: Map<String, String>): String = config.getValue("browserType")

// 10. Копия + новая версия (plus)
fun addNewVersion(versions: Map<String, String>, newKey: String, newValue: String): Map<String, String> =
    versions + (newKey to newValue)

// 11. Получить настройки или дефолт (getOrDefault)
fun getDeviceSettingsOrDefault(settings: Map<String, String>, device: String, default: String): String =
    settings.getOrDefault(device, default)

// 12. Содержит ли код ошибки (containsKey)
fun containsErrorCode(errors: Map<String, String>, code: String): Boolean =
    errors.containsKey(code)

// 13. Фильтр по версии в ключе (filterKeys)
fun filterByVersion(scenarios: Map<String, String>, version: String): Map<String, String> =
    scenarios.filterKeys { it.endsWith(version) }

// 14. Есть ли неудачные модули (any)
fun hasFailedModules(modules: Map<String, String>): Boolean =
    modules.any { it.value != "passed" }

// 15. Объединить настройки (putAll)
fun mergeTestSettings(target: MutableMap<String, String>, source: Map<String, String>) {
    target.putAll(source)
}

// 16. Объединить два словаря (toMap через plus, но явно через map + plus)
fun mergeBugDictionaries(a: Map<String, String>, b: Map<String, String>): Map<String, String> =
    a + b

// 17. Очистить словарь (clear)
fun clearTempData(data: MutableMap<String, String>) {
    data.clear()
}

// 18. Исключить skipped (filterValues)
fun removeSkippedTests(report: Map<String, String>): Map<String, String> =
    report.filterValues { it != "skipped" }

// 19. Копия без ключей (minus)
fun copyWithoutKeys(map: Map<String, Any>, keysToRemove: List<String>): Map<String, Any> =
    map - keysToRemove

// 20. Преобразовать в отчёт-список (map)
fun generateReport(results: Map<String, String>): List<String> =
    results.map { (id, status) -> "Test ID: $id — $status" }

// 21. Mutable -> Immutable (toMap)
fun archiveResults(results: MutableMap<String, String>): Map<String, String> = results.toMap()

// 22. ID из Int в String (mapKeys)
fun convertIdsToString(map: Map<Int, Long>): Map<String, Long> =
    map.mapKeys { it.key.toString() }

// 23. Увеличить каждую оценку на 10% (mapValues)
fun increaseByTenPercent(scores: Map<String, Double>): Map<String, Double> =
    scores.mapValues { it.value * 1.1 }

// 24. Пуст ли словарь (isEmpty)
fun isEmptyCompileErrors(errors: Map<String, String>): Boolean = errors.isEmpty()

// 25. Не пуст ли словарь (isNotEmpty)
fun isNotEmptyLoadTest(results: Map<String, String>): Boolean = results.isNotEmpty()

// 26. Все ли прошли успешно (all)
fun allTestsPassed(results: Map<String, String>): Boolean =
    results.all { it.value == "passed" }

// 27. Хотя бы одна ошибка (any)
fun anyTestFailed(results: Map<String, String>): Boolean =
    results.any { it.value == "failed" }

// 28. Фильтр: failed и содержит "optional" (filter + условие)
fun filterOptionalFailed(tests: Map<String, String>): Map<String, String> =
    tests.filter { (name, status) -> name.contains("optional") && status == "failed" }
