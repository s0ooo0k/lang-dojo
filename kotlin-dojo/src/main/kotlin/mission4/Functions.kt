package mission4

// ========================================
// Mission 4-1: 기본 인사 (기본 파라미터)
// ========================================
fun greet(name: String = "World"): String {
    TODO("name에게 인사하는 문자열 반환. 기본값은 'World'")
}

// ========================================
// Mission 4-2: 커피 주문 (여러 기본 파라미터)
// ========================================
fun orderCoffee(
    type: String = "Americano",
    size: String = "Medium",
    shots: Int = 2
): String {
    TODO("'size type with shots shot(s)' 형식으로 반환")
}

// ========================================
// Mission 4-3: 사용자 프로필 (Named Arguments 활용)
// ========================================
fun createProfile(
    name: String,
    age: Int,
    city: String,
    job: String
): String {
    TODO("'name (age) - job in city' 형식으로 반환")
}

// ========================================
// Mission 4-4: 합계 계산 (vararg)
// ========================================
fun sumAll(vararg numbers: Int): Int {
    TODO("모든 숫자의 합 반환")
}

// ========================================
// Mission 4-5: 최댓값 찾기 (vararg)
// ========================================
fun findMax(vararg numbers: Int): Int {
    TODO("가장 큰 숫자 반환. 빈 경우 Int.MIN_VALUE 반환")
}

// ========================================
// Mission 4-6: 문자열 합치기 (vararg + 기본 파라미터)
// ========================================
fun joinStrings(
    vararg strings: String,
    separator: String = ", "
): String {
    TODO("문자열들을 separator로 연결하여 반환")
}

// ========================================
// Mission 4-7: 반복 문자열 (기본 파라미터)
// ========================================
fun repeatString(text: String, times: Int = 1): String {
    TODO("text를 times번 반복한 문자열 반환")
}

// ========================================
// Mission 4-8: 포맷된 가격 (Named Arguments 연습)
// ========================================
fun formatPrice(
    amount: Int,
    currency: String = "USD",
    showSymbol: Boolean = true
): String {
    TODO("showSymbol이 true면 '$amount currency', false면 'amount' 반환")
}

// ========================================
// Mission 4-9: 평균 계산 (vararg)
// ========================================
fun average(vararg numbers: Double): Double {
    TODO("숫자들의 평균 반환. 빈 경우 0.0 반환")
}

// ========================================
// Mission 4-10: 태그 생성기 (vararg + 기본 파라미터)
// ========================================
fun createTag(
    tagName: String,
    vararg attributes: String,
    selfClosing: Boolean = false
): String {
    TODO("HTML 태그 형식 반환. selfClosing이면 <tagName attrs />, 아니면 <tagName attrs></tagName>")
}
