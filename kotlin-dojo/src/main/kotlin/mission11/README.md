# Mission 11: Interfaces & Inheritance (인터페이스와 상속)

## 학습 목표

Kotlin의 인터페이스, 상속, 추상 클래스를 이해하고 객체지향 프로그래밍의 다형성을 학습합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/11-interfaces-and-inheritance.md`

## 임무

### Task 1: 기본 인터페이스
`Drawable` 인터페이스를 구현하세요.
- `draw(): String` 메서드 선언 (추상)

`Circle` 클래스가 `Drawable`을 구현하도록 하세요.
- `draw()` 반환: "Drawing Circle"

### Task 2: 인터페이스의 기본 구현
`Greeting` 인터페이스를 구현하세요.
- `greet(): String` 추상 메서드
- `greetWithName(name: String): String` 기본 구현 → "Hello, {name}! {greet()}"

`FriendlyGreeting` 클래스가 `Greeting`을 구현하도록 하세요.
- `greet()` 반환: "Nice to meet you!"

### Task 3: 클래스 상속
`Vehicle` open 클래스를 구현하세요.
- `brand: String` 프로퍼티
- `start(): String` open 메서드 → "Starting {brand}"

`Car` 클래스가 `Vehicle`을 상속하도록 하세요.
- `model: String` 추가 프로퍼티
- `start()` 오버라이드 → "Starting {brand} {model} with engine"

### Task 4: 추상 클래스
`Shape` 추상 클래스를 구현하세요.
- `abstract val area: Double`
- `abstract fun describe(): String`

`Rectangle` 클래스가 `Shape`를 상속하도록 하세요.
- `width: Double`, `height: Double` 프로퍼티
- `area` 계산: width * height
- `describe()` 반환: "Rectangle with area {area}"

### Task 5: 다중 인터페이스
`Swimmer` 인터페이스: `swim(): String` → "Swimming"
`Flyer` 인터페이스: `fly(): String` → "Flying"

`Duck` 클래스가 두 인터페이스를 모두 구현하도록 하세요.
- 각 인터페이스의 기본 구현을 사용합니다.

### Task 6: super 호출
`Animal` open 클래스:
- `speak(): String` → "Some sound"

`Dog` 클래스가 `Animal`을 상속:
- `speak()` 오버라이드 → super.speak() + " Woof!"

### Task 7: 프로퍼티 오버라이드
`Base` open 클래스:
- `open val message: String` → "Base message"

`Derived` 클래스가 `Base`를 상속:
- `message` 오버라이드 → "Derived message"

### Task 8: 인터페이스 충돌 해결
`A` 인터페이스: `foo(): String` → "A"
`B` 인터페이스: `foo(): String` → "B"

`C` 클래스가 A, B 모두 구현:
- `foo()` → "A and B" (super<A>.foo() + " and " + super<B>.foo())

## 예상 출력

```
Task 1: Drawing Circle
Task 2: Nice to meet you!, Hello, Alice! Nice to meet you!
Task 3: Starting Toyota, Starting Toyota Camry with engine
Task 4: Rectangle(width=10.0, height=5.0), area=50.0, describe="Rectangle with area 50.0"
Task 5: Swimming, Flying
Task 6: Some sound Woof!
Task 7: Derived message
Task 8: A and B
```

## 테스트 실행

```bash
./gradlew test --tests "mission11.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
