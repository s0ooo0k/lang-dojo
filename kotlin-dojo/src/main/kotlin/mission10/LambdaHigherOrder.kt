package mission10

/**
 * Mission 10: Lambda & Higher-order Functions
 *
 * Kotlin의 람다와 고차 함수를 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

/**
 * Task 1: 기본 람다
 * 주어진 숫자 n을 더하는 람다를 반환합니다.
 */
fun createAdder(n: Int): (Int) -> Int {
    TODO("createAdder 함수를 구현하세요")
}

/**
 * Task 2: 고차 함수 - 함수 파라미터
 * 두 숫자에 operation을 적용한 결과를 반환합니다.
 */
fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    TODO("applyOperation 함수를 구현하세요")
}

/**
 * Task 3: 리스트 변환
 * 리스트의 각 요소에 transform을 적용한 새 리스트를 반환합니다.
 */
fun transformList(list: List<Int>, transform: (Int) -> Int): List<Int> {
    TODO("transformList 함수를 구현하세요")
}

/**
 * Task 4: 리스트 필터링
 * predicate를 만족하는 요소만 포함한 새 리스트를 반환합니다.
 */
fun filterList(list: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    TODO("filterList 함수를 구현하세요")
}

/**
 * Task 5: 리스트 축소 (fold)
 * initial 값부터 시작하여 모든 요소를 더한 결과를 반환합니다.
 */
fun sumWithInitial(list: List<Int>, initial: Int): Int {
    TODO("sumWithInitial 함수를 구현하세요")
}

/**
 * Task 6: 콜백 실행
 * value를 callback에 전달하여 실행합니다.
 */
fun executeWithCallback(value: Int, callback: (Int) -> Unit) {
    TODO("executeWithCallback 함수를 구현하세요")
}

/**
 * Task 7: 조건부 실행
 * condition이 true일 때만 action을 실행합니다.
 */
fun executeIf(condition: Boolean, action: () -> Unit) {
    TODO("executeIf 함수를 구현하세요")
}

/**
 * Task 8: 함수 합성
 * 두 함수를 합성합니다: (x) -> f(g(x))
 */
fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int {
    TODO("compose 함수를 구현하세요")
}

/**
 * Task 9: 체이닝
 * 짝수만 필터링 → 2배로 변환 → 정렬
 */
fun processNumbers(numbers: List<Int>): List<Int> {
    TODO("processNumbers 함수를 구현하세요")
}

/**
 * Task 10: groupBy 사용
 * 단어를 첫 글자로 그룹화합니다.
 */
fun groupByFirstLetter(words: List<String>): Map<Char, List<String>> {
    TODO("groupByFirstLetter 함수를 구현하세요")
}
