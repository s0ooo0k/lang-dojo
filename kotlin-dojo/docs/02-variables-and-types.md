# Mission 2 학습 자료: 변수와 기본 타입

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Basic Types](https://kotlinlang.org/docs/basic-types.html)

---

## 1. 변수 선언: val vs var

> 📖 참조: https://kotlinlang.org/docs/basic-syntax.html#variables

Kotlin에서 변수를 선언하는 두 가지 키워드가 있습니다:

### val - 읽기 전용 변수 (Immutable)

```kotlin
val name = "Kotlin"     // 한 번 할당하면 변경 불가
name = "Java"           // ❌ 컴파일 에러! val은 재할당 불가
```

### var - 변경 가능 변수 (Mutable)

```kotlin
var count = 0           // 변경 가능
count = 1               // ✅ OK
count = 100             // ✅ OK
```

### 어떤 것을 사용해야 할까?

```kotlin
// 권장: 가능하면 val 사용 (불변성)
val pi = 3.14159
val appName = "MyApp"

// 필요할 때만 var 사용
var score = 0
score += 10
```

**Best Practice**: 기본적으로 `val`을 사용하고, 값을 변경해야 할 때만 `var`을 사용하세요.

---

## 2. 기본 타입 (Basic Types)

> 📖 참조: https://kotlinlang.org/docs/numbers.html

### 정수 타입

```kotlin
val byte: Byte = 127          // 8비트, -128 ~ 127
val short: Short = 32767      // 16비트
val int: Int = 2147483647     // 32비트 (기본)
val long: Long = 9223372036854775807L  // 64비트, L 접미사
```

### 실수 타입

```kotlin
val float: Float = 3.14f      // 32비트, f 접미사 필수
val double: Double = 3.14159  // 64비트 (기본)
```

### 기타 타입

```kotlin
val isActive: Boolean = true   // true 또는 false
val letter: Char = 'A'         // 단일 문자 (작은따옴표)
val message: String = "Hello"  // 문자열 (큰따옴표)
```

---

## 3. 타입 추론 (Type Inference)

> 📖 참조: https://kotlinlang.org/docs/basic-types.html#type-inference

Kotlin은 값을 보고 타입을 자동으로 추론합니다:

```kotlin
val number = 42           // Int로 추론
val decimal = 3.14        // Double로 추론
val text = "Kotlin"       // String으로 추론
val flag = true           // Boolean으로 추론
```

명시적으로 타입을 지정할 수도 있습니다:

```kotlin
val number: Int = 42
val decimal: Double = 3.14
val text: String = "Kotlin"
```

---

## 4. 문자열 템플릿 (String Templates)

> 📖 참조: https://kotlinlang.org/docs/strings.html#string-templates

문자열 안에 변수나 표현식을 삽입할 수 있습니다:

### $ 기호로 변수 삽입

```kotlin
val language = "Kotlin"
val message = "I love $language"
println(message)  // 출력: I love Kotlin
```

### ${} 로 표현식 삽입

```kotlin
val a = 10
val b = 20
val result = "Sum: ${a + b}"
println(result)  // 출력: Sum: 30
```

### 다양한 예제

```kotlin
val name = "Alice"
val age = 25

// 변수 삽입
val intro = "My name is $name"

// 표현식 삽입
val info = "Next year I'll be ${age + 1}"

// 메서드 호출
val upper = "Name: ${name.uppercase()}"
```

---

## 5. 숫자 연산

> 📖 참조: https://kotlinlang.org/docs/numbers.html#operations-on-numbers

### 기본 산술 연산

```kotlin
val a = 10
val b = 3

val sum = a + b       // 13
val diff = a - b      // 7
val product = a * b   // 30
val quotient = a / b  // 3 (정수 나눗셈)
val remainder = a % b // 1 (나머지)
```

### 정수 나눗셈 주의

```kotlin
val x = 7 / 2         // 3 (정수끼리 나누면 정수)
val y = 7.0 / 2       // 3.5 (하나라도 실수면 실수)
val z = 7 / 2.0       // 3.5
```

---

## 6. 타입 변환

> 📖 참조: https://kotlinlang.org/docs/numbers.html#explicit-number-conversions

Kotlin은 암시적 타입 변환을 하지 않습니다. 명시적으로 변환해야 합니다:

```kotlin
val intNum: Int = 100
val longNum: Long = intNum.toLong()    // Int → Long
val doubleNum: Double = intNum.toDouble()  // Int → Double

val pi = 3.14159
val intPi: Int = pi.toInt()  // 3 (소수점 버림)
```

### 변환 메서드

```kotlin
// 숫자 변환
toInt(), toLong(), toFloat(), toDouble(), toByte(), toShort()

// 문자열 변환
toString()

// 문자열 → 숫자
"123".toInt()        // 123
"3.14".toDouble()    // 3.14
```

---

## 7. 흔히 하는 실수

### 실수 1: val에 재할당

```kotlin
// ❌ 잘못된 예
val count = 0
count = 1  // 컴파일 에러!

// ✅ var 사용
var count = 0
count = 1
```

### 실수 2: 문자열 템플릿에서 $ 누락

```kotlin
val name = "Kotlin"

// ❌ 잘못된 예
val msg = "Hello name"   // 출력: Hello name (변수가 아닌 텍스트)

// ✅ 올바른 예
val msg = "Hello $name"  // 출력: Hello Kotlin
```

### 실수 3: 정수 나눗셈 결과

```kotlin
// ❌ 예상과 다른 결과
val avg = (3 + 4) / 2    // 3 (정수 나눗셈)

// ✅ 실수 결과가 필요하면
val avg = (3 + 4) / 2.0  // 3.5
val avg = (3 + 4).toDouble() / 2  // 3.5
```

---

## 8. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] `val`과 `var`의 차이를 이해했나요?
- [ ] 기본 타입(Int, Double, Boolean, String 등)을 알고 있나요?
- [ ] 문자열 템플릿(`$변수`, `${표현식}`)을 사용할 수 있나요?
- [ ] 기본 산술 연산을 할 수 있나요?
- [ ] 타입 변환 메서드(toInt(), toDouble() 등)를 알고 있나요?

---

## 9. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Basic Types](https://kotlinlang.org/docs/basic-types.html)
- [Kotlin Numbers](https://kotlinlang.org/docs/numbers.html)
- [Kotlin Strings](https://kotlinlang.org/docs/strings.html)
- [Kotlin Variables](https://kotlinlang.org/docs/basic-syntax.html#variables)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
