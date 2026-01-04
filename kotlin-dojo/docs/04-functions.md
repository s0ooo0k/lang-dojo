# Mission 4 학습 자료: 함수 심화

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Functions](https://kotlinlang.org/docs/functions.html)

---

## 1. 기본 파라미터 (Default Parameters)

> 📖 참조: https://kotlinlang.org/docs/functions.html#default-arguments

함수의 파라미터에 기본값을 지정할 수 있습니다. 호출 시 해당 인자를 생략하면 기본값이 사용됩니다.

### 기본 문법

```kotlin
fun greet(name: String = "Guest") {
    println("Hello, $name!")
}

// 사용 예시
greet("Alice")   // 출력: Hello, Alice!
greet()          // 출력: Hello, Guest! (기본값 사용)
```

### 여러 기본 파라미터

```kotlin
fun createUser(
    name: String,
    age: Int = 0,
    city: String = "Unknown"
): String {
    return "$name ($age) from $city"
}

// 사용 예시
createUser("Alice", 25, "Seoul")  // Alice (25) from Seoul
createUser("Bob", 30)             // Bob (30) from Unknown
createUser("Charlie")             // Charlie (0) from Unknown
```

### 주의: 기본값이 있는 파라미터의 위치

```kotlin
// ✅ 권장: 기본값이 있는 파라미터는 뒤에
fun example(required: String, optional: Int = 0)

// ⚠️ 비권장: 기본값이 있는 파라미터가 앞에 있으면
fun example(optional: Int = 0, required: String)
// -> example(, "hello") 이렇게 호출할 수 없음!
// -> named argument를 써야 함: example(required = "hello")
```

---

## 2. Named Arguments (명명된 인자)

> 📖 참조: https://kotlinlang.org/docs/functions.html#named-arguments

함수 호출 시 파라미터 이름을 명시하여 인자를 전달할 수 있습니다.

### 기본 문법

```kotlin
fun printInfo(name: String, age: Int, city: String) {
    println("$name, $age, $city")
}

// 일반 호출 (순서대로)
printInfo("Alice", 25, "Seoul")

// Named arguments (순서 상관없이!)
printInfo(age = 25, city = "Seoul", name = "Alice")
printInfo(name = "Bob", city = "Busan", age = 30)
```

### 일부만 Named Argument 사용

```kotlin
fun connect(host: String, port: Int, timeout: Int = 1000) {
    println("Connecting to $host:$port (timeout: $timeout)")
}

// 앞부분은 위치로, 뒤는 named로
connect("localhost", port = 8080)
connect("localhost", 8080, timeout = 5000)
```

### 가독성 향상

```kotlin
// ❓ 무슨 값인지 불명확
createRectangle(100, 50, true, false)

// ✅ 명확함
createRectangle(
    width = 100,
    height = 50,
    filled = true,
    rounded = false
)
```

---

## 3. vararg (가변 인자)

> 📖 참조: https://kotlinlang.org/docs/functions.html#variable-number-of-arguments-varargs

개수가 정해지지 않은 여러 인자를 받을 수 있습니다.

### 기본 문법

```kotlin
fun printAll(vararg messages: String) {
    for (msg in messages) {
        println(msg)
    }
}

// 사용 예시
printAll("Hello")                    // 1개
printAll("Hello", "World")           // 2개
printAll("A", "B", "C", "D", "E")    // 5개
printAll()                           // 0개도 가능
```

### vararg는 배열처럼 동작

```kotlin
fun sum(vararg numbers: Int): Int {
    var total = 0
    for (n in numbers) {
        total += n
    }
    return total
}

sum(1, 2, 3)      // 6
sum(10, 20)       // 30
sum(5)            // 5
```

### 다른 파라미터와 함께 사용

```kotlin
// vararg는 보통 마지막에 위치
fun format(prefix: String, vararg items: String): String {
    return items.joinToString(", ", prefix = "$prefix: ")
}

format("Colors", "Red", "Green", "Blue")
// 출력: Colors: Red, Green, Blue
```

### vararg가 마지막이 아닐 때

```kotlin
fun example(vararg numbers: Int, suffix: String) {
    // suffix는 반드시 named argument로 전달해야 함
}

example(1, 2, 3, suffix = "end")  // ✅ OK
example(1, 2, 3, "end")           // ❌ 컴파일 에러
```

### 배열을 vararg에 전달: Spread 연산자 (*)

```kotlin
val array = intArrayOf(1, 2, 3)
sum(*array)  // * 연산자로 배열을 펼침

val list = listOf("A", "B", "C")
printAll(*list.toTypedArray())  // List는 toTypedArray() 필요
```

---

## 4. 단일 표현식 함수 (Single-Expression Functions)

> 📖 참조: https://kotlinlang.org/docs/functions.html#single-expression-functions

함수 본문이 단일 표현식이면 `=`을 사용하여 간결하게 작성할 수 있습니다.

```kotlin
// 일반 함수
fun double(x: Int): Int {
    return x * 2
}

// 단일 표현식 함수
fun double(x: Int): Int = x * 2

// 반환 타입도 추론 가능
fun double(x: Int) = x * 2
```

### 예제

```kotlin
fun add(a: Int, b: Int) = a + b
fun greet(name: String) = "Hello, $name!"
fun isPositive(n: Int) = n > 0
```

---

## 5. 함수 오버로딩

같은 이름의 함수를 파라미터가 다르게 여러 개 정의할 수 있습니다.

```kotlin
fun greet() = "Hello!"
fun greet(name: String) = "Hello, $name!"
fun greet(name: String, age: Int) = "Hello, $name ($age)!"

greet()              // Hello!
greet("Alice")       // Hello, Alice!
greet("Bob", 25)     // Hello, Bob (25)!
```

**참고**: 기본 파라미터를 사용하면 오버로딩을 줄일 수 있습니다.

```kotlin
// 오버로딩 대신 기본 파라미터 사용
fun greet(name: String = "World", age: Int? = null): String {
    return if (age != null) "Hello, $name ($age)!" else "Hello, $name!"
}
```

---

## 6. 흔히 하는 실수

### 실수 1: 기본값 있는 파라미터 순서

```kotlin
// ❌ 기본값 있는 파라미터가 앞에
fun bad(a: Int = 0, b: Int) { }
bad(10)  // 에러! a=10인지 b=10인지 모호

// ✅ 기본값 있는 파라미터는 뒤에
fun good(b: Int, a: Int = 0) { }
good(10)  // b=10, a=0(기본값)
```

### 실수 2: vararg 뒤의 파라미터

```kotlin
fun example(vararg nums: Int, name: String) { }

// ❌ 에러
example(1, 2, 3, "hello")

// ✅ named argument 필수
example(1, 2, 3, name = "hello")
```

### 실수 3: 배열을 vararg에 직접 전달

```kotlin
val arr = intArrayOf(1, 2, 3)

// ❌ 에러: 배열 자체가 하나의 인자로 전달됨
sum(arr)

// ✅ spread 연산자 사용
sum(*arr)
```

---

## 7. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 기본 파라미터를 정의하고 사용할 수 있나요?
- [ ] Named arguments를 사용할 수 있나요?
- [ ] vararg 파라미터를 정의하고 사용할 수 있나요?
- [ ] 단일 표현식 함수(`=`)를 작성할 수 있나요?
- [ ] spread 연산자(`*`)의 용도를 이해했나요?

---

## 8. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Functions](https://kotlinlang.org/docs/functions.html)
- [Default Arguments](https://kotlinlang.org/docs/functions.html#default-arguments)
- [Named Arguments](https://kotlinlang.org/docs/functions.html#named-arguments)
- [Variable Number of Arguments](https://kotlinlang.org/docs/functions.html#variable-number-of-arguments-varargs)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
