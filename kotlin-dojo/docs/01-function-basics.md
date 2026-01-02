# Mission 1 학습 자료: Kotlin 기초 - 함수와 문자열

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Functions](https://kotlinlang.org/docs/functions.html)

---

## 1. Kotlin 함수 기본

> 📖 참조: https://kotlinlang.org/docs/functions.html

### 함수 선언 기본 형식

```kotlin
fun 함수이름(파라미터: 타입): 반환타입 {
    // 함수 본문
    return 반환값
}
```

### 예제: 간단한 함수

```kotlin
fun greet(): String {
    return "Good Morning"
}

fun getLanguage(): String {
    return "Kotlin"
}
```

**구성 요소**:
- `fun`: 함수를 선언하는 키워드
- `greet`, `getLanguage`: 함수 이름
- `()`: 파라미터 목록 (현재는 비어있음)
- `: String`: 반환 타입 (이 함수는 문자열을 반환합니다)
- `{ ... }`: 함수 본문 (실제 코드가 들어가는 부분)
- `return "..."`: 실제로 반환하는 값

---

## 2. 문자열 (String)

> 📖 참조: https://kotlinlang.org/docs/strings.html

### 문자열 리터럴

Kotlin에서 문자열은 **큰따옴표(`"`)** 로 감싸야 합니다:

```kotlin
"Good Morning"   // ✅ 올바른 문자열
"Kotlin"         // ✅ 올바른 문자열
'Good Morning'   // ❌ 작은따옴표는 단일 문자용
Good Morning     // ❌ 따옴표 없으면 변수나 함수 이름으로 인식됨
```

### 문자열 변수 예제

```kotlin
val greeting = "안녕하세요"           // String 타입
val language = "Kotlin"             // String 타입
val message = "Welcome!"            // String 타입
```

### 작은따옴표 vs 큰따옴표

```kotlin
val char = 'A'           // ✅ Char 타입 (단일 문자)
val string = "A"         // ✅ String 타입 (문자열)
val wrong = 'AB'         // ❌ 작은따옴표는 한 문자만 가능!
```

---

## 3. return 키워드

> 📖 참조: https://kotlinlang.org/docs/returns.html

함수가 값을 **반환**할 때 `return` 키워드를 사용합니다:

```kotlin
fun getNumber(): Int {
    return 42        // 정수 42를 반환
}

fun getName(): String {
    return "Sook"    // 문자열 "Sook"을 반환
}

fun isKotlin(): Boolean {
    return true      // 불린 값 true를 반환
}
```

**중요**: 반환 타입이 지정된 함수는 반드시 값을 반환해야 합니다!

```kotlin
// ❌ 잘못된 예
fun greeting(): String {
    println("Hi")  // return이 없으면 컴파일 에러!
}

// ✅ 올바른 예
fun greeting(): String {
    return "Hi"    // String을 반환
}
```

---

## 4. println vs return

이 둘은 **완전히 다른 역할**을 합니다!

### println - 콘솔에 출력

```kotlin
fun sayHi() {
    println("Hi!")  // 콘솔에 "Hi!"를 출력
                    // 값을 반환하지 않음 (Unit 반환)
}
```

### return - 값을 반환

```kotlin
fun getHi(): String {
    return "Hi!"    // 값을 반환 (다른 곳에서 사용 가능)
                    // 콘솔에는 아무것도 출력 안 됨
}
```

### 차이점 비교

```kotlin
// 예제 1: println 사용
fun printMessage() {
    println("Welcome")     // 콘솔 출력: Welcome
}

val result1 = printMessage()  // 콘솔: Welcome
                              // result1 = Unit (값이 없음)

// 예제 2: return 사용
fun getMessage(): String {
    return "Welcome"       // 콘솔 출력: 없음
}

val result2 = getMessage()    // 콘솔: (출력 없음)
                              // result2 = "Welcome" (값을 받음)

println(result2)              // 이제 콘솔 출력: Welcome
```

**핵심 차이**:
- `println`: 화면에 **출력**만 함, 값을 돌려주지 않음
- `return`: 값을 **반환**함, 호출한 곳에서 그 값을 사용할 수 있음

---

## 5. TODO() 함수

> 📖 참조: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-t-o-d-o.html

Kotlin에서 `TODO()`는 "아직 구현되지 않음"을 나타내는 함수입니다:

```kotlin
fun someFunction(): String {
    TODO("이 함수는 아직 구현되지 않았습니다")
}
```

이 코드를 실행하면 `NotImplementedError`가 발생합니다.

**TDD 방식**에서는:
1. 🔴 **RED**: `TODO()`로 인해 테스트 실패
2. 🟢 **GREEN**: `TODO()`를 실제 구현으로 교체하여 테스트 통과

---

## 6. 단일 표현식 함수

> 📖 참조: https://kotlinlang.org/docs/functions.html#single-expression-functions

함수 본문이 한 줄일 때는 `=`를 사용해서 더 간결하게 작성할 수 있습니다:

```kotlin
// 일반 함수
fun add(a: Int, b: Int): Int {
    return a + b
}

// 단일 표현식 함수 (같은 의미)
fun add(a: Int, b: Int): Int = a + b

// 타입 추론 (반환 타입 생략 가능)
fun add(a: Int, b: Int) = a + b
```

```kotlin
// 문자열 반환 예제
fun getWelcome(): String {
    return "Welcome"
}

// 단일 표현식으로 동일하게
fun getWelcome(): String = "Welcome"
```

---

## 7. 흔히 하는 실수

### 실수 1: 따옴표 없이 문자열 사용

```kotlin
// ❌ 잘못된 예
fun getMessage(): String {
    return Good Morning  // 따옴표가 없음!
}

// ✅ 올바른 예
fun getMessage(): String {
    return "Good Morning"  // 따옴표로 감쌈
}
```

### 실수 2: println만 사용하고 return 안 함

```kotlin
// ❌ 잘못된 예
fun getMessage(): String {
    println("Good Morning")  // 출력만 하고 반환 안 함
}

// ✅ 올바른 예
fun getMessage(): String {
    return "Good Morning"    // 값을 반환
}
```

### 실수 3: return 없이 함수 끝냄

```kotlin
// ❌ 잘못된 예
fun getNumber(): Int {
    val x = 10 + 5
    // return이 없음!
}

// ✅ 올바른 예
fun getNumber(): Int {
    val x = 10 + 5
    return x
}
```

---

## 8. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] `fun` 키워드로 함수를 선언하는 방법을 이해했나요?
- [ ] 문자열은 큰따옴표(`"`)로 감싸야 한다는 것을 알고 있나요?
- [ ] `return` 키워드로 값을 반환하는 방법을 이해했나요?
- [ ] `println`과 `return`의 차이를 이해했나요?
- [ ] `TODO()`를 실제 구현으로 교체해야 한다는 것을 알고 있나요?

---

## 9. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin 함수 공식 문서](https://kotlinlang.org/docs/functions.html)
- [Kotlin 문자열 공식 문서](https://kotlinlang.org/docs/strings.html)
- [Kotlin 기본 타입 공식 문서](https://kotlinlang.org/docs/basic-types.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
