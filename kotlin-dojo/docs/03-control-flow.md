# Mission 3 학습 자료: Control Flow (제어 흐름)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 참조: [Kotlin 공식 문서 - Control Flow](https://kotlinlang.org/docs/control-flow.html)

---

## 1. if 표현식

> 참조: https://kotlinlang.org/docs/control-flow.html#if-expression

Kotlin에서 `if`는 **표현식(expression)**입니다. 값을 반환할 수 있습니다.

### 기본 사용법

```kotlin
val max = if (a > b) a else b
```

### 블록으로 사용

```kotlin
val max = if (a > b) {
    println("a가 더 큼")
    a  // 마지막 표현식이 반환값
} else {
    println("b가 더 큼")
    b
}
```

### if-else if-else

```kotlin
val result = if (score >= 90) {
    "A"
} else if (score >= 80) {
    "B"
} else {
    "C"
}
```

---

## 2. when 표현식

> 참조: https://kotlinlang.org/docs/control-flow.html#when-expression

Java의 `switch`보다 훨씬 강력합니다.

### 기본 사용법

```kotlin
val result = when (x) {
    1 -> "one"
    2 -> "two"
    else -> "other"
}
```

### 여러 값 매칭

```kotlin
when (x) {
    0, 1 -> println("0 또는 1")
    else -> println("그 외")
}
```

### 범위 검사

```kotlin
when (score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    else -> "F"
}
```

### 타입 검사

```kotlin
when (obj) {
    is String -> println("문자열: ${obj.length}")
    is Int -> println("정수: $obj")
    else -> println("알 수 없음")
}
```

### 조건식으로 사용

```kotlin
when {
    x < 0 -> "음수"
    x == 0 -> "0"
    else -> "양수"
}
```

---

## 3. for 반복문

> 참조: https://kotlinlang.org/docs/control-flow.html#for-loops

### Range를 이용한 반복

```kotlin
for (i in 1..5) {
    println(i)  // 1, 2, 3, 4, 5
}
```

### until (마지막 값 제외)

```kotlin
for (i in 0 until 5) {
    println(i)  // 0, 1, 2, 3, 4
}
```

### downTo (역순)

```kotlin
for (i in 5 downTo 1) {
    println(i)  // 5, 4, 3, 2, 1
}
```

### step (증가폭)

```kotlin
for (i in 0..10 step 2) {
    println(i)  // 0, 2, 4, 6, 8, 10
}
```

### 컬렉션 순회

```kotlin
val items = listOf("a", "b", "c")
for (item in items) {
    println(item)
}

// 인덱스와 함께
for ((index, value) in items.withIndex()) {
    println("$index: $value")
}
```

---

## 4. while 반복문

> 참조: https://kotlinlang.org/docs/control-flow.html#while-loops

### while

```kotlin
var x = 5
while (x > 0) {
    println(x)
    x--
}
```

### do-while

```kotlin
var x = 0
do {
    println(x)
    x++
} while (x < 5)
```

---

## 5. Range

> 참조: https://kotlinlang.org/docs/ranges.html

### 범위 생성

```kotlin
val range1 = 1..10      // 1부터 10까지 (10 포함)
val range2 = 1 until 10 // 1부터 9까지 (10 미포함)
val range3 = 10 downTo 1 // 10부터 1까지 역순
```

### 범위 검사 (in 연산자)

```kotlin
val x = 5
if (x in 1..10) {
    println("x는 1~10 사이")
}

if (x !in 1..10) {
    println("x는 1~10 밖")
}
```

---

## 6. 흔히 하는 실수

### 실수 1: if를 문장처럼 사용

```kotlin
// Java 스타일 (동작하지만 비권장)
var result: String
if (x > 0) {
    result = "양수"
} else {
    result = "음수"
}

// Kotlin 스타일 (권장)
val result = if (x > 0) "양수" else "음수"
```

### 실수 2: when에서 else 누락

```kotlin
// 컴파일 에러! 모든 케이스를 커버하지 않으면 else 필요
val result = when (x) {
    1 -> "one"
    2 -> "two"
    // else 없으면 에러
}
```

### 실수 3: ..와 until 혼동

```kotlin
for (i in 1..5)    // 1, 2, 3, 4, 5 (5 포함)
for (i in 1 until 5) // 1, 2, 3, 4 (5 미포함)
```

---

## 7. 체크리스트

미션을 풀기 전에 이해했는지 확인하세요:

- [ ] `if`가 표현식으로 값을 반환할 수 있다는 것을 이해했나요?
- [ ] `when`의 다양한 사용법(값 매칭, 범위, 조건식)을 알고 있나요?
- [ ] `for`와 Range(`..`, `until`, `downTo`, `step`)를 사용할 수 있나요?
- [ ] `while`과 `do-while`의 차이를 알고 있나요?
- [ ] `in` 연산자로 범위를 검사할 수 있나요?

---

## 8. 더 알아보기

- [Kotlin Control Flow](https://kotlinlang.org/docs/control-flow.html)
- [Kotlin Ranges](https://kotlinlang.org/docs/ranges.html)

---

**준비되셨나요? 이제 `src/main/kotlin/mission3/README.md`를 확인하고 구현을 시작하세요!**
