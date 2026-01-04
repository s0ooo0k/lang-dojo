# Mission 2: 변수와 기본 타입

## 목표
- `val`과 `var`의 차이를 이해합니다.
- Kotlin의 기본 타입(Int, Double, Boolean, String)을 다룹니다.
- 문자열 템플릿(`$`, `${}`)을 사용합니다.
- 기본 산술 연산과 타입 변환을 익힙니다.

## 학습 자료
> **미션을 시작하기 전에 반드시 읽어주세요!**
>
> [02-variables-and-types.md](../../../docs/02-variables-and-types.md)

---

## 임무 목록

### Mission 2-1: 내 이름 반환하기
`getMyName()` 함수에서 문자열 `"sook"`을 반환하세요.

**예상 출력:**
```
sook
```

---

### Mission 2-2: 내 나이 반환하기
`getMyAge()` 함수에서 정수 `25`를 반환하세요.

**예상 출력:**
```
25
```

---

### Mission 2-3: 내 키 반환하기
`getMyHeight()` 함수에서 실수 `175.5`를 반환하세요.

**예상 출력:**
```
175.5
```

---

### Mission 2-4: Kotlin이 재미있나요?
`isKotlinFun()` 함수에서 `true`를 반환하세요.

**예상 출력:**
```
true
```

---

### Mission 2-5: 자기소개 (문자열 템플릿 $)
`introduce(name)` 함수에서 문자열 템플릿 `$`를 사용하여 자기소개 문장을 만드세요.

**예상 입출력:**
```
introduce("Alice") -> "Hello, I'm Alice"
introduce("Bob")   -> "Hello, I'm Bob"
```

---

### Mission 2-6: 두 수 더하기
`addNumbers(a, b)` 함수에서 두 정수를 더한 결과를 반환하세요.

**예상 입출력:**
```
addNumbers(3, 5)   -> 8
addNumbers(10, 20) -> 30
```

---

### Mission 2-7: 평균 계산하기
`calculateAverage(a, b)` 함수에서 두 정수의 평균을 `Double`로 반환하세요.

**주의:** 정수끼리 나누면 정수가 됩니다! `7 / 2 = 3` (3.5가 아님)

**예상 입출력:**
```
calculateAverage(3, 4) -> 3.5
calculateAverage(5, 6) -> 5.5
```

---

### Mission 2-8: Int를 Double로 변환
`intToDouble(number)` 함수에서 정수를 실수로 변환하여 반환하세요.

**예상 입출력:**
```
intToDouble(42)  -> 42.0
intToDouble(100) -> 100.0
```

---

### Mission 2-9: 정보 포맷팅 (문자열 템플릿 ${})
`formatInfo(name, age)` 함수에서 문자열 템플릿 `${}`를 사용하여 정보를 포맷팅하세요.

**예상 입출력:**
```
formatInfo("sook", 25) -> "Name: sook, Age: 25"
formatInfo("Alice", 30) -> "Name: Alice, Age: 30"
```

---

### Mission 2-10: 다음 해 나이 계산
`nextYearAge(name, age)` 함수에서 문자열 템플릿 내에서 연산을 수행하세요.

**예상 입출력:**
```
nextYearAge("sook", 25)  -> "sook will be 26 next year"
nextYearAge("Alice", 30) -> "Alice will be 31 next year"
```

---

## 테스트 실행

```bash
# 전체 Mission 2 테스트
./gradlew test --tests "mission2.*"

# 개별 테스트 실행 예시
./gradlew test --tests "mission2.VariablesTest.mission_2_1*"
```

## 진행 체크리스트

- [ ] Mission 2-1: getMyName()
- [ ] Mission 2-2: getMyAge()
- [ ] Mission 2-3: getMyHeight()
- [ ] Mission 2-4: isKotlinFun()
- [ ] Mission 2-5: introduce()
- [ ] Mission 2-6: addNumbers()
- [ ] Mission 2-7: calculateAverage()
- [ ] Mission 2-8: intToDouble()
- [ ] Mission 2-9: formatInfo()
- [ ] Mission 2-10: nextYearAge()
