package mission10

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 10: Lambda & Higher-order Functions")
class LambdaHigherOrderTest {

    @Test
    @DisplayName("Task 1: createAdder")
    fun mission10_createAdder() {
        val addFive = createAdder(5)
        val addTen = createAdder(10)

        assertEquals(15, addFive(10))
        assertEquals(5, addFive(0))
        assertEquals(20, addTen(10))
    }

    @Test
    @DisplayName("Task 2: applyOperation - add")
    fun mission10_applyOperation_add() {
        val result = applyOperation(10, 5) { a, b -> a + b }
        assertEquals(15, result)
    }

    @Test
    @DisplayName("Task 2: applyOperation - multiply")
    fun mission10_applyOperation_multiply() {
        val result = applyOperation(10, 5) { a, b -> a * b }
        assertEquals(50, result)
    }

    @Test
    @DisplayName("Task 3: transformList")
    fun mission10_transformList() {
        val list = listOf(1, 2, 3)
        val doubled = transformList(list) { it * 2 }

        assertEquals(listOf(2, 4, 6), doubled)
    }

    @Test
    @DisplayName("Task 4: filterList")
    fun mission10_filterList() {
        val list = listOf(1, 2, 3, 4, 5)
        val evens = filterList(list) { it % 2 == 0 }

        assertEquals(listOf(2, 4), evens)
    }

    @Test
    @DisplayName("Task 5: sumWithInitial")
    fun mission10_sumWithInitial() {
        val list = listOf(1, 2, 3)

        assertEquals(16, sumWithInitial(list, 10))
        assertEquals(6, sumWithInitial(list, 0))
    }

    @Test
    @DisplayName("Task 5: sumWithInitial - empty list")
    fun mission10_sumWithInitial_empty() {
        assertEquals(10, sumWithInitial(emptyList(), 10))
    }

    @Test
    @DisplayName("Task 6: executeWithCallback")
    fun mission10_executeWithCallback() {
        var receivedValue = 0
        executeWithCallback(42) { receivedValue = it }

        assertEquals(42, receivedValue)
    }

    @Test
    @DisplayName("Task 7: executeIf - true")
    fun mission10_executeIf_true() {
        var executed = false
        executeIf(true) { executed = true }

        assertTrue(executed)
    }

    @Test
    @DisplayName("Task 7: executeIf - false")
    fun mission10_executeIf_false() {
        var executed = false
        executeIf(false) { executed = true }

        assertFalse(executed)
    }

    @Test
    @DisplayName("Task 8: compose")
    fun mission10_compose() {
        val double = { x: Int -> x * 2 }
        val addFive = { x: Int -> x + 5 }

        val composed = compose(double, addFive)

        // double(addFive(5)) = double(10) = 20
        assertEquals(20, composed(5))

        // double(addFive(0)) = double(5) = 10
        assertEquals(10, composed(0))
    }

    @Test
    @DisplayName("Task 9: processNumbers")
    fun mission10_processNumbers() {
        val numbers = listOf(3, 1, 4, 2, 5)
        val result = processNumbers(numbers)

        // 짝수: 4, 2 → 2배: 8, 4 → 정렬: 4, 8
        assertEquals(listOf(4, 8), result)
    }

    @Test
    @DisplayName("Task 9: processNumbers - no evens")
    fun mission10_processNumbers_noEvens() {
        val numbers = listOf(1, 3, 5)
        val result = processNumbers(numbers)

        assertTrue(result.isEmpty())
    }

    @Test
    @DisplayName("Task 10: groupByFirstLetter")
    fun mission10_groupByFirstLetter() {
        val words = listOf("apple", "banana", "apricot", "cherry")
        val grouped = groupByFirstLetter(words)

        assertEquals(listOf("apple", "apricot"), grouped['a'])
        assertEquals(listOf("banana"), grouped['b'])
        assertEquals(listOf("cherry"), grouped['c'])
    }

    @Test
    @DisplayName("Task 10: groupByFirstLetter - empty")
    fun mission10_groupByFirstLetter_empty() {
        val grouped = groupByFirstLetter(emptyList())

        assertTrue(grouped.isEmpty())
    }
}
