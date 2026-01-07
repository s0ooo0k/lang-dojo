package mission7

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 7: Null Safety")
class NullSafetyTest {

    @Test
    @DisplayName("Task 1: getLength - non-null")
    fun mission7_getLength_nonNull() {
        assertEquals(5, getLength("Hello"))
        assertEquals(0, getLength(""))
    }

    @Test
    @DisplayName("Task 1: getLength - null")
    fun mission7_getLength_null() {
        assertEquals(0, getLength(null))
    }

    @Test
    @DisplayName("Task 2: getOrDefault - non-null")
    fun mission7_getOrDefault_nonNull() {
        assertEquals("Hello", getOrDefault("Hello", "Default"))
    }

    @Test
    @DisplayName("Task 2: getOrDefault - null")
    fun mission7_getOrDefault_null() {
        assertEquals("Default", getOrDefault(null, "Default"))
    }

    @Test
    @DisplayName("Task 3: safeUpperCase - non-null")
    fun mission7_safeUpperCase_nonNull() {
        assertEquals("HELLO", safeUpperCase("hello"))
        assertEquals("WORLD", safeUpperCase("World"))
    }

    @Test
    @DisplayName("Task 3: safeUpperCase - null")
    fun mission7_safeUpperCase_null() {
        assertNull(safeUpperCase(null))
    }

    @Test
    @DisplayName("Task 4: getUserName - user with name")
    fun mission7_getUserName_withName() {
        val user = User("Alice", "alice@email.com")
        assertEquals("Alice", getUserName(user))
    }

    @Test
    @DisplayName("Task 4: getUserName - user with null name")
    fun mission7_getUserName_nullName() {
        val user = User(null, "anonymous@email.com")
        assertEquals("Anonymous", getUserName(user))
    }

    @Test
    @DisplayName("Task 4: getUserName - null user")
    fun mission7_getUserName_nullUser() {
        assertEquals("Guest", getUserName(null))
    }

    @Test
    @DisplayName("Task 5: getFirstChar - non-empty")
    fun mission7_getFirstChar_nonEmpty() {
        assertEquals('H', getFirstChar("Hello"))
        assertEquals('A', getFirstChar("ABC"))
    }

    @Test
    @DisplayName("Task 5: getFirstChar - empty or null")
    fun mission7_getFirstChar_emptyOrNull() {
        assertNull(getFirstChar(""))
        assertNull(getFirstChar(null))
    }

    @Test
    @DisplayName("Task 6: filterNulls")
    fun mission7_filterNulls() {
        val list = listOf("A", null, "B", null, "C")
        val result = filterNulls(list)

        assertEquals(listOf("A", "B", "C"), result)
    }

    @Test
    @DisplayName("Task 6: filterNulls - all nulls")
    fun mission7_filterNulls_allNulls() {
        val list = listOf<String?>(null, null, null)
        val result = filterNulls(list)

        assertTrue(result.isEmpty())
    }

    @Test
    @DisplayName("Task 7: parseIntOrNull - valid number")
    fun mission7_parseIntOrNull_valid() {
        assertEquals(123, parseIntOrNull("123"))
        assertEquals(-456, parseIntOrNull("-456"))
        assertEquals(0, parseIntOrNull("0"))
    }

    @Test
    @DisplayName("Task 7: parseIntOrNull - invalid")
    fun mission7_parseIntOrNull_invalid() {
        assertNull(parseIntOrNull("abc"))
        assertNull(parseIntOrNull("12.34"))
        assertNull(parseIntOrNull(null))
    }

    @Test
    @DisplayName("Task 8: getAddressCity - all present")
    fun mission7_getAddressCity_allPresent() {
        val address = Address("Seoul", "12345")
        val person = Person("Kim", address)

        assertEquals("Seoul", getAddressCity(person))
    }

    @Test
    @DisplayName("Task 8: getAddressCity - null city")
    fun mission7_getAddressCity_nullCity() {
        val address = Address(null, "12345")
        val person = Person("Kim", address)

        assertEquals("Unknown", getAddressCity(person))
    }

    @Test
    @DisplayName("Task 8: getAddressCity - null address")
    fun mission7_getAddressCity_nullAddress() {
        val person = Person("Kim", null)

        assertEquals("Unknown", getAddressCity(person))
    }

    @Test
    @DisplayName("Task 8: getAddressCity - null person")
    fun mission7_getAddressCity_nullPerson() {
        assertEquals("Unknown", getAddressCity(null))
    }
}
