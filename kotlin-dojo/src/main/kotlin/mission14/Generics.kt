package mission14

/**
 * Mission 14: Generics (제네릭)
 *
 * Kotlin의 제네릭을 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

// ============ Task 1: 기본 제네릭 클래스 ============

/**
 * Task 1: Container 클래스
 * - value: T
 * - getValue(): T
 * - map<R>(transform): Container<R>
 */
class Container<T>(val value: T) {
    fun getValue(): T {
        TODO("getValue를 구현하세요")
    }

    fun <R> map(transform: (T) -> R): Container<R> {
        TODO("map을 구현하세요")
    }
}

// ============ Task 2: 제네릭 함수 ============

/**
 * Task 2: 리스트 요소 교환
 */
fun <T> swap(list: MutableList<T>, i: Int, j: Int) {
    TODO("swap 함수를 구현하세요")
}

/**
 * Task 2: 첫 번째 요소 또는 기본값
 */
fun <T> firstOrDefault(list: List<T>, default: T): T {
    TODO("firstOrDefault 함수를 구현하세요")
}

// ============ Task 3: 타입 제약 ============

/**
 * Task 3: Comparable 제약으로 최댓값 찾기
 */
fun <T : Comparable<T>> findMax(list: List<T>): T? {
    TODO("findMax 함수를 구현하세요")
}

/**
 * Task 3: Number 제약으로 합계 계산
 */
fun <T : Number> sumNumbers(list: List<T>): Double {
    TODO("sumNumbers 함수를 구현하세요")
}

// ============ Task 4: 공변성 (out) ============

/**
 * Task 4: ReadOnlyBox (out T)
 * - 값을 읽기만 가능
 */
class ReadOnlyBox<out T>(private val value: T) {
    fun get(): T {
        TODO("get을 구현하세요")
    }
}

/**
 * Task 4: ReadOnlyBox에서 값 복사
 */
fun <T> copyAll(source: ReadOnlyBox<T>): T {
    TODO("copyAll 함수를 구현하세요")
}

// ============ Task 5: 반공변성 (in) ============

/**
 * Task 5: Writer 인터페이스 (in T)
 */
interface Writer<in T> {
    fun write(item: T)
}

/**
 * Task 5: StringWriter 구현
 */
class StringWriter : Writer<String> {
    val written = mutableListOf<String>()

    override fun write(item: String) {
        TODO("write를 구현하세요")
    }
}

// ============ Task 6: 두 타입 파라미터 ============

/**
 * Task 6: Pair 클래스
 */
data class Pair<A, B>(val first: A, val second: B) {
    fun swap(): Pair<B, A> {
        TODO("swap을 구현하세요")
    }
}

/**
 * Task 6: Pair를 List로 변환
 */
fun <A, B> Pair<A, B>.toList(): List<Any?> {
    TODO("toList 확장 함수를 구현하세요")
}

// ============ Task 7: 제네릭 인터페이스 ============

/**
 * Task 7: Repository 인터페이스
 */
interface Repository<T, ID> {
    fun findById(id: ID): T?
    fun save(item: T): ID
    fun deleteById(id: ID): Boolean
}

/**
 * Task 7: InMemoryRepository 구현
 */
class InMemoryRepository<T> : Repository<T, Int> {
    private val items = mutableMapOf<Int, T>()
    private var nextId = 1

    override fun findById(id: Int): T? {
        TODO("findById를 구현하세요")
    }

    override fun save(item: T): Int {
        TODO("save를 구현하세요")
    }

    override fun deleteById(id: Int): Boolean {
        TODO("deleteById를 구현하세요")
    }
}

// ============ Task 8: reified 타입 ============

/**
 * Task 8: 타입으로 필터링
 */
inline fun <reified T> filterByType(list: List<Any>): List<T> {
    TODO("filterByType 함수를 구현하세요")
}

/**
 * Task 8: 타입 확인
 */
inline fun <reified T> isType(value: Any): Boolean {
    TODO("isType 함수를 구현하세요")
}
