package mission9

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 9: Scope Functions")
class ScopeFunctionsTest {

    @Test
    @DisplayName("Task 1: processName - non-null")
    fun mission9_processName_nonNull() {
        assertEquals("Hello, Alice!", processName("Alice"))
        assertEquals("Hello, Bob!", processName("Bob"))
    }

    @Test
    @DisplayName("Task 1: processName - null")
    fun mission9_processName_null() {
        assertEquals("Hello, Guest!", processName(null))
    }

    @Test
    @DisplayName("Task 2: transformNumber")
    fun mission9_transformNumber() {
        assertEquals("Number: 42", transformNumber(42))
        assertEquals("Number: 0", transformNumber(0))
        assertEquals("Number: -5", transformNumber(-5))
    }

    @Test
    @DisplayName("Task 3: createPerson")
    fun mission9_createPerson() {
        val person = createPerson("Alice", 25, "Seoul")

        assertEquals("Alice", person.name)
        assertEquals(25, person.age)
        assertEquals("Seoul", person.city)
    }

    @Test
    @DisplayName("Task 4: processWithLogging")
    fun mission9_processWithLogging() {
        val logs = mutableListOf<String>()
        val result = processWithLogging("hello") { logs.add(it) }

        assertEquals("HELLO", result)
        assertEquals(2, logs.size)
        assertEquals("hello", logs[0])  // before
        assertEquals("HELLO", logs[1])  // after
    }

    @Test
    @DisplayName("Task 5: calculateArea")
    fun mission9_calculateArea() {
        assertEquals(50, calculateArea(10, 5))
        assertEquals(100, calculateArea(10, 10))
        assertEquals(0, calculateArea(0, 5))
    }

    @Test
    @DisplayName("Task 6: getStringInfo")
    fun mission9_getStringInfo() {
        val info = getStringInfo("Hello")

        assertEquals(5, info.length)
        assertEquals('H', info.firstChar)
        assertEquals('o', info.lastChar)
    }

    @Test
    @DisplayName("Task 6: getStringInfo - empty")
    fun mission9_getStringInfo_empty() {
        val info = getStringInfo("")

        assertEquals(0, info.length)
        assertNull(info.firstChar)
        assertNull(info.lastChar)
    }

    @Test
    @DisplayName("Task 7: buildMessage")
    fun mission9_buildMessage() {
        val result = buildMessage(listOf("Line1", "Line2", "Line3"))

        assertTrue(result.contains("Line1"))
        assertTrue(result.contains("Line2"))
        assertTrue(result.contains("Line3"))
        assertTrue(result.contains("\n"))
    }

    @Test
    @DisplayName("Task 7: buildMessage - empty")
    fun mission9_buildMessage_empty() {
        val result = buildMessage(emptyList())

        assertEquals("", result)
    }

    @Test
    @DisplayName("Task 8: processUser - with user")
    fun mission9_processUser_withUser() {
        val user = User("Alice", 25)
        val result = processUser(user)

        assertEquals("ALICE is 25 years old", result)
    }

    @Test
    @DisplayName("Task 8: processUser - null")
    fun mission9_processUser_null() {
        assertEquals("No user", processUser(null))
    }
}
