package mission6

import kotlin.math.PI

/**
 * Mission 6: Classes (클래스)
 *
 * Kotlin의 클래스를 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

/**
 * Task 1 & 2: Person 클래스
 * - name (String), age (Int) 프로퍼티
 * - introduce() 메서드: "안녕하세요, 저는 {name}이고 {age}살입니다." 반환
 */
class Person {
    // TODO: 기본 생성자와 프로퍼티를 구현하세요

    fun introduce(): String {
        TODO("introduce 메서드를 구현하세요")
    }
}

/**
 * Task 3: Rectangle 클래스
 * - width (Int), height (Int) 프로퍼티
 * - area(): 넓이 반환
 * - perimeter(): 둘레 반환
 */
class Rectangle {
    // TODO: 기본 생성자와 프로퍼티를 구현하세요

    fun area(): Int {
        TODO("area 메서드를 구현하세요")
    }

    fun perimeter(): Int {
        TODO("perimeter 메서드를 구현하세요")
    }
}

/**
 * Task 4: Product data class
 * - id (Int), name (String), price (Double) 프로퍼티
 */
// TODO: Product data class를 구현하세요

/**
 * Task 5: Data Class copy
 * 기존 Product의 price만 newPrice로 변경한 새 Product를 반환합니다.
 */
fun updatePrice(product: Any, newPrice: Double): Any {
    TODO("updatePrice 함수를 구현하세요")
}

/**
 * Task 6: Counter object (싱글톤)
 * - count: Int (초기값 0)
 * - increment(): count를 1 증가시키고 반환
 * - reset(): count를 0으로 초기화
 */
object Counter {
    // TODO: Counter object를 구현하세요

    fun increment(): Int {
        TODO("increment 메서드를 구현하세요")
    }

    fun reset() {
        TODO("reset 메서드를 구현하세요")
    }
}

/**
 * Task 7: IdGenerator 클래스 with companion object
 * - companion object 내에 currentId와 generateId()
 */
class IdGenerator {
    // TODO: companion object를 구현하세요
}

/**
 * Task 8: Circle 클래스
 * - radius (Double) 생성자 프로퍼티
 * - area: Double (계산된 프로퍼티) - PI * radius * radius
 * - circumference: Double (계산된 프로퍼티) - 2 * PI * radius
 */
class Circle {
    // TODO: Circle 클래스를 구현하세요
}
