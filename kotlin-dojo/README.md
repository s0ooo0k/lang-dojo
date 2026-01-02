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

### ✅ Mission 1: Hello World (현재 미션)
- **위치**: `src/main/kotlin/mission1/`
- **목표**: 함수에서 문자열 반환하기
- **📚 필독**: [학습 자료 (knowledge.md)](docs/mission1/knowledge.md) ← **먼저 읽으세요!**
- **문서**: [Mission 1 가이드](docs/mission1/README.md)

### 🔒 Mission 2: 변수와 데이터 타입
Mission 1 완료 후 사부님께 요청하세요

### 🔒 Mission 3: 함수 기본
Mission 2 완료 후 진행

### 🔒 이후 미션들
순차적으로 잠금 해제됩니다

## 테스트 실행

```bash
# 모든 테스트
./gradlew test

# Mission 1만
./gradlew test --tests "mission1.*"
```

## 학습 자료 및 도움말

### 순서대로 활용하세요:

1. **📚 `docs/mission1/knowledge.md`** - **필수! 미션 시작 전에 반드시 읽기**
   - 개념 설명, 문법, 예제 코드

2. **📋 `docs/mission1/README.md`** - 미션 설명 및 목표

3. **💡 `docs/mission1/Assistance.md`** - 힌트 (정말 막힐 때만!)

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

**첫 번째 단계**: `docs/mission1/knowledge.md` 파일을 열어서 학습 자료를 읽으세요!

**두 번째 단계**: 학습이 끝나면 `src/main/kotlin/mission1/Hello.kt` 파일을 열어 구현하세요!
