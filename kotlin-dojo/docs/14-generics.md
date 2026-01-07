# Mission 14 학습 자료: 제네릭 (Generics)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Generics](https://kotlinlang.org/docs/generics.html)

---

## 1. 제네릭 기본

> 📖 참조: https://kotlinlang.org/docs/generics.html

제네릭은 타입을 파라미터화하여 재사용 가능한 코드를 작성하게 합니다.

### 제네릭 클래스

```kotlin
class Box<T>(val value: T)

// 사용
val intBox = Box(42)         // Box<Int>
val stringBox = Box("Hello") // Box<String>

println(intBox.value)    // 42
println(stringBox.value) // Hello
```

### 제네릭 함수

```kotlin
fun <T> singletonList(item: T): List<T> {
    return listOf(item)
}

// 사용
val list1 = singletonList(42)      // List<Int>
val list2 = singletonList("Hello") // List<String>
```

---

## 2. 타입 파라미터 명명 규칙

관례적으로 사용되는 이름:
- `T` - Type
- `E` - Element (컬렉션)
- `K` - Key
- `V` - Value
- `R` - Result

```kotlin
class Map<K, V>
fun <T, R> transform(value: T, transformer: (T) -> R): R
```

---

## 3. 제네릭 제약 (Generic Constraints)

> 📖 참조: https://kotlinlang.org/docs/generics.html#upper-bounds

### Upper Bound

타입 파라미터에 상한을 지정합니다.

```kotlin
// T는 Number의 서브타입이어야 함
fun <T : Number> sum(list: List<T>): Double {
    return list.sumOf { it.toDouble() }
}

sum(listOf(1, 2, 3))      // ✅ Int는 Number의 서브타입
sum(listOf(1.5, 2.5))     // ✅ Double은 Number의 서브타입
// sum(listOf("a", "b"))  // ❌ String은 Number가 아님
```

### 여러 제약

```kotlin
// T는 Comparable이면서 CharSequence여야 함
fun <T> sort(list: List<T>) where T : Comparable<T>, T : CharSequence {
    // ...
}
```

---

## 4. 공변성 (Covariance) - out

> 📖 참조: https://kotlinlang.org/docs/generics.html#variance

`out`은 타입 파라미터가 **생산자(producer)** 위치에만 사용됨을 나타냅니다.

```kotlin
// Producer - 값을 읽기만 함
interface Source<out T> {
    fun next(): T  // T를 반환만 함
}

// Producer<Dog>를 Producer<Animal>로 사용 가능
fun demo(dogs: Source<Dog>) {
    val animals: Source<Animal> = dogs  // ✅ OK
}
```

### out의 의미

```kotlin
class Producer<out T>(private val value: T) {
    fun get(): T = value       // ✅ 반환 가능
    // fun set(v: T) { }       // ❌ 파라미터로 받을 수 없음
}
```

---

## 5. 반공변성 (Contravariance) - in

`in`은 타입 파라미터가 **소비자(consumer)** 위치에만 사용됨을 나타냅니다.

```kotlin
// Consumer - 값을 받기만 함
interface Consumer<in T> {
    fun consume(item: T)  // T를 받기만 함
}

// Consumer<Animal>을 Consumer<Dog>로 사용 가능
fun demo(animalConsumer: Consumer<Animal>) {
    val dogConsumer: Consumer<Dog> = animalConsumer  // ✅ OK
}
```

### in의 의미

```kotlin
class Sink<in T> {
    fun put(item: T) { }  // ✅ 파라미터로 받을 수 있음
    // fun get(): T { }   // ❌ 반환할 수 없음
}
```

---

## 6. 불변 (Invariant)

기본적으로 제네릭 타입은 불변입니다.

```kotlin
class Box<T>(var value: T)

val intBox: Box<Int> = Box(42)
// val anyBox: Box<Any> = intBox  // ❌ 컴파일 에러!
```

---

## 7. Star Projection (*)

> 📖 참조: https://kotlinlang.org/docs/generics.html#star-projections

타입을 모르거나 상관없을 때 `*`를 사용합니다.

```kotlin
fun printAll(list: List<*>) {
    for (item in list) {
        println(item)  // Any?로 취급
    }
}

printAll(listOf(1, 2, 3))
printAll(listOf("a", "b"))
```

---

## 8. 타입 소거 (Type Erasure)

JVM에서 제네릭 타입 정보는 런타임에 소거됩니다.

```kotlin
// 런타임에 List<Int>와 List<String>은 같은 List
fun demo(list: List<*>) {
    // if (list is List<Int>) { }  // ❌ 불가능

    // reified로 해결 (inline 함수 필요)
}
```

### reified 타입

```kotlin
inline fun <reified T> isInstance(value: Any): Boolean {
    return value is T
}

println(isInstance<String>("Hello"))  // true
println(isInstance<Int>("Hello"))     // false
```

---

## 9. 실용적인 예제

### 제네릭 데이터 클래스

```kotlin
data class Pair<A, B>(val first: A, val second: B)

val pair = Pair("name", 42)
println(pair.first)   // name
println(pair.second)  // 42
```

### 제네릭 확장 함수

```kotlin
fun <T> List<T>.secondOrNull(): T? {
    return if (size >= 2) this[1] else null
}

listOf(1, 2, 3).secondOrNull()  // 2
listOf("a").secondOrNull()       // null
```

### Result 타입

```kotlin
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: String) : Result<Nothing>()
}

fun <T> Result<T>.getOrNull(): T? = when (this) {
    is Result.Success -> data
    is Result.Failure -> null
}
```

---

## 10. 흔히 하는 실수

### 실수 1: 제네릭 타입 체크

```kotlin
// ❌ 런타임에 타입 정보가 없음
fun <T> check(list: List<*>): Boolean {
    // return list is List<T>  // 컴파일 에러!
}

// ✅ reified 사용
inline fun <reified T> checkElements(list: List<*>): Boolean {
    return list.all { it is T }
}
```

### 실수 2: 공변성 혼동

```kotlin
open class Animal
class Dog : Animal()

// List는 out (공변)
val animals: List<Animal> = listOf(Dog())  // ✅

// MutableList는 불변
// val mutableAnimals: MutableList<Animal> = mutableListOf<Dog>()  // ❌
```

### 실수 3: in/out 위치 오류

```kotlin
// ❌ out T는 반환만 가능
// class Producer<out T> {
//     fun consume(item: T) { }  // 컴파일 에러!
// }

// ✅ 올바른 사용
class Producer<out T>(private val value: T) {
    fun produce(): T = value
}
```

---

## 11. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 제네릭 클래스와 함수를 선언할 수 있나요?
- [ ] 타입 파라미터에 제약(upper bound)을 줄 수 있나요?
- [ ] `out`과 `in`의 의미를 이해했나요?
- [ ] Star projection `*`의 용도를 알고 있나요?
- [ ] `reified`의 역할을 이해했나요?

---

## 12. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Generics](https://kotlinlang.org/docs/generics.html)
- [Variance](https://kotlinlang.org/docs/generics.html#variance)
- [Type Projections](https://kotlinlang.org/docs/generics.html#type-projections)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
