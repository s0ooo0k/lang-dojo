package mission8

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 8: Extension Functions")
class ExtensionFunctionsTest {

    @Test
    @DisplayName("Task 1: isPalindrome - true cases")
    fun mission8_isPalindrome_true() {
        assertTrue("level".isPalindrome())
        assertTrue("Level".isPalindrome())
        assertTrue("A".isPalindrome())
        assertTrue("aa".isPalindrome())
        assertTrue("Racecar".isPalindrome())
    }

    @Test
    @DisplayName("Task 1: isPalindrome - false cases")
    fun mission8_isPalindrome_false() {
        assertFalse("hello".isPalindrome())
        assertFalse("world".isPalindrome())
        assertFalse("ab".isPalindrome())
    }

    @Test
    @DisplayName("Task 2: digitCount - positive numbers")
    fun mission8_digitCount_positive() {
        assertEquals(3, 123.digitCount())
        assertEquals(1, 0.digitCount())
        assertEquals(5, 12345.digitCount())
    }

    @Test
    @DisplayName("Task 2: digitCount - negative numbers")
    fun mission8_digitCount_negative() {
        assertEquals(3, (-123).digitCount())
        assertEquals(3, (-456).digitCount())
    }

    @Test
    @DisplayName("Task 3: secondOrNull - has second")
    fun mission8_secondOrNull_hasSecond() {
        assertEquals(2, listOf(1, 2, 3).secondOrNull())
        assertEquals("b", listOf("a", "b", "c").secondOrNull())
    }

    @Test
    @DisplayName("Task 3: secondOrNull - no second")
    fun mission8_secondOrNull_noSecond() {
        assertNull(listOf(1).secondOrNull())
        assertNull(emptyList<Int>().secondOrNull())
    }

    @Test
    @DisplayName("Task 4: repeatWithSeparator")
    fun mission8_repeatWithSeparator() {
        assertEquals("Hi-Hi-Hi", "Hi".repeatWithSeparator(3, "-"))
        assertEquals("A, A", "A".repeatWithSeparator(2, ", "))
        assertEquals("X", "X".repeatWithSeparator(1, "-"))
    }

    @Test
    @DisplayName("Task 5: toIntOrDefault - valid")
    fun mission8_toIntOrDefault_valid() {
        assertEquals(123, "123".toIntOrDefault(0))
        assertEquals(-456, "-456".toIntOrDefault(0))
    }

    @Test
    @DisplayName("Task 5: toIntOrDefault - invalid")
    fun mission8_toIntOrDefault_invalid() {
        assertEquals(0, "abc".toIntOrDefault(0))
        assertEquals(-1, "12.34".toIntOrDefault(-1))
        assertEquals(0, null.toIntOrDefault(0))
    }

    @Test
    @DisplayName("Task 6: countBy")
    fun mission8_countBy() {
        assertEquals(2, listOf(1, 2, 3, 4).countBy { it % 2 == 0 })
        assertEquals(3, listOf(1, 2, 3, 4, 5).countBy { it < 4 })
        assertEquals(0, listOf(1, 3, 5).countBy { it % 2 == 0 })
    }

    @Test
    @DisplayName("Task 7: wordCount")
    fun mission8_wordCount() {
        assertEquals(2, "Hello World".wordCount)
        assertEquals(3, "one two three".wordCount)
        assertEquals(1, "single".wordCount)
    }

    @Test
    @DisplayName("Task 7: wordCount - empty")
    fun mission8_wordCount_empty() {
        assertEquals(0, "".wordCount)
    }

    @Test
    @DisplayName("Task 8: isEven")
    fun mission8_isEven() {
        assertTrue(2.isEven)
        assertTrue(0.isEven)
        assertTrue(100.isEven)
        assertFalse(1.isEven)
        assertFalse(3.isEven)
        assertFalse((-1).isEven)
    }
}
