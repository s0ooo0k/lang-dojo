# Mission 10: Lambda & Higher-order Functions (람다와 고차 함수)

## 학습 목표

Kotlin의 람다 표현식과 고차 함수를 이해하고, 함수형 프로그래밍 패턴을 학습합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/10-lambda-and-higher-order-functions.md`

## 임무

### Task 1: 기본 람다
`createAdder(n: Int)` 함수를 구현하세요.
- 주어진 숫자 n을 더하는 람다를 반환합니다.
- 반환 타입: `(Int) -> Int`
- 예: `createAdder(5)` 반환 → 10을 입력하면 15 반환

### Task 2: 고차 함수 - 함수 파라미터
`applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int)` 함수를 구현하세요.
- 두 숫자에 operation을 적용한 결과를 반환합니다.

### Task 3: 리스트 변환
`transformList(list: List<Int>, transform: (Int) -> Int)` 함수를 구현하세요.
- 리스트의 각 요소에 transform을 적용한 새 리스트를 반환합니다.
- `map`을 사용하세요.

### Task 4: 리스트 필터링
`filterList(list: List<Int>, predicate: (Int) -> Boolean)` 함수를 구현하세요.
- predicate를 만족하는 요소만 포함한 새 리스트를 반환합니다.
- `filter`를 사용하세요.

### Task 5: 리스트 축소 (fold)
`sumWithInitial(list: List<Int>, initial: Int)` 함수를 구현하세요.
- initial 값부터 시작하여 모든 요소를 더한 결과를 반환합니다.
- `fold`를 사용하세요.

### Task 6: 콜백 실행
`executeWithCallback(value: Int, callback: (Int) -> Unit)` 함수를 구현하세요.
- value를 callback에 전달하여 실행합니다.

### Task 7: 조건부 실행
`executeIf(condition: Boolean, action: () -> Unit)` 함수를 구현하세요.
- condition이 true일 때만 action을 실행합니다.

### Task 8: 함수 합성
`compose(f: (Int) -> Int, g: (Int) -> Int)` 함수를 구현하세요.
- 두 함수를 합성합니다: `(x) -> f(g(x))`
- 먼저 g를 적용하고, 그 결과에 f를 적용하는 새 함수를 반환합니다.

### Task 9: 체이닝
`processNumbers(numbers: List<Int>)` 함수를 구현하세요.
- 짝수만 필터링
- 각 숫자를 2배로 변환
- 결과를 정렬
- 모두 `map`, `filter`, `sorted`를 체이닝하세요.

### Task 10: groupBy 사용
`groupByFirstLetter(words: List<String>)` 함수를 구현하세요.
- 단어를 첫 글자로 그룹화합니다.
- 반환 타입: `Map<Char, List<String>>`

## 예상 출력

```
Task 1: 15 (createAdder(5)(10))
Task 2: 15 (applyOperation(10, 5, { a, b -> a + b }))
Task 3: [2, 4, 6] (transformList([1, 2, 3], { it * 2 }))
Task 4: [2, 4] (filterList([1, 2, 3, 4, 5], { it % 2 == 0 }))
Task 5: 16 (sumWithInitial([1, 2, 3], 10))
Task 6: (callback executed with value)
Task 7: (action executed if condition is true)
Task 8: 20 (compose({ it * 2 }, { it + 5 })(5))
Task 9: [4, 8] (processNumbers([3, 1, 4, 2]))
Task 10: {a=[apple, apricot], b=[banana]}
```

## 테스트 실행

```bash
./gradlew test --tests "mission10.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
