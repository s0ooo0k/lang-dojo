package mission12

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 12: Sealed, Data, Enum Classes")
class SpecialClassesTest {

    @Test
    @DisplayName("Task 1: Direction enum")
    fun mission12_directionEnum() {
        assertEquals(4, Direction.entries.size)
        assertNotNull(Direction.NORTH)
        assertNotNull(Direction.SOUTH)
        assertNotNull(Direction.EAST)
        assertNotNull(Direction.WEST)
    }

    @Test
    @DisplayName("Task 1: getOpposite")
    fun mission12_getOpposite() {
        assertEquals(Direction.SOUTH, getOpposite(Direction.NORTH))
        assertEquals(Direction.NORTH, getOpposite(Direction.SOUTH))
        assertEquals(Direction.WEST, getOpposite(Direction.EAST))
        assertEquals(Direction.EAST, getOpposite(Direction.WEST))
    }

    @Test
    @DisplayName("Task 2: Priority enum")
    fun mission12_priorityEnum() {
        assertEquals(1, Priority.LOW.level)
        assertEquals(2, Priority.MEDIUM.level)
        assertEquals(3, Priority.HIGH.level)
        assertEquals(4, Priority.CRITICAL.level)
    }

    @Test
    @DisplayName("Task 2: getPriorityByLevel")
    fun mission12_getPriorityByLevel() {
        assertEquals(Priority.LOW, getPriorityByLevel(1))
        assertEquals(Priority.HIGH, getPriorityByLevel(3))
        assertNull(getPriorityByLevel(5))
        assertNull(getPriorityByLevel(0))
    }

    @Test
    @DisplayName("Task 3: Operation enum")
    fun mission12_operationEnum() {
        assertEquals(15, Operation.PLUS.apply(10, 5))
        assertEquals(5, Operation.MINUS.apply(10, 5))
        assertEquals(50, Operation.TIMES.apply(10, 5))
        assertEquals(2, Operation.DIVIDE.apply(10, 5))
    }

    @Test
    @DisplayName("Task 4: Book data class")
    fun mission12_bookDataClass() {
        val book = Book(1, "Kotlin", "JetBrains", 39.99)

        assertEquals(1, book.id)
        assertEquals("Kotlin", book.title)
        assertEquals("JetBrains", book.author)
        assertEquals(39.99, book.price)
    }

    @Test
    @DisplayName("Task 4: updateBookPrice")
    fun mission12_updateBookPrice() {
        val book = Book(1, "Kotlin", "JetBrains", 39.99)
        val updated = updateBookPrice(book, 29.99)

        assertEquals(1, updated.id)
        assertEquals("Kotlin", updated.title)
        assertEquals("JetBrains", updated.author)
        assertEquals(29.99, updated.price)

        // 원본 불변
        assertEquals(39.99, book.price)
    }

    @Test
    @DisplayName("Task 5: formatBook")
    fun mission12_formatBook() {
        val book = Book(1, "Kotlin", "JetBrains", 39.99)
        assertEquals("Kotlin by JetBrains", formatBook(book))
    }

    @Test
    @DisplayName("Task 6: Result sealed class - Success")
    fun mission12_resultSuccess() {
        val result = Result.Success(42)
        assertEquals("Value: 42", handleResult(result))
    }

    @Test
    @DisplayName("Task 6: Result sealed class - Failure")
    fun mission12_resultFailure() {
        val result = Result.Failure("Not found")
        assertEquals("Error: Not found", handleResult(result))
    }

    @Test
    @DisplayName("Task 6: Result sealed class - Loading")
    fun mission12_resultLoading() {
        val result = Result.Loading
        assertEquals("Loading...", handleResult(result))
    }

    @Test
    @DisplayName("Task 7: NetworkResponse - Success")
    fun mission12_networkResponseSuccess() {
        val response: NetworkResponse<String> = NetworkResponse.Success("Hello")
        assertEquals("Data: Hello", describeResponse(response))
    }

    @Test
    @DisplayName("Task 7: NetworkResponse - Error")
    fun mission12_networkResponseError() {
        val response: NetworkResponse<String> = NetworkResponse.Error(404, "Not Found")
        assertEquals("Error 404: Not Found", describeResponse(response))
    }

    @Test
    @DisplayName("Task 7: NetworkResponse - Loading")
    fun mission12_networkResponseLoading() {
        val response: NetworkResponse<String> = NetworkResponse.Loading
        assertEquals("Loading...", describeResponse(response))
    }

    @Test
    @DisplayName("Task 8: Day enum")
    fun mission12_dayEnum() {
        assertEquals(7, Day.entries.size)
    }

    @Test
    @DisplayName("Task 8: isWeekend")
    fun mission12_isWeekend() {
        assertTrue(isWeekend(Day.SATURDAY))
        assertTrue(isWeekend(Day.SUNDAY))
        assertFalse(isWeekend(Day.MONDAY))
        assertFalse(isWeekend(Day.FRIDAY))
    }

    @Test
    @DisplayName("Task 8: getDayType")
    fun mission12_getDayType() {
        assertEquals("Weekend", getDayType(Day.SATURDAY))
        assertEquals("Weekend", getDayType(Day.SUNDAY))
        assertEquals("Weekday", getDayType(Day.MONDAY))
        assertEquals("Weekday", getDayType(Day.FRIDAY))
    }
}
