package mission11

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

@DisplayName("Mission 11: Interfaces & Inheritance")
class InterfacesInheritanceTest {

    @Test
    @DisplayName("Task 1: Circle implements Drawable")
    fun mission11_circleDrawable() {
        val circle: Drawable = Circle()
        assertEquals("Drawing Circle", circle.draw())
    }

    @Test
    @DisplayName("Task 2: FriendlyGreeting - greet")
    fun mission11_friendlyGreeting_greet() {
        val greeting = FriendlyGreeting()
        assertEquals("Nice to meet you!", greeting.greet())
    }

    @Test
    @DisplayName("Task 2: FriendlyGreeting - greetWithName")
    fun mission11_friendlyGreeting_greetWithName() {
        val greeting = FriendlyGreeting()
        assertEquals("Hello, Alice! Nice to meet you!", greeting.greetWithName("Alice"))
    }

    @Test
    @DisplayName("Task 3: Vehicle start")
    fun mission11_vehicleStart() {
        val vehicle = Vehicle("Toyota")
        assertEquals("Starting Toyota", vehicle.start())
    }

    @Test
    @DisplayName("Task 3: Car start (override)")
    fun mission11_carStart() {
        val car = Car("Toyota", "Camry")
        assertEquals("Starting Toyota Camry with engine", car.start())
    }

    @Test
    @DisplayName("Task 4: Rectangle area")
    fun mission11_rectangleArea() {
        val rect = Rectangle(10.0, 5.0)
        assertEquals(50.0, rect.area, 0.001)
    }

    @Test
    @DisplayName("Task 4: Rectangle describe")
    fun mission11_rectangleDescribe() {
        val rect = Rectangle(10.0, 5.0)
        assertEquals("Rectangle with area 50.0", rect.describe())
    }

    @Test
    @DisplayName("Task 5: Duck swim")
    fun mission11_duckSwim() {
        val duck = Duck()
        assertEquals("Swimming", duck.swim())
    }

    @Test
    @DisplayName("Task 5: Duck fly")
    fun mission11_duckFly() {
        val duck = Duck()
        assertEquals("Flying", duck.fly())
    }

    @Test
    @DisplayName("Task 6: Dog speak (super call)")
    fun mission11_dogSpeak() {
        val dog = Dog()
        assertEquals("Some sound Woof!", dog.speak())
    }

    @Test
    @DisplayName("Task 6: Animal speak")
    fun mission11_animalSpeak() {
        val animal = Animal()
        assertEquals("Some sound", animal.speak())
    }

    @Test
    @DisplayName("Task 7: Base message")
    fun mission11_baseMessage() {
        val base = Base()
        assertEquals("Base message", base.message)
    }

    @Test
    @DisplayName("Task 7: Derived message (override)")
    fun mission11_derivedMessage() {
        val derived = Derived()
        assertEquals("Derived message", derived.message)
    }

    @Test
    @DisplayName("Task 8: C foo (interface conflict)")
    fun mission11_cFoo() {
        val c = C()
        assertEquals("A and B", c.foo())
    }
}
