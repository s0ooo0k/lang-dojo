package mission6

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.BeforeEach
import kotlin.math.PI

@DisplayName("Mission 6: Classes")
class ClassesTest {

    @Test
    @DisplayName("Task 1: Person 클래스 생성")
    fun mission6_personClass() {
        val person = Person("Alice", 25)

        assertEquals("Alice", person.name)
        assertEquals(25, person.age)
    }

    @Test
    @DisplayName("Task 2: Person introduce 메서드")
    fun mission6_personIntroduce() {
        val person = Person("Bob", 30)
        val result = person.introduce()

        assertEquals("안녕하세요, 저는 Bob이고 30살입니다.", result)
    }

    @Test
    @DisplayName("Task 3: Rectangle area")
    fun mission6_rectangleArea() {
        val rect = Rectangle(10, 5)

        assertEquals(50, rect.area())
    }

    @Test
    @DisplayName("Task 3: Rectangle perimeter")
    fun mission6_rectanglePerimeter() {
        val rect = Rectangle(10, 5)

        assertEquals(30, rect.perimeter())
    }

    @Test
    @DisplayName("Task 4: Product data class")
    fun mission6_productDataClass() {
        val product = Product(1, "Laptop", 999.99)

        assertEquals(1, product.id)
        assertEquals("Laptop", product.name)
        assertEquals(999.99, product.price)

        // data class의 toString 확인
        assertTrue(product.toString().contains("Product"))
        assertTrue(product.toString().contains("Laptop"))
    }

    @Test
    @DisplayName("Task 4: Product equals")
    fun mission6_productEquals() {
        val product1 = Product(1, "Laptop", 999.99)
        val product2 = Product(1, "Laptop", 999.99)

        assertEquals(product1, product2)
    }

    @Test
    @DisplayName("Task 5: updatePrice")
    fun mission6_updatePrice() {
        val product = Product(1, "Laptop", 999.99)
        val updated = updatePrice(product, 899.99) as Product

        assertEquals(1, updated.id)
        assertEquals("Laptop", updated.name)
        assertEquals(899.99, updated.price)

        // 원본은 변경되지 않음
        assertEquals(999.99, product.price)
    }

    @BeforeEach
    fun resetCounter() {
        Counter.reset()
    }

    @Test
    @DisplayName("Task 6: Counter increment")
    fun mission6_counterIncrement() {
        assertEquals(1, Counter.increment())
        assertEquals(2, Counter.increment())
        assertEquals(3, Counter.increment())
    }

    @Test
    @DisplayName("Task 6: Counter reset")
    fun mission6_counterReset() {
        Counter.increment()
        Counter.increment()
        Counter.reset()

        assertEquals(1, Counter.increment())
    }

    @Test
    @DisplayName("Task 7: IdGenerator")
    fun mission6_idGenerator() {
        // companion object의 상태를 리셋하기 위해 리플렉션 사용 대신 순차적 테스트
        val id1 = IdGenerator.generateId()
        val id2 = IdGenerator.generateId()
        val id3 = IdGenerator.generateId()

        // ID는 순차적으로 증가해야 함
        assertTrue(id2 > id1)
        assertTrue(id3 > id2)
    }

    @Test
    @DisplayName("Task 8: Circle area")
    fun mission6_circleArea() {
        val circle = Circle(5.0)
        val expectedArea = PI * 5.0 * 5.0

        assertEquals(expectedArea, circle.area, 0.001)
    }

    @Test
    @DisplayName("Task 8: Circle circumference")
    fun mission6_circleCircumference() {
        val circle = Circle(5.0)
        val expectedCircumference = 2 * PI * 5.0

        assertEquals(expectedCircumference, circle.circumference, 0.001)
    }
}
