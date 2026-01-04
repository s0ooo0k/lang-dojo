package mission3

// ========================================
// Mission 3-1: 짝수/홀수 판별
// ========================================
fun isEven(n: Int): Boolean {
    return n % 2 == 0
}

// ========================================
// Mission 3-2: 부호 판별
// ========================================
fun getSign(n: Int): String {
    val sign = if (n > 0) {
        "positive"
    } else if (n < 0) {
        "negative"
    } else {
        "zero"
    }
    return sign
}

// ========================================
// Mission 3-3: 성적 등급 (when)
// ========================================
fun getGrade(score: Int): String {
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..<90 -> "B"
        in 70..<80 -> "C"
        in 60..<70 -> "D"
        else -> "F"
    }
    return grade
}

// ========================================
// Mission 3-4: 요일 이름 (when)
fun getDayName(day: Int) = when (day) {
    1 -> "Monday"
    2 -> "Tuesday"
    3 -> "Wednesday"
    4 -> "Thursday"
    5 -> "Friday"
    6 -> "Saturday"
    7 -> "Sunday"
    else -> "Invalid"
}

//fun getDayName(day: Int): String {
//    val name = when (day) {
//        1 -> "Monday"
//        2 -> "Tuesday"
//        3 -> "Wednesday"
//        4 -> "Thursday"
//        5 -> "Friday"
//        6 -> "Saturday"
//        7 -> "Sunday"
//        else -> "Invalid"
//    }
//    return name
//}

// ========================================
// Mission 3-5: 범위 검사
// ========================================
fun isInRange(n: Int, min: Int, max: Int): Boolean {
    return n in min..max
}

// ========================================
// Mission 3-6: 1부터 N까지 합계 (for)
// ========================================
fun sumUpTo(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        sum += i
    }
    return sum
}

// ========================================
// Mission 3-7: 구구단 한 줄 (for)
// ========================================
fun multiplicationTable(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 1..9) {
        result.add(i * n)
    }
    return result
}

// ========================================
// Mission 3-8: 팩토리얼
// ========================================
fun factorial(n: Int): Long {
    var fac = 1L
    for (i in 1..n) {
        fac *= i
    }
    return fac
}

// ========================================
// Mission 3-9: 카운트다운 (downTo)
// ========================================
fun countDown(from: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (i in from downTo 1) {
        result.add(i)
    }
    return result
}

// ========================================
// Mission 3-10: FizzBuzz
// ========================================
fun fizzBuzz(n: Int): String {
    val result = when {
        n % 3 == 0 && n % 5 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> "$n"
    }
    return result
}

/*
fun fizzBuzz(n: Int) = when {
    n % 3 == 0 && n % 5 == 0 -> "FizzBuzz"
    n % 3 == 0 -> "Fizz"
    n % 5 == 0 -> "Buzz"
    else -> "$n"
}

 */