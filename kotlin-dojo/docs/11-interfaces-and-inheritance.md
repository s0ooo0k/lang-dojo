# Mission 11 학습 자료: 인터페이스와 상속 (Interfaces & Inheritance)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Inheritance](https://kotlinlang.org/docs/inheritance.html)

---

## 1. 상속 (Inheritance)

> 📖 참조: https://kotlinlang.org/docs/inheritance.html

Kotlin의 모든 클래스는 기본적으로 `final`입니다. 상속을 허용하려면 `open` 키워드가 필요합니다.

### 기본 클래스 상속

```kotlin
// 상속 가능하도록 open
open class Animal(val name: String) {
    open fun makeSound() {
        println("Some sound")
    }
}

// 상속
class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("Woof!")
    }
}

// 사용
val dog = Dog("Buddy")
dog.makeSound()  // Woof!
```

### open 키워드

```kotlin
open class Parent {
    open val property = "Parent"
    open fun method() = "Parent method"
    fun finalMethod() = "Cannot override"  // final (기본)
}

class Child : Parent() {
    override val property = "Child"
    override fun method() = "Child method"
    // override fun finalMethod() = ...  // ❌ 에러!
}
```

---

## 2. 인터페이스 (Interfaces)

> 📖 참조: https://kotlinlang.org/docs/interfaces.html

### 기본 인터페이스

```kotlin
interface Clickable {
    fun click()
}

class Button : Clickable {
    override fun click() {
        println("Button clicked")
    }
}
```

### 인터페이스의 프로퍼티

```kotlin
interface Named {
    val name: String  // 추상 프로퍼티
}

class Person(override val name: String) : Named
```

### 기본 구현 (Default Implementation)

```kotlin
interface Printable {
    fun print()  // 추상

    fun printWithBorder() {  // 기본 구현
        println("=====")
        print()
        println("=====")
    }
}

class Document(private val content: String) : Printable {
    override fun print() {
        println(content)
    }
    // printWithBorder()는 그대로 사용
}
```

### 다중 인터페이스

```kotlin
interface A {
    fun foo() = "A"
}

interface B {
    fun foo() = "B"
}

class C : A, B {
    // 충돌 해결 필수!
    override fun foo(): String {
        return super<A>.foo() + super<B>.foo()
    }
}
```

---

## 3. 추상 클래스 (Abstract Classes)

> 📖 참조: https://kotlinlang.org/docs/classes.html#abstract-classes

```kotlin
abstract class Shape {
    abstract val area: Double
    abstract fun draw()

    // 일반 메서드도 가능
    fun describe() = "This is a shape with area $area"
}

class Circle(private val radius: Double) : Shape() {
    override val area: Double
        get() = Math.PI * radius * radius

    override fun draw() {
        println("Drawing circle with radius $radius")
    }
}
```

### 인터페이스 vs 추상 클래스

| 특징 | 인터페이스 | 추상 클래스 |
|------|-----------|------------|
| 상태(프로퍼티) | backing field 없음 | 가능 |
| 생성자 | 없음 | 있음 |
| 다중 상속 | 가능 | 불가 |
| 기본 구현 | 가능 | 가능 |

---

## 4. override 규칙

### 메서드 오버라이드

```kotlin
open class Parent {
    open fun greet() = "Hello from Parent"
}

class Child : Parent() {
    override fun greet() = "Hello from Child"
}

// 더 이상 오버라이드 불가하게 하려면 final
class GrandChild : Child() {
    // final로 선언되어 오버라이드 불가
}

open class AnotherChild : Parent() {
    final override fun greet() = "Final"  // 더 이상 오버라이드 불가
}
```

### 프로퍼티 오버라이드

```kotlin
open class Parent {
    open val name: String = "Parent"
}

class Child : Parent() {
    override val name: String = "Child"
}

// val을 var로 오버라이드 가능 (반대는 불가)
open class Base {
    open val value: Int = 0
}

class Derived : Base() {
    override var value: Int = 0  // val → var 가능
}
```

---

## 5. super 키워드

### 부모 메서드 호출

```kotlin
open class Parent {
    open fun greet() = "Hello"
}

class Child : Parent() {
    override fun greet(): String {
        val parentGreeting = super.greet()
        return "$parentGreeting from Child"
    }
}
```

### 여러 부모의 메서드 호출

```kotlin
interface A {
    fun foo() = "A"
}

interface B {
    fun foo() = "B"
}

class C : A, B {
    override fun foo(): String {
        return "${super<A>.foo()} and ${super<B>.foo()}"
    }
}
```

---

## 6. 가시성 수정자 (Visibility Modifiers)

> 📖 참조: https://kotlinlang.org/docs/visibility-modifiers.html

| 수정자 | 클래스 멤버 | 최상위 선언 |
|--------|------------|------------|
| `public` (기본) | 모든 곳에서 접근 | 모든 곳에서 접근 |
| `private` | 클래스 내부에서만 | 파일 내부에서만 |
| `protected` | 서브클래스에서도 접근 | 사용 불가 |
| `internal` | 같은 모듈에서 접근 | 같은 모듈에서 접근 |

```kotlin
open class Parent {
    private val privateVal = "private"
    protected val protectedVal = "protected"
    internal val internalVal = "internal"
    val publicVal = "public"  // 기본이 public
}

class Child : Parent() {
    fun test() {
        // println(privateVal)    // ❌ 접근 불가
        println(protectedVal)     // ✅ 가능
        println(internalVal)      // ✅ 가능
        println(publicVal)        // ✅ 가능
    }
}
```

---

## 7. 흔히 하는 실수

### 실수 1: open 없이 상속

```kotlin
class Parent  // final (기본)

// ❌ 컴파일 에러
// class Child : Parent()

// ✅ open 추가
open class Parent2
class Child : Parent2()
```

### 실수 2: override 누락

```kotlin
open class Parent {
    open fun greet() = "Hello"
}

class Child : Parent() {
    // ❌ override 없이 같은 이름의 메서드
    // fun greet() = "Hi"  // 에러!

    // ✅ override 필수
    override fun greet() = "Hi"
}
```

### 실수 3: 인터페이스 충돌 미해결

```kotlin
interface A { fun foo() = "A" }
interface B { fun foo() = "B" }

// ❌ 컴파일 에러 - 충돌 해결 필요
// class C : A, B

// ✅ 명시적으로 해결
class C : A, B {
    override fun foo() = super<A>.foo()
}
```

---

## 8. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] `open` 키워드의 역할을 알고 있나요?
- [ ] 클래스를 상속하는 문법을 알고 있나요?
- [ ] 인터페이스를 구현하는 문법을 알고 있나요?
- [ ] `override` 키워드를 언제 사용하는지 알고 있나요?
- [ ] 추상 클래스와 인터페이스의 차이를 이해했나요?
- [ ] `super`로 부모 메서드를 호출할 수 있나요?

---

## 9. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Inheritance](https://kotlinlang.org/docs/inheritance.html)
- [Kotlin Interfaces](https://kotlinlang.org/docs/interfaces.html)
- [Kotlin Visibility Modifiers](https://kotlinlang.org/docs/visibility-modifiers.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
