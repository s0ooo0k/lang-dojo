package mission11

/**
 * Mission 11: Interfaces & Inheritance
 *
 * Kotlin의 인터페이스와 상속을 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

// ============ Task 1: 기본 인터페이스 ============

/**
 * Task 1: Drawable 인터페이스
 * draw(): String 메서드 선언
 */
interface Drawable {
    // TODO: draw() 메서드를 선언하세요
}

/**
 * Task 1: Circle 클래스
 * Drawable 구현, draw() → "Drawing Circle"
 */
class Circle : Drawable {
    override fun draw(): String {
        TODO("draw 메서드를 구현하세요")
    }
}

// ============ Task 2: 인터페이스 기본 구현 ============

/**
 * Task 2: Greeting 인터페이스
 * - greet(): String (추상)
 * - greetWithName(name: String): String (기본 구현)
 */
interface Greeting {
    // TODO: greet() 추상 메서드와 greetWithName() 기본 구현을 추가하세요
}

/**
 * Task 2: FriendlyGreeting 클래스
 * greet() → "Nice to meet you!"
 */
class FriendlyGreeting : Greeting {
    override fun greet(): String {
        TODO("greet 메서드를 구현하세요")
    }
}

// ============ Task 3: 클래스 상속 ============

/**
 * Task 3: Vehicle 클래스
 * - brand: String
 * - start(): String → "Starting {brand}"
 */
open class Vehicle(val brand: String) {
    open fun start(): String {
        TODO("start 메서드를 구현하세요")
    }
}

/**
 * Task 3: Car 클래스
 * - model: String 추가
 * - start() 오버라이드 → "Starting {brand} {model} with engine"
 */
class Car(brand: String, val model: String) : Vehicle(brand) {
    override fun start(): String {
        TODO("start 메서드를 오버라이드하세요")
    }
}

// ============ Task 4: 추상 클래스 ============

/**
 * Task 4: Shape 추상 클래스
 * - abstract val area: Double
 * - abstract fun describe(): String
 */
abstract class Shape {
    // TODO: 추상 프로퍼티와 메서드를 선언하세요
}

/**
 * Task 4: Rectangle 클래스
 * - width, height
 * - area = width * height
 * - describe() → "Rectangle with area {area}"
 */
class Rectangle(val width: Double, val height: Double) : Shape() {
    override val area: Double
        get() = TODO("area를 구현하세요")

    override fun describe(): String {
        TODO("describe 메서드를 구현하세요")
    }
}

// ============ Task 5: 다중 인터페이스 ============

/**
 * Task 5: Swimmer 인터페이스
 * swim(): String → "Swimming"
 */
interface Swimmer {
    fun swim(): String = TODO("기본 구현을 추가하세요")
}

/**
 * Task 5: Flyer 인터페이스
 * fly(): String → "Flying"
 */
interface Flyer {
    fun fly(): String = TODO("기본 구현을 추가하세요")
}

/**
 * Task 5: Duck 클래스
 * Swimmer와 Flyer 모두 구현
 */
class Duck : Swimmer, Flyer {
    // 기본 구현 사용
}

// ============ Task 6: super 호출 ============

/**
 * Task 6: Animal 클래스
 * speak(): String → "Some sound"
 */
open class Animal {
    open fun speak(): String {
        TODO("speak 메서드를 구현하세요")
    }
}

/**
 * Task 6: Dog 클래스
 * speak() 오버라이드 → super.speak() + " Woof!"
 */
class Dog : Animal() {
    override fun speak(): String {
        TODO("speak 메서드를 오버라이드하세요 (super 사용)")
    }
}

// ============ Task 7: 프로퍼티 오버라이드 ============

/**
 * Task 7: Base 클래스
 * open val message: String → "Base message"
 */
open class Base {
    open val message: String = TODO("message를 구현하세요")
}

/**
 * Task 7: Derived 클래스
 * message 오버라이드 → "Derived message"
 */
class Derived : Base() {
    override val message: String = TODO("message를 오버라이드하세요")
}

// ============ Task 8: 인터페이스 충돌 해결 ============

/**
 * Task 8: A 인터페이스
 * foo(): String → "A"
 */
interface A {
    fun foo(): String = TODO("기본 구현을 추가하세요")
}

/**
 * Task 8: B 인터페이스
 * foo(): String → "B"
 */
interface B {
    fun foo(): String = TODO("기본 구현을 추가하세요")
}

/**
 * Task 8: C 클래스
 * A, B 모두 구현, foo() → "A and B"
 */
class C : A, B {
    override fun foo(): String {
        TODO("충돌을 해결하고 foo 메서드를 구현하세요")
    }
}
