# Mission 9: Scope Functions (스코프 함수)

## 학습 목표

Kotlin의 5가지 스코프 함수(let, run, with, apply, also)를 이해하고 적절하게 활용합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/09-scope-functions.md`

## 임무

### Task 1: let으로 null 처리
`processName(name: String?)` 함수를 구현하세요.
- name이 null이 아니면 "Hello, {name}!" 반환
- name이 null이면 "Hello, Guest!" 반환
- `?.let`과 Elvis를 사용하세요.

### Task 2: let으로 변환
`transformNumber(number: Int)` 함수를 구현하세요.
- 숫자를 문자열로 변환하고 앞에 "Number: " 추가
- `let`을 사용하세요.
- 예: 42 → "Number: 42"

### Task 3: apply로 객체 초기화
`createPerson(name: String, age: Int, city: String)` 함수를 구현하세요.
- `PersonBuilder` 클래스를 사용하여 Person 객체 생성
- `apply`를 사용하여 프로퍼티 설정

### Task 4: also로 로깅
`processWithLogging(value: String, logger: (String) -> Unit)` 함수를 구현하세요.
- value를 대문자로 변환하여 반환
- 변환 전후에 logger를 호출하여 로깅
- `also`를 사용하세요.

### Task 5: run으로 계산
`calculateArea(width: Int, height: Int)` 함수를 구현하세요.
- Rectangle 클래스를 생성하고 넓이를 계산하여 반환
- `run`을 사용하세요.

### Task 6: with로 문자열 정보
`getStringInfo(text: String)` 함수를 구현하세요.
- 문자열의 정보를 담은 StringInfo 객체를 반환
- `with`를 사용하여 length, firstChar, lastChar를 설정

### Task 7: 체이닝
`buildMessage(parts: List<String>)` 함수를 구현하세요.
- StringBuilder를 사용하여 문자열 생성
- 각 part를 추가하고 줄바꿈 추가
- `apply`와 `also`를 체이닝하여 구현

### Task 8: 복합 사용
`processUser(user: User?)` 함수를 구현하세요.
- user가 null이면 "No user" 반환
- user가 있으면 name을 대문자로 변환하고 나이와 함께 포맷
- 결과: "{NAME} is {age} years old"
- scope function을 적절히 조합하세요.

## 데이터 클래스

```kotlin
data class Person(var name: String = "", var age: Int = 0, var city: String = "")

class PersonBuilder {
    var name: String = ""
    var age: Int = 0
    var city: String = ""

    fun build() = Person(name, age, city)
}

data class StringInfo(var length: Int = 0, var firstChar: Char? = null, var lastChar: Char? = null)

data class User(val name: String, val age: Int)
```

## 예상 출력

```
Task 1: Hello, Alice!, Hello, Guest!
Task 2: Number: 42
Task 3: Person(name=Alice, age=25, city=Seoul)
Task 4: HELLO (with logging)
Task 5: 50
Task 6: StringInfo(length=5, firstChar=H, lastChar=o)
Task 7: Line1\nLine2\nLine3\n
Task 8: ALICE is 25 years old, No user
```

## 테스트 실행

```bash
./gradlew test --tests "mission9.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
