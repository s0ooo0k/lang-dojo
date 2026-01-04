# Mission 3: Control Flow (제어 흐름)

## 목표
- `if` 표현식을 사용하여 값을 반환합니다.
- `when` 표현식으로 다양한 조건을 처리합니다.
- `for`와 `while`로 반복 작업을 수행합니다.
- Range(`..`, `until`, `downTo`, `step`)를 활용합니다.

## 학습 자료
> **미션을 시작하기 전에 반드시 읽어주세요!**
>
> [03-control-flow.md](../../../docs/03-control-flow.md)

---

## 임무 목록

### Mission 3-1: 짝수/홀수 판별
`isEven(n)` 함수에서 n이 짝수면 `true`, 홀수면 `false`를 반환하세요.

**예상 입출력:**
```
isEven(4) -> true
isEven(7) -> false
isEven(0) -> true
```

---

### Mission 3-2: 부호 판별
`getSign(n)` 함수에서 n의 부호에 따라 문자열을 반환하세요.

**예상 입출력:**
```
getSign(5)  -> "positive"
getSign(-3) -> "negative"
getSign(0)  -> "zero"
```

---

### Mission 3-3: 성적 등급 (when)
`getGrade(score)` 함수에서 점수에 따른 등급을 반환하세요.

- 90 이상: "A"
- 80 이상: "B"
- 70 이상: "C"
- 60 이상: "D"
- 그 외: "F"

**예상 입출력:**
```
getGrade(95) -> "A"
getGrade(82) -> "B"
getGrade(45) -> "F"
```

---

### Mission 3-4: 요일 이름 (when)
`getDayName(day)` 함수에서 숫자에 해당하는 요일 이름을 반환하세요.

- 1: "Monday", 2: "Tuesday", 3: "Wednesday", 4: "Thursday"
- 5: "Friday", 6: "Saturday", 7: "Sunday"
- 그 외: "Invalid"

**예상 입출력:**
```
getDayName(1) -> "Monday"
getDayName(5) -> "Friday"
getDayName(0) -> "Invalid"
```

---

### Mission 3-5: 범위 검사
`isInRange(n, min, max)` 함수에서 n이 min과 max 사이에 있으면 `true`를 반환하세요. (min, max 포함)

**예상 입출력:**
```
isInRange(5, 1, 10)  -> true
isInRange(0, 1, 10)  -> false
isInRange(10, 1, 10) -> true
```

---

### Mission 3-6: 1부터 N까지 합계 (for)
`sumUpTo(n)` 함수에서 1부터 n까지의 합계를 반환하세요.

**예상 입출력:**
```
sumUpTo(5)  -> 15  (1+2+3+4+5)
sumUpTo(10) -> 55
sumUpTo(1)  -> 1
```

---

### Mission 3-7: 구구단 한 줄 (for)
`multiplicationTable(n)` 함수에서 n단의 결과를 리스트로 반환하세요. (1~9까지)

**예상 입출력:**
```
multiplicationTable(2) -> [2, 4, 6, 8, 10, 12, 14, 16, 18]
multiplicationTable(5) -> [5, 10, 15, 20, 25, 30, 35, 40, 45]
```

---

### Mission 3-8: 팩토리얼
`factorial(n)` 함수에서 n의 팩토리얼을 반환하세요. (n! = n × (n-1) × ... × 1)

**힌트:** 0! = 1, 1! = 1

**예상 입출력:**
```
factorial(5) -> 120  (5×4×3×2×1)
factorial(0) -> 1
factorial(1) -> 1
```

---

### Mission 3-9: 카운트다운 (downTo)
`countDown(from)` 함수에서 from부터 1까지 역순으로 리스트를 반환하세요.

**예상 입출력:**
```
countDown(5) -> [5, 4, 3, 2, 1]
countDown(3) -> [3, 2, 1]
```

---

### Mission 3-10: FizzBuzz
`fizzBuzz(n)` 함수에서 다음 규칙에 따라 문자열을 반환하세요.

- 3과 5 둘 다 나누어지면: "FizzBuzz"
- 3으로만 나누어지면: "Fizz"
- 5로만 나누어지면: "Buzz"
- 둘 다 아니면: 숫자를 문자열로

**예상 입출력:**
```
fizzBuzz(15) -> "FizzBuzz"
fizzBuzz(9)  -> "Fizz"
fizzBuzz(10) -> "Buzz"
fizzBuzz(7)  -> "7"
```

---

## 테스트 실행

```bash
# 전체 Mission 3 테스트
./gradlew test --tests "mission3.*"

# 개별 테스트 실행 예시
./gradlew test --tests "mission3.ControlFlowTest.Mission3_1*"
```

## 진행 체크리스트

- [ ] Mission 3-1: isEven()
- [ ] Mission 3-2: getSign()
- [ ] Mission 3-3: getGrade()
- [ ] Mission 3-4: getDayName()
- [ ] Mission 3-5: isInRange()
- [ ] Mission 3-6: sumUpTo()
- [ ] Mission 3-7: multiplicationTable()
- [ ] Mission 3-8: factorial()
- [ ] Mission 3-9: countDown()
- [ ] Mission 3-10: fizzBuzz()
