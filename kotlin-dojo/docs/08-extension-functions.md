# Mission 8 학습 자료: 확장 함수 (Extension Functions)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Extensions](https://kotlinlang.org/docs/extensions.html)

---

## 1. 확장 함수 개요

> 📖 참조: https://kotlinlang.org/docs/extensions.html

확장 함수는 기존 클래스를 수정하지 않고 새로운 함수를 추가하는 기능입니다.

```kotlin
// String 클래스에 새로운 함수 추가
fun String.addExclamation(): String {
    return this + "!"
}

// 사용
val greeting = "Hello"
println(greeting.addExclamation())  // Hello!
```

### 문법

```kotlin
fun 수신타입.함수이름(파라미터): 반환타입 {
    // this는 수신 객체를 참조
    return ...
}
```

---

## 2. 수신 객체 (this)

확장 함수 내부에서 `this`는 함수가 호출되는 객체(수신 객체)를 참조합니다.

```kotlin
fun String.addBrackets(): String {
    return "[$this]"  // this는 호출되는 String
}

println("Hello".addBrackets())  // [Hello]
```

### this 생략

`this`는 생략할 수 있습니다.

```kotlin
fun String.double(): String {
    return this + this
    // 또는
    // return "$this$this"
}

println("Hi".double())  // HiHi
```

---

## 3. 다양한 타입에 확장 함수

### Int에 확장 함수

```kotlin
fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun Int.square(): Int {
    return this * this
}

println(4.isEven())   // true
println(5.isEven())   // false
println(4.square())   // 16
```

### List에 확장 함수

```kotlin
fun List<Int>.secondOrNull(): Int? {
    return if (this.size >= 2) this[1] else null
}

println(listOf(1, 2, 3).secondOrNull())  // 2
println(listOf(1).secondOrNull())        // null
```

### 제네릭 확장 함수

```kotlin
fun <T> List<T>.secondElement(): T? {
    return if (this.size >= 2) this[1] else null
}

println(listOf("a", "b", "c").secondElement())  // b
println(listOf(1, 2, 3).secondElement())        // 2
```

---

## 4. Nullable 수신 타입

`null`일 수 있는 타입에도 확장 함수를 정의할 수 있습니다.

```kotlin
fun String?.orEmpty(): String {
    return this ?: ""
}

val name: String? = null
println(name.orEmpty())  // "" (빈 문자열)

val greeting: String? = "Hello"
println(greeting.orEmpty())  // Hello
```

### null 안전한 확장 함수

```kotlin
fun String?.isNullOrShort(): Boolean {
    return this == null || this.length < 3
}

println(null.isNullOrShort())     // true
println("Hi".isNullOrShort())     // true
println("Hello".isNullOrShort())  // false
```

---

## 5. 확장 프로퍼티

함수뿐만 아니라 프로퍼티도 확장할 수 있습니다.

```kotlin
val String.firstChar: Char?
    get() = this.firstOrNull()

val String.lastChar: Char?
    get() = this.lastOrNull()

println("Hello".firstChar)  // H
println("Hello".lastChar)   // o
println("".firstChar)       // null
```

### 주의사항

확장 프로퍼티는 backing field를 가질 수 없습니다. (상태 저장 불가)

```kotlin
// ❌ 불가능
// val String.cached: String = ""

// ✅ getter만 가능
val String.reversed: String
    get() = this.reversed()
```

---

## 6. 표준 라이브러리의 확장 함수들

Kotlin 표준 라이브러리는 많은 확장 함수를 제공합니다.

```kotlin
// String 확장
"hello".uppercase()          // HELLO
"HELLO".lowercase()          // hello
"  hello  ".trim()           // hello
"hello".repeat(3)            // hellohellohello
"hello".reversed()           // olleh

// Collection 확장
listOf(1, 2, 3).sum()        // 6
listOf(1, 2, 3).average()    // 2.0
listOf(3, 1, 2).sorted()     // [1, 2, 3]

// Any? 확장
val obj: Any? = "Hello"
obj?.toString()              // Hello
```

---

## 7. 멤버 함수 vs 확장 함수

멤버 함수가 확장 함수보다 우선합니다.

```kotlin
class Example {
    fun printMe() = println("Member")
}

fun Example.printMe() = println("Extension")

Example().printMe()  // Member (멤버 함수 호출)
```

---

## 8. 흔히 하는 실수

### 실수 1: private 멤버 접근

확장 함수는 클래스의 private/protected 멤버에 접근할 수 없습니다.

```kotlin
class Person(private val secret: String)

// ❌ 컴파일 에러
// fun Person.revealSecret() = this.secret

// ✅ public 멤버만 접근 가능
class Person(val name: String)
fun Person.greet() = "Hello, ${this.name}"
```

### 실수 2: 확장 프로퍼티에 상태 저장

```kotlin
// ❌ backing field 불가
// var String.extra: String = ""

// ✅ 계산된 값만 반환
val String.wordCount: Int
    get() = this.split(" ").size
```

### 실수 3: 상속에서의 동작

확장 함수는 정적으로 해석됩니다 (오버라이드 안됨).

```kotlin
open class Parent
class Child : Parent()

fun Parent.greet() = "I'm Parent"
fun Child.greet() = "I'm Child"

fun callGreet(p: Parent) = p.greet()

callGreet(Child())  // "I'm Parent" (타입이 Parent로 선언됨)
```

---

## 9. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 확장 함수의 기본 문법을 알고 있나요?
- [ ] `this`가 무엇을 참조하는지 이해했나요?
- [ ] Nullable 타입에 확장 함수를 정의할 수 있나요?
- [ ] 확장 프로퍼티를 정의할 수 있나요?
- [ ] 멤버 함수와 확장 함수의 우선순위를 알고 있나요?

---

## 10. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Extensions](https://kotlinlang.org/docs/extensions.html)
- [Extension Functions](https://kotlinlang.org/docs/extensions.html#extension-functions)
- [Extension Properties](https://kotlinlang.org/docs/extensions.html#extension-properties)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
