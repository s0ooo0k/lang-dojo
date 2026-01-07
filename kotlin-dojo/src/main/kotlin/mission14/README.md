# Mission 14: Generics (제네릭)

## 학습 목표

Kotlin의 제네릭을 이해하고, 타입 파라미터, 공변성(out), 반공변성(in), 타입 제약을 활용합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/14-generics.md`

## 임무

### Task 1: 기본 제네릭 클래스
`Container<T>` 클래스를 구현하세요.
- `value: T` 프로퍼티
- `getValue(): T` 메서드
- `map<R>(transform: (T) -> R): Container<R>` 메서드

### Task 2: 제네릭 함수
`swap<T>(list: MutableList<T>, i: Int, j: Int)` 함수를 구현하세요.
- 리스트의 i번째와 j번째 요소를 교환합니다.

`firstOrDefault<T>(list: List<T>, default: T)` 함수를 구현하세요.
- 첫 번째 요소를 반환하거나, 비어있으면 default 반환

### Task 3: 타입 제약 (Upper Bound)
`findMax<T : Comparable<T>>(list: List<T>)` 함수를 구현하세요.
- 리스트에서 최댓값을 반환, 비어있으면 null

`sumNumbers<T : Number>(list: List<T>)` 함수를 구현하세요.
- 숫자 리스트의 합계를 Double로 반환

### Task 4: 공변성 (out)
`ReadOnlyBox<out T>` 클래스를 구현하세요.
- `value: T` 프로퍼티
- `get(): T` 메서드만 제공 (값을 읽기만 가능)

`copyAll<T>(source: ReadOnlyBox<T>): T` 함수를 구현하세요.
- ReadOnlyBox에서 값을 읽어 반환

### Task 5: 반공변성 (in)
`Writer<in T>` 인터페이스를 구현하세요.
- `write(item: T)` 메서드

`StringWriter` 클래스를 구현하세요.
- Writer<String> 구현
- 작성된 문자열을 `written: MutableList<String>`에 저장

### Task 6: 두 타입 파라미터
`Pair<A, B>` 클래스를 구현하세요.
- `first: A`, `second: B` 프로퍼티
- `swap(): Pair<B, A>` 메서드

`<A, B> Pair<A, B>.toList(): List<Any?>` 확장 함수를 구현하세요.
- Pair를 List로 변환

### Task 7: 제네릭 인터페이스
`Repository<T, ID>` 인터페이스를 구현하세요.
- `findById(id: ID): T?`
- `save(item: T): ID`
- `deleteById(id: ID): Boolean`

`InMemoryRepository<T>` 클래스를 구현하세요.
- Repository<T, Int> 구현
- 내부에 `items: MutableMap<Int, T>` 저장소 사용
- ID는 자동 증가

### Task 8: reified 타입
`inline fun <reified T> filterByType(list: List<Any>)` 함수를 구현하세요.
- 리스트에서 T 타입인 요소만 필터링

`inline fun <reified T> isType(value: Any)` 함수를 구현하세요.
- value가 T 타입인지 확인

## 예상 출력

```
Task 1: Container("Hello").map { it.length } → Container(5)
Task 2: [1, 2, 3] swap(0, 2) → [3, 2, 1]
Task 3: findMax([3, 1, 4, 1, 5]) → 5
Task 4: ReadOnlyBox("Hello").get() → "Hello"
Task 5: StringWriter.write("Hello") → written = ["Hello"]
Task 6: Pair(1, "a").swap() → Pair("a", 1)
Task 7: repository.save(item) → 1, findById(1) → item
Task 8: filterByType<String>([1, "a", 2, "b"]) → ["a", "b"]
```

## 테스트 실행

```bash
./gradlew test --tests "mission14.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
