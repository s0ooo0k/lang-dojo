package mission14

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 14: Generics")
class GenericsTest {

    @Test
    @DisplayName("Task 1: Container getValue")
    fun mission14_containerGetValue() {
        val container = Container("Hello")
        assertEquals("Hello", container.getValue())
    }

    @Test
    @DisplayName("Task 1: Container map")
    fun mission14_containerMap() {
        val container = Container("Hello")
        val mapped = container.map { it.length }

        assertEquals(5, mapped.getValue())
    }

    @Test
    @DisplayName("Task 2: swap")
    fun mission14_swap() {
        val list = mutableListOf(1, 2, 3)
        swap(list, 0, 2)

        assertEquals(listOf(3, 2, 1), list)
    }

    @Test
    @DisplayName("Task 2: firstOrDefault - not empty")
    fun mission14_firstOrDefault_notEmpty() {
        val list = listOf(1, 2, 3)
        assertEquals(1, firstOrDefault(list, 0))
    }

    @Test
    @DisplayName("Task 2: firstOrDefault - empty")
    fun mission14_firstOrDefault_empty() {
        val list = emptyList<Int>()
        assertEquals(0, firstOrDefault(list, 0))
    }

    @Test
    @DisplayName("Task 3: findMax")
    fun mission14_findMax() {
        assertEquals(5, findMax(listOf(3, 1, 4, 1, 5)))
        assertEquals("z", findMax(listOf("a", "z", "m")))
    }

    @Test
    @DisplayName("Task 3: findMax - empty")
    fun mission14_findMax_empty() {
        assertNull(findMax(emptyList<Int>()))
    }

    @Test
    @DisplayName("Task 3: sumNumbers")
    fun mission14_sumNumbers() {
        assertEquals(6.0, sumNumbers(listOf(1, 2, 3)))
        assertEquals(7.5, sumNumbers(listOf(1.5, 2.5, 3.5)))
    }

    @Test
    @DisplayName("Task 4: ReadOnlyBox")
    fun mission14_readOnlyBox() {
        val box = ReadOnlyBox("Hello")
        assertEquals("Hello", box.get())
    }

    @Test
    @DisplayName("Task 4: copyAll")
    fun mission14_copyAll() {
        val box = ReadOnlyBox(42)
        assertEquals(42, copyAll(box))
    }

    @Test
    @DisplayName("Task 5: StringWriter")
    fun mission14_stringWriter() {
        val writer = StringWriter()
        writer.write("Hello")
        writer.write("World")

        assertEquals(listOf("Hello", "World"), writer.written)
    }

    @Test
    @DisplayName("Task 6: Pair swap")
    fun mission14_pairSwap() {
        val pair = Pair(1, "a")
        val swapped = pair.swap()

        assertEquals("a", swapped.first)
        assertEquals(1, swapped.second)
    }

    @Test
    @DisplayName("Task 6: Pair toList")
    fun mission14_pairToList() {
        val pair = Pair(1, "a")
        val list = pair.toList()

        assertEquals(listOf<Any?>(1, "a"), list)
    }

    @Test
    @DisplayName("Task 7: InMemoryRepository save and find")
    fun mission14_repositorySaveFind() {
        val repo = InMemoryRepository<String>()

        val id = repo.save("Hello")
        assertEquals("Hello", repo.findById(id))
    }

    @Test
    @DisplayName("Task 7: InMemoryRepository findById not found")
    fun mission14_repositoryFindNotFound() {
        val repo = InMemoryRepository<String>()

        assertNull(repo.findById(999))
    }

    @Test
    @DisplayName("Task 7: InMemoryRepository delete")
    fun mission14_repositoryDelete() {
        val repo = InMemoryRepository<String>()

        val id = repo.save("Hello")
        assertTrue(repo.deleteById(id))
        assertNull(repo.findById(id))
        assertFalse(repo.deleteById(id))  // 이미 삭제됨
    }

    @Test
    @DisplayName("Task 8: filterByType")
    fun mission14_filterByType() {
        val list: List<Any> = listOf(1, "a", 2, "b", 3)

        val strings = filterByType<String>(list)
        val ints = filterByType<Int>(list)

        assertEquals(listOf("a", "b"), strings)
        assertEquals(listOf(1, 2, 3), ints)
    }

    @Test
    @DisplayName("Task 8: isType")
    fun mission14_isType() {
        assertTrue(isType<String>("Hello"))
        assertFalse(isType<Int>("Hello"))
        assertTrue(isType<Int>(42))
    }
}
