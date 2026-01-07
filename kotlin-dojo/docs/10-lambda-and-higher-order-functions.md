# Mission 10 학습 자료: 람다와 고차 함수 (Lambda & Higher-order Functions)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Lambdas](https://kotlinlang.org/docs/lambdas.html)

---

## 1. 람다 표현식 (Lambda Expressions)

> 📖 참조: https://kotlinlang.org/docs/lambdas.html#lambda-expressions-and-anonymous-functions

람다는 이름 없는 함수입니다. 함수를 값처럼 다룰 수 있게 합니다.

### 기본 문법

```kotlin
// 람다 표현식
val sum = { a: Int, b: Int -> a + b }

// 사용
println(sum(3, 5))  // 8
```

### 람다 문법 상세

```kotlin
// 전체 문법
val sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }

// 타입 추론
val sum = { a: Int, b: Int -> a + b }  // 반환 타입 추론

// 파라미터 타입 추론 (타입이 명시된 경우)
val sum: (Int, Int) -> Int = { a, b -> a + b }
```

### 단일 파라미터 - it

```kotlin
val double: (Int) -> Int = { it * 2 }
println(double(5))  // 10

// 동일한 표현
val double = { x: Int -> x * 2 }
```

---

## 2. 고차 함수 (Higher-order Functions)

> 📖 참조: https://kotlinlang.org/docs/lambdas.html#higher-order-functions

고차 함수는 **함수를 파라미터로 받거나** **함수를 반환하는** 함수입니다.

### 함수를 파라미터로 받기

```kotlin
fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// 사용
val result = operate(10, 5, { a, b -> a + b })
println(result)  // 15

// 또는
val sum = { a: Int, b: Int -> a + b }
val result = operate(10, 5, sum)
```

### 함수를 반환하기

```kotlin
fun multiplyBy(factor: Int): (Int) -> Int {
    return { number -> number * factor }
}

val double = multiplyBy(2)
val triple = multiplyBy(3)

println(double(5))  // 10
println(triple(5))  // 15
```

---

## 3. 트레일링 람다 (Trailing Lambda)

마지막 파라미터가 람다면 괄호 밖으로 뺄 수 있습니다.

```kotlin
fun repeat(times: Int, action: (Int) -> Unit) {
    for (i in 0 until times) {
        action(i)
    }
}

// 일반적인 호출
repeat(3, { println("Hello $it") })

// 트레일링 람다
repeat(3) { println("Hello $it") }

// 람다만 있으면 괄호 생략 가능
val list = listOf(1, 2, 3)
list.forEach { println(it) }
```

---

## 4. 컬렉션과 람다

### map

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val doubled = numbers.map { it * 2 }
println(doubled)  // [2, 4, 6, 8, 10]
```

### filter

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val evens = numbers.filter { it % 2 == 0 }
println(evens)  // [2, 4]
```

### reduce / fold

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

// reduce: 첫 요소부터 시작
val sum = numbers.reduce { acc, num -> acc + num }
println(sum)  // 15

// fold: 초기값 지정
val sum2 = numbers.fold(10) { acc, num -> acc + num }
println(sum2)  // 25 (10 + 1 + 2 + 3 + 4 + 5)
```

### sortedBy

```kotlin
data class Person(val name: String, val age: Int)

val people = listOf(
    Person("Alice", 30),
    Person("Bob", 25),
    Person("Charlie", 35)
)

val sortedByAge = people.sortedBy { it.age }
println(sortedByAge)
// [Person(Bob, 25), Person(Alice, 30), Person(Charlie, 35)]
```

### groupBy

```kotlin
val words = listOf("apple", "banana", "cherry", "apricot")
val grouped = words.groupBy { it.first() }
println(grouped)
// {a=[apple, apricot], b=[banana], c=[cherry]}
```

---

## 5. 함수 타입

### 함수 타입 선언

```kotlin
// (파라미터 타입) -> 반환 타입
val sum: (Int, Int) -> Int = { a, b -> a + b }
val print: (String) -> Unit = { println(it) }
val noParam: () -> String = { "Hello" }
```

### Nullable 함수 타입

```kotlin
// 함수 자체가 nullable
var callback: ((Int) -> Unit)? = null

callback?.invoke(42)  // null이면 실행 안됨

callback = { println(it) }
callback?.invoke(42)  // 42 출력
```

---

## 6. 함수 참조 (Function Reference)

`::` 연산자로 기존 함수를 참조할 수 있습니다.

```kotlin
fun isEven(n: Int) = n % 2 == 0

val numbers = listOf(1, 2, 3, 4, 5)
val evens = numbers.filter(::isEven)
println(evens)  // [2, 4]
```

### 메서드 참조

```kotlin
val numbers = listOf(1, 2, 3)
val strings = numbers.map(Int::toString)
println(strings)  // ["1", "2", "3"]
```

---

## 7. inline 함수

> 📖 참조: https://kotlinlang.org/docs/inline-functions.html

람다를 사용하면 객체가 생성되어 오버헤드가 발생합니다. `inline`으로 이를 방지할 수 있습니다.

```kotlin
inline fun measureTime(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}
```

---

## 8. 흔히 하는 실수

### 실수 1: 람다에서 return

```kotlin
fun findFirst(list: List<Int>): Int? {
    list.forEach {
        if (it > 3) return it  // 함수 전체에서 return!
    }
    return null
}

// 람다에서만 return하려면 레이블 사용
fun findFirst2(list: List<Int>): Int? {
    var result: Int? = null
    list.forEach {
        if (it > 3) {
            result = it
            return@forEach  // 람다에서만 return
        }
    }
    return result
}
```

### 실수 2: it 중첩

```kotlin
// ❌ 중첩된 it은 혼란스러움
list.forEach {
    it.items.forEach {
        println(it)  // 어떤 it?
    }
}

// ✅ 명시적 이름 사용
list.forEach { item ->
    item.items.forEach { subItem ->
        println(subItem)
    }
}
```

### 실수 3: 타입 추론 실패

```kotlin
// ❌ 컴파일 에러 - 타입 추론 불가
val operation = { a, b -> a + b }

// ✅ 타입 명시
val operation: (Int, Int) -> Int = { a, b -> a + b }
// 또는
val operation = { a: Int, b: Int -> a + b }
```

---

## 9. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 람다 표현식의 문법을 알고 있나요?
- [ ] 고차 함수가 무엇인지 이해했나요?
- [ ] 트레일링 람다를 사용할 수 있나요?
- [ ] `map`, `filter`, `fold` 등 컬렉션 함수를 사용할 수 있나요?
- [ ] 함수 타입을 선언할 수 있나요?
- [ ] `::`로 함수 참조를 사용할 수 있나요?

---

## 10. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Lambdas](https://kotlinlang.org/docs/lambdas.html)
- [Higher-order Functions](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
- [Inline Functions](https://kotlinlang.org/docs/inline-functions.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
