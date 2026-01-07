# Mission 12 학습 자료: 특수 클래스 (Sealed, Data, Enum Classes)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Sealed Classes](https://kotlinlang.org/docs/sealed-classes.html)

---

## 1. Enum Class

> 📖 참조: https://kotlinlang.org/docs/enum-classes.html

열거형 클래스는 고정된 상수 집합을 정의합니다.

### 기본 Enum

```kotlin
enum class Direction {
    NORTH, SOUTH, EAST, WEST
}

// 사용
val direction = Direction.NORTH
println(direction)       // NORTH
println(direction.name)  // NORTH
println(direction.ordinal)  // 0 (순서)
```

### 프로퍼티가 있는 Enum

```kotlin
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

println(Color.RED.rgb)  // 16711680
```

### Enum 메서드

```kotlin
enum class Planet(val mass: Double, val radius: Double) {
    EARTH(5.972e24, 6.371e6),
    MARS(6.39e23, 3.389e6);  // 세미콜론 필수!

    fun surfaceGravity(): Double {
        val G = 6.67430e-11
        return G * mass / (radius * radius)
    }
}
```

### Enum 순회 및 검색

```kotlin
enum class Day { MON, TUE, WED, THU, FRI, SAT, SUN }

// 모든 값 순회
Day.values().forEach { println(it) }
// 또는
Day.entries.forEach { println(it) }

// 이름으로 검색
val day = Day.valueOf("MON")
println(day)  // MON

// 안전한 검색
val maybeDday = Day.entries.find { it.name == "MON" }
```

---

## 2. Data Class (복습)

> 📖 참조: https://kotlinlang.org/docs/data-classes.html

```kotlin
data class User(val name: String, val age: Int)

// 자동 생성: equals(), hashCode(), toString(), copy(), componentN()

val user1 = User("Alice", 25)
val user2 = User("Alice", 25)

println(user1 == user2)  // true (값 비교)
println(user1)           // User(name=Alice, age=25)

// copy
val user3 = user1.copy(age = 30)
println(user3)  // User(name=Alice, age=30)

// 구조 분해
val (name, age) = user1
println("$name is $age")  // Alice is 25
```

---

## 3. Sealed Class

> 📖 참조: https://kotlinlang.org/docs/sealed-classes.html

Sealed 클래스는 **제한된 계층 구조**를 정의합니다. 모든 서브클래스가 컴파일 타임에 알려집니다.

### 기본 Sealed Class

```kotlin
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}
```

### when과 함께 사용

Sealed 클래스를 when과 사용하면 **else 없이** 모든 케이스를 처리할 수 있습니다.

```kotlin
fun handleResult(result: Result): String {
    return when (result) {
        is Result.Success -> "Data: ${result.data}"
        is Result.Error -> "Error: ${result.message}"
        is Result.Loading -> "Loading..."
        // else 불필요! 모든 케이스가 처리됨
    }
}
```

### 실용적인 예: API 응답

```kotlin
sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error(val code: Int, val message: String) : ApiResponse<Nothing>()
    object Loading : ApiResponse<Nothing>()
}

fun <T> handleResponse(response: ApiResponse<T>): String {
    return when (response) {
        is ApiResponse.Success -> "Got: ${response.data}"
        is ApiResponse.Error -> "Error ${response.code}: ${response.message}"
        is ApiResponse.Loading -> "Please wait..."
    }
}
```

---

## 4. Sealed Interface

Kotlin 1.5부터 sealed interface도 가능합니다.

```kotlin
sealed interface Error {
    data class NetworkError(val code: Int) : Error
    data class DatabaseError(val table: String) : Error
    object UnknownError : Error
}
```

---

## 5. Enum vs Sealed Class

| 특징 | Enum | Sealed Class |
|------|------|--------------|
| 인스턴스 | 고정된 싱글톤 | 다양한 인스턴스 가능 |
| 데이터 | 모두 같은 프로퍼티 | 각각 다른 프로퍼티 가능 |
| 상속 | 불가 | 가능 |
| 사용 시점 | 단순한 상태/옵션 | 복잡한 상태/결과 |

```kotlin
// Enum - 단순한 상태
enum class Status { PENDING, APPROVED, REJECTED }

// Sealed - 데이터가 다른 상태
sealed class OrderStatus {
    object Pending : OrderStatus()
    data class Shipped(val trackingId: String) : OrderStatus()
    data class Delivered(val date: String) : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}
```

---

## 6. when 표현식

### Enum with when

```kotlin
enum class Color { RED, GREEN, BLUE }

fun describe(color: Color): String = when (color) {
    Color.RED -> "Hot"
    Color.GREEN -> "Nature"
    Color.BLUE -> "Cool"
}
```

### Sealed with when

```kotlin
sealed class Shape {
    data class Circle(val radius: Double) : Shape()
    data class Rectangle(val width: Double, val height: Double) : Shape()
    object Empty : Shape()
}

fun area(shape: Shape): Double = when (shape) {
    is Shape.Circle -> Math.PI * shape.radius * shape.radius
    is Shape.Rectangle -> shape.width * shape.height
    is Shape.Empty -> 0.0
}
```

---

## 7. 흔히 하는 실수

### 실수 1: Enum에서 세미콜론 누락

```kotlin
enum class Planet(val mass: Double) {
    EARTH(5.972e24),
    MARS(6.39e23)  // ❌ 메서드가 있으면 세미콜론 필요!

    fun gravity() = ...
}

// ✅ 올바른 코드
enum class Planet(val mass: Double) {
    EARTH(5.972e24),
    MARS(6.39e23);  // 세미콜론!

    fun gravity() = ...
}
```

### 실수 2: Sealed class when에서 else 사용

```kotlin
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val msg: String) : Result()
}

// ⚠️ else 사용 시 새 서브클래스 추가해도 컴파일 에러 없음
fun handle(r: Result) = when (r) {
    is Result.Success -> "ok"
    else -> "fail"  // 새 타입 추가 시 버그 가능!
}

// ✅ 모든 케이스 명시
fun handle(r: Result) = when (r) {
    is Result.Success -> "ok"
    is Result.Error -> "error: ${r.msg}"
}
```

### 실수 3: Data class 프로퍼티 누락

```kotlin
// ❌ 본문에 선언된 프로퍼티는 equals/hashCode에 포함 안됨
data class User(val id: Int) {
    var name: String = ""  // equals 비교에서 제외됨!
}

// ✅ 생성자에 모든 프로퍼티 선언
data class User(val id: Int, val name: String)
```

---

## 8. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] Enum class를 선언하고 사용할 수 있나요?
- [ ] Enum에 프로퍼티와 메서드를 추가할 수 있나요?
- [ ] Data class의 자동 생성 기능을 알고 있나요?
- [ ] Sealed class의 용도를 이해했나요?
- [ ] when과 sealed class를 함께 사용할 수 있나요?
- [ ] Enum과 Sealed class의 차이를 알고 있나요?

---

## 9. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Enum Classes](https://kotlinlang.org/docs/enum-classes.html)
- [Kotlin Data Classes](https://kotlinlang.org/docs/data-classes.html)
- [Kotlin Sealed Classes](https://kotlinlang.org/docs/sealed-classes.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
