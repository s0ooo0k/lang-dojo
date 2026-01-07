# Kotlin Dojo - Kotlin 기초 수련장

Kotlin의 기본 개념과 문법을 TDD 방식으로 학습하는 프로젝트입니다.

## 빠른 시작

### 1. 프로젝트 열기

IntelliJ IDEA에서:
1. `File` → `Open`
2. `kotlin-dojo` 폴더 선택
3. `Trust Project` 클릭
4. Gradle 빌드 완료 대기 (우측 하단 진행 상황)

### 2. Mission 1 시작

#### 📚 STEP 0: 학습 자료 읽기 (필수!)
**먼저 이것을 읽으세요**: `docs/mission1/knowledge.md`
- Kotlin 함수 기본 개념
- 문자열 사용법
- return vs println 차이
- 예제 코드와 주의사항

#### 🔴 STEP 1: RED 단계 - 실패 확인
```bash
cd kotlin-dojo
./gradlew test --tests "mission1.*"
```

결과: `NotImplementedError` - 이것이 정상입니다!

#### 🟢 STEP 2: GREEN 단계 - 구현하기
1. `src/main/kotlin/mission1/Hello.kt` 파일 열기
2. `TODO()` 부분을 실제 구현으로 교체
3. 테스트 다시 실행

#### IntelliJ에서 테스트 실행하기
1. `src/test/kotlin/mission1/HelloTest.kt` 열기
2. 클래스 이름 옆 초록색 버튼 클릭 → `Run 'HelloTest'`

## TDD 학습 방식

### 🔴 RED
테스트가 실패합니다 (`TODO()`로 인해 `NotImplementedError` 발생)

### 🟢 GREEN
당신이 직접 코드를 작성하여 테스트를 통과시킵니다

### 🔵 REFACTOR
테스트가 통과한 후 코드를 개선합니다

## 미션 목록

> 공식 Kotlin Tour 기반 커리큘럼 (TDD 방식 실습)

### 초급 (Beginner)

- ✅ **Mission 1: Hello World** - 함수 기본, return
- ✅ **Mission 2: Variables & Basic Types** - val/var, 기본 타입, 문자열 템플릿
- ✅ **Mission 3: Control Flow** - if/when 표현식, for/while 반복문, Range
- ✅ **Mission 4: Functions** - 기본 파라미터, named arguments, vararg
- 📦 **Mission 5: Collections** - List, Set, Map, mutable/immutable
- 📦 **Mission 6: Classes** - class, 생성자, data class, object
- 📦 **Mission 7: Null Safety** - ?, ?., ?:, !!

### 중급 (Intermediate)

- 📦 **Mission 8: Extension Functions** - 확장 함수
- 📦 **Mission 9: Scope Functions** - let, run, with, apply, also
- 📦 **Mission 10: Lambda & Higher-order Functions** - 람다, 고차 함수
- 📦 **Mission 11: Interfaces & Inheritance** - 인터페이스, 상속, override
- 📦 **Mission 12: Sealed/Data/Enum Classes** - 특수 클래스
- 📦 **Mission 13: Properties & Delegation** - 프로퍼티, 위임
- 📦 **Mission 14: Generics** - 제네릭, in/out

### 심화 (Advanced)

- 🔒 **Mission 15: Coroutines 기초** - suspend, launch, async
- 🔒 **Mission 16: Coroutines Context & Dispatcher** - 코루틴 컨텍스트
- 🔒 **Mission 17: Flow** - 비동기 스트림
- 🔒 **Mission 18: Channel & 동시성** - 채널, 동시성 패턴
- 🔒 **Mission 19: DSL** - Kotlin DSL 작성

## 테스트 실행

```bash
# 모든 테스트
./gradlew test

# Mission 1만
./gradlew test --tests "mission1.*"
```

## 학습 자료 및 도움말

### 각 미션 순서대로 활용하세요:

1. **📚 `docs/NN-개념명.md`** - **필수! 미션 시작 전에 반드시 읽기**
2. **📋 `src/main/kotlin/missionN/README.md`** - 미션 설명 및 목표
3. **💡 `src/main/kotlin/missionN/Assistance.md`** - 힌트 (정말 막힐 때만!)
4. **⌨️ IntelliJ 자동완성**: `Ctrl+Space`

## 문제 해결

### Gradle 오류 시
```bash
./gradlew clean
./gradlew build
```

### IntelliJ 인식 안될 때
`File` → `Invalidate Caches` → `Invalidate and Restart`

---

**수련을 시작하세요!** 🥋

1. `docs/` 폴더에서 해당 미션의 학습 자료를 읽으세요
2. `src/main/kotlin/missionN/README.md`에서 미션 목표를 확인하세요
3. `TODO()`를 구현하고 테스트를 통과시키세요!
