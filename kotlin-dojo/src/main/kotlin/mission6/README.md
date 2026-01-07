# Mission 6: Classes (클래스)

## 학습 목표

Kotlin의 클래스, 생성자, data class, object를 이해하고 활용합니다.

## 사전 학습

**필수!** 미션 시작 전에 반드시 읽으세요:
- `docs/06-classes.md`

## 임무

### Task 1: 기본 클래스 만들기
`Person` 클래스를 구현하세요.
- 프로퍼티: `name` (String), `age` (Int)
- 기본 생성자로 두 값을 받습니다.

### Task 2: 메서드 추가
`Person` 클래스에 `introduce()` 메서드를 추가하세요.
- 반환값: "안녕하세요, 저는 {name}이고 {age}살입니다."

### Task 3: Rectangle 클래스
`Rectangle` 클래스를 구현하세요.
- 프로퍼티: `width` (Int), `height` (Int)
- 메서드: `area()` - 넓이 반환 (width * height)
- 메서드: `perimeter()` - 둘레 반환 (2 * (width + height))

### Task 4: Data Class
`Product` data class를 구현하세요.
- 프로퍼티: `id` (Int), `name` (String), `price` (Double)
- data class의 자동 생성 기능을 활용합니다.

### Task 5: Data Class copy
`updatePrice(product: Product, newPrice: Double)` 함수를 구현하세요.
- 기존 Product의 price만 newPrice로 변경한 새 Product를 반환합니다.
- copy() 함수를 활용하세요.

### Task 6: Object (싱글톤)
`Counter` object를 구현하세요.
- 프로퍼티: `count` (Int, 초기값 0)
- 메서드: `increment()` - count를 1 증가시키고 현재 count 반환
- 메서드: `reset()` - count를 0으로 초기화

### Task 7: Companion Object
`IdGenerator` 클래스를 구현하세요.
- companion object 내에:
  - `currentId` (Int, 초기값 0)
  - `generateId()` - currentId를 1 증가시키고 반환
- 클래스의 인스턴스 생성 없이 `IdGenerator.generateId()` 호출 가능해야 함

### Task 8: 계산된 프로퍼티
`Circle` 클래스를 구현하세요.
- 생성자 프로퍼티: `radius` (Double)
- 계산된 프로퍼티: `area` (Double) - PI * radius * radius
- 계산된 프로퍼티: `circumference` (Double) - 2 * PI * radius
- `kotlin.math.PI`를 사용하세요.

## 예상 출력

```
Task 1: Person(Alice, 25)
Task 2: 안녕하세요, 저는 Alice이고 25살입니다.
Task 3: area=50, perimeter=30
Task 4: Product(id=1, name=Laptop, price=999.99)
Task 5: Product(id=1, name=Laptop, price=899.99)
Task 6: 1, 2, 0
Task 7: 1, 2, 3
Task 8: area=78.54, circumference=31.42
```

## 테스트 실행

```bash
./gradlew test --tests "mission6.*"
```

## 힌트가 필요하면?

`Assistance.md` 파일을 참고하세요. 단, 정말 막힐 때만!
