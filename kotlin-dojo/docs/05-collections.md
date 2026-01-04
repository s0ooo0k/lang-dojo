# Mission 5 학습 자료: 컬렉션 (Collections)

> **이 파일을 먼저 읽고 미션을 시작하세요!**
>
> 📚 **공식 문서 참조**: [Kotlin 공식 문서 - Collections](https://kotlinlang.org/docs/collections-overview.html)

---

## 1. 컬렉션 개요

> 📖 참조: https://kotlinlang.org/docs/collections-overview.html

Kotlin의 컬렉션은 크게 세 가지입니다:

| 컬렉션 | 특징 | 예시 |
|--------|------|------|
| **List** | 순서 있음, 중복 허용 | `[1, 2, 2, 3]` |
| **Set** | 순서 없음, 중복 불허 | `{1, 2, 3}` |
| **Map** | Key-Value 쌍 | `{a=1, b=2}` |

각 컬렉션은 **읽기 전용(Immutable)**과 **변경 가능(Mutable)** 버전이 있습니다.

---

## 2. List

> 📖 참조: https://kotlinlang.org/docs/list-operations.html

### 읽기 전용 List 생성

```kotlin
val fruits = listOf("Apple", "Banana", "Cherry")
val numbers = listOf(1, 2, 3, 4, 5)
val empty = emptyList<String>()
```

### List 접근

```kotlin
val fruits = listOf("Apple", "Banana", "Cherry")

fruits[0]           // "Apple" (인덱스로 접근)
fruits.first()      // "Apple" (첫 번째)
fruits.last()       // "Cherry" (마지막)
fruits.size         // 3 (크기)
fruits.isEmpty()    // false
fruits.contains("Banana")  // true
"Apple" in fruits   // true (in 연산자)
```

### 변경 가능한 MutableList

```kotlin
val mutableFruits = mutableListOf("Apple", "Banana")

mutableFruits.add("Cherry")       // 끝에 추가
mutableFruits.add(0, "Apricot")   // 특정 위치에 추가
mutableFruits.remove("Banana")    // 요소 삭제
mutableFruits.removeAt(0)         // 인덱스로 삭제
mutableFruits[0] = "Avocado"      // 요소 변경
mutableFruits.clear()             // 전체 삭제
```

### List 변환

```kotlin
val immutable = listOf(1, 2, 3)
val mutable = immutable.toMutableList()  // MutableList로 변환

val mutableList = mutableListOf(1, 2, 3)
val immutableCopy = mutableList.toList()  // List로 변환
```

---

## 3. Set

> 📖 참조: https://kotlinlang.org/docs/set-operations.html

### Set 생성 (중복 자동 제거)

```kotlin
val numbers = setOf(1, 2, 2, 3, 3, 3)  // {1, 2, 3}
val letters = setOf("A", "B", "C")
val empty = emptySet<Int>()
```

### Set 연산

```kotlin
val set = setOf(1, 2, 3)

set.contains(2)     // true
2 in set            // true
set.size            // 3
set.isEmpty()       // false
```

### MutableSet

```kotlin
val mutableSet = mutableSetOf(1, 2, 3)

mutableSet.add(4)        // 추가 (이미 있으면 무시)
mutableSet.remove(2)     // 삭제
mutableSet.addAll(listOf(5, 6))  // 여러 개 추가
```

### Set 집합 연산

```kotlin
val a = setOf(1, 2, 3)
val b = setOf(2, 3, 4)

a union b       // {1, 2, 3, 4} 합집합
a intersect b   // {2, 3} 교집합
a subtract b    // {1} 차집합
```

---

## 4. Map

> 📖 참조: https://kotlinlang.org/docs/map-operations.html

### Map 생성

```kotlin
val scores = mapOf(
    "Alice" to 95,
    "Bob" to 87,
    "Charlie" to 92
)

// 또는
val scores2 = mapOf(
    Pair("Alice", 95),
    Pair("Bob", 87)
)
```

### Map 접근

```kotlin
val scores = mapOf("Alice" to 95, "Bob" to 87)

scores["Alice"]           // 95 (없으면 null)
scores.get("Alice")       // 95
scores.getOrDefault("David", 0)  // 0 (없으면 기본값)
scores.keys               // [Alice, Bob]
scores.values             // [95, 87]
scores.size               // 2
scores.containsKey("Alice")  // true
scores.containsValue(95)     // true
"Alice" in scores         // true
```

### MutableMap

```kotlin
val mutableScores = mutableMapOf("Alice" to 95)

mutableScores["Bob"] = 87        // 추가/수정
mutableScores.put("Charlie", 92) // 추가/수정
mutableScores.remove("Alice")    // 삭제
mutableScores.clear()            // 전체 삭제
```

### Map 순회

```kotlin
val scores = mapOf("Alice" to 95, "Bob" to 87)

// entries 순회
for ((name, score) in scores) {
    println("$name: $score")
}

// keys만 순회
for (name in scores.keys) {
    println(name)
}

// values만 순회
for (score in scores.values) {
    println(score)
}
```

---

## 5. 컬렉션 공통 연산

### 순회 (Iteration)

```kotlin
val list = listOf("A", "B", "C")

// for 루프
for (item in list) {
    println(item)
}

// 인덱스와 함께
for ((index, item) in list.withIndex()) {
    println("$index: $item")
}

// forEach (람다) - 나중에 자세히 배움
list.forEach { println(it) }
```

### 필터링 (간단히)

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

// filter - 조건에 맞는 요소만
val evens = numbers.filter { it % 2 == 0 }  // [2, 4, 6]

// filterNot - 조건에 안 맞는 요소만
val odds = numbers.filterNot { it % 2 == 0 }  // [1, 3, 5]
```

### 변환 (간단히)

```kotlin
val numbers = listOf(1, 2, 3)

// map - 각 요소를 변환
val doubled = numbers.map { it * 2 }  // [2, 4, 6]

// 문자열로 변환
val strings = numbers.map { it.toString() }  // ["1", "2", "3"]
```

### 유용한 함수들

```kotlin
val numbers = listOf(3, 1, 4, 1, 5, 9)

numbers.sorted()        // [1, 1, 3, 4, 5, 9] 정렬
numbers.reversed()      // [9, 5, 1, 4, 1, 3] 뒤집기
numbers.distinct()      // [3, 1, 4, 5, 9] 중복 제거
numbers.sum()           // 23 합계
numbers.average()       // 3.83... 평균
numbers.max()           // 9 최댓값
numbers.min()           // 1 최솟값
numbers.count()         // 6 개수
```

---

## 6. 읽기 전용 vs 변경 가능

### 중요한 차이

```kotlin
// 읽기 전용 - 수정 메서드 없음
val list: List<Int> = listOf(1, 2, 3)
// list.add(4)  // ❌ 컴파일 에러!

// 변경 가능 - 수정 메서드 있음
val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
mutableList.add(4)  // ✅ OK
```

### val과의 조합

```kotlin
// val + List: 변수도 안 바뀌고, 내용도 못 바꿈
val list = listOf(1, 2, 3)

// val + MutableList: 변수는 안 바뀌지만, 내용은 바꿀 수 있음
val mutableList = mutableListOf(1, 2, 3)
mutableList.add(4)  // ✅ 내용 추가 가능
// mutableList = mutableListOf(5, 6)  // ❌ 변수 재할당 불가

// var + MutableList: 둘 다 바꿀 수 있음
var varList = mutableListOf(1, 2, 3)
varList.add(4)  // ✅
varList = mutableListOf(5, 6)  // ✅
```

---

## 7. 흔히 하는 실수

### 실수 1: 읽기 전용 List에 추가하려고 함

```kotlin
val list = listOf(1, 2, 3)
// list.add(4)  // ❌ 컴파일 에러!

// ✅ 새로운 리스트를 만들어야 함
val newList = list + 4  // [1, 2, 3, 4]
// 또는
val mutableList = list.toMutableList()
mutableList.add(4)
```

### 실수 2: Map에서 없는 키 접근

```kotlin
val map = mapOf("a" to 1)

// ⚠️ null이 반환될 수 있음
val value = map["b"]  // null

// ✅ 기본값 지정
val safeValue = map.getOrDefault("b", 0)  // 0
```

### 실수 3: Set에 중복 추가

```kotlin
val set = mutableSetOf(1, 2, 3)
set.add(2)  // 이미 있으므로 무시됨
println(set)  // [1, 2, 3] - 그대로!
```

---

## 8. 체크리스트

Mission을 풀기 전에 이해했는지 확인하세요:

- [ ] List, Set, Map의 차이를 이해했나요?
- [ ] listOf vs mutableListOf의 차이를 알고 있나요?
- [ ] List의 요소에 접근하는 방법을 알고 있나요?
- [ ] Map에서 Key로 Value를 가져오는 방법을 알고 있나요?
- [ ] for 루프로 컬렉션을 순회할 수 있나요?
- [ ] MutableList/MutableSet/MutableMap에 요소를 추가/삭제할 수 있나요?

---

## 9. 더 알아보기

공식 문서에서 더 자세한 내용을 학습하세요:

- [Kotlin Collections Overview](https://kotlinlang.org/docs/collections-overview.html)
- [List Operations](https://kotlinlang.org/docs/list-operations.html)
- [Set Operations](https://kotlinlang.org/docs/set-operations.html)
- [Map Operations](https://kotlinlang.org/docs/map-operations.html)

---

**준비되셨나요? 이제 미션 폴더의 README.md를 확인하고 구현을 시작하세요!**
