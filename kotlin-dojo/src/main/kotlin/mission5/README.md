# Mission 5: Collections (컬렉션)

## 학습 목표

Kotlin의 컬렉션(List, Set, Map)을 이해하고, 읽기 전용과 변경 가능한 컬렉션의 차이를 학습합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/05-collections.md`

## 임무

### Task 1: 과일 목록 만들기
`createFruitList()` 함수를 구현하세요.
- "Apple", "Banana", "Cherry" 순서로 포함된 List를 반환합니다.

### Task 2: 리스트 첫 번째와 마지막 요소
`getFirstAndLast(list: List<String>)` 함수를 구현하세요.
- 리스트의 첫 번째와 마지막 요소를 Pair로 반환합니다.
- 예: `["A", "B", "C"]` → `Pair("A", "C")`

### Task 3: 중복 제거
`removeDuplicates(list: List<Int>)` 함수를 구현하세요.
- 리스트에서 중복을 제거한 Set을 반환합니다.
- 예: `[1, 2, 2, 3, 3, 3]` → `{1, 2, 3}`

### Task 4: 학생 점수 Map 만들기
`createScoreMap()` 함수를 구현하세요.
- "Alice" → 95, "Bob" → 87, "Charlie" → 92 를 담은 Map을 반환합니다.

### Task 5: Map에서 점수 조회
`getScore(scores: Map<String, Int>, name: String)` 함수를 구현하세요.
- 해당 이름의 점수를 반환합니다.
- 이름이 없으면 0을 반환합니다.

### Task 6: MutableList에 요소 추가
`addToList(list: MutableList<String>, item: String)` 함수를 구현하세요.
- 리스트에 item을 추가하고, 추가된 리스트의 크기를 반환합니다.

### Task 7: 숫자 리스트 통계
`getStatistics(numbers: List<Int>)` 함수를 구현하세요.
- 합계, 평균, 최댓값, 최솟값을 담은 Map을 반환합니다.
- 키: "sum", "average", "max", "min"
- 예: `[1, 2, 3, 4, 5]` → `{sum=15, average=3.0, max=5, min=1}`

### Task 8: 집합 연산
`setOperations(a: Set<Int>, b: Set<Int>)` 함수를 구현하세요.
- 합집합, 교집합, 차집합을 Triple로 반환합니다.
- 예: `{1, 2, 3}`, `{2, 3, 4}` → `Triple({1,2,3,4}, {2,3}, {1})`

## 예상 출력

```
Task 1: [Apple, Banana, Cherry]
Task 2: Pair(Apple, Cherry)
Task 3: [1, 2, 3]
Task 4: {Alice=95, Bob=87, Charlie=92}
Task 5: 95, 0
Task 6: 4
Task 7: {sum=15, average=3.0, max=5, min=1}
Task 8: Triple([1, 2, 3, 4], [2, 3], [1])
```

## 테스트 실행

```bash
./gradlew test --tests "mission5.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
