# Mission 9 학습 자료: Scope Functions (스코프 함수)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Scope Functions](https://kotlinlang.org/docs/scope-functions.html)

---

## 1. Scope Functions 개요

> 📖 참조: https://kotlinlang.org/docs/scope-functions.html

Scope Functions는 객체의 컨텍스트 내에서 코드 블록을 실행하는 함수들입니다.

| 함수 | 객체 참조 | 반환값 | 사용 시점 |
|------|----------|--------|----------|
| `let` | `it` | 람다 결과 | null 체크, 변환 |
| `run` | `this` | 람다 결과 | 객체 초기화 + 결과 계산 |
| `with` | `this` | 람다 결과 | 그룹화된 함수 호출 |
| `apply` | `this` | 컨텍스트 객체 | 객체 설정 |
| `also` | `it` | 컨텍스트 객체 | 부수 효과 |

---

## 2. let

> 📖 참조: https://kotlinlang.org/docs/scope-functions.html#let

### 기본 사용법

```kotlin
val result = "Hello".let {
    println("Original: $it")
    it.uppercase()  // 반환값
}
println(result)  // HELLO
```

### null 체크와 함께

```kotlin
val name: String? = "Alice"

name?.let {
    println("Name is $it")
    println("Length is ${it.length}")
}

// null이면 실행 안됨
val nullName: String? = null
nullName?.let {
    println("This won't print")
}
```

### 변환에 사용

```kotlin
val numbers = listOf(1, 2, 3)
val doubled = numbers.let {
    it.map { num -> num * 2 }
}
println(doubled)  // [2, 4, 6]
```

---

## 3. run

> 📖 참조: https://kotlinlang.org/docs/scope-functions.html#run

### 객체의 run

```kotlin
val result = "Hello".run {
    println("Original: $this")
    uppercase()  // this는 생략 가능
}
println(result)  // HELLO
```

### 객체 초기화 + 결과 계산

```kotlin
data class Person(var name: String, var age: Int)

val description = Person("Alice", 25).run {
    age += 1  // this.age
    "Name: $name, Age: $age"
}
println(description)  // Name: Alice, Age: 26
```

### 비-확장 run

```kotlin
val hexColor = run {
    val red = 255
    val green = 128
    val blue = 0
    "#%02X%02X%02X".format(red, green, blue)
}
println(hexColor)  // #FF8000
```

---

## 4. with

> 📖 참조: https://kotlinlang.org/docs/scope-functions.html#with

`with`는 확장 함수가 아닙니다. 첫 번째 인자로 객체를 받습니다.

```kotlin
val numbers = mutableListOf(1, 2, 3)

val result = with(numbers) {
    add(4)
    add(5)
    "Size: $size"  // 반환값
}
println(result)   // Size: 5
println(numbers)  // [1, 2, 3, 4, 5]
```

### 그룹화된 함수 호출

```kotlin
data class Config(var host: String = "", var port: Int = 0)

val config = Config()
with(config) {
    host = "localhost"
    port = 8080
}
println(config)  // Config(host=localhost, port=8080)
```

---

## 5. apply

> 📖 참조: https://kotlinlang.org/docs/scope-functions.html#apply

객체를 설정하고 **객체 자체를 반환**합니다.

```kotlin
data class Person(var name: String = "", var age: Int = 0)

val person = Person().apply {
    name = "Alice"
    age = 25
}
println(person)  // Person(name=Alice, age=25)
```

### 빌더 패턴처럼

```kotlin
val sb = StringBuilder().apply {
    append("Hello")
    append(" ")
    append("World")
}
println(sb.toString())  // Hello World
```

### 체이닝

```kotlin
data class User(var name: String = "", var email: String = "")

val user = User()
    .apply { name = "Alice" }
    .apply { email = "alice@example.com" }
println(user)  // User(name=Alice, email=alice@example.com)
```

---

## 6. also

> 📖 참조: https://kotlinlang.org/docs/scope-functions.html#also

부수 효과(side effect)를 위해 사용하고 **객체 자체를 반환**합니다.

```kotlin
val numbers = mutableListOf(1, 2, 3)
    .also { println("Before: $it") }
    .also { it.add(4) }
    .also { println("After: $it") }

// Before: [1, 2, 3]
// After: [1, 2, 3, 4]
```

### 로깅에 유용

```kotlin
fun processData(data: String) = data
    .also { println("Input: $it") }
    .uppercase()
    .also { println("Output: $it") }

processData("hello")
// Input: hello
// Output: HELLO
```

---

## 7. 선택 가이드

### let을 사용할 때
- null이 아닌 객체에서만 코드 실행
- 표현식의 결과를 변수에 할당

```kotlin
val name: String? = getName()
name?.let { processName(it) }
```

### apply를 사용할 때
- 객체 초기화/설정
- 객체 자체가 필요할 때

```kotlin
val textView = TextView(context).apply {
    text = "Hello"
    textSize = 16f
}
```

### also를 사용할 때
- 로깅, 디버깅
- 객체를 변경하지 않는 부수 효과

```kotlin
val user = createUser()
    .also { log("Created user: $it") }
```

### run을 사용할 때
- 객체의 함수를 호출하고 결과가 필요할 때

```kotlin
val result = config.run {
    validate()
    connect()
}
```

### with를 사용할 때
- 반환값이 필요 없을 때
- 객체의 여러 메서드 호출 그룹화

```kotlin
with(document) {
    setTitle("Report")
    setAuthor("Alice")
    save()
}
```

---

## 8. this vs it

| 함수 | 참조 방식 | 특징 |
|------|----------|------|
| `let`, `also` | `it` | 명시적, 이름 변경 가능 |
| `run`, `with`, `apply` | `this` | 암시적, 생략 가능 |

```kotlin
// it 사용 - 명시적
"Hello".let { str ->  // it 대신 이름 지정 가능
    println(str)
}

// this 사용 - 암시적
"Hello".run {
    println(this)    // 명시적
    println(length)  // this 생략
}
```

---

## 9. 흔히 하는 실수

### 실수 1: let과 apply 혼동

```kotlin
// ❌ let은 람다 결과를 반환
val result = person.let {
    it.name = "Bob"
    // 반환값이 Unit이면 Unit 반환
}

// ✅ apply는 객체 자체를 반환
val person = Person().apply {
    name = "Bob"
}
```

### 실수 2: 중첩 시 this/it 혼동

```kotlin
// ❌ 중첩된 this 혼동
person.apply {
    address.apply {
        // 여기서 this는 address
        // person에 접근하려면?
    }
}

// ✅ 레이블 사용
person.apply outer@{
    address.apply {
        this@outer.name = "..."  // person의 name
    }
}
```

---

## 10. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 5가지 scope function의 차이를 알고 있나요?
- [ ] `this`와 `it`의 차이를 이해했나요?
- [ ] 각 함수의 반환값이 무엇인지 알고 있나요?
- [ ] `?.let`으로 null 체크를 할 수 있나요?
- [ ] `apply`로 객체를 초기화할 수 있나요?

---

## 11. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Scope Functions](https://kotlinlang.org/docs/scope-functions.html)
- [Function Selection](https://kotlinlang.org/docs/scope-functions.html#function-selection)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
