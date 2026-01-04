# Mission 4: Functions (함수 심화)

## 목표
- 기본 파라미터(Default Parameters)를 사용합니다.
- Named Arguments로 가독성을 높입니다.
- vararg로 가변 인자를 처리합니다.
- 단일 표현식 함수를 작성합니다.

## 학습 자료
> **미션을 시작하기 전에 반드시 읽어주세요!**
>
> [04-functions.md](../../../docs/04-functions.md)

---

## 임무 목록

### Mission 4-1: 기본 인사 (기본 파라미터)
`greet(name)` 함수에서 이름에게 인사하세요. 이름이 없으면 "World"에게 인사합니다.

**예상 입출력:**
```
greet("Alice") -> "Hello, Alice!"
greet("Bob")   -> "Hello, Bob!"
greet()        -> "Hello, World!"
```

---

### Mission 4-2: 커피 주문 (여러 기본 파라미터)
`orderCoffee(type, size, shots)` 함수에서 커피 주문 문자열을 만드세요.

**기본값:**
- type: "Americano"
- size: "Medium"
- shots: 2

**예상 입출력:**
```
orderCoffee()                           -> "Medium Americano with 2 shot(s)"
orderCoffee("Latte")                    -> "Medium Latte with 2 shot(s)"
orderCoffee("Espresso", "Small", 1)     -> "Small Espresso with 1 shot(s)"
```

---

### Mission 4-3: 사용자 프로필 (Named Arguments 활용)
`createProfile(name, age, city, job)` 함수에서 프로필 문자열을 만드세요.

**예상 입출력:**
```
createProfile("Alice", 25, "Seoul", "Developer")
  -> "Alice (25) - Developer in Seoul"

createProfile(name = "Bob", age = 30, city = "Busan", job = "Designer")
  -> "Bob (30) - Designer in Busan"
```

---

### Mission 4-4: 합계 계산 (vararg)
`sumAll(vararg numbers)` 함수에서 모든 숫자의 합을 반환하세요.

**예상 입출력:**
```
sumAll(1, 2, 3)      -> 6
sumAll(10, 20, 30, 40) -> 100
sumAll(5)            -> 5
sumAll()             -> 0
```

---

### Mission 4-5: 최댓값 찾기 (vararg)
`findMax(vararg numbers)` 함수에서 가장 큰 숫자를 반환하세요.

**예상 입출력:**
```
findMax(1, 5, 3)     -> 5
findMax(10, 2, 8, 6) -> 10
findMax(-1, -5, -3)  -> -1
findMax()            -> Int.MIN_VALUE
```

---

### Mission 4-6: 문자열 합치기 (vararg + 기본 파라미터)
`joinStrings(vararg strings, separator)` 함수에서 문자열들을 연결하세요.

**기본값:**
- separator: ", "

**예상 입출력:**
```
joinStrings("A", "B", "C")                    -> "A, B, C"
joinStrings("X", "Y", separator = "-")        -> "X-Y"
joinStrings("Hello", "World", separator = " ") -> "Hello World"
joinStrings()                                  -> ""
```

---

### Mission 4-7: 반복 문자열 (기본 파라미터)
`repeatString(text, times)` 함수에서 문자열을 반복하세요.

**기본값:**
- times: 1

**예상 입출력:**
```
repeatString("Ha", 3)  -> "HaHaHa"
repeatString("OK")     -> "OK"
repeatString("!", 5)   -> "!!!!!"
```

---

### Mission 4-8: 포맷된 가격 (Named Arguments 연습)
`formatPrice(amount, currency, showSymbol)` 함수에서 가격을 포맷하세요.

**기본값:**
- currency: "USD"
- showSymbol: true

**예상 입출력:**
```
formatPrice(100)                                  -> "100 USD"
formatPrice(50, currency = "EUR")                 -> "50 EUR"
formatPrice(200, showSymbol = false)              -> "200"
formatPrice(75, currency = "KRW", showSymbol = true) -> "75 KRW"
```

---

### Mission 4-9: 평균 계산 (vararg)
`average(vararg numbers)` 함수에서 숫자들의 평균을 반환하세요.

**예상 입출력:**
```
average(1.0, 2.0, 3.0)  -> 2.0
average(10.0, 20.0)     -> 15.0
average(5.0)            -> 5.0
average()               -> 0.0
```

---

### Mission 4-10: 태그 생성기 (vararg + 기본 파라미터)
`createTag(tagName, vararg attributes, selfClosing)` 함수에서 HTML 태그를 생성하세요.

**기본값:**
- selfClosing: false

**예상 입출력:**
```
createTag("div")                          -> "<div></div>"
createTag("img", selfClosing = true)      -> "<img />"
createTag("a", "href='#'", "class='link'") -> "<a href='#' class='link'></a>"
createTag("br", selfClosing = true)       -> "<br />"
createTag("p", "id='intro'")              -> "<p id='intro'></p>"
```

---

## 테스트 실행

```bash
# 전체 Mission 4 테스트
./gradlew test --tests "mission4.*"

# 개별 테스트 실행 예시
./gradlew test --tests "mission4.FunctionsTest.Mission4_1*"
```

## 진행 체크리스트

- [ ] Mission 4-1: greet()
- [ ] Mission 4-2: orderCoffee()
- [ ] Mission 4-3: createProfile()
- [ ] Mission 4-4: sumAll()
- [ ] Mission 4-5: findMax()
- [ ] Mission 4-6: joinStrings()
- [ ] Mission 4-7: repeatString()
- [ ] Mission 4-8: formatPrice()
- [ ] Mission 4-9: average()
- [ ] Mission 4-10: createTag()
