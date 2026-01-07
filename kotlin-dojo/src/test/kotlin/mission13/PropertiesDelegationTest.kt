package mission13

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import kotlin.math.PI

@DisplayName("Mission 13: Properties & Delegation")
class PropertiesDelegationTest {

    @Test
    @DisplayName("Task 1: Circle area")
    fun mission13_circleArea() {
        val circle = Circle(5.0)
        assertEquals(PI * 25.0, circle.area, 0.001)
    }

    @Test
    @DisplayName("Task 1: Circle diameter")
    fun mission13_circleDiameter() {
        val circle = Circle(5.0)
        assertEquals(10.0, circle.diameter, 0.001)
    }

    @Test
    @DisplayName("Task 2: Temperature celsius min limit")
    fun mission13_temperatureCelsiusLimit() {
        val temp = Temperature(0.0)
        temp.celsius = -300.0  // 절대영도 이하
        assertEquals(-273.15, temp.celsius, 0.001)
    }

    @Test
    @DisplayName("Task 2: Temperature fahrenheit")
    fun mission13_temperatureFahrenheit() {
        val temp = Temperature(0.0)
        assertEquals(32.0, temp.fahrenheit, 0.001)

        temp.celsius = 100.0
        assertEquals(212.0, temp.fahrenheit, 0.001)
    }

    @Test
    @DisplayName("Task 3: Counter increment")
    fun mission13_counterIncrement() {
        val counter = Counter()
        counter.increment()
        counter.increment()
        counter.increment()
        assertEquals(3, counter.count)
    }

    @Test
    @DisplayName("Task 3: Counter negative ignored")
    fun mission13_counterNegativeIgnored() {
        val counter = Counter()
        counter.count = 5
        counter.count = -1  // 무시됨
        assertEquals(5, counter.count)
    }

    @Test
    @DisplayName("Task 3: Counter reset")
    fun mission13_counterReset() {
        val counter = Counter()
        counter.count = 10
        counter.reset()
        assertEquals(0, counter.count)
    }

    @Test
    @DisplayName("Task 4: DataLoader lazy")
    fun mission13_dataLoaderLazy() {
        val loader = DataLoader()

        // 첫 접근 전에는 초기화되지 않음
        // 첫 접근
        val data1 = loader.data
        assertEquals("Data loaded", data1)

        // 두 번째 접근 (캐시됨)
        val data2 = loader.data
        assertEquals("Data loaded", data2)
    }

    @Test
    @DisplayName("Task 5: Service not configured")
    fun mission13_serviceNotConfigured() {
        val service = Service()
        assertFalse(service.isConfigured())
        assertEquals("Not configured", service.getConfig())
    }

    @Test
    @DisplayName("Task 5: Service configured")
    fun mission13_serviceConfigured() {
        val service = Service()
        service.initialize("Production")

        assertTrue(service.isConfigured())
        assertEquals("Production", service.getConfig())
    }

    @Test
    @DisplayName("Task 6: User name observable")
    fun mission13_userNameObservable() {
        val user = User()

        user.name = "Alice"
        user.name = "Bob"

        assertEquals(2, user.nameChanges.size)
        assertEquals("Unknown -> Alice", user.nameChanges[0])
        assertEquals("Alice -> Bob", user.nameChanges[1])
    }

    @Test
    @DisplayName("Task 7: Account balance vetoable")
    fun mission13_accountBalanceVetoable() {
        val account = Account()

        account.balance = 100
        assertEquals(100, account.balance)

        account.balance = -50  // 거부됨
        assertEquals(100, account.balance)

        account.balance = 0  // 허용됨
        assertEquals(0, account.balance)
    }

    @Test
    @DisplayName("Task 8: Config from map")
    fun mission13_configFromMap() {
        val map = mapOf(
            "host" to "localhost",
            "port" to 8080,
            "timeout" to 30
        )

        val config = Config(map)

        assertEquals("localhost", config.host)
        assertEquals(8080, config.port)
        assertEquals(30, config.timeout)
    }
}
