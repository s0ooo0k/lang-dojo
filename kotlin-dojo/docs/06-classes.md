# Mission 6 학습 자료: 클래스 (Classes)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Classes](https://kotlinlang.org/docs/classes.html)

---

## 1. 클래스 기본

> 📖 참조: https://kotlinlang.org/docs/classes.html

### 클래스 선언

```kotlin
class Person {
    // 클래스 본문
}

// 본문이 없으면 중괄호 생략 가능
class Empty
```

### 프로퍼티 (Properties)

```kotlin
class Person {
    var name: String = ""
    var age: Int = 0
}

// 사용
val person = Person()
person.name = "Alice"
person.age = 25
println(person.name)  // Alice
```

---

## 2. 생성자 (Constructors)

> 📖 참조: https://kotlinlang.org/docs/classes.html#constructors

### 기본 생성자 (Primary Constructor)

```kotlin
class Person(val name: String, var age: Int)

// 사용
val alice = Person("Alice", 25)
println(alice.name)  // Alice
println(alice.age)   // 25
```

### 기본 생성자 + 프로퍼티

```kotlin
class Person(
    val name: String,      // val: 읽기 전용
    var age: Int,          // var: 변경 가능
    val email: String = "" // 기본값 설정 가능
)
```

### init 블록

```kotlin
class Person(val name: String) {
    val nameLength: Int

    init {
        // 기본 생성자 실행 시 호출
        println("Person created: $name")
        nameLength = name.length
    }
}
```

### 보조 생성자 (Secondary Constructor)

```kotlin
class Person(val name: String) {
    var age: Int = 0

    // 보조 생성자는 this()로 기본 생성자를 호출해야 함
    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }
}

// 사용
val p1 = Person("Alice")         // 기본 생성자
val p2 = Person("Bob", 30)       // 보조 생성자
```

---

## 3. 메서드 (Methods)

```kotlin
class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int) = a - b  // 단일 표현식
}

// 사용
val calc = Calculator()
println(calc.add(5, 3))       // 8
println(calc.subtract(5, 3))  // 2
```

---

## 4. Data Class

> 📖 참조: https://kotlinlang.org/docs/data-classes.html

데이터를 담는 클래스를 위한 특별한 클래스입니다.

### 자동 생성되는 것들

- `equals()` / `hashCode()`
- `toString()` - "User(name=Alice, age=25)" 형식
- `copy()` - 복사본 생성
- `componentN()` - 구조 분해

```kotlin
data class User(val name: String, val age: Int)

// 사용
val user = User("Alice", 25)

// toString() 자동 생성
println(user)  // User(name=Alice, age=25)

// equals() 자동 생성
val user2 = User("Alice", 25)
println(user == user2)  // true

// copy() 사용
val user3 = user.copy(age = 30)
println(user3)  // User(name=Alice, age=30)

// 구조 분해 (Destructuring)
val (name, age) = user
println("$name is $age years old")  // Alice is 25 years old
```

### Data Class 규칙

- 기본 생성자에 최소 하나의 파라미터 필요
- 모든 파라미터는 `val` 또는 `var`로 표시
- `abstract`, `open`, `sealed`, `inner` 불가

---

## 5. Object (싱글톤)

> 📖 참조: https://kotlinlang.org/docs/object-declarations.html

### object 선언 (Singleton)

```kotlin
object DatabaseConfig {
    val url: String = "localhost:5432"
    val maxConnections: Int = 10

    fun connect() {
        println("Connecting to $url")
    }
}

// 사용 (인스턴스 생성 없이 바로 사용)
println(DatabaseConfig.url)      // localhost:5432
DatabaseConfig.connect()          // Connecting to localhost:5432
```

### companion object

클래스 내부에 정의하는 싱글톤 객체입니다. Java의 static과 유사합니다.

```kotlin
class MyClass {
    companion object {
        const val TAG = "MyClass"

        fun create(): MyClass {
            return MyClass()
        }
    }
}

// 사용
println(MyClass.TAG)           // MyClass
val instance = MyClass.create()
```

---

## 6. 클래스 인스턴스 생성

Kotlin에서는 `new` 키워드가 없습니다!

```kotlin
// Java 스타일 (Kotlin에서 불가)
// Person person = new Person();  // ❌

// Kotlin 스타일
val person = Person("Alice", 25)  // ✅
```

---

## 7. Getter와 Setter

> 📖 참조: https://kotlinlang.org/docs/properties.html

### 커스텀 Getter

```kotlin
class Rectangle(val width: Int, val height: Int) {
    // 커스텀 getter
    val area: Int
        get() = width * height
}

val rect = Rectangle(10, 5)
println(rect.area)  // 50
```

### 커스텀 Setter

```kotlin
class User(name: String) {
    var name: String = name
        set(value) {
            field = value.trim()  // 공백 제거 후 저장
        }
}
```

---

## 8. 흔히 하는 실수

### 실수 1: new 키워드 사용

```kotlin
// ❌ 잘못된 코드
val person = new Person("Alice")

// ✅ 올바른 코드
val person = Person("Alice")
```

### 실수 2: val 프로퍼티 변경 시도

```kotlin
data class User(val name: String, val age: Int)

val user = User("Alice", 25)
// user.name = "Bob"  // ❌ 컴파일 에러! val은 변경 불가

// ✅ copy()를 사용
val newUser = user.copy(name = "Bob")
```

### 실수 3: Data Class 비교

```kotlin
// 일반 클래스
class Person(val name: String)
val p1 = Person("Alice")
val p2 = Person("Alice")
println(p1 == p2)  // false! (참조 비교)

// Data 클래스
data class User(val name: String)
val u1 = User("Alice")
val u2 = User("Alice")
println(u1 == u2)  // true! (값 비교)
```

---

## 9. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] 클래스를 선언하고 인스턴스를 생성할 수 있나요?
- [ ] 기본 생성자와 프로퍼티를 정의할 수 있나요?
- [ ] 클래스에 메서드를 추가할 수 있나요?
- [ ] data class의 특징을 이해했나요?
- [ ] object와 companion object의 차이를 알고 있나요?
- [ ] copy()를 사용하여 data class 인스턴스를 복사할 수 있나요?

---

## 10. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Classes](https://kotlinlang.org/docs/classes.html)
- [Kotlin Data Classes](https://kotlinlang.org/docs/data-classes.html)
- [Kotlin Object Declarations](https://kotlinlang.org/docs/object-declarations.html)
- [Kotlin Properties](https://kotlinlang.org/docs/properties.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
