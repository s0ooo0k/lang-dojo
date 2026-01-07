package mission5

/**
 * Mission 5: Collections (컬렉션)
 *
 * Kotlin의 컬렉션을 학습합니다.
 * 각 TODO()를 실제 구현으로 교체하세요.
 */

/**
 * Task 1: 과일 목록 만들기
 * "Apple", "Banana", "Cherry" 순서로 포함된 List를 반환합니다.
 */
fun createFruitList(): List<String> {
    TODO("과일 목록을 생성하세요")
}

/**
 * Task 2: 리스트 첫 번째와 마지막 요소
 * 리스트의 첫 번째와 마지막 요소를 Pair로 반환합니다.
 */
fun getFirstAndLast(list: List<String>): Pair<String, String> {
    TODO("첫 번째와 마지막 요소를 Pair로 반환하세요")
}

/**
 * Task 3: 중복 제거
 * 리스트에서 중복을 제거한 Set을 반환합니다.
 */
fun removeDuplicates(list: List<Int>): Set<Int> {
    TODO("중복을 제거하세요")
}

/**
 * Task 4: 학생 점수 Map 만들기
 * "Alice" → 95, "Bob" → 87, "Charlie" → 92 를 담은 Map을 반환합니다.
 */
fun createScoreMap(): Map<String, Int> {
    TODO("학생 점수 Map을 생성하세요")
}

/**
 * Task 5: Map에서 점수 조회
 * 해당 이름의 점수를 반환합니다. 이름이 없으면 0을 반환합니다.
 */
fun getScore(scores: Map<String, Int>, name: String): Int {
    TODO("점수를 조회하세요")
}

/**
 * Task 6: MutableList에 요소 추가
 * 리스트에 item을 추가하고, 추가된 리스트의 크기를 반환합니다.
 */
fun addToList(list: MutableList<String>, item: String): Int {
    TODO("요소를 추가하고 크기를 반환하세요")
}

/**
 * Task 7: 숫자 리스트 통계
 * 합계, 평균, 최댓값, 최솟값을 담은 Map을 반환합니다.
 * 키: "sum", "average", "max", "min"
 */
fun getStatistics(numbers: List<Int>): Map<String, Number> {
    TODO("통계를 계산하세요")
}

/**
 * Task 8: 집합 연산
 * 합집합, 교집합, 차집합을 Triple로 반환합니다.
 */
fun setOperations(a: Set<Int>, b: Set<Int>): Triple<Set<Int>, Set<Int>, Set<Int>> {
    TODO("집합 연산을 수행하세요")
}
