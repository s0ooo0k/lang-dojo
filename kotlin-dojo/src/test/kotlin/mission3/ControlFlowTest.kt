package mission3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Mission 3: Control Flow")
class ControlFlowTest {

    @Nested
    @DisplayName("Mission 3-1: 짝수/홀수 판별")
    inner class Mission3_1 {
        @Test
        fun `isEven_4는 true를 반환해야 한다`() {
            assertTrue(isEven(4))
        }

        @Test
        fun `isEven_7은 false를 반환해야 한다`() {
            assertFalse(isEven(7))
        }

        @Test
        fun `isEven_0은 true를 반환해야 한다`() {
            assertTrue(isEven(0))
        }

        @Test
        fun `isEven_음수도 처리해야 한다`() {
            assertTrue(isEven(-2))
            assertFalse(isEven(-3))
        }
    }

    @Nested
    @DisplayName("Mission 3-2: 부호 판별")
    inner class Mission3_2 {
        @Test
        fun `getSign_양수는 positive를 반환해야 한다`() {
            assertEquals("positive", getSign(5))
            assertEquals("positive", getSign(100))
        }

        @Test
        fun `getSign_음수는 negative를 반환해야 한다`() {
            assertEquals("negative", getSign(-3))
            assertEquals("negative", getSign(-100))
        }

        @Test
        fun `getSign_0은 zero를 반환해야 한다`() {
            assertEquals("zero", getSign(0))
        }
    }

    @Nested
    @DisplayName("Mission 3-3: 성적 등급")
    inner class Mission3_3 {
        @Test
        fun `getGrade_90이상은 A`() {
            assertEquals("A", getGrade(90))
            assertEquals("A", getGrade(95))
            assertEquals("A", getGrade(100))
        }

        @Test
        fun `getGrade_80이상90미만은 B`() {
            assertEquals("B", getGrade(80))
            assertEquals("B", getGrade(89))
        }

        @Test
        fun `getGrade_70이상80미만은 C`() {
            assertEquals("C", getGrade(70))
            assertEquals("C", getGrade(79))
        }

        @Test
        fun `getGrade_60이상70미만은 D`() {
            assertEquals("D", getGrade(60))
            assertEquals("D", getGrade(69))
        }

        @Test
        fun `getGrade_60미만은 F`() {
            assertEquals("F", getGrade(59))
            assertEquals("F", getGrade(0))
        }
    }

    @Nested
    @DisplayName("Mission 3-4: 요일 이름")
    inner class Mission3_4 {
        @Test
        fun `getDayName_1은 Monday`() {
            assertEquals("Monday", getDayName(1))
        }

        @Test
        fun `getDayName_5는 Friday`() {
            assertEquals("Friday", getDayName(5))
        }

        @Test
        fun `getDayName_7은 Sunday`() {
            assertEquals("Sunday", getDayName(7))
        }

        @Test
        fun `getDayName_범위밖은 Invalid`() {
            assertEquals("Invalid", getDayName(0))
            assertEquals("Invalid", getDayName(8))
            assertEquals("Invalid", getDayName(-1))
        }
    }

    @Nested
    @DisplayName("Mission 3-5: 범위 검사")
    inner class Mission3_5 {
        @Test
        fun `isInRange_범위안에 있으면 true`() {
            assertTrue(isInRange(5, 1, 10))
            assertTrue(isInRange(1, 1, 10))
            assertTrue(isInRange(10, 1, 10))
        }

        @Test
        fun `isInRange_범위밖이면 false`() {
            assertFalse(isInRange(0, 1, 10))
            assertFalse(isInRange(11, 1, 10))
            assertFalse(isInRange(-5, 1, 10))
        }
    }

    @Nested
    @DisplayName("Mission 3-6: 1부터 N까지 합계")
    inner class Mission3_6 {
        @Test
        fun `sumUpTo_5는 15`() {
            assertEquals(15, sumUpTo(5))
        }

        @Test
        fun `sumUpTo_10은 55`() {
            assertEquals(55, sumUpTo(10))
        }

        @Test
        fun `sumUpTo_1은 1`() {
            assertEquals(1, sumUpTo(1))
        }

        @Test
        fun `sumUpTo_100은 5050`() {
            assertEquals(5050, sumUpTo(100))
        }
    }

    @Nested
    @DisplayName("Mission 3-7: 구구단 한 줄")
    inner class Mission3_7 {
        @Test
        fun `multiplicationTable_2단`() {
            assertEquals(listOf(2, 4, 6, 8, 10, 12, 14, 16, 18), multiplicationTable(2))
        }

        @Test
        fun `multiplicationTable_5단`() {
            assertEquals(listOf(5, 10, 15, 20, 25, 30, 35, 40, 45), multiplicationTable(5))
        }

        @Test
        fun `multiplicationTable_9단`() {
            assertEquals(listOf(9, 18, 27, 36, 45, 54, 63, 72, 81), multiplicationTable(9))
        }
    }

    @Nested
    @DisplayName("Mission 3-8: 팩토리얼")
    inner class Mission3_8 {
        @Test
        fun `factorial_5는 120`() {
            assertEquals(120L, factorial(5))
        }

        @Test
        fun `factorial_0은 1`() {
            assertEquals(1L, factorial(0))
        }

        @Test
        fun `factorial_1은 1`() {
            assertEquals(1L, factorial(1))
        }

        @Test
        fun `factorial_10은 3628800`() {
            assertEquals(3628800L, factorial(10))
        }
    }

    @Nested
    @DisplayName("Mission 3-9: 카운트다운")
    inner class Mission3_9 {
        @Test
        fun `countDown_5`() {
            assertEquals(listOf(5, 4, 3, 2, 1), countDown(5))
        }

        @Test
        fun `countDown_3`() {
            assertEquals(listOf(3, 2, 1), countDown(3))
        }

        @Test
        fun `countDown_1`() {
            assertEquals(listOf(1), countDown(1))
        }
    }

    @Nested
    @DisplayName("Mission 3-10: FizzBuzz")
    inner class Mission3_10 {
        @Test
        fun `fizzBuzz_15는 FizzBuzz`() {
            assertEquals("FizzBuzz", fizzBuzz(15))
            assertEquals("FizzBuzz", fizzBuzz(30))
        }

        @Test
        fun `fizzBuzz_3의배수는 Fizz`() {
            assertEquals("Fizz", fizzBuzz(3))
            assertEquals("Fizz", fizzBuzz(9))
        }

        @Test
        fun `fizzBuzz_5의배수는 Buzz`() {
            assertEquals("Buzz", fizzBuzz(5))
            assertEquals("Buzz", fizzBuzz(10))
        }

        @Test
        fun `fizzBuzz_그외는 숫자문자열`() {
            assertEquals("1", fizzBuzz(1))
            assertEquals("7", fizzBuzz(7))
            assertEquals("11", fizzBuzz(11))
        }
    }
}
