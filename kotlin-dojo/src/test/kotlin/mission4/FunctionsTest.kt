package mission4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Mission 4: 함수 심화")
class FunctionsTest {

    @Nested
    @DisplayName("Mission 4-1: 기본 인사")
    inner class Mission4_1 {
        @Test
        fun `greet with name returns Hello name`() {
            assertEquals("Hello, Alice!", greet("Alice"))
        }

        @Test
        fun `greet with different name`() {
            assertEquals("Hello, Bob!", greet("Bob"))
        }

        @Test
        fun `greet without argument returns Hello World`() {
            assertEquals("Hello, World!", greet())
        }
    }

    @Nested
    @DisplayName("Mission 4-2: 커피 주문")
    inner class Mission4_2 {
        @Test
        fun `orderCoffee with no arguments uses all defaults`() {
            assertEquals("Medium Americano with 2 shot(s)", orderCoffee())
        }

        @Test
        fun `orderCoffee with type only`() {
            assertEquals("Medium Latte with 2 shot(s)", orderCoffee("Latte"))
        }

        @Test
        fun `orderCoffee with all arguments`() {
            assertEquals("Small Espresso with 1 shot(s)", orderCoffee("Espresso", "Small", 1))
        }

        @Test
        fun `orderCoffee with large size`() {
            assertEquals("Large Mocha with 3 shot(s)", orderCoffee("Mocha", "Large", 3))
        }
    }

    @Nested
    @DisplayName("Mission 4-3: 사용자 프로필")
    inner class Mission4_3 {
        @Test
        fun `createProfile returns formatted string`() {
            assertEquals(
                "Alice (25) - Developer in Seoul",
                createProfile("Alice", 25, "Seoul", "Developer")
            )
        }

        @Test
        fun `createProfile with named arguments`() {
            assertEquals(
                "Bob (30) - Designer in Busan",
                createProfile(name = "Bob", age = 30, city = "Busan", job = "Designer")
            )
        }

        @Test
        fun `createProfile with different order named arguments`() {
            assertEquals(
                "Charlie (28) - Engineer in Daegu",
                createProfile(job = "Engineer", city = "Daegu", name = "Charlie", age = 28)
            )
        }
    }

    @Nested
    @DisplayName("Mission 4-4: 합계 계산")
    inner class Mission4_4 {
        @Test
        fun `sumAll with three numbers`() {
            assertEquals(6, sumAll(1, 2, 3))
        }

        @Test
        fun `sumAll with four numbers`() {
            assertEquals(100, sumAll(10, 20, 30, 40))
        }

        @Test
        fun `sumAll with single number`() {
            assertEquals(5, sumAll(5))
        }

        @Test
        fun `sumAll with no numbers returns 0`() {
            assertEquals(0, sumAll())
        }

        @Test
        fun `sumAll with negative numbers`() {
            assertEquals(-6, sumAll(-1, -2, -3))
        }
    }

    @Nested
    @DisplayName("Mission 4-5: 최댓값 찾기")
    inner class Mission4_5 {
        @Test
        fun `findMax returns largest number`() {
            assertEquals(5, findMax(1, 5, 3))
        }

        @Test
        fun `findMax with first as max`() {
            assertEquals(10, findMax(10, 2, 8, 6))
        }

        @Test
        fun `findMax with negative numbers`() {
            assertEquals(-1, findMax(-1, -5, -3))
        }

        @Test
        fun `findMax with no arguments returns MIN_VALUE`() {
            assertEquals(Int.MIN_VALUE, findMax())
        }

        @Test
        fun `findMax with single number`() {
            assertEquals(42, findMax(42))
        }
    }

    @Nested
    @DisplayName("Mission 4-6: 문자열 합치기")
    inner class Mission4_6 {
        @Test
        fun `joinStrings with default separator`() {
            assertEquals("A, B, C", joinStrings("A", "B", "C"))
        }

        @Test
        fun `joinStrings with custom separator`() {
            assertEquals("X-Y", joinStrings("X", "Y", separator = "-"))
        }

        @Test
        fun `joinStrings with space separator`() {
            assertEquals("Hello World", joinStrings("Hello", "World", separator = " "))
        }

        @Test
        fun `joinStrings with no strings returns empty`() {
            assertEquals("", joinStrings())
        }

        @Test
        fun `joinStrings with single string`() {
            assertEquals("Only", joinStrings("Only"))
        }
    }

    @Nested
    @DisplayName("Mission 4-7: 반복 문자열")
    inner class Mission4_7 {
        @Test
        fun `repeatString three times`() {
            assertEquals("HaHaHa", repeatString("Ha", 3))
        }

        @Test
        fun `repeatString with default times`() {
            assertEquals("OK", repeatString("OK"))
        }

        @Test
        fun `repeatString five times`() {
            assertEquals("!!!!!", repeatString("!", 5))
        }

        @Test
        fun `repeatString zero times returns empty`() {
            assertEquals("", repeatString("Test", 0))
        }
    }

    @Nested
    @DisplayName("Mission 4-8: 포맷된 가격")
    inner class Mission4_8 {
        @Test
        fun `formatPrice with defaults`() {
            assertEquals("100 USD", formatPrice(100))
        }

        @Test
        fun `formatPrice with custom currency`() {
            assertEquals("50 EUR", formatPrice(50, currency = "EUR"))
        }

        @Test
        fun `formatPrice without symbol`() {
            assertEquals("200", formatPrice(200, showSymbol = false))
        }

        @Test
        fun `formatPrice with KRW`() {
            assertEquals("75 KRW", formatPrice(75, currency = "KRW", showSymbol = true))
        }

        @Test
        fun `formatPrice without symbol ignores currency`() {
            assertEquals("300", formatPrice(300, currency = "JPY", showSymbol = false))
        }
    }

    @Nested
    @DisplayName("Mission 4-9: 평균 계산")
    inner class Mission4_9 {
        @Test
        fun `average of three numbers`() {
            assertEquals(2.0, average(1.0, 2.0, 3.0), 0.01)
        }

        @Test
        fun `average of two numbers`() {
            assertEquals(15.0, average(10.0, 20.0), 0.01)
        }

        @Test
        fun `average of single number`() {
            assertEquals(5.0, average(5.0), 0.01)
        }

        @Test
        fun `average of no numbers returns 0`() {
            assertEquals(0.0, average(), 0.01)
        }
    }

    @Nested
    @DisplayName("Mission 4-10: 태그 생성기")
    inner class Mission4_10 {
        @Test
        fun `createTag simple div`() {
            assertEquals("<div></div>", createTag("div"))
        }

        @Test
        fun `createTag self-closing img`() {
            assertEquals("<img />", createTag("img", selfClosing = true))
        }

        @Test
        fun `createTag with attributes`() {
            assertEquals(
                "<a href='#' class='link'></a>",
                createTag("a", "href='#'", "class='link'")
            )
        }

        @Test
        fun `createTag self-closing br`() {
            assertEquals("<br />", createTag("br", selfClosing = true))
        }

        @Test
        fun `createTag with single attribute`() {
            assertEquals("<p id='intro'></p>", createTag("p", "id='intro'"))
        }

        @Test
        fun `createTag self-closing with attributes`() {
            assertEquals(
                "<input type='text' name='id' />",
                createTag("input", "type='text'", "name='id'", selfClosing = true)
            )
        }
    }
}
