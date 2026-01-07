# Mission 13 학습 자료: 프로퍼티와 위임 (Properties & Delegation)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Properties](https://kotlinlang.org/docs/properties.html)

---

## 1. 프로퍼티 기본

> 📖 참조: https://kotlinlang.org/docs/properties.html

### val과 var

```kotlin
class Person {
    val name: String = "Alice"  // 읽기 전용
    var age: Int = 25           // 읽기/쓰기
}

val person = Person()
println(person.name)  // Alice
// person.name = "Bob"  // ❌ val은 변경 불가

person.age = 26  // ✅ var는 변경 가능
```

---

## 2. 커스텀 Getter와 Setter

> 📖 참조: https://kotlinlang.org/docs/properties.html#getters-and-setters

### 커스텀 Getter

```kotlin
class Rectangle(val width: Int, val height: Int) {
    val area: Int
        get() = width * height  // 매번 계산

    val perimeter: Int
        get() = 2 * (width + height)
}

val rect = Rectangle(10, 5)
println(rect.area)       // 50
println(rect.perimeter)  // 30
```

### 커스텀 Setter

```kotlin
class User {
    var name: String = ""
        set(value) {
            field = value.trim()  // 공백 제거 후 저장
        }
}

val user = User()
user.name = "  Alice  "
println(user.name)  // "Alice"
```

### field 키워드

`field`는 backing field를 참조합니다. setter에서 무한 재귀를 방지합니다.

```kotlin
var counter: Int = 0
    set(value) {
        if (value >= 0) {
            field = value  // ✅ backing field 사용
            // counter = value  // ❌ 무한 재귀!
        }
    }
```

---

## 3. 지연 초기화 (Late Initialization)

> 📖 참조: https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables

### lateinit

Non-null 프로퍼티를 나중에 초기화할 때 사용합니다.

```kotlin
class Service {
    lateinit var api: Api  // 나중에 초기화

    fun setup() {
        api = Api()  // 실제 초기화
    }

    fun call() {
        if (::api.isInitialized) {  // 초기화 확인
            api.request()
        }
    }
}
```

**lateinit 제약:**
- `var`에만 사용 가능
- 기본 타입(Int, Boolean 등)에 사용 불가
- nullable이 아닌 타입에만 사용

---

## 4. Lazy 초기화

> 📖 참조: https://kotlinlang.org/docs/delegated-properties.html#lazy-properties

`lazy`는 첫 접근 시에만 초기화됩니다.

```kotlin
val expensiveData: String by lazy {
    println("Computing...")
    "Result"
}

println(expensiveData)  // Computing... 출력 후 "Result"
println(expensiveData)  // "Result"만 출력 (캐시됨)
```

### lazy의 옵션

```kotlin
// 기본: 스레드 안전
val data1 by lazy { compute() }

// 스레드 안전하지 않음 (단일 스레드용)
val data2 by lazy(LazyThreadSafetyMode.NONE) { compute() }

// 스레드 안전 (동기화)
val data3 by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { compute() }
```

---

## 5. 프로퍼티 위임 (Delegated Properties)

> 📖 참조: https://kotlinlang.org/docs/delegated-properties.html

`by` 키워드로 프로퍼티의 getter/setter를 다른 객체에 위임합니다.

### observable

값 변경을 감지합니다.

```kotlin
import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("Unknown") { prop, old, new ->
        println("$old -> $new")
    }
}

val user = User()
user.name = "Alice"  // Unknown -> Alice
user.name = "Bob"    // Alice -> Bob
```

### vetoable

값 변경을 거부할 수 있습니다.

```kotlin
var age: Int by Delegates.vetoable(0) { _, old, new ->
    new >= 0  // 음수면 거부
}

age = 25     // ✅ 변경됨
age = -5     // ❌ 거부됨, age는 여전히 25
println(age) // 25
```

### notNull

lateinit과 유사하지만 위임 방식입니다.

```kotlin
var name: String by Delegates.notNull<String>()

// 초기화 전 접근하면 예외 발생
// println(name)  // IllegalStateException

name = "Alice"
println(name)  // Alice
```

---

## 6. Map으로 위임

```kotlin
class User(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

val user = User(mapOf(
    "name" to "Alice",
    "age" to 25
))

println(user.name)  // Alice
println(user.age)   // 25
```

### MutableMap으로 위임 (읽기/쓰기)

```kotlin
class MutableUser(map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}

val map = mutableMapOf<String, Any?>(
    "name" to "Alice",
    "age" to 25
)
val user = MutableUser(map)

user.name = "Bob"
println(map["name"])  // Bob
```

---

## 7. 커스텀 Delegate

자신만의 delegate를 만들 수 있습니다.

```kotlin
import kotlin.reflect.KProperty

class LoggingDelegate<T>(private var value: T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("Getting ${property.name}")
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: T) {
        println("Setting ${property.name} to $newValue")
        value = newValue
    }
}

class Example {
    var text: String by LoggingDelegate("Hello")
}

val ex = Example()
println(ex.text)     // Getting text \n Hello
ex.text = "World"    // Setting text to World
```

---

## 8. 흔히 하는 실수

### 실수 1: lateinit 초기화 전 접근

```kotlin
class Service {
    lateinit var api: Api

    fun call() {
        // ❌ UninitializedPropertyAccessException!
        api.request()
    }
}

// ✅ 초기화 확인
if (::api.isInitialized) {
    api.request()
}
```

### 실수 2: lazy에서 var 사용

```kotlin
// ❌ lazy는 val에만 사용 가능
// var data by lazy { "Hello" }

// ✅ val 사용
val data by lazy { "Hello" }
```

### 실수 3: setter에서 field 대신 프로퍼티 사용

```kotlin
var value: Int = 0
    set(v) {
        // ❌ 무한 재귀!
        // value = v

        // ✅ field 사용
        field = v
    }
```

---

## 9. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 커스텀 getter와 setter를 작성할 수 있나요?
- [ ] `field` 키워드의 역할을 이해했나요?
- [ ] `lateinit`과 `lazy`의 차이를 알고 있나요?
- [ ] `by lazy`로 지연 초기화할 수 있나요?
- [ ] `Delegates.observable`을 사용할 수 있나요?

---

## 10. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Properties](https://kotlinlang.org/docs/properties.html)
- [Kotlin Delegated Properties](https://kotlinlang.org/docs/delegated-properties.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
