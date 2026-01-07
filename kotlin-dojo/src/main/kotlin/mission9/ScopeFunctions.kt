package mission9

/**
 * Mission 9: Scope Functions (스코프 함수)
 *
 * Kotlin의 스코프 함수를 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

// 데이터 클래스 정의
data class Person(var name: String = "", var age: Int = 0, var city: String = "")

class PersonBuilder {
    var name: String = ""
    var age: Int = 0
    var city: String = ""

    fun build() = Person(name, age, city)
}

data class StringInfo(var length: Int = 0, var firstChar: Char? = null, var lastChar: Char? = null)

data class User(val name: String, val age: Int)

class Rectangle(val width: Int, val height: Int) {
    fun area() = width * height
}

/**
 * Task 1: let으로 null 처리
 * name이 null이 아니면 "Hello, {name}!" 반환
 * null이면 "Hello, Guest!" 반환
 */
fun processName(name: String?): String {
    TODO("processName 함수를 구현하세요")
}

/**
 * Task 2: let으로 변환
 * 숫자를 문자열로 변환하고 "Number: " 추가
 */
fun transformNumber(number: Int): String {
    TODO("transformNumber 함수를 구현하세요")
}

/**
 * Task 3: apply로 객체 초기화
 * PersonBuilder를 사용하여 Person 객체 생성
 */
fun createPerson(name: String, age: Int, city: String): Person {
    TODO("createPerson 함수를 구현하세요")
}

/**
 * Task 4: also로 로깅
 * value를 대문자로 변환하고, 변환 전후에 logger 호출
 */
fun processWithLogging(value: String, logger: (String) -> Unit): String {
    TODO("processWithLogging 함수를 구현하세요")
}

/**
 * Task 5: run으로 계산
 * Rectangle 생성 후 넓이 반환
 */
fun calculateArea(width: Int, height: Int): Int {
    TODO("calculateArea 함수를 구현하세요")
}

/**
 * Task 6: with로 문자열 정보
 * 문자열의 length, firstChar, lastChar를 담은 StringInfo 반환
 */
fun getStringInfo(text: String): StringInfo {
    TODO("getStringInfo 함수를 구현하세요")
}

/**
 * Task 7: 체이닝
 * StringBuilder로 각 part를 줄바꿈과 함께 추가
 */
fun buildMessage(parts: List<String>): String {
    TODO("buildMessage 함수를 구현하세요")
}

/**
 * Task 8: 복합 사용
 * user가 null이면 "No user"
 * 아니면 "{NAME} is {age} years old"
 */
fun processUser(user: User?): String {
    TODO("processUser 함수를 구현하세요")
}
