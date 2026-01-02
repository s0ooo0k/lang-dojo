package mission1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloTest {
    @Test
    fun `mission_1_hello_world_output`() {
        val result = hello()
        assertEquals("Hello World", result)
    }
}
