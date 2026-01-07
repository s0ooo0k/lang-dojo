# Mission 7: Null Safety (널 안전성)

## 학습 목표

Kotlin의 Null Safety 기능을 이해하고, ?, ?., ?:, !! 연산자를 활용합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/07-null-safety.md`

## 임무

### Task 1: Nullable 변수의 길이 구하기
`getLength(text: String?)` 함수를 구현하세요.
- text가 null이면 0을 반환
- text가 null이 아니면 문자열 길이를 반환

### Task 2: 기본값 제공하기
`getOrDefault(value: String?, default: String)` 함수를 구현하세요.
- value가 null이면 default를 반환
- value가 null이 아니면 value를 반환

### Task 3: 안전한 대문자 변환
`safeUpperCase(text: String?)` 함수를 구현하세요.
- text가 null이면 null을 반환
- text가 null이 아니면 대문자로 변환하여 반환

### Task 4: 사용자 이름 가져오기
`getUserName(user: User?)` 함수를 구현하세요.
- User 클래스: `data class User(val name: String?, val email: String)`
- user가 null이면 "Guest"를 반환
- user의 name이 null이면 "Anonymous"를 반환
- 그 외에는 user의 name을 반환

### Task 5: 첫 번째 문자 가져오기
`getFirstChar(text: String?)` 함수를 구현하세요.
- text가 null이거나 비어있으면 null을 반환
- 그 외에는 첫 번째 문자를 반환

### Task 6: 리스트에서 null 제거
`filterNulls(list: List<String?>)` 함수를 구현하세요.
- 리스트에서 null이 아닌 요소만 포함된 새 리스트를 반환

### Task 7: 안전한 숫자 파싱
`parseIntOrNull(text: String?)` 함수를 구현하세요.
- text가 null이면 null 반환
- text를 Int로 파싱할 수 없으면 null 반환
- 파싱 성공 시 Int 반환

### Task 8: 체이닝된 Safe Call
`getAddressCity(person: Person?)` 함수를 구현하세요.
- Person 클래스: `data class Person(val name: String, val address: Address?)`
- Address 클래스: `data class Address(val city: String?, val zipCode: String)`
- person이 null이면 "Unknown" 반환
- address가 null이면 "Unknown" 반환
- city가 null이면 "Unknown" 반환
- 그 외에는 city 반환

## 예상 출력

```
Task 1: 5, 0
Task 2: Hello, Default
Task 3: HELLO, null
Task 4: Alice, Anonymous, Guest
Task 5: H, null
Task 6: [A, B, C]
Task 7: 123, null, null
Task 8: Seoul, Unknown
```

## 테스트 실행

```bash
./gradlew test --tests "mission7.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
