package mission5

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 5: Collections")
class CollectionsTest {

    @Test
    @DisplayName("Task 1: 과일 목록 만들기")
    fun mission5_createFruitList() {
        val result = createFruitList()

        assertEquals(3, result.size)
        assertEquals("Apple", result[0])
        assertEquals("Banana", result[1])
        assertEquals("Cherry", result[2])
    }

    @Test
    @DisplayName("Task 2: 리스트 첫 번째와 마지막 요소")
    fun mission5_getFirstAndLast() {
        val list = listOf("Apple", "Banana", "Cherry")
        val result = getFirstAndLast(list)

        assertEquals(Pair("Apple", "Cherry"), result)
    }

    @Test
    @DisplayName("Task 2: 단일 요소 리스트")
    fun mission5_getFirstAndLast_singleElement() {
        val list = listOf("Only")
        val result = getFirstAndLast(list)

        assertEquals(Pair("Only", "Only"), result)
    }

    @Test
    @DisplayName("Task 3: 중복 제거")
    fun mission5_removeDuplicates() {
        val list = listOf(1, 2, 2, 3, 3, 3)
        val result = removeDuplicates(list)

        assertEquals(setOf(1, 2, 3), result)
    }

    @Test
    @DisplayName("Task 3: 중복 없는 리스트")
    fun mission5_removeDuplicates_noDuplicates() {
        val list = listOf(1, 2, 3)
        val result = removeDuplicates(list)

        assertEquals(setOf(1, 2, 3), result)
    }

    @Test
    @DisplayName("Task 4: 학생 점수 Map 만들기")
    fun mission5_createScoreMap() {
        val result = createScoreMap()

        assertEquals(3, result.size)
        assertEquals(95, result["Alice"])
        assertEquals(87, result["Bob"])
        assertEquals(92, result["Charlie"])
    }

    @Test
    @DisplayName("Task 5: Map에서 점수 조회 - 존재하는 키")
    fun mission5_getScore_existing() {
        val scores = mapOf("Alice" to 95, "Bob" to 87)

        assertEquals(95, getScore(scores, "Alice"))
        assertEquals(87, getScore(scores, "Bob"))
    }

    @Test
    @DisplayName("Task 5: Map에서 점수 조회 - 존재하지 않는 키")
    fun mission5_getScore_notExisting() {
        val scores = mapOf("Alice" to 95, "Bob" to 87)

        assertEquals(0, getScore(scores, "Charlie"))
        assertEquals(0, getScore(scores, "David"))
    }

    @Test
    @DisplayName("Task 6: MutableList에 요소 추가")
    fun mission5_addToList() {
        val list = mutableListOf("A", "B", "C")
        val result = addToList(list, "D")

        assertEquals(4, result)
        assertTrue(list.contains("D"))
    }

    @Test
    @DisplayName("Task 6: 빈 리스트에 요소 추가")
    fun mission5_addToList_emptyList() {
        val list = mutableListOf<String>()
        val result = addToList(list, "First")

        assertEquals(1, result)
        assertEquals("First", list[0])
    }

    @Test
    @DisplayName("Task 7: 숫자 리스트 통계")
    fun mission5_getStatistics() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val result = getStatistics(numbers)

        assertEquals(15, result["sum"])
        assertEquals(3.0, result["average"])
        assertEquals(5, result["max"])
        assertEquals(1, result["min"])
    }

    @Test
    @DisplayName("Task 7: 동일한 숫자 리스트 통계")
    fun mission5_getStatistics_sameNumbers() {
        val numbers = listOf(5, 5, 5)
        val result = getStatistics(numbers)

        assertEquals(15, result["sum"])
        assertEquals(5.0, result["average"])
        assertEquals(5, result["max"])
        assertEquals(5, result["min"])
    }

    @Test
    @DisplayName("Task 8: 집합 연산")
    fun mission5_setOperations() {
        val a = setOf(1, 2, 3)
        val b = setOf(2, 3, 4)
        val result = setOperations(a, b)

        assertEquals(setOf(1, 2, 3, 4), result.first)  // 합집합
        assertEquals(setOf(2, 3), result.second)        // 교집합
        assertEquals(setOf(1), result.third)            // 차집합
    }

    @Test
    @DisplayName("Task 8: 서로 다른 집합 연산")
    fun mission5_setOperations_disjoint() {
        val a = setOf(1, 2)
        val b = setOf(3, 4)
        val result = setOperations(a, b)

        assertEquals(setOf(1, 2, 3, 4), result.first)  // 합집합
        assertEquals(emptySet<Int>(), result.second)    // 교집합 (없음)
        assertEquals(setOf(1, 2), result.third)         // 차집합
    }
}
