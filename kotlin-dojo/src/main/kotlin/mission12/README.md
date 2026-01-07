# Mission 12: Sealed, Data, Enum Classes (특수 클래스)

## 학습 목표

Kotlin의 Enum, Data, Sealed 클래스를 이해하고, 상황에 맞게 활용합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/12-special-classes.md`

## 임무

### Task 1: 기본 Enum
`Direction` enum class를 구현하세요.
- NORTH, SOUTH, EAST, WEST 상수

`getOpposite(direction: Direction)` 함수를 구현하세요.
- 반대 방향을 반환합니다.

### Task 2: 프로퍼티가 있는 Enum
`Priority` enum class를 구현하세요.
- LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4)
- `level: Int` 프로퍼티

`getPriorityByLevel(level: Int)` 함수를 구현하세요.
- level에 해당하는 Priority를 반환, 없으면 null

### Task 3: 메서드가 있는 Enum
`Operation` enum class를 구현하세요.
- PLUS, MINUS, TIMES, DIVIDE
- `apply(a: Int, b: Int): Int` 메서드로 계산 수행

### Task 4: Data Class 활용
`Book` data class를 구현하세요.
- `id: Int`, `title: String`, `author: String`, `price: Double`

`updateBookPrice(book: Book, newPrice: Double)` 함수를 구현하세요.
- 가격만 변경된 새 Book을 반환 (copy 사용)

### Task 5: Data Class 구조 분해
`formatBook(book: Book)` 함수를 구현하세요.
- 구조 분해를 사용하여 "{title} by {author}" 형식으로 반환

### Task 6: 기본 Sealed Class
`Result` sealed class를 구현하세요.
- `Success(val value: Int)` data class
- `Failure(val error: String)` data class
- `Loading` object

`handleResult(result: Result)` 함수를 구현하세요.
- when으로 각 케이스 처리 (else 없이!)
- Success: "Value: {value}"
- Failure: "Error: {error}"
- Loading: "Loading..."

### Task 7: Sealed Class with 다양한 데이터
`NetworkResponse` sealed class를 구현하세요.
- `Success<T>(val data: T)` data class
- `Error(val code: Int, val message: String)` data class
- `Loading` object

`describeResponse(response: NetworkResponse<String>)` 함수를 구현하세요.
- 각 상태를 설명하는 문자열 반환

### Task 8: Enum과 when 활용
`Day` enum class를 구현하세요.
- MONDAY ~ SUNDAY

`isWeekend(day: Day)` 함수를 구현하세요.
- 주말(토, 일)이면 true

`getDayType(day: Day)` 함수를 구현하세요.
- "Weekday" 또는 "Weekend" 반환

## 예상 출력

```
Task 1: SOUTH (opposite of NORTH)
Task 2: HIGH (level 3)
Task 3: 15 (PLUS.apply(10, 5))
Task 4: Book(id=1, title=Kotlin, author=JetBrains, price=29.99)
Task 5: "Kotlin by JetBrains"
Task 6: Value: 42, Error: Not found, Loading...
Task 7: Data: Hello, Error 404: Not Found, Loading...
Task 8: true (SATURDAY), "Weekend"
```

## 테스트 실행

```bash
./gradlew test --tests "mission12.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
