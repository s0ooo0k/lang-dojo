package mission8

import kotlin.math.abs

/**
 * Mission 8: Extension Functions (확장 함수)
 *
 * Kotlin의 확장 함수와 확장 프로퍼티를 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

/**
 * Task 1: 문자열 뒤집기 확인
 * 회문(앞뒤가 같은 문자열)인지 확인합니다. 대소문자 구분 없음.
 */
fun String.isPalindrome(): Boolean {
    TODO("isPalindrome 확장 함수를 구현하세요")
}

/**
 * Task 2: 숫자 자릿수
 * 정수의 자릿수를 반환합니다. 음수는 부호 제외.
 */
fun Int.digitCount(): Int {
    TODO("digitCount 확장 함수를 구현하세요")
}

/**
 * Task 3: 리스트 두 번째 요소
 * 두 번째 요소를 반환하거나, 없으면 null 반환.
 */
fun <T> List<T>.secondOrNull(): T? {
    TODO("secondOrNull 확장 함수를 구현하세요")
}

/**
 * Task 4: 문자열 반복
 * 문자열을 n번 반복하고 separator로 연결합니다.
 */
fun String.repeatWithSeparator(n: Int, separator: String): String {
    TODO("repeatWithSeparator 확장 함수를 구현하세요")
}

/**
 * Task 5: Nullable String 처리
 * 문자열을 Int로 변환, null이거나 실패 시 default 반환.
 */
fun String?.toIntOrDefault(default: Int): Int {
    TODO("toIntOrDefault 확장 함수를 구현하세요")
}

/**
 * Task 6: 리스트 요소 개수 세기
 * 조건을 만족하는 요소의 개수를 반환합니다.
 */
fun <T> List<T>.countBy(predicate: (T) -> Boolean): Int {
    TODO("countBy 확장 함수를 구현하세요")
}

/**
 * Task 7: 확장 프로퍼티 - 단어 수
 * 문자열의 단어 수를 반환합니다. 공백으로 구분.
 */
val String.wordCount: Int
    get() = TODO("wordCount 확장 프로퍼티를 구현하세요")

/**
 * Task 8: 확장 프로퍼티 - 짝수 여부
 * 짝수면 true, 홀수면 false.
 */
val Int.isEven: Boolean
    get() = TODO("isEven 확장 프로퍼티를 구현하세요")
