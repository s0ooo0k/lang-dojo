package mission2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Mission 2: 변수와 기본 타입")
class VariablesTest {

    @Nested
    @DisplayName("Mission 2-1: 내 이름 반환하기")
    inner class Mission2_1 {
        @Test
        fun `mission_2_1_getMyName은 sook을 반환해야 한다`() {
            val result = getMyName()
            assertEquals("sook", result)
        }
    }

    @Nested
    @DisplayName("Mission 2-2: 내 나이 반환하기")
    inner class Mission2_2 {
        @Test
        fun `mission_2_2_getMyAge는 25를 반환해야 한다`() {
            val result = getMyAge()
            assertEquals(25, result)
        }
    }

    @Nested
    @DisplayName("Mission 2-3: 내 키 반환하기")
    inner class Mission2_3 {
        @Test
        fun `mission_2_3_getMyHeight는 175점5를 반환해야 한다`() {
            val result = getMyHeight()
            assertEquals(175.5, result, 0.01)
        }
    }

    @Nested
    @DisplayName("Mission 2-4: Kotlin이 재미있나요?")
    inner class Mission2_4 {
        @Test
        fun `mission_2_4_isKotlinFun은 true를 반환해야 한다`() {
            val result = isKotlinFun()
            assertTrue(result)
        }
    }

    @Nested
    @DisplayName("Mission 2-5: 자기소개 (문자열 템플릿 $)")
    inner class Mission2_5 {
        @Test
        fun `mission_2_5_introduce_Alice는 Hello I'm Alice를 반환해야 한다`() {
            val result = introduce("Alice")
            assertEquals("Hello, I'm Alice", result)
        }

        @Test
        fun `mission_2_5_introduce_Bob은 Hello I'm Bob을 반환해야 한다`() {
            val result = introduce("Bob")
            assertEquals("Hello, I'm Bob", result)
        }

        @Test
        fun `mission_2_5_introduce_sook은 Hello I'm sook을 반환해야 한다`() {
            val result = introduce("sook")
            assertEquals("Hello, I'm sook", result)
        }
    }

    @Nested
    @DisplayName("Mission 2-6: 두 수 더하기")
    inner class Mission2_6 {
        @Test
        fun `mission_2_6_addNumbers_3과5는 8을 반환해야 한다`() {
            val result = addNumbers(3, 5)
            assertEquals(8, result)
        }

        @Test
        fun `mission_2_6_addNumbers_10과20은 30을 반환해야 한다`() {
            val result = addNumbers(10, 20)
            assertEquals(30, result)
        }

        @Test
        fun `mission_2_6_addNumbers_음수도 처리해야 한다`() {
            val result = addNumbers(-5, 10)
            assertEquals(5, result)
        }
    }

    @Nested
    @DisplayName("Mission 2-7: 평균 계산하기")
    inner class Mission2_7 {
        @Test
        fun `mission_2_7_calculateAverage_3과4의 평균은 3점5이다`() {
            val result = calculateAverage(3, 4)
            assertEquals(3.5, result, 0.01)
        }

        @Test
        fun `mission_2_7_calculateAverage_5과6의 평균은 5점5이다`() {
            val result = calculateAverage(5, 6)
            assertEquals(5.5, result, 0.01)
        }

        @Test
        fun `mission_2_7_calculateAverage_7과2의 평균은 4점5이다`() {
            val result = calculateAverage(7, 2)
            assertEquals(4.5, result, 0.01)
        }

        @Test
        fun `mission_2_7_calculateAverage_10과10의 평균은 10점0이다`() {
            val result = calculateAverage(10, 10)
            assertEquals(10.0, result, 0.01)
        }
    }

    @Nested
    @DisplayName("Mission 2-8: Int를 Double로 변환")
    inner class Mission2_8 {
        @Test
        fun `mission_2_8_intToDouble_42는 42점0을 반환해야 한다`() {
            val result = intToDouble(42)
            assertEquals(42.0, result, 0.01)
        }

        @Test
        fun `mission_2_8_intToDouble_100은 100점0을 반환해야 한다`() {
            val result = intToDouble(100)
            assertEquals(100.0, result, 0.01)
        }

        @Test
        fun `mission_2_8_intToDouble_0은 0점0을 반환해야 한다`() {
            val result = intToDouble(0)
            assertEquals(0.0, result, 0.01)
        }
    }

    @Nested
    @DisplayName("Mission 2-9: 정보 포맷팅 (문자열 템플릿 \${})")
    inner class Mission2_9 {
        @Test
        fun `mission_2_9_formatInfo_sook_25는 Name sook Age 25를 반환해야 한다`() {
            val result = formatInfo("sook", 25)
            assertEquals("Name: sook, Age: 25", result)
        }

        @Test
        fun `mission_2_9_formatInfo_Alice_30은 Name Alice Age 30을 반환해야 한다`() {
            val result = formatInfo("Alice", 30)
            assertEquals("Name: Alice, Age: 30", result)
        }
    }

    @Nested
    @DisplayName("Mission 2-10: 다음 해 나이 계산")
    inner class Mission2_10 {
        @Test
        fun `mission_2_10_nextYearAge_sook_25는 sook will be 26 next year를 반환해야 한다`() {
            val result = nextYearAge("sook", 25)
            assertEquals("sook will be 26 next year", result)
        }

        @Test
        fun `mission_2_10_nextYearAge_Alice_30은 Alice will be 31 next year를 반환해야 한다`() {
            val result = nextYearAge("Alice", 30)
            assertEquals("Alice will be 31 next year", result)
        }

        @Test
        fun `mission_2_10_nextYearAge_Bob_0은 Bob will be 1 next year를 반환해야 한다`() {
            val result = nextYearAge("Bob", 0)
            assertEquals("Bob will be 1 next year", result)
        }
    }
}
