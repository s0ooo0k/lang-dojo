package mission7

/**
 * Mission 7: Null Safety (널 안전성)
 *
 * Kotlin의 Null Safety를 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

// Task 4, 8에서 사용할 데이터 클래스
data class User(val name: String?, val email: String)
data class Address(val city: String?, val zipCode: String)
data class Person(val name: String, val address: Address?)

/**
 * Task 1: Nullable 변수의 길이 구하기
 * text가 null이면 0, 아니면 문자열 길이를 반환
 */
fun getLength(text: String?): Int {
    TODO("getLength 함수를 구현하세요")
}

/**
 * Task 2: 기본값 제공하기
 * value가 null이면 default, 아니면 value를 반환
 */
fun getOrDefault(value: String?, default: String): String {
    TODO("getOrDefault 함수를 구현하세요")
}

/**
 * Task 3: 안전한 대문자 변환
 * text가 null이면 null, 아니면 대문자로 변환하여 반환
 */
fun safeUpperCase(text: String?): String? {
    TODO("safeUpperCase 함수를 구현하세요")
}

/**
 * Task 4: 사용자 이름 가져오기
 * - user가 null이면 "Guest"
 * - user의 name이 null이면 "Anonymous"
 * - 그 외에는 user의 name
 */
fun getUserName(user: User?): String {
    TODO("getUserName 함수를 구현하세요")
}

/**
 * Task 5: 첫 번째 문자 가져오기
 * text가 null이거나 비어있으면 null, 아니면 첫 번째 문자 반환
 */
fun getFirstChar(text: String?): Char? {
    TODO("getFirstChar 함수를 구현하세요")
}

/**
 * Task 6: 리스트에서 null 제거
 * null이 아닌 요소만 포함된 새 리스트 반환
 */
fun filterNulls(list: List<String?>): List<String> {
    TODO("filterNulls 함수를 구현하세요")
}

/**
 * Task 7: 안전한 숫자 파싱
 * text가 null이거나 파싱 실패 시 null, 성공 시 Int 반환
 */
fun parseIntOrNull(text: String?): Int? {
    TODO("parseIntOrNull 함수를 구현하세요")
}

/**
 * Task 8: 체이닝된 Safe Call
 * person, address, city 중 하나라도 null이면 "Unknown" 반환
 */
fun getAddressCity(person: Person?): String {
    TODO("getAddressCity 함수를 구현하세요")
}
