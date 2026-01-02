# Coding Dojo

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.10-02303A?logo=gradle&logoColor=white)](https://gradle.org/)
[![JUnit5](https://img.shields.io/badge/JUnit-5.10-25A162?logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

AI 기반 TDD(Test-Driven Development) 프로그래밍 학습 프레임워크입니다.  
사부님과 함께 마스터하세요! 🥷🏼🥷🏼

## Overview

Coding Dojo는 **Claude Code**와 연동하여 동작하는 인터랙티브 학습 환경입니다.    
AI 튜터가 학습자의 수준을 파악하고, 순차적으로 난이도가 증가하는 미션을 제공합니다.

### Core Principles

- **TDD Methodology**: RED → GREEN → REFACTOR 사이클을 통한 실습
- **Self-Discovery Learning**: 정답을 제공하지 않고, 개념 이해를 통한 문제 해결 유도
- **Official Documentation First**: 모든 학습 자료는 공식 문서를 기반으로 작성
- **Progressive Difficulty**: 기초 문법부터 고급 패턴까지 단계적 학습 경로

## Architecture

```
coding-dojo/
├── prompt.md                    # AI Tutor System Prompt
├── README.md
└── {language}-dojo/             # Language-specific training ground
    ├── src/
    │   ├── main/{lang}/
    │   │   └── mission{N}/      # Implementation + Mission docs
    │   │       ├── Code.kt      # TODO placeholders
    │   │       ├── README.md    # Mission specification
    │   │       └── Assistance.md # AI Assistant instructions
    │   └── test/{lang}/
    │       └── mission{N}/      # Pre-written test cases
    ├── docs/
    │   └── NN-concept-name.md   # Learning material (numbered, official docs based)
    └── build.gradle.kts         # Build configuration
```

## Getting Started

### Prerequisites

- JDK 17+
- Gradle 8.x
- [Claude Code CLI](https://claude.ai/claude-code)

### Quick Start

```bash
# 1. Navigate to project
cd study

# 2. Launch Claude Code with system prompt
claude

# 3. Initialize session
@prompt.md 수련을 시작하겠습니다.
```

## TDD Workflow

각 미션은 다음 사이클을 따릅니다:

| Phase | Description | Command |
|-------|-------------|---------|
| **RED** | 실패하는 테스트 확인 | `./gradlew test --tests "mission1.*"` |
| **GREEN** | 테스트를 통과하는 최소 구현 | 코드 작성 후 테스트 재실행 |
| **REFACTOR** | 코드 품질 개선 | 테스트 유지하며 리팩토링 |

## Documentation Structure

| File | Location | Purpose |
|------|----------|---------|
| `NN-concept-name.md` | `docs/` | 개념 및 문법 학습 자료 (미션 시작 전 필수 학습) |
| `README.md` | `src/main/.../missionN/` | 미션 명세 및 예상 출력 |
| `Assistance.md` | `src/main/.../missionN/` | AI Assistant 지시서 (힌트 제공, 정답 미포함) |

> **Note**: 학습 자료(`docs/NN-*.md`)는 공식 문서를 참조하여 작성되며, 미션의 직접적인 정답은 포함하지 않습니다.

## Available Dojos

### Kotlin Dojo
```bash
cd kotlin-dojo
./gradlew test --tests "mission1.*"
```

### Planned Dojos
- `python-dojo/` - Python basics

## Usage Example

```bash
# Step 1: Study the concepts
cat kotlin-dojo/docs/01-function-basics.md

# Step 2: Read mission specification
cat kotlin-dojo/src/main/kotlin/mission1/README.md

# Step 3: Verify RED state
cd kotlin-dojo && ./gradlew test --tests "mission1.*"
# Expected: NotImplementedError

# Step 4: Implement solution
# Edit: src/main/kotlin/mission1/Hello.kt

# Step 5: Verify GREEN state
./gradlew test --tests "mission1.*"
# Expected: BUILD SUCCESSFUL

# Step 6: Report completion to AI Tutor
# In Claude Code: "Mission 1 완료했습니다."
```

## Extending

새로운 언어의 Dojo를 추가하려면 `prompt.md`를 참조하여 AI Tutor에게 요청하세요:

```
@prompt.md Rust 수련장을 생성해주세요.
```

## References

- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Kotlin Playground](https://play.kotlinlang.org/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Test-Driven Development by Example](https://www.amazon.com/Test-Driven-Development-Kent-Beck/dp/0321146530)

## License

- 본 레포지토리는 아래 GitHub 레포지토리의 프롬프트를 참고하여 수정했습니다     
  > Original Repository : https://github.com/tmdgusya/coding-dojo
---

<p align="center">
  <strong>Start your training.</strong><br>
  <code>@prompt.md</code>
</p>
