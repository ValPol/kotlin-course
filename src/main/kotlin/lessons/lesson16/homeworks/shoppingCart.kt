
class ShoppingCart {
    private val items = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: String, amount: Int) {
        if (amount <= 0) return
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(itemsMap: Map<String, Int>) {
        itemsMap.forEach { (id, amount) ->
            if (amount > 0) {
                items[id] = items.getOrDefault(id, 0) + amount
            }
        }
    }

    fun addToCart(ids: List<String>) {
        ids.forEach { id ->
            addToCart(id)
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.appendLine("=== Корзина товаров ===")
        if (items.isEmpty()) {
            sb.appendLine("Корзина пуста.")
        } else {
            var totalCount = 0
            items.forEach { (id, count) ->
                sb.appendLine("$id: $count шт.")
                totalCount += count
            }
            sb.appendLine("---------------------")
            sb.appendLine("Количество артикулов: ${items.size}")
            sb.appendLine("Общее количество товаров: $totalCount")
        }
        sb.appendLine("=====================")
        return sb.toString()
    }
}