# Mission 7 학습 자료: Null Safety (널 안전성)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Null Safety](https://kotlinlang.org/docs/null-safety.html)

---

## 1. Null Safety 개요

> 📖 참조: https://kotlinlang.org/docs/null-safety.html

Kotlin은 **NullPointerException(NPE)**을 방지하기 위해 타입 시스템 레벨에서 null을 구분합니다.

### Nullable vs Non-null

```kotlin
// Non-null (기본)
var name: String = "Alice"
// name = null  // ❌ 컴파일 에러!

// Nullable (? 붙임)
var nickname: String? = "Ali"
nickname = null  // ✅ OK
```

---

## 2. Nullable 타입 선언

### 기본 문법

```kotlin
val a: String = "Hello"     // Non-null String
val b: String? = null       // Nullable String

val x: Int = 10             // Non-null Int
val y: Int? = null          // Nullable Int

val list: List<String> = listOf("a")      // Non-null List
val nullableList: List<String>? = null    // Nullable List
```

---

## 3. Safe Call 연산자 (?.)

> 📖 참조: https://kotlinlang.org/docs/null-safety.html#safe-calls

null이 아닐 때만 메서드/프로퍼티에 접근합니다.

```kotlin
val name: String? = "Alice"

// Safe call - null이면 null 반환
val length: Int? = name?.length  // 5

val nullName: String? = null
val nullLength: Int? = nullName?.length  // null (에러 없음!)
```

### 체이닝

```kotlin
val city: String? = user?.address?.city

// 위 코드는 아래와 동일
val city: String? = if (user != null && user.address != null) {
    user.address.city
} else {
    null
}
```

---

## 4. Elvis 연산자 (?:)

> 📖 참조: https://kotlinlang.org/docs/null-safety.html#elvis-operator

null일 때 기본값을 제공합니다.

```kotlin
val name: String? = null

// Elvis 연산자 사용
val displayName: String = name ?: "Unknown"
println(displayName)  // Unknown

// Safe call과 함께 사용
val length: Int = name?.length ?: 0
println(length)  // 0
```

### 실용적인 예시

```kotlin
fun getUsername(user: User?): String {
    return user?.name ?: "Guest"
}

// 일찍 반환하기
fun process(data: String?) {
    val value = data ?: return  // null이면 함수 종료
    println(value.uppercase())
}
```

---

## 5. Not-null 단언 연산자 (!!)

> 📖 참조: https://kotlinlang.org/docs/null-safety.html#the-operator

**주의: null이면 NPE 발생!** 확실히 null이 아닐 때만 사용하세요.

```kotlin
val name: String? = "Alice"

// !! 사용 - null이 아님을 단언
val length: Int = name!!.length  // 5

// ⚠️ 위험! null이면 NPE 발생
val nullName: String? = null
// val len = nullName!!.length  // NPE!
```

### 언제 사용하나요?

```kotlin
// 논리적으로 절대 null이 아닐 때
fun processNotNull(items: List<String>) {
    if (items.isNotEmpty()) {
        val first = items.firstOrNull()!!  // 이미 비어있지 않음을 확인
        println(first)
    }
}
```

---

## 6. 안전한 캐스팅 (as?)

```kotlin
val obj: Any = "Hello"

// 안전한 캐스팅 - 실패하면 null
val str: String? = obj as? String  // "Hello"
val num: Int? = obj as? Int        // null (에러 없음)
```

---

## 7. let과 함께 사용

`?.let`은 null이 아닐 때만 블록을 실행합니다.

```kotlin
val name: String? = "Alice"

// null이 아닐 때만 실행
name?.let {
    println("Name is $it")
    println("Length is ${it.length}")
}

// null이면 아무것도 실행 안됨
val nullName: String? = null
nullName?.let {
    println("This won't be printed")
}
```

### Elvis와 함께

```kotlin
val name: String? = null

val result = name?.let {
    "Hello, $it"
} ?: "Hello, Guest"

println(result)  // Hello, Guest
```

---

## 8. Nullable 컬렉션

### 리스트 요소가 nullable

```kotlin
val list: List<String?> = listOf("a", null, "c")

// filterNotNull로 null 제거
val nonNullList: List<String> = list.filterNotNull()  // ["a", "c"]
```

### 리스트 자체가 nullable

```kotlin
val nullableList: List<String>? = null

// safe call 사용
val size = nullableList?.size ?: 0
```

---

## 9. 흔히 하는 실수

### 실수 1: !!를 남용

```kotlin
// ❌ 위험한 코드
fun getName(user: User?): String {
    return user!!.name!!  // NPE 가능!
}

// ✅ 안전한 코드
fun getName(user: User?): String {
    return user?.name ?: "Unknown"
}
```

### 실수 2: Safe call 결과 타입 무시

```kotlin
val name: String? = "Alice"

// ❌ 타입 불일치
// val length: Int = name?.length  // Int?가 반환됨

// ✅ 올바른 타입 또는 Elvis 사용
val length: Int? = name?.length
val safeLength: Int = name?.length ?: 0
```

### 실수 3: null 체크 후에도 스마트 캐스트 안됨

```kotlin
var name: String? = "Alice"

// ❌ var는 스마트 캐스트 안됨 (다른 스레드가 변경할 수 있음)
if (name != null) {
    // println(name.length)  // 여전히 String?로 취급될 수 있음
}

// ✅ let 사용
name?.let {
    println(it.length)  // it은 String
}
```

---

## 10. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] `String`과 `String?`의 차이를 알고 있나요?
- [ ] Safe call `?.`를 사용할 수 있나요?
- [ ] Elvis `?:`로 기본값을 제공할 수 있나요?
- [ ] `!!`의 위험성을 이해했나요?
- [ ] `?.let`을 사용할 수 있나요?

---

## 11. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Null Safety](https://kotlinlang.org/docs/null-safety.html)
- [Safe Calls](https://kotlinlang.org/docs/null-safety.html#safe-calls)
- [Elvis Operator](https://kotlinlang.org/docs/null-safety.html#elvis-operator)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
