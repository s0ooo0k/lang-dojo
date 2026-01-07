package mission12

/**
 * Mission 12: Sealed, Data, Enum Classes
 *
 * Kotlin의 특수 클래스들을 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

// ============ Task 1: 기본 Enum ============

/**
 * Task 1: Direction enum class
 * NORTH, SOUTH, EAST, WEST
 */
enum class Direction {
    // TODO: 방향 상수들을 정의하세요
}

/**
 * Task 1: 반대 방향 반환
 */
fun getOpposite(direction: Direction): Direction {
    TODO("getOpposite 함수를 구현하세요")
}

// ============ Task 2: 프로퍼티가 있는 Enum ============

/**
 * Task 2: Priority enum class
 * LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4)
 */
enum class Priority(val level: Int) {
    // TODO: 우선순위 상수들을 정의하세요
}

/**
 * Task 2: level로 Priority 찾기
 */
fun getPriorityByLevel(level: Int): Priority? {
    TODO("getPriorityByLevel 함수를 구현하세요")
}

// ============ Task 3: 메서드가 있는 Enum ============

/**
 * Task 3: Operation enum class
 * PLUS, MINUS, TIMES, DIVIDE
 * apply(a, b) 메서드로 계산 수행
 */
enum class Operation {
    // TODO: 연산 상수들과 apply 메서드를 정의하세요
    ;

    fun apply(a: Int, b: Int): Int {
        TODO("apply 메서드를 구현하세요")
    }
}

// ============ Task 4 & 5: Data Class ============

/**
 * Task 4: Book data class
 */
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val price: Double
)

/**
 * Task 4: 가격만 변경된 새 Book 반환
 */
fun updateBookPrice(book: Book, newPrice: Double): Book {
    TODO("updateBookPrice 함수를 구현하세요")
}

/**
 * Task 5: 구조 분해를 사용한 포맷팅
 * "{title} by {author}" 형식으로 반환
 */
fun formatBook(book: Book): String {
    TODO("formatBook 함수를 구현하세요")
}

// ============ Task 6: 기본 Sealed Class ============

/**
 * Task 6: Result sealed class
 * - Success(value: Int)
 * - Failure(error: String)
 * - Loading object
 */
sealed class Result {
    // TODO: Success, Failure, Loading을 정의하세요
}

/**
 * Task 6: Result 처리 (else 없이!)
 */
fun handleResult(result: Result): String {
    TODO("handleResult 함수를 구현하세요")
}

// ============ Task 7: Sealed Class with 제네릭 ============

/**
 * Task 7: NetworkResponse sealed class
 * - Success<T>(data: T)
 * - Error(code: Int, message: String)
 * - Loading object
 */
sealed class NetworkResponse<out T> {
    // TODO: Success, Error, Loading을 정의하세요
}

/**
 * Task 7: NetworkResponse 설명
 */
fun describeResponse(response: NetworkResponse<String>): String {
    TODO("describeResponse 함수를 구현하세요")
}

// ============ Task 8: Day Enum ============

/**
 * Task 8: Day enum class
 * MONDAY ~ SUNDAY
 */
enum class Day {
    // TODO: 요일 상수들을 정의하세요
}

/**
 * Task 8: 주말 여부 확인
 */
fun isWeekend(day: Day): Boolean {
    TODO("isWeekend 함수를 구현하세요")
}

/**
 * Task 8: 요일 타입 반환 ("Weekday" 또는 "Weekend")
 */
fun getDayType(day: Day): String {
    TODO("getDayType 함수를 구현하세요")
}
