# Mission 13: Properties & Delegation (프로퍼티와 위임)

## 학습 목표

Kotlin의 프로퍼티, 커스텀 getter/setter, 지연 초기화, 프로퍼티 위임을 이해하고 활용합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/13-properties-and-delegation.md`

## 임무

### Task 1: 커스텀 Getter
`Circle` 클래스를 구현하세요.
- `radius: Double` 생성자 프로퍼티
- `area: Double` 계산된 프로퍼티 (PI * radius * radius)
- `diameter: Double` 계산된 프로퍼티 (2 * radius)

### Task 2: 커스텀 Setter
`Temperature` 클래스를 구현하세요.
- `celsius: Double` 프로퍼티
- setter에서 -273.15 미만 값은 -273.15로 제한 (절대영도)
- `fahrenheit: Double` 계산된 프로퍼티 (celsius * 9/5 + 32)

### Task 3: Backing Field
`Counter` 클래스를 구현하세요.
- `count: Int` 프로퍼티 (초기값 0)
- setter에서 음수 값은 무시 (현재 값 유지)
- `increment()` 메서드: count를 1 증가
- `reset()` 메서드: count를 0으로 리셋

### Task 4: Lazy 초기화
`DataLoader` 클래스를 구현하세요.
- `data: String` lazy 프로퍼티
- 초기화 시 "Loading data..." 출력 후 "Data loaded" 반환
- 첫 접근 시에만 초기화되어야 함

### Task 5: lateinit
`Service` 클래스를 구현하세요.
- `config: String` lateinit 프로퍼티
- `initialize(config: String)` 메서드: config 설정
- `isConfigured()` 메서드: 초기화 여부 반환
- `getConfig()` 메서드: 초기화됐으면 config, 아니면 "Not configured"

### Task 6: Observable 위임
`User` 클래스를 구현하세요.
- `name: String` observable 프로퍼티 (초기값 "Unknown")
- 값 변경 시 `nameChanges` 리스트에 "{old} -> {new}" 형식으로 기록

### Task 7: Vetoable 위임
`Account` 클래스를 구현하세요.
- `balance: Int` vetoable 프로퍼티 (초기값 0)
- 음수로 설정하려는 시도는 거부

### Task 8: Map 위임
`Config` 클래스를 구현하세요.
- 생성자에서 `Map<String, Any?>`를 받음
- `host: String` Map에서 위임
- `port: Int` Map에서 위임
- `timeout: Int` Map에서 위임

## 예상 출력

```
Task 1: area=78.54, diameter=10.0 (radius=5.0)
Task 2: celsius=-273.15 (최소값), fahrenheit=32.0
Task 3: count=5, count=0 (after reset)
Task 4: "Loading data..." (첫 접근), "Data loaded"
Task 5: isConfigured=true, config="Production"
Task 6: nameChanges=["Unknown -> Alice", "Alice -> Bob"]
Task 7: balance=100, balance=100 (음수 거부)
Task 8: host="localhost", port=8080
```

## 테스트 실행

```bash
./gradlew test --tests "mission13.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
