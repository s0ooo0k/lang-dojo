package mission13

import kotlin.math.PI
import kotlin.properties.Delegates

/**
 * Mission 13: Properties & Delegation
 *
 * Kotlin의 프로퍼티와 위임을 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

// ============ Task 1: 커스텀 Getter ============

/**
 * Task 1: Circle 클래스
 * - radius: Double
 * - area: Double (계산된 프로퍼티)
 * - diameter: Double (계산된 프로퍼티)
 */
class Circle(val radius: Double) {
    val area: Double
        get() = TODO("area 계산을 구현하세요")

    val diameter: Double
        get() = TODO("diameter 계산을 구현하세요")
}

// ============ Task 2: 커스텀 Setter ============

/**
 * Task 2: Temperature 클래스
 * - celsius: Double (최소값 -273.15 제한)
 * - fahrenheit: Double (계산된 프로퍼티)
 */
class Temperature(initialCelsius: Double) {
    var celsius: Double = initialCelsius
        set(value) {
            TODO("celsius setter를 구현하세요 (최소값 제한)")
        }

    val fahrenheit: Double
        get() = TODO("fahrenheit 계산을 구현하세요")
}

// ============ Task 3: Backing Field ============

/**
 * Task 3: Counter 클래스
 * - count: Int (음수 무시)
 * - increment(): count 증가
 * - reset(): count를 0으로
 */
class Counter {
    var count: Int = 0
        set(value) {
            TODO("count setter를 구현하세요 (음수 무시)")
        }

    fun increment() {
        TODO("increment를 구현하세요")
    }

    fun reset() {
        TODO("reset을 구현하세요")
    }
}

// ============ Task 4: Lazy 초기화 ============

/**
 * Task 4: DataLoader 클래스
 * - data: String (lazy 초기화)
 * - 초기화 시 "Loading data..." 출력 후 "Data loaded" 반환
 */
class DataLoader {
    val data: String by lazy {
        TODO("lazy 초기화를 구현하세요")
    }
}

// ============ Task 5: lateinit ============

/**
 * Task 5: Service 클래스
 * - config: String (lateinit)
 * - initialize(config): config 설정
 * - isConfigured(): 초기화 여부
 * - getConfig(): config 또는 "Not configured"
 */
class Service {
    // TODO: lateinit var config를 선언하세요

    fun initialize(config: String) {
        TODO("initialize를 구현하세요")
    }

    fun isConfigured(): Boolean {
        TODO("isConfigured를 구현하세요")
    }

    fun getConfig(): String {
        TODO("getConfig를 구현하세요")
    }
}

// ============ Task 6: Observable 위임 ============

/**
 * Task 6: User 클래스
 * - name: String (observable, 초기값 "Unknown")
 * - nameChanges: MutableList<String> (변경 기록)
 */
class User {
    val nameChanges = mutableListOf<String>()

    var name: String by Delegates.observable("Unknown") { _, old, new ->
        TODO("값 변경을 nameChanges에 기록하세요")
    }
}

// ============ Task 7: Vetoable 위임 ============

/**
 * Task 7: Account 클래스
 * - balance: Int (vetoable, 초기값 0, 음수 거부)
 */
class Account {
    var balance: Int by Delegates.vetoable(0) { _, _, new ->
        TODO("음수 거부 조건을 구현하세요")
    }
}

// ============ Task 8: Map 위임 ============

/**
 * Task 8: Config 클래스
 * - Map에서 host, port, timeout 위임
 */
class Config(map: Map<String, Any?>) {
    // TODO: val host: String by map
    // TODO: val port: Int by map
    // TODO: val timeout: Int by map
}
