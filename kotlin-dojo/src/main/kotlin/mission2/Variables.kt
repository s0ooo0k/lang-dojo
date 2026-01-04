package mission2

// ========================================
// Mission 2-1: 내 이름 반환하기
// ========================================

fun getMyName(): String = "sook"
/*
fun getMyName(): String {
    val name = "sook"
    return name
}
*/

// ========================================
// Mission 2-2: 내 나이 반환하기
// ========================================
fun getMyAge(): Int {
    val age = 25
    return age
}

// ========================================
// Mission 2-3: 내 키 반환하기
// ========================================
fun getMyHeight(): Double {
    val height = 175.5
    return height
}

// ========================================
// Mission 2-4: Kotlin이 재미있나요?
// ========================================
fun isKotlinFun(): Boolean {
    val question = true
    return question
}

// ========================================
// Mission 2-5: 자기소개 (문자열 템플릿 $)
// ========================================
fun introduce(name: String): String {
    return "Hello, I'm $name"
}

// ========================================
// Mission 2-6: 두 수 더하기
// ========================================
fun addNumbers(a: Int, b: Int): Int = a + b

// ========================================
// Mission 2-7: 평균 계산하기
// ========================================
fun calculateAverage(a: Int, b: Int): Double {
    val num = 2.0
    return (a + b) / num
}

// ========================================
// Mission 2-8: Int를 Double로 변환
// ========================================
fun intToDouble(number: Int): Double {
    return number.toDouble()
}

// ========================================
// Mission 2-9: 정보 포맷팅 (문자열 템플릿 ${})
// ========================================
fun formatInfo(name: String, age: Int): String{
    return "Name: ${name}, Age: ${age}"
}
/*
fun formatInfo(name: String, age: Int): String {
    return "Name: $name, Age: $age"
}
 */

// ========================================
// Mission 2-10: 다음 해 나이 계산
// ========================================
fun nextYearAge(name: String, age: Int): String{
    return "${name} will be ${age+1} next year"
}
/*
fun nextYearAge(name: String, age: Int): String {
    val nextAge = age + 1
    return "$name will be $nextAge next year"
}
*/
