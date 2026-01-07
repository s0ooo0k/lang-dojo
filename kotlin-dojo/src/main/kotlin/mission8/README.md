# Mission 8: Extension Functions (확장 함수)

## 학습 목표

Kotlin의 확장 함수와 확장 프로퍼티를 이해하고, 기존 클래스에 새로운 기능을 추가하는 방법을 학습합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/08-extension-functions.md`

## 임무

### Task 1: 문자열 뒤집기 확인
`String.isPalindrome()` 확장 함수를 구현하세요.
- 문자열이 회문(앞뒤가 같은 문자열)인지 확인합니다.
- 대소문자를 구분하지 않습니다.
- 예: "level" → true, "hello" → false

### Task 2: 숫자 자릿수
`Int.digitCount()` 확장 함수를 구현하세요.
- 정수의 자릿수를 반환합니다.
- 음수의 경우 부호를 제외한 자릿수를 반환합니다.
- 예: 123 → 3, -456 → 3, 0 → 1

### Task 3: 리스트 두 번째 요소
`List<T>.secondOrNull()` 확장 함수를 구현하세요.
- 리스트의 두 번째 요소를 반환합니다.
- 요소가 없으면 null을 반환합니다.

### Task 4: 문자열 반복
`String.repeatWithSeparator(n: Int, separator: String)` 확장 함수를 구현하세요.
- 문자열을 n번 반복하고 separator로 연결합니다.
- 예: "Hi".repeatWithSeparator(3, "-") → "Hi-Hi-Hi"

### Task 5: Nullable String 처리
`String?.toIntOrDefault(default: Int)` 확장 함수를 구현하세요.
- 문자열을 Int로 변환합니다.
- null이거나 변환 실패 시 default를 반환합니다.

### Task 6: 리스트 요소 개수 세기
`List<T>.countBy(predicate: (T) -> Boolean)` 확장 함수를 구현하세요.
- 조건을 만족하는 요소의 개수를 반환합니다.
- 예: listOf(1, 2, 3, 4).countBy { it % 2 == 0 } → 2

### Task 7: 확장 프로퍼티 - 단어 수
`String.wordCount` 확장 프로퍼티를 구현하세요.
- 문자열의 단어 수를 반환합니다.
- 공백으로 구분하며, 빈 문자열은 0을 반환합니다.
- 예: "Hello World" → 2

### Task 8: 확장 프로퍼티 - 짝수 여부
`Int.isEven` 확장 프로퍼티를 구현하세요.
- 짝수면 true, 홀수면 false를 반환합니다.

## 예상 출력

```
Task 1: true, false
Task 2: 3, 3, 1
Task 3: 2, null
Task 4: Hi-Hi-Hi
Task 5: 123, 0
Task 6: 2
Task 7: 2, 0
Task 8: true, false
```

## 테스트 실행

```bash
./gradlew test --tests "mission8.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
